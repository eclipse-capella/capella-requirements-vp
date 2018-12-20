/*******************************************************************************
 * Copyright (c) 2017, 2018 THALES GLOBAL SERVICES.
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
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.eclipse.sirius.viewpoint.description.DescriptionPackage;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.common.mdsofa.common.misc.Couple;
import org.polarsys.capella.core.diagram.helpers.DAnnotationHelper;
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
   * Retrieve annotations of descriptors referencing the given requirement as incoming relation
   */
  public static Collection<DAnnotation> getIncomingAnnotations(Requirement requirement) {
    Collection<DAnnotation> result = new LinkedHashSet<>();
    for (Setting s : SessionManager.INSTANCE.getSession(requirement).getSemanticCrossReferencer()
        .getInverseReferences(requirement)) {
      if (DescriptionPackage.Literals.DANNOTATION__REFERENCES.equals(s.getEStructuralFeature())) {
        DAnnotation annotation = (DAnnotation) s.getEObject();
        if (IncomingRelationAnnotation.equals(annotation.getSource())) {
          result.add(annotation);
        }
      }
    }
    return result;
  }

  /**
   * Retrieve annotations of descriptors referencing the given requirement as outgoing relation
   */
  public static Collection<DAnnotation> getOutgoingAnnotations(Requirement requirement) {
    Collection<DAnnotation> result = new LinkedHashSet<>();
    for (Setting s : SessionManager.INSTANCE.getSession(requirement).getSemanticCrossReferencer()
        .getInverseReferences(requirement)) {
      if (DescriptionPackage.Literals.DANNOTATION__REFERENCES.equals(s.getEStructuralFeature())) {
        DAnnotation annotation = (DAnnotation) s.getEObject();
        if (OutgoingRelationAnnotation.equals(annotation.getSource())) {
          result.add(annotation);
        }
      }
    }
    return result;
  }

  /**
   * Retrieve annotations of descriptors typed by the given relation type
   */
  public static Collection<DAnnotation> getTypedAnnotations(RelationType type) {
    Collection<DAnnotation> result = new LinkedHashSet<>();
    for (Setting s : SessionManager.INSTANCE.getSession(type).getSemanticCrossReferencer().getInverseReferences(type)) {
      if (DescriptionPackage.Literals.DANNOTATION__REFERENCES.equals(s.getEStructuralFeature())) {
        DAnnotation annotation = (DAnnotation) s.getEObject();
        result.add(annotation);
      }
    }
    return result;
  }

  /**
   * @param descriptor
   * @param relationType
   *          one of the constants IncomingRelationAnnotation or OutgoingRelationAnnotation
   */
  public static Collection<DAnnotation> getAllocations(final DRepresentationDescriptor descriptor,
      final String relationType) {
    return getAnnotations(relationType, descriptor);
  }

  /**
   * Returns the descriptor containing the given annotation
   * 
   * @return it may return null, even it shall not occur
   */
  public static DRepresentationDescriptor getDescriptor(DAnnotation annotation) {
    return (DRepresentationDescriptor) annotation.eContainer();
  }

  /**
   * Returns the requirement associated to the given annotation
   * 
   * @return it may return null, even it shall not occur
   */
  public static Requirement getRequirement(DAnnotation annotation) {
    return (Requirement) annotation.getReferences().stream().filter(r -> r instanceof Requirement).findFirst()
        .orElse(null);
  }

  /**
   * Returns the relation type associated to the given annotation
   * 
   * @return it may return null, as a relation may not be typed.
   */
  public static RelationType getRelationType(DAnnotation annotation) {
    return (RelationType) annotation.getReferences().stream().filter(r -> r instanceof RelationType).findFirst()
        .orElse(null);
  }

  /**
   * Get all annotations with a given source from a given descriptor
   */
  public static Collection<DAnnotation> getAnnotations(String source, DRepresentationDescriptor descriptor) {
    Collection<DAnnotation> result = new ArrayList<DAnnotation>();
    for (DAnnotation annotation : descriptor.getEAnnotations()) {
      if (annotation.getSource() != null && annotation.getSource().equals(source)) {
        result.add(annotation);
      }
    }
    return result;
  }

  /**
   * @param descriptor
   * @param relationType
   * @param elements
   */
  public static void addAllocations(final DRepresentationDescriptor descriptor, final String relationType,
      final Collection<Couple<Requirement, RelationType>> elements) {
    TransactionHelper.getExecutionManager(descriptor).execute(new AbstractReadWriteCommand() {
      public void run() {
        for (Couple<Requirement, RelationType> entry : elements) {
          DAnnotation annotation = DAnnotationHelper.createAnnotation(relationType, descriptor);
          EObject requirement = entry.getKey();
          EObject type = entry.getValue();
          annotation.getReferences().add(requirement);
          if (type != null) {
            annotation.getReferences().add(type);
          }
        }
      }
    });
  }

  /**
   * @param descriptor
   * @param elements
   */
  public static void removeAllocations(final DRepresentationDescriptor descriptor, Collection<Object> elements) {
    removeAllocations(descriptor, IncomingRelationAnnotation, elements);
    removeAllocations(descriptor, OutgoingRelationAnnotation, elements);
  }

  /**
   * @param descriptor
   * @param relationType
   * @param elements
   */
  public static void removeAllocations(final DRepresentationDescriptor descriptor, final String relationType,
      Collection<Object> elements) {
    TransactionHelper.getExecutionManager(descriptor).execute(new AbstractReadWriteCommand() {
      public void run() {
        Collection<DAnnotation> annotations = getAnnotations(relationType, descriptor);
        for (Object requirement : elements) {
          Collection<DAnnotation> toRemove = annotations.stream().filter(a -> requirement.equals(getRequirement(a)))
              .collect(Collectors.toList());
          for (DAnnotation annotation : toRemove) {
            SiriusUtil.delete(annotation);
          }
        }
      }
    });
  }

  /**
   * @param descriptor
   * @param relationType
   * @param element
   */
  public static void addAllocation(final DRepresentationDescriptor descriptor, final String relationType,
      final Couple<Requirement, RelationType> element) {
    ArrayList<Couple<Requirement, RelationType>> res = new ArrayList<>();
    res.add(element);
    addAllocations(descriptor, relationType, res);
  }

  /**
   * @param descriptor
   * @param relationType
   * @param elements
   */
  public static void removeAllocation(final DRepresentationDescriptor descriptor, final String relationType,
      DAnnotation annotation) {
    if (annotation != null) {
      TransactionHelper.getExecutionManager(descriptor).execute(new AbstractReadWriteCommand() {
        public void run() {
          SiriusUtil.delete(annotation);
        }
      });
    }
  }

  public static void updateAllocation(DRepresentationDescriptor descriptor, AbstractRelation relation,
      DAnnotation annotation) {
    String relationType = null;
    Requirement requirement = null;
    if (relation instanceof CapellaIncomingRelation) {
      relationType = IncomingRelationAnnotation;
      requirement = ((CapellaIncomingRelation) relation).getSource();
    } else if (relation instanceof CapellaOutgoingRelation) {
      relationType = OutgoingRelationAnnotation;
      requirement = ((CapellaOutgoingRelation) relation).getTarget();
    }
    if (requirement != null) {
      removeAllocation(descriptor, relationType, annotation);
      addAllocation(descriptor, relationType,
          new Couple<Requirement, RelationType>(requirement, relation.getRelationType()));
    }
  }
}
