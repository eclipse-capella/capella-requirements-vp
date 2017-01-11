/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.preferences;

/**
 * Constant definitions for plug-in preferences
 */
public class RequirementsPreferencesConstants {

  public static final String REQUIREMENT_LABEL_EXPRESSION = "requirement.label.expression";
  
  public static final String REQUIREMENT_DEFAULT_LABEL_EXPRESSION = "<%(self.ownedAttributes[definition.ReqIFLongName==\"IE PUID\"].value + (self.ReqIFText.adapt(\"List\")+self.ReqIFLongName.adapt(\"List\") + self.ReqIFChapterName.adapt(\"List\"))[length>0].nFirst).sep(\" \").toString%>";

  public static final String REQUIREMENT_PROPERTIES_FILES = "requirement.properties.files";
  
  public static final String REQUIREMENT_LABEL_MAX_LEN = "requirement.label.max.len";
  
  public static final String REQUIREMENT_DEFAULT_LABEL_MAX_LEN = "80";

  public static final String VALUE_LABEL_MAX_LEN = "value.label.max.len";
  
  public static final String VALUE_DEFAULT_LABEL_MAX_LEN = "80";
  
}
