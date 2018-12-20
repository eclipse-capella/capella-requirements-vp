/*******************************************************************************
 * Copyright (c) 2017, 2018 THALES GLOBAL SERVICES.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.polarsys.capella.common.mdsofa.common.misc.Couple;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 */
public class RepresentationOutgoingLinkController extends AbstractAllocationController {
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
    if (semanticElement instanceof DRepresentationDescriptor) {
      DRepresentationDescriptor descriptor = (DRepresentationDescriptor) semanticElement;
      for (EObject eObj : values) {
        if (eObj instanceof Requirement) {
          Requirement requirement = (Requirement) eObj;
          Collection<Couple<Requirement, RelationType>> elts = new ArrayList<>();

          DiagramOutgoingLink tempOutgoingLink = createTempOutgoingLink(semanticElement, null, requirement, null);
          elts.add(new Couple<Requirement, RelationType>(requirement, getDefaultType(tempOutgoingLink)));
          RelationAnnotationHelper.addAllocations(descriptor, RelationAnnotationHelper.OutgoingRelationAnnotation,
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
    if (semanticElement instanceof DRepresentationDescriptor) {
      for (DAnnotation allocation : RelationAnnotationHelper.getAllocations((DRepresentationDescriptor) semanticElement,
          RelationAnnotationHelper.OutgoingRelationAnnotation)) {
        DiagramOutgoingLink tempOutgoingLink = createTempOutgoingLink(semanticElement, allocation,
            RelationAnnotationHelper.getRequirement(allocation), RelationAnnotationHelper.getRelationType(allocation));
        result.add(tempOutgoingLink);
      }
    }
    return result;
  }

  protected DiagramOutgoingLink createTempOutgoingLink(EObject descriptor, DAnnotation annotation,
      Requirement requirement, RelationType relationType) {
    DiagramOutgoingLink tempOutgoingLink = new DiagramOutgoingLink((DRepresentationDescriptor) descriptor, annotation);
    tempOutgoingLink.setTarget(requirement);
    tempOutgoingLink.setRelationType(relationType);

    // Choose the element containing the diagram as the source of the temporary link
    if (((DRepresentationDescriptor) descriptor).getTarget() instanceof CapellaElement) {
      tempOutgoingLink.setSource((CapellaElement) ((DRepresentationDescriptor) descriptor).getTarget());
    }
    return tempOutgoingLink;
  }
}
