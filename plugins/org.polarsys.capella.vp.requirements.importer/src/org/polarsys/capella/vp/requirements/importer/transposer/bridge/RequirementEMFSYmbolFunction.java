/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import org.eclipse.emf.diffmerge.bridge.impl.emf.EMFSymbolFunction;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.rmf.reqif10.AttributeDefinition;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueBoolean;
import org.eclipse.rmf.reqif10.AttributeValueDate;
import org.eclipse.rmf.reqif10.AttributeValueEnumeration;
import org.eclipse.rmf.reqif10.AttributeValueInteger;
import org.eclipse.rmf.reqif10.AttributeValueReal;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.AttributeValueXHTML;
import org.eclipse.rmf.reqif10.Identifiable;
import org.eclipse.rmf.reqif10.SpecHierarchy;
import org.eclipse.rmf.reqif10.SpecRelation;

/**
 * 
 * This class provides customizations to mapping traces
 *
 */
public class RequirementEMFSYmbolFunction extends EMFSymbolFunction {

  private static final RequirementEMFSYmbolFunction INSTANCE = new RequirementEMFSYmbolFunction();
  
  private static final String separator = ".";
  private static final String defaultValue = "defaultValue";

  public static RequirementEMFSYmbolFunction getInstance() {
    return INSTANCE;
  }

  @Override
  public String getEObjectSymbol(EObject element) {

    // For a Spec Hierarchy, use the identifier of its Spec Object instead
    if (element instanceof SpecHierarchy) {
      return getEObjectSymbol(((SpecHierarchy) element).getObject());
    }
    // For a Spec Relation, use the combination of its's source identifier, target identifier and Relation Type
    // identifier
    else if (element instanceof SpecRelation) {
      return getEObjectSymbol(((SpecRelation) element).getSource())
          + "+" + getEObjectSymbol(((SpecRelation) element).getTarget())
          + "+" +  getEObjectSymbol(((SpecRelation) element).getType());
    }
    // For an attribute value, use the its definition identifier and append a fragment. The appended fragment depends on
    // whether this value attribute is a default value for an attribute definition or owned by an attribute owner.
    else if (element instanceof AttributeValueEnumeration) {
      return ((AttributeValueEnumeration) element).getDefinition().getIdentifier() + separator
          + getSymbolFragment((AttributeValueEnumeration) element);
    } else if (element instanceof AttributeValueBoolean) {
      return ((AttributeValueBoolean) element).getDefinition().getIdentifier() + separator
          + getSymbolFragment((AttributeValueBoolean) element);
    } else if (element instanceof AttributeValueDate) {
      return ((AttributeValueDate) element).getDefinition().getIdentifier() + separator
          + getSymbolFragment((AttributeValueDate) element);
    } else if (element instanceof AttributeValueInteger) {
      return ((AttributeValueInteger) element).getDefinition().getIdentifier() + separator
          + getSymbolFragment((AttributeValueInteger) element);
    } else if (element instanceof AttributeValueReal) {
      return ((AttributeValueReal) element).getDefinition().getIdentifier() + separator
          + getSymbolFragment((AttributeValueReal) element);
    } else if (element instanceof AttributeValueString) {
      return ((AttributeValueString) element).getDefinition().getIdentifier() + separator
          + getSymbolFragment((AttributeValueString) element);
    } else if (element instanceof AttributeValueXHTML) {
      return ((AttributeValueXHTML) element).getDefinition().getIdentifier() + separator
          + getSymbolFragment((AttributeValueXHTML) element);
    }
    return super.getEObjectSymbol(element);
  }
  
  private String getSymbolFragment(AttributeValue attributeValue){
      // It's a default value for an attribute definition
      if(attributeValue.eContainer() instanceof AttributeDefinition){
        return defaultValue;
      }
      // It's owned by an attribute owner
      else if(attributeValue.eContainer() instanceof Identifiable){
        return ((Identifiable)attributeValue.eContainer()).getIdentifier();
      }
      else {
        throw new UnsupportedOperationException("ReqIF Attribute Owner of type '" + attributeValue.eContainer().eClass().getName() + "' is not supported!");
      }
  }
}