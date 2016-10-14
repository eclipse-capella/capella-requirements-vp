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
import java.util.List;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;

/**
 * @author Joao Barata
 */
public class PropertiesFileProvider {

  private static PropertiesFileProvider instance = null;
  private List<URI> propertiesFiles = null;

  private PropertiesFileProvider() {
    //
  }

  public static PropertiesFileProvider getInstance() {
    if (instance == null) {
      instance = new PropertiesFileProvider();
    }
    return instance;
  }
  
  private List<URI> getContributors() {
    List<URI> result = new ArrayList<URI>();

    IEclipsePreferences instanceScope = InstanceScope.INSTANCE.getNode(RequirementsImporterExtensionPlugin.PLUGIN_ID);
    String values = instanceScope.get("", ICommonConstants.EMPTY_STRING);
    if (values != null && !values.isEmpty()) {
      for (String value : values.split(";")) {
        if (value != null && !value.isEmpty()) {
          result.add(URI.createFileURI(value));
        }
      }
    }

    return result;
  }

  public void addContributor(URI contributor) {
    propertiesFiles.add(contributor);
  }

  public List<URI> getPropertiesFiles() {
    if (propertiesFiles == null) {
      propertiesFiles = getContributors();
    }
    return propertiesFiles;
  }
}
