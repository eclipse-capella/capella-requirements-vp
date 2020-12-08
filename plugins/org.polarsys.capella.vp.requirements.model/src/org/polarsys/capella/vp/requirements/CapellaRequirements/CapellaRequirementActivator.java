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
package org.polarsys.capella.vp.requirements.CapellaRequirements;
import org.eclipse.emf.ecore.EValidator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.polarsys.capella.core.validation.CapellaValidatorAdapter;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public class CapellaRequirementActivator implements BundleActivator {

  @Override
  public void start(BundleContext context) throws Exception {
    EValidator.Registry.INSTANCE.put(CapellaRequirementsPackage.eINSTANCE, new CapellaValidatorAdapter());
    EValidator.Registry.INSTANCE.put(RequirementsPackage.eINSTANCE, new CapellaValidatorAdapter());
  }

  @Override
  public void stop(BundleContext context) throws Exception {
    EValidator.Registry.INSTANCE.remove(CapellaRequirementsPackage.eINSTANCE);
    EValidator.Registry.INSTANCE.remove(RequirementsPackage.eINSTANCE);
  }

}
