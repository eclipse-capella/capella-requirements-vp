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
	 * The cached value of the '{@link #getRelationType() <em>Relation Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationType()
	 * @generated
	 * @ordered
	 */
	protected RelationType relationType;

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
	 * The cached value of the '{@link #getRelationTypeProxy() <em>Relation Type Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationTypeProxy()
	 * @generated
	 * @ordered
	 */
	protected String relationTypeProxy = RELATION_TYPE_PROXY_EDEFAULT;

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

		if (relationType != null && relationType.eIsProxy()) {
			InternalEObject oldRelationType = (InternalEObject) relationType;
			relationType = (RelationType) eResolveProxy(oldRelationType);
			if (relationType != oldRelationType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE, oldRelationType, relationType));
			}
		}
		return relationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public RelationType basicGetRelationType() {

		return relationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setRelationType(RelationType newRelationType) {

		RelationType oldRelationType = relationType;
		relationType = newRelationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE,
					oldRelationType, relationType));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getRelationTypeProxy() {

		return relationTypeProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setRelationTypeProxy(String newRelationTypeProxy) {

		String oldRelationTypeProxy = relationTypeProxy;
		relationTypeProxy = newRelationTypeProxy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE_PROXY, oldRelationTypeProxy,
					relationTypeProxy));

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
			return relationType != null;
		case RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE_PROXY:
			return RELATION_TYPE_PROXY_EDEFAULT == null ? relationTypeProxy != null
					: !RELATION_TYPE_PROXY_EDEFAULT.equals(relationTypeProxy);
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
		result.append(" (relationTypeProxy: "); //$NON-NLS-1$
		result.append(relationTypeProxy);
		result.append(')');
		return result.toString();
	}

} //AbstractRelationImpl