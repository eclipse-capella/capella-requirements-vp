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
package org.polarsys.capella.vp.requirements.business.queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.model.utils.ListExt;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public class Requirement_InternalRelationTarget_Requirement extends CapellaElement_CapellaRelation_Requirement {

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
	  
  @Override
  public List<EObject> getCurrentElements(EObject element, boolean onlyGenerated) {
    List<EObject> currentElements = new ArrayList<EObject>();
    
    for (EObject referencer : EObjectExt.getReferencers(element, RequirementsPackage.Literals.INTERNAL_RELATION__SOURCE)) {
      Requirement elt = ((InternalRelation) referencer).getTarget();
      if (elt != null) {
        currentElements.add(elt);
      }
    }
    
    currentElements = ListExt.removeDuplicates(currentElements);
    
    return currentElements;
  }

  @Override
  public EClass getEClass() {
    return RequirementsPackage.Literals.REQUIREMENT;
  }

  @Override
  public List<EReference> getEStructuralFeatures() {
    return Collections.singletonList(RequirementsPackage.Literals.INTERNAL_RELATION__TARGET);
  }

}
