/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.commands;

import java.util.List;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.vp.requirements.model.helpers.ViewpointHelper;

/**
 * @author Joao Barata
 */
public class RequirementsVPPropertyTester extends PropertyTester {

  /**
   * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
   */
  public boolean test(Object object, String propertyName, Object[] params, Object testedValue) {
    if (propertyName.equals("viewpointActive")) { //$NON-NLS-1$
      if (object instanceof List) {
        boolean result = true;
        for (Object obj : (List<?>) object) {
          if (obj instanceof BlockArchitecture) {
            result &= ViewpointHelper.isViewpointActive((EObject) obj);
          } else {
            result = false;
          }
        }
        return result && !((List<?>) object).isEmpty();
      }
      else if (object instanceof BlockArchitecture) {
        return ViewpointHelper.isViewpointActive((EObject) object);
      }
    }
    return false;
  }
}