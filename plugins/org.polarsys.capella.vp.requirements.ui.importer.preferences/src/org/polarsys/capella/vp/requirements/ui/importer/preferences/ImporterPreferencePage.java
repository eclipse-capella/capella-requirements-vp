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

import java.io.IOException;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;
import org.polarsys.capella.vp.requirements.importer.extension.AttributesProvider;
import org.polarsys.capella.vp.requirements.importer.extension.ImportPreferencesModel;
import org.polarsys.capella.vp.requirements.importer.extension.ReqImporterPreferencesUtil;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.internal.AttributesSelectionSection;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.internal.FilesSelectionSection;
import org.polarsys.kitalpha.emde.extension.utils.Log;

/**
 * @author Joao Barata
 */
public class ImporterPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
    /**
     * 
     */
    public static final String PROPERTY_PAGE_ID = RequirementsUIPreferencesPlugin.PLUGIN_ID + "ImporterPreferencePage"; //$NON-NLS-1$
    
    private AttributesSelectionSection attributesSelectionSection;
    private FilesSelectionSection filesSelectionSection;

    private ImportPreferencesModel model;
    
    
    public ImporterPreferencePage(){
      setPreferenceStore(RequirementsUIPreferencesPlugin.getDefault().getPreferenceStore());
      model = new ImportPreferencesModel();
    }
    
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
      filesSelectionSection = new FilesSelectionSection(model);
      filesSelectionSection.createComposite(container);
    }

    private void createAttributesSelectionSection(Composite container) {
      attributesSelectionSection = new AttributesSelectionSection(model);
      attributesSelectionSection.createComposite(container);
    }

    @Override
    public void init(IWorkbench workbench) {
    }

    @Override
    protected void performApply() {
      IPreferenceStore preferenceStore = getPreferenceStore();
      try {
        // Write property files list in preferences.
        String value = ReqImporterPreferencesUtil.serializePropertyFilesPreference(model.getPropertiesFiles());
        preferenceStore.setValue(RequirementsPreferencesConstants.REQUIREMENT_PROPERTIES_FILES, value);

        // Write selected attributes in preferences.
        for (AttributeSet category : model.getCategories()) {
          for (AttributeSet attribute : category.getChildren()) {
            String key = ReqImporterPreferencesUtil.getPreferenceKey(attribute);
            preferenceStore.setValue(key, attribute.isSelected());
          }
        }
        ((ScopedPreferenceStore)preferenceStore).save();
      } catch (IOException e) {
        Log.getDefault().logError(e);
      }
      AttributesProvider.invalidateModel();
    }

    @Override
    public boolean performOk() {
        performApply();
        return super.performOk();
    }

    @Override
    protected void performDefaults() {
      attributesSelectionSection.performDefaults(getPreferenceStore());
    }
}
