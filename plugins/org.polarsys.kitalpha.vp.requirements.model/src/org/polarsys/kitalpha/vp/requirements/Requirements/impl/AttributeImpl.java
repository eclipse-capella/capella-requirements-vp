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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeImpl#getDefinitionProxy <em>Definition Proxy</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AttributeImpl extends IdentifiableElementImpl implements Attribute {

	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected AttributeDefinition definition;

	/**
	 * The default value of the '{@link #getDefinitionProxy() <em>Definition Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionProxy()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFINITION_PROXY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefinitionProxy() <em>Definition Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionProxy()
	 * @generated
	 * @ordered
	 */
	protected String definitionProxy = DEFINITION_PROXY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public AttributeDefinition getDefinition() {

		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject) definition;
			definition = (AttributeDefinition) eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.ATTRIBUTE__DEFINITION,
							oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public AttributeDefinition basicGetDefinition() {

		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setDefinition(AttributeDefinition newDefinition) {

		AttributeDefinition oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.ATTRIBUTE__DEFINITION,
					oldDefinition, definition));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getDefinitionProxy() {

		return definitionProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setDefinitionProxy(String newDefinitionProxy) {

		String oldDefinitionProxy = definitionProxy;
		definitionProxy = newDefinitionProxy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.ATTRIBUTE__DEFINITION_PROXY,
					oldDefinitionProxy, definitionProxy));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementsPackage.ATTRIBUTE__DEFINITION:
			if (resolve)
				return getDefinition();
			return basicGetDefinition();
		case RequirementsPackage.ATTRIBUTE__DEFINITION_PROXY:
			return getDefinitionProxy();
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
		case RequirementsPackage.ATTRIBUTE__DEFINITION:
			setDefinition((AttributeDefinition) newValue);
			return;
		case RequirementsPackage.ATTRIBUTE__DEFINITION_PROXY:
			setDefinitionProxy((String) newValue);
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
		case RequirementsPackage.ATTRIBUTE__DEFINITION:
			setDefinition((AttributeDefinition) null);
			return;
		case RequirementsPackage.ATTRIBUTE__DEFINITION_PROXY:
			setDefinitionProxy(DEFINITION_PROXY_EDEFAULT);
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
		case RequirementsPackage.ATTRIBUTE__DEFINITION:
			return definition != null;
		case RequirementsPackage.ATTRIBUTE__DEFINITION_PROXY:
			return DEFINITION_PROXY_EDEFAULT == null ? definitionProxy != null
					: !DEFINITION_PROXY_EDEFAULT.equals(definitionProxy);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (definitionProxy: "); //$NON-NLS-1$
		result.append(definitionProxy);
		result.append(')');
		return result.toString();
	}

} //AttributeImpl