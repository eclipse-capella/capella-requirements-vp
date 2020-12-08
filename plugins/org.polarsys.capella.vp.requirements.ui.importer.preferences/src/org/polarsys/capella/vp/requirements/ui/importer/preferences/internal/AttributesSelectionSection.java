/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ui.importer.preferences.internal;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IPropertyListener;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;
import org.polarsys.capella.vp.requirements.importer.extension.ImportPreferencesModel;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes.AttributesSelectionContentProvider;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes.AttributesSelectionLabelProvider;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes.AttributesSelectionStateProvider;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.internal.messages.Messages;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.util.SWTUtil;

public class AttributesSelectionSection implements IPropertyListener {

  private CheckboxTreeViewer treeViewer;
  
  private ImportPreferencesModel model;
  
  public AttributesSelectionSection(ImportPreferencesModel rootNode) {
    this.model = rootNode;
  }
  
  public Composite createComposite(final Composite parent) {
    Group grp = SWTUtil.createGroup(parent, Messages.select_attributes_import, new GridLayout(2, false),
        new GridData(GridData.FILL, GridData.FILL, true, true));

    /** Creates the Tree */
    treeViewer = new CheckboxTreeViewer(grp);
    treeViewer.setContentProvider(new AttributesSelectionContentProvider());
    treeViewer.setLabelProvider(new AttributesSelectionLabelProvider());
    treeViewer.setCheckStateProvider(new AttributesSelectionStateProvider());
    treeViewer.addCheckStateListener(new ICheckStateListener() {
      @Override
      public void checkStateChanged(CheckStateChangedEvent event) {
        Object eventElement = event.getElement();
        if (eventElement instanceof AttributeSet) {
          AttributeSet attributeSet = (AttributeSet) eventElement;
          if (attributeSet.isMandatory() && !event.getChecked()) {
            // Reject the attempt to uncheck mandatory elements
            event.getCheckable().setChecked(attributeSet, true);
          } else { 
            updateCheckState(attributeSet, event.getChecked());
            treeViewer.refresh();
          }
        }
      }
    });

    /** layout the tree viewer below the text field */
    GridData layoutData = new GridData(GridData.FILL, GridData.FILL, true, true);
    layoutData.verticalSpan = 2;
    treeViewer.getControl().setLayoutData(layoutData);
    treeViewer.setInput(model);

    final Button selectAll = SWTUtil.createButton(grp, SWT.PUSH, Messages.select_all,
        new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    final Button deselectAll = SWTUtil.createButton(grp, SWT.PUSH, Messages.deselect_all,
        new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    SelectionListener selectionListener = new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        model.selectAll(event.getSource() == selectAll);
        treeViewer.refresh();
      }
    };
    selectAll.addSelectionListener(selectionListener);
    deselectAll.addSelectionListener(selectionListener);

    return grp;
  }

  public void performDefaults(IPreferenceStore preferenceStore) {
    // Reset model to default selection.
    model.resetToDefaultSelection();
    // Refresh tree.
    treeViewer.refresh();
  }

  /**
   * Update selection recursively
   */
  private void updateCheckState(AttributeSet attributeSet, boolean isCheckd){
    attributeSet.setSelected(isCheckd); 
    for(AttributeSet childAttr : attributeSet.getChildren()){
      updateCheckState(childAttr, isCheckd);
    }
  }
  
  @Override
  public void propertyChanged(Object source, int propId) {
    treeViewer.refresh();
  }
}
