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
package org.polarsys.capella.vp.requirements.ui.importer.preferences;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesPlugin;

/**
 * @author Joao Barata
 */
public class RequirementsPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	public RequirementsPreferencePage() {
		setPreferenceStore(RequirementsUIPreferencesPlugin.getDefault().getPreferenceStore());
		setDescription("Capella requirements preference page");
	}

  @Override
  protected Control createContents(Composite parent) {
    Composite result = new Composite(parent, SWT.NONE);

    GridLayout layout = new GridLayout();
    result.setLayout(layout);

    Group grp = new Group(result, SWT.NONE);
    grp.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
    grp.setLayout(new GridLayout());
    createScopeSelectionSection(grp);

    applyDialogFont(result);

    return result;
  }

  void createScopeSelectionSection(Composite container) {
    final IEclipsePreferences scope = InstanceScope.INSTANCE.getNode(RequirementsPreferencesPlugin.PLUGIN_ID);
    String expression = scope.get(RequirementsPreferencesConstants.REQUIREMENT_LABEL_EXPRESSION, RequirementsPreferencesConstants.REQUIREMENT_DEFAULT_LABEL_EXPRESSION);

    Label lbl = new Label(container, SWT.NONE);
    lbl.setText("Insert here an Acceleo expression that will be evaluated to show the requirement's label:"); //$NON-NLS-1$
    lbl.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, true));
    Text txt = new Text(container, SWT.MULTI);
    txt.setText(expression);
    txt.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, true));
    txt.addModifyListener(new ModifyListener() {
      @Override
      public void modifyText(ModifyEvent event) {
        try {
          String text = ((Text) event.getSource()).getText();
          scope.put(RequirementsPreferencesConstants.REQUIREMENT_LABEL_EXPRESSION, text);
          scope.flush();
        } catch (BackingStoreException ex) {
          ex.printStackTrace();
        }
      }
    });
  }

	/**
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}