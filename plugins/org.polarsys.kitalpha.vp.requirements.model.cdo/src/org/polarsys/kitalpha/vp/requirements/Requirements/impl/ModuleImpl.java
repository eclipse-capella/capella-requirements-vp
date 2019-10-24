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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
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
	 * The default value of the '{@link #getReqIFPrefix() <em>Req IF Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_PREFIX_EDEFAULT = null;

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

	@Override
	public String getReqIFName() {

		return (String) eDynamicGet(RequirementsPackage.MODULE__REQ_IF_NAME,
				RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setReqIFName(String newReqIFName) {

		eDynamicSet(RequirementsPackage.MODULE__REQ_IF_NAME,
				RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME, newReqIFName);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getReqIFPrefix() {

		return (String) eDynamicGet(RequirementsPackage.MODULE__REQ_IF_PREFIX,
				RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setReqIFPrefix(String newReqIFPrefix) {

		eDynamicSet(RequirementsPackage.MODULE__REQ_IF_PREFIX,
				RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX, newReqIFPrefix);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public ModuleType getModuleType() {

		return (ModuleType) eDynamicGet(RequirementsPackage.MODULE__MODULE_TYPE,
				RequirementsPackage.Literals.MODULE__MODULE_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public ModuleType basicGetModuleType() {

		return (ModuleType) eDynamicGet(RequirementsPackage.MODULE__MODULE_TYPE,
				RequirementsPackage.Literals.MODULE__MODULE_TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setModuleType(ModuleType newModuleType) {

		eDynamicSet(RequirementsPackage.MODULE__MODULE_TYPE, RequirementsPackage.Literals.MODULE__MODULE_TYPE,
				newModuleType);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@SuppressWarnings("unchecked")
	@Override
	public EList<Requirement> getOwnedRequirements() {

		return (EList<Requirement>) eDynamicGet(RequirementsPackage.MODULE__OWNED_REQUIREMENTS,
				RequirementsPackage.Literals.MODULE__OWNED_REQUIREMENTS, true, true);
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
			return REQ_IF_NAME_EDEFAULT == null ? getReqIFName() != null : !REQ_IF_NAME_EDEFAULT.equals(getReqIFName());
		case RequirementsPackage.MODULE__REQ_IF_PREFIX:
			return REQ_IF_PREFIX_EDEFAULT == null ? getReqIFPrefix() != null
					: !REQ_IF_PREFIX_EDEFAULT.equals(getReqIFPrefix());
		case RequirementsPackage.MODULE__MODULE_TYPE:
			return basicGetModuleType() != null;
		case RequirementsPackage.MODULE__OWNED_REQUIREMENTS:
			return !getOwnedRequirements().isEmpty();
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

} //ModuleImpl