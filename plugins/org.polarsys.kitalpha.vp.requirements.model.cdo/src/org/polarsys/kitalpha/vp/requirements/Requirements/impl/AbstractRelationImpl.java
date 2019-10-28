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
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractRelationImpl#getRelationType <em>Relation Type</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractRelationImpl#getRelationTypeProxy <em>Relation Type Proxy</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractRelationImpl extends ReqIFElementImpl implements AbstractRelation {

	/**
	 * The default value of the '{@link #getRelationTypeProxy() <em>Relation Type Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationTypeProxy()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATION_TYPE_PROXY_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractRelationImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.ABSTRACT_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public RelationType getRelationType() {

		return (RelationType) eDynamicGet(RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE,
				RequirementsPackage.Literals.ABSTRACT_RELATION__RELATION_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public RelationType basicGetRelationType() {

		return (RelationType) eDynamicGet(RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE,
				RequirementsPackage.Literals.ABSTRACT_RELATION__RELATION_TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setRelationType(RelationType newRelationType) {

		eDynamicSet(RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE,
				RequirementsPackage.Literals.ABSTRACT_RELATION__RELATION_TYPE, newRelationType);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getRelationTypeProxy() {

		return (String) eDynamicGet(RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE_PROXY,
				RequirementsPackage.Literals.ABSTRACT_RELATION__RELATION_TYPE_PROXY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setRelationTypeProxy(String newRelationTypeProxy) {

		eDynamicSet(RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE_PROXY,
				RequirementsPackage.Literals.ABSTRACT_RELATION__RELATION_TYPE_PROXY, newRelationTypeProxy);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE:
			if (resolve)
				return getRelationType();
			return basicGetRelationType();
		case RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE_PROXY:
			return getRelationTypeProxy();
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
		case RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE:
			setRelationType((RelationType) newValue);
			return;
		case RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE_PROXY:
			setRelationTypeProxy((String) newValue);
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
		case RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE:
			setRelationType((RelationType) null);
			return;
		case RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE_PROXY:
			setRelationTypeProxy(RELATION_TYPE_PROXY_EDEFAULT);
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
		case RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE:
			return basicGetRelationType() != null;
		case RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE_PROXY:
			return RELATION_TYPE_PROXY_EDEFAULT == null ? getRelationTypeProxy() != null
					: !RELATION_TYPE_PROXY_EDEFAULT.equals(getRelationTypeProxy());
		}
		return super.eIsSet(featureID);
	}

} //AbstractRelationImpl