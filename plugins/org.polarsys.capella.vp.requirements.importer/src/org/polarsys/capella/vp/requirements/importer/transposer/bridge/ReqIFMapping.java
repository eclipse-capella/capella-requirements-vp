/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.MappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.Query;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.Rule;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.emf.EMFMappingBridge;
import org.eclipse.emf.diffmerge.bridge.mapping.operations.MappingBridgeOperation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rmf.reqif10.AttributeDefinitionEnumeration;
import org.eclipse.rmf.reqif10.AttributeDefinitionInteger;
import org.eclipse.rmf.reqif10.AttributeDefinitionString;
import org.eclipse.rmf.reqif10.AttributeDefinitionXHTML;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueBoolean;
import org.eclipse.rmf.reqif10.AttributeValueDate;
import org.eclipse.rmf.reqif10.AttributeValueEnumeration;
import org.eclipse.rmf.reqif10.AttributeValueInteger;
import org.eclipse.rmf.reqif10.AttributeValueReal;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.AttributeValueXHTML;
import org.eclipse.rmf.reqif10.DatatypeDefinition;
import org.eclipse.rmf.reqif10.EnumValue;
import org.eclipse.rmf.reqif10.SpecElementWithAttributes;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;
import org.eclipse.rmf.reqif10.SpecObjectType;
import org.eclipse.rmf.reqif10.SpecRelation;
import org.eclipse.rmf.reqif10.SpecRelationType;
import org.eclipse.rmf.reqif10.SpecType;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.rmf.reqif10.SpecificationType;
import org.eclipse.rmf.reqif10.common.util.ReqIF10XhtmlUtil;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaModule;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsFactory;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner;
import org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.Folder;
import org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.ModuleType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;
import org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder;

/**
 * @author Joao Barata
 */
public class ReqIFMapping extends EMFMappingBridge<IEditableModelScope, IEditableModelScope> {

  IContext _context;

  @Override
  protected MappingBridgeOperation createMappingOperation(IEditableModelScope sourceDataSet, IEditableModelScope targetDataSet, MappingExecution execution) {
    final MappingBridgeOperation operation = new ReqIfMappingBridgeOperation(sourceDataSet, targetDataSet, this, execution);
    return operation;
  }

  public ReqIFMapping(IContext context) {
    _context = context;

    final Query<IEditableModelScope, Specification> modules = new Query<IEditableModelScope, Specification>(this) {
      public Iterable<Specification> evaluate(IEditableModelScope source, IQueryExecution environment) {
        try {
          return ReqIFMappingQueries.getAllSpecifications(source);
        } catch (Exception e) {
          return Collections.emptySet();
        }
      }
    };

    final Query<IEditableModelScope, SpecHierarchy> folders = new Query<IEditableModelScope, SpecHierarchy>(this) {
      public Iterable<SpecHierarchy> evaluate(IEditableModelScope source, IQueryExecution environment) {
        try {
          return ReqIFMappingQueries.getAllFolders(source);
        } catch (Exception e) {
          return Collections.emptySet();
        }
      }
    };

    final Query<IEditableModelScope, SpecHierarchy> requirements = new Query<IEditableModelScope, SpecHierarchy>(this) {
      public Iterable<SpecHierarchy> evaluate(IEditableModelScope source, IQueryExecution environment) {
        try {
          return ReqIFMappingQueries.getAllRequirements(source);
        } catch (Exception e) {
          return Collections.emptySet();
        }
      }
    };

    final Query<IEditableModelScope, SpecRelation> relations = new Query<IEditableModelScope, SpecRelation>(this) {
      public Iterable<SpecRelation> evaluate(IEditableModelScope source, IQueryExecution environment) {
        try {
          return ReqIFMappingQueries.getAllRelations(source);
        } catch (Exception e) {
          return Collections.emptySet();
        }
      }
    };

    final Query<IEditableModelScope, SpecType> types = new Query<IEditableModelScope, SpecType>(this) {
      public Iterable<SpecType> evaluate(IEditableModelScope source, IQueryExecution environment) {
        try {
          return ReqIFMappingQueries.getAllTypes(source);
        } catch (Exception e) {
          return Collections.emptySet();
        }
      }
    };

    final Query<IEditableModelScope, DatatypeDefinition> typeDefinitions = new Query<IEditableModelScope, DatatypeDefinition>(this) {
      public Iterable<DatatypeDefinition> evaluate(IEditableModelScope source, IQueryExecution environment) {
        try {
          return ReqIFMappingQueries.getAllTypeDefinitions(source);
        } catch (Exception e) {
          return Collections.emptySet();
        }
      }
    };

    // ******** RULES ********

    new Rule<Specification, TupleNP<Object>>(modules, "Module") { //$NON-NLS-1$
      public void defineTarget(Specification specification, TupleNP<Object> target, IQueryExecution queryEnv, IMappingExecution ruleEnv) {
        EObject tgt = ReqIFMappingQueries.getTargetBlockArchitecture(_context, getTemporaryScope());
        if (tgt != null) {
          Object type = ruleEnv.getOne(specification.getType());
          if (type instanceof TupleNP<?>) {
            type = ((TupleNP<?>) type).getRoot();
          }
          if (type instanceof ModuleType) {
            ((CapellaModule) target.getRoot()).setModuleType((ModuleType) type);
          }

          synchronizeAttributes(ruleEnv, null, specification);

          ((ExtensibleElement) tgt).getOwnedExtensions().add((CapellaModule) target.getRoot());
        }
      }

      public TupleNP<Object> createTarget(Specification specification, IQueryExecution queryExecution) {
        Map<String, Object> createdElements = new HashMap<String, Object>();
        CapellaModule module = CapellaRequirementsFactory.eINSTANCE.createCapellaModule();
        createdElements.put(specification.getIdentifier(), module);
        for (AttributeValue value : specification.getValues()) {
          createdElements.putAll(parseStandardReqIFAttributes(value, module));
        }
        module.setId(ReqIFMappingQueries.generateId());
        module.setReqIFIdentifier(specification.getIdentifier());
        module.setReqIFLongName(specification.getLongName());
        return new TupleNP<Object>(module, createdElements);
      }
    };

    new Rule<SpecHierarchy, TupleNP<Object>>(folders, "Folder") { //$NON-NLS-1$
      public void defineTarget(SpecHierarchy hierarchy, TupleNP<Object> target, IQueryExecution queryEnv, IMappingExecution ruleEnv) {
        Object obj = ruleEnv.getOne(hierarchy.eContainer());
        if (obj instanceof TupleNP<?>) {
          obj = ((TupleNP<?>) obj).getRoot();
        }

        Object type = ruleEnv.getOne(hierarchy.getObject().getType());
        if (type instanceof TupleNP<?>) {
          type = ((TupleNP<?>) type).getRoot();
        }
        if (type instanceof RequirementType) {
          ((Folder) target.getRoot()).setRequirementType((RequirementType) type);
        }

        synchronizeAttributes(ruleEnv, hierarchy, hierarchy.getObject());

        if (obj instanceof Folder) {
          ((Folder) obj).getOwnedRequirements().add((Folder) target.getRoot());
        } else if (obj instanceof CapellaModule) {
          ((CapellaModule) obj).getOwnedRequirements().add((Folder) target.getRoot());
        }
      }

      public TupleNP<Object> createTarget(SpecHierarchy hierarchy, IQueryExecution queryExecution) {
        Map<String, Object> createdElements = new HashMap<String, Object>();
        Folder folder = RequirementsFactory.eINSTANCE.createFolder();
        createdElements.put(hierarchy.getIdentifier(), folder);
        SpecObject object = hierarchy.getObject();
        for (AttributeValue value : object.getValues()) {
          createdElements.putAll(parseStandardReqIFAttributes(value, folder));
        }
        folder.setId(ReqIFMappingQueries.generateId());
        folder.setReqIFIdentifier(object.getIdentifier());
        folder.setReqIFLongName(folder.getReqIFChapterName());
        return new TupleNP<Object>(folder, createdElements);
      }
    };

    new Rule<SpecHierarchy, TupleNP<Object>>(requirements, "Requirement") { //$NON-NLS-1$
      public void defineTarget(SpecHierarchy hierarchy, TupleNP<Object> target, IQueryExecution queryEnv, IMappingExecution ruleEnv) {
        Object obj = ruleEnv.getOne(hierarchy.eContainer());
        if (obj instanceof TupleNP<?>) {
          obj = ((TupleNP<?>) obj).getRoot();
        }

        Object type = ruleEnv.getOne(hierarchy.getObject().getType());
        if (type instanceof TupleNP<?>) {
          type = ((TupleNP<?>) type).getRoot();
        }
        if (type instanceof RequirementType) {
          ((Requirement) target.getRoot()).setRequirementType((RequirementType) type);
        }

        synchronizeAttributes(ruleEnv, hierarchy, hierarchy.getObject());

        if (obj instanceof Folder) {
          ((Folder) obj).getOwnedRequirements().add((Requirement) target.getRoot());
        } else if (obj instanceof CapellaModule) {
          ((CapellaModule) obj).getOwnedRequirements().add((Requirement) target.getRoot());
        }
      }

      public TupleNP<Object> createTarget(SpecHierarchy hierarchy, IQueryExecution queryExecution) {
        Map<String, Object> createdElements = new HashMap<String, Object>();
        Requirement requirement = RequirementsFactory.eINSTANCE.createRequirement();
        createdElements.put(hierarchy.getIdentifier(), requirement);
        SpecObject object = hierarchy.getObject();
        for (AttributeValue value : object.getValues()) {
          createdElements.putAll(parseStandardReqIFAttributes(value, requirement));
        }
        requirement.setId(ReqIFMappingQueries.generateId());
        requirement.setReqIFIdentifier(object.getIdentifier());
        requirement.setReqIFLongName(requirement.getReqIFChapterName());
        return new TupleNP<Object>(requirement, createdElements);
      }
    };

    new Rule<SpecRelation, TupleNP<Object>>(relations, "Relation") { //$NON-NLS-1$
      public void defineTarget(SpecRelation specRelation, TupleNP<Object> target, IQueryExecution queryEnv, IMappingExecution ruleEnv) {

        SpecObject sourceObject = specRelation.getSource();
        SpecHierarchy sourceHierarchy = ReqIFMappingQueries.getHierarchyFromObject(sourceObject);

        Object relationSourceInTargetModel = ruleEnv.getOne(sourceHierarchy);
        if (relationSourceInTargetModel instanceof TupleNP<?>) {
          relationSourceInTargetModel = ((TupleNP<?>) relationSourceInTargetModel).getRoot();
        }

        SpecObject targetObject = specRelation.getTarget();
        SpecHierarchy targetHierarchy = ReqIFMappingQueries.getHierarchyFromObject(targetObject);
        Object relationTargetInTargetModel = ruleEnv.getOne(targetHierarchy);
        if (relationTargetInTargetModel instanceof TupleNP<?>) {
          relationTargetInTargetModel = ((TupleNP<?>) relationTargetInTargetModel).getRoot();
        }

        if (relationSourceInTargetModel != null && relationTargetInTargetModel != null) {
          InternalRelation relation = (InternalRelation) target.getRoot();
          relation.setSource((Requirement) relationSourceInTargetModel);
          relation.setTarget((Requirement) relationTargetInTargetModel);

          Object type = ruleEnv.getOne(specRelation.getType());
          if (type instanceof TupleNP<?>) {
            type = ((TupleNP<?>) type).getRoot();
          }
          if (type instanceof RelationType) {
            ((InternalRelation) target.getRoot()).setRelationType((RelationType) type);
          }

          ((Requirement) relationSourceInTargetModel).getOwnedRelations().add(relation);
        } else {
          System.out.println("should not happen !");
        }
      }

      public TupleNP<Object> createTarget(SpecRelation source, IQueryExecution queryExecution) {
        Map<String, Object> createdElements = new HashMap<String, Object>();

        InternalRelation targetRelation = RequirementsFactory.eINSTANCE.createInternalRelation();
        targetRelation.setId(ReqIFMappingQueries.generateId());
        targetRelation.setReqIFIdentifier(source.getIdentifier());
        targetRelation.setRelationTypeProxy(source.getType().getLongName());

        createdElements.put(source.getIdentifier(), targetRelation);
        return new TupleNP<Object>(targetRelation, createdElements);
      }
    };

    new Rule<SpecType, TupleNP<Object>>(types, "Type") { //$NON-NLS-1$
      public void defineTarget(SpecType spectype, TupleNP<Object> target, IQueryExecution queryEnv, IMappingExecution ruleEnv) {
        Object typeInTargetModel = ruleEnv.getOne(spectype);
        if (typeInTargetModel instanceof TupleNP<?>) {
          typeInTargetModel = ((TupleNP<?>) typeInTargetModel).getRoot();
        }
        if (typeInTargetModel instanceof AbstractType) {
          TypesFolder folder = ReqIFMappingQueries.getTypesFolder(_context, getTemporaryScope());
          if (folder != null) {
            folder.getOwnedTypes().add((AbstractType) typeInTargetModel);
          }
        }
      }

      public TupleNP<Object> createTarget(SpecType source, IQueryExecution queryExecution) {
        Map<String, Object> createdElements = new HashMap<String, Object>();

        AbstractType type = null;
        if (source instanceof SpecificationType) {
          type = RequirementsFactory.eINSTANCE.createModuleType();
        } else if (source instanceof SpecRelationType) {
          type = RequirementsFactory.eINSTANCE.createRelationType();
        } else if (source instanceof SpecObjectType) {
          type = RequirementsFactory.eINSTANCE.createRequirementType();
        }
        createdElements.put(source.getIdentifier(), type);

        for (org.eclipse.rmf.reqif10.AttributeDefinition definition : source.getSpecAttributes()) {
          AttributeDefinition attribute = RequirementsFactory.eINSTANCE.createAttributeDefinition();
          attribute.setId(ReqIFMappingQueries.generateId());
          attribute.setReqIFLongName(definition.getLongName());
          attribute.setReqIFIdentifier(definition.getIdentifier());
          type.getOwnedAttributes().add(attribute);
          createdElements.put(definition.getIdentifier(), attribute);
        }

        type.setId(ReqIFMappingQueries.generateId());
        type.setReqIFIdentifier(source.getIdentifier());
        type.setReqIFLongName(source.getLongName());

        return new TupleNP<Object>(type, createdElements);
      }
    };

    new Rule<DatatypeDefinition, TupleNP<Object>>(typeDefinitions, "TypeDefinition") { //$NON-NLS-1$
      public void defineTarget(DatatypeDefinition datatypedefinition, TupleNP<Object> target, IQueryExecution queryEnv, IMappingExecution ruleEnv) {
        Object typeInTargetModel = ruleEnv.getOne(datatypedefinition);
        if (typeInTargetModel instanceof TupleNP<?>) {
          typeInTargetModel = ((TupleNP<?>) typeInTargetModel).getRoot();
        }
        if (typeInTargetModel instanceof DataTypeDefinition) {
          TypesFolder folder = ReqIFMappingQueries.getTypesFolder(_context, getTemporaryScope());
          if (folder != null) {
            folder.getOwnedDefinitionTypes().add((DataTypeDefinition) typeInTargetModel);
          }
        }
      }

      public TupleNP<Object> createTarget(DatatypeDefinition source, IQueryExecution queryExecution) {
        Map<String, Object> createdElements = new HashMap<String, Object>();

        DataTypeDefinition type = RequirementsFactory.eINSTANCE.createDataTypeDefinition();
        createdElements.put(source.getIdentifier(), type);

        type.setId(ReqIFMappingQueries.generateId());
        type.setReqIFIdentifier(source.getIdentifier());
        type.setReqIFLongName(source.getLongName());

        return new TupleNP<Object>(type, createdElements);
      }
    };
  }

  private void synchronizeAttributes(IMappingExecution ruleEnv, SpecHierarchy hierarchy, SpecElementWithAttributes element) {
    for (AttributeValue attribute : element.getValues()) {
      org.eclipse.rmf.reqif10.AttributeDefinition definition = null;
      if (attribute instanceof AttributeValueEnumeration) {
        definition = ((AttributeValueEnumeration) attribute).getDefinition();
      } else if (attribute instanceof AttributeValueBoolean) {
        definition = ((AttributeValueBoolean) attribute).getDefinition();
      } else if (attribute instanceof AttributeValueDate) {
        definition = ((AttributeValueDate) attribute).getDefinition();
      } else if (attribute instanceof AttributeValueInteger) {
        definition = ((AttributeValueInteger) attribute).getDefinition();
      } else if (attribute instanceof AttributeValueReal) {
        definition = ((AttributeValueReal) attribute).getDefinition();
      } else if (attribute instanceof AttributeValueString) {
        definition = ((AttributeValueString) attribute).getDefinition();
      } else if (attribute instanceof AttributeValueXHTML) {
        definition = ((AttributeValueXHTML) attribute).getDefinition();
      }
      Object attr = ruleEnv.getOne(hierarchy != null ? hierarchy : element);
      if (attr instanceof TupleNP<?>) {
        attr = ((TupleNP<?>) attr).get(definition.getLongName());
      }
      Object def = ruleEnv.getOne(definition.eContainer());
      if (def instanceof TupleNP<?>) {
        def = ((TupleNP<?>) def).get(definition.getIdentifier());
      }
      if (attr instanceof Attribute && def instanceof AttributeDefinition) {
        ((Attribute) attr).setDefinition((AttributeDefinition) def);
      }
    }
  }

  /**
   * @deprecated extension point contributions / preferences shall be used
   */
  @Deprecated
  private List<String> importedCustomTypes = Arrays.asList(
    // Doors RMF attributes
    "IE Capability Number",
    "IE DocProperties Author",
    "IE DocProperties Company",
    "IE IVV Method",
    "IE IVV Non Regression",
    "IE IVV Procedure Number",
    "IE IVV Responsible",
    "IE IVV Skills",
    "IE IVV Type",
    "IE Object Type",
    "IE PUID",
    "IE Rationale",
    "IE Release",
    "IE Req Status",
    "IE Requirement Number",
    "IE StyleList",
    "IE Test Method Expected",
    "IE WordExportSettings"
  );

  protected Map<String, Object> parseNonStandardAttributes(AttributeValueXHTML value, AttributeOwner target) {
    Map<String, Object> createdObjects = new HashMap<String, Object>();
    AttributeDefinitionXHTML definition = ((AttributeValueXHTML) value).getDefinition();
    String longName = definition.getLongName();
    if (importedCustomTypes.contains(longName)) {
      StringValueAttribute pv = RequirementsFactory.eINSTANCE.createStringValueAttribute();
      pv.setId(ReqIFMappingQueries.generateId());
      //pv.setKey(longName);
      pv.setValue(getContent((AttributeValueXHTML) value));
      target.getOwnedAttributes().add(pv);
      createdObjects.put(longName, pv);
    } else {
      System.out.println("[XHTML] Not imported: " + longName);
    }
    return createdObjects;
  }

  protected Map<String, Object> parseNonStandardAttributes(AttributeValueString value, AttributeOwner target) {
    Map<String, Object> createdObjects = new HashMap<String, Object>();
    AttributeDefinitionString definition = ((AttributeValueString) value).getDefinition();
    String longName = definition.getLongName();
    if (importedCustomTypes.contains(longName)) {
      StringValueAttribute pv = RequirementsFactory.eINSTANCE.createStringValueAttribute();
      pv.setId(ReqIFMappingQueries.generateId());
      //pv.setKey(longName);
      pv.setValue(value.getTheValue());
      target.getOwnedAttributes().add(pv);
      createdObjects.put(longName, pv);
    } else {
      System.out.println("[String] Not imported: " + longName);
    }
    return createdObjects;
  }

  protected Map<String, Object> parseNonStandardAttributes(AttributeValueInteger value, AttributeOwner target) {
    Map<String, Object> createdObjects = new HashMap<String, Object>();
    AttributeDefinitionInteger definition = ((AttributeValueInteger) value).getDefinition();
    String longName = definition.getLongName();
    if (importedCustomTypes.contains(longName)) {
      IntegerValueAttribute pv = RequirementsFactory.eINSTANCE.createIntegerValueAttribute();
      pv.setId(ReqIFMappingQueries.generateId());
      //pv.setKey(longName);
      pv.setValue(value.getTheValue().intValue());
      target.getOwnedAttributes().add(pv);
      createdObjects.put(longName, pv);
    } else {
      System.out.println("[Integer] Not imported: " + longName);
    }
    return createdObjects;
  }

  protected Map<String, Object> parseNonStandardAttributes(AttributeValueEnumeration value, Requirement target) {
    Map<String, Object> createdObjects = new HashMap<String, Object>();
    AttributeDefinitionEnumeration definition = ((AttributeValueEnumeration) value).getDefinition();
    String longName = definition.getLongName();
    if (importedCustomTypes.contains(longName)) {
      StringValueAttribute pv = RequirementsFactory.eINSTANCE.createStringValueAttribute();
      pv.setId(ReqIFMappingQueries.generateId());
      //pv.setKey(longName);
      StringBuilder evs = new StringBuilder();
      for (EnumValue ev : value.getValues()) {
        evs.append(" " + ev.getLongName());
      }
      pv.setValue(evs.toString().trim());
      target.getOwnedAttributes().add(pv);
      createdObjects.put(longName, pv);
    } else {
      System.out.println("[Enum] Not imported: " + longName);
    }
    return createdObjects;
  }

  protected Map<String, Object> parseStandardReqIFAttributes(AttributeValue value, CapellaModule target) {
    Map<String, Object> createdObjects = new HashMap<String, Object>();
    if (value instanceof AttributeValueXHTML) {
      createdObjects.putAll(parseNonStandardAttributes((AttributeValueXHTML) value, target));
    } else if (value instanceof AttributeValueInteger) {
      createdObjects.putAll(parseNonStandardAttributes((AttributeValueInteger) value, target));
    }
    return createdObjects;
  }

  protected Map<String, Object> parseStandardReqIFAttributes(AttributeValue value, Requirement target) {
    Map<String, Object> createdObjects = new HashMap<String, Object>();
    if (value instanceof AttributeValueXHTML) {
      AttributeDefinitionXHTML definition = ((AttributeValueXHTML) value).getDefinition();
      if (definition.getLongName().equals("ReqIF.ChapterName")) {
        target.setReqIFChapterName(getContent((AttributeValueXHTML) value));
      } else if (definition.getLongName().equals("ReqIF.Name")) {
        //
      } else if (definition.getLongName().equals("ReqIF.Description")) {
        //
      } else if (definition.getLongName().equals("ReqIF.Text")) {
        target.setReqIFText(getContent((AttributeValueXHTML) value));
      } else if (definition.getLongName().equals("ReqIF.Prefix")) {
        target.setReqIFPrefix(getContent((AttributeValueXHTML) value));
      } else if (definition.getLongName().equals("ReqIF.ForeignCreatedBy")) {
        //
      } else if (definition.getLongName().equals("ReqIF.ForeignModifiedBy")) {
        //
      } else if (definition.getLongName().equals("Comment")) {
        //
      } else if (definition.getLongName().equals("Paragraph Style")) {
        //
      } else {
        createdObjects.putAll(parseNonStandardAttributes((AttributeValueXHTML) value, target));
      }
    } else if (value instanceof AttributeValueInteger) {
      AttributeDefinitionInteger definition = ((AttributeValueInteger) value).getDefinition();
      if (definition.getLongName().equals("ReqIF.ForeignID")) {
        target.setReqIFForeignID(((AttributeValueInteger) value).getTheValue().toString()); // FIXME should be EInteger in m2
      } else {
        createdObjects.putAll(parseNonStandardAttributes((AttributeValueInteger) value, target));
      }
    } else if (value instanceof AttributeValueString) {
      createdObjects.putAll(parseNonStandardAttributes((AttributeValueString) value, target));
    } else if (value instanceof AttributeValueEnumeration) {
      AttributeDefinitionEnumeration definition = ((AttributeValueEnumeration) value).getDefinition();
      if (definition.getLongName().equals("ReqIF.ForeignCreatedThru")) {
        //
      } else if (definition.getLongName().equals("TableType")) {
	    //
	  } else {
        createdObjects.putAll(parseNonStandardAttributes((AttributeValueEnumeration) value, target));
      }
    }
    return createdObjects;
  }

  protected String getContent(AttributeValueXHTML value) {
    String content = "";
    try {
      content = ReqIF10XhtmlUtil.getXhtmlString(((AttributeValueXHTML) value).getTheValue());
      content = content.replaceAll("<[^>]*>", "").replaceAll("\r\n", " ").trim();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return content;
  }

  /**
   * @return
   */
  protected IEditableModelScope getTemporaryScope() {
    return RequirementsVPBridge.temporaryScope;
  }
}
