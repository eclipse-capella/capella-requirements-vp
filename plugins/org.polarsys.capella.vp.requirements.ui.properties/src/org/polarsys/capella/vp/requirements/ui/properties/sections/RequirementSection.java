/*******************************************************************************
 * Copyright (c) 2016, 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ui.properties.sections;

import java.util.Collections;
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
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.ui.properties.CapellaUIPropertiesPlugin;
import org.polarsys.capella.core.ui.properties.IImageKeys;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.fields.ReferenceTableField;
import org.polarsys.capella.core.ui.properties.helpers.DialogHelper;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.core.ui.properties.viewers.AbstractPropertyValueCellEditorProvider;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRelation;
import org.polarsys.capella.vp.requirements.model.helpers.ViewpointHelper;
import org.polarsys.capella.vp.requirements.ui.properties.controllers.RequirementIncomingLinkController;
import org.polarsys.capella.vp.requirements.ui.properties.controllers.RequirementOutgoingLinkController;
import org.polarsys.capella.vp.requirements.ui.properties.labelproviders.CapellaElementColumnLabelProvider;
import org.polarsys.capella.vp.requirements.ui.properties.labelproviders.RelationTypeColumnLabelProvider;
import org.polarsys.capella.vp.requirements.ui.properties.widgets.RelationTypeTableDelegatedViewer;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * @author Joao Barata
 */
public class RequirementSection extends AbstractSection {

  protected EObject requirement;

  /**
   * @param eObject
   *          current object
   */
  @Override
  public boolean select(Object eObject) {
    EObject eObjectToTest = super.selection(eObject);

    if (ViewpointHelper.isViewpointActive(eObjectToTest) && eObjectToTest instanceof Requirement) {
      return true;
    }
    return false;
  }

  /**
   * @param part
   * @param selection
   */
  @Override
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
  @Override
  public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createControls(parent, aTabbedPropertySheetPage);
    
    parent.setLayout(new GridLayout());
    parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Group grp = getWidgetFactory().createGroup(parent, ICommonConstants.EMPTY_STRING);
    grp.setLayout(new GridLayout(2, false));
    grp.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

    setUpFields(grp);
  }

  /**
   * @param requirement
   */
  @Override
  public void loadData(final EObject requirement) {
    super.loadData(requirement);
    this.requirement = requirement;

    incomingTableField.loadData(requirement, RequirementsPackage.eINSTANCE.getRequirement_OwnedRelations());
    outgoingTableField.loadData(requirement, RequirementsPackage.eINSTANCE.getRequirement_OwnedRelations());
  }

  @Override
  public List<AbstractSemanticField> getSemanticFields() {
    return Collections.emptyList();
  }

  private ReferenceTableField incomingTableField;

  protected final String[] _columnProperties = { "Source element", "Relation type" };

  private ReferenceTableField outgoingTableField;

  protected final String[] outgoingColumnProperties = { "Target element", "Relation type" };

  protected void setUpFields(final Group grp) {
    incomingTableField = new ReferenceTableField(grp, getWidgetFactory(), null, "Incoming links",
        new RequirementIncomingLinkController(), new RelationTypeTableDelegatedViewer(getWidgetFactory(),
            new AbstractPropertyValueCellEditorProvider()) {
          @Override
          protected String[] getColumnProperties() {
            return _columnProperties;
          }

          @Override
          protected boolean createViewerColumns() {
            createTableViewerColumn(0, new CapellaElementColumnLabelProvider());
            createTableViewerColumn(1, new RelationTypeColumnLabelProvider());
            return true;
          }

          @Override
          public StructuredSelection getSelectedObjectFromSelection(TableItem[] inSelection) {
            if (inSelection != null && inSelection.length > 0) {
              CapellaRelation relation = (CapellaRelation) inSelection[0].getData();
              Object elementToDisplay_p = null;
              if (relation instanceof CapellaOutgoingRelation) {
                elementToDisplay_p = ((CapellaOutgoingRelation) relation).getSource();
              } else {
                elementToDisplay_p = ((CapellaIncomingRelation) relation).getTarget();
              }
              return new StructuredSelection(elementToDisplay_p);
            }
            return null;
          }
        }) {
      protected List<EObject> getReferencedElementsByContainedOnes() {
        return _controller.loadValues(semanticElement, semanticFeature);
      }

      protected void handleBrowse() {
        AbstractReadWriteCommand command = new AbstractReadWriteCommand() {
          public void run() {
            List<EObject> availableElements = _controller.readOpenValues(semanticElement, semanticFeature, true);
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
                  for (EObject eObj : selectedReferencedElements) {
                    if (eObj instanceof CapellaOutgoingRelation) {
                      CapellaElement srcElement = ((CapellaOutgoingRelation) eObj).getSource();
                      srcElement.getOwnedExtensions().remove((CapellaOutgoingRelation) eObj);
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

    outgoingTableField = new ReferenceTableField(grp, getWidgetFactory(), null, "Outgoing links",
        new RequirementOutgoingLinkController(), new RelationTypeTableDelegatedViewer(getWidgetFactory(),
            new AbstractPropertyValueCellEditorProvider()) {
          @Override
          protected String[] getColumnProperties() {
            return outgoingColumnProperties;
          }

          @Override
          protected boolean createViewerColumns() {
            createTableViewerColumn(0, new CapellaElementColumnLabelProvider());
            createTableViewerColumn(1, new RelationTypeColumnLabelProvider());
            return true;
          }

          @Override
          public StructuredSelection getSelectedObjectFromSelection(TableItem[] inSelection) {
            if (inSelection != null && inSelection.length > 0) {
              CapellaRelation relation = (CapellaRelation) inSelection[0].getData();
              Object elementToDisplay_p = null;
              if (relation instanceof CapellaOutgoingRelation) {
                elementToDisplay_p = ((CapellaOutgoingRelation) relation).getSource();
              } else {
                elementToDisplay_p = ((CapellaIncomingRelation) relation).getTarget();
              }
              return new StructuredSelection(elementToDisplay_p);
            }
            return null;
          }
        }) {
      protected List<EObject> getReferencedElementsByContainedOnes() {
        return _controller.loadValues(semanticElement, semanticFeature);
      }

      protected void handleBrowse() {
        AbstractReadWriteCommand command = new AbstractReadWriteCommand() {
          public void run() {
            List<EObject> availableElements = _controller.readOpenValues(semanticElement, semanticFeature, true);
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
                      if (eObj instanceof CapellaIncomingRelation) {
                        requirement.getOwnedRelations().remove((CapellaIncomingRelation) eObj);
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
