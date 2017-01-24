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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.polarsys.capella.common.mdsofa.common.misc.Couple;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
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
    if (object instanceof DSemanticDecorator) {
      element = ((DSemanticDecorator) object).getTarget();
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
    if (element instanceof DRepresentation) {
      List<EObject> result = new ArrayList<EObject>();
      for (Couple<Requirement, RelationType> allocation : RelationAnnotationHelper.getAllocations((DRepresentation) element, RelationAnnotationHelper.IncomingRelationAnnotation).values()) {
        result.add(allocation.getKey());
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
