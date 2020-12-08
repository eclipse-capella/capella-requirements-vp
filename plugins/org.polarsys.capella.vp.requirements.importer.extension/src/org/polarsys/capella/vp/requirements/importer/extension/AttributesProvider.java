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
package org.polarsys.capella.vp.requirements.importer.extension;

/**
 * @author Joao Barata
 */
public class AttributesProvider {
  // Model element containing import preferences.
  private static ImportPreferencesModel model = null;
  
  public static void invalidateModel() {
    model = null;
  }
  
  public static ImportPreferencesModel getInstance() {
    if (model == null) {
      model = new ImportPreferencesModel();
    }
    return model;
  }
}
