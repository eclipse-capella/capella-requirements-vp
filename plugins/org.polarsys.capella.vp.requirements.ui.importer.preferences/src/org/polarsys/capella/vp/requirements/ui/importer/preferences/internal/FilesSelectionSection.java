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

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.vp.requirements.importer.extension.PropertiesFileAttributesProvider;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesInitializer;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes.SelectionContentProvider;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes.SelectionLabelProvider;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.internal.messages.Messages;
import org.polarsys.capella.vp.requirements.ui.importer.preferences.util.SWTUtil;
import org.polarsys.kitalpha.emde.extension.utils.Log;

public class FilesSelectionSection {

  private ListViewer listViewer;
  private ListenerList listeners = new ListenerList();
  
  public Composite createComposite(final Composite parent) {
    Group grp = SWTUtil.createGroup(parent, Messages.manage_files_containing_attributes, new GridLayout(2, false), new GridData(GridData.FILL, GridData.FILL, true, false));
    
    /** Creates the list */
    listViewer = new ListViewer(grp);
    listViewer.setContentProvider(new SelectionContentProvider());
    listViewer.setLabelProvider(new SelectionLabelProvider());
    listViewer.setInput(PropertiesFileAttributesProvider.getInstance());

    /** layout the tree viewer below the text field */
    GridData layoutData = new GridData(GridData.FILL, GridData.FILL, true, false);
    layoutData.verticalSpan = 2;
    listViewer.getControl().setLayoutData(layoutData);

    Button addFile = SWTUtil.createButton(grp, SWT.PUSH, Messages.add_file, new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    addFile.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        ResourceDialog fileDialog = new ResourceDialog(parent.getShell(), "", SWT.SINGLE) {
          @Override
          protected boolean processResources() {
            for (URI uri : getURIs()) {
              if (!uri.fileExtension().equals("properties")) {
                return false;
              }
            }
            return true;
          }

          /**
           * Called to prepare the Browse File System button, this
           * implementation adds a selection listener that creates an
           * appropriate {@link FileDialog}.
           */
          protected void prepareBrowseFileSystemButton(Button browseFileSystemButton) {
            browseFileSystemButton.addSelectionListener(new SelectionAdapter() {
              @Override
              public void widgetSelected(SelectionEvent event) {
                FileDialog fileDialog = new FileDialog(getShell(), style);
                fileDialog.setFilterExtensions(new String[] { "*.properties", "*.*" });
                fileDialog.setFilterNames(new String[] { "Properties files", "All files" });
                fileDialog.open();

                String filterPath = fileDialog.getFilterPath();
                if (isMulti()) {
                  String[] fileNames = fileDialog.getFileNames();
                  StringBuffer uris = new StringBuffer();

                  for (int i = 0, len = fileNames.length; i < len; i++) {
                    uris.append(URI.createFileURI(filterPath + File.separator + fileNames[i])
                        .toString());
                    uris.append("  ");
                  }
                  uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
                } else {
                  String fileName = fileDialog.getFileName();
                  if (fileName != null) {
                    uriField.setText(
                        URI.createFileURI(filterPath + File.separator + fileName).toString());
                  }
                }
              }
            });
          }

          /**
           * Called to prepare the Browse Workspace button, this
           * implementation adds a selection listener that creates an
           * appropriate {@link WorkspaceResourceDialog}.
           */
          protected void prepareBrowseWorkspaceButton(Button browseWorkspaceButton) {
            browseWorkspaceButton.addSelectionListener(new SelectionAdapter() {
              @Override
              public void widgetSelected(SelectionEvent event) {
                ViewerFilter filter = new ViewerFilter() {
                  @Override
                  public boolean select(Viewer viewer, Object parentElement, Object element) {
                    if (element instanceof IFile) {
                      if (!"properties".equals(((IFile) element).getFileExtension())) {
                        return false;
                      }
                    }
                    return true;
                  }
                };
                if (isMulti()) {
                  StringBuffer uris = new StringBuffer();
                  IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), null, null,
                      true, getContextSelection(), Arrays.asList(filter));
                  for (int i = 0, len = files.length; i < len; i++) {
                    uris.append(
                        URI.createPlatformResourceURI(files[i].getFullPath().toString(), true));
                    uris.append("  ");
                  }
                  uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
                } else {
                  IFile file = null;

                  if (isSave()) {
                    String path = getContextPath();
                    file = WorkspaceResourceDialog.openNewFile(getShell(), null, null,
                        path != null ? new Path(path) : null, Arrays.asList(filter));
                  } else {
                    IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), null,
                        null, false, getContextSelection(), Arrays.asList(filter));
                    if (files.length != 0) {
                      file = files[0];
                    }
                  }

                  if (file != null) {
                    uriField.setText(
                        URI.createPlatformResourceURI(file.getFullPath().toString(), true)
                            .toString());
                  }
                }
              }

              private String getContextPath() {
                return context != null && context.isPlatformResource()
                    ? URI.createURI(".").resolve(context).path().substring(9) : null;
              }

              private Object[] getContextSelection() {
                String path = getContextPath();
                if (path != null) {
                  IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
                  IResource resource = root.findMember(path);
                  if (resource != null && resource.isAccessible()) {
                    return new Object[] { resource };
                  }
                }
                return null;
              }
            });
          }
        };
        if (fileDialog.open() == Window.OK) {
          for (URI uri : fileDialog.getURIs()) {
            PropertiesFileAttributesProvider.getInstance().addContributor(uri);
          }
          // Keep the default store updated
          new RequirementsPreferencesInitializer().initializeDefaultPreferences(PropertiesFileAttributesProvider.getInstance().getPropertiesFileCategories());
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
        if(selection instanceof IStructuredSelection){
          Iterator<?> iterator  = ((IStructuredSelection)selection).iterator();
          boolean refreshAndFireChange = iterator.hasNext();
          while (iterator.hasNext()) {
            Object selectedObject = iterator.next();
            if(selectedObject instanceof URI){
              PropertiesFileAttributesProvider.getInstance().removeContributor((URI)selectedObject);
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
  
  public void performApply(IPreferenceStore preferenceStore){
    try {
      String value = ICommonConstants.EMPTY_STRING;
      for (URI uri : PropertiesFileAttributesProvider.getInstance().getPropertiesFiles()) {
        value += uri.toFileString() + ";";
      }
      preferenceStore.setValue(RequirementsPreferencesConstants.REQUIREMENT_PROPERTIES_FILES, value);
      ((ScopedPreferenceStore)preferenceStore).save();
    } catch (IOException e) {
      Log.getDefault().logError(e);
    }
  
  }
  
  public void performDefaults(IPreferenceStore preferenceStore) {
  }
}
