/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import java.util.List;

import org.eclipse.emf.diffmerge.bridge.interactive.BridgeComparisonViewer;
import org.eclipse.emf.diffmerge.diffdata.EMatch;
import org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode;
import org.eclipse.emf.diffmerge.ui.viewers.MergeChoiceData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;

public class RequirementsComparisonViewer extends BridgeComparisonViewer {


  public RequirementsComparisonViewer(Composite parent) {
    this(parent,  null);
  }

  public RequirementsComparisonViewer(Composite parent, IActionBars actionBars) {
    super(parent, actionBars);
  }
  
  @Override
  protected void makeMergeChoices(MergeChoiceData choices, EMFDiffNode input, List<EMatch> selectedMatches,
      boolean acceptIncrementalMode) {
    // Make the following choices checked by default
    choices.setIncrementalMode(true);
    choices.setShowImpact(true);
    super.makeMergeChoices(choices, input, selectedMatches, acceptIncrementalMode);
  }
}
