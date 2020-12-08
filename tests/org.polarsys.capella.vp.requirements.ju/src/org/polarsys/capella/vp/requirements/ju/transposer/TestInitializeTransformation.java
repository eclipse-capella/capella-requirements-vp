/*******************************************************************************
 * Copyright (c) 2018, 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ju.transposer;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.api.IBridge;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace;
import org.eclipse.emf.diffmerge.diffdata.EComparison;
import org.eclipse.emf.diffmerge.generic.api.IMergeSelector;
import org.eclipse.emf.diffmerge.generic.api.Role;
import org.eclipse.emf.diffmerge.generic.api.diff.IDifference;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.vp.requirements.importer.transposer.activities.InitializeTransformation;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementsVPBridge;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFImporterDiffPolicy;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFMergePolicy;
import org.polarsys.kitalpha.cadence.core.api.parameter.ActivityParameters;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

public class TestInitializeTransformation extends InitializeTransformation {
  public static final String DIFFERENCES_FROM_REFERENCE_SCOPE = "DIFFERENCES_FROM_REFERENCE_SCOPE";
  public static final String DIFFERENCES_FROM_TARGET_SCOPE = "DIFFERENCES_FROM_TARGET_SCOPE";
  Collection<IDifference<EObject>> differencesFromReferenceScope;
  Collection<IDifference<EObject>> differencesFromTargetScope;

  public static String getId() {
    return TestInitializeTransformation.class.getCanonicalName();
  }

  @Override
  protected RequirementsVPBridge createBridge(IEditableModelScope sourceScope, IEditableModelScope targetScope,
      IBridge<IEditableModelScope, IEditableModelScope> bridge) {

    IMergeSelector<EObject> selector = new IMergeSelector<EObject>() {
      /**
       * @see org.eclipse.emf.diffmerge.api.IMergeSelector#getMergeDirection(org.eclipse.emf.diffmerge.api.diff.IDifference)
       */
      @Override
      public Role getMergeDirection(IDifference<EObject> difference_p) {
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
