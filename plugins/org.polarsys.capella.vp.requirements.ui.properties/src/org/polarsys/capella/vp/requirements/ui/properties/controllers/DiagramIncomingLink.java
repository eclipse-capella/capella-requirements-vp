/*******************************************************************************
 * Copyright (c) 2017, 2018 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ui.properties.controllers;

import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaIncomingRelationImpl;

public class DiagramIncomingLink extends CapellaIncomingRelationImpl {

  private DRepresentationDescriptor containingDescriptor;
  private DAnnotation annotation;

  public DAnnotation getAnnotation() {
    return annotation;
  }

  public DiagramIncomingLink(DRepresentationDescriptor containingDescriptor, DAnnotation annotation) {
    this.containingDescriptor = containingDescriptor;
    this.annotation = annotation;
  }

  public DRepresentationDescriptor getContainingRepresentation() {
    return containingDescriptor;
  }
  
  public String getId() {
    return annotation.getUid();
  }
}
