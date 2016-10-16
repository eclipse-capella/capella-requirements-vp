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

import org.eclipse.sirius.common.ui.tools.api.plugin.AbstractUIActivator;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * @author Joao Barata
 */
public class RequirementsVPUICommandsPlugin extends AbstractUIActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.polarsys.capella.vp.requirements.ui.commands"; //$NON-NLS-1$

	// The shared instance
	private static RequirementsVPUICommandsPlugin plugin;
	
	/**
	 * The constructor
	 */
	public RequirementsVPUICommandsPlugin() {
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RequirementsVPUICommandsPlugin getDefault() {
		return plugin;
	}
}
