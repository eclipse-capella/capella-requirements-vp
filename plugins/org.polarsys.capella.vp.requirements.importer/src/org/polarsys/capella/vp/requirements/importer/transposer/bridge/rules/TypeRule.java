/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution;
import org.eclipse.emf.diffmerge.bridge.util.structures.ITuple;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.rmf.reqif10.AttributeDefinitionBoolean;
import org.eclipse.rmf.reqif10.AttributeDefinitionDate;
import org.eclipse.rmf.reqif10.AttributeDefinitionInteger;
import org.eclipse.rmf.reqif10.AttributeDefinitionReal;
import org.eclipse.rmf.reqif10.AttributeDefinitionString;
import org.eclipse.rmf.reqif10.AttributeDefinitionXHTML;
import org.eclipse.rmf.reqif10.AttributeValueBoolean;
import org.eclipse.rmf.reqif10.AttributeValueDate;
import org.eclipse.rmf.reqif10.AttributeValueEnumeration;
import org.eclipse.rmf.reqif10.AttributeValueInteger;
import org.eclipse.rmf.reqif10.AttributeValueReal;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.AttributeValueXHTML;
import org.eclipse.rmf.reqif10.SpecObjectType;
import org.eclipse.rmf.reqif10.SpecRelationType;
import org.eclipse.rmf.reqif10.SpecType;
import org.eclipse.rmf.reqif10.SpecificationType;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMapping;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMappingQueries;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementEMFSYmbolFunction;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.TupleNP;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.TypeQuery;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration;
import org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;
import org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder;

public class TypeRule extends AbstractRule<SpecType, TupleNP<Object>> {

  public TypeRule(ReqIFMapping mapping, TypeQuery provider) {
    super(mapping, provider, "Type");
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
    createdElements.put(RequirementEMFSYmbolFunction.getInstance().getEObjectSymbol(source), type);

    for (org.eclipse.rmf.reqif10.AttributeDefinition srcDefinition : source.getSpecAttributes()) {
      AttributeDefinition definition;
      if (srcDefinition instanceof org.eclipse.rmf.reqif10.AttributeDefinitionEnumeration) {
        definition = RequirementsFactory.eINSTANCE.createAttributeDefinitionEnumeration();
        ((AttributeDefinitionEnumeration) definition)
            .setMultiValued(((org.eclipse.rmf.reqif10.AttributeDefinitionEnumeration) srcDefinition).isMultiValued());
      } else
        definition = RequirementsFactory.eINSTANCE.createAttributeDefinition();
      setDefaultValue(srcDefinition, definition, createdElements);
      definition.setReqIFLongName(srcDefinition.getLongName());
      definition.setReqIFIdentifier(srcDefinition.getIdentifier());
      type.getOwnedAttributes().add(definition);
      createdElements.put(RequirementEMFSYmbolFunction.getInstance().getEObjectSymbol(srcDefinition), definition);
    }

    type.setReqIFIdentifier(source.getIdentifier());
    type.setReqIFLongName(source.getLongName());

    return new TupleNP<Object>(type, createdElements);
  }

  private void setDefaultValue(org.eclipse.rmf.reqif10.AttributeDefinition srcDefinition, 
      AttributeDefinition trgtDefinition, Map<String, Object> createdElements) {
    if (srcDefinition instanceof org.eclipse.rmf.reqif10.AttributeDefinitionEnumeration) {
      handleAttibuteDefEnumeration((org.eclipse.rmf.reqif10.AttributeDefinitionEnumeration)srcDefinition, trgtDefinition, createdElements);
    } else if (srcDefinition instanceof AttributeDefinitionXHTML) {
      handleAttributeDefXHTML((AttributeDefinitionXHTML)srcDefinition, trgtDefinition, createdElements);
    } else if (srcDefinition instanceof AttributeDefinitionBoolean) {
      handleAttributeDefBoolean((AttributeDefinitionBoolean)srcDefinition, trgtDefinition, createdElements);
    } else if(srcDefinition instanceof AttributeDefinitionDate){
      handleAttributeDefDate((AttributeDefinitionDate)srcDefinition, trgtDefinition, createdElements);
    } else if(srcDefinition instanceof AttributeDefinitionInteger){
      handleAttributeDefInteger((AttributeDefinitionInteger)srcDefinition, trgtDefinition, createdElements);
    } else if(srcDefinition instanceof AttributeDefinitionReal){
      handleAttributeDefReal((AttributeDefinitionReal)srcDefinition, trgtDefinition, createdElements);
    } else if(srcDefinition instanceof AttributeDefinitionString){
      handleAttributeDefString((AttributeDefinitionString)srcDefinition, trgtDefinition, createdElements);
    } else {
      throw new UnsupportedOperationException("ReqIF AttributeDefinition of type '" + srcDefinition.eClass().getName() + "' is not supported!");
    }
  }

  private void handleAttibuteDefEnumeration(
      org.eclipse.rmf.reqif10.AttributeDefinitionEnumeration srcAttributeDefEnumeration,
      AttributeDefinition trgtDefinition, Map<String, Object> createdElements) {
    AttributeValueEnumeration defaultValue = srcAttributeDefEnumeration.getDefaultValue();
    if (defaultValue != null) {
      EnumerationValueAttribute valueAttribute = RequirementsFactory.eINSTANCE.createEnumerationValueAttribute();
      // The enumeration values are handled in the ReqIFMapping#synchronizeAttributeDefinitions(IMappingExecution,
      // SpecType)
      trgtDefinition.setDefaultValue(valueAttribute);
      createdElements.put(srcAttributeDefEnumeration.getLongName(), valueAttribute);
    }
  }
  
  private void handleAttributeDefXHTML(org.eclipse.rmf.reqif10.AttributeDefinitionXHTML srcAttributeDefXHTML,
      AttributeDefinition trgtDefinition, Map<String, Object> createdElements) {
    AttributeValueXHTML defaultValue = srcAttributeDefXHTML.getDefaultValue();
    if (defaultValue != null) {
      StringValueAttribute valueAttribute = RequirementsFactory.eINSTANCE.createStringValueAttribute();
      EObject xhtml = defaultValue.getTheValue().getXhtml();
      valueAttribute.setValue(getMixedText((FeatureMap) xhtml.eGet(xhtml.eClass().getEStructuralFeature("mixed"))));
      trgtDefinition.setDefaultValue(valueAttribute);
      createdElements.put(srcAttributeDefXHTML.getLongName(), valueAttribute);
    }
  }

  private void handleAttributeDefBoolean(org.eclipse.rmf.reqif10.AttributeDefinitionBoolean srcAttributeDefBoolean,
      AttributeDefinition trgtDefinition, Map<String, Object> createdElements) {
    AttributeValueBoolean defaultValue = srcAttributeDefBoolean.getDefaultValue();
    if (defaultValue != null) {
      BooleanValueAttribute valueAttribute = RequirementsFactory.eINSTANCE.createBooleanValueAttribute();
      valueAttribute.setValue(defaultValue.isTheValue());
      trgtDefinition.setDefaultValue(valueAttribute);
      createdElements.put(srcAttributeDefBoolean.getLongName(), valueAttribute);
    }
  }

  private void handleAttributeDefDate(org.eclipse.rmf.reqif10.AttributeDefinitionDate srcDefinition,
      AttributeDefinition trgtDefinition, Map<String, Object> createdElements) {
    AttributeValueDate defaultValue = srcDefinition.getDefaultValue();
    if (defaultValue != null) {
      DateValueAttribute valueAttribute = RequirementsFactory.eINSTANCE.createDateValueAttribute();
      valueAttribute.setValue(defaultValue.getTheValue().getTime());
      trgtDefinition.setDefaultValue(valueAttribute);
      createdElements.put(srcDefinition.getLongName(), valueAttribute);
    }
  }

  private void handleAttributeDefInteger(org.eclipse.rmf.reqif10.AttributeDefinitionInteger srcDefinition,
      AttributeDefinition trgtDefinition, Map<String, Object> createdElements) {
    AttributeValueInteger defaultValue = srcDefinition.getDefaultValue();
    if (defaultValue != null) {
      IntegerValueAttribute valueAttribute = RequirementsFactory.eINSTANCE.createIntegerValueAttribute();
      valueAttribute.setValue(defaultValue.getTheValue().intValue());
      trgtDefinition.setDefaultValue(valueAttribute);
      createdElements.put(srcDefinition.getLongName(), valueAttribute);
    }
  }

  private void handleAttributeDefReal(org.eclipse.rmf.reqif10.AttributeDefinitionReal srcDefinition,
      AttributeDefinition trgtDefinition, Map<String, Object> createdElements) {
    AttributeValueReal defaultValue = srcDefinition.getDefaultValue();
    if (defaultValue != null) {
      RealValueAttribute valueAttribute = RequirementsFactory.eINSTANCE.createRealValueAttribute();
      valueAttribute.setValue(defaultValue.getTheValue());
      trgtDefinition.setDefaultValue(valueAttribute);
      createdElements.put(srcDefinition.getLongName(), valueAttribute);
    }
  }

  private void handleAttributeDefString(org.eclipse.rmf.reqif10.AttributeDefinitionString srcDefinition,
      AttributeDefinition trgtDefinition, Map<String, Object> createdElements) {
    AttributeValueString defaultValue = srcDefinition.getDefaultValue();
    if (defaultValue != null) {
      StringValueAttribute valueAttribute = RequirementsFactory.eINSTANCE.createStringValueAttribute();
      valueAttribute.setValue(defaultValue.getTheValue());
      trgtDefinition.setDefaultValue(valueAttribute);
      createdElements.put(srcDefinition.getLongName(), valueAttribute);
    }
  }
  
  private String getMixedText(FeatureMap mixed) {
    Object textObject = mixed.get(org.eclipse.emf.ecore.xml.type.XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text(),
        true);
    if (textObject instanceof FeatureMapUtil.FeatureEList<?>) {
      FeatureMapUtil.FeatureEList<?> featureEList = (FeatureMapUtil.FeatureEList<?>) textObject;
      if (featureEList.size() != 0) {
        Object text = featureEList.get(0);
        if (text instanceof String) {
          return (String) text;
        }
      }
    }
    return "";
  }
  
  public void defineTarget(SpecType spectype, TupleNP<Object> target, IQueryExecution queryEnv,
      IMappingExecution ruleEnv) {
    Object typeInTargetModel = ruleEnv.getOne(spectype, ITuple.class);
    if (typeInTargetModel instanceof TupleNP<?>) {
      typeInTargetModel = ((TupleNP<?>) typeInTargetModel).getRoot();
    }

    getMapping().synchronizeAttributeDefinitions(ruleEnv, spectype);

    if (typeInTargetModel instanceof AbstractType) {
      TypesFolder folder = ReqIFMappingQueries.getTypesFolder(getMapping().getContext(),
          getMapping().getTemporaryScope());
      if (folder != null) {
        folder.getOwnedTypes().add((AbstractType) typeInTargetModel);
      }
    }
  }
}
