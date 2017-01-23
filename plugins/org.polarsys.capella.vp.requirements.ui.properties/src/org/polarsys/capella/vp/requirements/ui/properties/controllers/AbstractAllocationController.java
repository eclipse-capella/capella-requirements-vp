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
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.capella.core.ui.properties.controllers.AbstractMultipleSemanticFieldController;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public abstract class AbstractAllocationController extends AbstractMultipleSemanticFieldController {
  /**
   * Wizards should also propose already allocated elements
   */
  @Override
  public List<EObject> readOpenValues(EObject semanticElement, EStructuralFeature semanticFeature,
      boolean availableElements) {
    List<EObject> readOpenValues = super.readOpenValues(semanticElement, semanticFeature, availableElements);
    List<EObject> currentElements = getReadOpenValuesQuery(semanticElement).getCurrentElements(semanticElement, false);
    readOpenValues.addAll(currentElements);
    return readOpenValues;
  }

  /**
   *
   * @param relation
   * @return the default relation type if exists, otherwise null
   */
  public RelationType getDefaultType(AbstractRelation relation) {
    IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
        RequirementsPackage.eINSTANCE.getAbstractRelation(),
        RequirementsPackage.eINSTANCE.getAbstractRelation_RelationType());
    List<EObject> availableElements = query.getAvailableElements(relation);
    if (availableElements.size() == 1)
      return (RelationType) availableElements.get(0);
    return null;
  }
}
