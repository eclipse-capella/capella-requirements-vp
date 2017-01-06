/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.importer.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.polarsys.capella.common.helpers.operations.LongRunningListenersRegistry;
import org.polarsys.capella.core.commands.preferences.service.AbstractDefaultPreferencePage;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesPlugin;

/**
 * @author Joao Barata
 */
public class RequirementsPreferencePage extends AbstractDefaultPreferencePage {

  public RequirementsPreferencePage() {
    setPreferenceStore(RequirementsPreferencesPlugin.getDefault().getPreferenceStore());
  }

  @Override
  protected IPreferenceStore doGetPreferenceStore() {
    return RequirementsPreferencesPlugin.getDefault().getPreferenceStore();
  }
  
  @Override
  public boolean performOk() {
    boolean result = false;
    try { 
      //We trigger a LongRunningOperation to perform global refresh at saving preferences
      LongRunningListenersRegistry.getInstance().operationStarting(getClass());
      result = super.performOk();
      
    } finally { 
      LongRunningListenersRegistry.getInstance().operationEnded(getClass());
    }

    return result;
  }

  @Override
  protected void createFieldEditors() {
    super.createFieldEditors();

    Composite grp = createGroup("Requirement's label",
        "Insert here an interpreted expression that will be evaluated to show the requirement's label",
        getFieldEditorParent());

    StringFieldEditor _delayFieldEditor = new StringFieldEditor(
        RequirementsPreferencesConstants.REQUIREMENT_LABEL_EXPRESSION, "Expression", grp);
    addField(_delayFieldEditor);
  }

  @Override
  protected String getPageTitle() {
    return "Requirements";
  }

  @Override
  protected String getPageDescription() {
    return "Capella requirements preference page";
  }

}