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
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * @author Joao Barata
 */
public class RequirementTypedQuery extends AbstractViewpointQuery {

	/**
	 * @param object: The model element for which the semantic browser extension is generated
	 * @return List of object to display in the parent category
	 */
	public List<Object> computeQuery(Object object) {
		List<Object> result = new ArrayList<Object>();
    RequirementType type = (RequirementType) object;

    for (EObject requirement : EObjectExt.getReferencers(type, RequirementsPackage.Literals.REQUIREMENT__REQUIREMENT_TYPE)) {
      if (requirement != null)
        result.add(requirement);
    }

    return result;
	}
}
