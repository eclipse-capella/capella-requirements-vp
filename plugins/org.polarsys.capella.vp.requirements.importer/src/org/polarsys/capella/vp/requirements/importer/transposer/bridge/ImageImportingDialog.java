/*******************************************************************************
 * Copyright (c) 2020, 2022 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ImageImportingDialog extends TitleAreaDialog {

  private Text relativePathText;
  private ImageImporter imageImporter;
  private IProject currentProject;
  private String separator = System.getProperty("file.separator");

  protected ImageImportingDialog(Shell parentShell, ImageImporter imageImporter, IProject currentProject) {
    super(parentShell);
    this.imageImporter = imageImporter;
    this.currentProject = currentProject;
  }

  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);

    GridDataFactory.fillDefaults().grab(true, false).applyTo(container);
    GridLayoutFactory.fillDefaults().margins(5, 5).applyTo(container);

    Composite importingModesComposite = new Composite(container, SWT.NONE);
    GridDataFactory.fillDefaults().grab(true, false).applyTo(importingModesComposite);
    GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).margins(0, 0).applyTo(importingModesComposite);

    setUpRelPathUI(container, importingModesComposite);

    return container;
  }

  protected void setUpRelPathUI(Composite container, Composite importingModesComposite) {
    Label relativePathTextChoice = new Label(importingModesComposite, SWT.SINGLE);
    relativePathTextChoice.setText(Messages.ImageImportingDialog_RelativePathLabel);
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(relativePathTextChoice);

    relativePathText = new Text(importingModesComposite, SWT.SINGLE | SWT.BORDER);
    relativePathText.setText(currentProject.getName() + separator);
    relativePathText.addModifyListener(e -> {
      String currentProjectParentLocation = currentProject.getLocation().removeLastSegments(1).toString();
      Path currentProjectParentPath = Paths.get(currentProjectParentLocation);
      if (relativePathText.getText() == "" || !currentProjectParentPath.resolve(relativePathText.getText()).toFile().exists()) {
        setErrorMessage(Messages.ImageImportingDialog_RelativePathErrorMessage);
        disableFinish();
      } else {
        enableFinishForRelPath();
      }
    });
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(relativePathText);

    Button relativePathBrowseButton = new Button(importingModesComposite, SWT.PUSH);
    relativePathBrowseButton.setText("Browse...");
    relativePathBrowseButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        DirectoryDialog dialog = new DirectoryDialog(container.getShell());
        String currentProjectLocation = currentProject.getLocation().toString();
        String currentProjectParentLocation = currentProject.getLocation().removeLastSegments(1).toString();
        dialog.setFilterPath(currentProjectLocation);
        String result = dialog.open();
        if (result != null) {
          URI resultPath = Paths.get(result).toUri();
          URI currentProjectParentPath = Paths.get(currentProjectParentLocation).toUri();
          if (resultPath.toString().startsWith(currentProjectParentPath.toString())) {
            URI relativizedPath = currentProjectParentPath.relativize(resultPath);
            relativePathText.setText(relativizedPath.getPath());
          } else {
            relativePathText.setText("");
          }
        }
      }
    });
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(relativePathBrowseButton);
    setEnableRelativeImagePath(true);
  }

  protected void enableFinishForRelPath() {
    setErrorMessage(null);
    getButton(IDialogConstants.OK_ID).setEnabled(true);
    String path = relativePathText.getText();
    if (!path.endsWith("/") && !path.endsWith("\\")) {
        path = path + separator;
    }
    imageImporter.setRelPath(path);
  }

  protected void disableFinish() {
    getButton(IDialogConstants.OK_ID).setEnabled(false);
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  @Override
  protected Point getInitialSize() {
    return new Point(700, 200);
  }

  @Override
  public void create() {
    super.create();
    setTitle("Image importing parameters");
    setMessage(Messages.ImageImportingDialog_DefaultMessage + Messages.ImageImportingDialog_RelPathMessage,
            IMessageProvider.NONE);
    // Default path will be the current project so it should be active
    getButton(IDialogConstants.OK_ID).setEnabled(true);
  }

  private void setEnableRelativeImagePath(boolean enable) {
    relativePathText.setEnabled(enable);
  }

}
