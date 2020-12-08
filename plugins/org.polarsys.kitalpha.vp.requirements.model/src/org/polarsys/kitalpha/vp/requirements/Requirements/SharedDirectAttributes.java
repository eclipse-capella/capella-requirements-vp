/**
 *
 *  Copyright (c) 2016, 2019 THALES GLOBAL SERVICES.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */

package org.polarsys.kitalpha.vp.requirements.Requirements;

import org.polarsys.kitalpha.emde.model.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shared Direct Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes#getReqIFName <em>Req IF Name</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes#getReqIFPrefix <em>Req IF Prefix</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getSharedDirectAttributes()
 * @model abstract="true"
 * @generated
 */

public interface SharedDirectAttributes extends Element {

	/**
	 * Returns the value of the '<em><b>Req IF Name</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Req IF Name</em>' attribute.
	 * @see #setReqIFName(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getSharedDirectAttributes_ReqIFName()
	 * @model
	 * @generated
	 */

	String getReqIFName();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes#getReqIFName <em>Req IF Name</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Req IF Name</em>' attribute.
	 * @see #getReqIFName()
	 * @generated
	 */

	void setReqIFName(String value);

	/**
	 * Returns the value of the '<em><b>Req IF Prefix</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Req IF Prefix</em>' attribute.
	 * @see #setReqIFPrefix(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getSharedDirectAttributes_ReqIFPrefix()
	 * @model
	 * @generated
	 */

	String getReqIFPrefix();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes#getReqIFPrefix <em>Req IF Prefix</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Req IF Prefix</em>' attribute.
	 * @see #getReqIFPrefix()
	 * @generated
	 */

	void setReqIFPrefix(String value);

} // SharedDirectAttributes
