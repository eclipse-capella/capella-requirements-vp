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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage
 * @generated
 */
public interface CapellaRequirementsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CapellaRequirementsFactory eINSTANCE = org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Capella Types Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capella Types Folder</em>'.
	 * @generated
	 */
	CapellaTypesFolder createCapellaTypesFolder();

	/**
	 * Returns a new object of class '<em>Capella Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capella Module</em>'.
	 * @generated
	 */
	CapellaModule createCapellaModule();

	/**
	 * Returns a new object of class '<em>Capella Incoming Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capella Incoming Relation</em>'.
	 * @generated
	 */
	CapellaIncomingRelation createCapellaIncomingRelation();

	/**
	 * Returns a new object of class '<em>Capella Outgoing Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capella Outgoing Relation</em>'.
	 * @generated
	 */
	CapellaOutgoingRelation createCapellaOutgoingRelation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CapellaRequirementsPackage getCapellaRequirementsPackage();

} //CapellaRequirementsFactory
