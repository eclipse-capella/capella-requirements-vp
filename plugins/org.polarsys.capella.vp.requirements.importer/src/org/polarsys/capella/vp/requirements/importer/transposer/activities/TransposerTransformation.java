/*******************************************************************************
 * Copyright (c) 2017, 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.activities;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace;
import org.eclipse.emf.diffmerge.bridge.api.incremental.IIncrementalBridgeExecution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.progress.UIJob;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.handler.helpers.HoldingResourceHelper;
import org.polarsys.capella.core.transition.common.activities.AbstractActivity;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.IRequirementsImporterBridgeConstants;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementsVPBridge;
import org.polarsys.kitalpha.cadence.core.api.parameter.ActivityParameters;
import org.polarsys.kitalpha.transposer.api.ITransposerWorkflow;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * @author Joao Barata
 */
public class TransposerTransformation extends AbstractActivity {

  public static String getId() {
    return TransposerTransformation.class.getCanonicalName();
  }

  @Override
  protected IStatus _run(final ActivityParameters activityParams) {
    Job job = new UIJob("Merge of ReqIF elements") {
      @Override
      public IStatus runInUIThread(final IProgressMonitor monitor) {
        return mergeAndSave(activityParams);
      }
    };
    job.setRule(ReqIFJobSchedulingRule.getInstance());
    job.setPriority(Job.SHORT);
    job.schedule();

    return Status.OK_STATUS;
  }

  protected IStatus mergeAndSave(ActivityParameters activityParams) {
    final IContext context = (IContext) activityParams.getParameter(ITransposerWorkflow.TRANSPOSER_CONTEXT).getValue();
    final IEditableModelScope targetScope = (IEditableModelScope) context
        .get(IRequirementsImporterBridgeConstants.TARGET_SCOPE);
    BlockArchitecture target = (BlockArchitecture) context.get(IRequirementsImporterBridgeConstants.TARGET_ELEMENT);
    TransactionHelper.getExecutionManager(target).execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        RequirementsVPBridge bridge = (RequirementsVPBridge) context.get(IRequirementsImporterBridgeConstants.BRIDGE);
        Resource traceResource = (Resource) context.get(IRequirementsImporterBridgeConstants.TRACE_RESOURCE);
        final IIncrementalBridgeExecution execution2 = (IIncrementalBridgeExecution) context
            .get(IRequirementsImporterBridgeConstants.BRIDGE_EXECUTION);

        IStatus result = bridge.mergeInteractively(execution2, new NullProgressMonitor());
        if (result == Status.CANCEL_STATUS) {
          throw new OperationCanceledException(result.getMessage());
        }

        // Save traces and output model
        save(execution2, traceResource, execution2.getTrace(), targetScope);

        TransactionHelper.getExecutionManager(traceResource).execute(new AbstractReadWriteCommand() {
          @Override
          public void run() {
            HoldingResourceHelper
                .flushHoldingResource(TransactionHelper.getEditingDomain(targetScope.getContents().get(0)));
          }
        });

      }
    });
    return Status.OK_STATUS;
  }

  /**
   * @param traceResource
   * @param trace
   */
  @SuppressWarnings("rawtypes")
  private void save(IIncrementalBridgeExecution execution, Resource traceResource, IBridgeTrace trace,
      IEditableModelScope targetScope) {

    try {
      // setTrace(traceResource, execution.getTrace());
      // compact(traceResource);
      traceResource.save(new HashMap());
      targetScope.getContents().get(0).eResource().save(new HashMap());
    } catch (IOException e) {
      e.printStackTrace();
    }

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
