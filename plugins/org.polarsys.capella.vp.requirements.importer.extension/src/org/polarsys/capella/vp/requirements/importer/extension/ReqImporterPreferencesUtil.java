/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;
import org.polarsys.capella.common.mdsofa.common.helper.ExtensionPointHelper;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesPlugin;

public class ReqImporterPreferencesUtil {
  
  /**
   * Compute preference key for attribute selection
   * @param attribute
   * @return
   */
  public static String getPreferenceKey(AttributeSet attribute){
    AttributeSet category = attribute.getParent();
    Assert.isNotNull(category);
    
    String key = category.getName() + "." + attribute.getName();
    return key;
  }

  public static String serializePropertyFilesPreference(Collection<URI> propertyFilesURIs) {
    StringBuilder value = new StringBuilder();
    for (URI uri : propertyFilesURIs) {
      value.append(uri.toString() + ";"); 
    }
    return value.toString();
  }

  public static List<URI> deserializePropertyFilesPreference(String propertyFilesString) {
    if (propertyFilesString == null || propertyFilesString.isEmpty()) {
      return Collections.emptyList();
    }
    List<URI> uris = new ArrayList<URI>();
    for (String value : propertyFilesString.split(";")) {
      if (value != null && !value.isEmpty()) {
        uris.add(URI.createURI(value));
      }
    }
    return uris;
  }

  public static List<AttributeSet> loadPropertiesFileAttributes(List<URI> propertiesFiles) {    
    List<AttributeSet> result = new ArrayList<AttributeSet>();
    IPreferenceStore store = RequirementsPreferencesPlugin.getDefault().getPreferenceStore();
    for (URI propertiesFile : propertiesFiles) {
      // Get a platform path or an absolute path.
      String absoluteFilePath = null;
      if (propertiesFile.isPlatformResource()) {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IFile workspaceFile = root.getFile(new Path(propertiesFile.toPlatformString(true)));
        IPath workspaceFilePath = workspaceFile.getLocation();
        if (workspaceFilePath != null) {
          absoluteFilePath = workspaceFilePath.toString();
        }
      } else if (propertiesFile.isFile()) {
        absoluteFilePath = propertiesFile.toFileString();
      }
      if (absoluteFilePath != null) {
        File file = new File(absoluteFilePath);
        if (file.exists()) {
          try (FileInputStream stream = new FileInputStream(file)) {
            Properties properties = new Properties();
            properties.load(stream);
            String fileName = file.getName();
            AttributeSet attrSet = new AttributeSet(fileName);
            for (Entry<Object, Object> entry : properties.entrySet()) {
              String key = (String) entry.getKey();
              String value = (String) entry.getValue();
              AttributeSet childAttr = new AttributeSet(key);
              attrSet.addChild(childAttr);
              Boolean defaultValue = Boolean.valueOf(value);
              childAttr.setDefaultValue(defaultValue);
              String akey = getPreferenceKey(childAttr);
              boolean selected = store.contains(akey) ? store.getBoolean(akey) : defaultValue;
              childAttr.setSelected(selected);
            }
            result.add(attrSet);
          } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
          } catch (IOException ex) {
            System.err.println(ex.getMessage());
          }
        } else {
          System.out.println("Invalid file path: " + absoluteFilePath); //$NON-NLS-1$
        }
      } else {
        System.out.println("Invalid file path"); //$NON-NLS-1$
      }
    }
    return result;
  }

  public static List<URI> getPropertyFilesFromPreferences() {
    IPreferenceStore store = RequirementsPreferencesPlugin.getDefault().getPreferenceStore();
    String values = store.getString(RequirementsPreferencesConstants.REQUIREMENT_PROPERTIES_FILES_KEY);
    return deserializePropertyFilesPreference(values);
  }

  public static List<AttributeSet> loadContributedCategories() {
    List<AttributeSet> contributedAttributes = new ArrayList<AttributeSet>();
    IPreferenceStore store = RequirementsPreferencesPlugin.getDefault().getPreferenceStore();
    IConfigurationElement[] attributesProvider = ExtensionPointHelper.getConfigurationElements(RequirementsImporterExtensionPlugin.PLUGIN_ID,
            RequirementsImporterExtensionPlugin.ATTRIBUTES_PROVIDER_EXTENSION_ID);
    for (IConfigurationElement provider : attributesProvider) {
      AttributeSet attributeSet = new AttributeSet(provider.getAttribute("category"));
      attributeSet.setDescription(provider.getAttribute("description"));
      attributeSet.setMandatory(Boolean.valueOf(provider.getAttribute("mandatory")));
      for (IConfigurationElement attribute : provider.getChildren("attribute")) {
        String name = attribute.getAttribute("name");
        AttributeSet attributeSetChild = new AttributeSet(name);
        attributeSet.addChild(attributeSetChild);
        boolean defaultValue = Boolean.valueOf(attribute.getAttribute("defaultValue"));
        attributeSetChild.setDefaultValue(defaultValue);
        String akey = getPreferenceKey(attributeSetChild);
        boolean selected = store.contains(akey) ? store.getBoolean(akey) : defaultValue;
        attributeSetChild.setSelected(selected);
        attributeSetChild.setMandatory(attributeSet.isMandatory());
      }
  
      contributedAttributes.add(attributeSet);
    }
    return contributedAttributes;
  }
}
