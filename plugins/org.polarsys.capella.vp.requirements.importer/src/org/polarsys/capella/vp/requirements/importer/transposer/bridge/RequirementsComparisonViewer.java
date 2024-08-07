/*******************************************************************************
 * Copyright (c) 2017, 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import java.util.List;

import org.eclipse.emf.diffmerge.bridge.interactive.UpdateViewer;
import org.eclipse.emf.diffmerge.generic.api.IMatch;
import org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode;
import org.eclipse.emf.diffmerge.ui.viewers.MergeChoiceData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;

public class RequirementsComparisonViewer extends UpdateViewer {

  public RequirementsComparisonViewer(Composite parent) {
    this(parent, null);
  }

  public RequirementsComparisonViewer(Composite parent, IActionBars actionBars) {
    super(parent, actionBars);
  }

  @Override
  protected void makeMergeChoices(MergeChoiceData choices, EMFDiffNode input, List<IMatch<?>> selectedMatches,
      boolean acceptIncrementalMode) {
    // Make the following choices checked by default
    choices.setIncrementalMode(true);
    choices.setShowImpact(true);
    super.makeMergeChoices(choices, input, selectedMatches, acceptIncrementalMode);
  }
}
