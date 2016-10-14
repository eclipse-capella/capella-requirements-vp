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

import java.io.File;
import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.service.prefs.BackingStoreException;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;
import org.polarsys.capella.vp.requirements.importer.extension.AttributesProvider;
import org.polarsys.capella.vp.requirements.importer.extension.PropertiesFileProvider;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
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
    grp.setText("Manage files containing set of attributes");
    grp.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));
    grp.setLayout(new GridLayout(2, false));
    createFilesSelectionSection(grp);

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

  void createFilesSelectionSection(Composite container) {
    /** Creates the Tree */
    final CheckboxTreeViewer list = new CheckboxTreeViewer(container);
//    list.setContentProvider(new SelectionContentProvider());
//    list.setLabelProvider(new SelectionLabelProvider());
//    list.setCheckStateProvider(new SelectionCheckStateProvider());
//    list.setUseHashlookup(true);
//    list.addCheckStateListener(new ICheckStateListener() {
//      @Override
//      public void checkStateChanged(CheckStateChangedEvent event) {
//        //
//      }
//    });

    /** layout the tree viewer below the text field */
    GridData layoutData = new GridData(GridData.FILL, GridData.FILL, true, false);
    layoutData.verticalSpan = 2;
    list.getControl().setLayoutData(layoutData);
//    list.setInput("root");

    Button addFile = new Button(container, SWT.PUSH);
    addFile.setText("Add file"); //$NON-NLS-1$
    addFile.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    addFile.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        ResourceDialog fileDialog = new ResourceDialog(getShell(), "", SWT.SINGLE) {
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
           * Called to prepare the Browse File System button, this implementation adds a selection listener
           * that creates an appropriate {@link FileDialog}.
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
                    uris.append(URI.createFileURI(filterPath + File.separator + fileNames[i]).toString());
                    uris.append("  ");
                  }             
                  uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
                }
                else {
                  String fileName = fileDialog.getFileName();
                  if (fileName != null) {
                    uriField.setText(URI.createFileURI(filterPath + File.separator + fileName).toString());
                  }
                }
              }
            });
          }

          /**
           * Called to prepare the Browse Workspace button, this implementation adds a selection listener
           * that creates an appropriate {@link WorkspaceResourceDialog}.  
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
                  IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), null, null, true, getContextSelection(), Arrays.asList(filter));
                  for (int i = 0, len = files.length; i < len; i++) {
                    uris.append(URI.createPlatformResourceURI(files[i].getFullPath().toString(), true));
                    uris.append("  ");
                  }
                  uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
                }
                else {
                  IFile file = null;

                  if (isSave()) {
                    String path = getContextPath();
                    file = WorkspaceResourceDialog.openNewFile(getShell(), null, null, path != null ? new Path(path) : null, Arrays.asList(filter));
                  }
                  else {
                    IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), null, null, false, getContextSelection(), Arrays.asList(filter));
                    if (files.length != 0) {
                      file = files[0];
                    }
                  }
                   
                  if (file != null) {
                    uriField.setText(URI.createPlatformResourceURI(file.getFullPath().toString(), true).toString());
                  }
                }
              }

              private String getContextPath() {
                return context != null && context.isPlatformResource() ? URI.createURI(".").resolve(context).path().substring(9) : null;
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
        if (fileDialog.open() == SWT.OK) {
          for (URI uri : fileDialog.getURIs()) {
            PropertiesFileProvider.getInstance().addContributor(uri);
          }
        }
      }
    });

    Button removeFile = new Button(container, SWT.PUSH);
    removeFile.setText("Remove file"); //$NON-NLS-1$
    removeFile.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    removeFile.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        //
      }
    });
  }

  void createAttributesSelectionSection(Composite container) {
    /** Creates the Tree */
    final CheckboxTreeViewer tree = new CheckboxTreeViewer(container);
    tree.setContentProvider(new SelectionContentProvider());
    tree.setLabelProvider(new SelectionLabelProvider());
    tree.setCheckStateProvider(new SelectionCheckStateProvider());
    tree.setUseHashlookup(true);
    tree.addCheckStateListener(new ICheckStateListener() {
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
    tree.getControl().setLayoutData(layoutData);
    tree.setInput("root");

    Button selectAll = new Button(container, SWT.PUSH);
    selectAll.setText("Select All"); //$NON-NLS-1$
    selectAll.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    selectAll.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        for (Object obj : tree.getCheckedElements())
          tree.setChecked(obj, false);
        for (Object obj : tree.getGrayedElements()) {
          tree.setGrayChecked(obj, false);
        }
        tree.setAllChecked(true);
      }
    });

    Button deselectAll = new Button(container, SWT.PUSH);
    deselectAll.setText("Deselect All"); //$NON-NLS-1$
    deselectAll.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false));
    deselectAll.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent event) {
        tree.setAllChecked(false);
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

      String value = ICommonConstants.EMPTY_STRING;
      for (URI uri : PropertiesFileProvider.getInstance().getPropertiesFiles()) {
        value += uri.toFileString() + ";";
      }
      instanceScope.put(RequirementsPreferencesConstants.REQUIREMENT_PROPERTIES_FILES, value);

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
