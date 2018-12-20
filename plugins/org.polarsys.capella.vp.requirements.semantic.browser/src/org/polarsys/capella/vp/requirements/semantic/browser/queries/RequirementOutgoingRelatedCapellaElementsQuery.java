/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
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
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * @author Joao Barata
 */
public class RequirementOutgoingRelatedCapellaElementsQuery extends AbstractViewpointQuery {

  /**
   * @param object:
   *          The model element for which the semantic browser extension is generated
   * @return List of object to display in the parent category
   */
  public List<Object> computeQuery(Object object) {
    List<Object> result = new ArrayList<Object>();
    Requirement requirement = (Requirement) object;

    for (EObject eObject : EObjectExt.getReferencers(requirement,
        CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET)) {
      result.add(((CapellaOutgoingRelation) eObject).getSource());
    }
    for (DAnnotation annotation : RelationAnnotationHelper.getOutgoingAnnotations(requirement)) {
      DRepresentationDescriptor descriptor = RelationAnnotationHelper.getDescriptor(annotation);
      if (descriptor != null) {
        result.add(descriptor);
      }
    }
    return result;
  }
}
