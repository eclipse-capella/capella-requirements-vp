/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
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
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.SimpleSemanticField;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.ui.properties.KitalphaRequirementsUIPropertiesPlugin;
import org.polarsys.kitalpha.vp.requirements.ui.properties.Messages;
import org.polarsys.kitalpha.vp.requirements.ui.properties.controllers.DataTypeController;
import org.polarsys.kitalpha.vp.requirements.ui.properties.controllers.EnumDataTypeController;
import org.polarsys.kitalpha.vp.requirements.ui.properties.controllers.CurrentOrUpperBlockArchitectureFilteringController;
import org.polarsys.kitalpha.vp.requirements.ui.properties.fields.BasicReqIFElementGroup;

/**
 * @author Joao Barata
 */
public class AttributeDefinitionSection extends AbstractSection {

  protected SimpleSemanticField definitionField;
  protected BasicReqIFElementGroup reqIFElementGroup;

	/**
	 * @param eObject current object
	 */
	public boolean select(Object eObject) {
		EObject eObjectToTest = super.selection(eObject);

		if (KitalphaRequirementsUIPropertiesPlugin.isViewpointActive(eObjectToTest) && eObjectToTest instanceof AttributeDefinition) {
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

		if (newEObject instanceof AttributeDefinition) {
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

    reqIFElementGroup = new BasicReqIFElementGroup(rootParentComposite, getWidgetFactory(), false, false);
    reqIFElementGroup.setDisplayedInWizard(displayedInWizard);

    definitionField = new SimpleSemanticField(getReferencesGroup(), Messages.getString("AttributeDefinition.DataTypeLabel"), getWidgetFactory(), new CurrentOrUpperBlockArchitectureFilteringController()); //$NON-NLS-1$
    definitionField.setDisplayedInWizard(displayedInWizard);
	}

	/**
	 * @param capellaElement
	 */
	public void loadData(EObject capellaElement) {
		super.loadData(capellaElement);

    reqIFElementGroup.loadData(capellaElement);
    if (capellaElement instanceof AttributeDefinitionEnumeration)
      definitionField.setController(new EnumDataTypeController());
    else
      definitionField.setController(new DataTypeController());
      
    definitionField.loadData(capellaElement, RequirementsPackage.eINSTANCE.getAttributeDefinition_DefinitionType());
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
