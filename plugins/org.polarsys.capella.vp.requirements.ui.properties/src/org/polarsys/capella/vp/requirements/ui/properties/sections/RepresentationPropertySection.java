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

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDDiagramEditPart;
import org.eclipse.sirius.ui.tools.api.views.common.item.ItemWrapper;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
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
import org.polarsys.capella.core.model.handler.helpers.RepresentationHelper;
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
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.capella.vp.requirements.model.helpers.ViewpointHelper;
import org.polarsys.capella.vp.requirements.ui.properties.controllers.DiagramIncomingLink;
import org.polarsys.capella.vp.requirements.ui.properties.controllers.DiagramOutgoingLink;
import org.polarsys.capella.vp.requirements.ui.properties.controllers.RepresentationIncomingLinkController;
import org.polarsys.capella.vp.requirements.ui.properties.controllers.RepresentationOutgoingLinkController;
import org.polarsys.capella.vp.requirements.ui.properties.labelproviders.RelationTypeColumnLabelProvider;
import org.polarsys.capella.vp.requirements.ui.properties.labelproviders.RequirementColumnLabelProvider;
import org.polarsys.capella.vp.requirements.ui.properties.widgets.RelationTypeTableDelegatedViewer;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * @author Joao Barata
 */
public class RepresentationPropertySection extends AbstractSection {

  private WeakReference<DRepresentationDescriptor> descriptor;

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean select(Object toTest) {
    EObject eObjectToTest = super.selection(toTest);

    if (ViewpointHelper.isViewpointActive(eObjectToTest) && (eObjectToTest instanceof DRepresentationDescriptor)
        || (eObjectToTest instanceof DRepresentation) || (eObjectToTest instanceof IDDiagramEditPart)) {
      return true;
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setInput(IWorkbenchPart part, ISelection selection) {
    if (!selection.isEmpty()) {
      if (selection instanceof IStructuredSelection) {
        Object firstElement = ((IStructuredSelection) selection).getFirstElement();

        if (firstElement instanceof ItemWrapper) {
          firstElement = ((ItemWrapper) firstElement).getWrappedObject();
        }
        if (firstElement instanceof DRepresentationDescriptor) {
          descriptor = new WeakReference<>((DRepresentationDescriptor) firstElement);
        } else if (firstElement instanceof IDDiagramEditPart) {
          IDDiagramEditPart diagramEditPart = (IDDiagramEditPart) firstElement;
          descriptor = new WeakReference<>(RepresentationHelper
              .getRepresentationDescriptor((DRepresentation) ((Diagram) diagramEditPart.getModel()).getElement()));
        } else if (firstElement instanceof GraphicalEditPart) {
          Object model = ((GraphicalEditPart) firstElement).getModel();
          if (model instanceof Shape) {
            EObject element = ((Shape) model).getElement();
            if (element instanceof DRepresentationDescriptor) {
              descriptor = new WeakReference<>((DRepresentationDescriptor) element);
            }
          }
        } else {
          descriptor = null;
        }
      }
      if (descriptor != null)
        loadData(descriptor.get());
    }
  }

  /**
   * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
   *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
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
   * @param representation
   */
  @Override
  public void loadData(final EObject representation) {
    super.loadData(representation);

    incomingTableField.loadData(representation, RequirementsPackage.eINSTANCE.getRequirement_OwnedRelations());
    outgoingTableField.loadData(representation, RequirementsPackage.eINSTANCE.getRequirement_OwnedRelations());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void dispose() {
    super.dispose();

    if (null != descriptor) {
      descriptor.clear();
      descriptor = null;
    }
  }

  private ReferenceTableField incomingTableField;

  protected final String[] _columnProperties = { "Source element", "Relation type" };

  private ReferenceTableField outgoingTableField;

  protected final String[] outgoingColumnProperties = { "Target element", "Relation type" };

  protected void setUpFields(Group grp) {
    incomingTableField = new ReferenceTableField(grp, getWidgetFactory(), null, "Incoming links",
        new RepresentationIncomingLinkController(),
        new RelationTypeTableDelegatedViewer(getWidgetFactory(), new AbstractPropertyValueCellEditorProvider()) {
          @Override
          protected String[] getColumnProperties() {
            return _columnProperties;
          }

          @Override
          protected boolean createViewerColumns() {
            createTableViewerColumn(0, new RequirementColumnLabelProvider());
            createTableViewerColumn(1, new RelationTypeColumnLabelProvider());
            return true;
          }

          @Override
          public StructuredSelection getSelectedObjectFromSelection(TableItem[] inSelection) {
            if (inSelection != null && inSelection.length > 0) {
              CapellaRelation relation = (CapellaRelation) inSelection[0].getData();
              Object elementToDisplay_p = null;
              if (relation instanceof CapellaOutgoingRelation) {
                elementToDisplay_p = ((CapellaOutgoingRelation) relation).getTarget();
              } else {
                elementToDisplay_p = ((CapellaIncomingRelation) relation).getSource();
              }
              return new StructuredSelection(elementToDisplay_p);
            }
            return null;
          }
        }) {
      protected List<EObject> getReferencedElementsByContainedOnes() {
        return _controller.loadValues(descriptor.get(), semanticFeature);
      }

      protected void handleBrowse() {
        AbstractReadWriteCommand command = new AbstractReadWriteCommand() {
          public void run() {
            List<EObject> availableElements = _controller.readOpenValues(descriptor.get(), semanticFeature, true);
            List<EObject> allResults = (List<EObject>) DialogHelper.openMultiSelectionDialog(_browseBtn,
                availableElements);
            if (null != allResults) {
              _controller.writeOpenValues(descriptor.get(), semanticFeature, allResults);
            }
          }
        };
        TransactionHelper.getExecutionManager(descriptor.get()).execute(command);
        refreshViewer();
      }

      protected void handleDelete() {
        if (null != _delegatedViewer) {
          ColumnViewer columnViewer = _delegatedViewer.getColumnViewer();
          if (null != columnViewer) {
            final List<EObject> selectedReferencedElements = ((IStructuredSelection) columnViewer.getSelection())
                .toList();
            if (!selectedReferencedElements.isEmpty()) {
              for (EObject eObj : selectedReferencedElements) {
                if (eObj instanceof DiagramIncomingLink) {
                  RelationAnnotationHelper.removeAllocation(descriptor.get(),
                      RelationAnnotationHelper.IncomingRelationAnnotation, ((DiagramIncomingLink) eObj).getAnnotation());
                }
              }
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
        new RepresentationOutgoingLinkController(),
        new RelationTypeTableDelegatedViewer(getWidgetFactory(), new AbstractPropertyValueCellEditorProvider()) {
          @Override
          protected String[] getColumnProperties() {
            return outgoingColumnProperties;
          }

          @Override
          protected boolean createViewerColumns() {
            createTableViewerColumn(0, new RequirementColumnLabelProvider());
            createTableViewerColumn(1, new RelationTypeColumnLabelProvider());
            return true;
          }

          @Override
          public StructuredSelection getSelectedObjectFromSelection(TableItem[] inSelection) {
            if (inSelection != null && inSelection.length > 0) {
              CapellaRelation relation = (CapellaRelation) inSelection[0].getData();
              Object elementToDisplay_p = null;
              if (relation instanceof CapellaOutgoingRelation) {
                elementToDisplay_p = ((CapellaOutgoingRelation) relation).getTarget();
              } else {
                elementToDisplay_p = ((CapellaIncomingRelation) relation).getSource();
              }
              return new StructuredSelection(elementToDisplay_p);
            }
            return null;
          }
        }) {
      protected List<EObject> getReferencedElementsByContainedOnes() {
        return _controller.loadValues(descriptor.get(), semanticFeature);
      }

      protected void handleBrowse() {
        AbstractReadWriteCommand command = new AbstractReadWriteCommand() {
          public void run() {
            List<EObject> availableElements = _controller.readOpenValues(descriptor.get(), semanticFeature, true);
            List<EObject> allResults = (List<EObject>) DialogHelper.openMultiSelectionDialog(_browseBtn,
                availableElements);
            if (null != allResults) {
              _controller.writeOpenValues(descriptor.get(), semanticFeature, allResults);
            }
          }
        };
        TransactionHelper.getExecutionManager(descriptor.get()).execute(command);
        refreshViewer();
      }

      protected void handleDelete() {
        if (null != _delegatedViewer) {
          ColumnViewer columnViewer = _delegatedViewer.getColumnViewer();
          if (null != columnViewer) {
            final List<EObject> selectedReferencedElements = ((IStructuredSelection) columnViewer.getSelection())
                .toList();
            if (!selectedReferencedElements.isEmpty()) {

              for (EObject eObj : selectedReferencedElements) {
                if (eObj instanceof DiagramOutgoingLink) {
                  RelationAnnotationHelper.removeAllocation(descriptor.get(),
                      RelationAnnotationHelper.OutgoingRelationAnnotation, ((DiagramOutgoingLink) eObj).getAnnotation());
                }
              }

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

  @Override
  public List<AbstractSemanticField> getSemanticFields() {
    return Collections.emptyList();
  }
}
