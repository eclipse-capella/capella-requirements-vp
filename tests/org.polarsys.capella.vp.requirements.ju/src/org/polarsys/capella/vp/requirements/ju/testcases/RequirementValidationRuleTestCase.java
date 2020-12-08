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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.common.re.ReAbstractElement;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.libraries.model.ICapellaModel;
import org.polarsys.capella.test.framework.api.OracleDefinition;
import org.polarsys.capella.test.validation.rules.ju.testcases.ValidationRuleTestCase;
import org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement;

public class RequirementValidationRuleTestCase extends ValidationRuleTestCase {

  @Override
  protected String getRequiredTestModel() {
    return null;
  }

  @Override
  protected EClass getTargetedEClass() {
    return null;
  }

  @Override
  protected String getRuleID() {
    return null;
  }

  @Override
  protected List<OracleDefinition> getOracleDefinitions() {
    return null;
  }

  /**
   * Override this method to include Requirement viewpoint elements to test scope
   */
  @Override
  protected List<EObject> getTestScope(ICapellaModel model) {
    List<EObject> scope = new ArrayList<EObject>();
    Project project = model.getProject(getSessionForTestModel(getRequiredTestModel()).getTransactionalEditingDomain());
    if (project != null) {
      for (EObject object : EObjectExt.getAll(project, targetedEClass)) {
        if (object instanceof CapellaElement || object instanceof ReAbstractElement || object instanceof IdentifiableElement) {
        scope.add(object);
        }
      }
    }
    return scope;
  }
  
  /**
   * Override this method to get id from Requirement viewpoint elements
   */
  @Override
  protected String getId(EObject object) {
    if (object instanceof CapellaElement) {
      return ((CapellaElement) object).getId();
    }
    if (object instanceof ReAbstractElement) {
      return ((ReAbstractElement) object).getId();
    }
    if (object instanceof IdentifiableElement) {
      return ((IdentifiableElement) object).getId();
    }
    throw new IllegalArgumentException(object.eClass().getName() + "is not supported as a validation targeted EClass");
  }
}
