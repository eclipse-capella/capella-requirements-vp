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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    // Process content to preserve href values during decoding and unescaping
    transformedHTML = unescapePreserveHref(transformedHTML);
    return transformedHTML;
  }

  public static boolean keepHtmlTags() {
    return (Boolean) ReqImporterPreferencesUtil.getValueForPreferenceKey(RequirementsPreferencesConstants.REQUIREMENT_KEEP_XHTML_TAGS, Boolean.class);
  }

  /**
   * Unescapes HTML content while preserving href attributes.
   * @param content The HTML content to unescape.
   * @return The unescaped content.
   */
  public static String unescapePreserveHref(String content) {
    // Regular expression to match href attributes
    Pattern hrefPattern = Pattern.compile("href=\"(.*?)\"");
    Matcher matcher = hrefPattern.matcher(content);

    StringBuffer preservedContent = new StringBuffer();
    while (matcher.find()) {
      String hrefValue = matcher.group(1);
      // Temporarily replace href value with a placeholder
      matcher.appendReplacement(preservedContent, "href=\"" + hrefValue.hashCode() + "\"");
    }
    matcher.appendTail(preservedContent);

    // Decode the entire content
    String decodedContent = URI.decode(preservedContent.toString());
    // Unescape the entire content
    String unescapedContent = unescape(decodedContent);

    // Restore the original href values
    matcher = hrefPattern.matcher(content);
    while (matcher.find()) {
      String hrefValue = matcher.group(1);
      // Replace the placeholder with the original href value
      unescapedContent = unescapedContent.replace(String.valueOf(hrefValue.hashCode()), hrefValue);
    }

    return unescapedContent;
  }
}
