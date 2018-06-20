/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.commands;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * The dialog for configuring AQL expressions of Requirements VP
 * @author S0070513
 *
 */
public class ReqVPConfigureDialog extends TitleAreaDialog {

  private Text txtReqLabelExpression;
  private Text txtReqLabelMaxLength;

  private Text txtReqContentExpression;
  private Text txtReqContentMaxLength;

  private String labelExpression;
  private String labelMaxLength;
  private String contentExpression;
  private String contentMaxLength;
  
  public ReqVPConfigureDialog(Shell parentShell, String labelExpression, String contentExpression, String labelMaxLength, String contentMaxLength) {
    super(parentShell);
    this.labelExpression = (labelExpression == null) ? Messages.DefaultValueOfLabelExpression : labelExpression;
    this.contentExpression = (contentExpression == null) ? Messages.DefaultValueOfContentExpression : contentExpression;
    this.labelMaxLength = (labelMaxLength == null) ? Messages.DefaultValueOfLabelMaxLength : labelMaxLength;
    this.contentMaxLength = (contentMaxLength == null) ? Messages.DefaultValueOfContentMaxLength : contentMaxLength;
    
    setHelpAvailable(false);
    setDialogHelpAvailable(false);
  }

  @Override
  public void create() {
    super.create();
    setTitle(Messages.ReqVPConfigureDialog_Title);
    setMessage(Messages.ReqVPConfigureDialog_Message,
        IMessageProvider.INFORMATION);
  }

  @Override
  protected Control createDialogArea(Composite parent) {
    Composite area = (Composite) super.createDialogArea(parent);
    Composite container = new Composite(area, SWT.NONE);
    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    GridLayout layout = new GridLayout(2, false);
    container.setLayout(layout);

    createAreaForLabelExpression(container);
    createAreaForContentExpression(container);

    return area;
  }

  private void createAreaForLabelExpression(Composite container) {
    Group group = createGroup(container, Messages.GROUP_TITLE_FOR_LABEL_AREA);
    
    createLabelInGroup(group, Messages.EXPRESSION_LABEL_TEXT);
    txtReqLabelExpression = createMultiLineTextInGroup(group, labelExpression);
    
    createLabelInGroup(group, Messages.LENGTH_LABEL_TEXT);
    txtReqLabelMaxLength = createSingleLineTextInGroup(group, labelMaxLength);
  }

  private void createAreaForContentExpression(Composite container) {
    Group group = createGroup(container, Messages.GROUP_TITLE_FOR_CONTENT_AREA);
    
    createLabelInGroup(group, Messages.EXPRESSION_LABEL_TEXT);
    txtReqContentExpression = createMultiLineTextInGroup(group, contentExpression);

    createLabelInGroup(group, Messages.LENGTH_LABEL_TEXT);
    txtReqContentMaxLength = createSingleLineTextInGroup(group, contentMaxLength);
  }
  
  private Text createMultiLineTextInGroup(Group group, String defaultText) {
    Text text = new Text(group, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
    text.setText(defaultText);
    
    GridData txtExpressionGridData = new GridData(GridData.FILL_BOTH);
    txtExpressionGridData.grabExcessHorizontalSpace = true;
    txtExpressionGridData.horizontalAlignment = GridData.FILL;
    txtExpressionGridData.heightHint = 5 * text.getLineHeight();
    txtExpressionGridData.widthHint = 400;
    text.setLayoutData(txtExpressionGridData);
    
    return text;
  }
  
  private Text createSingleLineTextInGroup(Group group, String defaultText) {
    Text text = new Text(group, SWT.BORDER);
    text.setText(defaultText);
    
    GridData txtMaxLengthGridData = new GridData();
    txtMaxLengthGridData.grabExcessHorizontalSpace = true;
    txtMaxLengthGridData.horizontalAlignment = GridData.FILL;
    text.setLayoutData(txtMaxLengthGridData);
    
    return text;
  }
  
  private Label createLabelInGroup(Group group, String labelText) {
    Label label = new Label(group, SWT.NONE);
    label.setText(labelText);
    return label;
  }
  
  private Group createGroup(Composite container, String groupTitle) {
    Group group = new Group(container, SWT.NONE);
    group.setText(groupTitle);

    GridData groupGridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    groupGridData.horizontalSpan = 2;
    group.setLayoutData(groupGridData);
    group.setLayout(new GridLayout(2, false));
    
    return group;
  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  private void saveInput() {
    labelExpression = txtReqLabelExpression.getText();
    contentExpression = txtReqContentExpression.getText();
    try {
      labelMaxLength = String.valueOf(Integer.parseInt(txtReqLabelMaxLength.getText()));
    } catch (NumberFormatException e) {
      labelMaxLength = "";
    }
    try {
      contentMaxLength = String.valueOf(Integer.parseInt(txtReqContentMaxLength.getText()));
    } catch (NumberFormatException e) {
      contentMaxLength = "";
    }
  }

  @Override
  protected void okPressed() {
    saveInput();
    super.okPressed();
  }

  public String getLabelExpression() {
    return labelExpression;
  }

  public String getContentExpression() {
    return contentExpression;
  }

  public String getLabelMaxLength() {
    return labelMaxLength;
  }

  public String getContentMaxLength() {
    return contentMaxLength;
  }
}
