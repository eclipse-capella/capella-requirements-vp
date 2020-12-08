/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.id.handler;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement;
import org.polarsys.capella.shared.id.handler.AbstractIdHandler;

/**
 * Contribute an ID handler for IdManager
 */
public class IdentifiableElementIdHandler extends AbstractIdHandler {

  /**
   * Default constructor
   */
  public IdentifiableElementIdHandler() {
    //Do nothing
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getId(EObject object) {
    if (object instanceof IdentifiableElement) {
      return ((IdentifiableElement) object).getId();
    }
    return null;
  }

}
