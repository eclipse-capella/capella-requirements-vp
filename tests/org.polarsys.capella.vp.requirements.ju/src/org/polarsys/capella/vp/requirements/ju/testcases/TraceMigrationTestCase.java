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
  private static final String TRACE_FILE_POSTFIX = ".capella.bridgetraces";

  @Override
  public void test() throws Exception {
    IProject project = IResourceHelpers.getEclipseProjectInWorkspace(TEST_MODEL);

    IFile legacyTraceFile = project.getFile(TEST_MODEL + TRACE_FILE_POSTFIX);
    String legacyTracePath = legacyTraceFile.getFullPath().toOSString();
    String legacyTraceContent = FileHelper.readFile(legacyTracePath);

    MigrationHelper.migrateProject(project);

    IFile migratedTraceFile = project.getFile(TEST_MODEL + TRACE_FILE_POSTFIX);
    String migratedTracePath = migratedTraceFile.getFullPath().toOSString();
    String migratedTraceContent = FileHelper.readFile(migratedTracePath);

    assertEquals(legacyTraceContent, migratedTraceContent);
  }

  @Override
  public List<String> getRequiredTestModels() {

    return Arrays.asList(TEST_MODEL);
  }

}
