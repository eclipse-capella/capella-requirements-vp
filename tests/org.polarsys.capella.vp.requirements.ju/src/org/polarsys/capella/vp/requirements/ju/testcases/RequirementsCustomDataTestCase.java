/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
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
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.test.framework.helpers.IResourceHelpers;
import org.polarsys.capella.vp.requirements.ju.transposer.TestRequirementsImportLauncher;
import org.polarsys.capella.vp.requirements.ui.commands.ReqVPCustomDataHelper;
import org.polarsys.capella.vp.requirements.ui.commands.SaveQueriesCommand;

/**
 * Make sure the custom data for requirements vp is well manipulated and persisted in the resource.
 * 
 * @author Cong Bang DO
 *
 */
public class RequirementsCustomDataTestCase extends BasicTestCase {

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
    SessionContext sessionContext = new SessionContext(getSession(projectTestName));
    final EObject target = sessionContext.getSemanticElement(systemAnalysis);

    if (target instanceof BlockArchitecture) {
      TransactionHelper.getExecutionManager(target).execute(new AbstractReadWriteCommand() {
        @Override
        public void run() {
          File file = IResourceHelpers.getFileOrFolderInTestPlugin(getClass(), inputFileName);
          URI model = URI.createFileURI(file.getPath());
          new TestRequirementsImportLauncher().launch(model, (BlockArchitecture) target, new NullProgressMonitor());
        }
      });
      
      // By default, the custom data is null.
      assertNull(ReqVPCustomDataHelper.getCustomData(sessionContext.getSession()));

      EAnnotation queriesAnnotation = ReqVPCustomDataHelper.getCustomData(sessionContext.getSession());

      if (queriesAnnotation == null) {
        queriesAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
      }

      TransactionalEditingDomain domain = sessionContext.getSession().getTransactionalEditingDomain();
      domain.getCommandStack().execute(new SaveQueriesCommand(domain, sessionContext.getSession(), queriesAnnotation,
          "label1", "content1", "1", "1"));

      EAnnotation savedQueriesAnnotation = ReqVPCustomDataHelper.getCustomData(sessionContext.getSession());
      assertNotNull(savedQueriesAnnotation);
      assertEquals(
          savedQueriesAnnotation.getDetails().get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL),
          "label1");
      assertEquals(savedQueriesAnnotation.getDetails()
          .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL_LENGTH), "1");
      assertEquals(
          savedQueriesAnnotation.getDetails().get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT),
          "content1");
      assertEquals(savedQueriesAnnotation.getDetails()
          .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT_LENGTH), "1");

      domain.getCommandStack().execute(new SaveQueriesCommand(domain, sessionContext.getSession(),
          savedQueriesAnnotation, "label2", "content2", "2", "2"));

      EAnnotation savedQueriesAnnotation2 = ReqVPCustomDataHelper.getCustomData(sessionContext.getSession());
      assertNotNull(savedQueriesAnnotation2);
      assertEquals(
          savedQueriesAnnotation2.getDetails().get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL),
          "label2");
      assertEquals(savedQueriesAnnotation2.getDetails()
          .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL_LENGTH), "2");
      assertEquals(
          savedQueriesAnnotation2.getDetails().get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT),
          "content2");
      assertEquals(savedQueriesAnnotation2.getDetails()
          .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT_LENGTH), "2");
    }
  }
}
