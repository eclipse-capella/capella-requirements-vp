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
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * @author Joao Barata
 */
public class RelationAnnotationHelper {

  /**
   * Constants used in DAnnotation.source to distinguish IncomingRelation and OutgoingRelation. 
   */
  public static final String OutgoingRelationAnnotation = "http://www.polarsys.org/capella/vp/requirements/OutgoingRelation"; //$NON-NLS-1$
  public static final String IncomingRelationAnnotation = "http://www.polarsys.org/capella/vp/requirements/IncomingRelation"; //$NON-NLS-1$

  /**
   *
   */
  private static final String idseparator = ";"; //$NON-NLS-1$

  /**
   * @param representation
   * @param relationType one of the constants IncomingRelationAnnotation or OutgoingRelationAnnotation 
   */
  public static Map<String, Couple<Requirement, RelationType>> getAllocations(DRepresentation representation,
      String relationType) {
    Map<String, Couple<Requirement, RelationType>> result = new HashMap<>();
    DAnnotation annotation = RepresentationHelper.getAnnotation(relationType, representation);
    if (null != annotation) {
      for (Entry<String, String> detail : annotation.getDetails()) {
        String id = detail.getKey();
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
              for (Resource resource : RepresentationHelper.getSemanticResources(representation)) {
                if (resource != null) {
                  EObject reqObj = resource.getEObject(reqId);
                  EObject typeObj = null;
                  if (typeId != null && !typeId.isEmpty())
                    typeObj = resource.getEObject(typeId);
                  if (reqObj instanceof Requirement) {
                    result.put(id, new Couple<Requirement, RelationType>((Requirement) reqObj,
                        (typeObj != null && typeObj instanceof RelationType) ? (RelationType) typeObj : null));
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
   * @param relationType
   * @param requirement
   */
  public static RelationType getAllocationType(DRepresentation representation, String relationType,
      Requirement requirement) {
    RelationType type = null;
    for (Couple<Requirement, RelationType> allocation : getAllocations(representation, relationType).values()) {
      if (allocation.getKey().equals(requirement)) {
        return allocation.getValue();
      }
    }
    return type;
  }

  /**
   * @param representation
   * @param relationType
   * @param elements
   */
  public static void addAllocations(final DRepresentation representation, final String relationType,
      final Collection<Couple<EObject, EObject>> elements) {
    final Map<Requirement, RelationType> elementsToBeAdded = new HashMap<Requirement, RelationType>(0);
    for (Couple<EObject, EObject> obj : elements) {
      elementsToBeAdded.put((Requirement) obj.getKey(), (RelationType) obj.getValue());
    }
    for (Couple<Requirement, RelationType> allocation : getAllocations(representation, relationType).values()) {
      Requirement requirement = allocation.getKey();
      if (elementsToBeAdded.containsKey(requirement)) {
        elementsToBeAdded.remove(requirement);
      }
    }
    TransactionHelper.getExecutionManager(representation).execute(new AbstractReadWriteCommand() {
      public void run() {
        DAnnotation annotation = RepresentationHelper.getAnnotation(relationType, representation);
        if (annotation == null) {
          annotation = RepresentationHelper.createAnnotation(relationType, representation);
        }
        for (Entry<Requirement, RelationType> entry : elementsToBeAdded.entrySet()) {
          String reqId = entry.getKey().getId();
          String typeId = null;
          if (entry.getValue() != null)
            typeId = entry.getValue().getId();
          annotation.getDetails().put(EcoreUtil.generateUUID(), reqId + (typeId == null ? "" : idseparator + typeId));
        }
      }
    });
  }

  /**
   * @param representation
   * @param elements
   */
  public static void removeAllocations(final DRepresentation representation, Collection<Object> elements) {
    removeAllocations(representation, IncomingRelationAnnotation, elements);
    removeAllocations(representation, OutgoingRelationAnnotation, elements);
  }

  /**
   * @param representation
   * @param relationType
   * @param elements
   */
  public static void removeAllocations(final DRepresentation representation, final String relationType,
      Collection<Object> elements) {
    final List<Requirement> elementsToBeDestroyed = new ArrayList<Requirement>(0);
    for (Couple<Requirement, RelationType> allocation : getAllocations(representation, relationType).values()) {
      Requirement requirement = allocation.getKey();
      if (elements.contains(requirement)) {
        elementsToBeDestroyed.add(requirement);
      }
    }
    TransactionHelper.getExecutionManager(representation).execute(new AbstractReadWriteCommand() {
      public void run() {
        DAnnotation annotation = RepresentationHelper.getAnnotation(relationType, representation);
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

  /**
   * @param representation
   * @param relationType
   * @param element
   */
  public static void addAllocation(final DRepresentation representation, final String relationType,
      final Couple<EObject, EObject> element) {
    TransactionHelper.getExecutionManager(representation).execute(new AbstractReadWriteCommand() {
      public void run() {
        DAnnotation annotation = RepresentationHelper.getAnnotation(relationType, representation);
        if (annotation == null) {
          annotation = RepresentationHelper.createAnnotation(relationType, representation);
        }
        String reqId = ((Requirement) element.getKey()).getId();
        String typeId = null;
        if ((RelationType) element.getValue() != null)
          typeId = ((RelationType) element.getValue()).getId();
        annotation.getDetails().put(EcoreUtil.generateUUID(), reqId + (typeId == null ? "" : idseparator + typeId));
      }
    });
  }

  /**
   * @param representation
   * @param relationType
   * @param elements
   */
  public static void removeAllocation(final DRepresentation representation, final String relationType,
      final String id) {
    TransactionHelper.getExecutionManager(representation).execute(new AbstractReadWriteCommand() {
      public void run() {
        DAnnotation annotation = RepresentationHelper.getAnnotation(relationType, representation);
        if (annotation != null) {
          annotation.getDetails().removeKey(id);
        }
      }
    });
  }

  public static void updateAllocation(DRepresentation semanticElement, AbstractRelation relation, String id) {
    String relationType = null;
    Requirement requirement = null;
    if (relation instanceof CapellaIncomingRelation) {
      relationType = IncomingRelationAnnotation;
      requirement = ((CapellaIncomingRelation) relation).getSource();
    } else if (relation instanceof CapellaOutgoingRelation) {
      relationType = OutgoingRelationAnnotation;
      requirement = ((CapellaOutgoingRelation) relation).getTarget();
    }
    if (requirement != null && relationType != null) {
      removeAllocation(semanticElement, relationType, id);
      addAllocation(semanticElement, relationType,
          new Couple<EObject, EObject>(requirement, relation.getRelationType()));
    }
  }
}
