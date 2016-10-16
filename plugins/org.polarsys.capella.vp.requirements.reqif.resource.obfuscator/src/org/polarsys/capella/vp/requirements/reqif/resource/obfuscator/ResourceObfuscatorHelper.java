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

import java.io.IOException;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.common.ef.ExecutionManagerRegistry;

/**
 * @author Joao Barata
 */
public class ResourceObfuscatorHelper {

  /**
   * obfuscate given resource
   * @param file
   */
  public static void obfuscateResource(IFile file) {
	URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
	  
	ExecutionManager manager = ExecutionManagerRegistry.getInstance().addNewManager();
	TransactionalEditingDomain editingDomain = manager.getEditingDomain();
	ResourceSet resourceSet = editingDomain.getResourceSet();
	Resource resource = resourceSet.getResource(uri, true);

    manager.execute(new ResourceObfuscatorCommand(resource));
	  
	try {
	  resource.save(new HashMap<Object, Object>());
	} catch (IOException exception) {
	  ResourceObfuscatorPlugin.getDefault().getLog().log(
		new Status(IStatus.ERROR, ResourceObfuscatorPlugin.PLUGIN_ID, "Failed saving resource", exception));
	}

	editingDomain.dispose();
	ExecutionManagerRegistry.getInstance().removeManager(manager);
  }
}
