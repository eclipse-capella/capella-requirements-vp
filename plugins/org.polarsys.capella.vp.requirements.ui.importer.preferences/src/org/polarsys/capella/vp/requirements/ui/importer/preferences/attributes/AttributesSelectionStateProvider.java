/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes;

import org.eclipse.jface.viewers.ICheckStateProvider;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;

/**
 * @author Joao Barata
 */
public class AttributesSelectionStateProvider implements ICheckStateProvider {

  /**
   * @see org.eclipse.jface.viewers.ICheckStateProvider#isChecked(java.lang.Object)
   */
  @Override
  public boolean isChecked(Object element) {
    if (!(element instanceof AttributeSet)) {
      return false;
    }
    AttributeSet attributeSet = (AttributeSet) element;
    if (attributeSet.getChildren().isEmpty()) {
      // Leaf case (Attribute).
      return attributeSet.isMandatory() || ((AttributeSet) element).isSelected();
    }
    // Category case.
    return attributeSet.hasChildrenSelected();

  }

  /**
   * @see org.eclipse.jface.viewers.ICheckStateProvider#isGrayed(java.lang.Object)
   */
  @Override
  public boolean isGrayed(Object element) {
    if (!(element instanceof AttributeSet)) {
      return false;
    }
    AttributeSet attributeSet = (AttributeSet) element;
    if (attributeSet.getChildren().isEmpty()) {
      // Leaf case (Attribute).
      return false;
    }
    // Category case.
    return !attributeSet.hasAllChildrenSelected();
  }
}
