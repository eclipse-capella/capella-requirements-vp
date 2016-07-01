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
package org.polarsys.kitalpha.vp.requirements.ui.properties.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.core.ui.properties.controllers.SimpleSemanticFieldController;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.SimpleSemanticField;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.ui.properties.KitalphaRequirementsUIPropertiesPlugin;
import org.polarsys.kitalpha.vp.requirements.ui.properties.Messages;
import org.polarsys.kitalpha.vp.requirements.ui.properties.fields.BasicReqIFElementGroup;

/**
 * @author Joao Barata
 */
public class AttributeSection extends AbstractSection {

  protected SimpleSemanticField definitionField;
  protected BasicReqIFElementGroup reqIFElementGroup;

	/**
	 * @param eObject current object
	 */
	public boolean select(Object eObject) {
		EObject eObjectToTest = super.selection(eObject);

		if (KitalphaRequirementsUIPropertiesPlugin.isViewpointActive(eObjectToTest) && eObjectToTest instanceof Attribute) {
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

		if (newEObject instanceof Attribute) {
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

    reqIFElementGroup = new BasicReqIFElementGroup(_rootParentComposite, getWidgetFactory(), true);
    reqIFElementGroup.setDisplayedInWizard(displayedInWizard);

    definitionField = new SimpleSemanticField(getReferencesGroup(),
      Messages.getString("Attribute.DefinitionLabel"), getWidgetFactory(), new SimpleSemanticFieldController()); //$NON-NLS-1$
    definitionField.setDisplayedInWizard(displayedInWizard);
	}

	/**
	 * @param capellaElement
	 */
	public void loadData(EObject capellaElement) {
		super.loadData(capellaElement);

    reqIFElementGroup.loadData(capellaElement);
    definitionField.loadData(capellaElement, RequirementsPackage.eINSTANCE.getAttribute_Definition());
  }

	/**
	 * 
   */
	public List<AbstractSemanticField> getSemanticFields() {
		List<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();

		abstractSemanticFields.add(reqIFElementGroup);
		abstractSemanticFields.add(definitionField);

		return abstractSemanticFields;
	}
}
