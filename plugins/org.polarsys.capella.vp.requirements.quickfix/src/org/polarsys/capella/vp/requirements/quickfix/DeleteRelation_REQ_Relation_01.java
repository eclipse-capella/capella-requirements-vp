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

import org.polarsys.capella.core.validation.ui.ide.quickfix.AbstractDeleteCommandResolver;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;

public class DeleteRelation_REQ_Relation_01 extends AbstractDeleteCommandResolver {

  @Override
  public Object getElementToDelete(Object obj) {
    if (obj instanceof AbstractRelation) {
      return obj;
    }
    return null;
  }

}
