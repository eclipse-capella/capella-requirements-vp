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
package org.polarsys.capella.vp.requirements.model.helpers;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

/**
 * @author Joao Barata
 */
public class ViewpointHelper {

  public static final String VIEWPOINT_ID = "org.polarsys.capella.vp.requirements"; //$NON-NLS-1$

  /**
   * @return true is the AF viewpoint is active, false otherwise
   */
  public static boolean isViewpointActive(EObject element) {
    try {
      return (element != null) ? ViewpointManager.getInstance(element).isReferenced(VIEWPOINT_ID)
          && !ViewpointManager.getInstance(element).isInactive(VIEWPOINT_ID) : false;
    } catch (IllegalArgumentException ex) {
      // element is invalid, silent failure
    }
    return false;
  }
}
