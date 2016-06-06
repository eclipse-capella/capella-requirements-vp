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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2016 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(CapellaElement)
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage#getCapellaIncomingRelation_Source()
	 * @model
	 * @generated
	 */

	CapellaElement getSource();

	/**
	 * Sets the value of the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation#getSource <em>Source</em>}' reference.
	
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
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Requirement)
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage#getCapellaIncomingRelation_Target()
	 * @model
	 * @generated
	 */

	Requirement getTarget();

	/**
	 * Sets the value of the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation#getTarget <em>Target</em>}' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */

	void setTarget(Requirement value);

} // CapellaIncomingRelation
