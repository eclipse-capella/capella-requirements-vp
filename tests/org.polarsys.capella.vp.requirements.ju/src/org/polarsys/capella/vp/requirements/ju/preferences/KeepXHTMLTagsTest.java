/**
 *  Copyright (c) 2021 THALES GLOBAL SERVICES.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */
package org.polarsys.capella.vp.requirements.ju.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesPlugin;
import org.polarsys.kitalpha.vp.requirements.model.helpers.LabelHelper;

public class KeepXHTMLTagsTest extends BasicTestCase {
  
  private final String BR_TAG = "<xhtml:br/>";
  private String testString = "Test text<xhtml:br/>";
  private IPreferenceStore store = RequirementsPreferencesPlugin.getDefault().getPreferenceStore();
  
  @Override
  public void test() throws Exception {
    testWithTags();
    testWithoutTags();
  }
  
  public void testWithTags() {
    store.setValue(RequirementsPreferencesConstants.REQUIREMENT_KEEP_XHTML_TAGS, true);
    String result = LabelHelper.transformHTMLToTextWithLineFeed(testString);
    assertTrue(result.indexOf(BR_TAG) >= 0);
  }
  
  public void testWithoutTags() {
    store.setValue(RequirementsPreferencesConstants.REQUIREMENT_KEEP_XHTML_TAGS, false);
    String result = LabelHelper.transformHTMLToTextWithLineFeed(testString);
    assertTrue(result.indexOf(BR_TAG) < 0);
  }

}
