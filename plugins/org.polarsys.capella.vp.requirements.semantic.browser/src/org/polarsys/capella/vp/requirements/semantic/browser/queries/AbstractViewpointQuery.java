/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.semantic.browser.queries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.capella.vp.requirements.model.helpers.ViewpointHelper;

/**
 * @author Joao Barata
 */
public abstract class AbstractViewpointQuery implements IQuery {

  /**
   * @param object: The model element for which the semantic browser extension is generated
   * @return List of object to display in the parent category
   */
  public List<Object> compute(Object object) {
    List<Object> result = new ArrayList<Object>();

    if (object instanceof EObject && ViewpointHelper.isViewpointActive((EObject) object) && QueriesStateProvider.getInstance().areQueriesEnabled()) {
        result.addAll(computeQuery(object));
    }

    return result;
  }

  public abstract List<Object> computeQuery(Object object);
}
