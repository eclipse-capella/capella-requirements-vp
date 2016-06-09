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
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;
import org.polarsys.capella.vp.requirements.importer.extension.AttributesProvider;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesPlugin;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes.SelectionCheckStateProvider;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes.SelectionContentProvider;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes.SelectionLabelProvider;
import org.polarsys.kitalpha.emde.extension.utils.Log;

/**
 * @author Joao Barata
 */
public class ImporterPreferencePage  extends PreferencePage implements IWorkbenchPreferencePage {
  /**
   * 
   */
  public static final String PROPERTY_PAGE_ID = "org.polarsys.capella.vp.requirements.importer.preferences.ui.ImporterPreferencePage"; //$NON-NLS-1$

  @Override
  protected Control createContents(Composite parent) {
    Composite result = new Composite(parent, SWT.NONE);

    GridLayout layout = new GridLayout();
    result.setLayout(layout);

    Group grp = new Group(result, SWT.NONE);
    grp.setText("Select the scope of the importer");
    grp.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
    grp.setLayout(new GridLayout());
    createScopeSelectionSection(grp);

    grp = new Group(result, SWT.NONE);
    grp.setText("Select the attributes to be imported");
    grp.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
    grp.setLayout(new GridLayout(2, false));
    createAttributesSelectionSection(grp);

    applyDialogFont(result);

    return result;
  }

  void createScopeSelectionSection(Composite container) {
    Button btn = new Button(container, SWT.CHECK);
    btn.setText("Import internal links"); //$NON-NLS-1$
    btn.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, true));
    btn = new Button(container, SWT.CHECK);
    btn.setText("Import type definitions"); //$NON-NLS-1$
    btn.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, true));
  }

  void createAttributesSelectionSection(Composite container) {
    /** Creates the Tree */
    final CheckboxTreeViewer _tree = new CheckboxTreeViewer(container);
    _tree.setContentProvider(new SelectionContentProvider());
    _tree.setLabelProvider(new SelectionLabelProvider());
    _tree.setCheckStateProvider(new SelectionCheckStateProvider());
    _tree.setUseHashlookup(true);
    _tree.addCheckStateListener(new ICheckStateListener() {
      @Override
      public void checkStateChanged(CheckStateChangedEvent event) {
        Object eventElement = event.getElement();
        if (eventElement instanceof AttributeSet) {
          ((AttributeSet) eventElement).setSelected(event.getChecked());
        }
      }
    });

    /** layout the tree viewer below the text field */
    GridData layoutData = new GridData(GridData.FILL, GridData.FILL, true, true);
    layoutData.verticalSpan = 2;
    _tree.getControl().setLayoutData(layoutData);
    _tree.setInput("root");

    Button _selectAll = new Button(container, SWT.PUSH);
    _selectAll.setText("Select All"); //$NON-NLS-1$
    _selectAll.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    _selectAll.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        for (Object obj : _tree.getCheckedElements())
          _tree.setChecked(obj, false);
        for (Object obj : _tree.getGrayedElements()) {
          _tree.setGrayChecked(obj, false);
        }
        _tree.setAllChecked(true);
      }
    });

    Button _deselectAll = new Button(container, SWT.PUSH);
    _deselectAll.setText("Deselect All"); //$NON-NLS-1$
    _deselectAll.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    _deselectAll.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        _tree.setAllChecked(false);
      }
    });
  }

  @Override
  public void init(IWorkbench workbench) {
  }

  @Override
  protected void performApply() {
    try {
      IEclipsePreferences instanceScope = InstanceScope.INSTANCE.getNode(RequirementsPreferencesPlugin.PLUGIN_ID);
      for (AttributeSet category : AttributesProvider.getInstance().getAttributes()) {
        for (AttributeSet attribute : category.getChildren()) {
          String key = category.getId() + "." + attribute.getName();
          instanceScope.putBoolean(key, attribute.isSelected());
        }
      }
      instanceScope.flush();
    } catch (BackingStoreException e) {
      Log.getDefault().logError(e);
    }
  }

  @Override
  public boolean performOk() {
    performApply();
    return super.performOk();
  }

  @Override
  protected void performDefaults() {
  }

  @Override
  public boolean performCancel() {
    performDefaults();
    return super.performCancel();
  }
}
