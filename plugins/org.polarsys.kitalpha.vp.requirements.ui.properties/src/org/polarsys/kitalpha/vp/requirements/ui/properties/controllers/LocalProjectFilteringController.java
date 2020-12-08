/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
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
package org.polarsys.kitalpha.vp.requirements.ui.properties.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.model.helpers.ProjectExt;
import org.polarsys.capella.core.ui.properties.controllers.SimpleSemanticFieldController;

/**
 * A SimpleSemanticController that will allow only elements of the current Project/Library as open values.
 */
public class LocalProjectFilteringController extends SimpleSemanticFieldController {
  /**
   * Call the expected BusinessQuery then remove elements that do not belong to the current Project/Library. 
   */
  @Override
  public List<EObject> readOpenValues(EObject semanticElement, EStructuralFeature semanticFeature) { 
    Project projectOfInitialElement = ProjectExt.getProject(semanticElement);
    List<EObject> eObjs = new ArrayList<EObject>(); 
    for (EObject eObj : super.readOpenValues(semanticElement, semanticFeature)) {
      Project projectOfProposedElement = ProjectExt.getProject(eObj);
      // Keep only elements of my Project (or Library...).
      if (projectOfInitialElement.equals(projectOfProposedElement)) {
        eObjs.add(eObj);
      }
    }
    return eObjs;
  }
}