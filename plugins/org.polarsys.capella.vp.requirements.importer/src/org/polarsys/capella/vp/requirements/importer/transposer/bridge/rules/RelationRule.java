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
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;
import org.eclipse.rmf.reqif10.SpecRelation;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMapping;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMappingQueries;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.TupleNP;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.RelationQuery;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;

public class RelationRule extends AbstractRule<SpecRelation, TupleNP<Object>> {

  public RelationRule(ReqIFMapping mapping, RelationQuery provider) {
    super(mapping, provider, "Relation");
  }

  public TupleNP<Object> createTarget(SpecRelation source, IQueryExecution queryExecution) {
    Map<String, Object> createdElements = new HashMap<String, Object>();

    InternalRelation targetRelation = RequirementsFactory.eINSTANCE.createInternalRelation();
    targetRelation.setReqIFIdentifier(source.getIdentifier());
    targetRelation.setRelationTypeProxy(source.getType().getLongName());

    createdElements.put(source.getIdentifier(), targetRelation);
    return new TupleNP<Object>(targetRelation, createdElements);
  }

  public void defineTarget(SpecRelation specRelation, TupleNP<Object> target, IQueryExecution queryEnv,
      IMappingExecution ruleEnv) {

    SpecObject sourceObject = specRelation.getSource();
    SpecHierarchy sourceHierarchy = ReqIFMappingQueries.getHierarchyFromObject(sourceObject);

    Object relationSourceInTargetModel = ruleEnv.getOne(sourceHierarchy, Requirement.class);
    if (relationSourceInTargetModel instanceof TupleNP<?>) {
      relationSourceInTargetModel = ((TupleNP<?>) relationSourceInTargetModel).getRoot();
    }

    SpecObject targetObject = specRelation.getTarget();
    SpecHierarchy targetHierarchy = ReqIFMappingQueries.getHierarchyFromObject(targetObject);
    Object relationTargetInTargetModel = ruleEnv.getOne(targetHierarchy, Requirement.class);
    if (relationTargetInTargetModel instanceof TupleNP<?>) {
      relationTargetInTargetModel = ((TupleNP<?>) relationTargetInTargetModel).getRoot();
    }

    if (relationSourceInTargetModel != null && relationTargetInTargetModel != null) {
      InternalRelation relation = (InternalRelation) target.getRoot();
      relation.setSource((Requirement) relationSourceInTargetModel);
      relation.setTarget((Requirement) relationTargetInTargetModel);

      Object type = ruleEnv.getOne(specRelation.getType(), RelationType.class);
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
}
