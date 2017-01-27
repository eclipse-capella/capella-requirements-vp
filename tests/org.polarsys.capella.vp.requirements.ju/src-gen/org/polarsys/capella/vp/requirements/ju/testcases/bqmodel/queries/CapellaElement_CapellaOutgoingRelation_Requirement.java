/*******************************************************************************
 * Copyright (c) 2006, 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries;

import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.test.business.queries.ju.BQTestCase;

/**
 * @generated
 */
public class CapellaElement_CapellaOutgoingRelation_Requirement extends BQTestCase {

  /**
   * @generated
   */
  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(new String[] { "bqlibrary", "bqmodel" });
  }
  
	/**
	 * @generated
	 */
	public String getProjectForTest() {
		return "bqmodel"; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	@Override
	public String getBQFullQualifiedName() {
		return "org.polarsys.capella.vp.requirements.business.queries.CapellaElement_CapellaOutgoingRelation_Requirement"; //$NON-NLS-1$
	}

}
