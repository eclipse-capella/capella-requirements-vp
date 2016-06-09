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

import java.util.List;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesPlugin;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.model.edit.decorators.ItemProviderAdapterDecorator;

/**
 * @author Joao Barata
 */
public class RequirementItemProviderDecorator extends
		ItemProviderAdapterDecorator implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {

	public RequirementItemProviderDecorator(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
  public String getText(Object object) {
    Requirement requirement = (Requirement) object;
    try {
      Session session = SessionManager.INSTANCE.getSession(requirement);
      if (session != null) {
        IInterpreter interpreter = session.getInterpreter();
        if (interpreter != null) {
          IEclipsePreferences scope = InstanceScope.INSTANCE.getNode(RequirementsPreferencesPlugin.PLUGIN_ID);
          String expression = scope.get(RequirementsPreferencesConstants.REQUIREMENT_LABEL_EXPRESSION, RequirementsPreferencesConstants.REQUIREMENT_DEFAULT_LABEL_EXPRESSION);
          Object value = interpreter.evaluate(requirement, expression);
          if (value instanceof List<?>) {
    	    value = ((List<?>) value).get(0);
          }
          if (value instanceof String) {
    	    return (String) value;
          }
        }
      }
    } catch (EvaluationException ex) {
      ex.printStackTrace();
    }
    return super.getText(object);
  }
}
