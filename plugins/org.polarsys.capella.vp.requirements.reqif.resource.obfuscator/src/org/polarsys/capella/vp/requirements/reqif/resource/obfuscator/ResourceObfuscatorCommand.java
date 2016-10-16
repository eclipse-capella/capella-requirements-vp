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
package org.polarsys.capella.vp.requirements.reqif.resource.obfuscator;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl.SimpleFeatureMapEntry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.lib.IdGenerator;

/**
 * @author Joao Barata
 */
public class ResourceObfuscatorCommand extends AbstractReadWriteCommand {

  private Resource resource;

  /**
   * @param resource
   */
  public ResourceObfuscatorCommand(Resource resource) {
    this.resource = resource;
  }

  @Override
  public void run() {
    if (resource != null) {
      obfuscateResource(resource);
      resource = null;
    }
  }

  /**
   * obfuscate given resource
   * @param resource
   */
  protected void obfuscateResource(Resource resource) {
    TreeIterator<EObject> allContents = resource.getAllContents();
    while (allContents.hasNext()) {
      EObject currentObject = allContents.next();
      if ((currentObject != null) && !(currentObject.eIsProxy())) {
        obfuscateElement(currentObject);
      }
    }
  }

  /**
   * obfuscate element
   * @param object
   */
  protected void obfuscateElement(EObject object) {
    if (object.eClass() != null) {
      for (EAttribute attribute : object.eClass().getEAllAttributes()) {
        if (isEMFObfuscableEAttribute(object, attribute)
          && isObfuscationAllowedOnEAttribute(object, attribute))
        {
          obfuscateEAttribute(object, attribute);
        }
      }
    }
  }

  /**
   * returns whether attribute should be obfuscated according to EMF rules
   * (default implementation avoid IDAttribute or nonChangeable or derived or transient)
   * @param object
   * @param attribute
   * @return
   */
  protected boolean isEMFObfuscableEAttribute(EObject object, EAttribute attribute) {
    if (!attribute.isChangeable()) {
      return false;
    }
    if (attribute.isDerived()) {
      return false;
    }
    if (attribute.isTransient()) {
      return false;
    }

    EAttribute attributeId = object.eClass().getEIDAttribute();
    if ((attributeId != null) && attributeId.equals(attribute)) {
      return false;
    }
    return true;
  }

  /**
   * returns whether attribute is allowed to be obfuscated
   * @param object
   * @param attribute
   * @return
   */
  protected boolean isObfuscationAllowedOnEAttribute(EObject object, EAttribute attribute) {
    if (ModellingcorePackage.Literals.MODEL_ELEMENT__ID.equals(attribute)) {
      return false;
    }
    if (ModellingcorePackage.Literals.MODEL_ELEMENT__SID.equals(attribute)) {
      return false;
    }

//    if (CapellacorePackage.Literals.KEY_VALUE__KEY.equals(attribute)) {
//      if ((object != null) && (object.eContainer() != null) && (object.eContainer() instanceof Project)) {
//        return false;
//      }
//    }
//    if (CapellacorePackage.Literals.KEY_VALUE__VALUE.equals(attribute)) {
//      if ((object != null) && (object.eContainer() != null) && (object.eContainer() instanceof Project)) {
//        return false;
//      }
//    }

    return true;
  }

  /**
   * obfuscate given attribute on the given object
   * @param currentObject
   * @param attribute
   */
  @SuppressWarnings({ "rawtypes", "unchecked" })
  protected void obfuscateEAttribute(EObject currentObject, EAttribute attribute) {
    try {
      Object value = currentObject.eGet(attribute);
  	  if (!attribute.isMany() && (value instanceof String)) {
  	    currentObject.eSet(attribute, generateUnreadableString((String) value));
  	  } else if (attribute.isMany()) {
  	    if (value instanceof EList) {
    	    Iterator<Object> itList = ((EList) value).iterator();
    	    int i = 0;
    	    while (itList.hasNext()) {
    	      Object itElement = itList.next();
    	      if (itElement instanceof String) {
    	        ((EList) value).set(i, generateUnreadableString((String) itElement));
    	      } else if (itElement instanceof SimpleFeatureMapEntry) {
              Object itValue = ((SimpleFeatureMapEntry) itElement).getValue();
              if (itValue instanceof String) {
                ((FeatureMap) value).setValue(i, generateUnreadableString((String) itValue));
              }
            }
    	      i++;
    	    }
    	  }
  	  }
    } catch (Exception exception) {
  	  ResourceObfuscatorPlugin.getDefault().getLog().log(
  		  new Status(IStatus.WARNING, ResourceObfuscatorPlugin.PLUGIN_ID, "Error during obfuscation of an attribute", exception));
    }
  }

  /**
   * generate unreadable string.
   * @param uncrypted
   * @return a encrypted string
   */
  protected String generateUnreadableString(String uncrypted) {
    if (uncrypted == null) {
      return null;
    }
    if ("".equals(uncrypted)) {
      return "";
    }

    StringBuilder builder = new StringBuilder();
    String createId = IdGenerator.createId();
    for (int i = 0, j = 0; i < uncrypted.length(); i++, j++) {
      if (j >= createId.length()) {
        j = 0;
      }
      builder.append(createId.charAt(j));
    }
    return builder.toString();
  }
}
