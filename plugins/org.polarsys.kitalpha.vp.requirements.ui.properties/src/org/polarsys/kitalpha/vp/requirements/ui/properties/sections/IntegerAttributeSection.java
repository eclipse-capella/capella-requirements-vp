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
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute;

/**
 * @author Joao Barata
 */
public class IntegerAttributeSection extends AttributeSection {

	/**
	 * @param eObject current object
	 */
	public boolean select(Object eObject) {
		EObject eObjectToTest = super.selection(eObject);

		if (super.select(eObject) && eObjectToTest instanceof IntegerValueAttribute) {
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

		if (newEObject instanceof IntegerValueAttribute) {
			loadData(newEObject);
		}
	}

	/**
	 * @param parent
	 * @param aTabbedPropertySheetPage
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
	}

	/**
	 * @param capellaElement
	 */
	public void loadData(EObject capellaElement) {
		super.loadData(capellaElement);
  }

	/**
	 * 
   */
	public List<AbstractSemanticField> getSemanticFields() {
		List<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();

		return abstractSemanticFields;
	}
}
