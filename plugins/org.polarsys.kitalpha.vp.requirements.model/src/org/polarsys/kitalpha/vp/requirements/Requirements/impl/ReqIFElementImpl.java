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

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Req IF Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ReqIFElementImpl#getReqIFIdentifier <em>Req IF Identifier</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ReqIFElementImpl#getReqIFDescription <em>Req IF Description</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ReqIFElementImpl#getReqIFLongName <em>Req IF Long Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ReqIFElementImpl extends IdentifiableElementImpl implements ReqIFElement {

	/**
	 * The default value of the '{@link #getReqIFIdentifier() <em>Req IF Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReqIFIdentifier() <em>Req IF Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String reqIFIdentifier = REQ_IF_IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getReqIFDescription() <em>Req IF Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReqIFDescription() <em>Req IF Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFDescription()
	 * @generated
	 * @ordered
	 */
	protected String reqIFDescription = REQ_IF_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getReqIFLongName() <em>Req IF Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFLongName()
	 * @generated
	 * @ordered
	 */
	protected static final String REQ_IF_LONG_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReqIFLongName() <em>Req IF Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReqIFLongName()
	 * @generated
	 * @ordered
	 */
	protected String reqIFLongName = REQ_IF_LONG_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReqIFElementImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.REQ_IF_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getReqIFIdentifier() {

		return reqIFIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setReqIFIdentifier(String newReqIFIdentifier) {

		String oldReqIFIdentifier = reqIFIdentifier;
		reqIFIdentifier = newReqIFIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_IDENTIFIER,
					oldReqIFIdentifier, reqIFIdentifier));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getReqIFDescription() {

		return reqIFDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setReqIFDescription(String newReqIFDescription) {

		String oldReqIFDescription = reqIFDescription;
		reqIFDescription = newReqIFDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_DESCRIPTION, oldReqIFDescription, reqIFDescription));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public String getReqIFLongName() {

		return reqIFLongName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setReqIFLongName(String newReqIFLongName) {

		String oldReqIFLongName = reqIFLongName;
		reqIFLongName = newReqIFLongName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_LONG_NAME,
					oldReqIFLongName, reqIFLongName));

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_IDENTIFIER:
			return getReqIFIdentifier();
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_DESCRIPTION:
			return getReqIFDescription();
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_LONG_NAME:
			return getReqIFLongName();
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
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_IDENTIFIER:
			setReqIFIdentifier((String) newValue);
			return;
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_DESCRIPTION:
			setReqIFDescription((String) newValue);
			return;
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_LONG_NAME:
			setReqIFLongName((String) newValue);
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
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_IDENTIFIER:
			setReqIFIdentifier(REQ_IF_IDENTIFIER_EDEFAULT);
			return;
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_DESCRIPTION:
			setReqIFDescription(REQ_IF_DESCRIPTION_EDEFAULT);
			return;
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_LONG_NAME:
			setReqIFLongName(REQ_IF_LONG_NAME_EDEFAULT);
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
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_IDENTIFIER:
			return REQ_IF_IDENTIFIER_EDEFAULT == null ? reqIFIdentifier != null
					: !REQ_IF_IDENTIFIER_EDEFAULT.equals(reqIFIdentifier);
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_DESCRIPTION:
			return REQ_IF_DESCRIPTION_EDEFAULT == null ? reqIFDescription != null
					: !REQ_IF_DESCRIPTION_EDEFAULT.equals(reqIFDescription);
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_LONG_NAME:
			return REQ_IF_LONG_NAME_EDEFAULT == null ? reqIFLongName != null
					: !REQ_IF_LONG_NAME_EDEFAULT.equals(reqIFLongName);
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
		result.append(" (ReqIFIdentifier: "); //$NON-NLS-1$
		result.append(reqIFIdentifier);
		result.append(", ReqIFDescription: "); //$NON-NLS-1$
		result.append(reqIFDescription);
		result.append(", ReqIFLongName: "); //$NON-NLS-1$
		result.append(reqIFLongName);
		result.append(')');
		return result.toString();
	}

} //ReqIFElementImpl