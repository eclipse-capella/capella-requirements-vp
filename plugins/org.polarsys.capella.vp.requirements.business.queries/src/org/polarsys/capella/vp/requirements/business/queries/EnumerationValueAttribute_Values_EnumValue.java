/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.business.queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.model.utils.ListExt;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public class EnumerationValueAttribute_Values_EnumValue implements IBusinessQuery {

  /**
   * @see org.polarsys.capella.core.business.queries.ui.business.queries.IBusinessQuery#getAvailableElements(EObject)
   */
  @Override
  public List<EObject> getAvailableElements(EObject element) {
    List<EObject> availableElements = new ArrayList<EObject>();

    if (element instanceof EnumerationValueAttribute) {
      AttributeDefinition attDef = ((EnumerationValueAttribute) element).getDefinition();
      if(attDef != null){
        DataTypeDefinition definitionType = attDef.getDefinitionType();
        if (definitionType instanceof EnumerationDataTypeDefinition)
          availableElements.addAll(((EnumerationDataTypeDefinition) definitionType).getSpecifiedValues());        
      }
    }
    return availableElements;
  }

  /**
   * @see org.polarsys.capella.core.business.queries.ui.business.queries.IBusinessQuery#getCurrentElements(EObject,
   *      boolean)
   */
  @Override
  public List<EObject> getCurrentElements(EObject element, boolean onlyGenerated) {
    List<EObject> currentElements = new ArrayList<EObject>();

    if (element instanceof EnumerationValueAttribute) {
      currentElements.addAll(((EnumerationValueAttribute) element).getValues());
    }

    currentElements = ListExt.removeDuplicates(currentElements);

    return currentElements;
  }

  @Override
  public EClass getEClass() {
    return RequirementsPackage.Literals.ENUMERATION_VALUE_ATTRIBUTE;
  }

  @Override
  public List<EReference> getEStructuralFeatures() {
    return Collections.singletonList(RequirementsPackage.Literals.ENUMERATION_VALUE_ATTRIBUTE__VALUES);
  }

}
