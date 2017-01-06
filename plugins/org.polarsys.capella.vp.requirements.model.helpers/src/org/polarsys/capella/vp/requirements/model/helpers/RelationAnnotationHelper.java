/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.model.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.common.mdsofa.common.misc.Couple;
import org.polarsys.capella.core.model.handler.helpers.RepresentationHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * @author Joao Barata
 */
public class RelationAnnotationHelper {

  /**
   *
   */
  public static final String OutgoingRelationAnnotation = "http://www.polarsys.org/capella/vp/requirements/OutgoingRelation"; //$NON-NLS-1$
  public static final String IncomingRelationAnnotation = "http://www.polarsys.org/capella/vp/requirements/IncomingRelation"; //$NON-NLS-1$

  /**
   *
   */
  private static final String idseparator = ";"; //$NON-NLS-1$

  /**
   * @param representation
   */
  public static List<Couple<Requirement, RelationType>> getAllocations(DRepresentation representation) {
    ArrayList<Couple<Requirement, RelationType>> result = new ArrayList<Couple<Requirement, RelationType>>();
    DAnnotation annotation = RepresentationHelper.getAnnotation(OutgoingRelationAnnotation, representation);
    if (null != annotation) {
      for (String elementURIs : annotation.getDetails().values()) {
        if ((elementURIs != null) && !elementURIs.isEmpty()) {
          try {
            String[] elementURI = elementURIs.split(idseparator);
            String reqId = elementURI[0];
            URI reqURI = URI.createURI(reqId);
            if ((reqURI != null) && reqURI.hasFragment()) {
              reqId = reqURI.fragment();
            }
            String typeId = elementURI[1];
            URI typeURI = URI.createURI(typeId);
            if ((typeURI != null) && typeURI.hasFragment()) {
              typeId = typeURI.fragment();
            }

            if ((reqId != null) && (typeId != null) && !reqId.isEmpty() && !typeId.isEmpty()) {
              for (Resource resource : RepresentationHelper.getSemanticResources(representation)) {
                if (resource != null) {
                  EObject reqObj = resource.getEObject(reqId);
                  EObject typeObj = resource.getEObject(typeId);
                  if (reqObj instanceof Requirement && typeObj instanceof RelationType) {
                    result.add(new Couple<Requirement, RelationType>((Requirement) reqObj, (RelationType) typeObj));
                  }
                }
              }
            }
          } catch (IllegalArgumentException exception) {
            // silent exception.. we just ignore this element
          }
        }
      }
    }
    return result;
  }

  /**
   * @param representation
   * @param requirement
   */
  public static RelationType getAllocationType(DRepresentation representation, Requirement requirement) {
    RelationType type = null;
    for (Couple<Requirement, RelationType> allocation : getAllocations(representation)) {
      if (allocation.getKey().equals(requirement)) {
        return allocation.getValue();
      }
    }
    return type;
  }

  /**
   * @param representation
   * @param elements
   */
  public static void addAllocations(final DRepresentation representation, final Collection<Couple<EObject, EObject>> elements) {
    final Map<Requirement, RelationType> elementsToBeAdded = new HashMap<Requirement, RelationType>(0);
    for (Couple<EObject, EObject> obj : elements) {
      elementsToBeAdded.put((Requirement) obj.getKey(), (RelationType) obj.getValue());
    }
    for (Couple<Requirement, RelationType> allocation : getAllocations(representation)) {
      Requirement requirement = allocation.getKey();
      if (elementsToBeAdded.containsKey(requirement)) {
        elementsToBeAdded.remove(requirement);
      }
    }
    TransactionHelper.getExecutionManager(representation).execute(new AbstractReadWriteCommand() {
      public void run() {
        DAnnotation annotation = RepresentationHelper.getAnnotation(OutgoingRelationAnnotation, representation);
        if (annotation == null) {
          annotation = RepresentationHelper.createAnnotation(OutgoingRelationAnnotation, representation);
        }
        for (Entry<Requirement, RelationType> entry : elementsToBeAdded.entrySet()) {
          String reqId = entry.getKey().getId();
          String typeId = entry.getValue().getId();
          annotation.getDetails().put(EcoreUtil.generateUUID(), reqId + idseparator + typeId);
        }
      }
    });
  }

  /**
   * @param representation
   * @param elements
   */
  public static void removeAllocations(final DRepresentation representation, Collection<Object> elements) {
    final List<Requirement> elementsToBeDestroyed = new ArrayList<Requirement>(0);
    for (Couple<Requirement, RelationType> allocation : getAllocations(representation)) {
      Requirement requirement = allocation.getKey();
      if (elements.contains(requirement)) {
        elementsToBeDestroyed.add(requirement);
      }
    }
    TransactionHelper.getExecutionManager(representation).execute(new AbstractReadWriteCommand() {
      public void run() {
        DAnnotation annotation = RepresentationHelper.getAnnotation(OutgoingRelationAnnotation, representation);
        if (annotation != null) {
          for (Requirement requirement : elementsToBeDestroyed) {
            for (String key : getKeysByValue(annotation.getDetails(), requirement.getId())) {
              annotation.getDetails().remove(key);
            }
          }
        }
      }
    });
  }

  /**
   * @param map
   * @param value
   * @return
   */
  private static Set<String> getKeysByValue(EMap<String, String> map, String value) {
    Set<String> keys = new HashSet<String>();
    for (Entry<String, String> entry : map.entrySet()) {
      if (entry.getValue().startsWith(value + idseparator)) {
        keys.add(entry.getKey());
      }
    }
    return keys;
  }
}
