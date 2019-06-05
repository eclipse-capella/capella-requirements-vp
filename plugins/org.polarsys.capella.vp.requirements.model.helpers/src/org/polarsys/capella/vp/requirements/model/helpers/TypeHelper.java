/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.model.helpers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner;
import org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.Module;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public class TypeHelper {

  public static EDataType getDataType(EClass clazz) {
    if (RequirementsPackage.Literals.BOOLEAN_VALUE_ATTRIBUTE.equals(clazz)) {
      return EcorePackage.Literals.EBOOLEAN;
    } else if (RequirementsPackage.Literals.INTEGER_VALUE_ATTRIBUTE.equals(clazz)) {
      return EcorePackage.Literals.EINT;
    } else if (RequirementsPackage.Literals.REAL_VALUE_ATTRIBUTE.equals(clazz)) {
      return EcorePackage.Literals.EDOUBLE;
    } else if (RequirementsPackage.Literals.STRING_VALUE_ATTRIBUTE.equals(clazz)) {
      return EcorePackage.Literals.ESTRING;
    } else if (RequirementsPackage.Literals.DATE_VALUE_ATTRIBUTE.equals(clazz)) {
      return EcorePackage.Literals.EDATE;
    } 
    return null;
  }

  public static EClass getCompatibleType(AttributeDefinition def) {
    DataTypeDefinition definition = def.getDefinitionType();
    if (definition != null) {
      String type = definition.getReqIFLongName();
      if ("String".equals(type) || "Text".equals(type)) {
        return RequirementsPackage.Literals.STRING_VALUE_ATTRIBUTE;
      } else if ("Integer".equals(type)) {
        return RequirementsPackage.Literals.INTEGER_VALUE_ATTRIBUTE;
      } else if ("Real".equals(type)) {
        return RequirementsPackage.Literals.REAL_VALUE_ATTRIBUTE;
      } else if ("Boolean".equals(type)) {
        return RequirementsPackage.Literals.BOOLEAN_VALUE_ATTRIBUTE;
      } else if ("Date".equals(type)) {
        return RequirementsPackage.Literals.DATE_VALUE_ATTRIBUTE;
      } else if (definition instanceof EnumerationDataTypeDefinition) {
        return RequirementsPackage.Literals.ENUMERATION_VALUE_ATTRIBUTE;
      }
    }
    return RequirementsPackage.Literals.STRING_VALUE_ATTRIBUTE;
  }

  public static AbstractType getType(AttributeOwner req) {
    if (req instanceof Requirement) {
      return ((Requirement) req).getRequirementType();
    } else if (req instanceof Module) {
      return ((Module) req).getModuleType();
    }
    return null;
  }

}
