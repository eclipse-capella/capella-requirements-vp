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
  private Collection<AttributeSet> children = null;

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
   * @return <code>True</code> if some children are checked else <code>false</code>.
   */
  public boolean hasChildrenSelected() {
    boolean result = false;

    for (AttributeSet node : children) {
      result |= node.selected;
    }

    return result;
  }

  /**
   * Checks if the current item has all children checked.
   * @return <code>True</code> if all children are checked else <code>false</code>.
   */
  public boolean hasAllChildrenSelected() {
    boolean result = true;

    for (AttributeSet node : children) {
      result &= node.selected;
    }

    return result;
  }
  
  /**
   * @param node
   */
  public void addChild(AttributeSet node) {
    if (children == null)
      children = new ArrayList<AttributeSet>();
    children.add(node);
    node.setParent(this);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AttributeSet other = (AttributeSet) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    return "AttributeSet [name=" + name + ", parent=" + parent + "]";
  }
}
