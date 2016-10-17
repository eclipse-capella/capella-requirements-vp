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
package org.polarsys.capella.vp.requirements.ui.properties;

import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

/**
 * @author Joao Barata
 */
public class CapellaRequirementsUIPropertiesPlugin implements BundleActivator {

  public static final String VIEWPOINT_ID = "org.polarsys.capella.vp.requirements"; //$NON-NLS-1$

  /**
   * @return true is the AF viewpoint is active, false otherwise
   */
  public static boolean isViewpointActive(EObject modelElement) {
    return (modelElement != null) ? ViewpointManager.getInstance(modelElement).isReferenced(CapellaRequirementsUIPropertiesPlugin.VIEWPOINT_ID) &&
      !ViewpointManager.getInstance(modelElement).isInactive(CapellaRequirementsUIPropertiesPlugin.VIEWPOINT_ID) : false;
  }

  /**
   * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
  }

  /**
   * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
  }
}
