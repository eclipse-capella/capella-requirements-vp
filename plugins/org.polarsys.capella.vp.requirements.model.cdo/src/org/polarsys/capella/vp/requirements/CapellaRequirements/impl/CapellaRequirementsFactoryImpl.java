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

package org.polarsys.capella.vp.requirements.CapellaRequirements.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.capella.vp.requirements.CapellaRequirements.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CapellaRequirementsFactoryImpl extends EFactoryImpl implements CapellaRequirementsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CapellaRequirementsFactory init() {
		try {
			CapellaRequirementsFactory theCapellaRequirementsFactory = (CapellaRequirementsFactory) EPackage.Registry.INSTANCE
					.getEFactory(CapellaRequirementsPackage.eNS_URI);
			if (theCapellaRequirementsFactory != null) {
				return theCapellaRequirementsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CapellaRequirementsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapellaRequirementsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case CapellaRequirementsPackage.CAPELLA_TYPES_FOLDER:
			return (EObject) createCapellaTypesFolder();
		case CapellaRequirementsPackage.CAPELLA_MODULE:
			return (EObject) createCapellaModule();
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION:
			return (EObject) createCapellaIncomingRelation();
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION:
			return (EObject) createCapellaOutgoingRelation();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CapellaTypesFolder createCapellaTypesFolder() {
		CapellaTypesFolderImpl capellaTypesFolder = new CapellaTypesFolderImpl();
		return capellaTypesFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CapellaModule createCapellaModule() {
		CapellaModuleImpl capellaModule = new CapellaModuleImpl();
		return capellaModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CapellaIncomingRelation createCapellaIncomingRelation() {
		CapellaIncomingRelationImpl capellaIncomingRelation = new CapellaIncomingRelationImpl();
		return capellaIncomingRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CapellaOutgoingRelation createCapellaOutgoingRelation() {
		CapellaOutgoingRelationImpl capellaOutgoingRelation = new CapellaOutgoingRelationImpl();
		return capellaOutgoingRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CapellaRequirementsPackage getCapellaRequirementsPackage() {
		return (CapellaRequirementsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CapellaRequirementsPackage getPackage() {
		return CapellaRequirementsPackage.eINSTANCE;
	}

	//begin-capella-code

	//end-capella-code
} //CapellaRequirementsFactoryImpl