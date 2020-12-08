/*******************************************************************************
 * Copyright (c) 2017, 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.importer.transposer.policies;

import java.util.Set;

import org.eclipse.emf.diffmerge.generic.api.scopes.ITreeDataScope;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.compare.CapellaMergePolicy;
import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Module;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * @author Olivier Fremion
 */
public class ReqIFMergePolicy extends CapellaMergePolicy {

  /* Add the types needed for each Attribute */
  /* Add the types needed for each Module */
  /* Add the types needed for each Requirement */
  /* Add the source and target for each InternalRelation and their owned Attributes */
  @Override
  public Set<EObject> getAdditionGroup(EObject element_p, ITreeDataScope<EObject> scope_p) {

    Set<EObject> result = super.getAdditionGroup(element_p, scope_p);
    if (element_p instanceof Attribute) {
      Attribute attribute = (Attribute) element_p;
      if (attribute.getDefinition() != null && attribute.getDefinition().getDefinitionType() != null) {
        // Take the AttributeDefinition along with the Attribute
        result.add(attribute.getDefinition());
        // Take the DataTypeDefinition along with the AttributeDefinition
        DataTypeDefinition dataTypeDefinition = attribute.getDefinition().getDefinitionType();
        result.add(dataTypeDefinition);
        // If the DataTypeDefinition is an EnumerationDataTypeDefinition, take EnumValues with it
        if (dataTypeDefinition instanceof EnumerationDataTypeDefinition) {
          result.addAll(((EnumerationDataTypeDefinition) dataTypeDefinition).getSpecifiedValues());
        }
      }
    } else if (element_p instanceof Module) {
      Module module = (Module) element_p;
      if (module.getModuleType() != null) {
        result.add(module.getModuleType());
      }
    } else if (element_p instanceof InternalRelation) {
      InternalRelation internalRelation = (InternalRelation) element_p;
      if (internalRelation.getRelationType() != null) {
        result.add(internalRelation.getRelationType());
      }
      if (internalRelation.getSource() != null) {
        Requirement source = internalRelation.getSource();
        result.add(source);
        if (source.getOwnedAttributes() != null) {
          result.addAll(source.getOwnedAttributes());
        }
      }
      if (internalRelation.getTarget() != null) {
        Requirement target = internalRelation.getTarget();
        result.add(target);
        if (target.getOwnedAttributes() != null) {
          result.addAll(target.getOwnedAttributes());
        }
      }
    } else if (element_p instanceof Requirement) {
      Requirement requirement = (Requirement) element_p;
      if (requirement.getRequirementType() != null) {
        result.add(requirement.getRequirementType());
      }
    }
    return result;
  }

}
