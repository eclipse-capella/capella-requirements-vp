/**
 *
 *  Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Definition Type</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
