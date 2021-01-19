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

public class LabelHelper {
  private LabelHelper() {
    // Private constructor
  }
  public static String transformHTMLToText(String content) {
    content = content.replaceAll("<[^>]*>", "").replaceAll("\r\n", " ").replaceAll("\n", " ").trim();
    // Decode special characters
    content = URI.decode(content);
    // Unescape HTML special character entities
    content = StringEscapeUtils.unescapeHtml(content);
    return content;
  }
}
