/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.model.helpers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner;
import org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.Module;
import org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.SharedDirectAttributes;

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

  public static EStructuralFeature getDirectFeature(String longName, AttributeOwner target) {
    if (target instanceof SharedDirectAttributes) {
      if ("ReqIF.Name".equals(longName)) {
        return RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME;
      } else if ("ReqIF.Prefix".equals(longName)) {
        return RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX;
      }
    }
    if (target instanceof ReqIFElement) {
      if ("ReqIF.Description".equals(longName)) {
        return RequirementsPackage.Literals.REQ_IF_ELEMENT__REQ_IF_DESCRIPTION;
      } 
    }
    if (target instanceof Requirement) {
      if ("ReqIF.ChapterName".equals(longName)) {
        return RequirementsPackage.Literals.REQUIREMENT__REQ_IF_CHAPTER_NAME;
      } else if ("ReqIF.Text".equals(longName)) {
        return RequirementsPackage.Literals.REQUIREMENT__REQ_IF_TEXT;
      } else if ("ReqIF.ForeignID".equals(longName)) {
        return RequirementsPackage.Literals.REQUIREMENT__REQ_IF_FOREIGN_ID;
      }
    }
    return null;
  }

  public static boolean isDirectFeature(String longName, AttributeOwner target) {
    return getDirectFeature(longName, target) != null;
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
