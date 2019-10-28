/**
 *
 *  Copyright (c) 2016, 2019 THALES GLOBAL SERVICES.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */

package org.polarsys.kitalpha.vp.requirements.Requirements;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Value Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getIntegerValueAttribute()
 * @model
 * @generated
 */

public interface IntegerValueAttribute extends Attribute {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getIntegerValueAttribute_Value()
	 * @model
	 * @generated
	 */

	int getValue();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute#getValue <em>Value</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */

	void setValue(int value);

} // IntegerValueAttribute
