/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ui.commands;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.resource.AirdResource;

/**
 * The helper for manipulating the custom data of requirements VP in resource.
 * @author Cong Bang DO
 *
 */
public class ReqVPCustomDataHelper {
  
  /**
   * Private constructor because all methods will be public static
   */
  private ReqVPCustomDataHelper() {
  }

  public static final String CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES = "REQUIREMENTS_VP_QUERIES";
  public static final String CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL = "REQUIREMENTS_VP_LABEL_QUERY";
  public static final String CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL_LENGTH = "REQUIREMENTS_VP_LABEL_LENGTH";
  public static final String CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT = "REQUIREMENTS_VP_CONTENT_QUERY";
  public static final String CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT_LENGTH = "REQUIREMENTS_VP_CONTENT_LENGTH";
  
  /**
   * Get the custom data from a Sirius session
   * @param session
   * @return
   */
  public static EAnnotation getCustomData(Session session) {
    try {
      EObject associatedElement = session.getSelectedViews().stream().findAny().orElse(null);
      Collection<EObject> customDatas = session.getServices().getCustomData(CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES,
          associatedElement);
      for (EObject customData : customDatas) {
        if (customData instanceof EAnnotation) {
          EMap<String, String> details = ((EAnnotation) customData).getDetails();
          if (details != null && containsAllKeys(details)) {
            return (EAnnotation) customData;
          }
        }
      }
    } catch (Exception e) {
      return null;
    }
    return null;
  }
  
  /**
   * Check if the custom data contains all required fields.
   * @param details
   * @return
   */
  private static boolean containsAllKeys(EMap<String, String> details) {
    boolean result = details.containsKey(CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL);
    result = result && details.containsKey(CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT);
    result = result && details.containsKey(CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL_LENGTH);
    result = result && details.containsKey(CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT_LENGTH);

    return result;
  }

  /**
   * Get the RIGHT resource from a Sirius session
   * @param session
   * @return
   */
  public static Resource getResource(Session session) {
    Resource result = null;
    for (Iterator<Resource> iterator = session.getReferencedSessionResources().iterator(); iterator.hasNext();) {
      Resource resource = iterator.next();
      if (resource instanceof AirdResource) {
        continue;
      }
      result = resource;
    }
    if (result == null) {
      result = session.getSessionResource();
    }
    return result;
  }
  
  public static String getDefaultLabelExpression() {
    return Messages.DefaultValueOfLabelExpression;
  }
  
  public static String getDefaultContentExpression() {
    return Messages.DefaultValueOfContentExpression;
  }
  
  public static String getDefaultContentLength() {
    return Messages.DefaultValueOfContentMaxLength;
  }
  
  public static String getDefaultLabelLength() {
    return Messages.DefaultValueOfLabelMaxLength;
  }
}
