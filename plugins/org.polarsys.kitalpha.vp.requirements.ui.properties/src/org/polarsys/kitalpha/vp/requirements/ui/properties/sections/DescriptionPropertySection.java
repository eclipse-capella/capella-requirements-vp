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
package org.polarsys.kitalpha.vp.requirements.ui.properties.sections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.polarsys.capella.core.model.handler.helpers.CapellaAdapterHelper;
import org.polarsys.capella.core.ui.properties.richtext.RichtextManager;
import org.polarsys.capella.core.ui.properties.richtext.fields.CapellaElementDescriptionGroup;
import org.polarsys.capella.core.ui.properties.richtext.fields.FallbackDescriptionGroup;
import org.polarsys.capella.core.ui.properties.richtext.sections.CapellaDescriptionPropertySection;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public class DescriptionPropertySection extends CapellaDescriptionPropertySection {
  private static class DescriptionGroup extends CapellaElementDescriptionGroup {
    public DescriptionGroup(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory, ISection section) {
      super(parent, widgetFactory, section);
    }

    @Override
    public void loadData(EObject element) {
      super.loadData(element, RequirementsPackage.Literals.REQUIREMENT__REQ_IF_TEXT);
    }
  }

  @Override
  protected void createDescriptionWidget(TabbedPropertySheetWidgetFactory widgetFactory, Composite parent) {
    if (RichtextManager.getInstance().isRichTextEnabled()) {
      descriptionGroup = new DescriptionGroup(parent, widgetFactory, this);
    } else {
      descriptionFallbackGroup = new FallbackDescriptionGroup(parent, "", widgetFactory, true); //$NON-NLS-1$
      descriptionFallbackGroup.setDisplayedInWizard(isDisplayedInWizard());
    }
  }

  @Override
  public boolean select(Object element) {
    EObject semanticElement = CapellaAdapterHelper.resolveSemanticObject(element);
    return semanticElement instanceof Requirement;
  }

  @Override
  public void setInput(IWorkbenchPart part, ISelection selection) {
    super.setInput(part, selection);

    if (selection instanceof StructuredSelection) {
      StructuredSelection structuredSelection = (StructuredSelection) selection;
      Object element = structuredSelection.getFirstElement();
      EObject semanticElement = CapellaAdapterHelper.resolveSemanticObject(element);

      if (semanticElement instanceof Requirement) {
        loadData(semanticElement);
      }
    }
  }

}