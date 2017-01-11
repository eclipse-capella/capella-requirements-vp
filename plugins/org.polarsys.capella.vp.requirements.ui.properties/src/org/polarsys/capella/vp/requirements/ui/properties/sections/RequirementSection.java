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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.common.ui.toolkit.viewers.data.DataLabelProvider;
import org.polarsys.capella.common.ui.toolkit.viewers.data.TreeData;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.providers.CapellaTransfertViewerLabelProvider;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsFactory;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.capella.vp.requirements.ui.properties.CapellaRequirementsUIPropertiesPlugin;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * @author Joao Barata
 */
public class RequirementSection extends AbstractAllocationSection {
  
  protected EObject requirement;

	/**
	 * @param eObject current object
	 */
	public boolean select(Object eObject) {
		EObject eObjectToTest = super.selection(eObject);

		if (CapellaRequirementsUIPropertiesPlugin.isViewpointActive(eObjectToTest) && eObjectToTest instanceof Requirement) {
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

    _rootParentComposite.setLayout(new GridLayout());
    _rootParentComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Group grp = getWidgetFactory().createGroup(_rootParentComposite, ICommonConstants.EMPTY_STRING);
    grp.setLayout(new GridLayout(2, false));
    grp.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

    createRelationConfig(grp);
    createTransferTreeListViewer(grp);
  }

  @Override
  protected void addAllocations(Collection<Object> elts) {
    final List<CapellaElement> elementsToBeAdded = new ArrayList<CapellaElement>(0);
    for (Object obj : elts) {
      elementsToBeAdded.add((CapellaElement) obj);
    }
    final EObject currentSelection;
    // When the section is not initialized for a Property view, the selection is not set
    if (getSelection() == null)
      currentSelection = requirement;
    else
      currentSelection = (EObject) ((IStructuredSelection) getSelection()).getFirstElement();
    for (EObject elt : EObjectExt.getReferencers(currentSelection, CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE)) {
      CapellaElement element = ((CapellaIncomingRelation) elt).getTarget();
      if ((element != null) && elementsToBeAdded.contains(element)) {
        elementsToBeAdded.remove(element);
      }
    }
    for (EObject elt : EObjectExt.getReferencers(currentSelection, CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET)) {
        CapellaElement element = ((CapellaOutgoingRelation) elt).getSource();
        if ((element != null) && elementsToBeAdded.contains(element)) {
          elementsToBeAdded.remove(element);
        }
      }
    getExecutionManager().execute(new AbstractReadWriteCommand() {
      public void run() {
        for (CapellaElement elt : elementsToBeAdded) {
          CapellaRelation relation;
          if (getRelationDirection() == RelationDirectionKind.OUT) {
        	  CapellaIncomingRelation incomingRelation = CapellaRequirementsFactory.eINSTANCE.createCapellaIncomingRelation();
              incomingRelation.setTarget(elt);
              incomingRelation.setSource((Requirement) currentSelection);
              relation = incomingRelation;
          } else {
        	  CapellaOutgoingRelation outgoingRelation = CapellaRequirementsFactory.eINSTANCE.createCapellaOutgoingRelation();
              outgoingRelation.setTarget((Requirement) currentSelection);
              outgoingRelation.setSource(elt);
              relation = outgoingRelation;
          }
          relation.setRelationType(getRelationType());
          ((Requirement) currentSelection).getOwnedRelations().add(relation);
        }
      }
    });
  }

  @Override
  protected void removeAllocations(Collection<Object> elts) {
    final List<AbstractRelation> elementsToBeDestroyed = new ArrayList<AbstractRelation>(0);
    EObject currentSelection;
    if (getSelection() == null)
      currentSelection = requirement;
    else
      currentSelection = (EObject) ((IStructuredSelection) getSelection()).getFirstElement();
    for (EObject referencer : EObjectExt.getReferencers(currentSelection, CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE)) {
      CapellaElement elt = ((CapellaIncomingRelation) referencer).getTarget();
      if ((elt != null) && elts.contains(elt)) {
        elementsToBeDestroyed.add((AbstractRelation) referencer);
      }
    }
    for (EObject referencer : EObjectExt.getReferencers(currentSelection, CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET)) {
        CapellaElement elt = ((CapellaOutgoingRelation) referencer).getSource();
        if ((elt != null) && elts.contains(elt)) {
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
	 * @param requirement
	 */
	public void loadData(final EObject requirement) {
		super.loadData(requirement);
		this.requirement = requirement;

	addRequirementsRelationTypes(requirement);

    IBusinessQuery incomingQuery = BusinessQueriesProvider.getInstance().getContribution(RequirementsPackage.Literals.REQUIREMENT,
        CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET);
    IBusinessQuery outgoingQuery = BusinessQueriesProvider.getInstance().getContribution(RequirementsPackage.Literals.REQUIREMENT,
            CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__SOURCE);
    if (incomingQuery != null) {
      List<EObject> availableElements = incomingQuery.getAvailableElements(requirement);
      DataLabelProvider leftLabelProvider =  new CapellaTransfertViewerLabelProvider(TransactionHelper.getEditingDomain(availableElements));
      transferTreeViewer.setLeftLabelProvider(leftLabelProvider);
      transferTreeViewer.setLeftInput(new TreeData(availableElements, null));

      Set<EObject> currentElements = new HashSet<EObject>();
      currentElements.addAll(incomingQuery.getCurrentElements(requirement, false));
      currentElements.addAll(outgoingQuery.getCurrentElements(requirement, false));
      DataLabelProvider rightLabelProvider =  new CapellaTransfertViewerLabelProvider(TransactionHelper.getEditingDomain(currentElements)) {
        @Override
        public String getText(Object object) {
          String prefix = ICommonConstants.EMPTY_STRING;
          if (object instanceof CapellaElement) {
            for (EObject referencer : EObjectExt.getReferencers((EObject) object, CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET)) {
              if (referencer instanceof CapellaIncomingRelation) {
            	CapellaIncomingRelation relation = (CapellaIncomingRelation) referencer;
            	RelationType type = relation.getRelationType();
                if (type!= null && relation.getSource() == requirement) {
                  String typeName = type.getReqIFLongName();
                  if (typeName != null && !typeName.isEmpty()) {
                    prefix = "[-> " + typeName + "] ";
                  }
                }
              }
            }
            for (EObject referencer : EObjectExt.getReferencers((EObject) object, CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__SOURCE)) {
              if (referencer instanceof CapellaOutgoingRelation) {
            	CapellaOutgoingRelation relation = (CapellaOutgoingRelation) referencer;
            	RelationType type = relation.getRelationType();
                if (type!= null && relation.getTarget() == requirement) {
                  String typeName = type.getReqIFLongName();
                  if (typeName != null && !typeName.isEmpty()) {
                    prefix = "[<- " + typeName + "] ";
                  }
                }
              }
            }
          }
          return prefix + super.getText(object);
        }
      };
      transferTreeViewer.setRightLabelProvider(rightLabelProvider);
      transferTreeViewer.setRightInput(new TreeData(currentElements, null));
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
