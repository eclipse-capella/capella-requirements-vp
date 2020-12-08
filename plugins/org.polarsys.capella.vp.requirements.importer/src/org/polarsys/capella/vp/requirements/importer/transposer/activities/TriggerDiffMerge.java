/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.polarsys.capella.core.transition.common.activities.AbstractActivity;
import org.polarsys.kitalpha.cadence.core.api.parameter.ActivityParameters;

/**
 * @author Joao Barata
 */
public class TriggerDiffMerge extends AbstractActivity {

  public static final String getId() {
    return TriggerDiffMerge.class.getCanonicalName();
  }

  @Override
  protected IStatus _run(ActivityParameters activityParams) {
	 
    return Status.OK_STATUS;
  }

}
