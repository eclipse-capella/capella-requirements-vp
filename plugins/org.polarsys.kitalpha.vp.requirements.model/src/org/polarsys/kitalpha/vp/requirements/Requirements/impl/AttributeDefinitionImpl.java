/**
 *
 *  Copyright (c) 2016, 2019 THALES GLOBAL SERVICES.
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

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
	 * The cached value of the '{@link #getDefinitionType() <em>Definition Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionType()
	 * @generated
	 * @ordered
	 */
	protected DataTypeDefinition definitionType;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected Attribute defaultValue;

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

	@Override
	public DataTypeDefinition getDefinitionType() {

		if (definitionType != null && definitionType.eIsProxy()) {
			InternalEObject oldDefinitionType = (InternalEObject) definitionType;
			definitionType = (DataTypeDefinition) eResolveProxy(oldDefinitionType);
			if (definitionType != oldDefinitionType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RequirementsPackage.ATTRIBUTE_DEFINITION__DEFINITION_TYPE, oldDefinitionType,
							definitionType));
			}
		}
		return definitionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public DataTypeDefinition basicGetDefinitionType() {

		return definitionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setDefinitionType(DataTypeDefinition newDefinitionType) {

		DataTypeDefinition oldDefinitionType = definitionType;
		definitionType = newDefinitionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.ATTRIBUTE_DEFINITION__DEFINITION_TYPE, oldDefinitionType, definitionType));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public Attribute getDefaultValue() {

		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public NotificationChain basicSetDefaultValue(Attribute newDefaultValue, NotificationChain msgs) {

		Attribute oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE, oldDefaultValue, newDefaultValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}

		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setDefaultValue(Attribute newDefaultValue) {

		if (newDefaultValue != defaultValue) {
			NotificationChain msgs = null;
			if (defaultValue != null)
				msgs = ((InternalEObject) defaultValue).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE, null, msgs);
			if (newDefaultValue != null)
				msgs = ((InternalEObject) newDefaultValue).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE, null, msgs);
			msgs = basicSetDefaultValue(newDefaultValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE, newDefaultValue, newDefaultValue));

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
			return definitionType != null;
		case RequirementsPackage.ATTRIBUTE_DEFINITION__DEFAULT_VALUE:
			return defaultValue != null;
		}
		return super.eIsSet(featureID);
	}

} //AttributeDefinitionImpl