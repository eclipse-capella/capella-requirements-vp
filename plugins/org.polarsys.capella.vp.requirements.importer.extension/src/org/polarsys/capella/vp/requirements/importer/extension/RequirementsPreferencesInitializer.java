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
package org.polarsys.capella.vp.requirements.importer.extension;

import java.util.List;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesPlugin;

/**
 * Class used to initialize default preference values.
 */
public class RequirementsPreferencesInitializer extends AbstractPreferenceInitializer {

  /**
   * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
   */
  @Override
  public void initializeDefaultPreferences() {
    IPreferenceStore store = RequirementsPreferencesPlugin.getDefault().getPreferenceStore();
    List<AttributeSet> allAttributes = AttributesProvider.getInstance().getAttributes();
    for (AttributeSet attribute : allAttributes) {
      String key = ReqImporterPreferencesUtil.getPreferenceKey(attribute);
      store.setDefault(key, attribute.defaultValue());
    }
  }
}
