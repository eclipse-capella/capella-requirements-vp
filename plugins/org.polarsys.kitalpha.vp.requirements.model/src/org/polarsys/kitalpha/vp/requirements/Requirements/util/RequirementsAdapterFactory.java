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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage
 * @generated
 */
public class RequirementsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RequirementsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RequirementsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementsSwitch<Adapter> modelSwitch = new RequirementsSwitch<Adapter>() {
		@Override
		public Adapter caseIdentifiableElement(IdentifiableElement object) {
			return createIdentifiableElementAdapter();
		}

		@Override
		public Adapter caseReqIFElement(ReqIFElement object) {
			return createReqIFElementAdapter();
		}

		@Override
		public Adapter caseAbstractRelation(AbstractRelation object) {
			return createAbstractRelationAdapter();
		}

		@Override
		public Adapter caseInternalRelation(InternalRelation object) {
			return createInternalRelationAdapter();
		}

		@Override
		public Adapter caseAttribute(Attribute object) {
			return createAttributeAdapter();
		}

		@Override
		public Adapter caseStringValueAttribute(StringValueAttribute object) {
			return createStringValueAttributeAdapter();
		}

		@Override
		public Adapter caseIntegerValueAttribute(IntegerValueAttribute object) {
			return createIntegerValueAttributeAdapter();
		}

		@Override
		public Adapter caseBooleanValueAttribute(BooleanValueAttribute object) {
			return createBooleanValueAttributeAdapter();
		}

		@Override
		public Adapter caseRealValueAttribute(RealValueAttribute object) {
			return createRealValueAttributeAdapter();
		}

		@Override
		public Adapter caseDateValueAttribute(DateValueAttribute object) {
			return createDateValueAttributeAdapter();
		}

		@Override
		public Adapter caseSharedDirectAttributes(SharedDirectAttributes object) {
			return createSharedDirectAttributesAdapter();
		}

		@Override
		public Adapter caseAttributeOwner(AttributeOwner object) {
			return createAttributeOwnerAdapter();
		}

		@Override
		public Adapter caseRequirement(Requirement object) {
			return createRequirementAdapter();
		}

		@Override
		public Adapter caseFolder(Folder object) {
			return createFolderAdapter();
		}

		@Override
		public Adapter caseModule(org.polarsys.kitalpha.vp.requirements.Requirements.Module object) {
			return createModuleAdapter();
		}

		@Override
		public Adapter caseTypesFolder(TypesFolder object) {
			return createTypesFolderAdapter();
		}

		@Override
		public Adapter caseAbstractType(AbstractType object) {
			return createAbstractTypeAdapter();
		}

		@Override
		public Adapter caseModuleType(ModuleType object) {
			return createModuleTypeAdapter();
		}

		@Override
		public Adapter caseRequirementType(RequirementType object) {
			return createRequirementTypeAdapter();
		}

		@Override
		public Adapter caseRelationType(RelationType object) {
			return createRelationTypeAdapter();
		}

		@Override
		public Adapter caseDataTypeDefinition(DataTypeDefinition object) {
			return createDataTypeDefinitionAdapter();
		}

		@Override
		public Adapter caseAttributeDefinition(AttributeDefinition object) {
			return createAttributeDefinitionAdapter();
		}

		@Override
		public Adapter caseAttributeDefinitionEnumeration(AttributeDefinitionEnumeration object) {
			return createAttributeDefinitionEnumerationAdapter();
		}

		@Override
		public Adapter caseEnumerationValueAttribute(EnumerationValueAttribute object) {
			return createEnumerationValueAttributeAdapter();
		}

		@Override
		public Adapter caseEnumerationDataTypeDefinition(EnumerationDataTypeDefinition object) {
			return createEnumerationDataTypeDefinitionAdapter();
		}

		@Override
		public Adapter caseEnumValue(EnumValue object) {
			return createEnumValueAdapter();
		}

		@Override
		public Adapter caseElement(Element object) {
			return createElementAdapter();
		}

		@Override
		public Adapter caseExtensibleElement(ExtensibleElement object) {
			return createExtensibleElementAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement <em>Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement
	 * @generated
	 */
	public Adapter createIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement <em>Req IF Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement
	 * @generated
	 */
	public Adapter createReqIFElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation <em>Abstract Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation
	 * @generated
	 */
	public Adapter createAbstractRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation <em>Internal Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation
	 * @generated
	 */
	public Adapter createInternalRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute <em>String Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute
	 * @generated
	 */
	public Adapter createStringValueAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute <em>Integer Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute
	 * @generated
	 */
	public Adapter createIntegerValueAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute <em>Boolean Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute
	 * @generated
	 */
	public Adapter createBooleanValueAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute <em>Real Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute
	 * @generated
	 */
	public Adapter createRealValueAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute <em>Date Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute
	 * @generated
	 */
	public Adapter createDateValueAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes <em>Shared Direct Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes
	 * @generated
	 */
	public Adapter createSharedDirectAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner <em>Attribute Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner
	 * @generated
	 */
	public Adapter createAttributeOwnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Requirement
	 * @generated
	 */
	public Adapter createRequirementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Folder <em>Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Folder
	 * @generated
	 */
	public Adapter createFolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.Module
	 * @generated
	 */
	public Adapter createModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder <em>Types Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder
	 * @generated
	 */
	public Adapter createTypesFolderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType <em>Abstract Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType
	 * @generated
	 */
	public Adapter createAbstractTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.ModuleType <em>Module Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.ModuleType
	 * @generated
	 */
	public Adapter createModuleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType <em>Requirement Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType
	 * @generated
	 */
	public Adapter createRequirementTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.RelationType <em>Relation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RelationType
	 * @generated
	 */
	public Adapter createRelationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition <em>Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition
	 * @generated
	 */
	public Adapter createDataTypeDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition <em>Attribute Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition
	 * @generated
	 */
	public Adapter createAttributeDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration <em>Attribute Definition Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration
	 * @generated
	 */
	public Adapter createAttributeDefinitionEnumerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute <em>Enumeration Value Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute
	 * @generated
	 */
	public Adapter createEnumerationValueAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition <em>Enumeration Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition
	 * @generated
	 */
	public Adapter createEnumerationDataTypeDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.vp.requirements.Requirements.EnumValue <em>Enum Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.EnumValue
	 * @generated
	 */
	public Adapter createEnumValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.emde.model.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.emde.model.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.polarsys.kitalpha.emde.model.ExtensibleElement <em>Extensible Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.polarsys.kitalpha.emde.model.ExtensibleElement
	 * @generated
	 */
	public Adapter createExtensibleElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //RequirementsAdapterFactory
