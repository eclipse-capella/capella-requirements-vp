/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.model.helpers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.polarsys.capella.core.model.handler.command.CapellaResourceHelper;

public class TraceHelper {
  private static final String TRACE_FILE_EXTENSION = "bridgetraces";

  public static URI getTraceURI(URI uri) {
    return uri.appendFileExtension(TRACE_FILE_EXTENSION);
  }

  // Initial: model-with-manually-created-elements.melodymodeller.bridgetraces
  // Expected: model-with-manually-created-elements.capella.bridgetraces

  private static boolean hasTraceExtension(IResource resource) {
    return resource != null && IResource.FILE == resource.getType()
        && TRACE_FILE_EXTENSION.equals(resource.getFileExtension());
  }

  private static boolean hasSecondaryExtension(IResource resource, String expectedExtension) {
    if (expectedExtension != null && hasTraceExtension(resource)) {
      IPath resourcePath = resource.getFullPath();
      IPath capellaResourcePath = resourcePath.removeFileExtension();
      String capellaResourceExtension = capellaResourcePath.getFileExtension();
      return expectedExtension.equals(capellaResourceExtension);
    }

    return false;
  }

  public static boolean isLegacyTraceResource(IResource resource) {
    return hasSecondaryExtension(resource, CapellaResourceHelper.LEGACY_CAPELLA_MODEL_FILE_EXTENSION);
  }

  public static boolean isTraceResource(IResource resource) {
    return hasSecondaryExtension(resource, CapellaResourceHelper.CAPELLA_MODEL_FILE_EXTENSION);
  }

  public static IPath convertLegacyTracePathToModern(IPath tracePath) {
    IPath legacyCapellaResourcePath = tracePath.removeFileExtension();
    IPath modernCapellaResourcePath = CapellaResourceHelper
        .convertLegacyResourcePathToModern(legacyCapellaResourcePath);

    return modernCapellaResourcePath.addFileExtension(TRACE_FILE_EXTENSION);
  }

  public static void renameLegacyTraceFile(IFile traceFile) throws CoreException {
    IPath legacyTracePath = traceFile.getFullPath();
    IPath modernTracePath = convertLegacyTracePathToModern(legacyTracePath);

    traceFile.move(modernTracePath, true, new NullProgressMonitor());
  }

}
