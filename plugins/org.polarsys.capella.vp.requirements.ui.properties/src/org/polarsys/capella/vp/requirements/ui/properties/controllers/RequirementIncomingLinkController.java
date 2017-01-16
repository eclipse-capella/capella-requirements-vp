/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.ui.properties.controllers.AbstractMultipleSemanticFieldController;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsFactory;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 */
public class RequirementIncomingLinkController extends AbstractMultipleSemanticFieldController {
  /**
   * {@inheritDoc}
   */
  @Override
  protected IBusinessQuery getReadOpenValuesQuery(EObject semanticElement) {
    return BusinessQueriesProvider.getInstance().getContribution(RequirementsPackage.Literals.REQUIREMENT,
        CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET);
  }

  @Override
  public List<EObject> writeOpenValues(EObject semanticElement, EStructuralFeature semanticFeature,
      List<EObject> values) {
    if (semanticElement instanceof Requirement) {
      Requirement requirement = (Requirement) semanticElement;
      for (EObject eObj : values) {
        if (eObj instanceof CapellaElement) {
          CapellaElement capellaElement = (CapellaElement) eObj;
          CapellaOutgoingRelation incomingLink = CapellaRequirementsFactory.eINSTANCE.createCapellaOutgoingRelation();
          incomingLink.setSource(capellaElement);
          incomingLink.setTarget(requirement);
          capellaElement.getOwnedExtensions().add(incomingLink);
        }
      }
    }
    return null;
  }

  @Override
  public List<EObject> loadValues(EObject semanticElement, EStructuralFeature semanticFeature) {
    return EObjectExt.getReferencers(semanticElement,
        CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET);
  }
}
