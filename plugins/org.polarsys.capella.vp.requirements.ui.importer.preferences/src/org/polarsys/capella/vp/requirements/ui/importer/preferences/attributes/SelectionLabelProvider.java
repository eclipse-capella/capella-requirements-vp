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

import org.eclipse.emf.common.util.URI;
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
import org.polarsys.capella.core.ui.toolkit.viewers.CapellaElementLabelProvider;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;

/**
 * @author Joao Barata
 */
//TODO split this class and it internal to each section
public class SelectionLabelProvider extends DecoratingLabelProvider {

  private ImageDescriptor lockImage;
  private Image folderImage;
  private Image attributeImage;
  private Image overlayedFolderImage;
  private Image overlayedAttributeImage;
  private Image fileImage;

  /**
	 * Constructor
	 */
	public SelectionLabelProvider() {
		super(new CapellaElementLabelProvider(), PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator());
		lockImage = AbstractUIPlugin.imageDescriptorFromPlugin("org.polarsys.capella.vp.requirements.ui.importer.preferences", "icons/lock.gif");
		attributeImage = AbstractUIPlugin.imageDescriptorFromPlugin("org.polarsys.kitalpha.vp.requirements.model.edit", "icons/full/obj16/StringValueAttribute.gif").createImage();
    folderImage = AbstractUIPlugin.imageDescriptorFromPlugin("org.polarsys.capella.vp.requirements.ui.importer.preferences", "icons/folder.gif").createImage();
    fileImage = AbstractUIPlugin.imageDescriptorFromPlugin("org.polarsys.capella.vp.requirements.ui.importer.preferences", "icons/file.png").createImage();
    overlayedFolderImage = new DecorationOverlayIcon(folderImage, lockImage, IDecoration.TOP_RIGHT).createImage();
    overlayedAttributeImage = new DecorationOverlayIcon(attributeImage, lockImage, IDecoration.TOP_RIGHT).createImage();
	}

  /**
   *
   */
  public void dispose() {
    attributeImage.dispose();
    attributeImage = null;
    overlayedFolderImage.dispose();
    overlayedFolderImage = null;
    overlayedAttributeImage.dispose();
    overlayedAttributeImage = null;
    lockImage = null;
    fileImage.dispose();
    fileImage = null;
    super.dispose();
  }

	/**
	 * @see ILabelProvider#getImage(Object)
	 */
	@Override
	public Image getImage(Object element) {
	  if (element instanceof AttributeSet) {
	    if (((AttributeSet) element).getChildren().isEmpty()) {
	      if (((AttributeSet) element).isMandatory()) {
	        return overlayedAttributeImage;
	      }
        return attributeImage;
	    }

	    if (((AttributeSet) element).isMandatory()) {
        return overlayedFolderImage;
      }
      return folderImage;
	  }else if(element instanceof URI){
	    return fileImage;
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
		}else if(element instanceof URI){
		  return ((URI)element).toString();
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.jface.viewers.DecoratingLabelProvider#getFont(java.lang.Object)
	 */
  @Override
  public Font getFont(Object element) {
    if (element instanceof AttributeSet && ((AttributeSet) element).isMandatory()) {
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
      return Display.getCurrent().getSystemColor(SWT.COLOR_GRAY);
    }
    return super.getForeground(element);
  }
}
