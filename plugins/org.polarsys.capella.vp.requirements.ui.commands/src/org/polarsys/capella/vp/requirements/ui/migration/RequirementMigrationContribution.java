/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.migration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.polarsys.capella.common.mdsofa.common.misc.Couple;
import org.polarsys.capella.core.data.migration.context.MigrationContext;
import org.polarsys.capella.core.data.migration.contribution.AbstractMigrationContribution;
import org.polarsys.capella.core.diagram.helpers.DAnnotationHelper;
import org.polarsys.capella.core.model.handler.helpers.RepresentationHelper;
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

public class RequirementMigrationContribution extends AbstractMigrationContribution {
  
  private static final String idseparator = ";"; //$NON-NLS-1$

  @Override
  public void unaryMigrationExecute(EObject currentElement, MigrationContext context) {
    super.unaryMigrationExecute(currentElement, context);
    
    if (currentElement instanceof DRepresentationDescriptor) {
      DRepresentation representation = ((DRepresentationDescriptor)currentElement).getRepresentation();
      if (representation != null) {
        migrateAllocations((DRepresentationDescriptor)currentElement, RelationAnnotationHelper.IncomingRelationAnnotation, representation);
        migrateAllocations((DRepresentationDescriptor)currentElement, RelationAnnotationHelper.OutgoingRelationAnnotation, representation);
      }
    }
  }
  
  /**
   * @param descriptor
   * @param relationType one of the constants IncomingRelationAnnotation or OutgoingRelationAnnotation 
   */
  private void migrateAllocations(final DRepresentationDescriptor descriptor,
      final String relationType, DRepresentation representation) {
    Collection<Couple<Requirement, RelationType>> result = new ArrayList<>();
    final DAnnotation annotation = DAnnotationHelper.getAnnotation(relationType, representation, false);
    
    if (null != annotation) {
      Collection<Resource> resources = RepresentationHelper.getSemanticResources(descriptor);
      for (Entry<String, String> detail : annotation.getDetails()) {
        String elementURIs = detail.getValue();
        if ((elementURIs != null) && !elementURIs.isEmpty()) {
          try {
            String[] elementURI = elementURIs.split(idseparator);
            String reqId = elementURI[0];
            URI reqURI = URI.createURI(reqId);
            if ((reqURI != null) && reqURI.hasFragment()) {
              reqId = reqURI.fragment();
            }
            String typeId = null;
            if (elementURI.length > 1)
              typeId = elementURI[1];
            if (typeId != null) {
              URI typeURI = URI.createURI(typeId);
              if ((typeURI != null) && typeURI.hasFragment()) {
                typeId = typeURI.fragment();
              }
            }
            if ((reqId != null) && !reqId.isEmpty()) {
              for (Resource resource : resources) {
                if (resource != null) {
                  EObject reqObj = resource.getEObject(reqId);
                  EObject typeObj = null;
                  if (typeId != null && !typeId.isEmpty())
                    typeObj = resource.getEObject(typeId);
                  if (reqObj instanceof Requirement) {
                    result.add(new Couple<Requirement, RelationType>((Requirement) reqObj,
                        (typeObj instanceof RelationType) ? (RelationType) typeObj : null));
                  }
                }
              }
            }
          } catch (Exception exception) {
            // silent exception.. we just ignore this element
          }
        }
      }
      
      RelationAnnotationHelper.addAllocations(descriptor, relationType, result);
      DAnnotationHelper.deleteAnnotation(relationType, representation);
    }
  }
}
