/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.vp.requirements.Requirements.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute;
import org.polarsys.kitalpha.vp.requirements.model.edit.decorators.ItemProviderAdapterDecorator;

/**
 * @author Joao Barata
 */
public class DateValueAttributeItemProviderDecorator extends
		ItemProviderAdapterDecorator implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {

	public DateValueAttributeItemProviderDecorator(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
  public String getText(Object object) {
    DateValueAttribute attribute = (DateValueAttribute) object;

    StringBuilder result = new StringBuilder();
    AttributeDefinition definition = attribute.getDefinition();
    if (definition != null) {
      result.append("[" + definition.getReqIFLongName() + "]");
    } else {
      result.append("[" + EObjectLabelProviderHelper.getMetaclassLabel((EObject)object, false)+ "]");
    }
    
    result.append(" ");
    result.append(attribute.getValue());
    
    return result.toString();
  }
}
