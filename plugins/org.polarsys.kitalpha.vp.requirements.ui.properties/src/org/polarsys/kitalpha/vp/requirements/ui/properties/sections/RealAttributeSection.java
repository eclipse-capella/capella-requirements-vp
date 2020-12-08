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
import org.polarsys.capella.core.ui.properties.fields.RealValueGroup;
import org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.ui.properties.Messages;

/**
 * @author Joao Barata
 */
public class RealAttributeSection extends AttributeSection {

  protected RealValueGroup valueField;

  /**
   * @param eObject
   *          current object
   */
  public boolean select(Object eObject) {
    EObject eObjectToTest = super.selection(eObject);

    if (super.select(eObject) && eObjectToTest instanceof RealValueAttribute) {
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

    if (newEObject instanceof RealValueAttribute) {
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

    valueField = new RealValueGroup(getReferencesGroup(),
        Messages.getString("Attribute.ValueLabel"), getWidgetFactory(), true, true); //$NON-NLS-1$
    valueField.setDisplayedInWizard(displayedInWizard);
  }

  /**
   * @param capellaElement
   */
  public void loadData(EObject capellaElement) {
    super.loadData(capellaElement);

    valueField.loadData(capellaElement, RequirementsPackage.eINSTANCE.getRealValueAttribute_Value());
  }

  /**
	 * 
   */
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();

    abstractSemanticFields.add(valueField);

    return abstractSemanticFields;
  }
}
