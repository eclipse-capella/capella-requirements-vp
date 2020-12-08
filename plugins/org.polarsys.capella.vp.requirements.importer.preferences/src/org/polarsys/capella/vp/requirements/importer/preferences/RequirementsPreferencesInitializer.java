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
package org.polarsys.capella.vp.requirements.importer.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

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
    store.setDefault(RequirementsPreferencesConstants.REQUIREMENT_LABEL_EXPRESSION,
        RequirementsPreferencesConstants.REQUIREMENT_DEFAULT_LABEL_EXPRESSION);
    store.setDefault(RequirementsPreferencesConstants.REQUIREMENT_LABEL_MAX_LEN,
        RequirementsPreferencesConstants.REQUIREMENT_DEFAULT_LABEL_MAX_LEN);
    store.setDefault(RequirementsPreferencesConstants.VALUE_LABEL_MAX_LEN,
        RequirementsPreferencesConstants.VALUE_DEFAULT_LABEL_MAX_LEN);
    store.setDefault(RequirementsPreferencesConstants.PREFERENCE_FORCE_DOORS_RMF_USAGE,
            RequirementsPreferencesConstants.DEFAULT_VALUE_FORCE_DOORS_RMF_USAGE);
  }
  
}
