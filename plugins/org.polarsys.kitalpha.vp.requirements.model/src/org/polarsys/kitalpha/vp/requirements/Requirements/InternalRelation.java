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

package org.polarsys.kitalpha.vp.requirements.Requirements;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation#getSource <em>Source</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getInternalRelation()
 * @model
 * @generated
 */

public interface InternalRelation extends AbstractRelation {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Requirement)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getInternalRelation_Source()
	 * @model
	 * @generated
	 */

	Requirement getSource();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation#getSource <em>Source</em>}' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */

	void setSource(Requirement value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Requirement)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getInternalRelation_Target()
	 * @model
	 * @generated
	 */

	Requirement getTarget();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation#getTarget <em>Target</em>}' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */

	void setTarget(Requirement value);

} // InternalRelation
