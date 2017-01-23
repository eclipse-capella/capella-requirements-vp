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
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsFactory;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 */
public class CapellaElementIncomingLinkController extends AbstractAllocationController {
  /**
   * Override this to display elements on Browse wizard
   */
  @Override
  protected IBusinessQuery getReadOpenValuesQuery(EObject semanticElement) {
    return BusinessQueriesProvider.getInstance().getContribution(CapellacorePackage.Literals.CAPELLA_ELEMENT,
        CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE);
  }

  /**
   * Override this to process returned elements from Browse wizard
   */
  @Override
  public List<EObject> writeOpenValues(EObject semanticElement, EStructuralFeature semanticFeature,
      List<EObject> values) {
    if (semanticElement instanceof CapellaElement) {
      CapellaElement capellaElement = (CapellaElement) semanticElement;
      for (EObject eObj : values) {
        if (eObj instanceof Requirement) {
          Requirement requirement = (Requirement) eObj;
          CapellaIncomingRelation incomingLink = CapellaRequirementsFactory.eINSTANCE.createCapellaIncomingRelation();
          incomingLink.setSource(requirement);
          incomingLink.setTarget(capellaElement);
          incomingLink.setRelationType(getDefaultType(incomingLink));
          requirement.getOwnedRelations().add(incomingLink);
        }
      }
    }
    return null;
  }

  /**
   * Override this to display elements on the table
   */
  @Override
  public List<EObject> loadValues(EObject semanticElement, EStructuralFeature semanticFeature) {
    return EObjectExt.getReferencers(semanticElement,
        CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET);
  }
}
