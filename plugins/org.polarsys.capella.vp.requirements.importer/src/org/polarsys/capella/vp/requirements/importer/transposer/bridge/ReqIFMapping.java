/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.MappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.emf.EMFMappingBridge;
import org.eclipse.emf.diffmerge.bridge.mapping.operations.MappingBridgeOperation;
import org.eclipse.emf.diffmerge.bridge.util.structures.ITuple;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.rmf.reqif10.AttributeDefinition;
import org.eclipse.rmf.reqif10.AttributeDefinitionBoolean;
import org.eclipse.rmf.reqif10.AttributeDefinitionDate;
import org.eclipse.rmf.reqif10.AttributeDefinitionEnumeration;
import org.eclipse.rmf.reqif10.AttributeDefinitionInteger;
import org.eclipse.rmf.reqif10.AttributeDefinitionReal;
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
import org.eclipse.rmf.reqif10.SpecElementWithAttributes;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecType;
import org.eclipse.rmf.reqif10.XhtmlContent;
import org.eclipse.rmf.reqif10.common.util.ReqIF10XhtmlUtil;
import org.eclipse.rmf.reqif10.xhtml.XhtmlDivType;
import org.polarsys.capella.vp.requirements.importer.extension.AttributesProvider;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.FolderQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.ModuleQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.RelationQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.RequirementQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.TypeDefinitionQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.TypeQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.FolderRule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.ModuleRule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.RelationRule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.RequirementRule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.TypeDefinitionRule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.TypeRule;
import org.polarsys.capella.vp.requirements.model.helpers.TypeHelper;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner;
import org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumValue;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute;
import org.polarsys.kitalpha.vp.requirements.model.helpers.LabelHelper;

/**
 * @author Joao Barata
 */
public class ReqIFMapping extends EMFMappingBridge<IEditableModelScope, IEditableModelScope> {

  IContext context;
  Collection<String> reqTypes;
  ReqIFTextParser textParser;

  public ReqIFMapping(IContext context) {
    this.context = context;
    this.textParser = new ReqIFTextParser(context);
    ModuleQuery modules = new ModuleQuery(this);
    FolderQuery folders = new FolderQuery(this);
    RequirementQuery requirements = new RequirementQuery(this);
    RelationQuery relations = new RelationQuery(this);
    TypeQuery types = new TypeQuery(this);
    TypeDefinitionQuery typeDefinitions = new TypeDefinitionQuery(this);

    // ******** RULES ********
    new ModuleRule(this, modules);
    new FolderRule(this, folders);
    new RequirementRule(this, requirements);
    new RelationRule(this, relations);
    new TypeRule(this, types);
    new TypeDefinitionRule(this, typeDefinitions);

    // Get attribute types to import from preferences
    reqTypes = AttributesProvider.getInstance().getSelectedAttributeTypes();

  }

  public IContext getContext() {
    return context;
  }
  
  public void setTextParser(ReqIFTextParser textParser) {
    this.textParser = textParser;
  }

  @Override
  protected MappingBridgeOperation createMappingOperation(IEditableModelScope sourceDataSet,
      IEditableModelScope targetDataSet, MappingExecution execution) {
    final MappingBridgeOperation operation = new ReqIfMappingBridgeOperation(sourceDataSet, targetDataSet, this,
        execution);
    return operation;
  }

  public void synchronizeAttributeDefinitions(IMappingExecution ruleEnv, SpecType spectype) {
    for (org.eclipse.rmf.reqif10.AttributeDefinition attribute : spectype.getSpecAttributes()) {
      org.eclipse.rmf.reqif10.DatatypeDefinition datatype = null;
      org.eclipse.rmf.reqif10.AttributeDefinition valueDef = null;
      try {
        if (attribute instanceof AttributeDefinitionEnumeration) {
          datatype = ((AttributeDefinitionEnumeration) attribute).getType();
          AttributeValueEnumeration defaultValue = ((AttributeDefinitionEnumeration) attribute).getDefaultValue();
          if (defaultValue != null) {
            valueDef = defaultValue.getDefinition();
          }
        } else if (attribute instanceof AttributeDefinitionBoolean) {
          datatype = ((AttributeDefinitionBoolean) attribute).getType();
          AttributeValueBoolean defaultValue = ((AttributeDefinitionBoolean) attribute).getDefaultValue();
          if (defaultValue != null) {
            valueDef = defaultValue.getDefinition();
          }
        } else if (attribute instanceof AttributeDefinitionDate) {
          datatype = ((AttributeDefinitionDate) attribute).getType();
          AttributeValueDate defaultValue = ((AttributeDefinitionDate) attribute).getDefaultValue();
          if (defaultValue != null) {
            valueDef = defaultValue.getDefinition();
          }
        } else if (attribute instanceof AttributeDefinitionInteger) {
          datatype = ((AttributeDefinitionInteger) attribute).getType();
          AttributeValueInteger defaultValue = ((AttributeDefinitionInteger) attribute).getDefaultValue();
          if (defaultValue != null) {
            valueDef = defaultValue.getDefinition();
          }
        } else if (attribute instanceof AttributeDefinitionReal) {
          datatype = ((AttributeDefinitionReal) attribute).getType();
          AttributeValueReal defaultValue = ((AttributeDefinitionReal) attribute).getDefaultValue();
          if (defaultValue != null) {
            valueDef = defaultValue.getDefinition();
          }
        } else if (attribute instanceof AttributeDefinitionString) {
          datatype = ((AttributeDefinitionString) attribute).getType();
          AttributeValueString defaultValue = ((AttributeDefinitionString) attribute).getDefaultValue();
          if (defaultValue != null) {
            valueDef = defaultValue.getDefinition();
          }
        } else if (attribute instanceof AttributeDefinitionXHTML) {
          datatype = ((AttributeDefinitionXHTML) attribute).getType();
          AttributeValueXHTML defaultValue = ((AttributeDefinitionXHTML) attribute).getDefaultValue();
          if (defaultValue != null) {
            valueDef = defaultValue.getDefinition();
          }
        }
      } catch (Exception e) {
        System.out.println("Can't read type of attribute: " + attribute.getLongName());
      }

      Object attr = ruleEnv.getOne(attribute.eContainer(), ITuple.class);
      if (attr instanceof TupleNP<?>) {
        attr = ((TupleNP<?>) attr).get(attribute.getIdentifier());
      }
      Object def = ruleEnv.getOne(datatype, ITuple.class);
      if (def instanceof TupleNP<?>) {
        def = ((TupleNP<?>) def).get(datatype.getIdentifier());
      }
      if (attr instanceof org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition
          && def instanceof DataTypeDefinition) {
        ((org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition) attr)
            .setDefinitionType((DataTypeDefinition) def);
      }

      if (valueDef != null) {
        Object searchedDefinition = null;
        Object specTypeTuple = ruleEnv.getOne(valueDef.eContainer(), ITuple.class);
        if (specTypeTuple instanceof TupleNP<?>) {
          searchedDefinition = ((TupleNP<?>) specTypeTuple).get(valueDef.getIdentifier());
        }
        // Set the defaultValue.definition
        if (attr instanceof org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition
            && searchedDefinition instanceof org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition) {
          ((org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition) attr).getDefaultValue()
              .setDefinition(
                  (org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition) searchedDefinition);
        }
        // For an AttributeDefinitionEnumeration add the enumeration values
        if (attribute instanceof AttributeDefinitionEnumeration) {
          // Get the tuple related to the DatatypeDefinitionEnumeration
          Object tuple = ruleEnv.getOne(((AttributeDefinitionEnumeration) attribute).getType(), ITuple.class);
          if (tuple instanceof TupleNP<?>) {
            AttributeValueEnumeration defaultValue = ((AttributeDefinitionEnumeration) attribute).getDefaultValue();
            EList<org.eclipse.rmf.reqif10.EnumValue> values = defaultValue.getValues();
            for (org.eclipse.rmf.reqif10.EnumValue value : values) {
              Object x = ((TupleNP<?>) tuple).get(value.getIdentifier());
              if (x instanceof EnumValue)
                ((EnumerationValueAttribute) ((org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition) attr)
                    .getDefaultValue()).getValues().add((EnumValue) x);
            }
          }
        }
      }
    }
  }

  public void synchronizeAttributes(IMappingExecution ruleEnv, SpecHierarchy hierarchy,
      SpecElementWithAttributes element) {
    for (AttributeValue attribute : element.getValues()) {
      org.eclipse.rmf.reqif10.AttributeDefinition definition = getReqIFDefinition(attribute);
      List<org.eclipse.rmf.reqif10.EnumValue> enumValueList = new ArrayList<org.eclipse.rmf.reqif10.EnumValue>();

      if (attribute instanceof AttributeValueEnumeration) {
        for (org.eclipse.rmf.reqif10.EnumValue enumValue : ((AttributeValueEnumeration) attribute).getValues()) {
          enumValueList.add(enumValue);
        }
      }
      Object attr = ruleEnv.getOne(hierarchy != null ? hierarchy : element, ITuple.class);
      if (attr instanceof TupleNP<?>) {
        attr = ((TupleNP<?>) attr).get(RequirementEMFSYmbolFunction.getInstance().getEObjectSymbol(attribute));
      }
      Object def = ruleEnv.getOne(definition.eContainer(), ITuple.class);
      if (def instanceof TupleNP<?>) {
        def = ((TupleNP<?>) def).get(definition.getIdentifier());
      }
      if (attr instanceof Attribute
          && def instanceof org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition) {
        ((Attribute) attr).setDefinition((org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition) def);
        ((Attribute) attr).setDefinitionProxy(
            ((org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition) def).getReqIFIdentifier());
      }
      if (attr instanceof EnumerationValueAttribute) {
        for (org.eclipse.rmf.reqif10.EnumValue enumValue : enumValueList) {
          Object value = ruleEnv.getOne(enumValue.eContainer(), ITuple.class);
          if (value instanceof TupleNP<?>) {
            value = ((TupleNP<?>) value).get(enumValue.getIdentifier());
          }
          if (value instanceof EnumValue) {
            ((EnumerationValueAttribute) attr).getValues().add((EnumValue) value);
          }
        }
      }
    }
  }

  /**
   * From a ReqIf attribute, returns the expected Capella Attribute type
   */
  private EClass getAttributeType(AttributeValue value) {
    if (value instanceof AttributeValueXHTML) {
      return RequirementsPackage.Literals.STRING_VALUE_ATTRIBUTE;
    } else if (value instanceof AttributeValueString) {
      return RequirementsPackage.Literals.STRING_VALUE_ATTRIBUTE;
    } else if (value instanceof AttributeValueInteger) {
      return RequirementsPackage.Literals.INTEGER_VALUE_ATTRIBUTE;
    } else if (value instanceof AttributeValueBoolean) {
      return RequirementsPackage.Literals.BOOLEAN_VALUE_ATTRIBUTE;
    } else if (value instanceof AttributeValueDate) {
      return RequirementsPackage.Literals.DATE_VALUE_ATTRIBUTE;
    } else if (value instanceof AttributeValueReal) {
      return RequirementsPackage.Literals.REAL_VALUE_ATTRIBUTE;
    } else if (value instanceof AttributeValueEnumeration) {
      return RequirementsPackage.Literals.ENUMERATION_VALUE_ATTRIBUTE;
    }
    return null;
  }

  public void setAttribute(EObject target, EStructuralFeature feature, Object value) {
    if (value != null) {
      EClassifier type = feature.getEType();
      try {
        if (type == EcorePackage.Literals.EBIG_INTEGER && !(value instanceof BigInteger)) {
          if (value instanceof Integer) {
            value = BigInteger.valueOf(((Integer) value).longValue());
          } else {
            value = new BigInteger(value.toString());
          }
        } else if (type == EcorePackage.Literals.EBOOLEAN && !(value instanceof Boolean)) {
          value = Boolean.valueOf(value.toString());

        } else if (type == EcorePackage.Literals.EINT && !(value instanceof Integer)) {
          value = Integer.valueOf(value.toString());

        } else if (type == EcorePackage.Literals.EDOUBLE && !(value instanceof Double)) {
          value = Double.valueOf(value.toString());

        } else if (type == EcorePackage.Literals.ESTRING && !(value instanceof String)) {
          value = value.toString();
        }
      } catch (NumberFormatException e) {
        System.out.println("Can't import value: " + value);
      }
    }
    target.eSet(feature, value);

  }

  /**
   * Create an attribute with the given type and the given value.
   * 
   * if type is EnumerationValueAttribute, we don't set the value as it is done afterwards in synchronizeAttributes()
   */
  public Attribute createAttributeValue(AttributeOwner container, EClass attributeType, Object value) {

    Attribute attribute = (Attribute) RequirementsFactory.eINSTANCE.create(attributeType);
    container.getOwnedAttributes().add(attribute);

    if (attribute instanceof BooleanValueAttribute) {
      setAttribute(attribute, RequirementsPackage.Literals.BOOLEAN_VALUE_ATTRIBUTE__VALUE, value);

    } else if (attribute instanceof DateValueAttribute) {
      setAttribute(attribute, RequirementsPackage.Literals.DATE_VALUE_ATTRIBUTE__VALUE, value);

    } else if (attribute instanceof EnumerationValueAttribute) {
      // We don't set enumeration value here. it is done in synchronizeAttributes()
      // attribute.eSet(RequirementsPackage.Literals.ENUMERATION_VALUE_ATTRIBUTE__VALUES, value);

    } else if (attribute instanceof IntegerValueAttribute) {
      setAttribute(attribute, RequirementsPackage.Literals.INTEGER_VALUE_ATTRIBUTE__VALUE, value);

    } else if (attribute instanceof RealValueAttribute) {
      setAttribute(attribute, RequirementsPackage.Literals.REAL_VALUE_ATTRIBUTE__VALUE, value);

    } else if (attribute instanceof StringValueAttribute) {
      setAttribute(attribute, RequirementsPackage.Literals.STRING_VALUE_ATTRIBUTE__VALUE, value);
    }
    return attribute;
  }

  protected AttributeDefinition getReqIFDefinition(AttributeValue value) {
    if (value instanceof AttributeValueXHTML) {
      return ((AttributeValueXHTML) value).getDefinition();

    } else if (value instanceof AttributeValueString) {
      return ((AttributeValueString) value).getDefinition();

    } else if (value instanceof AttributeValueInteger) {
      return ((AttributeValueInteger) value).getDefinition();

    } else if (value instanceof AttributeValueBoolean) {
      return ((AttributeValueBoolean) value).getDefinition();

    } else if (value instanceof AttributeValueDate) {
      return ((AttributeValueDate) value).getDefinition();

    } else if (value instanceof AttributeValueReal) {
      return ((AttributeValueReal) value).getDefinition();

    } else if (value instanceof AttributeValueEnumeration) {
      return ((AttributeValueEnumeration) value).getDefinition();
    }
    return null;
  }

  /**
   * For a given ReqIf attribute, retrieve its value.
   */
  private Object getAttributeValue(AttributeValue value, AttributeOwner owner) {
    if (value instanceof AttributeValueXHTML) {
      return getContent((AttributeValueXHTML) value, owner);
    } else if (value instanceof AttributeValueInteger) {
      return ((AttributeValueInteger) value).getTheValue();
    } else if (value instanceof AttributeValueString) {
      return ((AttributeValueString) value).getTheValue();
    } else if (value instanceof AttributeValueBoolean) {
      return ((AttributeValueBoolean) value).isTheValue();
    } else if (value instanceof AttributeValueDate) {
      AttributeValueDate attribute = (AttributeValueDate) value;
      if (attribute.getTheValue() != null) {
        return ((AttributeValueDate) value).getTheValue().getTime();
      }
    } else if (value instanceof AttributeValueReal) {
      return ((AttributeValueReal) value).getTheValue();
    } else if (value instanceof AttributeValueEnumeration) {
      return ((AttributeValueEnumeration) value).getValues();
    }
    return null;
  }

  public Map<String, Object> parseStandardReqIFAttributes(AttributeValue value, AttributeOwner target) {
    Map<String, Object> createdObjects = new HashMap<String, Object>();
    AttributeDefinition definition = getReqIFDefinition(value);

    if (definition != null) {
      String type = definition.getLongName();
      if (!reqTypes.contains(type)) {
        System.out.println("[" + value.eClass().getName() + "] Not imported: " + type);
      } else {
        EStructuralFeature feature = TypeHelper.getDirectFeature(type, target);
        Object attributeValue = getAttributeValue(value, target);

        if (feature != null) {
          setAttribute(target, feature, attributeValue);
        } else {
          Attribute result = createAttributeValue(target, getAttributeType(value), attributeValue);
          if (result != null) {
            createdObjects.put(RequirementEMFSYmbolFunction.getInstance().getEObjectSymbol(value), result);
          }
        }
      }
    }
    return createdObjects;
  }

  protected String getContent(AttributeValueXHTML value, AttributeOwner owner) {
    String content = "";
    String rootTag = null;
    try {
      XhtmlContent theValue = ((AttributeValueXHTML) value).getTheValue();
      // We've got to store root tag here since ReqIF10XhtmlUtil.getXhtmlString does not include the original root tag of the XHTML element
      rootTag = getRootTag(theValue);
      content = ReqIF10XhtmlUtil.getXhtmlString(theValue);
      if (value.getDefinition().getLongName().equals("ReqIF.Text")) {
        content = textParser.transformToHTML(content, owner, rootTag);
      } else {
        content = transformToText(content, rootTag);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return content;
  }

  /**
   * 
   * @param theValue
   * @return the root tag of the xhtml element inside theValue
   */
  protected String getRootTag(XhtmlContent theValue) {
    // There's currently no better way to retrieve the root tag of a XhtmlContent.
    // div is a commonly used tag in reqif coming from DOORS
    if (theValue.getXhtml() instanceof XhtmlDivType) {
      return "div";
    }
    return null;
  }

  protected String transformToText(String content) {
    return transformToText(content, null);
  }

  protected String transformToText(String content, String rootTag) {
    return LabelHelper.transformHTMLToText(content, rootTag);
  }

  /**
   * @return
   */
  public IEditableModelScope getTemporaryScope() {
    return RequirementsVPBridge.temporaryScope;
  }
}
