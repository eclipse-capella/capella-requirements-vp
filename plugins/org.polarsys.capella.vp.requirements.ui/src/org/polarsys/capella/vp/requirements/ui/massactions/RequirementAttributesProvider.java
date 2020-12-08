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
package org.polarsys.capella.vp.requirements.ui.massactions;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.vp.requirements.model.helpers.TypeHelper;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.massactions.core.extensions.columnprovider.AbstractMAColumnProvider;
import org.polarsys.kitalpha.massactions.core.helper.container.PossibleFeature;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner;

public class RequirementAttributesProvider extends AbstractMAColumnProvider {

  @Override
  public Collection<IMAColumn> getColumnValues(Collection<PossibleFeature> arg0, Collection<EObject> elements) {

    //We return columns shared by all elements
    HashMap<IMAColumn, Integer> commonColumns = new HashMap<IMAColumn, Integer>();

    for (EObject object : elements) {
      if (object instanceof AttributeOwner) {
        AttributeOwner element = (AttributeOwner) object;
        HashSet<IMAColumn> columns = new HashSet<IMAColumn>();
        
        //Columns for owned attributes
        for (Attribute attribute : element.getOwnedAttributes()) {
          if (attribute.getDefinition() != null) {
            if (!TypeHelper.isDirectFeature(attribute.getDefinition().getReqIFLongName(), element)) {
              AttributeDefinitionColumn column = new AttributeDefinitionColumn(attribute.eClass(),
                  attribute.getDefinition());
              columns.add(column);
            }
          }
        }

        //Columns for its type
        AbstractType type = TypeHelper.getType(element);
        if (type != null) {
          for (AttributeDefinition definition : type.getOwnedAttributes()) {
            if (!TypeHelper.isDirectFeature(definition.getReqIFLongName(), element)) {
              AttributeDefinitionColumn c = new AttributeDefinitionColumn(TypeHelper.getCompatibleType(definition),
                  definition);
              columns.add(c);
            }
          }
        }
        
        //We add columns to the commonColumns
        for (IMAColumn c : columns) {
          commonColumns.put(c, commonColumns.getOrDefault(c, 0) + 1);
        }
      } else {
        
        //If there is an invalid element, we don't have common columns
        return Collections.emptyList();
      }
    }
    
    //We return columns shared by all elements
    List<IMAColumn> result = commonColumns.entrySet().stream().filter(e -> e.getValue() == elements.size())
        .map(e -> e.getKey()).collect(Collectors.toList());
    for (IMAColumn c : result) {
      ((AttributeDefinitionColumn) c).setBodyLayer(bodyLayer);
    }
    return result;
  }

}
