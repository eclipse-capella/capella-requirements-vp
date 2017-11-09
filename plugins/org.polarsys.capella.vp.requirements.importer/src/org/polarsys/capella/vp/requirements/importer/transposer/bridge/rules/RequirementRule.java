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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaModule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMapping;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.TupleNP;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.RequirementQuery;
import org.polarsys.kitalpha.vp.requirements.Requirements.Folder;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;

public class RequirementRule extends AbstractRule<SpecHierarchy, TupleNP<Object>> {

  public RequirementRule(ReqIFMapping mapping, RequirementQuery requirements) {
    super(mapping, requirements, "Requirement");
  }

  public TupleNP<Object> createTarget(SpecHierarchy hierarchy, IQueryExecution queryExecution) {
    Map<String, Object> createdElements = new HashMap<String, Object>();
    Requirement requirement = RequirementsFactory.eINSTANCE.createRequirement();
    createdElements.put(hierarchy.getIdentifier(), requirement);
    SpecObject object = hierarchy.getObject();
    for (AttributeValue value : object.getValues()) {
      createdElements.putAll(getMapping().parseStandardReqIFAttributes(value, requirement));
    }
    requirement.setReqIFIdentifier(object.getIdentifier());
    requirement.setReqIFLongName(requirement.getReqIFChapterName());
    return new TupleNP<Object>(requirement, createdElements);
  }

  public void defineTarget(SpecHierarchy hierarchy, TupleNP<Object> target, IQueryExecution queryEnv,
      IMappingExecution ruleEnv) {
    Object obj = ruleEnv.getOne(hierarchy.eContainer(), EObject.class);
    if (obj instanceof TupleNP<?>) {
      obj = ((TupleNP<?>) obj).getRoot();
    }

    Object type = ruleEnv.getOne(hierarchy.getObject().getType(), RequirementType.class);
    if (type instanceof TupleNP<?>) {
      type = ((TupleNP<?>) type).getRoot();
    }
    if (type instanceof RequirementType) {
      ((Requirement) target.getRoot()).setRequirementType((RequirementType) type);
      ((Requirement) target.getRoot()).setRequirementTypeProxy(((RequirementType) type).getReqIFIdentifier());
    }

    getMapping().synchronizeAttributes(ruleEnv, hierarchy, hierarchy.getObject());

    if (obj instanceof Folder) {
      ((Folder) obj).getOwnedRequirements().add((Requirement) target.getRoot());
    } else if (obj instanceof CapellaModule) {
      ((CapellaModule) obj).getOwnedRequirements().add((Requirement) target.getRoot());
    }
  }

}
