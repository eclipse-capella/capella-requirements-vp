/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
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
package org.polarsys.kitalpha.vp.requirements.ui.properties.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.MultipleSemanticField;
import org.polarsys.capella.core.ui.properties.fields.SimpleSemanticField;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.ui.properties.KitalphaRequirementsUIPropertiesPlugin;
import org.polarsys.kitalpha.vp.requirements.ui.properties.Messages;
import org.polarsys.kitalpha.vp.requirements.ui.properties.controllers.EnumAttributeDefinitionController;
import org.polarsys.kitalpha.vp.requirements.ui.properties.controllers.EnumValuesController;

public class EnumerationAttributeSection extends AbstractSection {

  protected SimpleSemanticField definitionField;
  protected MultipleSemanticField valueField;

  /**
   * @param eObject
   *          current object
   */
  public boolean select(Object eObject) {
    EObject eObjectToTest = super.selection(eObject);

    if (KitalphaRequirementsUIPropertiesPlugin.isViewpointActive(eObjectToTest)
        && eObjectToTest instanceof EnumerationValueAttribute) {
      return true;
    }
    return false;
  }

  /**
   * @param part
   * @param selection
   */
  public void setInput(IWorkbenchPart part, ISelection selection) {
    EObject newEObject = super.setInputSelection(part, selection);

    if (newEObject instanceof EnumerationValueAttribute) {
      loadData(newEObject);
    }
  }

  /**
   * @param parent
   * @param aTabbedPropertySheetPage
   */
  public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createControls(parent, aTabbedPropertySheetPage);

    boolean displayedInWizard = isDisplayedInWizard();

    definitionField = new SimpleSemanticField(getReferencesGroup(), Messages.getString("Attribute.DefinitionLabel"), //$NON-NLS-1$
        getWidgetFactory(), new EnumAttributeDefinitionController());
    definitionField.setDisplayedInWizard(displayedInWizard);

    valueField = new MultipleSemanticField(getReferencesGroup(), Messages.getString("Attribute.ValuesLabel"),
        getWidgetFactory(), new EnumValuesController());
    valueField.setDisplayedInWizard(displayedInWizard);
  }

  /**
   * @param capellaElement
   */
  public void loadData(EObject capellaElement) {
    super.loadData(capellaElement);

    definitionField.loadData(capellaElement, RequirementsPackage.eINSTANCE.getAttribute_Definition());
    valueField.loadData(capellaElement, RequirementsPackage.eINSTANCE.getEnumerationValueAttribute_Values());
  }

  /**
   * 
   */
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();

    abstractSemanticFields.add(definitionField);
    abstractSemanticFields.add(valueField);

    return abstractSemanticFields;
  }
}
