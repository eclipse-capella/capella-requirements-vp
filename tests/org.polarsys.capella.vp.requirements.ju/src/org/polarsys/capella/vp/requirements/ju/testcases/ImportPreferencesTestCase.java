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
package org.polarsys.capella.vp.requirements.ju.testcases;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.util.URI;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;
import org.polarsys.capella.vp.requirements.importer.extension.AttributesProvider;
import org.polarsys.capella.vp.requirements.importer.extension.ReqImporterPreferencesUtil;
import org.polarsys.capella.vp.requirements.importer.extension.RequirementsImporterExtensionPlugin;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;

/**
 * Test requirement import preferences (contribution mechanism, default attributes selection, mandatory selection,
 * behavior when an attribute is contributed by .properties files).
 */
public class ImportPreferencesTestCase extends BasicTestCase {
  public static final String FILE_CONTENT = "Attribute1:true\nAttribute2:false\n";
  public static final String ATTRIBUTE1 = "Attribute1";
  public static final String ATTRIBUTE2 = "Attribute2";

  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestCase#test()
   */
  @Override
  public void test() throws Exception {
    final NullProgressMonitor npm = new NullProgressMonitor();
    // Clear preference node (JUnit should be launch on a clean workspace ... but in the case of).
    IEclipsePreferences instanceScope = InstanceScope.INSTANCE.getNode(RequirementsImporterExtensionPlugin.PLUGIN_ID);
    instanceScope.clear();
    //
    // Create .properties files.
    //
    // Workspace file - create a container Project.
    IProject importPropertiesProject = ResourcesPlugin.getWorkspace().getRoot().getProject("ImportPropertiesProject");
    importPropertiesProject.create(npm);
    importPropertiesProject.open(npm);
    // Workspace file - create an IFile and fill it.
    IFile workspaceFile = importPropertiesProject.getFile("WorkspaceFile.properties");
    InputStream workspacePropertiesFileContent = new ByteArrayInputStream(
        FILE_CONTENT.getBytes(StandardCharsets.UTF_8));
    workspaceFile.create(workspacePropertiesFileContent, true, npm);
    // Classic file system file.
    File classicFile = File.createTempFile("ClassicFile", ".properties");
    classicFile.deleteOnExit();
    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(classicFile));
    osw.write(FILE_CONTENT);
    osw.close();
    //
    // Reference both .properties files in preferences.
    //
    Collection<URI> propertiesFileURIs = new ArrayList<URI>();
    propertiesFileURIs.add(URI.createPlatformResourceURI(workspaceFile.getFullPath().toString(), true));
    propertiesFileURIs.add(URI.createFileURI(classicFile.getAbsolutePath()));
    // Write property files list in preferences.
    String value = ReqImporterPreferencesUtil.serializePropertyFilesPreference(propertiesFileURIs);
    instanceScope.put(RequirementsPreferencesConstants.REQUIREMENT_PROPERTIES_FILES, value);

    //
    // Perform tests
    //
    Collection<String> selectedAttributes = null;

    // No attribute is selected in preferences -> only default attributes (from Extension points and files) shall be
    // selected.
    AttributesProvider.invalidateModel();
    selectedAttributes = AttributesProvider.getInstance().getSelectedAttributeTypes();
    assertTrue(selectedAttributes.containsAll(getDefaultContributedAttributes()));
    assertTrue(selectedAttributes.containsAll(getMandatoryContributedAttributes()));
    assertTrue(selectedAttributes.contains(ATTRIBUTE1));
    assertFalse(selectedAttributes.contains(ATTRIBUTE2));

    // Simulate selection of Attribute2 from workspace file only -> Attribute2 shall not be selected since Attribute2
    // from classic file is not selected.
    instanceScope.putBoolean(workspaceFile.getName() + "." + ATTRIBUTE2, true);
    AttributesProvider.invalidateModel();
    selectedAttributes = AttributesProvider.getInstance().getSelectedAttributeTypes();
    assertTrue(selectedAttributes.containsAll(getDefaultContributedAttributes()));
    assertTrue(selectedAttributes.containsAll(getMandatoryContributedAttributes()));
    assertTrue(selectedAttributes.contains(ATTRIBUTE1));
    assertFalse(selectedAttributes.contains(ATTRIBUTE2));

    // Simulate selection of Attribute2 from classic file only -> now Attribute2 shall be selected since Attribute2 from
    // both sources is selected.
    instanceScope.putBoolean(classicFile.getName() + "." + ATTRIBUTE2, true);
    AttributesProvider.invalidateModel();
    selectedAttributes = AttributesProvider.getInstance().getSelectedAttributeTypes();
    assertTrue(selectedAttributes.containsAll(getDefaultContributedAttributes()));
    assertTrue(selectedAttributes.containsAll(getMandatoryContributedAttributes()));
    assertTrue(selectedAttributes.contains(ATTRIBUTE1));
    assertTrue(selectedAttributes.contains(ATTRIBUTE2));
  }

  /**
   * Collect names of contributed attributes (by extension point) which must be selected by default.
   * 
   * @return
   */
  public List<String> getDefaultContributedAttributes() {
    List<AttributeSet> contributedCategories = ReqImporterPreferencesUtil.loadContributedCategories();
    List<String> result = new ArrayList<String>();
    for (AttributeSet category : contributedCategories) {
      for (AttributeSet attribute : category.getChildren()) {
        // Is attribute selected by default ?
        if (attribute.defaultValue()) {
          result.add(attribute.getName());
        }
      }
    }
    return result;
  }

  /**
   * Collect names of contributed attributes (by extension point) which must be selected mandatorily.
   * 
   * @return
   */
  public List<String> getMandatoryContributedAttributes() {
    List<AttributeSet> contributedCategories = ReqImporterPreferencesUtil.loadContributedCategories();
    List<String> result = new ArrayList<String>();
    for (AttributeSet category : contributedCategories) {
      for (AttributeSet attribute : category.getChildren()) {
        // Is it a mandatory attribute ?
        if (attribute.isMandatory()) {
          result.add(attribute.getName());
        }
      }
    }
    return result;
  }
}
