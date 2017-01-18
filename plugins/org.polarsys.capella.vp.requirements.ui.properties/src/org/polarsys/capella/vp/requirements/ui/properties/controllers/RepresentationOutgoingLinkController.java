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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.polarsys.capella.common.mdsofa.common.misc.Couple;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.ui.properties.controllers.AbstractMultipleSemanticFieldController;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 */
public class RepresentationOutgoingLinkController extends AbstractMultipleSemanticFieldController {
  /**
   * Override this to display elements on Browse wizard
   */
  @Override
  protected IBusinessQuery getReadOpenValuesQuery(EObject semanticElement) {
    return BusinessQueriesProvider.getInstance().getContribution(ViewpointPackage.Literals.DREPRESENTATION,
        CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET);
  }

  /**
   * Override this to process returned elements from Browse wizard
   */
  @Override
  public List<EObject> writeOpenValues(EObject semanticElement, EStructuralFeature semanticFeature,
      List<EObject> values) {
    if (semanticElement instanceof DRepresentation) {
      DRepresentation dRepresentation = (DRepresentation) semanticElement;
      for (EObject eObj : values) {
        if (eObj instanceof Requirement) {
          Requirement requirement = (Requirement) eObj;
          Collection<Couple<EObject, EObject>> elts = new ArrayList<Couple<EObject, EObject>>();
          elts.add(new Couple<EObject, EObject>(requirement, null));
          RelationAnnotationHelper.addAllocations(dRepresentation, RelationAnnotationHelper.OutgoingRelationAnnotation,
              elts);
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
    List<EObject> result = new ArrayList<EObject>();
    if (semanticElement instanceof DRepresentation) {
      for (Entry<String, Couple<Requirement, RelationType>> allocation : RelationAnnotationHelper
          .getAllocations((DRepresentation) semanticElement, RelationAnnotationHelper.OutgoingRelationAnnotation)
          .entrySet()) {
        DiagramOutgoingLink tempOutgoingLink = new DiagramOutgoingLink((DRepresentation) semanticElement,
            allocation.getKey());
        tempOutgoingLink.setTarget(allocation.getValue().getKey());
        tempOutgoingLink.setRelationType(allocation.getValue().getValue());

        // Choose the element containing the diagram as the source of the temporary link
        if (semanticElement instanceof DSemanticDecorator
            && ((DSemanticDecorator) semanticElement).getTarget() instanceof CapellaElement)
          tempOutgoingLink.setSource((CapellaElement) ((DSemanticDecorator) semanticElement).getTarget());

        result.add(tempOutgoingLink);
      }
    }
    return result;
  }
}
