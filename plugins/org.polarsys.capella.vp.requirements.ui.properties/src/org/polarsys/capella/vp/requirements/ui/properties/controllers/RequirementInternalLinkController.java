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
package org.polarsys.capella.vp.requirements.ui.properties.controllers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 */
public class RequirementInternalLinkController extends AbstractAllocationController {

  @Override
  protected IBusinessQuery getReadOpenValuesQuery(EObject semanticElement) {
    return BusinessQueriesProvider.getInstance().getContribution(RequirementsPackage.Literals.REQUIREMENT,
        RequirementsPackage.Literals.INTERNAL_RELATION__TARGET);
  }

  @Override
  public List<EObject> writeOpenValues(EObject semanticElement, EStructuralFeature semanticFeature,
      List<EObject> values) {
    if (semanticElement instanceof Requirement) {
      Requirement sourceRequirement = (Requirement) semanticElement;
      for (EObject eObj : values) {
        if (eObj instanceof Requirement) {
          Requirement targetRequirment = (Requirement) eObj;
          InternalRelation internalLink = RequirementsFactory.eINSTANCE.createInternalRelation();
          internalLink.setSource(sourceRequirement);
          internalLink.setTarget(targetRequirment);
          internalLink.setRelationType(getDefaultType(internalLink));
          sourceRequirement.getOwnedRelations().add(internalLink);
        }
      }
    }
    return null;
  }

  @Override
  public List<EObject> loadValues(EObject semanticElement, EStructuralFeature semanticFeature) {
    return EObjectExt.getReferencers(semanticElement, RequirementsPackage.Literals.INTERNAL_RELATION__SOURCE);
  }
}
