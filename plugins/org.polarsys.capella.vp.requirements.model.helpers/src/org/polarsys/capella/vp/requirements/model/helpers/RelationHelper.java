/*******************************************************************************
 * Copyright (c) 2017, 2018 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.model.helpers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.common.mdsofa.common.misc.Couple;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

public class RelationHelper {
  /**
   * Get a list of (Requirements, RelationType) for Requirements allocating the given Capella element.
   * @param targetCapellaElement
   * @return
   */
  public static List<Couple<Requirement, RelationType>> getIncomingAllocations(CapellaElement targetCapellaElement) {
    List<Couple<Requirement, RelationType>> result = new ArrayList<>();
    List<EObject> referencingEObjects = EObjectExt.getReferencers(targetCapellaElement, CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET);
    for (EObject referencingEObject : referencingEObjects) {
      if (referencingEObject instanceof CapellaIncomingRelation) {
        CapellaIncomingRelation relation = (CapellaIncomingRelation) referencingEObject;
        result.add(new Couple<Requirement, RelationType>(relation.getSource(), relation.getRelationType()));
      }
    }
    return result;
  }
  
  /**
   * Get a list of (Requirements, RelationType) for Requirements allocating the given descriptor.
   * @return
   */
  public static List<Couple<Requirement, RelationType>> getAllocations(DRepresentationDescriptor descriptor, String relationType) {
    List<Couple<Requirement, RelationType>> result = new ArrayList<>();
    for (DAnnotation annotation : RelationAnnotationHelper.getAllocations(descriptor, relationType)) {
      result.add(new Couple<Requirement, RelationType>(RelationAnnotationHelper.getRequirement(annotation), RelationAnnotationHelper.getRelationType(annotation)));
    }
    return result;
  }
  
  /**
   * Get a list of (Requirements, RelationType) for Requirements allocated by the given Capella element.
   * @param sourceCapellaElement
   * @return
   */
  public static List<Couple<Requirement, RelationType>> getOutgoingAllocations(CapellaElement sourceCapellaElement) {
    List<Couple<Requirement, RelationType>> result = new ArrayList<>();
    List<EObject> referencingEObjects = EObjectExt.getReferencers(sourceCapellaElement, CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__SOURCE);
    for (EObject referencingEObject : referencingEObjects) {
      if (referencingEObject instanceof CapellaOutgoingRelation) {
        CapellaOutgoingRelation relation = (CapellaOutgoingRelation) referencingEObject;
        result.add(new Couple<Requirement, RelationType>(relation.getTarget(), relation.getRelationType()));
      }
    }
    return result;
  }
}
