/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution;
import org.eclipse.emf.diffmerge.bridge.util.structures.ITuple;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecObject;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaModule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMapping;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementEMFSYmbolFunction;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.TupleNP;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.FolderQuery;
import org.polarsys.kitalpha.vp.requirements.Requirements.Folder;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;

public class FolderRule extends AbstractRule<SpecHierarchy, TupleNP<Object>> {

  public FolderRule(ReqIFMapping mapping, FolderQuery folders) {
    super(mapping, folders, "Folder");
  }

  public TupleNP<Object> createTarget(SpecHierarchy hierarchy, IQueryExecution queryExecution) {
    Map<String, Object> createdElements = new HashMap<String, Object>();
    Folder folder = RequirementsFactory.eINSTANCE.createFolder();
    createdElements.put(RequirementEMFSYmbolFunction.getInstance().getEObjectSymbol(hierarchy), folder);
    SpecObject object = hierarchy.getObject();
    for (AttributeValue value : object.getValues()) {
      createdElements.putAll(getMapping().parseStandardReqIFAttributes(value, folder));
    }
    folder.setReqIFLongName(object.getLongName());
    folder.setReqIFIdentifier(object.getIdentifier());
    return new TupleNP<Object>(folder, createdElements);
  }

  public void defineTarget(SpecHierarchy hierarchy, TupleNP<Object> target, IQueryExecution queryEnv,
      IMappingExecution ruleEnv) {
    Object obj = ruleEnv.getOne(hierarchy.eContainer(), ITuple.class);
    if (obj instanceof TupleNP<?>) {
      obj = ((TupleNP<?>) obj).getRoot();
    }

    Object type = ruleEnv.getOne(hierarchy.getObject().getType(), ITuple.class);
    if (type instanceof TupleNP<?>) {
      type = ((TupleNP<?>) type).getRoot();
    }
    if (type instanceof RequirementType) {
      ((Folder) target.getRoot()).setRequirementType((RequirementType) type);
      ((Folder) target.getRoot()).setRequirementTypeProxy(((RequirementType) type).getReqIFIdentifier());
    }

    getMapping().synchronizeAttributes(ruleEnv, hierarchy, hierarchy.getObject());

    if (obj instanceof Folder) {
      ((Folder) obj).getOwnedRequirements().add((Folder) target.getRoot());
    } else if (obj instanceof CapellaModule) {
      ((CapellaModule) obj).getOwnedRequirements().add((Folder) target.getRoot());
    }
  }
}
