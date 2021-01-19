/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
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

import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

public class HtmlToTextTestCase extends BasicTestCase {

  private static final String projectTestName = "misc";

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

    Requirement target = session.getSemanticElement("130237c0-c390-4b1a-99e8-1933d14d0f21");
    setText(target, "value1<okok>");
    assertTrue(EObjectLabelProviderHelper.getText(target).equals("value1"));
    
    setText(target, "value1<okok>\r\nvalue2");
    assertTrue(EObjectLabelProviderHelper.getText(target).equals("value1 value2"));
    
    setText(target, "value1<okok>\nvalue2");
    assertTrue(EObjectLabelProviderHelper.getText(target).equals("value1 value2"));

    setText(target, "value1<okok><pppp>\n<lll>\n</br>\r\n</kkkk>value2");
    assertTrue(EObjectLabelProviderHelper.getText(target).equals("value1   value2"));
  }
  
  private void setText(Requirement req, String text) {
    TransactionHelper.getExecutionManager(req).execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        req.setReqIFText(text);
      }
    });
  }
}
