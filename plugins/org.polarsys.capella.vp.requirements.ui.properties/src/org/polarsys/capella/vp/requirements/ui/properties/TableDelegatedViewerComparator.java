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
package org.polarsys.capella.vp.requirements.ui.properties;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;

public class TableDelegatedViewerComparator extends ViewerComparator {
  
  private int columnIndex;
  
  private boolean descending;

  public TableDelegatedViewerComparator() {
    this.columnIndex = 0;
    descending = true;
  }

  public int getDirection() {
    return descending ? SWT.DOWN : SWT.UP;
  }

  public void setColumn(int column) {
    if (column == this.columnIndex) {
      // Same column as last sort; toggle the direction
      descending = !descending;
    } else {
      // New column; do an ascending sort
      this.columnIndex = column;
      descending = true;
    }
  }

  @Override
  public int compare(Viewer viewer, Object o1, Object o2) {
    int rc = 0;

    CellLabelProvider provider = ((TableViewer) viewer).getLabelProvider(columnIndex);
    if (provider instanceof ILabelProvider) {
      ILabelProvider labelProvider = (ILabelProvider) provider;
      String s1 = labelProvider.getText(o1);
      String s2 = labelProvider.getText(o2);
      rc = s2.compareTo(s1);
    }

    // if descending order, flip the direction
    if (descending) {
      rc = -rc;
    }
    return rc;
  }
}
