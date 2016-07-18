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

package org.polarsys.kitalpha.vp.requirements.Requirements;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Req IF Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFIdentifier <em>Req IF Identifier</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFDescription <em>Req IF Description</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFLongName <em>Req IF Long Name</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getReqIFElement()
 * @model abstract="true"
 * @generated
 */

public interface ReqIFElement extends IdentifiableElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2016 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Req IF Identifier</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Req IF Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Req IF Identifier</em>' attribute.
	 * @see #setReqIFIdentifier(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getReqIFElement_ReqIFIdentifier()
	 * @model
	 * @generated
	 */

	String getReqIFIdentifier();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFIdentifier <em>Req IF Identifier</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Req IF Identifier</em>' attribute.
	 * @see #getReqIFIdentifier()
	 * @generated
	 */

	void setReqIFIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Req IF Description</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Req IF Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Req IF Description</em>' attribute.
	 * @see #setReqIFDescription(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getReqIFElement_ReqIFDescription()
	 * @model
	 * @generated
	 */

	String getReqIFDescription();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFDescription <em>Req IF Description</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Req IF Description</em>' attribute.
	 * @see #getReqIFDescription()
	 * @generated
	 */

	void setReqIFDescription(String value);

	/**
	 * Returns the value of the '<em><b>Req IF Long Name</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Req IF Long Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Req IF Long Name</em>' attribute.
	 * @see #setReqIFLongName(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getReqIFElement_ReqIFLongName()
	 * @model
	 * @generated
	 */

	String getReqIFLongName();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFLongName <em>Req IF Long Name</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Req IF Long Name</em>' attribute.
	 * @see #getReqIFLongName()
	 * @generated
	 */

	void setReqIFLongName(String value);

} // ReqIFElement
