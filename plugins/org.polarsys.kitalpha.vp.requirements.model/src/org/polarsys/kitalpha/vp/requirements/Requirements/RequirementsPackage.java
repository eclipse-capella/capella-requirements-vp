/**
 *
 *  Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
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
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.IdentifiableElementImpl <em>Identifiable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.IdentifiableElementImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getIdentifiableElement()
	 * @generated
	 */
	int IDENTIFIABLE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ELEMENT__ID = 0;

	/**
	 * The number of structural features of the '<em>Identifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Identifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.ReqIFElementImpl <em>Req IF Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.ReqIFElementImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getReqIFElement()
	 * @generated
	 */
	int REQ_IF_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_IF_ELEMENT__ID = IDENTIFIABLE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_IF_ELEMENT__REQ_IF_IDENTIFIER = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_IF_ELEMENT__REQ_IF_DESCRIPTION = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_IF_ELEMENT__REQ_IF_LONG_NAME = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Req IF Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_IF_ELEMENT_FEATURE_COUNT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Req IF Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQ_IF_ELEMENT_OPERATION_COUNT = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractRelationImpl <em>Abstract Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AbstractRelationImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAbstractRelation()
	 * @generated
	 */
	int ABSTRACT_RELATION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__REQ_IF_DESCRIPTION = REQ_IF_ELEMENT__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__REQ_IF_LONG_NAME = REQ_IF_ELEMENT__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Relation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__RELATION_TYPE = REQ_IF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Relation Type Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATION__RELATION_TYPE_PROXY = REQ_IF_ELEMENT_FEATURE_COUNT + 1;

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
	int INTERNAL_RELATION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__ID = ABSTRACT_RELATION__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__REQ_IF_IDENTIFIER = ABSTRACT_RELATION__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__REQ_IF_DESCRIPTION = ABSTRACT_RELATION__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__REQ_IF_LONG_NAME = ABSTRACT_RELATION__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Relation Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__RELATION_TYPE = ABSTRACT_RELATION__RELATION_TYPE;

	/**
	 * The feature id for the '<em><b>Relation Type Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_RELATION__RELATION_TYPE_PROXY = ABSTRACT_RELATION__RELATION_TYPE_PROXY;

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
	int ATTRIBUTE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ID = IDENTIFIABLE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DEFINITION = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Definition Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DEFINITION_PROXY = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = IDENTIFIABLE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.StringValueAttributeImpl <em>String Value Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.StringValueAttributeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getStringValueAttribute()
	 * @generated
	 */
	int STRING_VALUE_ATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_ATTRIBUTE__DEFINITION = ATTRIBUTE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Definition Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_ATTRIBUTE__DEFINITION_PROXY = ATTRIBUTE__DEFINITION_PROXY;

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
	int INTEGER_VALUE_ATTRIBUTE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_ATTRIBUTE__DEFINITION = ATTRIBUTE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Definition Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_ATTRIBUTE__DEFINITION_PROXY = ATTRIBUTE__DEFINITION_PROXY;

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
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.BooleanValueAttributeImpl <em>Boolean Value Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.BooleanValueAttributeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getBooleanValueAttribute()
	 * @generated
	 */
	int BOOLEAN_VALUE_ATTRIBUTE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_ATTRIBUTE__DEFINITION = ATTRIBUTE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Definition Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_ATTRIBUTE__DEFINITION_PROXY = ATTRIBUTE__DEFINITION_PROXY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_ATTRIBUTE__VALUE = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RealValueAttributeImpl <em>Real Value Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RealValueAttributeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getRealValueAttribute()
	 * @generated
	 */
	int REAL_VALUE_ATTRIBUTE = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_ATTRIBUTE__DEFINITION = ATTRIBUTE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Definition Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_ATTRIBUTE__DEFINITION_PROXY = ATTRIBUTE__DEFINITION_PROXY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_ATTRIBUTE__VALUE = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Real Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.DateValueAttributeImpl <em>Date Value Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.DateValueAttributeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getDateValueAttribute()
	 * @generated
	 */
	int DATE_VALUE_ATTRIBUTE = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VALUE_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VALUE_ATTRIBUTE__DEFINITION = ATTRIBUTE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Definition Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VALUE_ATTRIBUTE__DEFINITION_PROXY = ATTRIBUTE__DEFINITION_PROXY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VALUE_ATTRIBUTE__VALUE = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Date Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VALUE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Date Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VALUE_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.SharedDirectAttributesImpl <em>Shared Direct Attributes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.SharedDirectAttributesImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getSharedDirectAttributes()
	 * @generated
	 */
	int SHARED_DIRECT_ATTRIBUTES = 10;

	/**
	 * The feature id for the '<em><b>Req IF Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME = 0;

	/**
	 * The feature id for the '<em><b>Req IF Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX = 1;

	/**
	 * The number of structural features of the '<em>Shared Direct Attributes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DIRECT_ATTRIBUTES_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Shared Direct Attributes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DIRECT_ATTRIBUTES_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeOwnerImpl <em>Attribute Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeOwnerImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAttributeOwner()
	 * @generated
	 */
	int ATTRIBUTE_OWNER = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OWNER__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OWNER__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OWNER__REQ_IF_DESCRIPTION = REQ_IF_ELEMENT__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OWNER__REQ_IF_LONG_NAME = REQ_IF_ELEMENT__REQ_IF_LONG_NAME;

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
	int REQUIREMENT = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ID = ATTRIBUTE_OWNER__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_IDENTIFIER = ATTRIBUTE_OWNER__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_DESCRIPTION = ATTRIBUTE_OWNER__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_LONG_NAME = ATTRIBUTE_OWNER__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__OWNED_ATTRIBUTES = ATTRIBUTE_OWNER__OWNED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Req IF Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_NAME = ATTRIBUTE_OWNER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Req IF Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_PREFIX = ATTRIBUTE_OWNER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requirement Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQUIREMENT_TYPE = ATTRIBUTE_OWNER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__OWNED_RELATIONS = ATTRIBUTE_OWNER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Req IF Chapter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_CHAPTER_NAME = ATTRIBUTE_OWNER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Req IF Foreign ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_FOREIGN_ID = ATTRIBUTE_OWNER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Req IF Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQ_IF_TEXT = ATTRIBUTE_OWNER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Requirement Type Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQUIREMENT_TYPE_PROXY = ATTRIBUTE_OWNER_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = ATTRIBUTE_OWNER_FEATURE_COUNT + 8;

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
	int FOLDER = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__ID = REQUIREMENT__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQ_IF_IDENTIFIER = REQUIREMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQ_IF_DESCRIPTION = REQUIREMENT__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQ_IF_LONG_NAME = REQUIREMENT__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__OWNED_ATTRIBUTES = REQUIREMENT__OWNED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Req IF Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQ_IF_NAME = REQUIREMENT__REQ_IF_NAME;

	/**
	 * The feature id for the '<em><b>Req IF Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQ_IF_PREFIX = REQUIREMENT__REQ_IF_PREFIX;

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
	 * The feature id for the '<em><b>Req IF Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQ_IF_TEXT = REQUIREMENT__REQ_IF_TEXT;

	/**
	 * The feature id for the '<em><b>Requirement Type Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDER__REQUIREMENT_TYPE_PROXY = REQUIREMENT__REQUIREMENT_TYPE_PROXY;

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
	int MODULE = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__ID = ATTRIBUTE_OWNER__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__REQ_IF_IDENTIFIER = ATTRIBUTE_OWNER__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__REQ_IF_DESCRIPTION = ATTRIBUTE_OWNER__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__REQ_IF_LONG_NAME = ATTRIBUTE_OWNER__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__OWNED_ATTRIBUTES = ATTRIBUTE_OWNER__OWNED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Req IF Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__REQ_IF_NAME = ATTRIBUTE_OWNER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Req IF Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__REQ_IF_PREFIX = ATTRIBUTE_OWNER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Module Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODULE_TYPE = ATTRIBUTE_OWNER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__OWNED_REQUIREMENTS = ATTRIBUTE_OWNER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = ATTRIBUTE_OWNER_FEATURE_COUNT + 4;

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
	int TYPES_FOLDER = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_FOLDER__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_FOLDER__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_FOLDER__REQ_IF_DESCRIPTION = REQ_IF_ELEMENT__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPES_FOLDER__REQ_IF_LONG_NAME = REQ_IF_ELEMENT__REQ_IF_LONG_NAME;

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
	int ABSTRACT_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE__REQ_IF_DESCRIPTION = REQ_IF_ELEMENT__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TYPE__REQ_IF_LONG_NAME = REQ_IF_ELEMENT__REQ_IF_LONG_NAME;

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
	int MODULE_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE__ID = ABSTRACT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE__REQ_IF_IDENTIFIER = ABSTRACT_TYPE__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE__REQ_IF_DESCRIPTION = ABSTRACT_TYPE__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_TYPE__REQ_IF_LONG_NAME = ABSTRACT_TYPE__REQ_IF_LONG_NAME;

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
	int REQUIREMENT_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_TYPE__ID = ABSTRACT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_TYPE__REQ_IF_IDENTIFIER = ABSTRACT_TYPE__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_TYPE__REQ_IF_DESCRIPTION = ABSTRACT_TYPE__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_TYPE__REQ_IF_LONG_NAME = ABSTRACT_TYPE__REQ_IF_LONG_NAME;

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
	int RELATION_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_TYPE__ID = ABSTRACT_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_TYPE__REQ_IF_IDENTIFIER = ABSTRACT_TYPE__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_TYPE__REQ_IF_DESCRIPTION = ABSTRACT_TYPE__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_TYPE__REQ_IF_LONG_NAME = ABSTRACT_TYPE__REQ_IF_LONG_NAME;

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
	int DATA_TYPE_DEFINITION = 20;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__REQ_IF_DESCRIPTION = REQ_IF_ELEMENT__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__REQ_IF_LONG_NAME = REQ_IF_ELEMENT__REQ_IF_LONG_NAME;

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
	int ATTRIBUTE_DEFINITION = 21;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__REQ_IF_DESCRIPTION = REQ_IF_ELEMENT__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__REQ_IF_LONG_NAME = REQ_IF_ELEMENT__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Definition Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__DEFINITION_TYPE = REQ_IF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__DEFAULT_VALUE = REQ_IF_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_FEATURE_COUNT = REQ_IF_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_OPERATION_COUNT = REQ_IF_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeDefinitionEnumerationImpl <em>Attribute Definition Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeDefinitionEnumerationImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAttributeDefinitionEnumeration()
	 * @generated
	 */
	int ATTRIBUTE_DEFINITION_ENUMERATION = 22;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_ENUMERATION__ID = ATTRIBUTE_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_ENUMERATION__REQ_IF_IDENTIFIER = ATTRIBUTE_DEFINITION__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_ENUMERATION__REQ_IF_DESCRIPTION = ATTRIBUTE_DEFINITION__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_ENUMERATION__REQ_IF_LONG_NAME = ATTRIBUTE_DEFINITION__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Definition Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_ENUMERATION__DEFINITION_TYPE = ATTRIBUTE_DEFINITION__DEFINITION_TYPE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_ENUMERATION__DEFAULT_VALUE = ATTRIBUTE_DEFINITION__DEFAULT_VALUE;

	/**
	 * The feature id for the '<em><b>Multi Valued</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED = ATTRIBUTE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Definition Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_ENUMERATION_FEATURE_COUNT = ATTRIBUTE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Definition Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_ENUMERATION_OPERATION_COUNT = ATTRIBUTE_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumerationValueAttributeImpl <em>Enumeration Value Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumerationValueAttributeImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getEnumerationValueAttribute()
	 * @generated
	 */
	int ENUMERATION_VALUE_ATTRIBUTE = 23;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_ATTRIBUTE__DEFINITION = ATTRIBUTE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Definition Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_ATTRIBUTE__DEFINITION_PROXY = ATTRIBUTE__DEFINITION_PROXY;

	/**
	 * The feature id for the '<em><b>Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_ATTRIBUTE__VALUES = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enumeration Value Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_VALUE_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumerationDataTypeDefinitionImpl <em>Enumeration Data Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumerationDataTypeDefinitionImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getEnumerationDataTypeDefinition()
	 * @generated
	 */
	int ENUMERATION_DATA_TYPE_DEFINITION = 24;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DATA_TYPE_DEFINITION__ID = DATA_TYPE_DEFINITION__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DATA_TYPE_DEFINITION__REQ_IF_IDENTIFIER = DATA_TYPE_DEFINITION__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DATA_TYPE_DEFINITION__REQ_IF_DESCRIPTION = DATA_TYPE_DEFINITION__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DATA_TYPE_DEFINITION__REQ_IF_LONG_NAME = DATA_TYPE_DEFINITION__REQ_IF_LONG_NAME;

	/**
	 * The feature id for the '<em><b>Specified Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DATA_TYPE_DEFINITION__SPECIFIED_VALUES = DATA_TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DATA_TYPE_DEFINITION_FEATURE_COUNT = DATA_TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enumeration Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DATA_TYPE_DEFINITION_OPERATION_COUNT = DATA_TYPE_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumValueImpl <em>Enum Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumValueImpl
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getEnumValue()
	 * @generated
	 */
	int ENUM_VALUE = 25;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE__ID = REQ_IF_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Req IF Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE__REQ_IF_IDENTIFIER = REQ_IF_ELEMENT__REQ_IF_IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Req IF Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE__REQ_IF_DESCRIPTION = REQ_IF_ELEMENT__REQ_IF_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Req IF Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE__REQ_IF_LONG_NAME = REQ_IF_ELEMENT__REQ_IF_LONG_NAME;

	/**
	 * The number of structural features of the '<em>Enum Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE_FEATURE_COUNT = REQ_IF_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Enum Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_VALUE_OPERATION_COUNT = REQ_IF_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement <em>Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable Element</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement
	 * @generated
	 */
	EClass getIdentifiableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement#getId()
	 * @see #getIdentifiableElement()
	 * @generated
	 */
	EAttribute getIdentifiableElement_Id();

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
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFIdentifier <em>Req IF Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Identifier</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFIdentifier()
	 * @see #getReqIFElement()
	 * @generated
	 */
	EAttribute getReqIFElement_ReqIFIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFDescription <em>Req IF Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Description</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFDescription()
	 * @see #getReqIFElement()
	 * @generated
	 */
	EAttribute getReqIFElement_ReqIFDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFLongName <em>Req IF Long Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Long Name</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement#getReqIFLongName()
	 * @see #getReqIFElement()
	 * @generated
	 */
	EAttribute getReqIFElement_ReqIFLongName();

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
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation#getRelationTypeProxy <em>Relation Type Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relation Type Proxy</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation#getRelationTypeProxy()
	 * @see #getAbstractRelation()
	 * @generated
	 */
	EAttribute getAbstractRelation_RelationTypeProxy();

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
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Attribute#getDefinitionProxy <em>Definition Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Definition Proxy</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Attribute#getDefinitionProxy()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_DefinitionProxy();

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
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute <em>Boolean Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Value Attribute</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute
	 * @generated
	 */
	EClass getBooleanValueAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute#isValue()
	 * @see #getBooleanValueAttribute()
	 * @generated
	 */
	EAttribute getBooleanValueAttribute_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute <em>Real Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Value Attribute</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute
	 * @generated
	 */
	EClass getRealValueAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute#getValue()
	 * @see #getRealValueAttribute()
	 * @generated
	 */
	EAttribute getRealValueAttribute_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute <em>Date Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date Value Attribute</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute
	 * @generated
	 */
	EClass getDateValueAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute#getValue()
	 * @see #getDateValueAttribute()
	 * @generated
	 */
	EAttribute getDateValueAttribute_Value();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes <em>Shared Direct Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shared Direct Attributes</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes
	 * @generated
	 */
	EClass getSharedDirectAttributes();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes#getReqIFName <em>Req IF Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Name</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes#getReqIFName()
	 * @see #getSharedDirectAttributes()
	 * @generated
	 */
	EAttribute getSharedDirectAttributes_ReqIFName();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes#getReqIFPrefix <em>Req IF Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Prefix</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes#getReqIFPrefix()
	 * @see #getSharedDirectAttributes()
	 * @generated
	 */
	EAttribute getSharedDirectAttributes_ReqIFPrefix();

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
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFChapterName <em>Req IF Chapter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Chapter Name</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFChapterName()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_ReqIFChapterName();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFForeignID <em>Req IF Foreign ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Foreign ID</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFForeignID()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_ReqIFForeignID();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFText <em>Req IF Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Req IF Text</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getReqIFText()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_ReqIFText();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getRequirementTypeProxy <em>Requirement Type Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirement Type Proxy</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement#getRequirementTypeProxy()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_RequirementTypeProxy();

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
	 * Returns the meta object for the containment reference '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition#getDefaultValue()
	 * @see #getAttributeDefinition()
	 * @generated
	 */
	EReference getAttributeDefinition_DefaultValue();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration <em>Attribute Definition Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Definition Enumeration</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration
	 * @generated
	 */
	EClass getAttributeDefinitionEnumeration();

	/**
	 * Returns the meta object for the attribute '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration#isMultiValued <em>Multi Valued</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multi Valued</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration#isMultiValued()
	 * @see #getAttributeDefinitionEnumeration()
	 * @generated
	 */
	EAttribute getAttributeDefinitionEnumeration_MultiValued();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute <em>Enumeration Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Value Attribute</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute
	 * @generated
	 */
	EClass getEnumerationValueAttribute();

	/**
	 * Returns the meta object for the reference list '{@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Values</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute#getValues()
	 * @see #getEnumerationValueAttribute()
	 * @generated
	 */
	EReference getEnumerationValueAttribute_Values();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition <em>Enumeration Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Data Type Definition</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition
	 * @generated
	 */
	EClass getEnumerationDataTypeDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition#getSpecifiedValues <em>Specified Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Specified Values</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition#getSpecifiedValues()
	 * @see #getEnumerationDataTypeDefinition()
	 * @generated
	 */
	EReference getEnumerationDataTypeDefinition_SpecifiedValues();

	/**
	 * Returns the meta object for class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumValue <em>Enum Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Value</em>'.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.EnumValue
	 * @generated
	 */
	EClass getEnumValue();

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
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.IdentifiableElementImpl <em>Identifiable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.IdentifiableElementImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getIdentifiableElement()
		 * @generated
		 */
		EClass IDENTIFIABLE_ELEMENT = eINSTANCE.getIdentifiableElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE_ELEMENT__ID = eINSTANCE.getIdentifiableElement_Id();

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
		 * The meta object literal for the '<em><b>Req IF Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQ_IF_ELEMENT__REQ_IF_IDENTIFIER = eINSTANCE.getReqIFElement_ReqIFIdentifier();

		/**
		 * The meta object literal for the '<em><b>Req IF Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQ_IF_ELEMENT__REQ_IF_DESCRIPTION = eINSTANCE.getReqIFElement_ReqIFDescription();

		/**
		 * The meta object literal for the '<em><b>Req IF Long Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQ_IF_ELEMENT__REQ_IF_LONG_NAME = eINSTANCE.getReqIFElement_ReqIFLongName();

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
		 * The meta object literal for the '<em><b>Relation Type Proxy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_RELATION__RELATION_TYPE_PROXY = eINSTANCE.getAbstractRelation_RelationTypeProxy();

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
		 * The meta object literal for the '<em><b>Definition Proxy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__DEFINITION_PROXY = eINSTANCE.getAttribute_DefinitionProxy();

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
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.BooleanValueAttributeImpl <em>Boolean Value Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.BooleanValueAttributeImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getBooleanValueAttribute()
		 * @generated
		 */
		EClass BOOLEAN_VALUE_ATTRIBUTE = eINSTANCE.getBooleanValueAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_VALUE_ATTRIBUTE__VALUE = eINSTANCE.getBooleanValueAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.RealValueAttributeImpl <em>Real Value Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RealValueAttributeImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getRealValueAttribute()
		 * @generated
		 */
		EClass REAL_VALUE_ATTRIBUTE = eINSTANCE.getRealValueAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_VALUE_ATTRIBUTE__VALUE = eINSTANCE.getRealValueAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.DateValueAttributeImpl <em>Date Value Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.DateValueAttributeImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getDateValueAttribute()
		 * @generated
		 */
		EClass DATE_VALUE_ATTRIBUTE = eINSTANCE.getDateValueAttribute();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_VALUE_ATTRIBUTE__VALUE = eINSTANCE.getDateValueAttribute_Value();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.SharedDirectAttributesImpl <em>Shared Direct Attributes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.SharedDirectAttributesImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getSharedDirectAttributes()
		 * @generated
		 */
		EClass SHARED_DIRECT_ATTRIBUTES = eINSTANCE.getSharedDirectAttributes();

		/**
		 * The meta object literal for the '<em><b>Req IF Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME = eINSTANCE.getSharedDirectAttributes_ReqIFName();

		/**
		 * The meta object literal for the '<em><b>Req IF Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX = eINSTANCE.getSharedDirectAttributes_ReqIFPrefix();

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
		EAttribute REQUIREMENT__REQ_IF_CHAPTER_NAME = eINSTANCE.getRequirement_ReqIFChapterName();

		/**
		 * The meta object literal for the '<em><b>Req IF Foreign ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__REQ_IF_FOREIGN_ID = eINSTANCE.getRequirement_ReqIFForeignID();

		/**
		 * The meta object literal for the '<em><b>Req IF Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__REQ_IF_TEXT = eINSTANCE.getRequirement_ReqIFText();

		/**
		 * The meta object literal for the '<em><b>Requirement Type Proxy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__REQUIREMENT_TYPE_PROXY = eINSTANCE.getRequirement_RequirementTypeProxy();

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

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_DEFINITION__DEFAULT_VALUE = eINSTANCE.getAttributeDefinition_DefaultValue();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeDefinitionEnumerationImpl <em>Attribute Definition Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.AttributeDefinitionEnumerationImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getAttributeDefinitionEnumeration()
		 * @generated
		 */
		EClass ATTRIBUTE_DEFINITION_ENUMERATION = eINSTANCE.getAttributeDefinitionEnumeration();

		/**
		 * The meta object literal for the '<em><b>Multi Valued</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED = eINSTANCE
				.getAttributeDefinitionEnumeration_MultiValued();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumerationValueAttributeImpl <em>Enumeration Value Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumerationValueAttributeImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getEnumerationValueAttribute()
		 * @generated
		 */
		EClass ENUMERATION_VALUE_ATTRIBUTE = eINSTANCE.getEnumerationValueAttribute();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_VALUE_ATTRIBUTE__VALUES = eINSTANCE.getEnumerationValueAttribute_Values();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumerationDataTypeDefinitionImpl <em>Enumeration Data Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumerationDataTypeDefinitionImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getEnumerationDataTypeDefinition()
		 * @generated
		 */
		EClass ENUMERATION_DATA_TYPE_DEFINITION = eINSTANCE.getEnumerationDataTypeDefinition();

		/**
		 * The meta object literal for the '<em><b>Specified Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_DATA_TYPE_DEFINITION__SPECIFIED_VALUES = eINSTANCE
				.getEnumerationDataTypeDefinition_SpecifiedValues();

		/**
		 * The meta object literal for the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumValueImpl <em>Enum Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.EnumValueImpl
		 * @see org.polarsys.kitalpha.vp.requirements.Requirements.impl.RequirementsPackageImpl#getEnumValue()
		 * @generated
		 */
		EClass ENUM_VALUE = eINSTANCE.getEnumValue();

	}

} //RequirementsPackage
