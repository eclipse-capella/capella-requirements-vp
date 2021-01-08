/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
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
package org.polarsys.kitalpha.vp.requirements.ui.properties.fields;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.helpers.LockHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.ui.properties.Messages;

/**
 * @author Joao Barata
 */
public class BasicReqIFElementGroup extends AbstractSemanticField {

  protected Text longNameField;
  protected Text nameField;
  protected Text chapternameField;
  protected Text prefixField;

  @Deprecated
  public BasicReqIFElementGroup(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory, boolean onlyName) {
    this(parent, widgetFactory, !onlyName, !onlyName);
  }

  /**
   * @param parent
   * @param widgetFactory
   */
  public BasicReqIFElementGroup(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory,
      boolean sharedAttributes, boolean requirementAttributes) {
    super(widgetFactory);

    Group textGroup = widgetFactory.createGroup(parent, ICommonConstants.EMPTY_STRING);
    textGroup.setLayout(new GridLayout(2, false));
    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    gd.horizontalSpan = 2;
    textGroup.setLayoutData(gd);

    longNameField = createTextField(textGroup, Messages.getString("ReqIFElement.LongNameLabel")); //$NON-NLS-1$

    if (sharedAttributes) {
      nameField = createTextField(textGroup, Messages.getString("ReqIFElement.NameLabel")); //$NON-NLS-1$
    }
    if (requirementAttributes) {
      chapternameField = createTextField(textGroup, Messages.getString("ReqIFElement.ChapterNameLabel")); //$NON-NLS-1$
    }
    if (sharedAttributes) {
      prefixField = createTextField(textGroup, Messages.getString("ReqIFElement.PrefixLabel")); //$NON-NLS-1$
    }
  }

  /**
   * @param textGroup
   * @param textLabel
   */
  private Text createTextField(Group textGroup, String textLabel) {
    widgetFactory.createCLabel(textGroup, textLabel);

    Text field = widgetFactory.createText(textGroup, ICommonConstants.EMPTY_STRING);
    field.addFocusListener(this);
    field.addKeyListener(this);
    field.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

    return field;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void loadData(EObject semanticElement) {
    loadData(semanticElement, null);

    if (null != semanticElement) {
      if (null != longNameField) {
        setTextValue(longNameField, semanticElement, RequirementsPackage.eINSTANCE.getReqIFElement_ReqIFLongName());
      }
      if (null != nameField) {
        setTextValue(nameField, semanticElement, RequirementsPackage.eINSTANCE.getSharedDirectAttributes_ReqIFName());
      }
      if (null != chapternameField) {
        setTextValue(chapternameField, semanticElement,
            RequirementsPackage.eINSTANCE.getRequirement_ReqIFChapterName());
      }
      if (null != prefixField) {
        setTextValue(prefixField, semanticElement,
            RequirementsPackage.eINSTANCE.getSharedDirectAttributes_ReqIFPrefix());
      }
    }
  }

  /**
   * @param field
   *          text field to be filled
   */
  @Override
  protected void fillTextField(Text field) {
    if (field.equals(longNameField)) {
      setDataValue(semanticElement, RequirementsPackage.eINSTANCE.getReqIFElement_ReqIFLongName(),
          longNameField.getText());
    } else if (field.equals(nameField)) {
      setDataValue(semanticElement, RequirementsPackage.eINSTANCE.getSharedDirectAttributes_ReqIFName(),
          nameField.getText());
    } else if (field.equals(chapternameField)) {
      setDataValue(semanticElement, RequirementsPackage.eINSTANCE.getRequirement_ReqIFChapterName(),
          chapternameField.getText());
    } else if (field.equals(prefixField)) {
      setDataValue(semanticElement, RequirementsPackage.eINSTANCE.getSharedDirectAttributes_ReqIFPrefix(),
          prefixField.getText());
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setEnabled(boolean enabled) {
    LockHelper.getInstance().enable(longNameField, enabled);
    LockHelper.getInstance().enable(nameField, enabled);
    LockHelper.getInstance().enable(chapternameField, enabled);
    LockHelper.getInstance().enable(prefixField, enabled);
  }
}
