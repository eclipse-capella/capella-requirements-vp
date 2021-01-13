/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ImageImportingDialog extends TitleAreaDialog {

  private Text absPathText;
  private Button absPathChoosingButton;
  private Text relativePathText;
  private Button relativePathChoosingButton;
  private Button embedImageButton;
  private ImageImporter imageImporter;
  private IProject currentProject;

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

    setUpAbsPathUI(container, importingModesComposite);

    setUpRelPathUI(container, importingModesComposite);

    setUpEmbeddedModeUI(importingModesComposite);

    return container;
  }

  protected void setUpEmbeddedModeUI(Composite importingModesComposite) {
    embedImageButton = new Button(importingModesComposite, SWT.RADIO);
    embedImageButton.setText("Encode image in Base64 and embed it in the text");
    embedImageButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        embedImageButton.setSelection(true);
        setEnableAbsImagePath(false);
        setEnableRelativeImagePath(false);
        enableFinishForEmbeddedImg();
      }

      protected void enableFinishForEmbeddedImg() {
        setMessage(Messages.ImageImportingDialog_DefaultMessage + Messages.ImageImportingDialog_EmbeddedMessage);
        getButton(IDialogConstants.OK_ID).setEnabled(true);
        imageImporter.setImgImportStrategy(ImageImportStrategy.EMBEDDED);
      }
    });
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(embedImageButton);
  }

  protected void setUpRelPathUI(Composite container, Composite importingModesComposite) {
    relativePathChoosingButton = new Button(importingModesComposite, SWT.RADIO);
    relativePathChoosingButton.setText("Choose a path to image folder that is relative to the current project:");
    relativePathChoosingButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        setEnableRelativeImagePath(true);
        setEnableAbsImagePath(false);
        embedImageButton.setSelection(false);
        String currentProjectLocation = currentProject.getLocation().toString();
        Path currentProjectPath = Paths.get(currentProjectLocation);
        if (!currentProjectPath.resolve(relativePathText.getText()).toFile().exists()) {
          disableFinish();
        } else {
          enableFinishForRelPath();
        }
      }
    });
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(relativePathChoosingButton);

    relativePathText = new Text(importingModesComposite, SWT.SINGLE | SWT.BORDER);
    relativePathText.addModifyListener(e -> {
      String currentProjectLocation = currentProject.getLocation().toString();
      Path currentProjectPath = Paths.get(currentProjectLocation);
      if (!currentProjectPath.resolve(relativePathText.getText()).toFile().exists()) {
        setErrorMessage("The relative path does not point to a valid folder.");
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
        dialog.setFilterPath(currentProjectLocation);
        String result = dialog.open();
        if (result != null) {
          Path resultPath = Paths.get(result);
          Path currentProjectPath = Paths.get(currentProjectLocation);
          if (resultPath.startsWith(currentProjectPath)) {
            Path relativizedPath = currentProjectPath.relativize(resultPath);
            relativePathText.setText(relativizedPath.toString());
          } else {
            relativePathText.setText("");
          }
        }
      }
    });
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(relativePathBrowseButton);
    setEnableRelativeImagePath(false);
  }

  protected void setUpAbsPathUI(Composite container, Composite importingModesComposite) {
    absPathChoosingButton = new Button(importingModesComposite, SWT.RADIO);
    absPathChoosingButton.setText("Choose an absolute path to image folder:");
    absPathChoosingButton.setSelection(true);
    absPathChoosingButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        setEnableAbsImagePath(true);
        setEnableRelativeImagePath(false);
        embedImageButton.setSelection(false);
        if (Paths.get(absPathText.getText()).toFile().exists() && Paths.get(absPathText.getText()).isAbsolute()) {
          enableFinishForAbsPath();
        } else {
          setMessage(Messages.ImageImportingDialog_DefaultMessage + Messages.ImageImportingDialog_AbsPathMessage);
          disableFinish();
        }
      }
    });
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(absPathChoosingButton);

    absPathText = new Text(importingModesComposite, SWT.SINGLE | SWT.BORDER);
    absPathText.addModifyListener(e -> {
      if (Paths.get(absPathText.getText()).toFile().exists() && Paths.get(absPathText.getText()).isAbsolute()) {
        enableFinishForAbsPath();
      } else {
        setErrorMessage("The absolute path does not point to a valid folder.");
        disableFinish();
      }
    });
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(absPathText);

    Button absPathBrowseButton = new Button(importingModesComposite, SWT.PUSH);
    absPathBrowseButton.setText("Browse...");
    absPathBrowseButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        DirectoryDialog dialog = new DirectoryDialog(container.getShell());
        String result = dialog.open();
        if (result != null) {
          absPathText.setText(result);
        }
      }
    });
    GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).applyTo(absPathBrowseButton);
  }

  protected void enableFinishForAbsPath() {
    setMessage(Messages.ImageImportingDialog_DefaultMessage + Messages.ImageImportingDialog_AbsPathMessage);
    setErrorMessage(null);
    getButton(IDialogConstants.OK_ID).setEnabled(true);
    imageImporter.setImgImportStrategy(ImageImportStrategy.ABS_PATH);
    imageImporter.setAbsPath(absPathText.getText());
  }

  protected void enableFinishForRelPath() {
    setMessage(Messages.ImageImportingDialog_DefaultMessage + Messages.ImageImportingDialog_RelPathMessage);
    setErrorMessage(null);
    getButton(IDialogConstants.OK_ID).setEnabled(true);
    imageImporter.setImgImportStrategy(ImageImportStrategy.REL_PATH);
    imageImporter.setRelPath(relativePathText.getText());
  }

  protected void disableFinish() {
    getButton(IDialogConstants.OK_ID).setEnabled(false);
    imageImporter.setImgImportStrategy(null);
    imageImporter.setAbsPath(null);
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  @Override
  protected Point getInitialSize() {
    return new Point(1000, 320);
  }

  @Override
  public void create() {
    super.create();
    setTitle("Image importing options");
    setMessage(Messages.ImageImportingDialog_DefaultMessage + Messages.ImageImportingDialog_AbsPathMessage,
        IMessageProvider.NONE);
    getButton(IDialogConstants.OK_ID).setEnabled(false);
  }

  private void setEnableAbsImagePath(boolean enable) {
    absPathChoosingButton.setSelection(enable);
    absPathText.setEnabled(enable);
  }

  private void setEnableRelativeImagePath(boolean enable) {
    relativePathChoosingButton.setSelection(enable);
    relativePathText.setEnabled(enable);
  }

}
