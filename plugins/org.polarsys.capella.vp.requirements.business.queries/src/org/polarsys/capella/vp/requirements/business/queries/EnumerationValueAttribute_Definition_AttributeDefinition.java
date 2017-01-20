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

package org.polarsys.capella.vp.requirements.business.queries;

import org.eclipse.emf.ecore.EClass;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public class EnumerationValueAttribute_Definition_AttributeDefinition extends AbstractAttribute_Definition_AttributeDefinition {

  @Override
  public EClass getEClass() {
    return RequirementsPackage.Literals.ENUMERATION_VALUE_ATTRIBUTE;
  }
}
