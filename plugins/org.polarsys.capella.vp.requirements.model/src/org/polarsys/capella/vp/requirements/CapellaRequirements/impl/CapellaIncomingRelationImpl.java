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

package org.polarsys.capella.vp.requirements.CapellaRequirements.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.polarsys.capella.core.data.capellacore.CapellaElement;

import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;

import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Capella Incoming Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaIncomingRelationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaIncomingRelationImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CapellaIncomingRelationImpl extends CapellaRelationImpl implements CapellaIncomingRelation {

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Requirement source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected CapellaElement target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CapellaIncomingRelationImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public Requirement getSource() {

		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (Requirement) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public Requirement basicGetSource() {

		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setSource(Requirement newSource) {

		Requirement oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE, oldSource, source));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public CapellaElement getTarget() {

		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) target;
			target = (CapellaElement) eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public CapellaElement basicGetTarget() {

		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setTarget(CapellaElement newTarget) {

		CapellaElement oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET, oldTarget, target));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET:
			if (resolve)
				return getTarget();
			return basicGetTarget();
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
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE:
			setSource((Requirement) newValue);
			return;
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET:
			setTarget((CapellaElement) newValue);
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
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE:
			setSource((Requirement) null);
			return;
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET:
			setTarget((CapellaElement) null);
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
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE:
			return source != null;
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET:
			return target != null;
		}
		return super.eIsSet(featureID);
	}

} //CapellaIncomingRelationImpl