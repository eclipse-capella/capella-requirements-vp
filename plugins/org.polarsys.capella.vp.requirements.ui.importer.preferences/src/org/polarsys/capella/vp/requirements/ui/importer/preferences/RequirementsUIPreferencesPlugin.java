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
package org.polarsys.capella.vp.requirements.ui.importer.preferences;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.osgi.framework.BundleContext;
import org.polarsys.capella.vp.requirements.importer.extension.RequirementsImporterExtensionPlugin;

/**
 * @author Joao Barata
 */
public class RequirementsUIPreferencesPlugin extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "org.polarsys.capella.vp.requirements.ui.importer.preferences"; //$NON-NLS-1$

  // The shared instance
  private static RequirementsUIPreferencesPlugin plugin;
  
  private ScopedPreferenceStore preferenceStore;

  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
  }

  /**
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   *
   * @return the shared instance
   */
  public static RequirementsUIPreferencesPlugin getDefault() {
    return plugin;
  }

  @Override
  public IPreferenceStore getPreferenceStore() {

    // Create the preference store lazily.
    if (preferenceStore == null) {
      preferenceStore = new ScopedPreferenceStore(InstanceScope.INSTANCE, RequirementsImporterExtensionPlugin.PLUGIN_ID);
    }
    return preferenceStore;
  }
}
