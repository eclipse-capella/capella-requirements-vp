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

package org.polarsys.kitalpha.vp.requirements.Requirements.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
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
	 * The cached value of the '{@link #getOwnedDefinitionTypes() <em>Owned Definition Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDefinitionTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataTypeDefinition> ownedDefinitionTypes;

	/**
	 * The cached value of the '{@link #getOwnedTypes() <em>Owned Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractType> ownedTypes;

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

	@Override
	public EList<DataTypeDefinition> getOwnedDefinitionTypes() {

		if (ownedDefinitionTypes == null) {
			ownedDefinitionTypes = new EObjectContainmentEList<DataTypeDefinition>(DataTypeDefinition.class, this,
					RequirementsPackage.TYPES_FOLDER__OWNED_DEFINITION_TYPES);
		}
		return ownedDefinitionTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */

	@Override
	public EList<AbstractType> getOwnedTypes() {

		if (ownedTypes == null) {
			ownedTypes = new EObjectContainmentEList<AbstractType>(AbstractType.class, this,
					RequirementsPackage.TYPES_FOLDER__OWNED_TYPES);
		}
		return ownedTypes;
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
			return ownedDefinitionTypes != null && !ownedDefinitionTypes.isEmpty();
		case RequirementsPackage.TYPES_FOLDER__OWNED_TYPES:
			return ownedTypes != null && !ownedTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TypesFolderImpl