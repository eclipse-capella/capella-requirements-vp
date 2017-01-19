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
import org.polarsys.capella.core.ui.properties.controllers.AbstractMultipleSemanticFieldController;

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
}
