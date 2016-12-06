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

import org.eclipse.core.runtime.Assert;
import org.polarsys.capella.vp.requirements.importer.extension.AttributeSet;

public class ReqImporterPreferences {
  
  public static String getPreferenceKey(AttributeSet attribute){
    AttributeSet category = attribute.getParent();
    Assert.isNotNull(category);
    
    String key = category.getName() + "." + attribute.getName();
    return key;
  }
}
