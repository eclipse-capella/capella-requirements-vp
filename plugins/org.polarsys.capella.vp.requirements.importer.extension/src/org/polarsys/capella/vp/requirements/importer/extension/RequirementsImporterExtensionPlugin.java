/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.importer.extension;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Joao Barata
 */
public class RequirementsImporterExtensionPlugin implements BundleActivator {

  // The plug-in ID
  public static final String PLUGIN_ID = "org.polarsys.capella.vp.requirements.importer.extension"; //$NON-NLS-1$

  public static final String ATTRIBUTES_PROVIDER_EXTENSION_ID = "attributesProvider"; //$NON-NLS-1$

  // The shared instance
	private static BundleContext context;

	public static BundleContext getContext() {
		return context;
	}

	/**
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		RequirementsImporterExtensionPlugin.context = bundleContext;
		new RequirementsPreferencesInitializer().initializeDefaultPreferences();
	}

	/**
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		RequirementsImporterExtensionPlugin.context = null;
	}

}
