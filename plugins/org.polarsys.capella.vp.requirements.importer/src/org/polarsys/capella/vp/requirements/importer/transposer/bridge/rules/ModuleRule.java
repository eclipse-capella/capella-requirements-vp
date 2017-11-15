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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.Specification;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaModule;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsFactory;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMapping;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMappingQueries;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementEMFSYmbolFunction;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.TupleNP;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.query.ModuleQuery;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.ModuleType;

public class ModuleRule extends AbstractRule<Specification, TupleNP<Object>> {

  public ModuleRule(ReqIFMapping mapping, ModuleQuery provider) {
    super(mapping, provider, "Module");
  }

  public TupleNP<Object> createTarget(Specification specification, IQueryExecution queryExecution) {
    Map<String, Object> createdElements = new HashMap<String, Object>();
    CapellaModule module = CapellaRequirementsFactory.eINSTANCE.createCapellaModule();
    createdElements.put(RequirementEMFSYmbolFunction.getInstance().getEObjectSymbol(specification), module);
    for (AttributeValue value : specification.getValues()) {
      createdElements.putAll(getMapping().parseStandardReqIFAttributes(value, module));
    }
    module.setReqIFIdentifier(specification.getIdentifier());
    module.setReqIFLongName(specification.getLongName());
    return new TupleNP<Object>(module, createdElements);
  }

  public void defineTarget(Specification specification, TupleNP<Object> target, IQueryExecution queryEnv,
      IMappingExecution ruleEnv) {
    EObject tgt = ReqIFMappingQueries.getTargetBlockArchitecture(getMapping().getContext(),
        getMapping().getTemporaryScope());
    if (tgt != null) {
      Object type = ruleEnv.getOne(specification.getType(), ITuple.class);
      if (type instanceof TupleNP<?>) {
        type = ((TupleNP<?>) type).getRoot();
      }
      if (type instanceof ModuleType) {
        ((CapellaModule) target.getRoot()).setModuleType((ModuleType) type);
      }

      getMapping().synchronizeAttributes(ruleEnv, null, specification);

      ((ExtensibleElement) tgt).getOwnedExtensions().add((CapellaModule) target.getRoot());
    }
  }
}
