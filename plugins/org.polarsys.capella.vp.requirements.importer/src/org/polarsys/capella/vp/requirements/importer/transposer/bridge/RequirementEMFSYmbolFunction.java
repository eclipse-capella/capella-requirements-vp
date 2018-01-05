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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import org.eclipse.emf.diffmerge.bridge.impl.emf.EMFSymbolFunction;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecRelation;

/**
 * 
 * This class provides customizations to mapping traces
 *
 */
public class RequirementEMFSYmbolFunction extends EMFSymbolFunction {

  private static final RequirementEMFSYmbolFunction INSTANCE = new RequirementEMFSYmbolFunction();

  public static RequirementEMFSYmbolFunction getInstance() {
    return INSTANCE;
  }

  @Override
  public String getEObjectSymbol(EObject element) {

    // For a Spec Hierarchy, use the identifier of its Spec Object instead
    if (element instanceof SpecHierarchy) {
      return getEObjectSymbol(((SpecHierarchy) element).getObject());
    }
    // For a Spec Relation, use the combination of its's source identifier, target identifier and Relation Type
    // identifier
    else if (element instanceof SpecRelation) {
      return getEObjectSymbol(((SpecRelation) element).getSource())
          + "+" + getEObjectSymbol(((SpecRelation) element).getTarget())
          + "+" +  getEObjectSymbol(((SpecRelation) element).getType());
    }

    return super.getEObjectSymbol(element);
  }
}