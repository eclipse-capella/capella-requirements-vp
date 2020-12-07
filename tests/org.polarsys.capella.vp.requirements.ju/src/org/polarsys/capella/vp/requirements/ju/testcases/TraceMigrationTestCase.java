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
package org.polarsys.capella.vp.requirements.ju.testcases;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.polarsys.capella.common.mdsofa.common.helper.FileHelper;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.helpers.IResourceHelpers;
import org.polarsys.capella.test.migration.ju.helpers.MigrationHelper;

public class TraceMigrationTestCase extends BasicTestCase {

  private static final String TEST_MODEL = "migration-model";
  private static final String LEGACY_TRACE_FILE = "migration-model.melodymodeller.bridgetraces";
  private static final String MIGRATED_TRACE_FILE = "migration-model.capella.bridgetraces";

  @Override
  public void test() throws Exception {
    IProject project = IResourceHelpers.getEclipseProjectInWorkspace(TEST_MODEL);

    IFile legacyTraceFile = project.getFile(LEGACY_TRACE_FILE);
    String legacyTracePath = legacyTraceFile.getFullPath().toOSString();
    String legacyTraceContent = FileHelper.readFile(legacyTracePath);

    MigrationHelper.migrateProject(project);

    IFile migratedTraceFile = project.getFile(MIGRATED_TRACE_FILE);
    String migratedTracePath = migratedTraceFile.getFullPath().toOSString();
    String migratedTraceContent = FileHelper.readFile(migratedTracePath);

    assertEquals(legacyTraceContent, migratedTraceContent);
  }

  @Override
  public List<String> getRequiredTestModels() {

    return Arrays.asList(TEST_MODEL);
  }

}
