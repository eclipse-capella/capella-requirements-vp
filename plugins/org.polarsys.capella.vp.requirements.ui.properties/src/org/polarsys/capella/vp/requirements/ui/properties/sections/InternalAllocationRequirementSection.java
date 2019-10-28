/*******************************************************************************
 * Copyright (c) 2017, 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.properties.sections;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.core.ui.properties.CapellaUIPropertiesPlugin;
import org.polarsys.capella.core.ui.properties.IImageKeys;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.ReferenceTableField;
import org.polarsys.capella.core.ui.properties.helpers.DialogHelper;
import org.polarsys.capella.core.ui.properties.viewers.AbstractPropertyValueCellEditorProvider;
import org.polarsys.capella.vp.requirements.ui.properties.controllers.RequirementInternalLinkController;
import org.polarsys.capella.vp.requirements.ui.properties.labelproviders.RelationTypeColumnLabelProvider;
import org.polarsys.capella.vp.requirements.ui.properties.labelproviders.RequirementColumnLabelProvider;
import org.polarsys.capella.vp.requirements.ui.properties.widgets.RelationTypeTableDelegatedViewer;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.ui.properties.KitalphaRequirementsUIPropertiesPlugin;

public class InternalAllocationRequirementSection extends AbstractAllocationSection {

  protected EObject requirement;

  /**
   * @param eObject
   *          current object
   */
  public boolean select(Object eObject) {
    EObject eObjectToTest = super.selection(eObject);

    if (KitalphaRequirementsUIPropertiesPlugin.isViewpointActive(eObjectToTest) && eObjectToTest instanceof Requirement) {
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
    if (newEObject instanceof Requirement) {
      loadData(newEObject);
    }
  }

  /**
   * @param parent
   * @param aTabbedPropertySheetPage
   */
  public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createControls(parent, aTabbedPropertySheetPage);
    
    parent.setLayout(new GridLayout());
    parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Group grp = getWidgetFactory().createGroup(parent, ICommonConstants.EMPTY_STRING);
    grp.setLayout(new GridLayout(1, false));
    grp.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

    setUpFields(grp);
  }

  /**
   * @param requirement
   */
  public void loadData(final EObject requirement) {
    super.loadData(requirement);
    this.requirement = requirement;

    internalTableField.loadData(requirement, RequirementsPackage.eINSTANCE.getRequirement_OwnedRelations());
  }

  /**
	 * 
   */
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();
    return abstractSemanticFields;
  }

  private ReferenceTableField internalTableField;

  protected final String[] internalColumnProperties = { "Target element", "Relation type" };

  protected void setUpFields(Group grp) {
    internalTableField = new ReferenceTableField(grp, getWidgetFactory(), null, "Internal links",
        new RequirementInternalLinkController(), new RelationTypeTableDelegatedViewer(getWidgetFactory(),
            new AbstractPropertyValueCellEditorProvider()) {
          /**
           * {@inheritDoc}
           */
          @Override
          protected String[] getColumnProperties() {
            return internalColumnProperties;
          }

          /**
           * {@inheritDoc}
           */
          @Override
          protected boolean createViewerColumns() {
            createTableViewerColumn(0, new RequirementColumnLabelProvider());
            createTableViewerColumn(1, new RelationTypeColumnLabelProvider());

            return true;
          }

          @Override
          public StructuredSelection getSelectedObjectFromSelection(TableItem[] inSelection) {
            if (inSelection != null && inSelection.length > 0) {
              InternalRelation relation = (InternalRelation) inSelection[0].getData();
              Object elementToDisplay_p = null;
              if (relation instanceof InternalRelation) {
                elementToDisplay_p = ((InternalRelation) relation).getTarget();
              }
              return new StructuredSelection(elementToDisplay_p);
            }
            return null;
          }

          /**
           * {@inheritDoc}
           */
          @Override
          protected void modifyElement(final EObject element, final int column, final Object value) {
            executeCommmand(new AbstractReadWriteCommand() {
              public void run() {
                getCellEditorProvider().modifyElement(element, column, value);
              }
            });
          }
        }) {
      protected List<EObject> getReferencedElementsByContainedOnes() {
        return _controller.loadValues(semanticElement, semanticFeature);
      }

      /**
       * Handle Browse button.
       */
      protected void handleBrowse() {
        AbstractReadWriteCommand command = new AbstractReadWriteCommand() {
          public void run() {
            List<EObject> availableElements = _controller.readOpenValues(semanticElement, semanticFeature, true);
            // We do not want to create an internal relation to the requirement itself
            availableElements.remove(semanticElement);
            List<EObject> allResults = (List<EObject>) DialogHelper.openMultiSelectionDialog(_browseBtn,
                availableElements);
            if (null != allResults) {
              _controller.writeOpenValues(semanticElement, semanticFeature, allResults);
            }
          }
        };
        TransactionHelper.getExecutionManager(semanticElement).execute(command);
        refreshViewer();
      }

      protected void handleDelete() {
        if (null != _delegatedViewer) {
          ColumnViewer columnViewer = _delegatedViewer.getColumnViewer();
          if (null != columnViewer) {
            final List<EObject> selectedReferencedElements = ((IStructuredSelection) columnViewer.getSelection())
                .toList();
            if (!selectedReferencedElements.isEmpty()) {
              AbstractReadWriteCommand command = new AbstractReadWriteCommand() {
                public void run() {
                  if (semanticElement instanceof Requirement) {
                    Requirement requirement = (Requirement) semanticElement;
                    for (EObject eObj : selectedReferencedElements) {
                      if (eObj instanceof InternalRelation) {
                        requirement.getOwnedRelations().remove((InternalRelation) eObj);
                      }
                    }
                  }
                }
              };
              TransactionHelper.getExecutionManager(semanticElement).execute(command);
              refreshViewer();
            }
          }
        }
      }

      @Override
      protected void createCustomActions(Composite parent) {
        _browseBtn = createTableButton(parent,
            CapellaUIPropertiesPlugin.getDefault().getImage(IImageKeys.IMG_ADD_BUTTON), new Runnable() {
              public void run() {
                handleBrowse();
              }
            });
      }

    };
  }
}
