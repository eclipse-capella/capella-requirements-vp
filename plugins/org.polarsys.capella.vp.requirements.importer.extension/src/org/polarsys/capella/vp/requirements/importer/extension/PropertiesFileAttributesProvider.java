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
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;

/**
 * @author Joao Barata
 */
public class PropertiesFileAttributesProvider {

  private static PropertiesFileAttributesProvider instance = null;
  private List<URI> propertiesFiles = null;
  private List<AttributeSet> propertiesFileAttributes = null;

  private PropertiesFileAttributesProvider() {
    //
  }

  public static PropertiesFileAttributesProvider getInstance() {
    if (instance == null) {
      instance = new PropertiesFileAttributesProvider();
    }
    return instance;
  }
  
  private List<URI> getPreferencePropertiesFiles() {
    List<URI> result = new ArrayList<URI>();

    IEclipsePreferences instanceScope = InstanceScope.INSTANCE.getNode(RequirementsImporterExtensionPlugin.PLUGIN_ID);
    String values = instanceScope.get("requirement.properties.files", ICommonConstants.EMPTY_STRING);
    if (values != null && !values.isEmpty()) {
      for (String value : values.split(";")) {
        if (value != null && !value.isEmpty()) {
          result.add(URI.createFileURI(value));
        }
      }
    }
    return result;
  }

  public boolean addContributor(URI propertiesFileURI) {
    boolean isAdded = propertiesFiles.add(propertiesFileURI);
    if(isAdded){
      // Keep the list of attributes up to date
      getPropertiesFileCategories().addAll(loadPropertiesFileAttributes(Collections.singletonList(propertiesFileURI)));
    }
    return isAdded;
  }
  
  public boolean removeContributor(URI propertiesFileURI) {
    boolean isRemoved = propertiesFiles.remove(propertiesFileURI);
    if(isRemoved){
      getPropertiesFileCategories().remove(toAttributeSet(propertiesFileURI));
    }
    return isRemoved;
  }

  public List<URI> getPropertiesFiles() {
    if (propertiesFiles == null) {
      propertiesFiles = getPreferencePropertiesFiles();
    }
    return propertiesFiles;
  }
  
  public List<AttributeSet> getPropertiesFileCategories(){
    if(propertiesFileAttributes == null){
      propertiesFileAttributes = new ArrayList<AttributeSet>();
      propertiesFileAttributes.addAll(loadPropertiesFileAttributes(getPropertiesFiles()));
    }
    return propertiesFileAttributes;
  }
  
  private List<AttributeSet> loadPropertiesFileAttributes(List<URI> propertiesFiles) {
    List<AttributeSet> result = new ArrayList<AttributeSet>();
    IEclipsePreferences instanceScope = InstanceScope.INSTANCE.getNode(RequirementsImporterExtensionPlugin.PLUGIN_ID);
    for (URI propertiesFile : propertiesFiles) {
      String filepath = propertiesFile.toFileString();
      if (filepath != null) {
        File file = new File(filepath);
        if (file.exists()) {
          try {
            FileInputStream stream = new FileInputStream(file);
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
              boolean selected = instanceScope.getBoolean(fileName + "." + key, defaultValue);
              childAttr.setSelected(selected);
            }
            result.add(attrSet);
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
  
  private AttributeSet toAttributeSet(URI uri){
    return new AttributeSet(uri.lastSegment());
  }
}
