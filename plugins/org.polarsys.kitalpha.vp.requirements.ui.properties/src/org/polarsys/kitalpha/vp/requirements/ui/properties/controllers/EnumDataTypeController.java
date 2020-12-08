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
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition;

public class EnumDataTypeController extends LocalProjectFilteringController {
  @Override
  public List<EObject> readOpenValues(EObject semanticElement, EStructuralFeature semanticFeature) {
    List<EObject> eObjs = new ArrayList<EObject>(); 
    for (EObject eObj : super.readOpenValues(semanticElement, semanticFeature)) {
      if (eObj instanceof EnumerationDataTypeDefinition) {
        if (BlockArchitectureExt.getRootAndPreviousBlockArchitectures(semanticElement).contains(BlockArchitectureExt.getRootBlockArchitecture(eObj))) {
    	  eObjs.add(eObj);
    	}
      }
    }
    return eObjs;
  }
}
