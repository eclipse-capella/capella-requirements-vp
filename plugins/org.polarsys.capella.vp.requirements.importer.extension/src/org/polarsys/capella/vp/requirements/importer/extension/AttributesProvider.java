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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.polarsys.capella.common.mdsofa.common.helper.ExtensionPointHelper;

/**
 * @author Joao Barata
 */
public class AttributesProvider {

  private static AttributesProvider instance = null;
  private List<AttributeSet> attributes = null;

  private AttributesProvider() {
    //
  }

  public static AttributesProvider getInstance() {
    if (instance == null) {
      instance = new AttributesProvider();
    }
    return instance;
  }
  
  private List<AttributeSet> getContributors() {
    List<AttributeSet> result = new ArrayList<AttributeSet>();
    IEclipsePreferences instanceScope = InstanceScope.INSTANCE.getNode(RequirementsImporterExtensionPlugin.PLUGIN_ID);
    List<IConfigurationElement> attributesProvider =
        Arrays.asList(ExtensionPointHelper.getConfigurationElements(RequirementsImporterExtensionPlugin.PLUGIN_ID, RequirementsImporterExtensionPlugin.ATTRIBUTES_PROVIDER_EXTENSION_ID));
    for (IConfigurationElement provider : attributesProvider) {
      AttributeSet attributeSet = new AttributeSet(provider.getAttribute("category"));
      String id = provider.getAttribute("id");
      attributeSet.setId(id);
      attributeSet.setDescription(provider.getAttribute("description"));
      attributeSet.setMandatory(Boolean.valueOf(provider.getAttribute("mandatory")));

      for (IConfigurationElement attribute : provider.getChildren("attribute")) {
        String name = attribute.getAttribute("name");
        AttributeSet attributeSetChild = new AttributeSet(name);
        boolean defaultValue = Boolean.valueOf(attribute.getAttribute("defaultValue"));
        attributeSetChild.setDefaultValue(defaultValue);
        boolean selected = instanceScope.getBoolean(id + "." + name, defaultValue);
        attributeSetChild.setSelected(selected);
        attributeSetChild.setMandatory(attributeSet.isMandatory());

        attributeSet.addChild(attributeSetChild);
      }

      result.add(attributeSet);
    }
    return result;
  }
  
  private List<AttributeSet> loadContributors(List<URI> propertiesFiles) {
    List<AttributeSet> result = new ArrayList<AttributeSet>();

    for (URI propertiesFile : propertiesFiles) {
      String filepath = propertiesFile.toFileString();
      if (filepath != null) {
        File file = new File(filepath);
        if (file.exists()) {
          try {
            FileInputStream stream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(stream);
            for (Entry<Object, Object> entry : properties.entrySet()) {
              String key = (String) entry.getKey();
              String value = (String) entry.getValue();

              // TODO to be implemented
            }
            stream.close();
          } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
          } catch (IOException ex) {
            System.err.println(ex.getMessage());
          }
        } else {
          System.out.println("Invalid file path: " + filepath); //$NON-NLS-1$
        }
      } else {
        System.out.println("Invalid file path"); //$NON-NLS-1$
      }
    }

    return result;
  }

  public List<AttributeSet> getAttributes() {
    if (attributes == null) {
     attributes = getContributors();

     List<URI> propertiesFiles = PropertiesFileProvider.getInstance().getPropertiesFiles();
     attributes.addAll(loadContributors(propertiesFiles));
    }
    return attributes;
  }
}
