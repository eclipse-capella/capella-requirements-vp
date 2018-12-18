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
package org.polarsys.capella.vp.requirements.ui.properties.controllers;

import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.polarsys.capella.vp.requirements.CapellaRequirements.impl.CapellaOutgoingRelationImpl;

public class DiagramOutgoingLink extends CapellaOutgoingRelationImpl {

  private DRepresentationDescriptor containingDescriptor;
  private String id;
  
  public DiagramOutgoingLink(DRepresentationDescriptor containingDescriptor, String id) {
    this.containingDescriptor = containingDescriptor;
    this.id = id;
  }

  public DRepresentationDescriptor getContainingRepresentation() {
    return containingDescriptor;
  }
  
  public String getId() {
    return id;
  }
}
