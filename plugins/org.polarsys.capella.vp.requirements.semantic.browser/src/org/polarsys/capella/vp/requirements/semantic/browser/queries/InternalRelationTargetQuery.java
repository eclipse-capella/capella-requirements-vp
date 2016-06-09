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
package org.polarsys.capella.vp.requirements.semantic.browser.queries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;

/**
 * @author Joao Barata
 */
public class InternalRelationTargetQuery implements IQuery {

	/**
	 * @param object_p: The model element for which the semantic browser extension is generated
	 * @return List of object to display in the parent category
	 */
	public List<Object> compute(Object object_p) {
		List<Object> result = new ArrayList<Object>();
    InternalRelation object = (InternalRelation) object_p;

    EObject target = object.getTarget();
    if (target != null)
      result.add(target);

		return result;
	}
}