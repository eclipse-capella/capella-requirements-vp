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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.MappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.emf.EMFMappingBridge;
import org.eclipse.emf.diffmerge.bridge.mapping.operations.MappingBridgeOperation;
import org.eclipse.emf.diffmerge.bridge.util.structures.ITuple;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.rmf.reqif10.common.util.ReqIF10XhtmlUtil;
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

/**
 * @author Joao Barata
 */
public class ReqIFMapping extends EMFMappingBridge<IEditableModelScope, IEditableModelScope> {

  IContext context;

  Collection<String> reqTypes;

  public ReqIFMapping(IContext context) {
    this.context = context;

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

  /**
   * Create an attribute with the given type and the given value.
   * 
   * if type is EnumerationValueAttribute, we don't set the value as it is done afterwards in synchronizeAttributes()
   */
  public Attribute createAttributeValue(AttributeOwner container, EClass attributeType, Object value) {

    Attribute attribute = (Attribute) RequirementsFactory.eINSTANCE.create(attributeType);
    container.getOwnedAttributes().add(attribute);

    if (attribute instanceof BooleanValueAttribute) {
      attribute.eSet(RequirementsPackage.Literals.BOOLEAN_VALUE_ATTRIBUTE__VALUE, value);

    } else if (attribute instanceof DateValueAttribute) {
      attribute.eSet(RequirementsPackage.Literals.DATE_VALUE_ATTRIBUTE__VALUE, value);

    } else if (attribute instanceof EnumerationValueAttribute) {
      // We don't set enumeration value here. it is done in synchronizeAttributes()
      // attribute.eSet(RequirementsPackage.Literals.ENUMERATION_VALUE_ATTRIBUTE__VALUES, value);

    } else if (attribute instanceof IntegerValueAttribute) {
      attribute.eSet(RequirementsPackage.Literals.INTEGER_VALUE_ATTRIBUTE__VALUE, value);

    } else if (attribute instanceof RealValueAttribute) {
      attribute.eSet(RequirementsPackage.Literals.REAL_VALUE_ATTRIBUTE__VALUE, value);

    } else if (attribute instanceof StringValueAttribute) {
      attribute.eSet(RequirementsPackage.Literals.STRING_VALUE_ATTRIBUTE__VALUE, value);
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
  private Object getAttributeValue(AttributeValue value) {
    if (value instanceof AttributeValueXHTML) {
      return getContent((AttributeValueXHTML) value);
    } else if (value instanceof AttributeValueInteger) {
      AttributeValueInteger attribute = (AttributeValueInteger) value;
      if (attribute.getTheValue() != null) {
        return ((AttributeValueInteger) value).getTheValue();
      }
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
        Object attributeValue = getAttributeValue(value);
        if (value instanceof BigInteger) {
          // An Integer can't be cast to BigInteger, so we can't return an int wrapped into Integer in getAttributeValue
          attributeValue = ((BigInteger) value).intValue();
        }
        if (feature != null) {
          target.eSet(feature, attributeValue);
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

  protected String getContent(AttributeValueXHTML value) {
    String content = "";
    try {
      content = ReqIF10XhtmlUtil.getXhtmlString(((AttributeValueXHTML) value).getTheValue());
      content = content.replaceAll("<[^>]*>", "").replaceAll("\r\n", " ").trim();
      // Decode special characters
      content = URI.decode(content);
      // Unescape HTML special character entities
      content = StringEscapeUtils.unescapeHtml(content);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return content;
  }

  /**
   * @return
   */
  public IEditableModelScope getTemporaryScope() {
    return RequirementsVPBridge.temporaryScope;
  }
}
