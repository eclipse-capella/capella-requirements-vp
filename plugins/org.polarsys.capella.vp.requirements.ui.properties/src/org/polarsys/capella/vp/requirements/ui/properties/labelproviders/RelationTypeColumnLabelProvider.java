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
package org.polarsys.capella.vp.requirements.ui.properties.labelproviders;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;

public class RelationTypeColumnLabelProvider extends ColumnLabelProvider {

  @Override
  public String getText(Object element) {
    if (element instanceof AbstractRelation && ((AbstractRelation)element).getRelationType() != null) {
      return ((AbstractRelation)element).getRelationType().getReqIFLongName();
    }
    return ICommonConstants.EMPTY_STRING;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Image getImage(Object element) {
    return super.getImage(element);
  }
}