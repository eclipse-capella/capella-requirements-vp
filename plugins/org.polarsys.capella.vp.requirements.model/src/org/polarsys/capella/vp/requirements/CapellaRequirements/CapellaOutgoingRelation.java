/**
 *
 *  Copyright (c) 2016, 2022 THALES GLOBAL SERVICES.
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

import org.polarsys.kitalpha.emde.model.ElementExtension;

import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capella Outgoing Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation#getSource <em>Source</em>}</li>
 *   <li>{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage#getCapellaOutgoingRelation()
 * @model annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraint ExtendedElement=' http://www.polarsys.org/capella/core/core/6.0.0#//CapellaElement'"
 *        annotation="http://www.polarsys.org/kitalpha/emde/1.0.0/constraintMapping Mapping=' platform:/plugin/org.polarsys.capella.core.data.gen/model/CapellaCore.ecore#//CapellaElement'"
 * @generated
 */

public interface CapellaOutgoingRelation extends CapellaRelation, ElementExtension {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(CapellaElement)
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage#getCapellaOutgoingRelation_Source()
	 * @model
	 * @generated
	 */

	CapellaElement getSource();

	/**
	 * Sets the value of the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation#getSource <em>Source</em>}' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */

	void setSource(CapellaElement value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Requirement)
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage#getCapellaOutgoingRelation_Target()
	 * @model
	 * @generated
	 */

	Requirement getTarget();

	/**
	 * Sets the value of the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation#getTarget <em>Target</em>}' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */

	void setTarget(Requirement value);

} // CapellaOutgoingRelation
