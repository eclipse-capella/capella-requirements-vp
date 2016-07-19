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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getRequirementType <em>Requirement Type</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getOwnedRelations <em>Owned Relations</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFChapterName <em>Req IF Chapter Name</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFForeignID <em>Req IF Foreign ID</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFPrefix <em>Req IF Prefix</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFText <em>Req IF Text</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getRequirementTypeProxy <em>Requirement Type Proxy</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getRequirement()
 * @model
 * @generated
 */

public interface Requirement extends AttributeOwner {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2016 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Requirement Type</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement Type</em>' reference.
	 * @see #setRequirementType(RequirementType)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getRequirement_RequirementType()
	 * @model
	 * @generated
	 */

	RequirementType getRequirementType();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getRequirementType <em>Requirement Type</em>}' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement Type</em>' reference.
	 * @see #getRequirementType()
	 * @generated
	 */

	void setRequirementType(RequirementType value);

	/**
	 * Returns the value of the '<em><b>Owned Relations</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation}.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Relations</em>' containment reference list.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getRequirement_OwnedRelations()
	 * @model containment="true"
	 * @generated
	 */

	EList<AbstractRelation> getOwnedRelations();

	/**
	 * Returns the value of the '<em><b>Req IF Chapter Name</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Req IF Chapter Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Req IF Chapter Name</em>' attribute.
	 * @see #setReqIFChapterName(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getRequirement_ReqIFChapterName()
	 * @model
	 * @generated
	 */

	String getReqIFChapterName();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFChapterName <em>Req IF Chapter Name</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Req IF Chapter Name</em>' attribute.
	 * @see #getReqIFChapterName()
	 * @generated
	 */

	void setReqIFChapterName(String value);

	/**
	 * Returns the value of the '<em><b>Req IF Foreign ID</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Req IF Foreign ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Req IF Foreign ID</em>' attribute.
	 * @see #setReqIFForeignID(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getRequirement_ReqIFForeignID()
	 * @model
	 * @generated
	 */

	String getReqIFForeignID();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFForeignID <em>Req IF Foreign ID</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Req IF Foreign ID</em>' attribute.
	 * @see #getReqIFForeignID()
	 * @generated
	 */

	void setReqIFForeignID(String value);

	/**
	 * Returns the value of the '<em><b>Req IF Prefix</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Req IF Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Req IF Prefix</em>' attribute.
	 * @see #setReqIFPrefix(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getRequirement_ReqIFPrefix()
	 * @model
	 * @generated
	 */

	String getReqIFPrefix();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFPrefix <em>Req IF Prefix</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Req IF Prefix</em>' attribute.
	 * @see #getReqIFPrefix()
	 * @generated
	 */

	void setReqIFPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Req IF Text</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Req IF Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Req IF Text</em>' attribute.
	 * @see #setReqIFText(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getRequirement_ReqIFText()
	 * @model
	 * @generated
	 */

	String getReqIFText();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFText <em>Req IF Text</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Req IF Text</em>' attribute.
	 * @see #getReqIFText()
	 * @generated
	 */

	void setReqIFText(String value);

	/**
	 * Returns the value of the '<em><b>Requirement Type Proxy</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement Type Proxy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement Type Proxy</em>' attribute.
	 * @see #setRequirementTypeProxy(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getRequirement_RequirementTypeProxy()
	 * @model
	 * @generated
	 */

	String getRequirementTypeProxy();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getRequirementTypeProxy <em>Requirement Type Proxy</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement Type Proxy</em>' attribute.
	 * @see #getRequirementTypeProxy()
	 * @generated
	 */

	void setRequirementTypeProxy(String value);

} // Requirement
