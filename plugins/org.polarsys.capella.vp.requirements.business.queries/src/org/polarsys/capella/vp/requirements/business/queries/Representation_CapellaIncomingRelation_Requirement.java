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
package org.polarsys.capella.vp.requirements.business.queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * @author Joao Barata
 */
public class Representation_CapellaIncomingRelation_Requirement extends Representation_CapellaRelation_Requirement {

  /**
   * @see org.polarsys.capella.core.business.queries.ui.business.queries.IBusinessQuery#getAvailableElements(EObject)
   */
  @Override
	public List<EObject> getAvailableElements(EObject object) {
	  
    EObject element = null;
    if (object instanceof DRepresentationDescriptor) {
      element = ((DRepresentationDescriptor) object).getTarget();
    }
	  
    List<EObject> availableElements = new ArrayList<EObject>();
    
    BlockArchitecture currentBlock = BlockArchitectureExt.getRootBlockArchitecture(element);
    
    for (BlockArchitecture currentAndNextBlock : BlockArchitectureExt.getAllAllocatingArchitectures(currentBlock)) {
      availableElements.addAll(getRequirements(currentAndNextBlock));
    }
    
    availableElements.removeAll(getCurrentElements(element, false));
    availableElements.remove(element);

    return availableElements;
  }
	  
  /**
   * @see org.polarsys.capella.core.business.queries.ui.business.queries.IBusinessQuery#getCurrentElements(EObject, boolean)
   */
  @Override
	public List<EObject> getCurrentElements(EObject element, boolean onlyGenerated) {
    if (element instanceof DRepresentationDescriptor) {
      List<EObject> result = new ArrayList<EObject>();
      for (DAnnotation allocation : RelationAnnotationHelper.getAllocations((DRepresentationDescriptor) element, RelationAnnotationHelper.IncomingRelationAnnotation)) {
        Requirement requirement = RelationAnnotationHelper.getRequirement(allocation);
        if (requirement != null) {
          result.add(requirement);
        }
      }
      return result;
    }
    return Collections.emptyList();
  }

  @Override
	public List<EReference> getEStructuralFeatures() {
    return Collections.singletonList(CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE);
  }
}
