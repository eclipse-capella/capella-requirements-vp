/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
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

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.polarsys.capella.core.compare.CapellaDiffPolicy;
import org.polarsys.kitalpha.emde.model.EmdePackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * @author Joao Barata
 */
public class ReqIFImporterDiffPolicy extends CapellaDiffPolicy {

  /** The set of references whose order should be ignored (semantically unordered references) */
  private static final Collection<EReference> SEMANTICALLY_UNORDERED_REFERENCES =
    Arrays.asList(
      RequirementsPackage.eINSTANCE.getModule_OwnedRequirements(),
      RequirementsPackage.eINSTANCE.getFolder_OwnedRequirements(),
      RequirementsPackage.eINSTANCE.getAttributeOwner_OwnedAttributes(),
      RequirementsPackage.eINSTANCE.getRequirement_OwnedRelations(),
      RequirementsPackage.eINSTANCE.getTypesFolder_OwnedTypes(),
      RequirementsPackage.eINSTANCE.getTypesFolder_OwnedDefinitionTypes(),
      EmdePackage.eINSTANCE.getExtensibleElement_OwnedExtensions()
    );

  /** The set of references that can be ignored */
  private static final Collection<EReference> UNSIGNIFICANT_REFERENCES =
    Arrays.asList(
      RequirementsPackage.eINSTANCE.getRequirement_OwnedRelations()
    );

  /**
   * @see org.eclipse.emf.diffmerge.impl.policies.ConfigurableDiffPolicy#doConsiderOrdered(org.eclipse.emf.ecore.EStructuralFeature)
   */
  @Override
  protected boolean doConsiderOrdered(EStructuralFeature feature) {
    return !SEMANTICALLY_UNORDERED_REFERENCES.contains(feature) && super.doConsiderOrdered(feature);
  }

  /**
   * @see org.eclipse.emf.diffmerge.impl.policies.DefaultDiffPolicy#coverFeature(org.eclipse.emf.ecore.EStructuralFeature)
   */
  @Override
  public boolean coverFeature(EStructuralFeature feature) {
    return !UNSIGNIFICANT_REFERENCES.contains(feature) && super.coverFeature(feature);
  }
}
