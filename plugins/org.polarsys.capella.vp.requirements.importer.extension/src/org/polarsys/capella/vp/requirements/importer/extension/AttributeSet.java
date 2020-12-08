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
package org.polarsys.capella.vp.requirements.importer.extension;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Joao Barata
 */
public class AttributeSet {
  private String name;
  private String description;
  private boolean defaultValue = false;
  private boolean mandatory = false;
  private boolean selected = false;
  private AttributeSet parent = null;
  private final Collection<AttributeSet> children;

  /**
   *
   */
  public AttributeSet(String name) {
    this.name = name;
    this.children = new ArrayList<AttributeSet>();
  }

  /**
   *
   */
  public String getName() {
    return name;
  }

  /**
   *
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   *
   */
  public String getDescription() {
    return description;
  }

  /**
   *
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   *
   */
  public boolean isMandatory() {
    return mandatory;
  }

  /**
   *
   */
  public void setMandatory(boolean mandatory) {
    this.mandatory = mandatory;
  }

  /**
   *
   */
  public boolean isSelected() {
    return selected;
  }

  /**
   *
   */
  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  /**
   *
   */
  public boolean defaultValue() {
    return defaultValue;
  }

  /**
   *
   */
  public void setDefaultValue(boolean defaultValue) {
    this.defaultValue = defaultValue;
  }

  /**
   * @return Returns the parent.
   */
  public AttributeSet getParent() {
    return parent;
  }

  /**
   * @param parent The parent to set.
   */
  public void setParent(AttributeSet parent) {
    this.parent = parent;
  }

  /**
   * @return Returns the children.
   */
  public Collection<AttributeSet> getChildren() {
    return children;
  }

  /**
   * Checks if the current item has some children checked.
   * @return <code>true</code> if some children are checked else <code>false</code>.
   */
  public boolean hasChildrenSelected() {
    for (AttributeSet node : children) {
      if (node.selected) {
        // One child is selected. 
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if the current item has all children checked.
   * @return <code>true</code> if all children are checked else <code>false</code>.
   */
  public boolean hasAllChildrenSelected() {
    for (AttributeSet node : children) {
      if (!node.selected) {
        // One child is not selected.
        return false;
      }
    }
    return true;
  }
  
  /**
   * @param node
   */
  public void addChild(AttributeSet node) {
    children.add(node);
    node.setParent(this);
  }
  
  @Override
  public String toString() {
    return "AttributeSet [name=" + name + ", parent=" + parent + "]";
  }
}
