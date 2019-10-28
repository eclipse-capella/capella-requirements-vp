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

package org.polarsys.kitalpha.vp.requirements.Requirements.impl;

import org.eclipse.emf.ecore.EClass;
import org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Value Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.BooleanValueAttributeImpl#isValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanValueAttributeImpl extends AttributeImpl implements BooleanValueAttribute {

	/**
	 * The default value of the '{@link #isValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALUE_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanValueAttributeImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.BOOLEAN_VALUE_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public boolean isValue() {

		return (Boolean) eDynamicGet(RequirementsPackage.BOOLEAN_VALUE_ATTRIBUTE__VALUE,
				RequirementsPackage.Literals.BOOLEAN_VALUE_ATTRIBUTE__VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setValue(boolean newValue) {

		eDynamicSet(RequirementsPackage.BOOLEAN_VALUE_ATTRIBUTE__VALUE,
				RequirementsPackage.Literals.BOOLEAN_VALUE_ATTRIBUTE__VALUE, newValue);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementsPackage.BOOLEAN_VALUE_ATTRIBUTE__VALUE:
			return isValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RequirementsPackage.BOOLEAN_VALUE_ATTRIBUTE__VALUE:
			setValue((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case RequirementsPackage.BOOLEAN_VALUE_ATTRIBUTE__VALUE:
			setValue(VALUE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case RequirementsPackage.BOOLEAN_VALUE_ATTRIBUTE__VALUE:
			return isValue() != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //BooleanValueAttributeImpl