/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.commands;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

/**
 * @author Joao Barata
 */
public class ReqIFPropertyTester extends PropertyTester {

  public static final String VIEWPOINT_ID = "org.polarsys.capella.vp.requirements"; //$NON-NLS-1$

  /**
   * @return true is the AF viewpoint is active, false otherwise
   */
  public static boolean isViewpointActive(EObject modelElement) {
    return ViewpointManager.getInstance(modelElement).isActive(VIEWPOINT_ID);
  }

  /**
   * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
   */
  public boolean test(Object object, String propertyName, Object[] params, Object testedValue) {
    if (propertyName.equals("viewpointActive")) { //$NON-NLS-1$
      return (object instanceof EObject) && isViewpointActive((EObject) object);
    }
    return true;
  }
}