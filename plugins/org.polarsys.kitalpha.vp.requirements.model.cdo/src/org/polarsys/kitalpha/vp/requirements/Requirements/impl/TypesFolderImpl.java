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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType;
import org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Types Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.TypesFolderImpl#getOwnedDefinitionTypes <em>Owned Definition Types</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.impl.TypesFolderImpl#getOwnedTypes <em>Owned Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypesFolderImpl extends ReqIFElementImpl implements TypesFolder {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.\r\n All rights reserved. This program and the accompanying materials\r\n are made available under the terms of the Eclipse Public License v1.0\r\n which accompanies this distribution, and is available at\r\n http://www.eclipse.org/legal/epl-v10.html\r\n\r\n Contributors:\r\n    Thales - initial API and implementation"; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypesFolderImpl() {

		super();

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementsPackage.Literals.TYPES_FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@SuppressWarnings("unchecked")
	public EList<DataTypeDefinition> getOwnedDefinitionTypes() {

		return (EList<DataTypeDefinition>) eDynamicGet(RequirementsPackage.TYPES_FOLDER__OWNED_DEFINITION_TYPES,
				RequirementsPackage.Literals.TYPES_FOLDER__OWNED_DEFINITION_TYPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@SuppressWarnings("unchecked")
	public EList<AbstractType> getOwnedTypes() {

		return (EList<AbstractType>) eDynamicGet(RequirementsPackage.TYPES_FOLDER__OWNED_TYPES,
				RequirementsPackage.Literals.TYPES_FOLDER__OWNED_TYPES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementsPackage.TYPES_FOLDER__OWNED_DEFINITION_TYPES:
			return ((InternalEList<?>) getOwnedDefinitionTypes()).basicRemove(otherEnd, msgs);
		case RequirementsPackage.TYPES_FOLDER__OWNED_TYPES:
			return ((InternalEList<?>) getOwnedTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RequirementsPackage.TYPES_FOLDER__OWNED_DEFINITION_TYPES:
			return getOwnedDefinitionTypes();
		case RequirementsPackage.TYPES_FOLDER__OWNED_TYPES:
			return getOwnedTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case RequirementsPackage.TYPES_FOLDER__OWNED_DEFINITION_TYPES:
			getOwnedDefinitionTypes().clear();
			getOwnedDefinitionTypes().addAll((Collection<? extends DataTypeDefinition>) newValue);
			return;
		case RequirementsPackage.TYPES_FOLDER__OWNED_TYPES:
			getOwnedTypes().clear();
			getOwnedTypes().addAll((Collection<? extends AbstractType>) newValue);
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
		case RequirementsPackage.TYPES_FOLDER__OWNED_DEFINITION_TYPES:
			getOwnedDefinitionTypes().clear();
			return;
		case RequirementsPackage.TYPES_FOLDER__OWNED_TYPES:
			getOwnedTypes().clear();
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
		case RequirementsPackage.TYPES_FOLDER__OWNED_DEFINITION_TYPES:
			return !getOwnedDefinitionTypes().isEmpty();
		case RequirementsPackage.TYPES_FOLDER__OWNED_TYPES:
			return !getOwnedTypes().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TypesFolderImpl