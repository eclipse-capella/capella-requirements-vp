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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition#getDefinitionType <em>Definition Type</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAttributeDefinition()
 * @model
 * @generated
 */

public interface AttributeDefinition extends ReqIFElement {

	/**
	 * Returns the value of the '<em><b>Definition Type</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition Type</em>' reference.
	 * @see #setDefinitionType(DataTypeDefinition)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAttributeDefinition_DefinitionType()
	 * @model
	 * @generated
	 */

	DataTypeDefinition getDefinitionType();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition#getDefinitionType <em>Definition Type</em>}' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition Type</em>' reference.
	 * @see #getDefinitionType()
	 * @generated
	 */

	void setDefinitionType(DataTypeDefinition value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(Attribute)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAttributeDefinition_DefaultValue()
	 * @model containment="true"
	 * @generated
	 */

	Attribute getDefaultValue();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition#getDefaultValue <em>Default Value</em>}' containment reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */

	void setDefaultValue(Attribute value);

} // AttributeDefinition
