/**
 *
 *  Copyright (c) 2016, 2019 THALES GLOBAL SERVICES.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */

package org.polarsys.kitalpha.vp.requirements.Requirements.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.polarsys.kitalpha.emde.model.EmdePackage;

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
import org.polarsys.kitalpha.vp.requirements.Requirements.ModuleType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes;
import org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementsPackageImpl extends EPackageImpl implements RequirementsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reqIFElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringValueAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerValueAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanValueAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realValueAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dateValueAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sharedDirectAttributesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeOwnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typesFolderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeDefinitionEnumerationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationValueAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationDataTypeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumValueEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RequirementsPackageImpl() {
		super(eNS_URI, RequirementsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link RequirementsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RequirementsPackage init() {
		if (isInited)
			return (RequirementsPackage) EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredRequirementsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		RequirementsPackageImpl theRequirementsPackage = registeredRequirementsPackage instanceof RequirementsPackageImpl
				? (RequirementsPackageImpl) registeredRequirementsPackage
				: new RequirementsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		EmdePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRequirementsPackage.createPackageContents();

		// Initialize created meta-data
		theRequirementsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRequirementsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RequirementsPackage.eNS_URI, theRequirementsPackage);
		return theRequirementsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIdentifiableElement() {
		return identifiableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIdentifiableElement_Id() {
		return (EAttribute) identifiableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReqIFElement() {
		return reqIFElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReqIFElement_ReqIFIdentifier() {
		return (EAttribute) reqIFElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReqIFElement_ReqIFDescription() {
		return (EAttribute) reqIFElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getReqIFElement_ReqIFLongName() {
		return (EAttribute) reqIFElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractRelation() {
		return abstractRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractRelation_RelationType() {
		return (EReference) abstractRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractRelation_RelationTypeProxy() {
		return (EAttribute) abstractRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInternalRelation() {
		return internalRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInternalRelation_Source() {
		return (EReference) internalRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInternalRelation_Target() {
		return (EReference) internalRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttribute_Definition() {
		return (EReference) attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttribute_DefinitionProxy() {
		return (EAttribute) attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringValueAttribute() {
		return stringValueAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringValueAttribute_Value() {
		return (EAttribute) stringValueAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntegerValueAttribute() {
		return integerValueAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerValueAttribute_Value() {
		return (EAttribute) integerValueAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBooleanValueAttribute() {
		return booleanValueAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBooleanValueAttribute_Value() {
		return (EAttribute) booleanValueAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRealValueAttribute() {
		return realValueAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRealValueAttribute_Value() {
		return (EAttribute) realValueAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDateValueAttribute() {
		return dateValueAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDateValueAttribute_Value() {
		return (EAttribute) dateValueAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSharedDirectAttributes() {
		return sharedDirectAttributesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSharedDirectAttributes_ReqIFName() {
		return (EAttribute) sharedDirectAttributesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSharedDirectAttributes_ReqIFPrefix() {
		return (EAttribute) sharedDirectAttributesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeOwner() {
		return attributeOwnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeOwner_OwnedAttributes() {
		return (EReference) attributeOwnerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRequirement() {
		return requirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRequirement_RequirementType() {
		return (EReference) requirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRequirement_OwnedRelations() {
		return (EReference) requirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRequirement_ReqIFChapterName() {
		return (EAttribute) requirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRequirement_ReqIFForeignID() {
		return (EAttribute) requirementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRequirement_ReqIFText() {
		return (EAttribute) requirementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRequirement_RequirementTypeProxy() {
		return (EAttribute) requirementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFolder() {
		return folderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFolder_OwnedRequirements() {
		return (EReference) folderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModule() {
		return moduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModule_ModuleType() {
		return (EReference) moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModule_OwnedRequirements() {
		return (EReference) moduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypesFolder() {
		return typesFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypesFolder_OwnedDefinitionTypes() {
		return (EReference) typesFolderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypesFolder_OwnedTypes() {
		return (EReference) typesFolderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractType() {
		return abstractTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractType_OwnedAttributes() {
		return (EReference) abstractTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModuleType() {
		return moduleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRequirementType() {
		return requirementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationType() {
		return relationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataTypeDefinition() {
		return dataTypeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeDefinition() {
		return attributeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeDefinition_DefinitionType() {
		return (EReference) attributeDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeDefinition_DefaultValue() {
		return (EReference) attributeDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeDefinitionEnumeration() {
		return attributeDefinitionEnumerationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeDefinitionEnumeration_MultiValued() {
		return (EAttribute) attributeDefinitionEnumerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumerationValueAttribute() {
		return enumerationValueAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnumerationValueAttribute_Values() {
		return (EReference) enumerationValueAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumerationDataTypeDefinition() {
		return enumerationDataTypeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnumerationDataTypeDefinition_SpecifiedValues() {
		return (EReference) enumerationDataTypeDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumValue() {
		return enumValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RequirementsFactory getRequirementsFactory() {
		return (RequirementsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		identifiableElementEClass = createEClass(IDENTIFIABLE_ELEMENT);
		createEAttribute(identifiableElementEClass, IDENTIFIABLE_ELEMENT__ID);

		reqIFElementEClass = createEClass(REQ_IF_ELEMENT);
		createEAttribute(reqIFElementEClass, REQ_IF_ELEMENT__REQ_IF_IDENTIFIER);
		createEAttribute(reqIFElementEClass, REQ_IF_ELEMENT__REQ_IF_DESCRIPTION);
		createEAttribute(reqIFElementEClass, REQ_IF_ELEMENT__REQ_IF_LONG_NAME);

		abstractRelationEClass = createEClass(ABSTRACT_RELATION);
		createEReference(abstractRelationEClass, ABSTRACT_RELATION__RELATION_TYPE);
		createEAttribute(abstractRelationEClass, ABSTRACT_RELATION__RELATION_TYPE_PROXY);

		internalRelationEClass = createEClass(INTERNAL_RELATION);
		createEReference(internalRelationEClass, INTERNAL_RELATION__SOURCE);
		createEReference(internalRelationEClass, INTERNAL_RELATION__TARGET);

		attributeEClass = createEClass(ATTRIBUTE);
		createEReference(attributeEClass, ATTRIBUTE__DEFINITION);
		createEAttribute(attributeEClass, ATTRIBUTE__DEFINITION_PROXY);

		stringValueAttributeEClass = createEClass(STRING_VALUE_ATTRIBUTE);
		createEAttribute(stringValueAttributeEClass, STRING_VALUE_ATTRIBUTE__VALUE);

		integerValueAttributeEClass = createEClass(INTEGER_VALUE_ATTRIBUTE);
		createEAttribute(integerValueAttributeEClass, INTEGER_VALUE_ATTRIBUTE__VALUE);

		booleanValueAttributeEClass = createEClass(BOOLEAN_VALUE_ATTRIBUTE);
		createEAttribute(booleanValueAttributeEClass, BOOLEAN_VALUE_ATTRIBUTE__VALUE);

		realValueAttributeEClass = createEClass(REAL_VALUE_ATTRIBUTE);
		createEAttribute(realValueAttributeEClass, REAL_VALUE_ATTRIBUTE__VALUE);

		dateValueAttributeEClass = createEClass(DATE_VALUE_ATTRIBUTE);
		createEAttribute(dateValueAttributeEClass, DATE_VALUE_ATTRIBUTE__VALUE);

		sharedDirectAttributesEClass = createEClass(SHARED_DIRECT_ATTRIBUTES);
		createEAttribute(sharedDirectAttributesEClass, SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME);
		createEAttribute(sharedDirectAttributesEClass, SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX);

		attributeOwnerEClass = createEClass(ATTRIBUTE_OWNER);
		createEReference(attributeOwnerEClass, ATTRIBUTE_OWNER__OWNED_ATTRIBUTES);

		requirementEClass = createEClass(REQUIREMENT);
		createEReference(requirementEClass, REQUIREMENT__REQUIREMENT_TYPE);
		createEReference(requirementEClass, REQUIREMENT__OWNED_RELATIONS);
		createEAttribute(requirementEClass, REQUIREMENT__REQ_IF_CHAPTER_NAME);
		createEAttribute(requirementEClass, REQUIREMENT__REQ_IF_FOREIGN_ID);
		createEAttribute(requirementEClass, REQUIREMENT__REQ_IF_TEXT);
		createEAttribute(requirementEClass, REQUIREMENT__REQUIREMENT_TYPE_PROXY);

		folderEClass = createEClass(FOLDER);
		createEReference(folderEClass, FOLDER__OWNED_REQUIREMENTS);

		moduleEClass = createEClass(MODULE);
		createEReference(moduleEClass, MODULE__MODULE_TYPE);
		createEReference(moduleEClass, MODULE__OWNED_REQUIREMENTS);

		typesFolderEClass = createEClass(TYPES_FOLDER);
		createEReference(typesFolderEClass, TYPES_FOLDER__OWNED_DEFINITION_TYPES);
		createEReference(typesFolderEClass, TYPES_FOLDER__OWNED_TYPES);

		abstractTypeEClass = createEClass(ABSTRACT_TYPE);
		createEReference(abstractTypeEClass, ABSTRACT_TYPE__OWNED_ATTRIBUTES);

		moduleTypeEClass = createEClass(MODULE_TYPE);

		requirementTypeEClass = createEClass(REQUIREMENT_TYPE);

		relationTypeEClass = createEClass(RELATION_TYPE);

		dataTypeDefinitionEClass = createEClass(DATA_TYPE_DEFINITION);

		attributeDefinitionEClass = createEClass(ATTRIBUTE_DEFINITION);
		createEReference(attributeDefinitionEClass, ATTRIBUTE_DEFINITION__DEFINITION_TYPE);
		createEReference(attributeDefinitionEClass, ATTRIBUTE_DEFINITION__DEFAULT_VALUE);

		attributeDefinitionEnumerationEClass = createEClass(ATTRIBUTE_DEFINITION_ENUMERATION);
		createEAttribute(attributeDefinitionEnumerationEClass, ATTRIBUTE_DEFINITION_ENUMERATION__MULTI_VALUED);

		enumerationValueAttributeEClass = createEClass(ENUMERATION_VALUE_ATTRIBUTE);
		createEReference(enumerationValueAttributeEClass, ENUMERATION_VALUE_ATTRIBUTE__VALUES);

		enumerationDataTypeDefinitionEClass = createEClass(ENUMERATION_DATA_TYPE_DEFINITION);
		createEReference(enumerationDataTypeDefinitionEClass, ENUMERATION_DATA_TYPE_DEFINITION__SPECIFIED_VALUES);

		enumValueEClass = createEClass(ENUM_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EmdePackage theEmdePackage = (EmdePackage) EPackage.Registry.INSTANCE.getEPackage(EmdePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		identifiableElementEClass.getESuperTypes().add(theEmdePackage.getElement());
		reqIFElementEClass.getESuperTypes().add(this.getIdentifiableElement());
		abstractRelationEClass.getESuperTypes().add(this.getReqIFElement());
		internalRelationEClass.getESuperTypes().add(this.getAbstractRelation());
		attributeEClass.getESuperTypes().add(this.getIdentifiableElement());
		stringValueAttributeEClass.getESuperTypes().add(this.getAttribute());
		integerValueAttributeEClass.getESuperTypes().add(this.getAttribute());
		booleanValueAttributeEClass.getESuperTypes().add(this.getAttribute());
		realValueAttributeEClass.getESuperTypes().add(this.getAttribute());
		dateValueAttributeEClass.getESuperTypes().add(this.getAttribute());
		sharedDirectAttributesEClass.getESuperTypes().add(theEmdePackage.getElement());
		attributeOwnerEClass.getESuperTypes().add(this.getReqIFElement());
		requirementEClass.getESuperTypes().add(this.getAttributeOwner());
		requirementEClass.getESuperTypes().add(this.getSharedDirectAttributes());
		folderEClass.getESuperTypes().add(this.getRequirement());
		moduleEClass.getESuperTypes().add(this.getAttributeOwner());
		moduleEClass.getESuperTypes().add(this.getSharedDirectAttributes());
		typesFolderEClass.getESuperTypes().add(this.getReqIFElement());
		abstractTypeEClass.getESuperTypes().add(this.getReqIFElement());
		moduleTypeEClass.getESuperTypes().add(this.getAbstractType());
		requirementTypeEClass.getESuperTypes().add(this.getAbstractType());
		relationTypeEClass.getESuperTypes().add(this.getAbstractType());
		dataTypeDefinitionEClass.getESuperTypes().add(this.getReqIFElement());
		attributeDefinitionEClass.getESuperTypes().add(this.getReqIFElement());
		attributeDefinitionEnumerationEClass.getESuperTypes().add(this.getAttributeDefinition());
		enumerationValueAttributeEClass.getESuperTypes().add(this.getAttribute());
		enumerationDataTypeDefinitionEClass.getESuperTypes().add(this.getDataTypeDefinition());
		enumValueEClass.getESuperTypes().add(this.getReqIFElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(identifiableElementEClass, IdentifiableElement.class, "IdentifiableElement", IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiableElement_Id(), ecorePackage.getEString(), "id", null, 0, 1, //$NON-NLS-1$
				IdentifiableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(reqIFElementEClass, ReqIFElement.class, "ReqIFElement", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReqIFElement_ReqIFIdentifier(), ecorePackage.getEString(), "ReqIFIdentifier", null, 0, 1, //$NON-NLS-1$
				ReqIFElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getReqIFElement_ReqIFDescription(), ecorePackage.getEString(), "ReqIFDescription", null, 0, 1, //$NON-NLS-1$
				ReqIFElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getReqIFElement_ReqIFLongName(), ecorePackage.getEString(), "ReqIFLongName", null, 0, 1, //$NON-NLS-1$
				ReqIFElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(abstractRelationEClass, AbstractRelation.class, "AbstractRelation", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractRelation_RelationType(), this.getRelationType(), null, "relationType", null, 0, 1, //$NON-NLS-1$
				AbstractRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractRelation_RelationTypeProxy(), ecorePackage.getEString(), "relationTypeProxy", null, 0, //$NON-NLS-1$
				1, AbstractRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(internalRelationEClass, InternalRelation.class, "InternalRelation", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInternalRelation_Source(), this.getRequirement(), null, "source", null, 0, 1, //$NON-NLS-1$
				InternalRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInternalRelation_Target(), this.getRequirement(), null, "target", null, 0, 1, //$NON-NLS-1$
				InternalRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttribute_Definition(), this.getAttributeDefinition(), null, "definition", null, 0, 1, //$NON-NLS-1$
				Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_DefinitionProxy(), ecorePackage.getEString(), "definitionProxy", null, 0, 1, //$NON-NLS-1$
				Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(stringValueAttributeEClass, StringValueAttribute.class, "StringValueAttribute", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringValueAttribute_Value(), ecorePackage.getEString(), "value", null, 0, 1, //$NON-NLS-1$
				StringValueAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerValueAttributeEClass, IntegerValueAttribute.class, "IntegerValueAttribute", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerValueAttribute_Value(), ecorePackage.getEInt(), "value", null, 0, 1, //$NON-NLS-1$
				IntegerValueAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanValueAttributeEClass, BooleanValueAttribute.class, "BooleanValueAttribute", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanValueAttribute_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1, //$NON-NLS-1$
				BooleanValueAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(realValueAttributeEClass, RealValueAttribute.class, "RealValueAttribute", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealValueAttribute_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, //$NON-NLS-1$
				RealValueAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(dateValueAttributeEClass, DateValueAttribute.class, "DateValueAttribute", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDateValueAttribute_Value(), ecorePackage.getEDate(), "value", null, 0, 1, //$NON-NLS-1$
				DateValueAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(sharedDirectAttributesEClass, SharedDirectAttributes.class, "SharedDirectAttributes", IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSharedDirectAttributes_ReqIFName(), ecorePackage.getEString(), "ReqIFName", null, 0, 1, //$NON-NLS-1$
				SharedDirectAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSharedDirectAttributes_ReqIFPrefix(), ecorePackage.getEString(), "ReqIFPrefix", null, 0, 1, //$NON-NLS-1$
				SharedDirectAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeOwnerEClass, AttributeOwner.class, "AttributeOwner", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeOwner_OwnedAttributes(), this.getAttribute(), null, "ownedAttributes", null, 0, -1, //$NON-NLS-1$
				AttributeOwner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementEClass, Requirement.class, "Requirement", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequirement_RequirementType(), this.getRequirementType(), null, "requirementType", null, 0, 1, //$NON-NLS-1$
				Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRequirement_OwnedRelations(), this.getAbstractRelation(), null, "ownedRelations", null, 0, -1, //$NON-NLS-1$
				Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_ReqIFChapterName(), ecorePackage.getEString(), "ReqIFChapterName", null, 0, 1, //$NON-NLS-1$
				Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_ReqIFForeignID(), ecorePackage.getEBigInteger(), "ReqIFForeignID", null, 0, 1, //$NON-NLS-1$
				Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_ReqIFText(), ecorePackage.getEString(), "ReqIFText", null, 0, 1, //$NON-NLS-1$
				Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequirement_RequirementTypeProxy(), ecorePackage.getEString(), "requirementTypeProxy", null, //$NON-NLS-1$
				0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(folderEClass, Folder.class, "Folder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getFolder_OwnedRequirements(), this.getRequirement(), null, "ownedRequirements", null, 0, -1, //$NON-NLS-1$
				Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleEClass, org.polarsys.kitalpha.vp.requirements.Requirements.Module.class, "Module", //$NON-NLS-1$
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModule_ModuleType(), this.getModuleType(), null, "moduleType", null, 0, 1, //$NON-NLS-1$
				org.polarsys.kitalpha.vp.requirements.Requirements.Module.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_OwnedRequirements(), this.getRequirement(), null, "ownedRequirements", null, 0, -1, //$NON-NLS-1$
				org.polarsys.kitalpha.vp.requirements.Requirements.Module.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typesFolderEClass, TypesFolder.class, "TypesFolder", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypesFolder_OwnedDefinitionTypes(), this.getDataTypeDefinition(), null,
				"ownedDefinitionTypes", null, 0, -1, TypesFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, //$NON-NLS-1$
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypesFolder_OwnedTypes(), this.getAbstractType(), null, "ownedTypes", null, 0, -1, //$NON-NLS-1$
				TypesFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractTypeEClass, AbstractType.class, "AbstractType", IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractType_OwnedAttributes(), this.getAttributeDefinition(), null, "ownedAttributes", null, //$NON-NLS-1$
				0, -1, AbstractType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleTypeEClass, ModuleType.class, "ModuleType", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(requirementTypeEClass, RequirementType.class, "RequirementType", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationTypeEClass, RelationType.class, "RelationType", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataTypeDefinitionEClass, DataTypeDefinition.class, "DataTypeDefinition", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeDefinitionEClass, AttributeDefinition.class, "AttributeDefinition", !IS_ABSTRACT, //$NON-NLS-1$
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeDefinition_DefinitionType(), this.getDataTypeDefinition(), null, "definitionType", //$NON-NLS-1$
				null, 0, 1, AttributeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeDefinition_DefaultValue(), this.getAttribute(), null, "defaultValue", null, 0, 1, //$NON-NLS-1$
				AttributeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeDefinitionEnumerationEClass, AttributeDefinitionEnumeration.class,
				"AttributeDefinitionEnumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAttributeDefinitionEnumeration_MultiValued(), ecorePackage.getEBoolean(), "multiValued", null, //$NON-NLS-1$
				0, 1, AttributeDefinitionEnumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationValueAttributeEClass, EnumerationValueAttribute.class, "EnumerationValueAttribute", //$NON-NLS-1$
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerationValueAttribute_Values(), this.getEnumValue(), null, "values", null, 0, -1, //$NON-NLS-1$
				EnumerationValueAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationDataTypeDefinitionEClass, EnumerationDataTypeDefinition.class,
				"EnumerationDataTypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEnumerationDataTypeDefinition_SpecifiedValues(), this.getEnumValue(), null, "specifiedValues", //$NON-NLS-1$
				null, 0, -1, EnumerationDataTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumValueEClass, EnumValue.class, "EnumValue", !IS_ABSTRACT, !IS_INTERFACE, //$NON-NLS-1$
				IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //RequirementsPackageImpl
