/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.polarsys.capella.common.ui.toolkit.viewers.data.DataContentProvider;
import org.polarsys.capella.common.ui.toolkit.viewers.transfer.AbstractTransferViewer2;
import org.polarsys.capella.common.ui.toolkit.viewers.transfer.TransferTreeListViewer;
import org.polarsys.capella.core.data.capellacore.ModellingArchitecture;
import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.core.ui.properties.fields.AbstractSemanticField;
import org.polarsys.capella.core.ui.properties.sections.AbstractSection;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaTypesFolder;
import org.polarsys.capella.vp.requirements.ui.properties.widgets.FixedPreferredSizeComposite;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;

/**
 *
 */
public abstract class AbstractAllocationSection extends AbstractSection {

  public final static int DEFAULT_EXPAND_LEVEL = 4;
  public final static int DEFAULT_TREE_VIEWER_STYLE = SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER;
  public final static int TRANSFER_TREE_STYLE = AbstractTransferViewer2.SINGLE_SELECTION_VIEWER | AbstractTransferViewer2.ALL_BUTTONS;

  protected Group relationDirectionGroup;
  protected ComboViewer relationTypeComboViewer;
  protected TransferTreeListViewer transferTreeViewer;
  protected EObject capellaElement;

  enum RelationDirectionKind {
    IN,
    OUT,
  }

  protected void createRelationConfig(Group grp) {

	// relation direction radio button group:
	relationDirectionGroup = getWidgetFactory().createGroup(grp, "Relation direction:");
	relationDirectionGroup.setLayout(new GridLayout(2, true));
	// - incoming radio button
	Button incoming = getWidgetFactory().createButton(relationDirectionGroup, "In-link", SWT.RADIO);
	incoming.setData(RelationDirectionKind.IN);
	// - outgoing radio button
	Button outgoing = getWidgetFactory().createButton(relationDirectionGroup, "Out-link", SWT.RADIO);
	outgoing.setData(RelationDirectionKind.OUT);
	outgoing.setSelection(true);

	// relation type combo-box group:
	Group relationTypeGrp = getWidgetFactory().createGroup(grp, "Relation type: ");
	relationTypeGrp.setLayout(new GridLayout());
	relationTypeGrp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	// - combo-box for relation type
	CCombo combo = getWidgetFactory().createCCombo(relationTypeGrp, SWT.BORDER | SWT.READ_ONLY);
	relationTypeComboViewer = new ComboViewer(combo);
	relationTypeComboViewer.setLabelProvider(new LabelProvider() {
	  @Override
	  public String getText(Object element) {
	    return ((RelationType) element).getReqIFLongName();
	  }
	});
  }

  protected void addRequirementsRelationTypes(EObject capellaElement) {
	CCombo combo = relationTypeComboViewer.getCCombo();
	combo.removeAll();
    ModellingArchitecture archi = BlockArchitectureExt.getRootBlockArchitecture(capellaElement);
    if (archi != null) {
      for (ElementExtension extension : archi.getOwnedExtensions()) {
        if (extension instanceof CapellaTypesFolder) {
          CapellaTypesFolder typesfolder = (CapellaTypesFolder) extension;
          for (AbstractType ownedType : typesfolder.getOwnedTypes()) {
            if (ownedType instanceof RelationType) {
              relationTypeComboViewer.add(ownedType);
            }
          }
        }
      }
      if (combo.getItemCount() > 0) {
    	  combo.select(0);
      }
      combo.redraw();
    }
  }

  protected RelationDirectionKind getRelationDirection() {
    for (Control button : relationDirectionGroup.getChildren()) {
      if(((Button) button).getSelection()) {
        return (RelationDirectionKind) button.getData();
      }
    }
    return null;
  }
  
  protected RelationType getRelationType() {
	Object object = relationTypeComboViewer.getElementAt(relationTypeComboViewer.getCCombo().getSelectionIndex());
    if (object instanceof RelationType) {
      return (RelationType) object;
    }
    return null;
  }

  protected void createTransferTreeListViewer(Composite parent) {
    // Intermediate Composite used to avoid SrollBars of parent ScrolledComposite.
    FixedPreferredSizeComposite fixedPreferredSizeComposite = new FixedPreferredSizeComposite(parent, SWT.NONE);
    fixedPreferredSizeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
    
    transferTreeViewer = new TransferTreeListViewer(fixedPreferredSizeComposite, TRANSFER_TREE_STYLE, DEFAULT_TREE_VIEWER_STYLE, DEFAULT_TREE_VIEWER_STYLE, DEFAULT_EXPAND_LEVEL, DEFAULT_EXPAND_LEVEL) {
      @Override
      protected boolean doHandleAddAllButton() {
        handleAddAllButton();
        return super.doHandleAddAllButton();
      }

      @Override
      protected boolean doHandleRemoveAllButton() {
        handleRemoveAllButton();
        return super.doHandleRemoveAllButton();
      }

      @Override
      protected boolean doHandleAddSelectedButton() {
        handleAddSelectedButton();
        return super.doHandleAddSelectedButton();
      }

      @Override
      protected boolean doHandleRemoveSelectedButton() {
        handleRemoveSelectedButton();
        return super.doHandleRemoveSelectedButton();
      }
    };

    transferTreeViewer.setLeftContentProvider(new DataContentProvider());
    transferTreeViewer.setRightContentProvider(new DataContentProvider());

    // Fixed size <=> preferred size of the empty TransferTreeListViewer.
    fixedPreferredSizeComposite.setPreferredSize(transferTreeViewer.getControl().computeSize(SWT.DEFAULT, SWT.DEFAULT));
  }

  protected void handleAddAllButton() {
    addAllocations(transferTreeViewer.getLeftInput().getValidElements());
  }

  protected void handleRemoveAllButton() {
    removeAllocations(transferTreeViewer.getRightInput().getValidElements());
  }

  @SuppressWarnings("unchecked")
  protected void handleAddSelectedButton() {
    addAllocations(((IStructuredSelection) transferTreeViewer.getLeftViewer().getSelection()).toList());
  }

  @SuppressWarnings("unchecked")
  protected void handleRemoveSelectedButton() {
    removeAllocations(((IStructuredSelection) transferTreeViewer.getRightViewer().getSelection()).toList());
  }

  protected void addAllocations(Collection<Object> elts) {
    // do nothing by default
  }

  protected void removeAllocations(Collection<Object> elts) {
    // do nothing by default
  }

  /**
   * 
   */
  public List<AbstractSemanticField> getSemanticFields() {
    List<AbstractSemanticField> abstractSemanticFields = new ArrayList<AbstractSemanticField>();
    return abstractSemanticFields;
  }
}
