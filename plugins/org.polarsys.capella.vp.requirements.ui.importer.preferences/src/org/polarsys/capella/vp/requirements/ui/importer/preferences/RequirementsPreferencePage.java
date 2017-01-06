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

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.IPreferenceConstants;
import org.eclipse.ui.internal.WorkbenchMessages;
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

    final Composite grp = createGroup("Requirement's label",
        "Insert here an interpreted expression that will be evaluated to show the requirement's label",
        getFieldEditorParent());

    StringFieldEditor _delayFieldEditor = new StringFieldEditor(
        RequirementsPreferencesConstants.REQUIREMENT_LABEL_EXPRESSION, "Expression", grp);
    
    addField(_delayFieldEditor);
    
    final StringFieldEditor maxLenFieldEditor = new StringFieldEditor(RequirementsPreferencesConstants.REQUIREMENT_LABEL_MAX_LEN,
        "Number of displayed characters for a requirement label (put nothing to display full text):", grp);
    maxLenFieldEditor.getTextControl(grp).addModifyListener(new ModifyListener() {
      ControlDecoration decorator;
      {
          decorator = new ControlDecoration(maxLenFieldEditor.getTextControl(grp), SWT.CENTER);
          decorator.setDescriptionText("Not a valid number");
          Image image = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage();
          decorator.setImage(image);
          decorator.hide();
      }
      @Override
      public void modifyText(ModifyEvent event) {
          String text = ((Text) event.getSource()).getText();
          if (!text.matches("\\d*")) { 
            decorator.show();
            setValid(false);
          }
          else {
            decorator.hide();
            setValid(true);
          }
      }
    });
    addField(maxLenFieldEditor);
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