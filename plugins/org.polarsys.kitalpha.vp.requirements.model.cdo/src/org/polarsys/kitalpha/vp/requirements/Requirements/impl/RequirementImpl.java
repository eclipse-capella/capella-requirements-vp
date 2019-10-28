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

import java.math.BigInteger;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getReqIFName <em>Req IF Name</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getReqIFPrefix <em>Req IF Prefix</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getRequirementType <em>Requirement Type</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getOwnedRelations <em>Owned Relations</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getReqIFChapterName <em>Req IF Chapter Name</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getReqIFForeignID <em>Req IF Foreign ID</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getReqIFText <em>Req IF Text</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getRequirementTypeProxy <em>Requirement Type Proxy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementImpl extends AttributeOwnerImpl implements Requirement {

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
	 * The default value of the '{@link #getReqIFChapterName() <em>Req IF Chapter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFChapterName()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_CHAPTER_NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getReqIFForeignID() <em>Req IF Foreign ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFForeignID()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger REQ_IF_FOREIGN_ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getReqIFText() <em>Req IF Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFText()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_TEXT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getRequirementTypeProxy() <em>Requirement Type Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementTypeProxy()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIREMENT_TYPE_PROXY_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getReqIFName() {

		return (String) eDynamicGet(RequirementsPackage.REQUIREMENT__REQ_IF_NAME,
				RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setReqIFName(String newReqIFName) {

		eDynamicSet(RequirementsPackage.REQUIREMENT__REQ_IF_NAME,
				RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME, newReqIFName);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getReqIFPrefix() {

		return (String) eDynamicGet(RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX,
				RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setReqIFPrefix(String newReqIFPrefix) {

		eDynamicSet(RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX,
				RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX, newReqIFPrefix);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public RequirementType getRequirementType() {

		return (RequirementType) eDynamicGet(RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE,
				RequirementsPackage.Literals.REQUIREMENT__REQUIREMENT_TYPE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public RequirementType basicGetRequirementType() {

		return (RequirementType) eDynamicGet(RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE,
				RequirementsPackage.Literals.REQUIREMENT__REQUIREMENT_TYPE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setRequirementType(RequirementType newRequirementType) {

		eDynamicSet(RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE,
				RequirementsPackage.Literals.REQUIREMENT__REQUIREMENT_TYPE, newRequirementType);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@SuppressWarnings("unchecked")
	@Override
	public EList<AbstractRelation> getOwnedRelations() {

		return (EList<AbstractRelation>) eDynamicGet(RequirementsPackage.REQUIREMENT__OWNED_RELATIONS,
				RequirementsPackage.Literals.REQUIREMENT__OWNED_RELATIONS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getReqIFChapterName() {

		return (String) eDynamicGet(RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME,
				RequirementsPackage.Literals.REQUIREMENT__REQ_IF_CHAPTER_NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setReqIFChapterName(String newReqIFChapterName) {

		eDynamicSet(RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME,
				RequirementsPackage.Literals.REQUIREMENT__REQ_IF_CHAPTER_NAME, newReqIFChapterName);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public BigInteger getReqIFForeignID() {

		return (BigInteger) eDynamicGet(RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID,
				RequirementsPackage.Literals.REQUIREMENT__REQ_IF_FOREIGN_ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setReqIFForeignID(BigInteger newReqIFForeignID) {

		eDynamicSet(RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID,
				RequirementsPackage.Literals.REQUIREMENT__REQ_IF_FOREIGN_ID, newReqIFForeignID);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getReqIFText() {

		return (String) eDynamicGet(RequirementsPackage.REQUIREMENT__REQ_IF_TEXT,
				RequirementsPackage.Literals.REQUIREMENT__REQ_IF_TEXT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setReqIFText(String newReqIFText) {

		eDynamicSet(RequirementsPackage.REQUIREMENT__REQ_IF_TEXT, RequirementsPackage.Literals.REQUIREMENT__REQ_IF_TEXT,
				newReqIFText);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getRequirementTypeProxy() {

		return (String) eDynamicGet(RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE_PROXY,
				RequirementsPackage.Literals.REQUIREMENT__REQUIREMENT_TYPE_PROXY, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setRequirementTypeProxy(String newRequirementTypeProxy) {

		eDynamicSet(RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE_PROXY,
				RequirementsPackage.Literals.REQUIREMENT__REQUIREMENT_TYPE_PROXY, newRequirementTypeProxy);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementsPackage.REQUIREMENT__OWNED_RELATIONS:
			return ((InternalEList<?>) getOwnedRelations()).basicRemove(otherEnd, msgs);
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
		case RequirementsPackage.REQUIREMENT__REQ_IF_NAME:
			return getReqIFName();
		case RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX:
			return getReqIFPrefix();
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE:
			if (resolve)
				return getRequirementType();
			return basicGetRequirementType();
		case RequirementsPackage.REQUIREMENT__OWNED_RELATIONS:
			return getOwnedRelations();
		case RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME:
			return getReqIFChapterName();
		case RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID:
			return getReqIFForeignID();
		case RequirementsPackage.REQUIREMENT__REQ_IF_TEXT:
			return getReqIFText();
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE_PROXY:
			return getRequirementTypeProxy();
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
		case RequirementsPackage.REQUIREMENT__REQ_IF_NAME:
			setReqIFName((String) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX:
			setReqIFPrefix((String) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE:
			setRequirementType((RequirementType) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__OWNED_RELATIONS:
			getOwnedRelations().clear();
			getOwnedRelations().addAll((Collection<? extends AbstractRelation>) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME:
			setReqIFChapterName((String) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID:
			setReqIFForeignID((BigInteger) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_TEXT:
			setReqIFText((String) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE_PROXY:
			setRequirementTypeProxy((String) newValue);
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
		case RequirementsPackage.REQUIREMENT__REQ_IF_NAME:
			setReqIFName(REQ_IF_NAME_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX:
			setReqIFPrefix(REQ_IF_PREFIX_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE:
			setRequirementType((RequirementType) null);
			return;
		case RequirementsPackage.REQUIREMENT__OWNED_RELATIONS:
			getOwnedRelations().clear();
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME:
			setReqIFChapterName(REQ_IF_CHAPTER_NAME_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID:
			setReqIFForeignID(REQ_IF_FOREIGN_ID_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_TEXT:
			setReqIFText(REQ_IF_TEXT_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE_PROXY:
			setRequirementTypeProxy(REQUIREMENT_TYPE_PROXY_EDEFAULT);
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
		case RequirementsPackage.REQUIREMENT__REQ_IF_NAME:
			return REQ_IF_NAME_EDEFAULT == null ? getReqIFName() != null : !REQ_IF_NAME_EDEFAULT.equals(getReqIFName());
		case RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX:
			return REQ_IF_PREFIX_EDEFAULT == null ? getReqIFPrefix() != null
					: !REQ_IF_PREFIX_EDEFAULT.equals(getReqIFPrefix());
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE:
			return basicGetRequirementType() != null;
		case RequirementsPackage.REQUIREMENT__OWNED_RELATIONS:
			return !getOwnedRelations().isEmpty();
		case RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME:
			return REQ_IF_CHAPTER_NAME_EDEFAULT == null ? getReqIFChapterName() != null
					: !REQ_IF_CHAPTER_NAME_EDEFAULT.equals(getReqIFChapterName());
		case RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID:
			return REQ_IF_FOREIGN_ID_EDEFAULT == null ? getReqIFForeignID() != null
					: !REQ_IF_FOREIGN_ID_EDEFAULT.equals(getReqIFForeignID());
		case RequirementsPackage.REQUIREMENT__REQ_IF_TEXT:
			return REQ_IF_TEXT_EDEFAULT == null ? getReqIFText() != null : !REQ_IF_TEXT_EDEFAULT.equals(getReqIFText());
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE_PROXY:
			return REQUIREMENT_TYPE_PROXY_EDEFAULT == null ? getRequirementTypeProxy() != null
					: !REQUIREMENT_TYPE_PROXY_EDEFAULT.equals(getRequirementTypeProxy());
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
			case RequirementsPackage.REQUIREMENT__REQ_IF_NAME:
				return RequirementsPackage.SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME;
			case RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX:
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
				return RequirementsPackage.REQUIREMENT__REQ_IF_NAME;
			case RequirementsPackage.SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX:
				return RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //RequirementImpl