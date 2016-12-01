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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge.query;

import java.util.Collections;

import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryHolder;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.Query;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMappingQueries;

public class RequirementQuery extends Query<IEditableModelScope, SpecHierarchy> {

  public RequirementQuery(IQueryHolder<? extends IEditableModelScope> parent) {
    super(parent);
  }

  public Iterable<SpecHierarchy> evaluate(IEditableModelScope source, IQueryExecution environment) {
    try {
      return ReqIFMappingQueries.getAllRequirements(source);
    } catch (Exception e) {
      return Collections.emptySet();
    }
  }
}
