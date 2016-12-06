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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.polarsys.capella.common.mdsofa.common.helper.ExtensionPointHelper;

/**
 * @author Joao Barata
 */
public class AttributesProvider {

  private static AttributesProvider instance = null;
  private List<AttributeSet> contributedAttributes = null;

  private AttributesProvider() {
    //
  }

  public static AttributesProvider getInstance() {
    if (instance == null) {
      instance = new AttributesProvider();
    }
    return instance;
  }
  
  private List<AttributeSet> getContributedCategories() {
    if (contributedAttributes == null) {
      contributedAttributes = new ArrayList<AttributeSet>();
      IEclipsePreferences instanceScope = InstanceScope.INSTANCE.getNode(RequirementsImporterExtensionPlugin.PLUGIN_ID);
      List<IConfigurationElement> attributesProvider = Arrays
          .asList(ExtensionPointHelper.getConfigurationElements(RequirementsImporterExtensionPlugin.PLUGIN_ID,
              RequirementsImporterExtensionPlugin.ATTRIBUTES_PROVIDER_EXTENSION_ID));
      for (IConfigurationElement provider : attributesProvider) {
        AttributeSet attributeSet = new AttributeSet(provider.getAttribute("category"));
        attributeSet.setDescription(provider.getAttribute("description"));
        attributeSet.setMandatory(Boolean.valueOf(provider.getAttribute("mandatory")));
        for (IConfigurationElement attribute : provider.getChildren("attribute")) {
          String name = attribute.getAttribute("name");
          AttributeSet attributeSetChild = new AttributeSet(name);
          boolean defaultValue = Boolean.valueOf(attribute.getAttribute("defaultValue"));
          attributeSetChild.setDefaultValue(defaultValue);
          boolean selected = instanceScope.getBoolean(attributeSet.getName() + "." + name, defaultValue);
          attributeSetChild.setSelected(selected);
          attributeSetChild.setMandatory(attributeSet.isMandatory());

          attributeSet.addChild(attributeSetChild);
        }

        contributedAttributes.add(attributeSet);
      }
    }
    return contributedAttributes;
  }
  
  /**
   * @return The list off {@link AttributeSet}}roots. Each root in the returned list holds a list of attributes.
   */
  public Collection<AttributeSet> getCategories() {
    // Do not cache the attributes because attributes from properties file may change
    List<AttributeSet> result = new ArrayList<AttributeSet>();
    result.addAll(getContributedCategories());
    result.addAll(PropertiesFileAttributesProvider.getInstance().getPropertiesFileCategories());
    return result;
  }
  
  /**
   * 
   * @return all the attributes.
   */
  public Collection<AttributeSet> getAttributes() {
    Collection<AttributeSet> result = new HashSet<AttributeSet>();
    for(AttributeSet category : getCategories()){
      for(AttributeSet attribute : category.getChildren()){
        // TODO check for duplicated attribute here
        result.add(attribute);
      }
    }
    return result;
  }
  
  public Collection<String> getAttributeTypes(){
    Collection<String> result = new HashSet<String>();
    for(AttributeSet attribute : getAttributes()){
      result.add(attribute.getName());
    }
    return result;
  }
}
