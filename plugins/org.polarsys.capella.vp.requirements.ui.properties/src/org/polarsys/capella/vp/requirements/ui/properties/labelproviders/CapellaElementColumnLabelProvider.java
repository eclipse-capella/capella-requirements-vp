/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.properties.labelproviders;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.common.ui.services.helper.EObjectLabelProviderHelper;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;

/**
   */
  public class CapellaElementColumnLabelProvider extends ColumnLabelProvider {
    @Override
    public String getText(Object element) {
      if (element instanceof CapellaOutgoingRelation) {
        CapellaElement source = ((CapellaOutgoingRelation) element).getSource();
        return source != null ? source.getLabel() : ICommonConstants.EMPTY_STRING;
      } else if (element instanceof CapellaIncomingRelation) {
        CapellaElement target = ((CapellaIncomingRelation) element).getTarget();
        return target != null ? target.getLabel() : ICommonConstants.EMPTY_STRING;
      }
      return ICommonConstants.EMPTY_STRING;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Image getImage(Object element) {
      if (element instanceof CapellaOutgoingRelation)
        return EObjectLabelProviderHelper.getImage(((CapellaOutgoingRelation) element).getSource());
      else if (element instanceof CapellaIncomingRelation)
        return EObjectLabelProviderHelper.getImage(((CapellaIncomingRelation) element).getTarget());
      return super.getImage(element);
    }
  }