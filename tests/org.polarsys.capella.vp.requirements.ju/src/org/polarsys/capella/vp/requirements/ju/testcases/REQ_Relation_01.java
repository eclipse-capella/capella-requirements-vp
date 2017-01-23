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
				new OracleDefinition("e0855458-3563-4c36-8793-d33c35ecfd3a", 1) //$NON-NLS-1$
			});
	}

}
