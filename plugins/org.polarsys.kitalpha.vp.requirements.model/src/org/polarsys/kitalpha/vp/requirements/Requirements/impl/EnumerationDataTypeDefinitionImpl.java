/**
 *
 *  Copyright (c) 2017, 2019 THALES GLOBAL SERVICES.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */

package org.polarsys.kitalpha.vp.requirements.Requirements.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.polarsys.kitalpha.vp.requirements.Requirements.EnumValue;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Data Type Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumerationDataTypeDefinitionImpl#getSpecifiedValues <em>Specified Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumerationDataTypeDefinitionImpl extends DataTypeDefinitionImpl implements EnumerationDataTypeDefinition {

	/**
	 * The cached value of the '{@link #getSpecifiedValues() <em>Specified Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiedValues()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumValue> specifiedValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationDataTypeDefinitionImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.ENUMERATION_DATA_TYPE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public EList<EnumValue> getSpecifiedValues() {

		if (specifiedValues == null) {
			specifiedValues = new EObjectContainmentEList<EnumValue>(EnumValue.class, this,
					RequirementsPackage.ENUMERATION_DATA_TYPE_DEFINITION__SPECIFIED_VALUES);
		}
		return specifiedValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementsPackage.ENUMERATION_DATA_TYPE_DEFINITION__SPECIFIED_VALUES:
			return ((InternalEList<?>) getSpecifiedValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementsPackage.ENUMERATION_DATA_TYPE_DEFINITION__SPECIFIED_VALUES:
			return getSpecifiedValues();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RequirementsPackage.ENUMERATION_DATA_TYPE_DEFINITION__SPECIFIED_VALUES:
			getSpecifiedValues().clear();
			getSpecifiedValues().addAll((Collection<? extends EnumValue>) newValue);
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
		case RequirementsPackage.ENUMERATION_DATA_TYPE_DEFINITION__SPECIFIED_VALUES:
			getSpecifiedValues().clear();
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
		case RequirementsPackage.ENUMERATION_DATA_TYPE_DEFINITION__SPECIFIED_VALUES:
			return specifiedValues != null && !specifiedValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnumerationDataTypeDefinitionImpl