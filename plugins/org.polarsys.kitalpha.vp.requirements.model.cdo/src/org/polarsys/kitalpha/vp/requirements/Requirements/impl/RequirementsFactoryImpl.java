/**
 *
 *  Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */

package org.polarsys.kitalpha.vp.requirements.Requirements.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.polarsys.kitalpha.vp.requirements.Requirements.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementsFactoryImpl extends EFactoryImpl implements RequirementsFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RequirementsFactory init() {
		try {
			RequirementsFactory theRequirementsFactory = (RequirementsFactory) EPackage.Registry.INSTANCE
					.getEFactory(RequirementsPackage.eNS_URI);
			if (theRequirementsFactory != null) {
				return theRequirementsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RequirementsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsFactoryImpl() {
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
		case RequirementsPackage.INTERNAL_RELATION:
			return (EObject) createInternalRelation();
		case RequirementsPackage.STRING_VALUE_ATTRIBUTE:
			return (EObject) createStringValueAttribute();
		case RequirementsPackage.INTEGER_VALUE_ATTRIBUTE:
			return (EObject) createIntegerValueAttribute();
		case RequirementsPackage.BOOLEAN_VALUE_ATTRIBUTE:
			return (EObject) createBooleanValueAttribute();
		case RequirementsPackage.REAL_VALUE_ATTRIBUTE:
			return (EObject) createRealValueAttribute();
		case RequirementsPackage.DATE_VALUE_ATTRIBUTE:
			return (EObject) createDateValueAttribute();
		case RequirementsPackage.REQUIREMENT:
			return (EObject) createRequirement();
		case RequirementsPackage.FOLDER:
			return (EObject) createFolder();
		case RequirementsPackage.MODULE:
			return (EObject) createModule();
		case RequirementsPackage.TYPES_FOLDER:
			return (EObject) createTypesFolder();
		case RequirementsPackage.MODULE_TYPE:
			return (EObject) createModuleType();
		case RequirementsPackage.REQUIREMENT_TYPE:
			return (EObject) createRequirementType();
		case RequirementsPackage.RELATION_TYPE:
			return (EObject) createRelationType();
		case RequirementsPackage.DATA_TYPE_DEFINITION:
			return (EObject) createDataTypeDefinition();
		case RequirementsPackage.ATTRIBUTE_DEFINITION:
			return (EObject) createAttributeDefinition();
		case RequirementsPackage.ATTRIBUTE_DEFINITION_ENUMERATION:
			return (EObject) createAttributeDefinitionEnumeration();
		case RequirementsPackage.ENUMERATION_VALUE_ATTRIBUTE:
			return (EObject) createEnumerationValueAttribute();
		case RequirementsPackage.ENUMERATION_DATA_TYPE_DEFINITION:
			return (EObject) createEnumerationDataTypeDefinition();
		case RequirementsPackage.ENUM_VALUE:
			return (EObject) createEnumValue();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalRelation createInternalRelation() {
		InternalRelationImpl internalRelation = new InternalRelationImpl();
		return internalRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringValueAttribute createStringValueAttribute() {
		StringValueAttributeImpl stringValueAttribute = new StringValueAttributeImpl();
		return stringValueAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerValueAttribute createIntegerValueAttribute() {
		IntegerValueAttributeImpl integerValueAttribute = new IntegerValueAttributeImpl();
		return integerValueAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanValueAttribute createBooleanValueAttribute() {
		BooleanValueAttributeImpl booleanValueAttribute = new BooleanValueAttributeImpl();
		return booleanValueAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealValueAttribute createRealValueAttribute() {
		RealValueAttributeImpl realValueAttribute = new RealValueAttributeImpl();
		return realValueAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateValueAttribute createDateValueAttribute() {
		DateValueAttributeImpl dateValueAttribute = new DateValueAttributeImpl();
		return dateValueAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement createRequirement() {
		RequirementImpl requirement = new RequirementImpl();
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder createFolder() {
		FolderImpl folder = new FolderImpl();
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		ModuleImpl module = new ModuleImpl();
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFolder createTypesFolder() {
		TypesFolderImpl typesFolder = new TypesFolderImpl();
		return typesFolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleType createModuleType() {
		ModuleTypeImpl moduleType = new ModuleTypeImpl();
		return moduleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementType createRequirementType() {
		RequirementTypeImpl requirementType = new RequirementTypeImpl();
		return requirementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationType createRelationType() {
		RelationTypeImpl relationType = new RelationTypeImpl();
		return relationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeDefinition createDataTypeDefinition() {
		DataTypeDefinitionImpl dataTypeDefinition = new DataTypeDefinitionImpl();
		return dataTypeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDefinition createAttributeDefinition() {
		AttributeDefinitionImpl attributeDefinition = new AttributeDefinitionImpl();
		return attributeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeDefinitionEnumeration createAttributeDefinitionEnumeration() {
		AttributeDefinitionEnumerationImpl attributeDefinitionEnumeration = new AttributeDefinitionEnumerationImpl();
		return attributeDefinitionEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationValueAttribute createEnumerationValueAttribute() {
		EnumerationValueAttributeImpl enumerationValueAttribute = new EnumerationValueAttributeImpl();
		return enumerationValueAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationDataTypeDefinition createEnumerationDataTypeDefinition() {
		EnumerationDataTypeDefinitionImpl enumerationDataTypeDefinition = new EnumerationDataTypeDefinitionImpl();
		return enumerationDataTypeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumValue createEnumValue() {
		EnumValueImpl enumValue = new EnumValueImpl();
		return enumValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsPackage getRequirementsPackage() {
		return (RequirementsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RequirementsPackage getPackage() {
		return RequirementsPackage.eINSTANCE;
	}

} //RequirementsFactoryImpl
