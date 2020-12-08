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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.polarsys.capella.common.mdsofa.common.helper.FileHelper;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.vp.requirements.model.helpers.TraceHelper;

public class TraceHelperTestCase extends BasicTestCase {

  private static final String LEGACY_VALID = "./A/In-Flight Entertainment System.melodymodeller.bridgetraces";
  private static final String LEGACY_INVALID = "./A/In-Flight Entertainment System.yolo.bridgetraces";

  private static final String MODERN_VALID = "./A/In-Flight Entertainment System.capella.bridgetraces";
  private static final String MODERN_INVALID = "./A/In-Flight Entertainment System.capellaInvalid.bridgetraces";

  @Override
  public void test() throws Exception {
    testResourceHelpers();
  }

  public void testResourceHelpers() {

    IFile legacyValidFile = FileHelper.getPlatformFile(LEGACY_VALID);
    IFile legacyInvalidFile = FileHelper.getPlatformFile(LEGACY_INVALID);

    IFile modernValidFile = FileHelper.getPlatformFile(MODERN_VALID);
    IFile modernInvalidFile = FileHelper.getPlatformFile(MODERN_INVALID);

    assertTrue(TraceHelper.isLegacyTraceResource(legacyValidFile));
    assertFalse(TraceHelper.isLegacyTraceResource(modernValidFile));
    assertFalse(TraceHelper.isLegacyTraceResource(legacyInvalidFile));

    assertTrue(TraceHelper.isTraceResource(modernValidFile));
    assertFalse(TraceHelper.isTraceResource(legacyValidFile));
    assertFalse(TraceHelper.isTraceResource(modernInvalidFile));

    assertEquals(Path.fromOSString(MODERN_VALID),
        TraceHelper.convertLegacyTracePathToModern(Path.fromOSString(LEGACY_VALID)));
  }

}
