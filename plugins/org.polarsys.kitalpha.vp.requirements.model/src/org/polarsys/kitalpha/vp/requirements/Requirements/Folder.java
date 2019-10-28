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
 * A representation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.Folder#getOwnedRequirements <em>Owned Requirements</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getFolder()
 * @model
 * @generated
 */

public interface Folder extends Requirement {

	/**
	 * Returns the value of the '<em><b>Owned Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement}.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Requirements</em>' containment reference list.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getFolder_OwnedRequirements()
	 * @model containment="true"
	 * @generated
	 */

	EList<Requirement> getOwnedRequirements();

} // Folder
