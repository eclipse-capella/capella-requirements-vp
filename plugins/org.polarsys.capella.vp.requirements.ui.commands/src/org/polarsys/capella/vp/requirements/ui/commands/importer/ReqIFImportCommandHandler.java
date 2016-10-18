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
package org.polarsys.capella.vp.requirements.ui.commands.importer;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
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
          RequirementsVPUICommandsPlugin.getDefault().getLog().log(new Status(Status.ERROR, RequirementsVPUICommandsPlugin.PLUGIN_ID, "Invalid selection"));
        }
      }
    }
    return null;
  }

//  @Override
//  public void setEnabled(Object evaluationContext) {
//    Object ctx = ((IEvaluationContext) evaluationContext).getVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME);
//    setBaseEnabled(isAllowedContext(ctx));
//  }

  protected Shell getActiveShell(ExecutionEvent event) {
    IWorkbenchPart part = (IWorkbenchPart) getVariableValue(event, ACTIVE_PART_VARIABLE);
    if (part == null) {
      return RequirementsVPUICommandsPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell();
    }
    return part.getSite().getShell();
  }

  protected void run(final URI model, final BlockArchitecture target) {
    Job job = new Job("Import from ReqIF") {
      protected IStatus run(IProgressMonitor monitor) {
        new RequirementsImportLauncher().launch(model, target, monitor);
        return Status.OK_STATUS;
      }
    };
    job.setPriority(Job.SHORT);
    job.schedule();
  }

  protected URI getReqIFFileURI(ExecutionEvent event) {
    FileDialog fileDialog = new FileDialog(getActiveShell(event), SWT.SINGLE);
    fileDialog.setFilterExtensions(new String[] { "*.reqif", "*.*" });
    fileDialog.setFilterNames(new String[] { "ReqIF files", "All files" });
    String filepath = fileDialog.open();
    if (filepath != null) {
      return URI.createFileURI(filepath);
    }
    return null;
  }

//  public static final String VIEWPOINT_ID = "org.polarsys.capella.vp.requirements"; //$NON-NLS-1$

  /**
   * @return true is the AF viewpoint is active, false otherwise
   */
//  public static boolean isViewpointActive(EObject modelElement) {
//    return (modelElement != null) ? ViewpointManager.getInstance(modelElement).isReferenced(VIEWPOINT_ID) &&
//      !ViewpointManager.getInstance(modelElement).isInactive(VIEWPOINT_ID) : false;
//  }

  /**
   *
   */
//  public boolean isAllowedContext(Object object) {
//    if (object instanceof IStructuredSelection) {
//      boolean result = true;
//      for (Object obj : ((IStructuredSelection) object).toList()) {
//        if (obj instanceof BlockArchitecture) {
//          result &= isViewpointActive((EObject) obj);
//        } else {
//          result = false;
//        }
//      }
//      return result;
//    }
//    else if (object instanceof BlockArchitecture) {
//      return isViewpointActive((EObject) object);
//    }
//    return false;
//  }
}
