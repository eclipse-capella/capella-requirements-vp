/**
 *
 *  Copyright (c) 2017, 2019 THALES GLOBAL SERVICES.
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
 * A representation of the model object '<em><b>Enumeration Value Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getEnumerationValueAttribute()
 * @model
 * @generated
 */

public interface EnumerationValueAttribute extends Attribute {

	/**
	 * Returns the value of the '<em><b>Values</b></em>' reference list.
	 * The list contents are of type {@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumValue}.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' reference list.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getEnumerationValueAttribute_Values()
	 * @model
	 * @generated
	 */

	EList<EnumValue> getValues();

} // EnumerationValueAttribute
