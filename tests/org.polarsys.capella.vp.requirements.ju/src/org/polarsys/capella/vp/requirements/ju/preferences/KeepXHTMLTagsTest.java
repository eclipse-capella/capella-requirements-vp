/*******************************************************************
* Copyright  2021 Thales Global Services SAS
*
* Licensed under the Thales Inner Source Software License:
* Version 1.2, InnerOpen - Distribution Controlled
*
* You may not use this file except in compliance with the License.
* You may obtain a copy of the License at https://gitlab.thalesdigital.io/Tiss-Organization/tiss-licenses
* See the License for the specific language governing permissions and limitations under the License.
*******************************************************************/
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
