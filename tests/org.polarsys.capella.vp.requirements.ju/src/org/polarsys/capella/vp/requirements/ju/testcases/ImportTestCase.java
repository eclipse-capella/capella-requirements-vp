/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
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
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.test.framework.helpers.IResourceHelpers;
import org.polarsys.capella.vp.requirements.ju.transposer.TestRequirementsImportLauncher;

/**
 * @author Joao Barata
 */
public class ImportTestCase extends BasicTestCase {

  private static final String systemAnalysis = "24658239-7734-4c39-9402-83325c52d04c";
  
  private static final String inputFileName = "model/inputs/model1.reqif";

  private static final String projectTestName = "emptymodel";

  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestArtefact#getRequiredTestModels()
   */
  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(projectTestName);
  }

  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestCase#test()
   */
  @Override
  public void test() throws Exception {
    SessionContext session = new SessionContext(getSession(projectTestName));
    final EObject target = session.getSemanticElement(systemAnalysis);
    
    if (target instanceof BlockArchitecture) {
      TransactionHelper.getExecutionManager(target).execute(new AbstractReadWriteCommand() {
        @Override
        public void run() {
          File file = IResourceHelpers.getFileOrFolderInTestPlugin(getClass(), inputFileName);
          URI model = URI.createFileURI(file.getPath());
          new TestRequirementsImportLauncher().launch(model, (BlockArchitecture) target, new NullProgressMonitor());
        }
      });
    }
  }
}
