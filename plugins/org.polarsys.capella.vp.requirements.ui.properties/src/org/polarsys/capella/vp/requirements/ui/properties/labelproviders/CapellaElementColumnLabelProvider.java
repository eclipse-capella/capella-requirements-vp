/*******************************************************************************
 * Copyright (c) 2017, 2019 THALES GLOBAL SERVICES.
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

import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
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
      CapellaElement extractedElement = null;
      
      if (element instanceof CapellaOutgoingRelation) {
        extractedElement = ((CapellaOutgoingRelation) element).getSource();
      }
      else if (element instanceof CapellaIncomingRelation) {
        extractedElement = ((CapellaIncomingRelation) element).getTarget();
      }
      
      if(extractedElement != null) {
        Object imagePointer = EObjectLabelProviderHelper.getImage(extractedElement);
        return ExtendedImageRegistry.getInstance().getImage(imagePointer);
      }
      
      return super.getImage(element);
    }
  }