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
package org.polarsys.capella.vp.requirements.importer.transposer.launcher;

import java.util.HashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.transition.common.context.TransitionContext;
import org.polarsys.capella.core.transition.common.launcher.ActivitiesLauncher;
import org.polarsys.capella.core.transition.common.launcher.IDefaultWorkflow;
import org.polarsys.capella.vp.requirements.importer.transposer.activities.InitializeTransformation;
import org.polarsys.capella.vp.requirements.importer.transposer.activities.TransposerTransformation;
import org.polarsys.capella.vp.requirements.importer.transposer.activities.TriggerDiffMerge;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.IRequirementsImporterBridgeConstants;
import org.polarsys.kitalpha.cadence.core.api.parameter.GenericParameter;
import org.polarsys.kitalpha.cadence.core.api.parameter.WorkflowActivityParameter;
import org.polarsys.kitalpha.transposer.api.ITransposerWorkflow;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * @author Joao Barata
 */
public class RequirementsImportLauncher extends ActivitiesLauncher {

  HashMap<String, String[]> activities = null;

  IContext context = new TransitionContext();

  public RequirementsImportLauncher() {
    activities = new HashMap<String, String[]>();
    activities.put(IDefaultWorkflow.WORKFLOW_STEP__INITIALIZATION, new String[] { InitializeTransformation.getId() });
    activities.put(IDefaultWorkflow.WORKFLOW_STEP__TRANSPOSITION, new String[] {});
    activities.put(IDefaultWorkflow.WORKFLOW_STEP__DIFF_MERGE, new String[] { TriggerDiffMerge.getId() });
    activities.put(IDefaultWorkflow.WORKFLOW_STEP__FINALIZATION, new String[] { TransposerTransformation.getId() });
  }

  public void launch(URI model, BlockArchitecture target, IProgressMonitor monitor) {
    context.put(IRequirementsImporterBridgeConstants.CONTEXT_MODEL, model);
    context.put(IRequirementsImporterBridgeConstants.TARGET_ELEMENT, target);
    triggerActivities(null, getWorkflow(), monitor);
  }

  @Override
  protected String getWorkflow() {
    return ITransposerWorkflow.TRANSPOSER_WORKFLOW;
  }

  @Override
  protected String[] getWorkflowElements(String workflowId) {
    return new String[] { IDefaultWorkflow.WORKFLOW_STEP__INITIALIZATION, IDefaultWorkflow.WORKFLOW_STEP__TRANSPOSITION,
                         IDefaultWorkflow.WORKFLOW_STEP__DIFF_MERGE };
  }

  @Override
  protected String[] getFinalWorkflowElements(String workflowId) {
    return new String[] { IDefaultWorkflow.WORKFLOW_STEP__FINALIZATION };
  }

  @Override
  protected WorkflowActivityParameter getParameter(String workflowId, String workflowElement) {
    return createParameter(activities.get(workflowElement));
  }

  protected WorkflowActivityParameter createParameter(String... ids) {
    WorkflowActivityParameter parameter = new WorkflowActivityParameter();

    GenericParameter<IContext> gContext = new GenericParameter<IContext>(ITransposerWorkflow.TRANSPOSER_CONTEXT, context, "context");
    for (String id : ids) {
      parameter.addActivity(getActivity(id));
      parameter.addParameter(getActivity(id), gContext);
    }

    return parameter;
  }
}
