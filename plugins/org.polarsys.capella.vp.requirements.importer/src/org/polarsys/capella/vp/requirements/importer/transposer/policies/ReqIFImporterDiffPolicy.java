/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

  /**
   * @see org.eclipse.emf.diffmerge.impl.policies.ConfigurableDiffPolicy#doConsiderOrdered(org.eclipse.emf.ecore.EStructuralFeature)
   */
  @Override
  protected boolean doConsiderOrdered(EStructuralFeature feature) {
    return super.doConsiderOrdered(feature) &&
        !SEMANTICALLY_UNORDERED_REFERENCES.contains(feature);
  }
}
