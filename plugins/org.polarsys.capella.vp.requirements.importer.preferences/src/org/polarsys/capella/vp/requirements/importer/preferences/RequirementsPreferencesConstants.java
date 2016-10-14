/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
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
  
  public static final String REQUIREMENT_DEFAULT_LABEL_EXPRESSION = "<%self.ownedAttributes[definition.ReqIFLongName==\"IE PUID\"].value%>";

  public static final String REQUIREMENT_PROPERTIES_FILES = "requirement.properties.files";

}
