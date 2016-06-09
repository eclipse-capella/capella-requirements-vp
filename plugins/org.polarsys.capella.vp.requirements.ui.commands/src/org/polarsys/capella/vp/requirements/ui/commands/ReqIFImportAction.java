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

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.vp.requirements.importer.transposer.launcher.RequirementsImportLauncher;

/**
 * @author Joao Barata
 */
public class ReqIFImportAction implements IObjectActionDelegate {

  IWorkbenchPart part;
  ISelection selection;

  /**
   * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
   */
  public void setActivePart(IAction action, IWorkbenchPart part) {
    this.part = part;
  }

  /**
   * @see IActionDelegate#run(IAction) Instantiates the wizard and opens it in the wizard container
   */
  public void run(IAction action) {
    if (selection instanceof IStructuredSelection) {
    	Object firstSelection = ((IStructuredSelection) selection).getFirstElement();
    	if (firstSelection instanceof BlockArchitecture) {
    		System.out.println(((BlockArchitecture) firstSelection).getName());
    	    new RequirementsImportLauncher().launch(URI.createPlatformResourceURI("/org.polarsys.capella.vp.requirements.ju/model/testmodule.reqif", true), (BlockArchitecture) firstSelection, new NullProgressMonitor());
    	} else {
            RequirementsVPUICommandsPlugin.getDefault().getLog().log(new Status(Status.ERROR, RequirementsVPUICommandsPlugin.PLUGIN_ID, "Invalid selection"));
    	}
    }
  }

  /**
   * @see IActionDelegate#selectionChanged(IAction, ISelection)
   */
  public void selectionChanged(IAction action, ISelection selection) {
    this.selection = selection;
  }
}
