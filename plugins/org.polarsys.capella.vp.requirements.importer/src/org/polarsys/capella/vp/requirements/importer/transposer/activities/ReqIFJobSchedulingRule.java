/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.jobs.ISchedulingRule;

/**
 * This rule is used to ensure that ReqIF import jobs are launched in order
 */
public class ReqIFJobSchedulingRule implements ISchedulingRule {
  private static ReqIFJobSchedulingRule INSTANCE;

  public static ReqIFJobSchedulingRule getInstance() {
    if (INSTANCE == null)
      INSTANCE = new ReqIFJobSchedulingRule();
    return INSTANCE;
  }

  public boolean isConflicting(ISchedulingRule rule) {
    if (rule == this)
      return true;
    // Resource saving threads should not be run in concurrence with ReqIF jobs
    if (rule instanceof IResource) {
      return true;
    }
    return false;
  }

  public boolean contains(ISchedulingRule rule) {
    return isConflicting(rule);
  }
}
