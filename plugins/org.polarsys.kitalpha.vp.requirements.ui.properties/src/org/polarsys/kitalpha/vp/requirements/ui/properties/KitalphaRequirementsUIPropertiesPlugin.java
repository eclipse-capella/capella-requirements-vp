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
package org.polarsys.kitalpha.vp.requirements.ui.properties;

import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.polarsys.kitalpha.ad.services.manager.ViewpointManager;

/**
 * @author Joao Barata
 */
public class KitalphaRequirementsUIPropertiesPlugin implements BundleActivator {

  public static final String VIEWPOINT_ID = "org.polarsys.kitalpha.vp.requirements"; //$NON-NLS-1$

  /**
   * @return true is the AF viewpoint is active, false otherwise
   */
  public static boolean isViewpointActive(EObject modelElement) {
    return ViewpointManager.getInstance(modelElement).isActive(KitalphaRequirementsUIPropertiesPlugin.VIEWPOINT_ID);
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
