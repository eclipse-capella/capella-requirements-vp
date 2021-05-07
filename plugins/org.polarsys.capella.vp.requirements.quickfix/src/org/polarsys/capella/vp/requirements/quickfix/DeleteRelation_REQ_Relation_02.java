/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.quickfix;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.platform.sirius.ui.commands.CapellaDeleteCommand;
import org.polarsys.capella.core.validation.ui.ide.quickfix.AbstractCapellaMarkerResolution;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

public class DeleteRelation_REQ_Relation_02 extends AbstractCapellaMarkerResolution {

  @Override
  public void run(IMarker marker) {
    // Get ModelElement associated to the marker.
    List<EObject> modelElements = getModelElements(marker);
    if (modelElements.isEmpty()) {
      return;
    }
    final EObject modelElement = modelElements.get(0);
    if (modelElements.size() > 2
        && (modelElements.get(0) != null && modelElements.get(1) != null && modelElements.get(2) != null)) {
      List<EObject> relations = getRelations(modelElement, modelElements.get(0), modelElements.get(1),
          modelElements.get(2));
      if (relations.size() > 1) {
        // keep only one relation
        relations.remove(0);

        // delete the duplicated relations
        if (deleteRelations(modelElement, relations)) {
          try {
            marker.delete();
          } catch (CoreException e) {
          }
        }
      }
    }
  }

  private boolean deleteRelations(EObject modelElement, List<EObject> relations) {
    final boolean deleted[] = { false };
    AbstractReadWriteCommand abstrctCommand = new AbstractReadWriteCommand() {
      @Override
      public void run() {
        // Ask user for confirmation.
        boolean confirmDeletion = CapellaDeleteCommand
            .confirmDeletion(TransactionHelper.getExecutionManager(modelElement), relations);
        if (confirmDeletion) {
          CapellaDeleteCommand command = new CapellaDeleteCommand(TransactionHelper.getExecutionManager(modelElement),
              relations, false, false, true);
          if (command.canExecute()) {
            command.execute();
            // Element (s) deleted -> delete maker too.
            deleted[0] = true;
          }
        }
      }
    };
    TransactionHelper.getExecutionManager(modelElement).execute(abstrctCommand);
    return deleted[0];
  }

  private List<EObject> getRelations(EObject element, EObject source, EObject target, EObject relationType) {
    List<EObject> elements = new ArrayList<EObject>();
    if (element instanceof Requirement) {
      Requirement requirement = (Requirement) element;
      for (AbstractRelation relation : requirement.getOwnedRelations()) {
        if (relation.getRelationType().equals(relationType)) {
          if (relation instanceof InternalRelation) {
            InternalRelation internalRelation = (InternalRelation) relation;
            if (internalRelation.getSource().equals(source) && internalRelation.getTarget().equals(target)) {
              elements.add(relation);
            }
          } else if (relation instanceof CapellaIncomingRelation) {
            CapellaIncomingRelation inRelation = (CapellaIncomingRelation) relation;
            if (inRelation.getSource().equals(source) && inRelation.getTarget().equals(target)) {
              elements.add(relation);
            }
          }
        }
      }

      List<DAnnotation> annotations = new ArrayList<>();
      annotations.addAll(RelationAnnotationHelper.getIncomingAnnotations(requirement));
      annotations.addAll(RelationAnnotationHelper.getOutgoingAnnotations(requirement));
      for (DAnnotation annotation : annotations) {
        if (RelationAnnotationHelper.getDescriptor(annotation).equals(source)
            && RelationAnnotationHelper.getRequirement(annotation).equals(target)
            && RelationAnnotationHelper.getRelationType(annotation).equals(relationType)) {
          elements.add(annotation);
        }
      }

    } else if (element instanceof CapellaElement) {
      CapellaElement capellaElement = (CapellaElement) element;
      for (ElementExtension ext : capellaElement.getOwnedExtensions()) {
        if (ext instanceof CapellaOutgoingRelation) {
          CapellaOutgoingRelation outRelation = (CapellaOutgoingRelation) ext;
          if (outRelation.getRelationType().equals(relationType) && outRelation.getSource().equals(source)
              && outRelation.getTarget().equals(target)) {
            elements.add(ext);
          }
        }
      }

    } else if (element instanceof DRepresentationDescriptor) {
      DRepresentationDescriptor descriptor = (DRepresentationDescriptor) element;
      List<DAnnotation> annotations = new ArrayList<>();
      annotations.addAll(
          RelationAnnotationHelper.getAllocations(descriptor, RelationAnnotationHelper.IncomingRelationAnnotation));
      annotations.addAll(
          RelationAnnotationHelper.getAllocations(descriptor, RelationAnnotationHelper.OutgoingRelationAnnotation));
      for (DAnnotation annotation : annotations) {
        if (RelationAnnotationHelper.getDescriptor(annotation).equals(source)
            && RelationAnnotationHelper.getRequirement(annotation).equals(target)
            && RelationAnnotationHelper.getRelationType(annotation).equals(relationType)) {
          elements.add(annotation);
        }
      }
    }

    return elements;
  }
}
