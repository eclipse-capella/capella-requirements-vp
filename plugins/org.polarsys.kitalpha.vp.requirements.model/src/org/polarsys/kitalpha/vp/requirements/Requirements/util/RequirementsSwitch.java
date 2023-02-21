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

package org.polarsys.kitalpha.vp.requirements.Requirements.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.polarsys.kitalpha.emde.model.Element;

import org.polarsys.kitalpha.emde.model.ExtensibleElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner;
import org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumValue;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.Folder;
import org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Module;
import org.polarsys.kitalpha.vp.requirements.Requirements.ModuleType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes;
import org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage
 * @generated
 */
public class RequirementsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RequirementsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsSwitch() {
		if (modelPackage == null) {
			modelPackage = RequirementsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case RequirementsPackage.IDENTIFIABLE_ELEMENT: {
			IdentifiableElement identifiableElement = (IdentifiableElement) theEObject;
			T result = caseIdentifiableElement(identifiableElement);
			if (result == null)
				result = caseExtensibleElement(identifiableElement);
			if (result == null)
				result = caseElement(identifiableElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.REQ_IF_ELEMENT: {
			ReqIFElement reqIFElement = (ReqIFElement) theEObject;
			T result = caseReqIFElement(reqIFElement);
			if (result == null)
				result = caseIdentifiableElement(reqIFElement);
			if (result == null)
				result = caseExtensibleElement(reqIFElement);
			if (result == null)
				result = caseElement(reqIFElement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.ABSTRACT_RELATION: {
			AbstractRelation abstractRelation = (AbstractRelation) theEObject;
			T result = caseAbstractRelation(abstractRelation);
			if (result == null)
				result = caseReqIFElement(abstractRelation);
			if (result == null)
				result = caseIdentifiableElement(abstractRelation);
			if (result == null)
				result = caseExtensibleElement(abstractRelation);
			if (result == null)
				result = caseElement(abstractRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.INTERNAL_RELATION: {
			InternalRelation internalRelation = (InternalRelation) theEObject;
			T result = caseInternalRelation(internalRelation);
			if (result == null)
				result = caseAbstractRelation(internalRelation);
			if (result == null)
				result = caseReqIFElement(internalRelation);
			if (result == null)
				result = caseIdentifiableElement(internalRelation);
			if (result == null)
				result = caseExtensibleElement(internalRelation);
			if (result == null)
				result = caseElement(internalRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.ATTRIBUTE: {
			Attribute attribute = (Attribute) theEObject;
			T result = caseAttribute(attribute);
			if (result == null)
				result = caseIdentifiableElement(attribute);
			if (result == null)
				result = caseExtensibleElement(attribute);
			if (result == null)
				result = caseElement(attribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.STRING_VALUE_ATTRIBUTE: {
			StringValueAttribute stringValueAttribute = (StringValueAttribute) theEObject;
			T result = caseStringValueAttribute(stringValueAttribute);
			if (result == null)
				result = caseAttribute(stringValueAttribute);
			if (result == null)
				result = caseIdentifiableElement(stringValueAttribute);
			if (result == null)
				result = caseExtensibleElement(stringValueAttribute);
			if (result == null)
				result = caseElement(stringValueAttribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.INTEGER_VALUE_ATTRIBUTE: {
			IntegerValueAttribute integerValueAttribute = (IntegerValueAttribute) theEObject;
			T result = caseIntegerValueAttribute(integerValueAttribute);
			if (result == null)
				result = caseAttribute(integerValueAttribute);
			if (result == null)
				result = caseIdentifiableElement(integerValueAttribute);
			if (result == null)
				result = caseExtensibleElement(integerValueAttribute);
			if (result == null)
				result = caseElement(integerValueAttribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.BOOLEAN_VALUE_ATTRIBUTE: {
			BooleanValueAttribute booleanValueAttribute = (BooleanValueAttribute) theEObject;
			T result = caseBooleanValueAttribute(booleanValueAttribute);
			if (result == null)
				result = caseAttribute(booleanValueAttribute);
			if (result == null)
				result = caseIdentifiableElement(booleanValueAttribute);
			if (result == null)
				result = caseExtensibleElement(booleanValueAttribute);
			if (result == null)
				result = caseElement(booleanValueAttribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.REAL_VALUE_ATTRIBUTE: {
			RealValueAttribute realValueAttribute = (RealValueAttribute) theEObject;
			T result = caseRealValueAttribute(realValueAttribute);
			if (result == null)
				result = caseAttribute(realValueAttribute);
			if (result == null)
				result = caseIdentifiableElement(realValueAttribute);
			if (result == null)
				result = caseExtensibleElement(realValueAttribute);
			if (result == null)
				result = caseElement(realValueAttribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.DATE_VALUE_ATTRIBUTE: {
			DateValueAttribute dateValueAttribute = (DateValueAttribute) theEObject;
			T result = caseDateValueAttribute(dateValueAttribute);
			if (result == null)
				result = caseAttribute(dateValueAttribute);
			if (result == null)
				result = caseIdentifiableElement(dateValueAttribute);
			if (result == null)
				result = caseExtensibleElement(dateValueAttribute);
			if (result == null)
				result = caseElement(dateValueAttribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.SHARED_DIRECT_ATTRIBUTES: {
			SharedDirectAttributes sharedDirectAttributes = (SharedDirectAttributes) theEObject;
			T result = caseSharedDirectAttributes(sharedDirectAttributes);
			if (result == null)
				result = caseElement(sharedDirectAttributes);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.ATTRIBUTE_OWNER: {
			AttributeOwner attributeOwner = (AttributeOwner) theEObject;
			T result = caseAttributeOwner(attributeOwner);
			if (result == null)
				result = caseReqIFElement(attributeOwner);
			if (result == null)
				result = caseIdentifiableElement(attributeOwner);
			if (result == null)
				result = caseExtensibleElement(attributeOwner);
			if (result == null)
				result = caseElement(attributeOwner);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.REQUIREMENT: {
			Requirement requirement = (Requirement) theEObject;
			T result = caseRequirement(requirement);
			if (result == null)
				result = caseAttributeOwner(requirement);
			if (result == null)
				result = caseSharedDirectAttributes(requirement);
			if (result == null)
				result = caseReqIFElement(requirement);
			if (result == null)
				result = caseIdentifiableElement(requirement);
			if (result == null)
				result = caseExtensibleElement(requirement);
			if (result == null)
				result = caseElement(requirement);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.FOLDER: {
			Folder folder = (Folder) theEObject;
			T result = caseFolder(folder);
			if (result == null)
				result = caseRequirement(folder);
			if (result == null)
				result = caseAttributeOwner(folder);
			if (result == null)
				result = caseSharedDirectAttributes(folder);
			if (result == null)
				result = caseReqIFElement(folder);
			if (result == null)
				result = caseIdentifiableElement(folder);
			if (result == null)
				result = caseExtensibleElement(folder);
			if (result == null)
				result = caseElement(folder);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.MODULE: {
			org.polarsys.kitalpha.vp.requirements.Requirements.Module module = (org.polarsys.kitalpha.vp.requirements.Requirements.Module) theEObject;
			T result = caseModule(module);
			if (result == null)
				result = caseAttributeOwner(module);
			if (result == null)
				result = caseSharedDirectAttributes(module);
			if (result == null)
				result = caseReqIFElement(module);
			if (result == null)
				result = caseIdentifiableElement(module);
			if (result == null)
				result = caseExtensibleElement(module);
			if (result == null)
				result = caseElement(module);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.TYPES_FOLDER: {
			TypesFolder typesFolder = (TypesFolder) theEObject;
			T result = caseTypesFolder(typesFolder);
			if (result == null)
				result = caseReqIFElement(typesFolder);
			if (result == null)
				result = caseIdentifiableElement(typesFolder);
			if (result == null)
				result = caseExtensibleElement(typesFolder);
			if (result == null)
				result = caseElement(typesFolder);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.ABSTRACT_TYPE: {
			AbstractType abstractType = (AbstractType) theEObject;
			T result = caseAbstractType(abstractType);
			if (result == null)
				result = caseReqIFElement(abstractType);
			if (result == null)
				result = caseIdentifiableElement(abstractType);
			if (result == null)
				result = caseExtensibleElement(abstractType);
			if (result == null)
				result = caseElement(abstractType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.MODULE_TYPE: {
			ModuleType moduleType = (ModuleType) theEObject;
			T result = caseModuleType(moduleType);
			if (result == null)
				result = caseAbstractType(moduleType);
			if (result == null)
				result = caseReqIFElement(moduleType);
			if (result == null)
				result = caseIdentifiableElement(moduleType);
			if (result == null)
				result = caseExtensibleElement(moduleType);
			if (result == null)
				result = caseElement(moduleType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.REQUIREMENT_TYPE: {
			RequirementType requirementType = (RequirementType) theEObject;
			T result = caseRequirementType(requirementType);
			if (result == null)
				result = caseAbstractType(requirementType);
			if (result == null)
				result = caseReqIFElement(requirementType);
			if (result == null)
				result = caseIdentifiableElement(requirementType);
			if (result == null)
				result = caseExtensibleElement(requirementType);
			if (result == null)
				result = caseElement(requirementType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.RELATION_TYPE: {
			RelationType relationType = (RelationType) theEObject;
			T result = caseRelationType(relationType);
			if (result == null)
				result = caseAbstractType(relationType);
			if (result == null)
				result = caseReqIFElement(relationType);
			if (result == null)
				result = caseIdentifiableElement(relationType);
			if (result == null)
				result = caseExtensibleElement(relationType);
			if (result == null)
				result = caseElement(relationType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.DATA_TYPE_DEFINITION: {
			DataTypeDefinition dataTypeDefinition = (DataTypeDefinition) theEObject;
			T result = caseDataTypeDefinition(dataTypeDefinition);
			if (result == null)
				result = caseReqIFElement(dataTypeDefinition);
			if (result == null)
				result = caseIdentifiableElement(dataTypeDefinition);
			if (result == null)
				result = caseExtensibleElement(dataTypeDefinition);
			if (result == null)
				result = caseElement(dataTypeDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.ATTRIBUTE_DEFINITION: {
			AttributeDefinition attributeDefinition = (AttributeDefinition) theEObject;
			T result = caseAttributeDefinition(attributeDefinition);
			if (result == null)
				result = caseReqIFElement(attributeDefinition);
			if (result == null)
				result = caseIdentifiableElement(attributeDefinition);
			if (result == null)
				result = caseExtensibleElement(attributeDefinition);
			if (result == null)
				result = caseElement(attributeDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.ATTRIBUTE_DEFINITION_ENUMERATION: {
			AttributeDefinitionEnumeration attributeDefinitionEnumeration = (AttributeDefinitionEnumeration) theEObject;
			T result = caseAttributeDefinitionEnumeration(attributeDefinitionEnumeration);
			if (result == null)
				result = caseAttributeDefinition(attributeDefinitionEnumeration);
			if (result == null)
				result = caseReqIFElement(attributeDefinitionEnumeration);
			if (result == null)
				result = caseIdentifiableElement(attributeDefinitionEnumeration);
			if (result == null)
				result = caseExtensibleElement(attributeDefinitionEnumeration);
			if (result == null)
				result = caseElement(attributeDefinitionEnumeration);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.ENUMERATION_VALUE_ATTRIBUTE: {
			EnumerationValueAttribute enumerationValueAttribute = (EnumerationValueAttribute) theEObject;
			T result = caseEnumerationValueAttribute(enumerationValueAttribute);
			if (result == null)
				result = caseAttribute(enumerationValueAttribute);
			if (result == null)
				result = caseIdentifiableElement(enumerationValueAttribute);
			if (result == null)
				result = caseExtensibleElement(enumerationValueAttribute);
			if (result == null)
				result = caseElement(enumerationValueAttribute);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.ENUMERATION_DATA_TYPE_DEFINITION: {
			EnumerationDataTypeDefinition enumerationDataTypeDefinition = (EnumerationDataTypeDefinition) theEObject;
			T result = caseEnumerationDataTypeDefinition(enumerationDataTypeDefinition);
			if (result == null)
				result = caseDataTypeDefinition(enumerationDataTypeDefinition);
			if (result == null)
				result = caseReqIFElement(enumerationDataTypeDefinition);
			if (result == null)
				result = caseIdentifiableElement(enumerationDataTypeDefinition);
			if (result == null)
				result = caseExtensibleElement(enumerationDataTypeDefinition);
			if (result == null)
				result = caseElement(enumerationDataTypeDefinition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case RequirementsPackage.ENUM_VALUE: {
			EnumValue enumValue = (EnumValue) theEObject;
			T result = caseEnumValue(enumValue);
			if (result == null)
				result = caseReqIFElement(enumValue);
			if (result == null)
				result = caseIdentifiableElement(enumValue);
			if (result == null)
				result = caseExtensibleElement(enumValue);
			if (result == null)
				result = caseElement(enumValue);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiableElement(IdentifiableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Req IF Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Req IF Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReqIFElement(ReqIFElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractRelation(AbstractRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalRelation(InternalRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Value Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Value Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringValueAttribute(StringValueAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Value Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Value Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerValueAttribute(IntegerValueAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Value Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Value Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanValueAttribute(BooleanValueAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Value Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Value Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealValueAttribute(RealValueAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Date Value Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Date Value Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDateValueAttribute(DateValueAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shared Direct Attributes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shared Direct Attributes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSharedDirectAttributes(SharedDirectAttributes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeOwner(AttributeOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirement(Requirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFolder(Folder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModule(org.polarsys.kitalpha.vp.requirements.Requirements.Module object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Types Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Types Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypesFolder(TypesFolder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractType(AbstractType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModuleType(ModuleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirementType(RequirementType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationType(RelationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeDefinition(DataTypeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeDefinition(AttributeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Definition Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Definition Enumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeDefinitionEnumeration(AttributeDefinitionEnumeration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Value Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Value Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationValueAttribute(EnumerationValueAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Data Type Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationDataTypeDefinition(EnumerationDataTypeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumValue(EnumValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extensible Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExtensibleElement(ExtensibleElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //RequirementsSwitch
