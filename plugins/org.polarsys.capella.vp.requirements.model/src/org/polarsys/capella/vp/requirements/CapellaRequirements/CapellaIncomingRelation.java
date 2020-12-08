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

package org.polarsys.capella.vp.requirements.CapellaRequirements;

import org.polarsys.capella.core.data.capellacore.CapellaElement;

import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capella Incoming Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation#getSource <em>Source</em>}</li>
 *   <li>{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage#getCapellaIncomingRelation()
 * @model
 * @generated
 */

public interface CapellaIncomingRelation extends CapellaRelation {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Requirement)
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage#getCapellaIncomingRelation_Source()
	 * @model
	 * @generated
	 */

	Requirement getSource();

	/**
	 * Sets the value of the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation#getSource <em>Source</em>}' reference.
	
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
	 * @see #setTarget(CapellaElement)
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage#getCapellaIncomingRelation_Target()
	 * @model
	 * @generated
	 */

	CapellaElement getTarget();

	/**
	 * Sets the value of the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation#getTarget <em>Target</em>}' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */

	void setTarget(CapellaElement value);

} // CapellaIncomingRelation
