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
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.model.edit.decorators.ItemProviderAdapterDecorator;

/**
 * @author Joao Barata
 */
public class InternalRelationItemProviderDecorator extends
		ItemProviderAdapterDecorator implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {

	public InternalRelationItemProviderDecorator(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
  public String getText(Object object) {
    InternalRelation relation = (InternalRelation) object;

    StringBuilder builder = new StringBuilder();
    RelationType type = relation.getRelationType();
    Requirement target = relation.getTarget();
    if (type != null) {
      builder.append("[" + type.getReqIFLongName() + "] " );
    }else{
      builder.append("[undefined] ");
    }
    if(target != null){
      builder.append(EObjectLabelProviderHelper.getText(target));
    }
return builder.toString();
  }
}
