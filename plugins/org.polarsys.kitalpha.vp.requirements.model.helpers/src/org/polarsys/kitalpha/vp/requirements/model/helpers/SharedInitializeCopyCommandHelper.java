/**
 *  Copyright (c) 2017 THALES GLOBAL SERVICES.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */
package org.polarsys.kitalpha.vp.requirements.model.helpers;

import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CopyCommand.Helper;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.osgi.framework.Bundle;

public class SharedInitializeCopyCommandHelper {
	
	private static SharedInitializeCopyCommandHelper instance;
	private static final Logger LOGGER = Logger.getLogger( SharedInitializeCopyCommandHelper.class.getName());
	private static final String EXTENSION_POINT_ID = "org.polarsys.kitalpha.vp.requirements.model.helpers.SharedInitializeCopyCommand"; //$NON-NLS-1$
	private static final String ATTR_CLASS = "class"; //$NON-NLS-1$
	
	/**
	 * Gets singleton instance
	 * @return instance of this singleton
	 */
	public static SharedInitializeCopyCommandHelper getInstance() {
		if (instance == null) {
			instance = new SharedInitializeCopyCommandHelper();
		}
		return instance;
	}

	/**
	 * This class cannot be instantiated from outside
	 */
	private SharedInitializeCopyCommandHelper() {
		// do nothing
	}
	
	/**
	 * Perform shared initialize copy command when the suitable class has been found
	 * @return
	 */
	public Command doSharedInitializeCopyCommand(EditingDomain domain, EObject owner, Helper helper) {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
	    IConfigurationElement[] cfgElements = extensionRegistry.getConfigurationElementsFor(EXTENSION_POINT_ID);
	    for(IConfigurationElement configElement : cfgElements){
	    	try {
				Class<?> clazz = loadClass(configElement);
				Constructor<?> constructor = clazz.getConstructor(EditingDomain.class, EObject.class, Helper.class);
				return (Command)constructor.newInstance(domain,  owner,  helper);
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, e.toString(), e);
			}
	    }
		return null;
	}
	
	/**
	 * load a specific class from a targeted bundle
	 * @param configElement
	 * @return
	 * @throws Exception
	 */
	private Class<?> loadClass(IConfigurationElement configElement) throws Exception {
		String contributorPluginId = configElement.getContributor().getName();
		String className = configElement.getAttribute(ATTR_CLASS);
	    Bundle bundle = Platform.getBundle(contributorPluginId);
	    if (bundle == null) {
	      throw new IllegalStateException("Cannot locate contributor plug-in '" + contributorPluginId + "'"); //$NON-NLS-1$ //$NON-NLS-2$
	    }
	    return bundle.loadClass(className);
	}
}
