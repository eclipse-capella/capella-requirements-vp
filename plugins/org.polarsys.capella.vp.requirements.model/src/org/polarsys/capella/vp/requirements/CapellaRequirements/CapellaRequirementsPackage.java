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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsFactory
 * @model kind="package"
 * @generated
 */
public interface CapellaRequirementsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2016 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "CapellaRequirements"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/capella/requirements"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CapellaRequirements"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CapellaRequirementsPackage eINSTANCE = org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaTypesFolderImpl <em>Capella Types Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaTypesFolderImpl
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsPackageImpl#getCapellaTypesFolder()
	 * @generated
	 */
	int CAPELLA_TYPES_FOLDER = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_TYPES_FOLDER__ID = RequirementsPackage.TYPES_FOLDER__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_TYPES_FOLDER__REQ_IF_IDENTIFIER = RequirementsPackage.TYPES_FOLDER__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_TYPES_FOLDER__REQ_IF_DESCRIPTION = RequirementsPackage.TYPES_FOLDER__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_TYPES_FOLDER__REQ_IF_LONG_NAME = RequirementsPackage.TYPES_FOLDER__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Owned Definition Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_TYPES_FOLDER__OWNED_DEFINITION_TYPES = RequirementsPackage.TYPES_FOLDER__OWNED_DEFINITION_TYPES;

	/**
	 * The feature id for the '<em><b>Owned Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_TYPES_FOLDER__OWNED_TYPES = RequirementsPackage.TYPES_FOLDER__OWNED_TYPES;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_TYPES_FOLDER__OWNED_EXTENSIONS = RequirementsPackage.TYPES_FOLDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Capella Types Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_TYPES_FOLDER_FEATURE_COUNT = RequirementsPackage.TYPES_FOLDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaModuleImpl <em>Capella Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaModuleImpl
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsPackageImpl#getCapellaModule()
	 * @generated
	 */
	int CAPELLA_MODULE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_MODULE__ID = RequirementsPackage.MODULE__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_MODULE__REQ_IF_IDENTIFIER = RequirementsPackage.MODULE__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_MODULE__REQ_IF_DESCRIPTION = RequirementsPackage.MODULE__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_MODULE__REQ_IF_LONG_NAME = RequirementsPackage.MODULE__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_MODULE__OWNED_ATTRIBUTES = RequirementsPackage.MODULE__OWNED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Module Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_MODULE__MODULE_TYPE = RequirementsPackage.MODULE__MODULE_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_MODULE__OWNED_REQUIREMENTS = RequirementsPackage.MODULE__OWNED_REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_MODULE__OWNED_EXTENSIONS = RequirementsPackage.MODULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Capella Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_MODULE_FEATURE_COUNT = RequirementsPackage.MODULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRelationImpl <em>Capella Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRelationImpl
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsPackageImpl#getCapellaRelation()
	 * @generated
	 */
	int CAPELLA_RELATION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_RELATION__ID = RequirementsPackage.ABSTRACT_RELATION__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_RELATION__REQ_IF_IDENTIFIER = RequirementsPackage.ABSTRACT_RELATION__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_RELATION__REQ_IF_DESCRIPTION = RequirementsPackage.ABSTRACT_RELATION__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_RELATION__REQ_IF_LONG_NAME = RequirementsPackage.ABSTRACT_RELATION__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Relation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_RELATION__RELATION_TYPE = RequirementsPackage.ABSTRACT_RELATION__RELATION_TYPE;

	/**
	 * The feature id for the '<em><b>Req IF Relation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_RELATION__REQ_IF_RELATION_TYPE = RequirementsPackage.ABSTRACT_RELATION__REQ_IF_RELATION_TYPE;

	/**
	 * The number of structural features of the '<em>Capella Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_RELATION_FEATURE_COUNT = RequirementsPackage.ABSTRACT_RELATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaIncomingRelationImpl <em>Capella Incoming Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaIncomingRelationImpl
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsPackageImpl#getCapellaIncomingRelation()
	 * @generated
	 */
	int CAPELLA_INCOMING_RELATION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_INCOMING_RELATION__ID = CAPELLA_RELATION__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_INCOMING_RELATION__REQ_IF_IDENTIFIER = CAPELLA_RELATION__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_INCOMING_RELATION__REQ_IF_DESCRIPTION = CAPELLA_RELATION__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_INCOMING_RELATION__REQ_IF_LONG_NAME = CAPELLA_RELATION__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Relation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_INCOMING_RELATION__RELATION_TYPE = CAPELLA_RELATION__RELATION_TYPE;

	/**
	 * The feature id for the '<em><b>Req IF Relation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_INCOMING_RELATION__REQ_IF_RELATION_TYPE = CAPELLA_RELATION__REQ_IF_RELATION_TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_INCOMING_RELATION__SOURCE = CAPELLA_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_INCOMING_RELATION__TARGET = CAPELLA_RELATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Capella Incoming Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_INCOMING_RELATION_FEATURE_COUNT = CAPELLA_RELATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaOutgoingRelationImpl <em>Capella Outgoing Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaOutgoingRelationImpl
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsPackageImpl#getCapellaOutgoingRelation()
	 * @generated
	 */
	int CAPELLA_OUTGOING_RELATION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_OUTGOING_RELATION__ID = CAPELLA_RELATION__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_OUTGOING_RELATION__REQ_IF_IDENTIFIER = CAPELLA_RELATION__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_OUTGOING_RELATION__REQ_IF_DESCRIPTION = CAPELLA_RELATION__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_OUTGOING_RELATION__REQ_IF_LONG_NAME = CAPELLA_RELATION__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Relation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_OUTGOING_RELATION__RELATION_TYPE = CAPELLA_RELATION__RELATION_TYPE;

	/**
	 * The feature id for the '<em><b>Req IF Relation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_OUTGOING_RELATION__REQ_IF_RELATION_TYPE = CAPELLA_RELATION__REQ_IF_RELATION_TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_OUTGOING_RELATION__SOURCE = CAPELLA_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_OUTGOING_RELATION__TARGET = CAPELLA_RELATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Capella Outgoing Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPELLA_OUTGOING_RELATION_FEATURE_COUNT = CAPELLA_RELATION_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaTypesFolder <em>Capella Types Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capella Types Folder</em>'.
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaTypesFolder
	 * @generated
	 */
	EClass getCapellaTypesFolder();

	/**
	 * Returns the meta object for class '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaModule <em>Capella Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capella Module</em>'.
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaModule
	 * @generated
	 */
	EClass getCapellaModule();

	/**
	 * Returns the meta object for class '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRelation <em>Capella Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capella Relation</em>'.
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRelation
	 * @generated
	 */
	EClass getCapellaRelation();

	/**
	 * Returns the meta object for class '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation <em>Capella Incoming Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capella Incoming Relation</em>'.
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation
	 * @generated
	 */
	EClass getCapellaIncomingRelation();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation#getSource()
	 * @see #getCapellaIncomingRelation()
	 * @generated
	 */
	EReference getCapellaIncomingRelation_Source();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation#getTarget()
	 * @see #getCapellaIncomingRelation()
	 * @generated
	 */
	EReference getCapellaIncomingRelation_Target();

	/**
	 * Returns the meta object for class '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation <em>Capella Outgoing Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capella Outgoing Relation</em>'.
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation
	 * @generated
	 */
	EClass getCapellaOutgoingRelation();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation#getSource()
	 * @see #getCapellaOutgoingRelation()
	 * @generated
	 */
	EReference getCapellaOutgoingRelation_Source();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation#getTarget()
	 * @see #getCapellaOutgoingRelation()
	 * @generated
	 */
	EReference getCapellaOutgoingRelation_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CapellaRequirementsFactory getCapellaRequirementsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaTypesFolderImpl <em>Capella Types Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaTypesFolderImpl
		 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsPackageImpl#getCapellaTypesFolder()
		 * @generated
		 */
		EClass CAPELLA_TYPES_FOLDER = eINSTANCE.getCapellaTypesFolder();

		/**
		 * The meta object literal for the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaModuleImpl <em>Capella Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaModuleImpl
		 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsPackageImpl#getCapellaModule()
		 * @generated
		 */
		EClass CAPELLA_MODULE = eINSTANCE.getCapellaModule();

		/**
		 * The meta object literal for the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRelationImpl <em>Capella Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRelationImpl
		 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsPackageImpl#getCapellaRelation()
		 * @generated
		 */
		EClass CAPELLA_RELATION = eINSTANCE.getCapellaRelation();

		/**
		 * The meta object literal for the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaIncomingRelationImpl <em>Capella Incoming Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaIncomingRelationImpl
		 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsPackageImpl#getCapellaIncomingRelation()
		 * @generated
		 */
		EClass CAPELLA_INCOMING_RELATION = eINSTANCE.getCapellaIncomingRelation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPELLA_INCOMING_RELATION__SOURCE = eINSTANCE.getCapellaIncomingRelation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPELLA_INCOMING_RELATION__TARGET = eINSTANCE.getCapellaIncomingRelation_Target();

		/**
		 * The meta object literal for the '{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaOutgoingRelationImpl <em>Capella Outgoing Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaOutgoingRelationImpl
		 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaRequirementsPackageImpl#getCapellaOutgoingRelation()
		 * @generated
		 */
		EClass CAPELLA_OUTGOING_RELATION = eINSTANCE.getCapellaOutgoingRelation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPELLA_OUTGOING_RELATION__SOURCE = eINSTANCE.getCapellaOutgoingRelation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPELLA_OUTGOING_RELATION__TARGET = eINSTANCE.getCapellaOutgoingRelation_Target();

	}

} //CapellaRequirementsPackage
