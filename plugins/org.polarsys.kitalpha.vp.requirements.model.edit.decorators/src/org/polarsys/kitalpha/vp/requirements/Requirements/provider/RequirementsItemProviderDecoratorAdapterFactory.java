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
package org.polarsys.kitalpha.vp.requirements.Requirements.provider;

import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.DataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.Folder;
import org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.Module;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute;
import org.polarsys.kitalpha.vp.requirements.model.edit.decorators.ForwardingItemProviderAdapterDecorator;

/**
 * @author Joao Barata
 */
public class RequirementsItemProviderDecoratorAdapterFactory extends DecoratorAdapterFactory {

	public RequirementsItemProviderDecoratorAdapterFactory() {
		super(new RequirementsItemProviderAdapterFactory());
	}

	@Override
	protected IItemProviderDecorator createItemProviderDecorator(Object target, Object Type) {
	  if (target instanceof Module) {
      return new ModuleItemProviderDecorator(this);
    } else if (target instanceof Folder) {
      return new FolderItemProviderDecorator(this);
    } else if (target instanceof Requirement) {
			return new RequirementItemProviderDecorator(this);
		} else if (target instanceof IntegerValueAttribute) {
      return new IntegerValueAttributeItemProviderDecorator(this);
    } else if (target instanceof StringValueAttribute) {
      return new StringValueAttributeItemProviderDecorator(this);
    } else if (target instanceof AttributeDefinition) {
      return new AttributeDefinitionItemProviderDecorator(this);
    } else if (target instanceof DataTypeDefinition) {
      return new DataTypeDefinitionItemProviderDecorator(this);
    }
		return new ForwardingItemProviderAdapterDecorator(this);
	}
}
