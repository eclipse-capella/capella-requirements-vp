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
package org.polarsys.kitalpha.vp.requirements.ui.properties.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.polarsys.capella.core.model.handler.command.CapellaResourceHelper;
import org.polarsys.capella.core.ui.properties.controllers.SimpleSemanticFieldController;

/**
 */
public class RequirementController extends SimpleSemanticFieldController {
  @Override
  public List<EObject> readOpenValues(EObject semanticElement, EStructuralFeature semanticFeature) { 
    List<EObject> eObjs = new ArrayList<EObject>(); 
    for (EObject eObj : super.readOpenValues(semanticElement, semanticFeature))
      if (!isLibraryProject(eObj))
        eObjs.add(eObj);
    return eObjs;
  }
  
  /**
   * Returns whether the given project is a library project
   */
  public boolean isLibraryProject(IProject targetProject) {
    try {
      return targetProject.hasNature(CapellaResourceHelper.CAPELLA_LIBRARY_PROJECT_NATURE);
    } catch (CoreException exception) {
      return false;
    }
  }

  /**
   * Returns whether the given resource belongs to a library project
   */
  public boolean isLibraryProject(Resource resource) {
    IFile file = WorkspaceSynchronizer.getFile(resource);
    if (file != null) {
      IProject project = file.getProject();
      if (project != null) {
        return isLibraryProject(project);
      }
    }
    return false;
  }

  /**
   * Returns whether the given resource belongs to a library project
   */
  public boolean isLibraryProject(EObject eObject) {
    Resource res = CapellaResourceHelper.getMainModelResource(eObject);
    if (res != null) {
      return isLibraryProject(res);
    }
    return false;
  }
}
