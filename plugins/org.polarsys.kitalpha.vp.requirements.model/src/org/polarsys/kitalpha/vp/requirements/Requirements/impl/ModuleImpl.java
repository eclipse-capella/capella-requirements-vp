/**
 *
 *  Copyright (c) 2016 THALES GLOBAL SERVICES.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */

package org.polarsys.kitalpha.vp.requirements.Requirements.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.polarsys.kitalpha.vp.requirements.Requirements.Module;
import org.polarsys.kitalpha.vp.requirements.Requirements.ModuleType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleImpl#getReqIFName <em>Req IF Name</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleImpl#getReqIFPrefix <em>Req IF Prefix</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleImpl#getModuleType <em>Module Type</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleImpl#getOwnedRequirements <em>Owned Requirements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModuleImpl extends AttributeOwnerImpl implements Module {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2016 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getReqIFName() <em>Req IF Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFName()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReqIFName() <em>Req IF Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFName()
	 * @generated
	 * @ordered
	 */
	protected String reqIFName = REQ_IF_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getReqIFPrefix() <em>Req IF Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReqIFPrefix() <em>Req IF Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFPrefix()
	 * @generated
	 * @ordered
	 */
	protected String reqIFPrefix = REQ_IF_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModuleType() <em>Module Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModuleType()
	 * @generated
	 * @ordered
	 */
	protected ModuleType moduleType;

	/**
	 * The cached value of the '{@link #getOwnedRequirements() <em>Owned Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<Requirement> ownedRequirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public ModuleType getModuleType() {

		if (moduleType != null && moduleType.eIsProxy()) {
			InternalEObject oldModuleType = (InternalEObject) moduleType;
			moduleType = (ModuleType) eResolveProxy(oldModuleType);
			if (moduleType != oldModuleType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.MODULE__MODULE_TYPE,
							oldModuleType, moduleType));
			}
		}
		return moduleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public ModuleType basicGetModuleType() {

		return moduleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setModuleType(ModuleType newModuleType) {

		ModuleType oldModuleType = moduleType;
		moduleType = newModuleType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.MODULE__MODULE_TYPE,
					oldModuleType, moduleType));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public EList<Requirement> getOwnedRequirements() {

		if (ownedRequirements == null) {
			ownedRequirements = new EObjectContainmentEList<Requirement>(Requirement.class, this,
					RequirementsPackage.MODULE__OWNED_REQUIREMENTS);
		}
		return ownedRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public String getReqIFName() {

		return reqIFName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setReqIFName(String newReqIFName) {

		String oldReqIFName = reqIFName;
		reqIFName = newReqIFName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.MODULE__REQ_IF_NAME, oldReqIFName,
					reqIFName));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public String getReqIFPrefix() {

		return reqIFPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setReqIFPrefix(String newReqIFPrefix) {

		String oldReqIFPrefix = reqIFPrefix;
		reqIFPrefix = newReqIFPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.MODULE__REQ_IF_PREFIX,
					oldReqIFPrefix, reqIFPrefix));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementsPackage.MODULE__OWNED_REQUIREMENTS:
			return ((InternalEList<?>) getOwnedRequirements()).basicRemove(otherEnd, msgs);
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
		case RequirementsPackage.MODULE__REQ_IF_NAME:
			return getReqIFName();
		case RequirementsPackage.MODULE__REQ_IF_PREFIX:
			return getReqIFPrefix();
		case RequirementsPackage.MODULE__MODULE_TYPE:
			if (resolve)
				return getModuleType();
			return basicGetModuleType();
		case RequirementsPackage.MODULE__OWNED_REQUIREMENTS:
			return getOwnedRequirements();
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
		case RequirementsPackage.MODULE__REQ_IF_NAME:
			setReqIFName((String) newValue);
			return;
		case RequirementsPackage.MODULE__REQ_IF_PREFIX:
			setReqIFPrefix((String) newValue);
			return;
		case RequirementsPackage.MODULE__MODULE_TYPE:
			setModuleType((ModuleType) newValue);
			return;
		case RequirementsPackage.MODULE__OWNED_REQUIREMENTS:
			getOwnedRequirements().clear();
			getOwnedRequirements().addAll((Collection<? extends Requirement>) newValue);
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
		case RequirementsPackage.MODULE__REQ_IF_NAME:
			setReqIFName(REQ_IF_NAME_EDEFAULT);
			return;
		case RequirementsPackage.MODULE__REQ_IF_PREFIX:
			setReqIFPrefix(REQ_IF_PREFIX_EDEFAULT);
			return;
		case RequirementsPackage.MODULE__MODULE_TYPE:
			setModuleType((ModuleType) null);
			return;
		case RequirementsPackage.MODULE__OWNED_REQUIREMENTS:
			getOwnedRequirements().clear();
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
		case RequirementsPackage.MODULE__REQ_IF_NAME:
			return REQ_IF_NAME_EDEFAULT == null ? reqIFName != null : !REQ_IF_NAME_EDEFAULT.equals(reqIFName);
		case RequirementsPackage.MODULE__REQ_IF_PREFIX:
			return REQ_IF_PREFIX_EDEFAULT == null ? reqIFPrefix != null : !REQ_IF_PREFIX_EDEFAULT.equals(reqIFPrefix);
		case RequirementsPackage.MODULE__MODULE_TYPE:
			return moduleType != null;
		case RequirementsPackage.MODULE__OWNED_REQUIREMENTS:
			return ownedRequirements != null && !ownedRequirements.isEmpty();
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
		if (baseClass == SharedDirectAttributes.class) {
			switch (derivedFeatureID) {
			case RequirementsPackage.MODULE__REQ_IF_NAME:
				return RequirementsPackage.SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME;
			case RequirementsPackage.MODULE__REQ_IF_PREFIX:
				return RequirementsPackage.SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX;
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
		if (baseClass == SharedDirectAttributes.class) {
			switch (baseFeatureID) {
			case RequirementsPackage.SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME:
				return RequirementsPackage.MODULE__REQ_IF_NAME;
			case RequirementsPackage.SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX:
				return RequirementsPackage.MODULE__REQ_IF_PREFIX;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ReqIFName: "); //$NON-NLS-1$
		result.append(reqIFName);
		result.append(", ReqIFPrefix: "); //$NON-NLS-1$
		result.append(reqIFPrefix);
		result.append(')');
		return result.toString();
	}

} //ModuleImpl