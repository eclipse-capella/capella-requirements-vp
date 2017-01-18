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

import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.common.ui.services.helper.EObjectLabelProviderHelper;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.provider.RequirementsItemProviderDecoratorAdapterFactory;

public class RequirementColumnLabelProvider extends ColumnLabelProvider {

  @Override
  public String getText(Object element) {

    Requirement requirement = null;
    if (element instanceof CapellaOutgoingRelation)
      requirement = ((CapellaOutgoingRelation) element).getTarget();
    else if (element instanceof CapellaIncomingRelation)
      requirement = ((CapellaIncomingRelation) element).getSource();
    else if (element instanceof InternalRelation)
      requirement = ((InternalRelation) element).getTarget();

    if (requirement != null) {
      IItemLabelProvider adapted = (IItemLabelProvider) (new RequirementsItemProviderDecoratorAdapterFactory())
          .adapt(requirement, IItemLabelProvider.class);
      return adapted.getText(requirement);
    }
    
    return ICommonConstants.EMPTY_STRING;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Image getImage(Object element) {
    if (element instanceof CapellaOutgoingRelation)
      return EObjectLabelProviderHelper.getImage(((CapellaOutgoingRelation) element).getTarget());
    else if (element instanceof CapellaIncomingRelation)
      return EObjectLabelProviderHelper.getImage(((CapellaIncomingRelation) element).getSource());
    else if (element instanceof InternalRelation)
      return EObjectLabelProviderHelper.getImage(((InternalRelation) element).getTarget());
    return super.getImage(element);
  }
}