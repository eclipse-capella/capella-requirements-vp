/**
 *  Copyright (c) 2019 THALES GLOBAL SERVICES.
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

package org.polarsys.kitalpha.vp.requirements.docgen.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;

import java.io.IOException;
import java.io.InputStream;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;
import org.polarsys.kitalpha.vp.requirements.Requirements.Folder;
import org.polarsys.kitalpha.vp.requirements.Requirements.Module;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

import org.polarsys.kitalpha.vp.requirements.docgen.Activator;

public class ImageHelper {

  public static String getImagePath(EObject model, String projectName, String outputFolder)
      throws IOException, CoreException {
    if (model instanceof Module) {
      // copyFile(projectName, outputFolder, "Module.png");
      return "../icon/Module.png";
    }
    if (model instanceof Folder) {
      copyFile(projectName, outputFolder, "Folder.png");
      return "../icon/Folder.png";
    }
    if (model instanceof Requirement) {
      copyFile(projectName, outputFolder, "Requirement.png");
      return "../icon/Requirement.png";
    }
    return "";
  }

  public static void copyFile(String projectName, String outputFolder, String fileName)
      throws IOException, CoreException {
    Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
    InputStream stream = FileLocator.openStream(bundle, new Path("icons/" + fileName), false);
    IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
    IFolder folder = project.getFolder(outputFolder);
    String targetFilePath = folder.getParent().getProjectRelativePath().toString() + "/icon/" + fileName;

    IFile destinationFile = project.getFile(targetFilePath);
    if (!destinationFile.exists()) {
      destinationFile.create(stream, true, new NullProgressMonitor());
    }
  }
}
