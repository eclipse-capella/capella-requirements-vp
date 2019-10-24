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

package org.polarsys.kitalpha.vp.requirements.Requirements;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Types Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder#getOwnedDefinitionTypes <em>Owned Definition Types</em>}</li>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.TypesFolder#getOwnedTypes <em>Owned Types</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getTypesFolder()
 * @model
 * @generated
 */

public interface TypesFolder extends ReqIFElement {

	/**
	 * Returns the value of the '<em><b>Owned Definition Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition}.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Definition Types</em>' containment reference list.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getTypesFolder_OwnedDefinitionTypes()
	 * @model containment="true"
	 * @generated
	 */

	EList<DataTypeDefinition> getOwnedDefinitionTypes();

	/**
	 * Returns the value of the '<em><b>Owned Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType}.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Types</em>' containment reference list.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getTypesFolder_OwnedTypes()
	 * @model containment="true"
	 * @generated
	 */

	EList<AbstractType> getOwnedTypes();

} // TypesFolder
