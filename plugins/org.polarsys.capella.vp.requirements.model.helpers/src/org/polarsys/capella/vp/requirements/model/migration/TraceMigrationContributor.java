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
package org.polarsys.capella.vp.requirements.model.migration;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.polarsys.capella.core.data.migration.AbstractMigrationRunnable;
import org.polarsys.capella.core.data.migration.MigrationConstants;
import org.polarsys.capella.core.data.migration.contributor.AbstractMigrationContributor;
import org.polarsys.capella.vp.requirements.model.helpers.TraceHelper;

public class TraceMigrationContributor extends AbstractMigrationContributor {

  /**
   * @param member
   * @return
   */
  @Override
  public boolean isValidResource(IResource resource) {
    return TraceHelper.isLegacyTraceResource(resource);
  }

  @Override
  public String getKind() {
    return MigrationConstants.MIGRATION_KIND__SEMANTIC;
  }

  @Override
  public AbstractMigrationRunnable getRunnable(IFile file) {
    return new TraceMigrationRunnable(file);
  }
}
