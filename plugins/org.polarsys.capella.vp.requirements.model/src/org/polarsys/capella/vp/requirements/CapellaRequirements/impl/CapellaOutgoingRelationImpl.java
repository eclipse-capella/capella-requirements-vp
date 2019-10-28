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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.polarsys.capella.core.data.capellacore.CapellaElement;

import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;

import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.emde.model.EmdePackage;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Capella Outgoing Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaOutgoingRelationImpl#getOwnedExtensions <em>Owned Extensions</em>}</li>
 *   <li>{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaOutgoingRelationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaOutgoingRelationImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CapellaOutgoingRelationImpl extends CapellaRelationImpl implements CapellaOutgoingRelation {

	/**
	 * The cached value of the '{@link #getOwnedExtensions() <em>Owned Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementExtension> ownedExtensions;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected CapellaElement source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Requirement target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CapellaOutgoingRelationImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public EList<ElementExtension> getOwnedExtensions() {

		if (ownedExtensions == null) {
			ownedExtensions = new EObjectContainmentEList<ElementExtension>(ElementExtension.class, this,
					CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__OWNED_EXTENSIONS);
		}
		return ownedExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public CapellaElement getSource() {

		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (CapellaElement) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public CapellaElement basicGetSource() {

		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setSource(CapellaElement newSource) {

		CapellaElement oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__SOURCE, oldSource, source));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public Requirement getTarget() {

		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) target;
			target = (Requirement) eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public Requirement basicGetTarget() {

		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setTarget(Requirement newTarget) {

		Requirement oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__TARGET, oldTarget, target));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__OWNED_EXTENSIONS:
			return ((InternalEList<?>) getOwnedExtensions()).basicRemove(otherEnd, msgs);
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
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__OWNED_EXTENSIONS:
			return getOwnedExtensions();
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__TARGET:
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
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__OWNED_EXTENSIONS:
			getOwnedExtensions().clear();
			getOwnedExtensions().addAll((Collection<? extends ElementExtension>) newValue);
			return;
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__SOURCE:
			setSource((CapellaElement) newValue);
			return;
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__TARGET:
			setTarget((Requirement) newValue);
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
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__OWNED_EXTENSIONS:
			getOwnedExtensions().clear();
			return;
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__SOURCE:
			setSource((CapellaElement) null);
			return;
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__TARGET:
			setTarget((Requirement) null);
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
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__OWNED_EXTENSIONS:
			return ownedExtensions != null && !ownedExtensions.isEmpty();
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__SOURCE:
			return source != null;
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__TARGET:
			return target != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ExtensibleElement.class) {
			switch (derivedFeatureID) {
			case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__OWNED_EXTENSIONS:
				return EmdePackage.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS;
			default:
				return -1;
			}
		}
		if (baseClass == ElementExtension.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ExtensibleElement.class) {
			switch (baseFeatureID) {
			case EmdePackage.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS:
				return CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION__OWNED_EXTENSIONS;
			default:
				return -1;
			}
		}
		if (baseClass == ElementExtension.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CapellaOutgoingRelationImpl