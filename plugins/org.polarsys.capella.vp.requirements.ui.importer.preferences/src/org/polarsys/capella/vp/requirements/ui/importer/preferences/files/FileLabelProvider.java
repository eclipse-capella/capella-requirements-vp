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
package org.polarsys.capella.vp.requirements.ui.importer.preferences.files;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class FileLabelProvider extends LabelProvider {
  private Image fileImage;
  
  public FileLabelProvider() {
    fileImage = AbstractUIPlugin.imageDescriptorFromPlugin("org.polarsys.capella.vp.requirements.ui.importer.preferences", "icons/file.png").createImage();
  }
  
  @Override
  public Image getImage(Object element) {
    if (element instanceof URI) {
      return fileImage;
    }
    return super.getImage(element);
  }
  
  public void dispose() {
    fileImage.dispose();
    fileImage = null;
    super.dispose();
  }
}