/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
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
import org.polarsys.capella.core.data.capellamodeller.SystemEngineering;
import org.polarsys.capella.vp.requirements.model.helpers.ViewpointHelper;

/**
 * This tester verifies whether the menu item "Configure Requirement Labels In Diagram" can be active or not.
 * It is active if the selected item is an SystemEngineering and the requirement viewpoint is referenced. 
 * @author Cong Bang DO
 *
 */
public class ActiveReqVPOnSystemEngineeringPropertyTester extends PropertyTester {

  @Override
  public boolean test(Object object, String propertyName, Object[] params, Object testedValue) {
    if (propertyName.equals("viewpointActiveAndSelectingAird")) { //$NON-NLS-1$
      if (object instanceof List) {
        boolean result = true;
        for (Object obj : (List<?>) object) {
          if (obj instanceof SystemEngineering) {
            result &= ViewpointHelper.isViewpointActive((EObject) obj);
          } else {
            result = false;
          }
        }
        return result && !((List<?>) object).isEmpty();
      } else if (object instanceof SystemEngineering) {
        return ViewpointHelper.isViewpointActive((EObject) object);
      }
    }
    return false;
  }

}
