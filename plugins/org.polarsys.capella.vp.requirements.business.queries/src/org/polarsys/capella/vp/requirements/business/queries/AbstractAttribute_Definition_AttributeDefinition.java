/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/

package org.polarsys.capella.vp.requirements.business.queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.Module;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public abstract class AbstractAttribute_Definition_AttributeDefinition implements IBusinessQuery {

  @Override
  public List<EObject> getAvailableElements(EObject element) {
    List<EObject> availableElements = new ArrayList<EObject>();
    if(element instanceof Attribute){
      EObject eContainer = element.eContainer();
      if(eContainer instanceof Requirement){
        Requirement requirement = (Requirement)eContainer;
        if(requirement.getRequirementType() != null){
          availableElements.addAll(requirement.getRequirementType().getOwnedAttributes());
        }
      }else if(eContainer instanceof Module){
        Module module = (Module)eContainer;
        if(module.getModuleType() != null){
          availableElements.addAll(module.getModuleType().getOwnedAttributes());
        }
      }else if(eContainer instanceof AbstractRelation){
        AbstractRelation relation = (AbstractRelation)eContainer;
        if(relation.getRelationType() != null){
          availableElements.addAll(relation.getRelationType().getOwnedAttributes());
        }
      }
    }
    return availableElements;
  }

  @Override
  public List<EObject> getCurrentElements(EObject element, boolean onlyGenerated) {
    List<EObject> currentElements = new ArrayList<EObject>();
    if(element instanceof Attribute){
      Attribute attribute = (Attribute)element;
      AttributeDefinition definition = attribute.getDefinition();
      if(definition != null){
        currentElements.add(definition);
      }
    }
    return currentElements;
  }

  @Override
  public List<EReference> getEStructuralFeatures() {
    return Collections.singletonList(RequirementsPackage.Literals.ATTRIBUTE__DEFINITION);
  }
}
