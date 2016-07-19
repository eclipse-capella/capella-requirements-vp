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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation#getRelationType <em>Relation Type</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation#getRelationTypeProxy <em>Relation Type Proxy</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAbstractRelation()
 * @model abstract="true"
 * @generated
 */

public interface AbstractRelation extends ReqIFElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2016 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Relation Type</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation Type</em>' reference.
	 * @see #setRelationType(RelationType)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAbstractRelation_RelationType()
	 * @model
	 * @generated
	 */

	RelationType getRelationType();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation#getRelationType <em>Relation Type</em>}' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation Type</em>' reference.
	 * @see #getRelationType()
	 * @generated
	 */

	void setRelationType(RelationType value);

	/**
	 * Returns the value of the '<em><b>Relation Type Proxy</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation Type Proxy</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation Type Proxy</em>' attribute.
	 * @see #setRelationTypeProxy(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAbstractRelation_RelationTypeProxy()
	 * @model
	 * @generated
	 */

	String getRelationTypeProxy();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation#getRelationTypeProxy <em>Relation Type Proxy</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation Type Proxy</em>' attribute.
	 * @see #getRelationTypeProxy()
	 * @generated
	 */

	void setRelationTypeProxy(String value);

} // AbstractRelation
