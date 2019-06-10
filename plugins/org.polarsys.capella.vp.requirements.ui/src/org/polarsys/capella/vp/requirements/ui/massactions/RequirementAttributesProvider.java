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
package org.polarsys.capella.vp.requirements.ui.massactions;

import java.util.Collection;
import java.util.LinkedHashSet;

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

  Collection<IMAColumn> columns = null;

  @Override
  public Collection<IMAColumn> getColumnValues(Collection<PossibleFeature> arg0, Collection<EObject> elements) {
    if (columns == null) {
      columns = new LinkedHashSet<IMAColumn>();

      for (EObject object : elements) {
        if (object instanceof AttributeOwner) {
          AttributeOwner element = (AttributeOwner) object;
          for (Attribute attribute : element.getOwnedAttributes()) {
            if (attribute.getDefinition() != null) {
              if (!TypeHelper.isDirectFeature(attribute.getDefinition().getReqIFLongName(), element)) {
                columns.add(new AttributeDefinitionColumn(attribute.eClass(), attribute.getDefinition()));
              }
            }
          }
          AbstractType type = TypeHelper.getType(element);
          if (type != null) {
            for (AttributeDefinition definition : type.getOwnedAttributes()) {
              if (!TypeHelper.isDirectFeature(definition.getReqIFLongName(), element)) {
                columns.add(new AttributeDefinitionColumn(TypeHelper.getCompatibleType(definition), definition));
              }
            }
          }
        }
      }

      for (IMAColumn c : columns) {
        ((AttributeDefinitionColumn) c).setBodyLayer(bodyLayer);
      }
    }
    return columns;
  }

}
