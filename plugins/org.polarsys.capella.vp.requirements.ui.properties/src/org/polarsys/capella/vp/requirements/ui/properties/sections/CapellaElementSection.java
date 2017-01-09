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
package org.polarsys.capella.vp.requirements.ui.properties.sections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.common.lib.IdGenerator;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.common.ui.toolkit.viewers.data.DataContentProvider;
import org.polarsys.capella.common.ui.toolkit.viewers.data.DataLabelProvider;
import org.polarsys.capella.common.ui.toolkit.viewers.data.TreeData;
import org.polarsys.capella.common.ui.toolkit.viewers.transfer.AbstractTransferViewer2;
import org.polarsys.capella.common.ui.toolkit.viewers.transfer.TransferTreeListViewer;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.providers.CapellaTransfertViewerLabelProvider;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsFactory;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.capella.vp.requirements.ui.properties.CapellaRequirementsUIPropertiesPlugin;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * @author Joao Barata
 */
public class CapellaElementSection extends AbstractSection {

  public final static int DEFAULT_EXPAND_LEVEL = 4;
  public final static int DEFAULT_TREE_VIEWER_STYLE = SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER;
  public final static int TRANSFER_TREE_STYLE = AbstractTransferViewer2.SINGLE_SELECTION_VIEWER | AbstractTransferViewer2.ALL_BUTTONS;

  protected TransferTreeListViewer viewer;
  protected EObject capellaElement;

  /**
	 * @param eObject current object
   */
  public boolean select(Object eObject) {
    EObject eObjectToTest = super.selection(eObject);

		if (CapellaRequirementsUIPropertiesPlugin.isViewpointActive(eObjectToTest) && eObjectToTest instanceof CapellaElement) {
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
    if (newEObject instanceof CapellaElement) {
      loadData(newEObject);
    }
  }

  /**
   * @param parent
   * @param aTabbedPropertySheetPage
   */
  public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
    super.createControls(parent, aTabbedPropertySheetPage);

    _rootParentComposite.setLayout(new GridLayout());
    _rootParentComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Group grp = getWidgetFactory().createGroup(_rootParentComposite, ICommonConstants.EMPTY_STRING);
    grp.setLayout(new GridLayout(1, false));
    grp.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

		viewer = new TransferTreeListViewer(grp, TRANSFER_TREE_STYLE, DEFAULT_TREE_VIEWER_STYLE, DEFAULT_TREE_VIEWER_STYLE, DEFAULT_EXPAND_LEVEL, DEFAULT_EXPAND_LEVEL) {
      @Override
      protected boolean doHandleAddAllButton() {
        addAllocations(getLeftInput().getValidElements());
        return super.doHandleAddAllButton();
      }

      @Override
      protected boolean doHandleRemoveAllButton() {
        removeAllocations(getRightInput().getValidElements());
        return super.doHandleRemoveAllButton();
      }

      @SuppressWarnings("unchecked")
      @Override
      protected boolean doHandleAddSelectedButton() {
        addAllocations(((IStructuredSelection) getLeftViewer().getSelection()).toList());
        return super.doHandleAddSelectedButton();
      }

      @SuppressWarnings("unchecked")
      @Override
      protected boolean doHandleRemoveSelectedButton() {
        removeAllocations(((IStructuredSelection) getRightViewer().getSelection()).toList());
        return super.doHandleRemoveSelectedButton();
      }

    };
    viewer.setLeftContentProvider(new DataContentProvider());
    viewer.setRightContentProvider(new DataContentProvider());
  }

  protected void addAllocations(Collection<Object> elts) {
    final List<Requirement> elementsToBeAdded = new ArrayList<Requirement>(0);
    for (Object obj : elts) {
      elementsToBeAdded.add((Requirement) obj);
    }
    final EObject currentSelection;
    // When the section is not initialized for a Property view, the selection is not set
    if (getSelection() == null)
      currentSelection = capellaElement;
    else
      currentSelection = (EObject) ((IStructuredSelection) getSelection()).getFirstElement();
    for (EObject referencer : EObjectExt.getReferencers(currentSelection, CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__SOURCE)) {
      Requirement requirement = ((CapellaOutgoingRelation) referencer).getTarget();
      if ((requirement != null) && elementsToBeAdded.contains(requirement)) {
        elementsToBeAdded.remove(requirement);
      }
    }
    getExecutionManager().execute(new AbstractReadWriteCommand() {
      public void run() {
        for (Requirement requirement : elementsToBeAdded) {
          CapellaOutgoingRelation relation = CapellaRequirementsFactory.eINSTANCE.createCapellaOutgoingRelation();
          relation.setId(IdGenerator.createId());
          relation.setTarget(requirement);
          relation.setSource((CapellaElement) currentSelection);
          requirement.getOwnedRelations().add(relation);
        }
      }
    });
  }

  protected void removeAllocations(Collection<Object> elts) {
    final List<AbstractRelation> elementsToBeDestroyed = new ArrayList<AbstractRelation>(0);
    EObject currentSelection;
    if (getSelection() == null)
      currentSelection = capellaElement;
    else
      currentSelection = (EObject) ((IStructuredSelection) getSelection()).getFirstElement();
    for (EObject referencer : EObjectExt.getReferencers(currentSelection, CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__SOURCE)) {
      Requirement requirement = ((CapellaOutgoingRelation) referencer).getTarget();
      if ((requirement != null) && elts.contains(requirement)) {
        elementsToBeDestroyed.add((AbstractRelation) referencer);
      }
    }
    getExecutionManager().execute(new AbstractReadWriteCommand() {
      public void run() {
        for (AbstractRelation relation : elementsToBeDestroyed) {
          EcoreUtil.delete(relation);
        }
      }
    });
  }

  /**
   * @param capellaElement
   */
  public void loadData(EObject capellaElement) {
    super.loadData(capellaElement);
    this.capellaElement = capellaElement;
    IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(CapellacorePackage.Literals.CAPELLA_ELEMENT,
        CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET);
    if (query != null) {
      List<EObject> availableElements = query.getAvailableElements(capellaElement);
      DataLabelProvider leftLabelProvider =  new CapellaTransfertViewerLabelProvider(TransactionHelper.getEditingDomain(availableElements));
      viewer.setLeftLabelProvider(leftLabelProvider);
      viewer.setLeftInput(new TreeData(availableElements, null));

      List<EObject> currentElements = query.getCurrentElements(capellaElement, false);
      DataLabelProvider rightLabelProvider =  new CapellaTransfertViewerLabelProvider(TransactionHelper.getEditingDomain(currentElements)) {
        @Override
        public String getText(Object object) {
          String prefix = ICommonConstants.EMPTY_STRING;
          if (object instanceof Requirement) {
            for (EObject relation : EObjectExt.getReferencers((EObject) object, CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET)) {
              RelationType type = ((CapellaOutgoingRelation) relation).getRelationType();
              if (type != null) {
                String typeName = type.getReqIFLongName();
                if (typeName != null && !typeName.isEmpty()) {
                  prefix = "[" + typeName + "] ";
                }
              }
            }
          }
          return prefix + super.getText(object);
        }
      };
      viewer.setRightLabelProvider(rightLabelProvider);
      viewer.setRightInput(new TreeData(currentElements, null));
    }
  }

  /**
   * 
   */
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();
    return abstractSemanticFields;
  }
}
