/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
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

import java.io.File;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.test.framework.helpers.IResourceHelpers;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.IRequirementsImporterBridgeConstants;
import org.polarsys.capella.vp.requirements.ju.transposer.TestRequirementsImportLauncher;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * 
 * This test case imports a sample ReqIF model into a test model and test that the target scope is not read-only. See Bug 2325 
 */
public class EditableTargetScope extends ModelDiffTestCase {

  @Override
  public void test() throws Exception {
    SessionContext session = new SessionContext(getSession(projectTestName));
    getSession(projectWithImportedReqifTestName);
    final EObject target = session.getSemanticElement(systemAnalysis);
    final TestRequirementsImportLauncher testRequirementsImportLauncher = new TestRequirementsImportLauncher();
    
    if (target instanceof BlockArchitecture) {
      TransactionHelper.getExecutionManager(target).execute(new AbstractReadWriteCommand() {
        @Override
        public void run() {
          File file = IResourceHelpers.getFileOrFolderInTestPlugin(getClass(), inputFileName);
          URI model = URI.createFileURI(file.getPath());
          testRequirementsImportLauncher.launch(model, (BlockArchitecture) target, new NullProgressMonitor());
        }
      });
    }
    
    IContext context = testRequirementsImportLauncher.getContext();
    IEditableModelScope targetScope = (IEditableModelScope) context.get(IRequirementsImporterBridgeConstants.TARGET_SCOPE);
    assertTrue("The target scope must not be read-only, otherwise we can have merge problem", !targetScope.isReadOnly());
  }
}
