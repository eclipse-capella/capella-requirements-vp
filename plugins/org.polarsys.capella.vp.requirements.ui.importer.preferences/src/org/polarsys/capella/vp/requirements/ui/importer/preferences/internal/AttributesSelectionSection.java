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
package org.polarsys.capella.vp.requirements.ui.importer.preferences.internal;

import java.io.IOException;

import org.eclipse.jface.preference.IPreferenceStore;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;
import org.polarsys.capella.vp.requirements.importer.extension.AttributesProvider;
import org.polarsys.capella.vp.requirements.importer.preferences.ReqImporterPreferences;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.AttributeSetTreeNode;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes.SelectionCheckStateProvider;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes.SelectionContentProvider;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes.SelectionLabelProvider;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.internal.messages.Messages;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.util.SWTUtil;
import org.polarsys.kitalpha.emde.extension.utils.Log;

public class AttributesSelectionSection implements IPropertyListener {

  private CheckboxTreeViewer treeViewer;
  
  public Composite createComposite(final Composite parent) {
    Group grp = SWTUtil.createGroup(parent, Messages.select_attributes_import, new GridLayout(2, false),
        new GridData(GridData.FILL, GridData.FILL, true, true));

    /** Creates the Tree */
    treeViewer = new CheckboxTreeViewer(grp);
    treeViewer.setContentProvider(new SelectionContentProvider());
    treeViewer.setLabelProvider(new SelectionLabelProvider());
    treeViewer.setCheckStateProvider(new SelectionCheckStateProvider());
    treeViewer.setUseHashlookup(true);
    treeViewer.addCheckStateListener(new ICheckStateListener() {
      @Override
      public void checkStateChanged(CheckStateChangedEvent event) {
        Object eventElement = event.getElement();
        if (eventElement instanceof AttributeSet) {
          AttributeSet attributeSet = (AttributeSet) eventElement;
            updateCheckState(attributeSet, event.getChecked());
            treeViewer.refresh();
        }
      }
    });

    /** layout the tree viewer below the text field */
    GridData layoutData = new GridData(GridData.FILL, GridData.FILL, true, true);
    layoutData.verticalSpan = 2;
    treeViewer.getControl().setLayoutData(layoutData);
    treeViewer.setInput(AttributeSetTreeNode.createRoot("RootNode"));

    Button selectAll = SWTUtil.createButton(grp, SWT.PUSH, Messages.select_all,
        new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    selectAll.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        updateCheckState((AttributeSet)treeViewer.getInput(), true);
        treeViewer.refresh();
      }
    });

    Button deselectAll = SWTUtil.createButton(grp, SWT.PUSH, Messages.deselect_all,
        new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    deselectAll.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        updateCheckState((AttributeSet)treeViewer.getInput(), false);
        treeViewer.refresh();
      }
    });
    return grp;
  }

  public void performApply(IPreferenceStore preferenceStore) {
    try {
      for (AttributeSet category : AttributesProvider.getInstance().getCategories()) {
        for (AttributeSet attribute : category.getChildren()) {
          String key = ReqImporterPreferences.getPreferenceKey(attribute);
          preferenceStore.setValue(key, attribute.isSelected());
        }
      }
      ((ScopedPreferenceStore)preferenceStore).save();
    } catch (IOException e) {
      Log.getDefault().logError(e);
    }
  }

  public void performDefaults(IPreferenceStore preferenceStore) {
  }
  
  private void updateCheckState(AttributeSet attributeSet, boolean isCheckd){
    if(attributeSet.isMandatory()){
      attributeSet.setSelected(true);
    }else{
      attributeSet.setSelected(isCheckd);      
    }
    for(AttributeSet childAttr : attributeSet.getChildren()){
      updateCheckState(childAttr, isCheckd);
    }
  }

  @Override
  public void propertyChanged(Object source, int propId) {
    treeViewer.refresh();
  }
}
