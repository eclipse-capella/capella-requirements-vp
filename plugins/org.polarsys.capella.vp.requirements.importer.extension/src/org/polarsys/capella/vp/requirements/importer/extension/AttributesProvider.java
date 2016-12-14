/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
