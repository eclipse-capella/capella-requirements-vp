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
package org.polarsys.capella.vp.requirements.ju.testcases;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigatorManager;
import org.polarsys.capella.core.libraries.model.ICapellaModel;
import org.polarsys.capella.core.libraries.utils.ScopeModelWrapper;
import org.polarsys.capella.core.platform.sirius.ui.navigator.view.CapellaCommonNavigator;
import org.polarsys.capella.shared.id.handler.IScope;
import org.polarsys.capella.shared.id.handler.IdManager;
import org.polarsys.capella.test.framework.api.BasicTestCase;

/**
 * Selecting a viewpoint element while the property view is opened should not raise any exception
 *
 */
public class PropertyViewTestCase extends BasicTestCase {
  private static final String projectTestName = "misc";
  private static final String CAPELLA_MODULE = "92115d8a-4cf0-4b63-8200-a7043e201ea0";

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
    EObject capellaModule = IdManager.getInstance().getEObject(CAPELLA_MODULE, scope);
    
    activatePropertyView();
    selectOnNavigatorView(capellaModule);
  }

  private void selectOnNavigatorView(EObject selectedObject) {
    IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    try {
      activePage.showView("capella.project.explorer");
      CapellaCommonNavigator navigatorview = (CapellaCommonNavigator) activePage.findView("capella.project.explorer");
      
      CommonNavigatorManager manager = new CommonNavigatorManager(navigatorview);
      manager.selectionChanged(
          new SelectionChangedEvent(navigatorview.getCommonViewer(), new StructuredSelection(selectedObject)));
    } catch (PartInitException e) {
      e.printStackTrace();
    }
  }

  private void activatePropertyView() {
    IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    try {
      activePage.showView("org.eclipse.ui.views.PropertySheet");
      IViewPart propertyView = (IViewPart) activePage.findView("org.eclipse.ui.views.PropertySheet");
      activePage.activate(propertyView);
    } catch (PartInitException e) {
      e.printStackTrace();
    }
  }
}
