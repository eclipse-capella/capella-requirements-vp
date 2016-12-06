/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
public class SelectionCheckStateProvider implements ICheckStateProvider {

  /**
   * @see org.eclipse.jface.viewers.ICheckStateProvider#isChecked(java.lang.Object)
   */
  @Override
  public boolean isChecked(Object element) {
    if (element instanceof AttributeSet) {
      AttributeSet attributeSet = (AttributeSet)element;
      if (attributeSet.getChildren().isEmpty()) {
        return attributeSet.isMandatory() || ((AttributeSet) element).isSelected();
      }
      boolean allChildChecked = true;
      boolean atLeastOneChildChecked = false;
      for (AttributeSet child : attributeSet.getChildren()) {
        if (!child.isSelected()) {
          allChildChecked = false;
        }
        else{
          atLeastOneChildChecked = true;
          break;
        }
      }
      return (allChildChecked || atLeastOneChildChecked);
    }
    return false;
  }

  /**
   * @see org.eclipse.jface.viewers.ICheckStateProvider#isGrayed(java.lang.Object)
   */
  @Override
	public boolean isGrayed(Object element) {
		if (element instanceof AttributeSet) {
			AttributeSet attributeSet = (AttributeSet) element;
			if (!attributeSet.getChildren().isEmpty()) {
				boolean allChildChecked = true;
				boolean allChildUnchecked = true;
				for (AttributeSet child : attributeSet.getChildren()) {
					if (!child.isSelected())
						allChildChecked = false;
					else
						allChildUnchecked = false;
				}
				return !(allChildChecked || allChildUnchecked);
			}
		}
		return false;
	}
}
