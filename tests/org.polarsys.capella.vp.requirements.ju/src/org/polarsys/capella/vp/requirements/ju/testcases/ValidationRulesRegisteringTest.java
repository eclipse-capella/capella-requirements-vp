/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ju.testcases;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.osgi.util.NLS;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.vp.requirements.validation.Activator;

/**
 * This test case ensures that validation rules are properly registered.
 * (there is rules registered on Sirius and Capella metamodels. We will be noticed on namespaceUri changes)
 */
public class ValidationRulesRegisteringTest extends BasicTestCase {

  @Override
  public void test() throws Exception {

    //for each nsUri used on requirement validation plugin, we ensure that there is a EPackage associated on the registry
    IConfigurationElement [] contributions = Platform.getExtensionRegistry().getConfigurationElementsFor("org.eclipse.emf.validation", "constraintProviders");
    for (IConfigurationElement element : contributions) {
      if (Activator.PLUGIN_ID.equals(element.getContributor().getName())) {
        for (IConfigurationElement child : element.getChildren("package")) {
          String namespace = child.getAttribute("namespaceUri");
          EPackage pkg = EPackage.Registry.INSTANCE.getEPackage(namespace);
          assertTrue(NLS.bind("Namespace uri ''{0}'' doesn't exist", namespace), pkg != null); 
        }
      }
    }
  }
}
