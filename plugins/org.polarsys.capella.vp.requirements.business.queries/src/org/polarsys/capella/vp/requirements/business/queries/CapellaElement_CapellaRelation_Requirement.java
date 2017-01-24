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
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.vp.requirements.Requirements.Folder;
import org.polarsys.kitalpha.vp.requirements.Requirements.Module;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * @author Joao Barata
 */
public abstract class CapellaElement_CapellaRelation_Requirement implements IBusinessQuery {

  @Override
	public EClass getEClass() {
    return CapellacorePackage.Literals.CAPELLA_ELEMENT;
  }
  
  /**
	 * 
	 */
  List<Requirement> getRequirements(BlockArchitecture arch) {
    List<Requirement> elements = new ArrayList<Requirement>();

    for (ElementExtension pkg : arch.getOwnedExtensions()) {
      if (pkg instanceof Module) {
        for (EObject req : EObjectExt.getAll(pkg, RequirementsPackage.Literals.REQUIREMENT)) {
          if (!(req instanceof Folder)) {
            elements.add((Requirement) req);
          }
        }
      }
    }

    return elements;
  }
}
