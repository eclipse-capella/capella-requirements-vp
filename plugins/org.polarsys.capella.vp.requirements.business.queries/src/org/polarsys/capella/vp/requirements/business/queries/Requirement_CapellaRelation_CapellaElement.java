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
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * @author Joao Barata
 */
public abstract class Requirement_CapellaRelation_CapellaElement implements IBusinessQuery {

  @Override
	public EClass getEClass() {
    return RequirementsPackage.Literals.REQUIREMENT;
  }

  /**
	 * 
	 */
  List<CapellaElement> getCapellaElements(BlockArchitecture arch) {
    List<CapellaElement> elements = new ArrayList<CapellaElement>();

    TreeIterator<EObject> content = arch.eAllContents();
    while (content.hasNext()) {
      EObject object = (EObject) content.next();
      if (object instanceof CapellaElement) {
        elements.add((CapellaElement) object);
      }
    }

    return elements;
  }
}
