/**
 *
 *  Copyright (c) 2017 THALES GLOBAL SERVICES.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */

package org.polarsys.kitalpha.vp.requirements.Requirements;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Data Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition#getSpecifiedValues <em>Specified Values</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getEnumerationDataTypeDefinition()
 * @model
 * @generated
 */

public interface EnumerationDataTypeDefinition extends DataTypeDefinition {

	/**
	 * Returns the value of the '<em><b>Specified Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumValue}.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specified Values</em>' containment reference list.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getEnumerationDataTypeDefinition_SpecifiedValues()
	 * @model containment="true"
	 * @generated
	 */

	EList<EnumValue> getSpecifiedValues();

} // EnumerationDataTypeDefinition
