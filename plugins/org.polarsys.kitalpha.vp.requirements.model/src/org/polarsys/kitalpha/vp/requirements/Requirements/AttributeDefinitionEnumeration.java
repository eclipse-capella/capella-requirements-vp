/**
 *
 *  Copyright (c) 2017, 2019 THALES GLOBAL SERVICES.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Definition Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration#isMultiValued <em>Multi Valued</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAttributeDefinitionEnumeration()
 * @model
 * @generated
 */

public interface AttributeDefinitionEnumeration extends AttributeDefinition {

	/**
	 * Returns the value of the '<em><b>Multi Valued</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Valued</em>' attribute.
	 * @see #setMultiValued(boolean)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAttributeDefinitionEnumeration_MultiValued()
	 * @model
	 * @generated
	 */

	boolean isMultiValued();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration#isMultiValued <em>Multi Valued</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Valued</em>' attribute.
	 * @see #isMultiValued()
	 * @generated
	 */

	void setMultiValued(boolean value);

} // AttributeDefinitionEnumeration
