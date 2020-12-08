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
package org.polarsys.capella.vp.requirements.ui.commands;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.polarsys.capella.vp.requirements.ui.commands.messages"; //$NON-NLS-1$
  public static String GROUP_TITLE_FOR_LABEL_AREA;
  public static String GROUP_TITLE_FOR_CONTENT_AREA;
  public static String EXPRESSION_LABEL_TEXT;
  public static String LENGTH_LABEL_TEXT;
  public static String DefaultValueOfLabelExpression;
  public static String DefaultValueOfContentExpression;
  public static String DefaultValueOfLabelMaxLength;
  public static String DefaultValueOfContentMaxLength;
  public static String ReqVPConfigureDialog_Title;
  public static String ReqVPConfigureDialog_Message;
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
  }
}
