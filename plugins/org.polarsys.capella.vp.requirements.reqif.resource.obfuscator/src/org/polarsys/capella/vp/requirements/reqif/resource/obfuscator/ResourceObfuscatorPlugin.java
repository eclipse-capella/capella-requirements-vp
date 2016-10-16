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
package org.polarsys.capella.vp.requirements.reqif.resource.obfuscator;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 *
 * @author Joao Barata
 */
public class ResourceObfuscatorPlugin extends Plugin {
  /**
   * The plugin ID.
   */
  public static final String PLUGIN_ID = "org.polarsys.capella.vp.requirements.reqif.resource.obfuscator"; //$NON-NLS-1$

  /**
   * The singleton instance.
   */
  private static ResourceObfuscatorPlugin plugin;

  /**
   * {@inheritDoc}
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  /**
   * Returns the singleton instance
   * @return
   */
  public static ResourceObfuscatorPlugin getDefault() {
    return plugin;
  }
}
