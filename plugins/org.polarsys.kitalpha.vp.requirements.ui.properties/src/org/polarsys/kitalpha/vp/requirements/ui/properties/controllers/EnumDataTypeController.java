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
package org.polarsys.kitalpha.vp.requirements.ui.properties.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.core.ui.properties.controllers.SimpleSemanticFieldController;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition;

public class EnumDataTypeController extends SimpleSemanticFieldController {
  @Override
  public List<EObject> readOpenValues(EObject semanticElement, EStructuralFeature semanticFeature) {
    List<EObject> eObjs = new ArrayList<EObject>(); 
    for (EObject eObj : super.readOpenValues(semanticElement, semanticFeature))
      if (eObj instanceof EnumerationDataTypeDefinition)
        eObjs.add(eObj);
    return eObjs;
  }
}
