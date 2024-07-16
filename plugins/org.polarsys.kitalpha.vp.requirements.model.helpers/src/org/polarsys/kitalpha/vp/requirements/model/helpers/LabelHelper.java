/**
 *  Copyright (c) 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.kitalpha.vp.requirements.model.helpers;

import org.apache.commons.lang.StringEscapeUtils;
import org.eclipse.emf.common.util.URI;
import org.polarsys.capella.vp.requirements.importer.extension.ReqImporterPreferencesUtil;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;

public class LabelHelper {
  private LabelHelper() {
    // Private constructor
  }

  public static String unescape(String content) {
    return StringEscapeUtils.unescapeHtml(content);
  }

  public static String toOneLine(String content) {
    return content.replace("\r\n", " ").replace("\n", " ").trim();
  }
	  
  public static String transformHTMLToText(String content) {
    return toOneLine(transformHTMLToTextWithLineFeed(content));
  }
  
  public static String transformHTMLToText(String content, String rootTag) {
    String result = transformHTMLToText(content);
    if (rootTag != null && keepHtmlTags()) {
      return "<" + rootTag + ">" + result + "</" + rootTag + ">";
    }
    return result;
  }
  
  public static String transformHTMLToTextWithLineFeed(String content) {
    String transformedHTML = content;
    if (!keepHtmlTags()) {
      transformedHTML = transformedHTML.replaceAll("<xhtml:br/>", " ").replaceAll("<[^>]*>", "").trim();
    } else {
      transformedHTML = transformedHTML.replaceAll("(?!</xhtml)(?!<xhtml)<[^>]*>", "").replace("xhtml:", "");
    }
    // Decode special characters
    transformedHTML = URI.decode(transformedHTML);
    // Unescape HTML special character entities
    transformedHTML = unescape(transformedHTML);
    return transformedHTML;
  }
  
  public static boolean keepHtmlTags() {
    return (Boolean) ReqImporterPreferencesUtil
        .getValueForPreferenceKey(RequirementsPreferencesConstants.REQUIREMENT_KEEP_XHTML_TAGS, Boolean.class);
  }
}
