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
package org.polarsys.capella.vp.requirements.Requirements.provider;

import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaModule;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaTypesFolder;
import org.polarsys.capella.vp.requirements.CapellaRequirements.provider.CapellaRequirementsItemProviderAdapterFactory;
import org.polarsys.capella.vp.requirements.model.edit.decorators.ForwardingItemProviderAdapterDecorator;

/**
 * @author Joao Barata
 */
public class CapellaRequirementsItemProviderDecoratorAdapterFactory extends DecoratorAdapterFactory {

	public CapellaRequirementsItemProviderDecoratorAdapterFactory() {
		super(new CapellaRequirementsItemProviderAdapterFactory());
	}

	@Override
	protected IItemProviderDecorator createItemProviderDecorator(Object target, Object Type) {
	  if (target instanceof CapellaModule) {
      return new CapellaModuleItemProviderDecorator(this);
    } else if (target instanceof CapellaTypesFolder) {
      return new CapellaTypesFolderItemProviderDecorator(this);
    } else if (target instanceof CapellaIncomingRelation) {
      return new CapellaIncomingRelationItemProviderDecorator(this);
    } else if (target instanceof CapellaOutgoingRelation) {
      return new CapellaOutgoingRelationItemProviderDecorator(this);
    }
		return new ForwardingItemProviderAdapterDecorator(this);
	}
}
