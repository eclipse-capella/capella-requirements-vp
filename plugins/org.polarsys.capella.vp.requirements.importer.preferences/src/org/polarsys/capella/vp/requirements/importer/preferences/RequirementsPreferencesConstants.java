/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.importer.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class RequirementsPreferencesConstants {

  public static final String REQUIREMENT_PROPERTIES_FILES_KEY = "requirement.properties.files";

  public static final String REQUIREMENT_LABEL_EXPRESSION_KEY = "requirement.label.expression";
  public static final String REQUIREMENT_DEFAULT_LABEL_EXPRESSION = "aql:let puid = self.ownedAttributes->any(a | a.definition.ReqIFLongName == 'IE PUID')->collect(a | '['+a.value+']')->first() in let name = OrderedSet{self.ReqIFText, self.ReqIFName, self.ReqIFChapterName, self.ReqIFLongName}->any(s | s != null and s.size() > 0)->first() in OrderedSet{puid, name}->select(s | s != null)->sep(' ')->toString()";
  public static final String REQUIREMENT_LABEL_MAX_LEN_KEY = "requirement.label.max.len";
  public static final String REQUIREMENT_DEFAULT_LABEL_MAX_LEN = "80";

  public static final String ENUMERATION_VALUE_ATTRIBUTE_LABEL_MAX_LEN_KEY = "value.label.max.len";
  public static final String ENUMERATION_VALUE_ATTRIBUTE_DEFAULT_LABEL_MAX_LEN = "80";
  /**
   * Preference used to enforce requirements check with Doors and RMF plugin
   */
  public static final String PREFERENCE_FORCE_DOORS_RMF_USAGE = "requirement.label.doors.rmf";
  /**
   * Default value
   */
  public static final String DEFAULT_VALUE_FORCE_DOORS_RMF_USAGE = "false";

}
