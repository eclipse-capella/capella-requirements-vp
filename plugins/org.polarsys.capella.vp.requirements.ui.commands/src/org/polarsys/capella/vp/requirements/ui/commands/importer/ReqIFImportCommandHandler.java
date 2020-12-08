/*******************************************************************************
 * Copyright (c) 2017, 2018 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ui.commands.importer;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.polarsys.capella.common.ui.services.commands.AbstractUiHandler;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.vp.requirements.importer.transposer.launcher.RequirementsImportLauncher;
import org.polarsys.capella.vp.requirements.ui.commands.RequirementsVPUICommandsPlugin;

/**
 * @author Joao Barata
 */
public class ReqIFImportCommandHandler extends AbstractUiHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    List<EObject> selection = getSelection(event, EObject.class);
    if ((selection != null) && (selection.size() > 0)) {
      for (EObject semanticElement : selection) {
        if (semanticElement instanceof BlockArchitecture) {
          URI file = getReqIFFileURI(event);
          if (file != null) {
            run(file, (BlockArchitecture) semanticElement);
          }
        } else {
          RequirementsVPUICommandsPlugin.getDefault().getLog()
              .log(new Status(Status.ERROR, RequirementsVPUICommandsPlugin.PLUGIN_ID, "Invalid selection"));
        }
      }
    }
    return null;
  }

  protected Shell getActiveShell(ExecutionEvent event) {
    IWorkbenchPart part = (IWorkbenchPart) getVariableValue(event, ACTIVE_PART_VARIABLE);
    if (part == null) {
      return RequirementsVPUICommandsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
    }
    return part.getSite().getShell();
  }

  protected void run(final URI model, final BlockArchitecture target) {
    new RequirementsImportLauncher().launch(model, target, new NullProgressMonitor());
  }

  protected URI getReqIFFileURI(ExecutionEvent event) {
    FileDialog fileDialog = new FileDialog(getActiveShell(event), SWT.SINGLE);
    fileDialog.setFilterExtensions(new String[] { "*.reqif" });
    fileDialog.setFilterNames(new String[] { "ReqIF files" });
    String filepath = fileDialog.open();
    if (filepath != null) {
      return URI.createFileURI(filepath);
    }
    return null;
  }
}
