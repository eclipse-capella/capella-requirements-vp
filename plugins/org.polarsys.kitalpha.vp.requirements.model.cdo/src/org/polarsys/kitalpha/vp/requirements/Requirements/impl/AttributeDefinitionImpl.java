/**
 *
 *  Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */

package org.polarsys.kitalpha.vp.requirements.Requirements.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeDefinitionImpl#getDefinitionType <em>Definition Type</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeDefinitionImpl#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeDefinitionImpl extends ReqIFElementImpl implements AttributeDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeDefinitionImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.ATTRIBUTE_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public DataTypeDefinition getDefinitionType() {

		return (DataTypeDefinition) eDynamicGet(RequirementsPackage.ATTRIBUTE_DEFINITION__DEFINITION_TYPE,
				RequirementsPackage.Literals.ATTRIBUTE_DEFINITION__DEFINITION_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public DataTypeDefinition basicGetDefinitionType() {

		return (DataTypeDefinition) eDynamicGet(RequirementsPackage.ATTRIBUTE_DEFINITION__DEFINITION_TYPE,
				RequirementsPackage.Literals.ATTRIBUTE_DEFINITION__DEFINITION_TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setDefinitionType(DataTypeDefinition newDefinitionType) {

		eDynamicSet(RequirementsPackage.ATTRIBUTE_DEFINITION__DEFINITION_TYPE,
				RequirementsPackage.Literals.ATTRIBUTE_DEFINITION__DEFINITION_TYPE, newDefinitionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public Attribute getDefaultValue() {

		return (Attribute) eDynamicGet(RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE,
				RequirementsPackage.Literals.ATTRIBUTE_DEFINITION__DEFAULT_VALUE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public NotificationChain basicSetDefaultValue(Attribute newDefaultValue, NotificationChain msgs) {

		msgs = eDynamicInverseAdd((InternalEObject) newDefaultValue,
				RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE, msgs);

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setDefaultValue(Attribute newDefaultValue) {

		eDynamicSet(RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE,
				RequirementsPackage.Literals.ATTRIBUTE_DEFINITION__DEFAULT_VALUE, newDefaultValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE:
			return basicSetDefaultValue(null, msgs);
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
		case RequirementsPackage.ATTRIBUTE_DEFINITION__DEFINITION_TYPE:
			if (resolve)
				return getDefinitionType();
			return basicGetDefinitionType();
		case RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE:
			return getDefaultValue();
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
		case RequirementsPackage.ATTRIBUTE_DEFINITION__DEFINITION_TYPE:
			setDefinitionType((DataTypeDefinition) newValue);
			return;
		case RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE:
			setDefaultValue((Attribute) newValue);
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
		case RequirementsPackage.ATTRIBUTE_DEFINITION__DEFINITION_TYPE:
			setDefinitionType((DataTypeDefinition) null);
			return;
		case RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE:
			setDefaultValue((Attribute) null);
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
		case RequirementsPackage.ATTRIBUTE_DEFINITION__DEFINITION_TYPE:
			return basicGetDefinitionType() != null;
		case RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE:
			return getDefaultValue() != null;
		}
		return super.eIsSet(featureID);
	}

} //AttributeDefinitionImpl