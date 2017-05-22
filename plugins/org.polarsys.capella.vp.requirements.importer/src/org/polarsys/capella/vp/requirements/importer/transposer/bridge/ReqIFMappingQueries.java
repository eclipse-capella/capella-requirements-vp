/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.rmf.reqif10.AttributeDefinition;
import org.eclipse.rmf.reqif10.AttributeDefinitionBoolean;
import org.eclipse.rmf.reqif10.AttributeDefinitionDate;
import org.eclipse.rmf.reqif10.AttributeDefinitionEnumeration;
import org.eclipse.rmf.reqif10.AttributeDefinitionInteger;
import org.eclipse.rmf.reqif10.AttributeDefinitionReal;
import org.eclipse.rmf.reqif10.AttributeDefinitionString;
import org.eclipse.rmf.reqif10.AttributeDefinitionXHTML;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueEnumeration;
import org.eclipse.rmf.reqif10.AttributeValueXHTML;
import org.eclipse.rmf.reqif10.DatatypeDefinition;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;
import org.eclipse.rmf.reqif10.SpecRelation;
import org.eclipse.rmf.reqif10.SpecType;
import org.eclipse.rmf.reqif10.Specification;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsFactory;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaTypesFolder;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesPlugin;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder;

/**
 * @author Joao Barata
 */
public class ReqIFMappingQueries {

  public static BlockArchitecture getTargetBlockArchitecture(IContext context, IEditableModelScope scope) {
    BlockArchitecture srcBlock = (BlockArchitecture) context.get(IRequirementsImporterBridgeConstants.TARGET_ELEMENT);
    BlockArchitecture tgtBlock = null;
    TreeIterator<EObject> it = scope.getAllContents();
    while (it.hasNext()) {
      EObject next = it.next();
      if (next instanceof ModelElement && ((ModelElement) next).getId().equals(srcBlock.getId())) {
        tgtBlock = (BlockArchitecture) next;
        break;
      }
    }
    return tgtBlock;
  }

  public static TypesFolder getTypesFolder(IContext context, IEditableModelScope scope) {
    BlockArchitecture block = getTargetBlockArchitecture(context, scope);
    if (block != null) {
      for (ElementExtension ext : block.getOwnedExtensions()) {
        if (ext instanceof TypesFolder) {
//          String reqIFId = ((TypesFolder) ext).getReqIF_Identifier();
//          if (reqIFId != null && reqIFId.equals(getSourceModelId(context))) {
            return (TypesFolder) ext;
//          }
        }
      }
      // no types folder has been found, we create one
      CapellaTypesFolder folder = CapellaRequirementsFactory.eINSTANCE.createCapellaTypesFolder();
      folder.setReqIFLongName("Types Folder");
      folder.setReqIFIdentifier(getSourceModelId(context));
      block.getOwnedExtensions().add(folder);
      return folder;
    }
    return null;
  }

  private static String getSourceModelId(IContext context) {
    Object src = context.get(IRequirementsImporterBridgeConstants.SOURCE_SCOPE);
    if (src instanceof IModelScope) {
      EObject root = ((IModelScope) src).getContents().get(0);
      if (root instanceof ReqIF) {
        return ((ReqIF) root).getTheHeader().getIdentifier();
      }
    }
    return null;
  }

  public static Collection<Specification> getAllSpecifications(IEditableModelScope scope) {
    List<Specification> specifications = new ArrayList<Specification>();
    for (Specification specification : getReqIFModelRoot(scope).getCoreContent().getSpecifications()) {
      specifications.add(specification);
    }
    return specifications;
  }

  public static Collection<SpecHierarchy> getAllFolders(IEditableModelScope scope) {
    List<SpecHierarchy> hierarchies = new ArrayList<SpecHierarchy>();
    for (EObject hierarchy : EObjectExt.getAll(getReqIFModelRoot(scope), ReqIF10Package.Literals.SPEC_HIERARCHY)) {
      // Some children -> it's a Folder
      if (!((SpecHierarchy) hierarchy).getChildren().isEmpty()) {
        hierarchies.add((SpecHierarchy) hierarchy);
      }
    }
    return hierarchies;
  }

  public static Collection<SpecHierarchy> getAllRequirements(IEditableModelScope scope) {
    List<SpecHierarchy> hierarchies = new ArrayList<SpecHierarchy>();
    for (EObject hierarchy : EObjectExt.getAll(getReqIFModelRoot(scope), ReqIF10Package.Literals.SPEC_HIERARCHY)) {
      // No child -> it's a Requirement
      if (((SpecHierarchy) hierarchy).getChildren().isEmpty()) {
        hierarchies.add((SpecHierarchy) hierarchy);
      }
    }
    return filter(hierarchies);
  }

  public static Collection<SpecRelation> getAllRelations(IEditableModelScope scope) {
    List<SpecRelation> specRelations = new ArrayList<SpecRelation>();
    for (EObject relation : EObjectExt.getAll(getReqIFModelRoot(scope), ReqIF10Package.Literals.SPEC_RELATION)) {
      if (relationCondition(getHierarchyFromObject(((SpecRelation) relation).getSource()))
          && relationCondition(getHierarchyFromObject(((SpecRelation) relation).getTarget()))) {
        specRelations.add((SpecRelation) relation);
      }
    }
    return specRelations;
  }

  public static Collection<SpecType> getAllTypes(IEditableModelScope scope) {
    List<SpecType> types = new ArrayList<SpecType>();
    for (SpecHierarchy folder : getAllFolders(scope)) {
      types.add(folder.getObject().getType());
    }
    for (SpecHierarchy requirement : getAllRequirements(scope)) {
      types.add(requirement.getObject().getType());
    }
    for (SpecRelation relation : getAllRelations(scope)) {
      types.add(relation.getType());
    }
    for (Specification specification : getAllSpecifications(scope)) {
      types.add(specification.getType());
    }
    return types;
  }

  public static Collection<DatatypeDefinition> getAllTypeDefinitions(IEditableModelScope scope) {
    List<DatatypeDefinition> typeDefinitions = new ArrayList<DatatypeDefinition>();
    for (SpecType type : getAllTypes(scope)) {
      for (AttributeDefinition definition : type.getSpecAttributes()) {
        if (definition instanceof AttributeDefinitionEnumeration) {
          DatatypeDefinition def = ((AttributeDefinitionEnumeration) definition).getType();
          if (!typeDefinitions.contains(def)) typeDefinitions.add(def);
        } else if (definition instanceof AttributeDefinitionXHTML) {
          DatatypeDefinition def = ((AttributeDefinitionXHTML) definition).getType();
          if (!typeDefinitions.contains(def)) typeDefinitions.add(def);
        } else if (definition instanceof AttributeDefinitionBoolean) {
          DatatypeDefinition def = ((AttributeDefinitionBoolean) definition).getType();
          if (!typeDefinitions.contains(def)) typeDefinitions.add(def);
        } else if (definition instanceof AttributeDefinitionDate) {
          DatatypeDefinition def = ((AttributeDefinitionDate) definition).getType();
          if (!typeDefinitions.contains(def)) typeDefinitions.add(def);
        } else if (definition instanceof AttributeDefinitionInteger) {
          DatatypeDefinition def = ((AttributeDefinitionInteger) definition).getType();
          if (!typeDefinitions.contains(def)) typeDefinitions.add(def);
        } else if (definition instanceof AttributeDefinitionReal) {
          DatatypeDefinition def = ((AttributeDefinitionReal) definition).getType();
          if (!typeDefinitions.contains(def)) typeDefinitions.add(def);
        } else if (definition instanceof AttributeDefinitionString) {
          DatatypeDefinition def = ((AttributeDefinitionString) definition).getType();
          if (!typeDefinitions.contains(def)) typeDefinitions.add(def);
        }
      }
    }
    return typeDefinitions;
  }

  private static ReqIF getReqIFModelRoot(IEditableModelScope scope) {
    return (ReqIF) scope.getContents().get(0);
  }

  private static Collection<SpecHierarchy> filter(Collection<SpecHierarchy> collection) {
    Iterator<SpecHierarchy> it = collection.iterator();
    while (it.hasNext()) {
      SpecHierarchy object = it.next();
      if (!condition(object))
        it.remove();
    }
    return collection;
  }

  /**
   * Is a Requirement ? Must have a "IE PUID" attribute and a "IE Object Type" with "Requirement" value.
   * 
   * @param object
   * @return
   */
  private static boolean condition(EObject object) {
    if (object instanceof SpecHierarchy) {
      boolean foundIEPUID = false, foundIEObjectType = false;
      SpecObject specObject = ((SpecHierarchy) object).getObject();
      for (AttributeValue attributeValue : specObject.getValues()) {
        if (attributeValue instanceof AttributeValueXHTML) {
          if ("IE PUID".equals(((AttributeValueXHTML) attributeValue).getDefinition().getLongName())) {
            foundIEPUID = true;
          }
        } else if (attributeValue instanceof AttributeValueEnumeration) {
          if ("IE Object Type".equals(((AttributeValueEnumeration) attributeValue).getDefinition().getLongName())) {
            // for (EnumValue ev : ((AttributeValueEnumeration) attributeValue).getValues()) {
            // if ("Requirement".equals(ev.getLongName())) {
            foundIEObjectType = true;
            // }
            // }
          }
        }
      }
      
      Boolean forceDoorsRmfUsage = RequirementsPreferencesPlugin.getDefault().getPreferenceStore()
  	        .getBoolean(RequirementsPreferencesConstants.PREFERENCE_FORCE_DOORS_RMF_USAGE);
      // In case of using Doors with RMF plugin, attribute PE UID is mandatory
      if(forceDoorsRmfUsage) {
    	  return (foundIEPUID && foundIEObjectType);
      }
    }
    return true;
  }

  /**
   * Is a Requirement ? Must have a "IE PUID" attribute and a "IE Object Type" with "Requirement" value.
   * 
   * @param object
   * @return
   */
  private static boolean relationCondition(EObject object) {
    // if (object instanceof SpecHierarchy) {
    // if (((SpecHierarchy) object).getChildren().isEmpty()) {
    return condition(object);
    // }
    // }
    // return true;
  }

  public static SpecHierarchy getHierarchyFromObject(SpecObject object) {
    ReqIF rootEObject = (ReqIF) EcoreUtil.getRootContainer(object);
    for (Setting ref : UsageCrossReferencer.find(object, rootEObject.getCoreContent().getSpecifications())) {
      EObject eObject = ref.getEObject();
      if (eObject instanceof SpecHierarchy) {
        return (SpecHierarchy) eObject;
      }
    }
    return null;
  }

  public static Specification getSpecificationFromType(SpecType type) {
    ReqIF rootEObject = (ReqIF) EcoreUtil.getRootContainer(type);
    for (Specification spec : rootEObject.getCoreContent().getSpecifications()) {
      if (type.equals(spec.getType())) {
        return spec;
      }
    }
    return null;
  }
}
