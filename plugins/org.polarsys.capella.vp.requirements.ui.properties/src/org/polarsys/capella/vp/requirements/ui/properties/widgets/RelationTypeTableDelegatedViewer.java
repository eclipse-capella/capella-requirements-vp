/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.properties.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.capella.core.ui.properties.viewers.ICellEditorProvider;
import org.polarsys.capella.core.ui.properties.viewers.TableDelegatedViewer;
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.capella.vp.requirements.ui.properties.controllers.DiagramIncomingLink;
import org.polarsys.capella.vp.requirements.ui.properties.controllers.DiagramOutgoingLink;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public class RelationTypeTableDelegatedViewer extends TableDelegatedViewer {

  public RelationTypeTableDelegatedViewer(TabbedPropertySheetWidgetFactory widgetFactory,
      ICellEditorProvider cellEditorProvider) {
    super(widgetFactory, cellEditorProvider);
  }

  /**
   * @param colNumber
   * @param labelProvider
   * @return
   */
  protected TableViewerColumn createTableViewerColumn(int colNumber, ColumnLabelProvider labelProvider) {
    if (colNumber == 1) {
      TableViewerColumn viewerColumn = new TableViewerColumn((TableViewer) getColumnViewer(), SWT.NONE);

      viewerColumn.setEditingSupport(new EditingSupport(getColumnViewer()) {

        @Override
        protected void setValue(Object element, final Object value) {
          if (element instanceof AbstractRelation) {
            final AbstractRelation relation = (AbstractRelation) element;
            IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
                RequirementsPackage.eINSTANCE.getAbstractRelation(),
                RequirementsPackage.eINSTANCE.getAbstractRelation_RelationType());
            final List<EObject> availableElements = query.getAvailableElements(relation);
            if (value instanceof Integer && ((Integer) value) >= 0 && availableElements.get((Integer) value) instanceof RelationType) {
              AbstractReadWriteCommand command = new AbstractReadWriteCommand() {
                public void run() {
                  relation.setRelationType((RelationType) availableElements.get((Integer) value));
                }
              };

              if (relation instanceof DiagramOutgoingLink) {
                TransactionHelper.getExecutionManager(((DiagramOutgoingLink) relation).getSource()).execute(command);
              } else if (relation instanceof DiagramIncomingLink) {
                TransactionHelper.getExecutionManager(((DiagramIncomingLink) relation).getTarget()).execute(command);
              } else
                TransactionHelper.getExecutionManager(relation).execute(command);
              
              if (relation instanceof DiagramOutgoingLink) {
                RelationAnnotationHelper.updateAllocation(
                    ((DiagramOutgoingLink) relation).getContainingRepresentation(), relation,
                    ((DiagramOutgoingLink) relation).getId());
              } else if (relation instanceof DiagramIncomingLink) {
                RelationAnnotationHelper.updateAllocation(
                    ((DiagramIncomingLink) relation).getContainingRepresentation(), relation,
                    ((DiagramIncomingLink) relation).getId());
              }
            }
          }
          getViewer().update(element, null);
        }

        @Override
        protected Object getValue(Object element) {
          if (element instanceof AbstractRelation) {
            AbstractRelation relation = (AbstractRelation) element;
            IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
                RequirementsPackage.eINSTANCE.getAbstractRelation(),
                RequirementsPackage.eINSTANCE.getAbstractRelation_RelationType());
            List<EObject> availableElements = query.getAvailableElements(relation);
            if (query.getCurrentElements(relation, false).size() > 0) {
              EObject currentElement = query.getCurrentElements(relation, false).get(0);
              return availableElements.indexOf(currentElement);
            }
          }
          return 0;
        }

        @Override
        protected CellEditor getCellEditor(Object element) {
          List<EObject> relationTypes = new ArrayList<>();
          if (element instanceof AbstractRelation) {
            AbstractRelation relation = (AbstractRelation) element;
            IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
                RequirementsPackage.eINSTANCE.getAbstractRelation(),
                RequirementsPackage.eINSTANCE.getAbstractRelation_RelationType());
            relationTypes.addAll(query.getAvailableElements(relation));
          }
          String[] relationTypeNames = new String[relationTypes.size()];
          for (int i = 0; i < relationTypes.size(); i++) {
            if (relationTypes.get(i) instanceof RelationType)
              relationTypeNames[i] = ((RelationType) relationTypes.get(i)).getReqIFLongName();

          }
          return new ComboBoxCellEditor(_table, relationTypeNames);
        }

        @Override
        protected boolean canEdit(Object element) {
          return true;
        }
      });

      TableColumn column = viewerColumn.getColumn();
      column.setText(getColumnProperties()[colNumber]);
      column.setWidth(DEFAULT_COLUMN_BOUND);
      column.setResizable(true);
      column.setMoveable(true);
      viewerColumn.setLabelProvider(labelProvider);
      return viewerColumn;
    }
    return super.createTableViewerColumn(colNumber, labelProvider);
  }
}
