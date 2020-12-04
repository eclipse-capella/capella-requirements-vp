/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.model.migration;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.polarsys.capella.core.data.migration.AbstractMigrationRunnable;
import org.polarsys.capella.core.data.migration.context.MigrationContext;
import org.polarsys.capella.vp.requirements.model.helpers.TraceHelper;

public class TraceMigrationRunnable extends AbstractMigrationRunnable {

  public TraceMigrationRunnable(IFile file) {
    super(file);
  }

  @Override
  public IStatus run(MigrationContext context, boolean checkVersion) {
    IFile traceFile = getFile();

    if (TraceHelper.isLegacyTraceResource(traceFile)) {
      try {
        TraceHelper.renameLegacyTraceFile(traceFile);
      } catch (CoreException exception) {
        return new Status(IStatus.ERROR, TraceMigrationRunnable.class, exception.getMessage(), exception);
      }

    }
    return Status.OK_STATUS;
  }
}
