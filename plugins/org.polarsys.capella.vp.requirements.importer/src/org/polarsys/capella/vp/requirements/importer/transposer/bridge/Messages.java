/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
  private static final String BUNDLE_NAME = "org.polarsys.capella.vp.requirements.importer.transposer.bridge.messages"; //$NON-NLS-1$
  public static String Categories_Description;
  public static String Categories_InternalRelations;
  public static String Categories_Name;
  public static String Categories_Types;
  public static String CategoryFormat_Description;
  public static String CategoryFormat_Name;
  public static String ImageImportingDialog_DefaultMessage;
  public static String ImageImportingDialog_RelPathMessage;
  public static String ImageImportingDialog_RelativePathLabel;
  public static String ImageImportingDialog_RelativePathErrorMessage;
  
  static {
    // initialize resource bundle
    NLS.initializeMessages(BUNDLE_NAME, Messages.class);
  }

  private Messages() {
  }
}
