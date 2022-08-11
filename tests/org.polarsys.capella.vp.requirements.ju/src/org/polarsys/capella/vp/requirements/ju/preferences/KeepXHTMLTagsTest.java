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
import org.polarsys.capella.core.transition.common.context.TransitionContext;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesPlugin;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFTextParser;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;
import org.polarsys.kitalpha.vp.requirements.model.helpers.LabelHelper;

public class KeepXHTMLTagsTest extends BasicTestCase {
  
  private final String DIV = "div";
  private final String BR_TAG = "<br/>";
  private final String DIV_TAG = "<div>";
  private final String DIV_END_TAG = "/div";
  private String testString = "<xhtml:div>Test text <xhtml:br/></xhtml:div>";
  private String testQuotes = "<xhtml:div>Capella &quot;&lt;is&gt;&quot; great <xhtml:a href=\"to%20.pdf\">here</xhtml:a></xhtml:div>";
  private String expectedResultWithoutTags= "Capella \"<is>\" great here";
  private String expectedResultWithTags = "<div>Capella \"&lt;is&gt;\" great <a href=\"to%20.pdf\">here</a></div>";
  private IPreferenceStore store = RequirementsPreferencesPlugin.getDefault().getPreferenceStore();
  
  @Override
  public void test() throws Exception {
    testWithTags();
    testWithoutTags();
  }
  
  public void testWithTags() {
    store.setValue(RequirementsPreferencesConstants.REQUIREMENT_KEEP_XHTML_TAGS, true);
    ReqIFTextParser parser = new ReqIFTextParser(new TransitionContext());
    Requirement dummyRequirement = RequirementsFactory.eINSTANCE.createRequirement();
    String result = parser.transformToHTML(testString, dummyRequirement);
    
    assertTrue(result.indexOf(BR_TAG) >= 0);
    assertEquals(result.indexOf(DIV_TAG), 0);
    assertTrue(result.indexOf(DIV_END_TAG) >= 0);
    
    String resultQuotes = parser.transformToHTML(testQuotes, dummyRequirement);
    assertEquals(resultQuotes, expectedResultWithTags);
  }
  
  public void testWithoutTags() {
    store.setValue(RequirementsPreferencesConstants.REQUIREMENT_KEEP_XHTML_TAGS, false);
    String result = LabelHelper.transformHTMLToText(testString, DIV);
    assertTrue(result.indexOf(BR_TAG) < 0);
    assertTrue(result.indexOf(DIV_TAG) < 0);
    assertTrue(result.indexOf(DIV_END_TAG) < 0);
    
    String resultTestWithQuotes = LabelHelper.transformHTMLToText(testQuotes);
    assertEquals(resultTestWithQuotes, expectedResultWithoutTags);
  }

}
