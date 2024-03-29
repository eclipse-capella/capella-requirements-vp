/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
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
import org.polarsys.capella.common.data.modellingcore.AbstractType;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.utils.ListExt;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * @author Joao Barata
 */
public class CapellaElement_CapellaOutgoingRelation_Requirement extends CapellaElement_CapellaRelation_Requirement {

  /**
   * @see org.polarsys.capella.core.business.queries.ui.business.queries.IBusinessQuery#getAvailableElements(EObject)
   */
  @Override
	public List<EObject> getAvailableElements(EObject element) {
    List<EObject> availableElements = new ArrayList<EObject>();
    
    BlockArchitecture currentBlock = BlockArchitectureExt.getRootBlockArchitecture(element);
    
    for (BlockArchitecture currentAndPreviousBlock : BlockArchitectureExt.getAllAllocatedArchitectures(currentBlock)) {
      availableElements.addAll(getRequirements(currentAndPreviousBlock));
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
    List<EObject> currentElements = new ArrayList<EObject>();
    
    // if it is a part, looking for also all requirements associated with its component.
    if (element instanceof Part) {
      AbstractType abstractType = ((Part) element).getAbstractType();
      currentElements.addAll(findOutgoingRequirements(abstractType));
    }
    
    currentElements.addAll(findOutgoingRequirements(element));

    currentElements = ListExt.removeDuplicates(currentElements);

    return currentElements;
  }

  private List<Requirement> findOutgoingRequirements(EObject element) {
    List<Requirement> requirements = new ArrayList<>();
    for (EObject referencer : EObjectExt.getReferencers(element, CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__SOURCE)) {
      Requirement requirement = ((CapellaOutgoingRelation) referencer).getTarget();
      if (requirement != null) {
        requirements.add(requirement);
      }
    }
    return requirements;
  }

  @Override
	public List<EReference> getEStructuralFeatures() {
    return Collections.singletonList(CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET);
  }
}
