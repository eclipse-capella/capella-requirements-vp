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

import org.eclipse.emf.ecore.EClass;
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
	 * The default value of the '{@link #getDefinitionProxy() <em>Definition Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinitionProxy()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFINITION_PROXY_EDEFAULT = null;

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

		return (AttributeDefinition) eDynamicGet(RequirementsPackage.ATTRIBUTE__DEFINITION,
				RequirementsPackage.Literals.ATTRIBUTE__DEFINITION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public AttributeDefinition basicGetDefinition() {

		return (AttributeDefinition) eDynamicGet(RequirementsPackage.ATTRIBUTE__DEFINITION,
				RequirementsPackage.Literals.ATTRIBUTE__DEFINITION, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setDefinition(AttributeDefinition newDefinition) {

		eDynamicSet(RequirementsPackage.ATTRIBUTE__DEFINITION, RequirementsPackage.Literals.ATTRIBUTE__DEFINITION,
				newDefinition);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getDefinitionProxy() {

		return (String) eDynamicGet(RequirementsPackage.ATTRIBUTE__DEFINITION_PROXY,
				RequirementsPackage.Literals.ATTRIBUTE__DEFINITION_PROXY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setDefinitionProxy(String newDefinitionProxy) {

		eDynamicSet(RequirementsPackage.ATTRIBUTE__DEFINITION_PROXY,
				RequirementsPackage.Literals.ATTRIBUTE__DEFINITION_PROXY, newDefinitionProxy);

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
			return basicGetDefinition() != null;
		case RequirementsPackage.ATTRIBUTE__DEFINITION_PROXY:
			return DEFINITION_PROXY_EDEFAULT == null ? getDefinitionProxy() != null
					: !DEFINITION_PROXY_EDEFAULT.equals(getDefinitionProxy());
		}
		return super.eIsSet(featureID);
	}

} //AttributeImpl