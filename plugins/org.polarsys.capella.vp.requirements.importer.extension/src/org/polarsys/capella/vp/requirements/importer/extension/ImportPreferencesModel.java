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
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;

/**
 * @author Joao Barata
 */
public class ImportPreferencesModel {

  // Selected properties files.
  private final List<URI> propertiesFiles;

  // Attributes.
  private final List<AttributeSet> categories;

  public ImportPreferencesModel() {
    propertiesFiles = new ArrayList<URI>(ReqImporterPreferencesUtil.getPropertyFilesFromPreferences());
    categories = new ArrayList<AttributeSet>();
    categories.addAll(ReqImporterPreferencesUtil.loadContributedCategories());
    categories.addAll(ReqImporterPreferencesUtil.loadPropertiesFileAttributes(propertiesFiles));
  }

  public void addPropertyFiles(List<URI> newPropertyFileURIs) {
    categories.addAll(ReqImporterPreferencesUtil.loadPropertiesFileAttributes(newPropertyFileURIs));
    propertiesFiles.addAll(newPropertyFileURIs);
  }

  /**
   * Returns names of attributes selected in the preference page.
   * 
   * @return
   */
  public Collection<String> getSelectedAttributeTypes() {
    Collection<String> allAttributesName = getAttributeTypes();
    // Remove attributes which are not selected everywhere
    for (AttributeSet attribute : getAttributes()) {
      if (!attribute.isMandatory() && !attribute.isSelected()) {
        allAttributesName.remove(attribute.getName());
      }
    }
    return allAttributesName;
  }

  /**
   * 
   * @return all the attributes.
   */
  public List<AttributeSet> getAttributes() {
    List<AttributeSet> result = new ArrayList<AttributeSet>();
    for (AttributeSet category : getCategories()) {
      result.addAll(category.getChildren());
    }
    return result;
  }

  public Collection<String> getAttributeTypes() {
    Collection<String> result = new HashSet<String>();
    for (AttributeSet attribute : getAttributes()) {
      result.add(attribute.getName());
    }
    return result;
  }

  public List<AttributeSet> getCategories() {
    return Collections.unmodifiableList(categories);
  }

  public List<URI> getPropertiesFiles() {
    return Collections.unmodifiableList(propertiesFiles);
  }

  public void removePropertyFile(URI oldPropertyFileURI) {
    Iterator<AttributeSet> it = categories.iterator();
    while (it.hasNext()) {
      AttributeSet as = it.next();
      if (as.getName().equals(oldPropertyFileURI.lastSegment())) {
        it.remove();
      }
    }
    propertiesFiles.remove(oldPropertyFileURI);
  }

  public void resetToDefaultSelection() {
    for (AttributeSet category : categories) {
      for (AttributeSet att : category.getChildren()) {
        att.setSelected(att.defaultValue() || att.isMandatory());
      }
    }
  }

  public void selectAll(boolean selected) {
    for (AttributeSet category : categories) {
      for (AttributeSet att : category.getChildren()) {
        att.setSelected(selected || att.isMandatory());
      }
    }
  }
}
