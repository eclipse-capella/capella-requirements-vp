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
package org.polarsys.capella.vp.requirements.ui.importer.preferences;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
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
      // We trigger a LongRunningOperation to perform global refresh at saving preferences
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
    Composite parentGroup = new Composite(getFieldEditorParent(), SWT.NONE);
    parentGroup.setLayout(new GridLayout(1, false));

    final Composite grp = createGroup("Requirement's label",
        "Insert here an interpreted expression that will be evaluated to show the requirement's label", parentGroup);

    StringFieldEditor _delayFieldEditor = new StringFieldEditor(
        RequirementsPreferencesConstants.REQUIREMENT_LABEL_EXPRESSION, "Expression", grp);

    addField(_delayFieldEditor);

    final StringFieldEditor maxLenFieldEditor = new StringFieldEditor(
        RequirementsPreferencesConstants.REQUIREMENT_LABEL_MAX_LEN, "Length (put nothing to display full text):", grp);
    maxLenFieldEditor.getTextControl(grp)
        .addModifyListener(new NumberFieldModifyListener(maxLenFieldEditor.getTextControl(grp)));
    addField(maxLenFieldEditor);

    final Composite grpValue = createGroup("Attribute Value's label",
        "Insert here the maximum length of an attribute value's label", parentGroup);
    final StringFieldEditor maxValueLenFieldEditor = new StringFieldEditor(
        RequirementsPreferencesConstants.VALUE_LABEL_MAX_LEN, "Length (put nothing to display full text):", grpValue);
    maxValueLenFieldEditor.getTextControl(grpValue)
        .addModifyListener(new NumberFieldModifyListener(maxValueLenFieldEditor.getTextControl(grpValue)));
    addField(maxValueLenFieldEditor);
    
    final Composite grpOther = createGroup("Other configuration items",
            "", parentGroup);
        final BooleanFieldEditor forceDoorsRmfUsageBooleanEditor = new BooleanFieldEditor(
            RequirementsPreferencesConstants.PREFERENCE_FORCE_DOORS_RMF_USAGE, "Force DOORS RMF usage check while importing requirements", grpOther);
        addField(forceDoorsRmfUsageBooleanEditor);

  }

  @Override
  protected String getPageTitle() {
    return "Requirements";
  }

  @Override
  protected String getPageDescription() {
    return "Capella requirements preference page";
  }

  class NumberFieldModifyListener implements ModifyListener {
    ControlDecoration decorator;

    public NumberFieldModifyListener(Control control) {
      decorator = new ControlDecoration(control, SWT.CENTER);
      decorator.setDescriptionText("Not a valid number");
      Image image = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
          .getImage();
      decorator.setImage(image);
      decorator.hide();
    }

    @Override
    public void modifyText(ModifyEvent event) {
      String text = ((Text) event.getSource()).getText();
      if (!text.matches("\\d*")) {
        decorator.show();
        setValid(false);
      } else {
        decorator.hide();
        setValid(true);
      }
    }

  }
}