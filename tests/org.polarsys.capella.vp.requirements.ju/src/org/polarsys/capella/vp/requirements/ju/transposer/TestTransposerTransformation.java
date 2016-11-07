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
package org.polarsys.capella.vp.requirements.ju.transposer;

import org.eclipse.emf.diffmerge.api.IMergeSelector;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.api.IBridge;
import org.polarsys.capella.core.compare.CapellaMergePolicy;
import org.polarsys.capella.vp.requirements.importer.transposer.activities.TransposerTransformation;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementsVPBridge;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFImporterDiffPolicy;

/**
 * @author Joao Barata
 */
public class TestTransposerTransformation extends TransposerTransformation {

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

    return new RequirementsVPBridge(targetScope, bridge, new ReqIFImporterDiffPolicy(), new CapellaMergePolicy(), selector) {
      @Override
      protected boolean isAlwaysInteractive() {
        return false;
      }
    };
  }
}
