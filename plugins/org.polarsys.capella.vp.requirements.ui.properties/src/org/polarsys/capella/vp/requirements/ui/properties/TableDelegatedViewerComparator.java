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

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.provider.RequirementsItemProviderDecoratorAdapterFactory;


public class TableDelegatedViewerComparator extends ViewerComparator {
  private int propertyIndex;
  private static final int DESCENDING = 1;
  private int direction = DESCENDING;

  public TableDelegatedViewerComparator() {
          this.propertyIndex = 0;
          direction = DESCENDING;
  }

  public int getDirection() {
          return direction == 1 ? SWT.DOWN : SWT.UP;
  }

  public void setColumn(int column) {
          if (column == this.propertyIndex) {
                  // Same column as last sort; toggle the direction
                  direction = 1 - direction;
          } else {
                  // New column; do an ascending sort
                  this.propertyIndex = column;
                  direction = DESCENDING;
          }
  }
  
  @Override
  /**
   * This makes sure that nodes with children are always on top
   * {@inheritDoc}
   */
  public int category(Object o) {
    if (o instanceof IMarker) {
      return 100;
    }
    return 0;
  }

  @Override
  public int compare(Viewer viewer, Object o1, Object o2) {
      int rc = 0;
      
      int cat1 = category(o1);
      int cat2 = category(o2);
      if (cat1 != cat2) {
        rc = cat1 - cat2;
      }
      
      // requirements comparison
      if ((o1 instanceof Requirement) && (o2 instanceof Requirement)){
           // extract req o1's label
           IItemLabelProvider adapted1 = (IItemLabelProvider) (new RequirementsItemProviderDecoratorAdapterFactory())
                    .adapt(o1, IItemLabelProvider.class);
           String s1 = adapted1.getText(o1);
           
           // extract req o2's label
           IItemLabelProvider adapted2 = (IItemLabelProvider) (new RequirementsItemProviderDecoratorAdapterFactory())
                    .adapt(o2, IItemLabelProvider.class);
           String s2 = adapted2.getText(o2);
           
           if (s1 == null) {
               s1 = ICommonConstants.EMPTY_STRING;
           }
           if (s2 == null) {
               s2 = ICommonConstants.EMPTY_STRING;
           }
           
           rc = s1.compareTo(s2);
      }
     
      // capella elements comparison
      if ((o1 instanceof CapellaElement) && (o2 instanceof CapellaElement)) {
          rc = o1.toString().compareTo(o2.toString());
      }
     
      // relation types comparison
      if ((o1 instanceof AbstractRelation) && (o2 instanceof AbstractRelation)){
          rc = o1.toString().compareTo(o2.toString());
      }
      
      //if descending order, flip the direction
      if(direction == DESCENDING) {
        rc = -rc;
      }
      return rc;
  }
}
