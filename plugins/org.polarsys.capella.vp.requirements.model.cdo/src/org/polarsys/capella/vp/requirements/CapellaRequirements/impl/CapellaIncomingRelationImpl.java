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
import org.polarsys.capella.core.data.capellacore.CapellaElement;

import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;

import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Capella Incoming Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaIncomingRelationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaIncomingRelationImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CapellaIncomingRelationImpl extends CapellaRelationImpl implements CapellaIncomingRelation {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CapellaIncomingRelationImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public Requirement getSource() {

		return (Requirement) eDynamicGet(CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE,
				CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public Requirement basicGetSource() {

		return (Requirement) eDynamicGet(CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE,
				CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setSource(Requirement newSource) {

		eDynamicSet(CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE,
				CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE, newSource);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public CapellaElement getTarget() {

		return (CapellaElement) eDynamicGet(CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET,
				CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public CapellaElement basicGetTarget() {

		return (CapellaElement) eDynamicGet(CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET,
				CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setTarget(CapellaElement newTarget) {

		eDynamicSet(CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET,
				CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET, newTarget);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET:
			if (resolve)
				return getTarget();
			return basicGetTarget();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE:
			setSource((Requirement) newValue);
			return;
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET:
			setTarget((CapellaElement) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE:
			setSource((Requirement) null);
			return;
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET:
			setTarget((CapellaElement) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__SOURCE:
			return basicGetSource() != null;
		case CapellaRequirementsPackage.CAPELLA_INCOMING_RELATION__TARGET:
			return basicGetTarget() != null;
		}
		return super.eIsSet(featureID);
	}

} //CapellaIncomingRelationImpl