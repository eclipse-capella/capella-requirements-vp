/*******************************************************************************
 * Copyright (c) 2016, 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.importer.preferences.attributes;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.polarsys.capella.common.ui.providers.MDEAdapterFactoryLabelProvider;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;

/**
 * @author Joao Barata
 */
public class AttributesSelectionLabelProvider extends DecoratingLabelProvider {
  private Image categoryImage;
  private Image attributeImage;
  
  private ImageDescriptor lockImage;
  private Image lockedCategoryImage;
  private Image lockedAttributeImage;

  /**
	 * Constructor
	 */
	public AttributesSelectionLabelProvider() {
		super(new MDEAdapterFactoryLabelProvider(), PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator());
		// Attribute/Category images.
		attributeImage = AbstractUIPlugin.imageDescriptorFromPlugin("org.polarsys.kitalpha.vp.requirements.model.edit", "icons/full/obj16/StringValueAttribute.gif").createImage();
    categoryImage = AbstractUIPlugin.imageDescriptorFromPlugin("org.polarsys.capella.vp.requirements.ui.importer.preferences", "icons/folder.gif").createImage();

    // Create LOCKED Attribute/Category images.
    lockImage = AbstractUIPlugin.imageDescriptorFromPlugin("org.polarsys.capella.vp.requirements.ui.importer.preferences", "icons/lock.gif");
    lockedCategoryImage = new DecorationOverlayIcon(categoryImage, lockImage, IDecoration.TOP_RIGHT).createImage();
    lockedAttributeImage = new DecorationOverlayIcon(attributeImage, lockImage, IDecoration.TOP_RIGHT).createImage();
	}

  /**
   *
   */
  public void dispose() {
    attributeImage.dispose();
    attributeImage = null;
    categoryImage.dispose();
    categoryImage = null;
    
    lockImage = null;
    lockedCategoryImage.dispose();
    lockedCategoryImage = null;
    lockedAttributeImage.dispose();
    lockedAttributeImage = null;
    super.dispose();
  }

	/**
	 * @see ILabelProvider#getImage(Object)
	 */
	@Override
	public Image getImage(Object element) {
    if (element instanceof AttributeSet) {
      AttributeSet attributeSet = (AttributeSet) element;
      // Attribute case.
      if (attributeSet.getParent() != null) {
        if (((AttributeSet) element).isMandatory()) {
          return lockedAttributeImage;
        }
        return attributeImage;
      }
      // Category case (attributes container).
      if (((AttributeSet) element).isMandatory()) {
        return lockedCategoryImage;
      }
      return categoryImage;

    }
    return super.getImage(element);
	}

  /**
	 * @see ILabelProvider#getText(Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof AttributeSet) {
			return ((AttributeSet) element).getName();
		}
		return super.getText(element);
	}

	/**
	 * @see org.eclipse.jface.viewers.DecoratingLabelProvider#getFont(java.lang.Object)
	 */
  @Override
  public Font getFont(Object element) {
    if (element instanceof AttributeSet && ((AttributeSet) element).isMandatory()) {
      // Display mandatory elements in Italic.
      return JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT);
    }
    return super.getFont(element);
  }

  /**
   * @see org.eclipse.jface.viewers.DecoratingLabelProvider#getForeground(java.lang.Object)
   */
  @Override
  public Color getForeground(Object element) {
    if (element instanceof AttributeSet && ((AttributeSet) element).isMandatory()) {
      // Display mandatory elements in Gray.
      return Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
    }
    return super.getForeground(element);
  }
}
