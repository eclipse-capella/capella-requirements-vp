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

import java.util.List;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;
import org.polarsys.capella.vp.requirements.importer.extension.AttributesProvider;

/**
 * @author Joao Barata
 */
public class SelectionContentProvider implements ITreeContentProvider {
  private static Object[] EMPTY_ARRAY = new Object[0];
  protected CheckboxTreeViewer _viewer = null;

  /**
   * @see IContentProvider#dispose()
   */
  public void dispose() {
    /** no op */
  }

  /**
   * @see IContentProvider#inputChanged(Viewer, Object, Object)
   * @param viewer the viewer
   * @param oldInput the old input element, or <code>null</code> if the viewer did not previously have an input
   * @param newInput the new input element, or <code>null</code> if the viewer does not have an input
   */
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    _viewer = (CheckboxTreeViewer) viewer;
  }

  /**
   * @see ITreeContentProvider#getChildren(Object)
   */
  public Object[] getChildren(Object parentElement) {
    if (parentElement instanceof AttributeSet) {
      AttributeSet node = (AttributeSet) parentElement;
      List<AttributeSet> list = node.getChildren();
      if (list != null)
        return list.toArray();
    }
    return EMPTY_ARRAY;
  }

  /**
   * @see ITreeContentProvider#getParent(Object)
   */
  public Object getParent(Object element) {
    if (element instanceof AttributeSet) {
      return ((AttributeSet) element).getParent();
    }
    return null;
  }

  /**
   * @see ITreeContentProvider#hasChildren(Object)
   */
  public boolean hasChildren(Object element) {
    return getChildren(element).length > 0;
  }

  /**
   * @see IStructuredContentProvider#getElements(Object)
   */
  public Object[] getElements(Object inputElement) {
    return AttributesProvider.getInstance().getAttributes().toArray();
  }
}
