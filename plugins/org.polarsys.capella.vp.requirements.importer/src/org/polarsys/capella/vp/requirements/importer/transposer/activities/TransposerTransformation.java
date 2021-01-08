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
package org.polarsys.capella.vp.requirements.importer.transposer.activities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace;
import org.eclipse.emf.diffmerge.bridge.api.incremental.IIncrementalBridgeExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.common.tools.report.config.registry.ReportManagerRegistry;
import org.polarsys.capella.common.tools.report.util.IReportManagerDefaultComponents;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.handler.helpers.HoldingResourceHelper;
import org.polarsys.capella.core.transition.common.activities.AbstractActivity;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.IRequirementsImporterBridgeConstants;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementsVPBridge;
import org.polarsys.kitalpha.cadence.core.api.parameter.ActivityParameters;
import org.polarsys.kitalpha.transposer.api.ITransposerWorkflow;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * This class managers the merge of requirements into the model and the save of the associated resources.
 * 
 */
public class TransposerTransformation extends AbstractActivity {

  /**
   * Flag to detect if the merge operation was canceled by the user. This is required since the merge operation and the
   * save of the resources are executed in two different transactions. If they are executed in the same transaction, the
   * Sirius Session does not detect that the model has changed, and thus the save does not have any effect.
   * 
   * The second transactions depends on the first one.
   * 
   * There must be a cleaner way to achieve this. But for the moment this will do.
   */
  final boolean[] mergeOperationCanceled = { false };
  private static final Logger LOGGER = ReportManagerRegistry.getInstance()
      .subscribe(IReportManagerDefaultComponents.DEFAULT);

  /**
   * The UI job that manages the transformation.
   */
  private class MergeAndSaveRequirementsUIJob extends UIJob {

    private ActivityParameters activityParams;

    public MergeAndSaveRequirementsUIJob(ActivityParameters activityParams) {
      super("Import and Merge Requirements Job");
      this.activityParams = activityParams;
    }

    @Override
    public IStatus runInUIThread(IProgressMonitor monitor) {
      return mergeAndSave(activityParams, monitor);
    }
  }

  /**
   * The Workspace Runnable that manages the resource save. The save must be executed in a Workspace Runnable, since it
   * is the workspace who manages the lifecycle of the save.
   * 
   * <b>Reason:</b> When resources are saved, the buffer used to save the resource can be flushed multiple times if the
   * resource content is bigger than the buffer. For resources that are not saved in a WorkspaceRunnable (by invoking
   * <code>resource.save()</code> for example, the workspace detects that a resource has changed and notifies any
   * listener that is registered to the event. The problem is that if multiple flushes are required, the file is
   * incomplete for all flushed except the last one, so the listener fail since the resource is corrupted. Thus only the
   * last flush should generated a notification, and the runnable ensured this.
   * 
   * In our case we do a <code>resource.save()</code> for the <code>bridgetraces</code> resource, since this resource is
   * not a semantic resource of our model, and thus the session save does not have an effect on it.
   * 
   * Running the save in a Workspace Runnable ensure that the Workspace does not get confused.
   */
  private class SaveResourcesWorkspaceRunnable implements IWorkspaceRunnable {
    private Resource modelResource;
    private Resource traceResource;

    public SaveResourcesWorkspaceRunnable(Resource modelResource, Resource traceResource) {
      this.modelResource = modelResource;
      this.traceResource = traceResource;
    }

    @Override
    public void run(IProgressMonitor monitor) throws CoreException {
      SubMonitor subMonitor = SubMonitor.convert(monitor, "Save resources", 100);
      subMonitor.split(30);
      try {
        traceResource.save(Collections.emptyMap());
        Session session = SessionManager.INSTANCE.getSession(modelResource);
        session.save(subMonitor.split(70));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  };

  @Override
  protected IStatus _run(final ActivityParameters activityParams) {

    Job job = new MergeAndSaveRequirementsUIJob(activityParams);

    job.setRule(ReqIFJobSchedulingRule.getInstance());
    job.setPriority(Job.SHORT);
    job.schedule();

    return Status.OK_STATUS;
  }

  /**
   * The main method executed by the MergeAndSaveRequirementsUIJob.
   * 
   * @param activityParams
   * @param monitor
   * @return the execution status.
   */
  protected IStatus mergeAndSave(ActivityParameters activityParams, IProgressMonitor monitor) {
    IContext context = (IContext) activityParams.getParameter(ITransposerWorkflow.TRANSPOSER_CONTEXT).getValue();

    if (reqIfContainsModule(context)) {
      BlockArchitecture blockArchitecture = (BlockArchitecture) context
          .get(IRequirementsImporterBridgeConstants.TARGET_ELEMENT);
      RequirementsVPBridge requirementBridge = (RequirementsVPBridge) context
          .get(IRequirementsImporterBridgeConstants.BRIDGE);
      IIncrementalBridgeExecution requirementBridgeExecution = (IIncrementalBridgeExecution) context
          .get(IRequirementsImporterBridgeConstants.BRIDGE_EXECUTION);

      ExecutionManager executionManager = TransactionHelper.getExecutionManager(blockArchitecture);

      SubMonitor subMonitor = SubMonitor.convert(monitor, "Merge and Save requirements", 2);

      mergeRequirements(executionManager, requirementBridge, requirementBridgeExecution, subMonitor.split(1));

      if (!isMergeOperationCanceled()) {
        IEditableModelScope targetScope = (IEditableModelScope) context
            .get(IRequirementsImporterBridgeConstants.TARGET_SCOPE);

        List<EObject> targetScopeContents = targetScope.getContents();

        if (!targetScopeContents.isEmpty()) {
          EObject rootScopeElement = targetScopeContents.get(0);
          Resource modelResource = rootScopeElement.eResource();
          Resource traceResource = (Resource) context.get(IRequirementsImporterBridgeConstants.TRACE_RESOURCE);

          saveAndCleanResources(executionManager, modelResource, traceResource, subMonitor.split(1));
          importReferencedImages(blockArchitecture, context);
        }
      }

    } else {
      displayNoModuleFoundInformationDialog();
    }
    return Status.OK_STATUS;
  }

  /**
   * Copy referenced images
   * @param targetElement
   * @param context
   */
  protected void importReferencedImages(EObject targetElement, IContext context) {
    TreeIterator<EObject> eAllContents = targetElement.eAllContents();
    while (eAllContents.hasNext()) {
      EObject eObj = eAllContents.next();
      if (eObj instanceof Requirement) {
        Requirement requirement = (Requirement) eObj;
        importReferencedImagesOfRequirement(requirement, context);
      }
    }
  }

  protected void importReferencedImagesOfRequirement(Requirement requirement, IContext context) {
    Map<String, List<List<Path>>> reqID2Images = (Map<String, List<List<Path>>>) context
        .get(IRequirementsImporterBridgeConstants.IMAGES_TO_COPY);
    if (reqID2Images.containsKey(requirement.getReqIFIdentifier())) {
      List<List<Path>> imagesToCopy = reqID2Images.get(requirement.getReqIFIdentifier());
      if (!imagesToCopy.isEmpty()) {
        for (List<Path> srcPath2TargetPath : imagesToCopy) {
          try {
            Files.copy(srcPath2TargetPath.get(0), srcPath2TargetPath.get(1), StandardCopyOption.REPLACE_EXISTING);
          } catch (IOException e) {
            LOGGER.log(Level.ERROR, MessageFormat.format("Cannot find or cannot copy {0}", srcPath2TargetPath.get(0)),
                e);
          }
        }
      }
    }
  }

  /**
   * Displays the Diff Merge Window, and merges the Requirements on user feedback. The code is executed in a
   * transaction.
   * 
   * @param executionManager
   * @param requirementBridge
   * @param requirementBridgeExecution
   * @param monitor
   */
  private void mergeRequirements(ExecutionManager executionManager, RequirementsVPBridge requirementBridge,
      IIncrementalBridgeExecution requirementBridgeExecution, SubMonitor monitor) {

    monitor.beginTask("Merge requirements", 1);
    setMergeOperationCanceled(false);

    executionManager.execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        IStatus result = requirementBridge.mergeInteractively(requirementBridgeExecution, monitor);
        if (result == Status.CANCEL_STATUS) {
          setMergeOperationCanceled(true);
          throw new OperationCanceledException(result.getMessage());
        }
      }
    });
  }

  /**
   * Saves the model resource, trace resource and cleans existing holding resources.
   * 
   * @param executionManager
   * @param modelResource
   * @param traceResource
   * @param monitor
   */
  private void saveAndCleanResources(ExecutionManager executionManager, Resource modelResource, Resource traceResource,
      SubMonitor monitor) {
    executionManager.execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        saveResources(modelResource, traceResource, monitor);

        HoldingResourceHelper.flushHoldingResource(TransactionHelper.getEditingDomain(modelResource));
      }
    });
  }

  /**
   * Saves the model and trace resources in a workspace runnable.
   * 
   * @param modelResource
   * @param traceResource
   * @param progressMonitor
   */
  private void saveResources(Resource modelResource, Resource traceResource, SubMonitor progressMonitor) {

    IWorkspaceRoot workspaceRoot = EcorePlugin.getWorkspaceRoot();
    if (workspaceRoot != null) {
      IWorkspace workspace = workspaceRoot.getWorkspace();

      if (workspace != null) {
        SaveResourcesWorkspaceRunnable saveRunnable = new SaveResourcesWorkspaceRunnable(modelResource, traceResource);

        try {
          workspace.run(saveRunnable, progressMonitor);
        } catch (CoreException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private void displayNoModuleFoundInformationDialog() {
    Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    String title = Messages.ReqIfImport_NoModuleFoundPopup_Title;
    String content = Messages.ReqIfImport_NoModuleFoundPopup_Content;
    MessageDialog.openInformation(shell, title, content);
  }

  private void setMergeOperationCanceled(boolean isCanceled) {
    mergeOperationCanceled[0] = isCanceled;
  }

  private boolean isMergeOperationCanceled() {
    return mergeOperationCanceled[0];
  }

  public static String getId() {
    return TransposerTransformation.class.getCanonicalName();
  }

  private boolean reqIfContainsModule(IContext context) {
    Object isModulePresent = context.get(IRequirementsImporterBridgeConstants.REQIF_MODEL_CONTAINS_MODULE);
    return isModulePresent instanceof Boolean && ((Boolean) isModulePresent).booleanValue();
  }

  protected static void compact(Resource resource) {
    List<EObject> filtered = EcoreUtil.filterDescendants(resource.getContents());
    resource.getContents().retainAll(filtered);
  }

  protected static void setTrace(final Resource traceResource, final IBridgeTrace trace) {
    TransactionHelper.getExecutionManager(traceResource).execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        traceResource.getContents().clear();
        traceResource.getContents().add((EObject) trace);
      }
    });
  }

}
