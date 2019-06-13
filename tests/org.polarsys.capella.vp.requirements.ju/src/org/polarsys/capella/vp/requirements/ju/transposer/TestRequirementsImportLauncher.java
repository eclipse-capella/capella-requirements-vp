/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ju.transposer;

import org.polarsys.capella.core.transition.common.launcher.IDefaultWorkflow;
import org.polarsys.capella.vp.requirements.importer.transposer.activities.TriggerDiffMerge;
import org.polarsys.capella.vp.requirements.importer.transposer.launcher.RequirementsImportLauncher;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * @author Joao Barata
 */
public class TestRequirementsImportLauncher extends RequirementsImportLauncher {

  public TestRequirementsImportLauncher() {
    super();
    activities.put(IDefaultWorkflow.WORKFLOW_STEP__INITIALIZATION,
        new String[] { TestInitializeTransformation.getId() });
    activities.put(IDefaultWorkflow.WORKFLOW_STEP__DIFF_MERGE,
        new String[] { TriggerDiffMerge.getId(), TestTransposerTransformation.getId() });
  }

  public IContext getContext() {
    return context;
  }
}
