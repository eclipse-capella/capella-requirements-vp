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

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesInitializer;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.internal.AttributesSelectionSection;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.internal.FilesSelectionSection;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.internal.messages.Messages;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.util.SWTUtil;

/**
 * @author Joao Barata
 */
public class ImporterPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
  
  public ImporterPreferencePage(){
    new RequirementsPreferencesInitializer().initializeDefaultPreferences();
  }
    /**
     * 
     */
    public static final String PROPERTY_PAGE_ID = RequirementsUIPreferencesPlugin.PLUGIN_ID + "ImporterPreferencePage"; //$NON-NLS-1$
    
    private AttributesSelectionSection attributesSelectionSection;
    private FilesSelectionSection filesSelectionSection;

    @Override
    protected Control createContents(Composite parent) {
        Composite result = new Composite(parent, SWT.NONE);

        GridLayout layout = new GridLayout();
        result.setLayout(layout);

        createFilesSelectionSection(result);

        createAttributesSelectionSection(result);
        
        // Wire both sections
        filesSelectionSection.addListener(attributesSelectionSection);

        applyDialogFont(result);

        return result;
    }

    private void createFilesSelectionSection(Composite container) {
      filesSelectionSection = new FilesSelectionSection();
      filesSelectionSection.createComposite(container);
    }

    private void createAttributesSelectionSection(Composite container) {
      attributesSelectionSection = new AttributesSelectionSection();
      attributesSelectionSection.createComposite(container);
    }

    @Override
    public void init(IWorkbench workbench) {
    }

    @Override
    protected void performApply() {
      filesSelectionSection.performApply(getPreferenceStore());
      attributesSelectionSection.performApply(getPreferenceStore());
    }

    @Override
    public boolean performOk() {
        performApply();
        return super.performOk();
    }

    @Override
    protected void performDefaults() {
      filesSelectionSection.performDefaults(getPreferenceStore());
      attributesSelectionSection.performDefaults(getPreferenceStore());
    }

    @Override
    public boolean performCancel() {
        performDefaults();
        return super.performCancel();
    }

    @Override
    protected IPreferenceStore doGetPreferenceStore() {
        return RequirementsUIPreferencesPlugin.getDefault().getPreferenceStore();
    }
}
