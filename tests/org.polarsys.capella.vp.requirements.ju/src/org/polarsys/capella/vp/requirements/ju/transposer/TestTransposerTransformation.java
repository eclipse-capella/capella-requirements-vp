/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ju.transposer;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.diffmerge.api.IMergeSelector;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.api.IBridge;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace;
import org.eclipse.emf.diffmerge.diffdata.EComparison;
import org.polarsys.capella.vp.requirements.importer.transposer.activities.TransposerTransformation;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementsVPBridge;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFImporterDiffPolicy;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFMergePolicy;
import org.polarsys.kitalpha.cadence.core.api.parameter.ActivityParameters;

/**
 * @author Joao Barata
 */
public class TestTransposerTransformation extends TransposerTransformation {
  public static final String COMPARE_RESULT = "COMPARE_RESULT";
  List<IDifference> differencesFromReferenceScope;
  

  public static String getId() {
    return TestTransposerTransformation.class.getCanonicalName();
  }

  protected RequirementsVPBridge createBridge(IEditableModelScope targetScope, IBridge<IEditableModelScope, IEditableModelScope> bridge) {

    IMergeSelector selector = new IMergeSelector() {
      /**
       * @see org.eclipse.emf.diffmerge.api.IMergeSelector#getMergeDirection(org.eclipse.emf.diffmerge.api.diff.IDifference)
       */
      public Role getMergeDirection(IDifference difference_p) {
        return Role.TARGET;
      }
    };

    return new RequirementsVPBridge(targetScope, bridge, new ReqIFImporterDiffPolicy(), new ReqIFMergePolicy(), selector) {
      @Override
      protected boolean isAlwaysInteractive() {
        return false;
      }
      
      protected EComparison compare(IEditableModelScope created, IEditableModelScope existing,
          IBridgeTrace createdTrace, IBridgeTrace existingTrace, IProgressMonitor monitor) {
        EComparison compare = super.compare(created, existing, createdTrace, existingTrace, monitor);
        differencesFromReferenceScope = compare.getDifferences(Role.REFERENCE);
        return compare;
      }
    };
  }
  
  protected IStatus _run(ActivityParameters activityParams) {
    IStatus status = super._run(activityParams);
    getContext(activityParams).put(COMPARE_RESULT, differencesFromReferenceScope);
    return status;
  }
}
