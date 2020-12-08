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

package org.polarsys.capella.vp.requirements.business.queries;

import org.eclipse.emf.ecore.EClass;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public class RealValueAttribute_Definition_AttributeDefinition extends AbstractAttribute_Definition_AttributeDefinition {

  @Override
  public EClass getEClass() {
    return RequirementsPackage.Literals.REAL_VALUE_ATTRIBUTE;
  }
}
