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

package org.polarsys.kitalpha.vp.requirements.Requirements;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory
 * @model kind="package"
 * @generated
 */
public interface RequirementsPackage extends EPackage {
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
	String eNAME = "Requirements"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.polarsys.org/kitalpha/requirements"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Requirements"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RequirementsPackage eINSTANCE = org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ReqIFElementImpl <em>Req IF Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.ReqIFElementImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getReqIFElement()
	 * @generated
	 */
	int REQ_IF_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_IF_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_IF_ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_IF_ELEMENT__REQ_IF_IDENTIFIER = 2;

	/**
	 * The number of structural features of the '<em>Req IF Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_IF_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Req IF Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_IF_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractRelationImpl <em>Abstract Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractRelationImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAbstractRelation()
	 * @generated
	 */
	int ABSTRACT_RELATION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__NAME = REQ_IF_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Relation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__RELATION_TYPE = REQ_IF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Req IF Relation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__REQ_IF_RELATION_TYPE = REQ_IF_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Abstract Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION_FEATURE_COUNT = REQ_IF_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Abstract Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION_OPERATION_COUNT = REQ_IF_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.InternalRelationImpl <em>Internal Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.InternalRelationImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getInternalRelation()
	 * @generated
	 */
	int INTERNAL_RELATION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__ID = ABSTRACT_RELATION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__NAME = ABSTRACT_RELATION__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__REQ_IF_IDENTIFIER = ABSTRACT_RELATION__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Relation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__RELATION_TYPE = ABSTRACT_RELATION__RELATION_TYPE;

	/**
	 * The feature id for the '<em><b>Req IF Relation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__REQ_IF_RELATION_TYPE = ABSTRACT_RELATION__REQ_IF_RELATION_TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__SOURCE = ABSTRACT_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__TARGET = ABSTRACT_RELATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Internal Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION_FEATURE_COUNT = ABSTRACT_RELATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Internal Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION_OPERATION_COUNT = ABSTRACT_RELATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = REQ_IF_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DEFINITION = REQ_IF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__KEY = REQ_IF_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = REQ_IF_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = REQ_IF_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.StringValueAttributeImpl <em>String Value Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.StringValueAttributeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getStringValueAttribute()
	 * @generated
	 */
	int STRING_VALUE_ATTRIBUTE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_ATTRIBUTE__REQ_IF_IDENTIFIER = ATTRIBUTE__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_ATTRIBUTE__DEFINITION = ATTRIBUTE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_ATTRIBUTE__KEY = ATTRIBUTE__KEY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_ATTRIBUTE__VALUE = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.IntegerValueAttributeImpl <em>Integer Value Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.IntegerValueAttributeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getIntegerValueAttribute()
	 * @generated
	 */
	int INTEGER_VALUE_ATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_ATTRIBUTE__REQ_IF_IDENTIFIER = ATTRIBUTE__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_ATTRIBUTE__DEFINITION = ATTRIBUTE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_ATTRIBUTE__KEY = ATTRIBUTE__KEY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_ATTRIBUTE__VALUE = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Integer Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeOwnerImpl <em>Attribute Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeOwnerImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAttributeOwner()
	 * @generated
	 */
	int ATTRIBUTE_OWNER = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OWNER__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OWNER__NAME = REQ_IF_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OWNER__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OWNER__OWNED_ATTRIBUTES = REQ_IF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OWNER_FEATURE_COUNT = REQ_IF_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OWNER_OPERATION_COUNT = REQ_IF_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ID = ATTRIBUTE_OWNER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__NAME = ATTRIBUTE_OWNER__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_IDENTIFIER = ATTRIBUTE_OWNER__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__OWNED_ATTRIBUTES = ATTRIBUTE_OWNER__OWNED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Requirement Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQUIREMENT_TYPE = ATTRIBUTE_OWNER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__OWNED_RELATIONS = ATTRIBUTE_OWNER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Req IF Chapter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_CHAPTER_NAME = ATTRIBUTE_OWNER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Req IF Foreign ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_FOREIGN_ID = ATTRIBUTE_OWNER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Req IF Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_PREFIX = ATTRIBUTE_OWNER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Req IF Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_TEXT = ATTRIBUTE_OWNER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = ATTRIBUTE_OWNER_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_OPERATION_COUNT = ATTRIBUTE_OWNER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.FolderImpl <em>Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.FolderImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getFolder()
	 * @generated
	 */
	int FOLDER = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__ID = REQUIREMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__NAME = REQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQ_IF_IDENTIFIER = REQUIREMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__OWNED_ATTRIBUTES = REQUIREMENT__OWNED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Requirement Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQUIREMENT_TYPE = REQUIREMENT__REQUIREMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Owned Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__OWNED_RELATIONS = REQUIREMENT__OWNED_RELATIONS;

	/**
	 * The feature id for the '<em><b>Req IF Chapter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQ_IF_CHAPTER_NAME = REQUIREMENT__REQ_IF_CHAPTER_NAME;

	/**
	 * The feature id for the '<em><b>Req IF Foreign ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQ_IF_FOREIGN_ID = REQUIREMENT__REQ_IF_FOREIGN_ID;

	/**
	 * The feature id for the '<em><b>Req IF Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQ_IF_PREFIX = REQUIREMENT__REQ_IF_PREFIX;

	/**
	 * The feature id for the '<em><b>Req IF Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQ_IF_TEXT = REQUIREMENT__REQ_IF_TEXT;

	/**
	 * The feature id for the '<em><b>Owned Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__OWNED_REQUIREMENTS = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER_OPERATION_COUNT = REQUIREMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ID = ATTRIBUTE_OWNER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__NAME = ATTRIBUTE_OWNER__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__REQ_IF_IDENTIFIER = ATTRIBUTE_OWNER__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__OWNED_ATTRIBUTES = ATTRIBUTE_OWNER__OWNED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Module Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODULE_TYPE = ATTRIBUTE_OWNER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__OWNED_REQUIREMENTS = ATTRIBUTE_OWNER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = ATTRIBUTE_OWNER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_OPERATION_COUNT = ATTRIBUTE_OWNER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.TypesFolderImpl <em>Types Folder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.TypesFolderImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getTypesFolder()
	 * @generated
	 */
	int TYPES_FOLDER = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_FOLDER__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_FOLDER__NAME = REQ_IF_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_FOLDER__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Definition Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_FOLDER__OWNED_DEFINITION_TYPES = REQ_IF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_FOLDER__OWNED_TYPES = REQ_IF_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Types Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_FOLDER_FEATURE_COUNT = REQ_IF_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Types Folder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_FOLDER_OPERATION_COUNT = REQ_IF_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractTypeImpl <em>Abstract Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractTypeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAbstractType()
	 * @generated
	 */
	int ABSTRACT_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE__NAME = REQ_IF_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE__OWNED_ATTRIBUTES = REQ_IF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE_FEATURE_COUNT = REQ_IF_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE_OPERATION_COUNT = REQ_IF_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleTypeImpl <em>Module Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleTypeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getModuleType()
	 * @generated
	 */
	int MODULE_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE__ID = ABSTRACT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE__NAME = ABSTRACT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE__REQ_IF_IDENTIFIER = ABSTRACT_TYPE__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE__OWNED_ATTRIBUTES = ABSTRACT_TYPE__OWNED_ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Module Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE_FEATURE_COUNT = ABSTRACT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Module Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE_OPERATION_COUNT = ABSTRACT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementTypeImpl <em>Requirement Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementTypeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getRequirementType()
	 * @generated
	 */
	int REQUIREMENT_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_TYPE__ID = ABSTRACT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_TYPE__NAME = ABSTRACT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_TYPE__REQ_IF_IDENTIFIER = ABSTRACT_TYPE__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_TYPE__OWNED_ATTRIBUTES = ABSTRACT_TYPE__OWNED_ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Requirement Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_TYPE_FEATURE_COUNT = ABSTRACT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Requirement Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_TYPE_OPERATION_COUNT = ABSTRACT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RelationTypeImpl <em>Relation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RelationTypeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getRelationType()
	 * @generated
	 */
	int RELATION_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_TYPE__ID = ABSTRACT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_TYPE__NAME = ABSTRACT_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_TYPE__REQ_IF_IDENTIFIER = ABSTRACT_TYPE__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_TYPE__OWNED_ATTRIBUTES = ABSTRACT_TYPE__OWNED_ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Relation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_TYPE_FEATURE_COUNT = ABSTRACT_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Relation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_TYPE_OPERATION_COUNT = ABSTRACT_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.DataTypeDefinitionImpl <em>Data Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.DataTypeDefinitionImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getDataTypeDefinition()
	 * @generated
	 */
	int DATA_TYPE_DEFINITION = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__NAME = REQ_IF_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION_FEATURE_COUNT = REQ_IF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION_OPERATION_COUNT = REQ_IF_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeDefinitionImpl <em>Attribute Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeDefinitionImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAttributeDefinition()
	 * @generated
	 */
	int ATTRIBUTE_DEFINITION = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__NAME = REQ_IF_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Definition Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__DEFINITION_TYPE = REQ_IF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_FEATURE_COUNT = REQ_IF_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_OPERATION_COUNT = REQ_IF_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement <em>Req IF Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Req IF Element</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement
	 * @generated
	 */
	EClass getReqIFElement();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getId()
	 * @see #getReqIFElement()
	 * @generated
	 */
	EAttribute getReqIFElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getName()
	 * @see #getReqIFElement()
	 * @generated
	 */
	EAttribute getReqIFElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIF_Identifier <em>Req IF Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Identifier</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIF_Identifier()
	 * @see #getReqIFElement()
	 * @generated
	 */
	EAttribute getReqIFElement_ReqIF_Identifier();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation <em>Abstract Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Relation</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation
	 * @generated
	 */
	EClass getAbstractRelation();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation#getRelationType <em>Relation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Relation Type</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation#getRelationType()
	 * @see #getAbstractRelation()
	 * @generated
	 */
	EReference getAbstractRelation_RelationType();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation#getReqIF_RelationType <em>Req IF Relation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Relation Type</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation#getReqIF_RelationType()
	 * @see #getAbstractRelation()
	 * @generated
	 */
	EAttribute getAbstractRelation_ReqIF_RelationType();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation <em>Internal Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Relation</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation
	 * @generated
	 */
	EClass getInternalRelation();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation#getSource()
	 * @see #getInternalRelation()
	 * @generated
	 */
	EReference getInternalRelation_Source();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation#getTarget()
	 * @see #getInternalRelation()
	 * @generated
	 */
	EReference getInternalRelation_Target();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Attribute#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Attribute#getDefinition()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Definition();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Attribute#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Attribute#getKey()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Key();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute <em>String Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value Attribute</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute
	 * @generated
	 */
	EClass getStringValueAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute#getValue()
	 * @see #getStringValueAttribute()
	 * @generated
	 */
	EAttribute getStringValueAttribute_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute <em>Integer Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Value Attribute</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute
	 * @generated
	 */
	EClass getIntegerValueAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute#getValue()
	 * @see #getIntegerValueAttribute()
	 * @generated
	 */
	EAttribute getIntegerValueAttribute_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner <em>Attribute Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Owner</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner
	 * @generated
	 */
	EClass getAttributeOwner();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner#getOwnedAttributes <em>Owned Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Attributes</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner#getOwnedAttributes()
	 * @see #getAttributeOwner()
	 * @generated
	 */
	EReference getAttributeOwner_OwnedAttributes();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getRequirementType <em>Requirement Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Requirement Type</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getRequirementType()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_RequirementType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getOwnedRelations <em>Owned Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Relations</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getOwnedRelations()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_OwnedRelations();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIF_ChapterName <em>Req IF Chapter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Chapter Name</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIF_ChapterName()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_ReqIF_ChapterName();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIF_ForeignID <em>Req IF Foreign ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Foreign ID</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIF_ForeignID()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_ReqIF_ForeignID();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIF_Prefix <em>Req IF Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Prefix</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIF_Prefix()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_ReqIF_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIF_Text <em>Req IF Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Text</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIF_Text()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_ReqIF_Text();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folder</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Folder
	 * @generated
	 */
	EClass getFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Folder#getOwnedRequirements <em>Owned Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Requirements</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Folder#getOwnedRequirements()
	 * @see #getFolder()
	 * @generated
	 */
	EReference getFolder_OwnedRequirements();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Module#getModuleType <em>Module Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Module Type</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Module#getModuleType()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_ModuleType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Module#getOwnedRequirements <em>Owned Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Requirements</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Module#getOwnedRequirements()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_OwnedRequirements();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder <em>Types Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Types Folder</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder
	 * @generated
	 */
	EClass getTypesFolder();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder#getOwnedDefinitionTypes <em>Owned Definition Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Definition Types</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder#getOwnedDefinitionTypes()
	 * @see #getTypesFolder()
	 * @generated
	 */
	EReference getTypesFolder_OwnedDefinitionTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder#getOwnedTypes <em>Owned Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Types</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder#getOwnedTypes()
	 * @see #getTypesFolder()
	 * @generated
	 */
	EReference getTypesFolder_OwnedTypes();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType <em>Abstract Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Type</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType
	 * @generated
	 */
	EClass getAbstractType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType#getOwnedAttributes <em>Owned Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Attributes</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType#getOwnedAttributes()
	 * @see #getAbstractType()
	 * @generated
	 */
	EReference getAbstractType_OwnedAttributes();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ModuleType <em>Module Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module Type</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.ModuleType
	 * @generated
	 */
	EClass getModuleType();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType <em>Requirement Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement Type</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType
	 * @generated
	 */
	EClass getRequirementType();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.RelationType <em>Relation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Type</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RelationType
	 * @generated
	 */
	EClass getRelationType();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition <em>Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Definition</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition
	 * @generated
	 */
	EClass getDataTypeDefinition();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition <em>Attribute Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Definition</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition
	 * @generated
	 */
	EClass getAttributeDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition#getDefinitionType <em>Definition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition Type</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition#getDefinitionType()
	 * @see #getAttributeDefinition()
	 * @generated
	 */
	EReference getAttributeDefinition_DefinitionType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RequirementsFactory getRequirementsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ReqIFElementImpl <em>Req IF Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.ReqIFElementImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getReqIFElement()
		 * @generated
		 */
		EClass REQ_IF_ELEMENT = eINSTANCE.getReqIFElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQ_IF_ELEMENT__ID = eINSTANCE.getReqIFElement_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQ_IF_ELEMENT__NAME = eINSTANCE.getReqIFElement_Name();

		/**
		 * The meta object literal for the '<em><b>Req IF Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQ_IF_ELEMENT__REQ_IF_IDENTIFIER = eINSTANCE.getReqIFElement_ReqIF_Identifier();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractRelationImpl <em>Abstract Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractRelationImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAbstractRelation()
		 * @generated
		 */
		EClass ABSTRACT_RELATION = eINSTANCE.getAbstractRelation();

		/**
		 * The meta object literal for the '<em><b>Relation Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_RELATION__RELATION_TYPE = eINSTANCE.getAbstractRelation_RelationType();

		/**
		 * The meta object literal for the '<em><b>Req IF Relation Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_RELATION__REQ_IF_RELATION_TYPE = eINSTANCE.getAbstractRelation_ReqIF_RelationType();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.InternalRelationImpl <em>Internal Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.InternalRelationImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getInternalRelation()
		 * @generated
		 */
		EClass INTERNAL_RELATION = eINSTANCE.getInternalRelation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_RELATION__SOURCE = eINSTANCE.getInternalRelation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_RELATION__TARGET = eINSTANCE.getInternalRelation_Target();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__DEFINITION = eINSTANCE.getAttribute_Definition();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__KEY = eINSTANCE.getAttribute_Key();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.StringValueAttributeImpl <em>String Value Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.StringValueAttributeImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getStringValueAttribute()
		 * @generated
		 */
		EClass STRING_VALUE_ATTRIBUTE = eINSTANCE.getStringValueAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VALUE_ATTRIBUTE__VALUE = eINSTANCE.getStringValueAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.IntegerValueAttributeImpl <em>Integer Value Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.IntegerValueAttributeImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getIntegerValueAttribute()
		 * @generated
		 */
		EClass INTEGER_VALUE_ATTRIBUTE = eINSTANCE.getIntegerValueAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_VALUE_ATTRIBUTE__VALUE = eINSTANCE.getIntegerValueAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeOwnerImpl <em>Attribute Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeOwnerImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAttributeOwner()
		 * @generated
		 */
		EClass ATTRIBUTE_OWNER = eINSTANCE.getAttributeOwner();

		/**
		 * The meta object literal for the '<em><b>Owned Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_OWNER__OWNED_ATTRIBUTES = eINSTANCE.getAttributeOwner_OwnedAttributes();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Requirement Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__REQUIREMENT_TYPE = eINSTANCE.getRequirement_RequirementType();

		/**
		 * The meta object literal for the '<em><b>Owned Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__OWNED_RELATIONS = eINSTANCE.getRequirement_OwnedRelations();

		/**
		 * The meta object literal for the '<em><b>Req IF Chapter Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__REQ_IF_CHAPTER_NAME = eINSTANCE.getRequirement_ReqIF_ChapterName();

		/**
		 * The meta object literal for the '<em><b>Req IF Foreign ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__REQ_IF_FOREIGN_ID = eINSTANCE.getRequirement_ReqIF_ForeignID();

		/**
		 * The meta object literal for the '<em><b>Req IF Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__REQ_IF_PREFIX = eINSTANCE.getRequirement_ReqIF_Prefix();

		/**
		 * The meta object literal for the '<em><b>Req IF Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__REQ_IF_TEXT = eINSTANCE.getRequirement_ReqIF_Text();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.FolderImpl <em>Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.FolderImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getFolder()
		 * @generated
		 */
		EClass FOLDER = eINSTANCE.getFolder();

		/**
		 * The meta object literal for the '<em><b>Owned Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOLDER__OWNED_REQUIREMENTS = eINSTANCE.getFolder_OwnedRequirements();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Module Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__MODULE_TYPE = eINSTANCE.getModule_ModuleType();

		/**
		 * The meta object literal for the '<em><b>Owned Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__OWNED_REQUIREMENTS = eINSTANCE.getModule_OwnedRequirements();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.TypesFolderImpl <em>Types Folder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.TypesFolderImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getTypesFolder()
		 * @generated
		 */
		EClass TYPES_FOLDER = eINSTANCE.getTypesFolder();

		/**
		 * The meta object literal for the '<em><b>Owned Definition Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPES_FOLDER__OWNED_DEFINITION_TYPES = eINSTANCE.getTypesFolder_OwnedDefinitionTypes();

		/**
		 * The meta object literal for the '<em><b>Owned Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPES_FOLDER__OWNED_TYPES = eINSTANCE.getTypesFolder_OwnedTypes();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractTypeImpl <em>Abstract Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractTypeImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAbstractType()
		 * @generated
		 */
		EClass ABSTRACT_TYPE = eINSTANCE.getAbstractType();

		/**
		 * The meta object literal for the '<em><b>Owned Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TYPE__OWNED_ATTRIBUTES = eINSTANCE.getAbstractType_OwnedAttributes();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleTypeImpl <em>Module Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.ModuleTypeImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getModuleType()
		 * @generated
		 */
		EClass MODULE_TYPE = eINSTANCE.getModuleType();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementTypeImpl <em>Requirement Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementTypeImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getRequirementType()
		 * @generated
		 */
		EClass REQUIREMENT_TYPE = eINSTANCE.getRequirementType();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RelationTypeImpl <em>Relation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RelationTypeImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getRelationType()
		 * @generated
		 */
		EClass RELATION_TYPE = eINSTANCE.getRelationType();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.DataTypeDefinitionImpl <em>Data Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.DataTypeDefinitionImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getDataTypeDefinition()
		 * @generated
		 */
		EClass DATA_TYPE_DEFINITION = eINSTANCE.getDataTypeDefinition();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeDefinitionImpl <em>Attribute Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeDefinitionImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAttributeDefinition()
		 * @generated
		 */
		EClass ATTRIBUTE_DEFINITION = eINSTANCE.getAttributeDefinition();

		/**
		 * The meta object literal for the '<em><b>Definition Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_DEFINITION__DEFINITION_TYPE = eINSTANCE.getAttributeDefinition_DefinitionType();

	}

} //RequirementsPackage
