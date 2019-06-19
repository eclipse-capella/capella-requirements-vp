/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ju.testcases;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.libraries.model.ICapellaModel;
import org.polarsys.capella.core.libraries.utils.ScopeModelWrapper;
import org.polarsys.capella.core.model.handler.helpers.CapellaAdapterHelper;
import org.polarsys.capella.shared.id.handler.IScope;
import org.polarsys.capella.shared.id.handler.IdManager;
import org.polarsys.capella.test.framework.api.BasicTestCase;

/**
 * Requirement elements should inherit Kitalpha's Element class
 *
 */
public class SemanticRequirementElementTestCase extends BasicTestCase {
  private static final String projectTestName = "emptymodelWithImportedReqif";
  public static final String REQUIREMENT_1 = "20169578-b83e-4d02-a041-d41a9f7b60ae"; //$NON-NLS-1$

  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestArtefact#getRequiredTestModels()
   */
  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(projectTestName);
  }

  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestCase#test()
   */
  @Override
  public void test() throws Exception {
    ICapellaModel model = getTestModel(projectTestName);
    IScope scope = new ScopeModelWrapper(model);
    EObject REQ1 = IdManager.getInstance().getEObject(REQUIREMENT_1, scope);
    assertTrue("Requirements should be resolvable", CapellaAdapterHelper.resolveSemanticObject(REQ1, true) != null);
  }
}
