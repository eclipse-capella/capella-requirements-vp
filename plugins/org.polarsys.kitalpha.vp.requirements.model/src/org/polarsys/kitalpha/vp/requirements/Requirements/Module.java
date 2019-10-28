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

package org.polarsys.kitalpha.vp.requirements.Requirements;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Module#getModuleType <em>Module Type</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Module#getOwnedRequirements <em>Owned Requirements</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getModule()
 * @model
 * @generated
 */

public interface Module extends AttributeOwner, SharedDirectAttributes {

	/**
	 * Returns the value of the '<em><b>Module Type</b></em>' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module Type</em>' reference.
	 * @see #setModuleType(ModuleType)
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getModule_ModuleType()
	 * @model
	 * @generated
	 */

	ModuleType getModuleType();

	/**
	 * Sets the value of the '{@link org.polarsys.kitalpha.vp.requirements.Requirements.Module#getModuleType <em>Module Type</em>}' reference.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module Type</em>' reference.
	 * @see #getModuleType()
	 * @generated
	 */

	void setModuleType(ModuleType value);

	/**
	 * Returns the value of the '<em><b>Owned Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement}.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Requirements</em>' containment reference list.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getModule_OwnedRequirements()
	 * @model containment="true"
	 * @generated
	 */

	EList<Requirement> getOwnedRequirements();

} // Module
