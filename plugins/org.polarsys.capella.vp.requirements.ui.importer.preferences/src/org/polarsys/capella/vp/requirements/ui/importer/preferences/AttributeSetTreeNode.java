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
package org.polarsys.capella.vp.requirements.ui.importer.preferences;

import java.util.Collection;

import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;
import org.polarsys.capella.vp.requirements.importer.extension.AttributesProvider;

/**
 * @author Joao Barata
 */
public class AttributeSetTreeNode extends AttributeSet{

  /**
   *
   */
  public AttributeSetTreeNode(String name) {
    super(name);
  }
  
  public static RootAttributeSetTreeNode createRoot(String name){
    RootAttributeSetTreeNode rootNode = new RootAttributeSetTreeNode(name);
    return rootNode;
  }
  
  private static class RootAttributeSetTreeNode extends AttributeSetTreeNode {

    public RootAttributeSetTreeNode(String name) {
      super(name);
    }
    
    @Override
    public Collection<AttributeSet> getChildren() {
      Collection<AttributeSet> attributes = AttributesProvider.getInstance().getCategories();
      for(AttributeSet attributeSet : attributes){
        addChild(attributeSet);
      }
      return attributes;
    }
    
    @Override
    public boolean isSelected() {
      return false;
    }
  }
}
