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
package org.polarsys.kitalpha.vp.requirements.Requirements.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesPlugin;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute;
import org.polarsys.kitalpha.vp.requirements.model.edit.decorators.ItemProviderAdapterDecorator;

public class EnumerationValueAttributeItemProviderDecorator extends ItemProviderAdapterDecorator
    implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
    IItemPropertySource {

  public EnumerationValueAttributeItemProviderDecorator(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  @Override
  public String getText(Object object) {
    EnumerationValueAttribute attribute = (EnumerationValueAttribute) object;

    StringBuilder result = new StringBuilder();
    AttributeDefinition definition = attribute.getDefinition();
    if (definition != null) {
      result.append("[" + definition.getReqIFLongName() + "]");
    } else {
      result.append("[" + EObjectLabelProviderHelper.getMetaclassLabel((EObject)object, false) + "]");
    }

    result.append(" ");
    
    String strEnumValues = "";
    for (int i = 0; i < attribute.getValues().size(); i++) {
      result.append(attribute.getValues().get(i).getReqIFLongName());
      if (i != attribute.getValues().size() - 1)
        result.append(", ");
    }
    
    result.append(strEnumValues);

    return reduceValueLabelLen(result.toString(),
        RequirementsPreferencesPlugin.getDefault().getPreferenceStore()
        .getString(RequirementsPreferencesConstants.VALUE_LABEL_MAX_LEN));
  }

  /**
   * 
   * @param reqName
   * @return a reduced value label with length = MAX_LEN
   */
  protected String reduceValueLabelLen(String reqName, String strMaxLen) {
    if (strMaxLen.length() == 0)
      return reqName;
    int maxLen = Integer.parseInt(strMaxLen);
    if (reqName.length() > maxLen)
      return reqName.substring(0, maxLen).concat("...");
    return reqName;
  }
}
