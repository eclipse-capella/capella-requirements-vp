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
package org.polarsys.capella.vp.requirements.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.osgi.util.NLS;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.validation.rule.AbstractValidationRule;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

public class REQ_Relation_02 extends AbstractValidationRule {

  @Override
  public IStatus validate(IValidationContext ctx) {
    EObject target = ctx.getTarget();
    Collection<IStatus> statuses = new ArrayList<IStatus>();

    Map<UniqueRelation, Integer> uniqueRelationCountMap = getUniqueRelationCountMap(target);
    for (Entry<UniqueRelation, Integer> entry : uniqueRelationCountMap.entrySet()) {
      if (entry.getValue() > 1) {
        String msg = NLS.bind(
            "''{0}'' [{1}] contains {2} duplicated relations ''{5}'' between source ''{3}'' and target ''{4}''",
            new String[] { EObjectLabelProviderHelper.getText(target),
                EObjectLabelProviderHelper.getMetaclassLabel(target, false), "" + entry.getValue(),
                EObjectLabelProviderHelper.getText(entry.getKey().getSourceElement()),
                EObjectLabelProviderHelper.getText(entry.getKey().getTargetElement()),
                EObjectLabelProviderHelper.getText(entry.getKey().getRelationType()) });
        IStatus failureStatus = ctx.createFailureStatus(msg);
        statuses.add(failureStatus);
      }
    }

    if (!statuses.isEmpty()) {
      return ConstraintStatus.createMultiStatus(ctx, statuses);
    }

    return ctx.createSuccessStatus();
  }

  /**
   * Build a map of duplicated relations contained in a given element
   * 
   * @param target
   *          element that contains relations
   */
  protected Map<UniqueRelation, Integer> getUniqueRelationCountMap(EObject target) {
    Map<UniqueRelation, Integer> relationCountMap = new HashMap<>();

    for (UniqueRelation relation : getRelations(target)) {
      if (isUniqueRelationValid(relation)) {
        updateRelationCountMap(relationCountMap, relation);
      }
    }
    return relationCountMap;
  }

  private Collection<UniqueRelation> getRelations(EObject target) {
    Collection<UniqueRelation> result = new ArrayList<>();

    if (target instanceof Requirement) {
      Requirement req = (Requirement) target;
      for (AbstractRelation relation : req.getOwnedRelations()) {
        if (relation instanceof InternalRelation) {
          result.add(new UniqueRelation((InternalRelation) relation));

        } else if (relation instanceof CapellaIncomingRelation) {
          result.add(new UniqueRelation((CapellaIncomingRelation) relation));
        }
      }
      for (DAnnotation annotation : RelationAnnotationHelper.getIncomingAnnotations(req)) {
        result.add(new UniqueRelation((DAnnotation) annotation));
      }
      for (DAnnotation annotation : RelationAnnotationHelper.getOutgoingAnnotations(req)) {
        result.add(new UniqueRelation((DAnnotation) annotation));
      }

    } else if (target instanceof CapellaElement) {
      CapellaElement capellaElement = (CapellaElement) target;
      for (ElementExtension ext : capellaElement.getOwnedExtensions()) {
        if (ext instanceof CapellaOutgoingRelation) {
          result.add(new UniqueRelation((CapellaOutgoingRelation) ext));
        }
      }

    } else if (target instanceof DRepresentationDescriptor) {
      DRepresentationDescriptor descriptor = (DRepresentationDescriptor) target;
      for (DAnnotation annotation : RelationAnnotationHelper.getAllocations(descriptor,
          RelationAnnotationHelper.IncomingRelationAnnotation)) {
        result.add(new UniqueRelation((DAnnotation) annotation));
      }

      for (DAnnotation annotation : RelationAnnotationHelper.getAllocations(descriptor,
          RelationAnnotationHelper.OutgoingRelationAnnotation)) {
        result.add(new UniqueRelation((DAnnotation) annotation));
      }
    }

    return result;
  }

  /**
   * Add the relation to the map if it does not exist already, increment the count number otherwise
   * 
   * @param relationCountMap
   * @param uniqueRelation
   */
  protected void updateRelationCountMap(Map<UniqueRelation, Integer> relationCountMap, UniqueRelation uniqueRelation) {
    if (relationCountMap.containsKey(uniqueRelation))
      relationCountMap.put(uniqueRelation, relationCountMap.get(uniqueRelation) + 1);
    else
      relationCountMap.put(uniqueRelation, 1);
  }

  /**
   * Check if a relation's source, target and type are not null
   * 
   * @param relationCountMap
   * @param uniqueRelation
   */
  protected boolean isUniqueRelationValid(UniqueRelation uniqueRelation) {
    return uniqueRelation.getSourceElement() != null && uniqueRelation.getTargetElement() != null
        && uniqueRelation.getRelationType() != null;
  }

  /**
   * 
   * A representation of a requirement relation that is unique based on source element, target element and relation type
   * instead of identifier
   */
  class UniqueRelation {
    EObject source;
    EObject target;
    EObject relationType;

    public UniqueRelation(DAnnotation annotation) {
      this(RelationAnnotationHelper.getDescriptor(annotation), RelationAnnotationHelper.getRequirement(annotation),
          RelationAnnotationHelper.getRelationType(annotation));
    }
    
    public UniqueRelation(CapellaOutgoingRelation relation) {
      this(relation.getSource(), relation.getTarget(), relation.getRelationType());
    }
    
    public UniqueRelation(CapellaIncomingRelation relation) {
      this(relation.getSource(), relation.getTarget(), relation.getRelationType());
    }

    public UniqueRelation(InternalRelation relation) {
      this(relation.getSource(), relation.getTarget(), relation.getRelationType());
    }
    
    public UniqueRelation(EObject source, EObject target, EObject relationType) {
      this.source = source;
      this.target = target;
      this.relationType = relationType;
    }

    public EObject getSourceElement() {
      return source;
    }

    public EObject getTargetElement() {
      return target;
    }

    public EObject getRelationType() {
      return relationType;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (obj == null || obj.getClass() != this.getClass()) {
        return false;
      }

      UniqueRelation relationToCompare = (UniqueRelation) obj;

      return source.equals(relationToCompare.getSourceElement()) && target.equals(relationToCompare.getTargetElement())
          && relationType.equals(relationToCompare.getRelationType());
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((source == null) ? 0 : source.hashCode());
      result = prime * result + ((target == null) ? 0 : target.hashCode());
      result = prime * result + ((relationType == null) ? 0 : relationType.hashCode());
      return result;
    }
  }
}
