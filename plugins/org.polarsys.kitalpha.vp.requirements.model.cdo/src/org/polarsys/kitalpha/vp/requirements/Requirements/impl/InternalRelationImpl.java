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

package org.polarsys.kitalpha.vp.requirements.Requirements.impl;

import org.eclipse.emf.ecore.EClass;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.InternalRelationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.InternalRelationImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InternalRelationImpl extends AbstractRelationImpl implements InternalRelation {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalRelationImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.INTERNAL_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public Requirement getSource() {

		return (Requirement) eDynamicGet(RequirementsPackage.INTERNAL_RELATION__SOURCE,
				RequirementsPackage.Literals.INTERNAL_RELATION__SOURCE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public Requirement basicGetSource() {

		return (Requirement) eDynamicGet(RequirementsPackage.INTERNAL_RELATION__SOURCE,
				RequirementsPackage.Literals.INTERNAL_RELATION__SOURCE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setSource(Requirement newSource) {

		eDynamicSet(RequirementsPackage.INTERNAL_RELATION__SOURCE,
				RequirementsPackage.Literals.INTERNAL_RELATION__SOURCE, newSource);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public Requirement getTarget() {

		return (Requirement) eDynamicGet(RequirementsPackage.INTERNAL_RELATION__TARGET,
				RequirementsPackage.Literals.INTERNAL_RELATION__TARGET, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	public Requirement basicGetTarget() {

		return (Requirement) eDynamicGet(RequirementsPackage.INTERNAL_RELATION__TARGET,
				RequirementsPackage.Literals.INTERNAL_RELATION__TARGET, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public void setTarget(Requirement newTarget) {

		eDynamicSet(RequirementsPackage.INTERNAL_RELATION__TARGET,
				RequirementsPackage.Literals.INTERNAL_RELATION__TARGET, newTarget);

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementsPackage.INTERNAL_RELATION__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case RequirementsPackage.INTERNAL_RELATION__TARGET:
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
		case RequirementsPackage.INTERNAL_RELATION__SOURCE:
			setSource((Requirement) newValue);
			return;
		case RequirementsPackage.INTERNAL_RELATION__TARGET:
			setTarget((Requirement) newValue);
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
		case RequirementsPackage.INTERNAL_RELATION__SOURCE:
			setSource((Requirement) null);
			return;
		case RequirementsPackage.INTERNAL_RELATION__TARGET:
			setTarget((Requirement) null);
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
		case RequirementsPackage.INTERNAL_RELATION__SOURCE:
			return basicGetSource() != null;
		case RequirementsPackage.INTERNAL_RELATION__TARGET:
			return basicGetTarget() != null;
		}
		return super.eIsSet(featureID);
	}

} //InternalRelationImpl