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
package org.polarsys.capella.vp.requirements.importer.preferences;

import java.util.Collection;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;
import org.polarsys.capella.vp.requirements.importer.extension.AttributesProvider;
import org.polarsys.capella.vp.requirements.importer.extension.RequirementsImporterExtensionPlugin;

/**
 * Class used to initialize default preference values.
 */
public class RequirementsPreferencesInitializer extends AbstractPreferenceInitializer {

  /**
   * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
   */
  @Override
  public void initializeDefaultPreferences() {
    initializeDefaultPreferences(AttributesProvider.getInstance().getCategories());
  }
  
  public void initializeDefaultPreferences(Collection<AttributeSet> attributes){
    IEclipsePreferences defaultScope = DefaultScope.INSTANCE.getNode(RequirementsImporterExtensionPlugin.PLUGIN_ID);
    for (AttributeSet category : attributes) {
      for (AttributeSet attribute : category.getChildren()) {
        String key = ReqImporterPreferences.getPreferenceKey(attribute);
        defaultScope.putBoolean(key, attribute.defaultValue());
      }
    }
  }
}
