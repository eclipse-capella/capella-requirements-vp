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

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IPropertyListener;
import org.polarsys.capella.vp.requirements.importer.extension.ImportPreferencesModel;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.files.FileLabelProvider;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.files.PropertyFilesSelectionDialog;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.internal.messages.Messages;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.util.SWTUtil;

public class FilesSelectionSection {
  private ListenerList listeners = new ListenerList();
  
  // Data
  private ImportPreferencesModel model;
  
  private TableViewer listViewer;
  
  public FilesSelectionSection(ImportPreferencesModel model) {
    this.model = model;
  }
  
  public Composite createComposite(final Composite parent) {
    Group grp = SWTUtil.createGroup(parent, Messages.manage_files_containing_attributes, new GridLayout(2, false), new GridData(GridData.FILL, GridData.FILL, true, false));
    
    /** Creates the list */
    listViewer = new TableViewer(grp);
    listViewer.setContentProvider(new ArrayContentProvider());
    listViewer.setLabelProvider(new FileLabelProvider());
    listViewer.setInput(model.getPropertiesFiles());

    /** layout the tree viewer below the text field */
    GridData layoutData = new GridData(GridData.FILL, GridData.FILL, true, false);
    layoutData.verticalSpan = 2;
    listViewer.getControl().setLayoutData(layoutData);

    Button addFile = SWTUtil.createButton(grp, SWT.PUSH, Messages.add_file, new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    addFile.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        // Open a file selection dialog
        ResourceDialog fileDialog = new PropertyFilesSelectionDialog(parent.getShell(), "", SWT.SINGLE);
        if (fileDialog.open() == Window.OK) {
          model.addPropertyFiles(fileDialog.getURIs());
          listViewer.refresh();
          fireChange();
        }
      }
    });

    Button removeFile = SWTUtil.createButton(grp, SWT.PUSH, Messages.remove_file, new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    removeFile.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        ISelection selection = listViewer.getSelection();
        if(selection instanceof IStructuredSelection && !selection.isEmpty()) {
          boolean refreshAndFireChange = false;
          Object[] selectedElements = ((IStructuredSelection)selection).toArray();
          for (Object selectedElement : selectedElements) {
            if(selectedElement instanceof URI){
              model.removePropertyFile((URI) selectedElement);
              refreshAndFireChange = true;
            }
          }
          if(refreshAndFireChange){
            listViewer.refresh();
            fireChange();
          }
        }
      }
    });
    return grp;
  }
  
  public void addListener(IPropertyListener l) {
    listeners.add(l);
  } 
  
  public void removeListener(IPropertyListener l) {
    listeners.remove(l);
  } 
  
  private void fireChange() {
    Object[] array = listeners.getListeners();
    for (int i = 0; i < array.length; i++) {
      IPropertyListener element = (IPropertyListener)array[i];
      element.propertyChanged(this, 0);
    }
  }
}
