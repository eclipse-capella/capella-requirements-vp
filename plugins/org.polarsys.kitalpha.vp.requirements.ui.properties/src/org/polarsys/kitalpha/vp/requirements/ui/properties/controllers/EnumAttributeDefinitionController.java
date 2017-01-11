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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.core.ui.properties.controllers.SimpleSemanticFieldController;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration;

public class EnumAttributeDefinitionController extends SimpleSemanticFieldController {
  /**
   * {@inheritDoc}
   */
  @Override
  public EObject loadValue(EObject semanticElement, EStructuralFeature semanticFeature) {
    EObject loadValue = super.loadValue(semanticElement, semanticFeature);
    if (!(loadValue instanceof AttributeDefinitionEnumeration))
      return null;
    return loadValue;
  }
}
