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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.MappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.emf.EMFMappingBridge;
import org.eclipse.emf.diffmerge.bridge.mapping.operations.MappingBridgeOperation;
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
import org.eclipse.rmf.reqif10.EnumValue;
import org.eclipse.rmf.reqif10.SpecElementWithAttributes;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.common.util.ReqIF10XhtmlUtil;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaModule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.FolderQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.ModuleQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.RelationQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.RequierementQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.TypeDefinitionQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.TypeQuery;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.FolderRule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.ModuleRule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.RelationRule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.RequirementRule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.TypeDefinitionRule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules.TypeRule;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner;
import org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;
import org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute;

/**
 * @author Joao Barata
 */
public class ReqIFMapping extends EMFMappingBridge<IEditableModelScope, IEditableModelScope> {

  IContext _context;

  public IContext getContext() {
    return _context;
  }
  
  @Override
  protected MappingBridgeOperation createMappingOperation(IEditableModelScope sourceDataSet, IEditableModelScope targetDataSet, MappingExecution execution) {
    final MappingBridgeOperation operation = new ReqIfMappingBridgeOperation(sourceDataSet, targetDataSet, this, execution);
    return operation;
  }

  public ReqIFMapping(IContext context) {
    _context = context;

    ModuleQuery modules = new ModuleQuery(this);
    FolderQuery folders = new FolderQuery(this);
    RequierementQuery requirements = new RequierementQuery(this);
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

  }

  public void synchronizeAttributes(IMappingExecution ruleEnv, SpecHierarchy hierarchy, SpecElementWithAttributes element) {
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
        ((Attribute) attr).setDefinitionProxy(((AttributeDefinition) def).getReqIFIdentifier());
        
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

  public Map<String, Object> parseStandardReqIFAttributes(AttributeValue value, CapellaModule target) {
    Map<String, Object> createdObjects = new HashMap<String, Object>();
    if (value instanceof AttributeValueXHTML) {
      createdObjects.putAll(parseNonStandardAttributes((AttributeValueXHTML) value, target));
    } else if (value instanceof AttributeValueInteger) {
      createdObjects.putAll(parseNonStandardAttributes((AttributeValueInteger) value, target));
    }
    return createdObjects;
  }

  public Map<String, Object> parseStandardReqIFAttributes(AttributeValue value, Requirement target) {
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
  public IEditableModelScope getTemporaryScope() {
    return RequirementsVPBridge.temporaryScope;
  }
}
