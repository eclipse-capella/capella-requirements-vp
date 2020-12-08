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
package org.polarsys.capella.vp.requirements.ui.importer.preferences.files;

import java.io.File;
import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class PropertyFilesSelectionDialog extends ResourceDialog {
  public PropertyFilesSelectionDialog(Shell parent, String title, int style) {
    super(parent, title, style);
  }

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
   * Called to prepare the Browse File System button, this implementation adds a selection listener that creates an
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
            uris.append(URI.createFileURI(filterPath + File.separator + fileNames[i]).toString());
            uris.append("  ");
          }
          uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
        } else {
          String fileName = fileDialog.getFileName();
          if (fileName != null) {
            uriField.setText(URI.createFileURI(filterPath + File.separator + fileName).toString());
          }
        }
      }
    });
  }

  /**
   * Called to prepare the Browse Workspace button, this implementation adds a selection listener that creates an
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
          IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), null, null, true, getContextSelection(),
              Arrays.asList(filter));
          for (int i = 0, len = files.length; i < len; i++) {
            uris.append(URI.createPlatformResourceURI(files[i].getFullPath().toString(), true));
            uris.append("  ");
          }
          uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
        } else {
          IFile file = null;

          if (isSave()) {
            String path = getContextPath();
            file = WorkspaceResourceDialog.openNewFile(getShell(), null, null, path != null ? new Path(path) : null,
                Arrays.asList(filter));
          } else {
            IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), null, null, false,
                getContextSelection(), Arrays.asList(filter));
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
        return context != null && context.isPlatformResource() ? URI.createURI(".").resolve(context).path().substring(9)
            : null;
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
}