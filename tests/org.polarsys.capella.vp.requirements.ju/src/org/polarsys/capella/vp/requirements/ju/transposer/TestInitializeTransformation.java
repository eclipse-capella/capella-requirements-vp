/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
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
import org.polarsys.capella.vp.requirements.importer.transposer.activities.InitializeTransformation;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementsVPBridge;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFImporterDiffPolicy;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFMergePolicy;
import org.polarsys.kitalpha.cadence.core.api.parameter.ActivityParameters;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

public class TestInitializeTransformation extends InitializeTransformation {
  public static final String DIFFERENCES_FROM_REFERENCE_SCOPE = "DIFFERENCES_FROM_REFERENCE_SCOPE";
  public static final String DIFFERENCES_FROM_TARGET_SCOPE = "DIFFERENCES_FROM_TARGET_SCOPE";
  List<IDifference> differencesFromReferenceScope;
  List<IDifference> differencesFromTargetScope;

  public static String getId() {
    return TestInitializeTransformation.class.getCanonicalName();
  }

  @Override
  protected RequirementsVPBridge createBridge(IEditableModelScope sourceScope, IEditableModelScope targetScope,
      IBridge<IEditableModelScope, IEditableModelScope> bridge) {

    IMergeSelector selector = new IMergeSelector() {
      /**
       * @see org.eclipse.emf.diffmerge.api.IMergeSelector#getMergeDirection(org.eclipse.emf.diffmerge.api.diff.IDifference)
       */
      @Override
      public Role getMergeDirection(IDifference difference_p) {
        return Role.TARGET;
      }
    };

    return new RequirementsVPBridge(sourceScope, targetScope, bridge, new ReqIFImporterDiffPolicy(),
        new ReqIFMergePolicy(), selector) {
      @Override
      protected boolean isAlwaysInteractive() {
        return false;
      }

      @Override
      protected EComparison compare(IEditableModelScope created, IEditableModelScope existing,
          IBridgeTrace createdTrace, IBridgeTrace existingTrace, IProgressMonitor monitor) {
        EComparison compare = super.compare(created, existing, createdTrace, existingTrace, monitor);
        differencesFromReferenceScope = compare.getDifferences(Role.REFERENCE);
        differencesFromTargetScope = compare.getDifferences(Role.TARGET);
        return compare;
      }
    };
  }

  @Override
  protected IStatus _run(ActivityParameters activityParams) {
    // Override this to avoid launching the activity in a Job in testing mode
    IStatus status = initializeTransformation(activityParams);

    IContext context = getContext(activityParams);
    context.put(DIFFERENCES_FROM_REFERENCE_SCOPE, differencesFromReferenceScope);
    context.put(DIFFERENCES_FROM_TARGET_SCOPE, differencesFromTargetScope);

    return status;
  }
}
