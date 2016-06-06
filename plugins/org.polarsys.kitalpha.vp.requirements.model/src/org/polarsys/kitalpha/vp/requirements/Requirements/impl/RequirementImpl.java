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

import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getRequirementType <em>Requirement Type</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getOwnedRelations <em>Owned Relations</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getReqIF_ChapterName <em>Req IF Chapter Name</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getReqIF_ForeignID <em>Req IF Foreign ID</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getReqIF_Prefix <em>Req IF Prefix</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl#getReqIF_Text <em>Req IF Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RequirementImpl extends AttributeOwnerImpl implements Requirement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2016 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getRequirementType() <em>Requirement Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementType()
	 * @generated
	 * @ordered
	 */
	protected RequirementType requirementType;

	/**
	 * The cached value of the '{@link #getOwnedRelations() <em>Owned Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRelation> ownedRelations;

	/**
	 * The default value of the '{@link #getReqIF_ChapterName() <em>Req IF Chapter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIF_ChapterName()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_CHAPTER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReqIF_ChapterName() <em>Req IF Chapter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIF_ChapterName()
	 * @generated
	 * @ordered
	 */
	protected String reqIF_ChapterName = REQ_IF_CHAPTER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getReqIF_ForeignID() <em>Req IF Foreign ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIF_ForeignID()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_FOREIGN_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReqIF_ForeignID() <em>Req IF Foreign ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIF_ForeignID()
	 * @generated
	 * @ordered
	 */
	protected String reqIF_ForeignID = REQ_IF_FOREIGN_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getReqIF_Prefix() <em>Req IF Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIF_Prefix()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReqIF_Prefix() <em>Req IF Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIF_Prefix()
	 * @generated
	 * @ordered
	 */
	protected String reqIF_Prefix = REQ_IF_PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getReqIF_Text() <em>Req IF Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIF_Text()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReqIF_Text() <em>Req IF Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIF_Text()
	 * @generated
	 * @ordered
	 */
	protected String reqIF_Text = REQ_IF_TEXT_EDEFAULT;

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

	public RequirementType getRequirementType() {

		if (requirementType != null && requirementType.eIsProxy()) {
			InternalEObject oldRequirementType = (InternalEObject) requirementType;
			requirementType = (RequirementType) eResolveProxy(oldRequirementType);
			if (requirementType != oldRequirementType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE, oldRequirementType, requirementType));
			}
		}
		return requirementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public RequirementType basicGetRequirementType() {

		return requirementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setRequirementType(RequirementType newRequirementType) {

		RequirementType oldRequirementType = requirementType;
		requirementType = newRequirementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE,
					oldRequirementType, requirementType));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public EList<AbstractRelation> getOwnedRelations() {

		if (ownedRelations == null) {
			ownedRelations = new EObjectContainmentEList<AbstractRelation>(AbstractRelation.class, this,
					RequirementsPackage.REQUIREMENT__OWNED_RELATIONS);
		}
		return ownedRelations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public String getReqIF_ChapterName() {

		return reqIF_ChapterName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setReqIF_ChapterName(String newReqIF_ChapterName) {

		String oldReqIF_ChapterName = reqIF_ChapterName;
		reqIF_ChapterName = newReqIF_ChapterName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME,
					oldReqIF_ChapterName, reqIF_ChapterName));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public String getReqIF_ForeignID() {

		return reqIF_ForeignID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setReqIF_ForeignID(String newReqIF_ForeignID) {

		String oldReqIF_ForeignID = reqIF_ForeignID;
		reqIF_ForeignID = newReqIF_ForeignID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID,
					oldReqIF_ForeignID, reqIF_ForeignID));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public String getReqIF_Prefix() {

		return reqIF_Prefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setReqIF_Prefix(String newReqIF_Prefix) {

		String oldReqIF_Prefix = reqIF_Prefix;
		reqIF_Prefix = newReqIF_Prefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX,
					oldReqIF_Prefix, reqIF_Prefix));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public String getReqIF_Text() {

		return reqIF_Text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public void setReqIF_Text(String newReqIF_Text) {

		String oldReqIF_Text = reqIF_Text;
		reqIF_Text = newReqIF_Text;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__REQ_IF_TEXT,
					oldReqIF_Text, reqIF_Text));

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
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE:
			if (resolve)
				return getRequirementType();
			return basicGetRequirementType();
		case RequirementsPackage.REQUIREMENT__OWNED_RELATIONS:
			return getOwnedRelations();
		case RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME:
			return getReqIF_ChapterName();
		case RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID:
			return getReqIF_ForeignID();
		case RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX:
			return getReqIF_Prefix();
		case RequirementsPackage.REQUIREMENT__REQ_IF_TEXT:
			return getReqIF_Text();
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
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE:
			setRequirementType((RequirementType) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__OWNED_RELATIONS:
			getOwnedRelations().clear();
			getOwnedRelations().addAll((Collection<? extends AbstractRelation>) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME:
			setReqIF_ChapterName((String) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID:
			setReqIF_ForeignID((String) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX:
			setReqIF_Prefix((String) newValue);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_TEXT:
			setReqIF_Text((String) newValue);
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
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE:
			setRequirementType((RequirementType) null);
			return;
		case RequirementsPackage.REQUIREMENT__OWNED_RELATIONS:
			getOwnedRelations().clear();
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME:
			setReqIF_ChapterName(REQ_IF_CHAPTER_NAME_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID:
			setReqIF_ForeignID(REQ_IF_FOREIGN_ID_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX:
			setReqIF_Prefix(REQ_IF_PREFIX_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__REQ_IF_TEXT:
			setReqIF_Text(REQ_IF_TEXT_EDEFAULT);
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
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE:
			return requirementType != null;
		case RequirementsPackage.REQUIREMENT__OWNED_RELATIONS:
			return ownedRelations != null && !ownedRelations.isEmpty();
		case RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME:
			return REQ_IF_CHAPTER_NAME_EDEFAULT == null ? reqIF_ChapterName != null
					: !REQ_IF_CHAPTER_NAME_EDEFAULT.equals(reqIF_ChapterName);
		case RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID:
			return REQ_IF_FOREIGN_ID_EDEFAULT == null ? reqIF_ForeignID != null
					: !REQ_IF_FOREIGN_ID_EDEFAULT.equals(reqIF_ForeignID);
		case RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX:
			return REQ_IF_PREFIX_EDEFAULT == null ? reqIF_Prefix != null : !REQ_IF_PREFIX_EDEFAULT.equals(reqIF_Prefix);
		case RequirementsPackage.REQUIREMENT__REQ_IF_TEXT:
			return REQ_IF_TEXT_EDEFAULT == null ? reqIF_Text != null : !REQ_IF_TEXT_EDEFAULT.equals(reqIF_Text);
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ReqIF_ChapterName: "); //$NON-NLS-1$
		result.append(reqIF_ChapterName);
		result.append(", ReqIF_ForeignID: "); //$NON-NLS-1$
		result.append(reqIF_ForeignID);
		result.append(", ReqIF_Prefix: "); //$NON-NLS-1$
		result.append(reqIF_Prefix);
		result.append(", ReqIF_Text: "); //$NON-NLS-1$
		result.append(reqIF_Text);
		result.append(')');
		return result.toString();
	}

} //RequirementImpl