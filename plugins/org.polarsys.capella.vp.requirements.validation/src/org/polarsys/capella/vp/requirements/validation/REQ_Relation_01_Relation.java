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
package org.polarsys.capella.vp.requirements.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.core.validation.rule.AbstractValidationRule;
import org.polarsys.capella.vp.requirements.Requirements.provider.CapellaRequirementsItemProviderDecoratorAdapterFactory;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.provider.RequirementsItemProviderDecoratorAdapterFactory;

public class REQ_Relation_01_Relation extends AbstractValidationRule {

  @Override
  public IStatus validate(IValidationContext ctx) {
    AbstractRelation relation = (AbstractRelation) ctx.getTarget();
    if (relation.getRelationType() == null) {
      IItemLabelProvider adapted = (IItemLabelProvider) (new RequirementsItemProviderDecoratorAdapterFactory())
          .adapt(relation, IItemLabelProvider.class);
      
      if (adapted == null) {
        adapted = (IItemLabelProvider) (new CapellaRequirementsItemProviderDecoratorAdapterFactory())
            .adapt(relation, IItemLabelProvider.class);
      }
      return ctx.createFailureStatus(
          new Object[] { adapted != null ? adapted.getText(relation) : relation.getReqIFLongName() });
    }
    return ctx.createSuccessStatus();
  }

}
