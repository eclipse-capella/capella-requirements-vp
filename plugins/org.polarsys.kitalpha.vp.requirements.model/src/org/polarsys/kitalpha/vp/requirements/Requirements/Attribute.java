
package org.polarsys.kitalpha.vp.requirements.Requirements;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Attribute#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Attribute#getDefinitionProxy <em>Definition Proxy</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAttribute()
 * @model abstract="true"
 * @generated
 */

public interface Attribute extends IdentifiableElement {

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(AttributeDefinition)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAttribute_Definition()
	 * @model
	 * @generated
	 */

	AttributeDefinition getDefinition();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Attribute#getDefinition <em>Definition</em>}' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */

	void setDefinition(AttributeDefinition value);

	/**
	 * Returns the value of the '<em><b>Definition Proxy</b></em>' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition Proxy</em>' attribute.
	 * @see #setDefinitionProxy(String)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAttribute_DefinitionProxy()
	 * @model
	 * @generated
	 */

	String getDefinitionProxy();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Attribute#getDefinitionProxy <em>Definition Proxy</em>}' attribute.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition Proxy</em>' attribute.
	 * @see #getDefinitionProxy()
	 * @generated
	 */

	void setDefinitionProxy(String value);

} // Attribute
