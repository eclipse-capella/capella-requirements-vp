/*******************************************************************************
 * Copyright (c) 2006, 2017 THALES GLOBAL SERVICES.
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.diagram.ui.edit.api.part.IDDiagramEditPart;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.common.mdsofa.common.misc.Couple;
import org.polarsys.capella.common.ui.toolkit.viewers.data.DataContentProvider;
import org.polarsys.capella.common.ui.toolkit.viewers.data.DataLabelProvider;
import org.polarsys.capella.common.ui.toolkit.viewers.data.TreeData;
import org.polarsys.capella.common.ui.toolkit.viewers.transfer.TransferTreeListViewer;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.capella.core.ui.properties.providers.CapellaTransfertViewerLabelProvider;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.capella.vp.requirements.ui.properties.CapellaRequirementsUIPropertiesPlugin;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 *
 */
public class RepresentationPropertySection extends AbstractAllocationSection {

  private WeakReference<DRepresentation> _representation;

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean select(Object toTest) {
    EObject eObjectToTest = super.selection(toTest);

    if (CapellaRequirementsUIPropertiesPlugin.isViewpointActive(eObjectToTest) &&
        (eObjectToTest instanceof DRepresentationDescriptor) || (eObjectToTest instanceof DRepresentation) || (eObjectToTest instanceof IDDiagramEditPart))
    {
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

        if (firstElement instanceof DRepresentationDescriptor) {
          firstElement = ((DRepresentationDescriptor) firstElement).getRepresentation();
        }

        if (firstElement instanceof DRepresentation) {
          _representation = new WeakReference<DRepresentation>((DRepresentation) firstElement);
        } else if (firstElement instanceof IDDiagramEditPart) {
          IDDiagramEditPart diagramEditPart = (IDDiagramEditPart) firstElement;
          _representation = new WeakReference<DRepresentation>((DRepresentation) ((Diagram) diagramEditPart.getModel()).getElement());
        } else {
          _representation = null;
        }
      }
      loadData();
    }
  }

  /**
   * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
   *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
   */
  @Override
  public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createControls(parent, aTabbedPropertySheetPage);

    _rootParentComposite.setLayout(new GridLayout());
    _rootParentComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Group grp = getWidgetFactory().createGroup(_rootParentComposite, ICommonConstants.EMPTY_STRING);
    grp.setLayout(new GridLayout(2, false));
    grp.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

    createRelationConfig(grp);
    
    transferTreeViewer = new TransferTreeListViewer(grp, TRANSFER_TREE_STYLE, DEFAULT_TREE_VIEWER_STYLE, DEFAULT_TREE_VIEWER_STYLE, DEFAULT_EXPAND_LEVEL, DEFAULT_EXPAND_LEVEL) {
      @Override
      protected boolean doHandleAddAllButton() {
        Collection<Couple<EObject, EObject>> elts = new ArrayList<Couple<EObject,EObject>>();
        for (Object elt : getLeftInput().getValidElements()) {
          elts.add(new Couple<EObject, EObject>((EObject) elt, getRelationType()));
        }
        if (getRelationDirection() == RelationDirectionKind.INCOMING) {
          RelationAnnotationHelper.addAllocations(_representation.get(), RelationAnnotationHelper.IncomingRelationAnnotation, elts);
        } else {
          RelationAnnotationHelper.addAllocations(_representation.get(), RelationAnnotationHelper.OutgoingRelationAnnotation, elts);
        }

        return super.doHandleAddAllButton();
      }

      @Override
      protected boolean doHandleRemoveAllButton() {
        RelationAnnotationHelper.removeAllocations(_representation.get(), getRightInput().getValidElements());
        return super.doHandleRemoveAllButton();
      }

      @Override
      protected boolean doHandleAddSelectedButton() {
        Collection<Couple<EObject, EObject>> elts = new ArrayList<Couple<EObject,EObject>>();
        for (Object elt : ((IStructuredSelection) getLeftViewer().getSelection()).toList()) {
          elts.add(new Couple<EObject, EObject>((EObject) elt, getRelationType()));
        }
        if (getRelationDirection() == RelationDirectionKind.INCOMING) {
          RelationAnnotationHelper.addAllocations(_representation.get(), RelationAnnotationHelper.IncomingRelationAnnotation, elts);
        } else {
          RelationAnnotationHelper.addAllocations(_representation.get(), RelationAnnotationHelper.OutgoingRelationAnnotation, elts);
        }

        return super.doHandleAddSelectedButton();
      }

      @SuppressWarnings("unchecked")
      @Override
      protected boolean doHandleRemoveSelectedButton() {
        RelationAnnotationHelper.removeAllocations(_representation.get(), ((IStructuredSelection) getRightViewer().getSelection()).toList());
        return super.doHandleRemoveSelectedButton();
      }
      
    };
    transferTreeViewer.setLeftContentProvider(new DataContentProvider());
    transferTreeViewer.setRightContentProvider(new DataContentProvider());
    transferTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void dispose() {
    super.dispose();

    if (null != _representation) {
      _representation.clear();
      _representation = null;
    }
  }

  /**
   * 
   */
  public void loadData() {
  
  DRepresentation representation = _representation.get();
  if (representation instanceof DSemanticDecorator) {
    DSemanticDecorator semanticDecorator = (DSemanticDecorator) representation;
    addRequirementsRelationTypes(semanticDecorator.getTarget());
  }

    IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(ViewpointPackage.Literals.DREPRESENTATION,
        CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET);
    if (query != null) {
      List<EObject> availableElements = query.getAvailableElements(_representation.get());
      DataLabelProvider leftLabelProvider =  new CapellaTransfertViewerLabelProvider(TransactionHelper.getEditingDomain(availableElements));
      transferTreeViewer.setLeftLabelProvider(leftLabelProvider);
      transferTreeViewer.setLeftInput(new TreeData(availableElements, null));

      List<EObject> currentElements = query.getCurrentElements(_representation.get(), false);
      DataLabelProvider rightLabelProvider =  new CapellaTransfertViewerLabelProvider(TransactionHelper.getEditingDomain(currentElements)) {
        @Override
        public String getText(Object object) {
          String prefix = ICommonConstants.EMPTY_STRING;
          if (object instanceof Requirement) {
            RelationType outgoingRelationType = RelationAnnotationHelper.getAllocationType(_representation.get(), RelationAnnotationHelper.OutgoingRelationAnnotation, (Requirement) object);
            if (outgoingRelationType != null) {
              String typeName = outgoingRelationType.getReqIFLongName();
              if (typeName != null && !typeName.isEmpty()) {
                prefix = "[-> " + typeName + "] ";
              }
            }
            RelationType incomingRelationType = RelationAnnotationHelper.getAllocationType(_representation.get(), RelationAnnotationHelper.IncomingRelationAnnotation, (Requirement) object);
            if (incomingRelationType != null) {
              String typeName = incomingRelationType.getReqIFLongName();
              if (typeName != null && !typeName.isEmpty()) {
                prefix = "[<- " + typeName + "] ";
              }
            }
          }
          return prefix + super.getText(object);
        }
      };
      transferTreeViewer.setRightLabelProvider(rightLabelProvider);
      transferTreeViewer.setRightInput(new TreeData(currentElements, null));
      transferTreeViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
    }
  }
}
