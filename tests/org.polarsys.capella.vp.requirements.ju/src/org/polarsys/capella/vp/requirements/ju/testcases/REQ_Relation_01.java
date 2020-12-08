/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ju.testcases;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.test.framework.api.OracleDefinition;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;

public class REQ_Relation_01 extends RequirementValidationRuleTestCase {

	@Override
	protected String getRequiredTestModel() {
		return "validation"; //$NON-NLS-1$
	}

	@Override
	protected EClass getTargetedEClass() {
		return CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION;
	}

	@Override
	protected String getRuleID() {
		return "org.polarsys.capella.vp.requirements.validation.REQ_Relation_01"; //$NON-NLS-1$
	}

	@Override
	protected List<OracleDefinition> getOracleDefinitions() {
		return Arrays.asList(new OracleDefinition [] {
				new OracleDefinition("33550190-9e41-44cb-9cc0-a041f510865c", 1) //$NON-NLS-1$
			});
	}

}
