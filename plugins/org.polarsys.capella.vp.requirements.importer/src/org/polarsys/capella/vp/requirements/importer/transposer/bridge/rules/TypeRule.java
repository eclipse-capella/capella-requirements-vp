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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution;
import org.eclipse.emf.diffmerge.bridge.util.structures.ITuple;
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
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;
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
      definition.setReqIFLongName(srcDefinition.getLongName());
      definition.setReqIFIdentifier(srcDefinition.getIdentifier());
      type.getOwnedAttributes().add(definition);
      createdElements.put(RequirementEMFSYmbolFunction.getInstance().getEObjectSymbol(srcDefinition), definition);
    }

    type.setReqIFIdentifier(source.getIdentifier());
    type.setReqIFLongName(source.getLongName());

    return new TupleNP<Object>(type, createdElements);
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
