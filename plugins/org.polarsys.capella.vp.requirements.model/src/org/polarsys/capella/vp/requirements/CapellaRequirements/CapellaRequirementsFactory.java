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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2016 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

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
