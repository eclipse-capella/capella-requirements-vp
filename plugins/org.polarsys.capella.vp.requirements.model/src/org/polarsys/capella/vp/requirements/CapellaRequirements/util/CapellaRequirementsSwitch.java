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

package org.polarsys.capella.vp.requirements.CapellaRequirements.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.polarsys.capella.vp.requirements.CapellaRequirements.*;

import org.polarsys.kitalpha.emde.model.Element;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.emde.model.ExtensibleElement;

import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner;
import org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes;
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
 * @see org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage
 * @generated
 */
public class CapellaRequirementsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CapellaRequirementsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapellaRequirementsSwitch() {
		if (modelPackage == null) {
			modelPackage = CapellaRequirementsPackage.eINSTANCE;
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
		case CapellaRequirementsPackage.CAPELLA_TYPES_FOLDER: {
			CapellaTypesFolder capellaTypesFolder = (CapellaTypesFolder) theEObject;
			T result = caseCapellaTypesFolder(capellaTypesFolder);
			if (result == null)
				result = caseTypesFolder(capellaTypesFolder);
			if (result == null)
				result = caseElementExtension(capellaTypesFolder);
			if (result == null)
				result = caseReqIFElement(capellaTypesFolder);
			if (result == null)
				result = caseExtensibleElement(capellaTypesFolder);
			if (result == null)
				result = caseIdentifiableElement(capellaTypesFolder);
			if (result == null)
				result = caseElement(capellaTypesFolder);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CapellaRequirementsPackage.CAPELLA_MODULE: {
			CapellaModule capellaModule = (CapellaModule) theEObject;
			T result = caseCapellaModule(capellaModule);
			if (result == null)
				result = caseModule(capellaModule);
			if (result == null)
				result = caseElementExtension(capellaModule);
			if (result == null)
				result = caseAttributeOwner(capellaModule);
			if (result == null)
				result = caseSharedDirectAttributes(capellaModule);
			if (result == null)
				result = caseExtensibleElement(capellaModule);
			if (result == null)
				result = caseReqIFElement(capellaModule);
			if (result == null)
				result = caseIdentifiableElement(capellaModule);
			if (result == null)
				result = caseElement(capellaModule);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CapellaRequirementsPackage.CAPELLA_RELATION: {
			CapellaRelation capellaRelation = (CapellaRelation) theEObject;
			T result = caseCapellaRelation(capellaRelation);
			if (result == null)
				result = caseAbstractRelation(capellaRelation);
			if (result == null)
				result = caseReqIFElement(capellaRelation);
			if (result == null)
				result = caseIdentifiableElement(capellaRelation);
			if (result == null)
				result = caseElement(capellaRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION: {
			CapellaIncomingRelation capellaIncomingRelation = (CapellaIncomingRelation) theEObject;
			T result = caseCapellaIncomingRelation(capellaIncomingRelation);
			if (result == null)
				result = caseCapellaRelation(capellaIncomingRelation);
			if (result == null)
				result = caseAbstractRelation(capellaIncomingRelation);
			if (result == null)
				result = caseReqIFElement(capellaIncomingRelation);
			if (result == null)
				result = caseIdentifiableElement(capellaIncomingRelation);
			if (result == null)
				result = caseElement(capellaIncomingRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case CapellaRequirementsPackage.CAPELLA_OUTGOING_RELATION: {
			CapellaOutgoingRelation capellaOutgoingRelation = (CapellaOutgoingRelation) theEObject;
			T result = caseCapellaOutgoingRelation(capellaOutgoingRelation);
			if (result == null)
				result = caseCapellaRelation(capellaOutgoingRelation);
			if (result == null)
				result = caseElementExtension(capellaOutgoingRelation);
			if (result == null)
				result = caseAbstractRelation(capellaOutgoingRelation);
			if (result == null)
				result = caseExtensibleElement(capellaOutgoingRelation);
			if (result == null)
				result = caseReqIFElement(capellaOutgoingRelation);
			if (result == null)
				result = caseIdentifiableElement(capellaOutgoingRelation);
			if (result == null)
				result = caseElement(capellaOutgoingRelation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capella Types Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capella Types Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapellaTypesFolder(CapellaTypesFolder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capella Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capella Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapellaModule(CapellaModule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capella Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capella Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapellaRelation(CapellaRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capella Incoming Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capella Incoming Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapellaIncomingRelation(CapellaIncomingRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capella Outgoing Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capella Outgoing Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapellaOutgoingRelation(CapellaOutgoingRelation object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Element Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementExtension(ElementExtension object) {
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

} //CapellaRequirementsSwitch
