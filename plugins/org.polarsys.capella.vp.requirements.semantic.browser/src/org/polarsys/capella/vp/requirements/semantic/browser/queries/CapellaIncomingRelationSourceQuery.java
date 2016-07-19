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
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;

/**
 * @author Joao Barata
 */
public class CapellaIncomingRelationSourceQuery implements IQuery {

	/**
	 * @param object: The model element for which the semantic browser extension is generated
	 * @return List of object to display in the parent category
	 */
	public List<Object> compute(Object object) {
		List<Object> result = new ArrayList<Object>();
		CapellaIncomingRelation relation = (CapellaIncomingRelation) object;

		EObject source = relation.getSource();
		if (source != null)
			result.add(source);

		return result;
	}
}
