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
  public static String transformHTMLToText(String content) {
    return transformHTMLToTextWithLineFeed(content).replace("\r\n", " ").replace("\n", " ").trim();
  }
  
  public static String transformHTMLToTextWithLineFeed(String content) {
    Boolean keepXhtmlTages = (Boolean) ReqImporterPreferencesUtil
        .getValueForPreferenceKey(RequirementsPreferencesConstants.REQUIREMENT_KEEP_XHTML_TAGS, Boolean.class);
    if (!keepXhtmlTages) {
      content = content.replaceAll("<xhtml:br/>", " ").replaceAll("<[^>]*>", "").trim();
    }
    content = content.replaceAll("(?!</xhtml)(?!<xhtml)<[^>]*>", "").replace("xhtml:", "");
    // Decode special characters
    content = URI.decode(content);
    // Unescape HTML special character entities
    content = StringEscapeUtils.unescapeHtml(content);
    return content;
  }
}
