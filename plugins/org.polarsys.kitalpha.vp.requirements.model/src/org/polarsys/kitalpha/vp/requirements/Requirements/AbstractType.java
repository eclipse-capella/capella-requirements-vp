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

package org.polarsys.kitalpha.vp.requirements.Requirements;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType#getOwnedAttributes <em>Owned Attributes</em>}</li>
 * </ul>
 *
 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAbstractType()
 * @model abstract="true"
 * @generated
 */

public interface AbstractType extends ReqIFElement {

	/**
	 * Returns the value of the '<em><b>Owned Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition}.
	
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Attributes</em>' containment reference list.
	 * @see org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage#getAbstractType_OwnedAttributes()
	 * @model containment="true"
	 * @generated
	 */

	EList<AttributeDefinition> getOwnedAttributes();

} // AbstractType
