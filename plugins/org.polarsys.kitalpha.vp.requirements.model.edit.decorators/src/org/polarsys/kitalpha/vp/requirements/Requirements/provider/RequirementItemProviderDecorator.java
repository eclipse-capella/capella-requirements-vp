/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
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
package org.polarsys.kitalpha.vp.requirements.Requirements.provider;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.interpreter.CompoundInterpreter;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesConstants;
import org.polarsys.capella.vp.requirements.importer.preferences.RequirementsPreferencesPlugin;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.model.edit.decorators.ItemProviderAdapterDecorator;
import org.polarsys.kitalpha.vp.requirements.model.helpers.LabelHelper;

/**
 * @author Joao Barata
 */
public class RequirementItemProviderDecorator extends ItemProviderAdapterDecorator
    implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
    IItemPropertySource {

  public RequirementItemProviderDecorator(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This method allows to retrieve a session from elements attached to the 'holding resource' (ie. diff/merge dialog)
   * 
   * @param element
   * @return a session related to the given element
   */
  protected Session getRelatedSession(EObject element) {
    Session session = SessionManager.INSTANCE.getSession(element);
    if (session == null) {
      TransactionalEditingDomain domain = TransactionHelper.getEditingDomain(element);
      for (Session activeSession : SessionManager.INSTANCE.getSessions()) {
        if (activeSession.getTransactionalEditingDomain().equals(domain)) {
          return activeSession;
        }
      }
    }
    return session;
  }

  /**
   * @param object
   * @return
   */
  @Override
  public String getText(Object object) {
    Requirement requirement = (Requirement) object;
    try {
      Session session = getRelatedSession(requirement);
      IInterpreter interpreter = null;
      if (session != null) {
        interpreter = session.getInterpreter();
      } else
        interpreter = CompoundInterpreter.INSTANCE;
      if (interpreter != null) {
        String expression = RequirementsPreferencesPlugin.getDefault().getPreferenceStore()
            .getString(RequirementsPreferencesConstants.REQUIREMENT_LABEL_EXPRESSION_KEY);
        Object value = interpreter.evaluate(requirement, expression);
        String result = "";
        if (value instanceof List<?>) {
          for (Object item : (List) value) {
            result += item;
          }
        } else {
          result += value;
        }
        result = LabelHelper.unescape(LabelHelper.transformHTMLToText(result));
        return reduceReqNameLen(result, RequirementsPreferencesPlugin.getDefault().getPreferenceStore()
            .getString(RequirementsPreferencesConstants.REQUIREMENT_LABEL_MAX_LEN_KEY));
      }
    } catch (EvaluationException ex) {
      return "[Error in label expression] " + super.getText(object);
    }
    return super.getText(object);
  }

  /**
   * 
   * @param reqName
   * @return a reduced requirement name with length = MAX_LEN
   */
  protected String reduceReqNameLen(String reqName, String strMaxLen) {
    if (strMaxLen.length() == 0)
      return reqName;
    int maxLen = Integer.parseInt(strMaxLen);
    if (reqName.length() > maxLen)
      return reqName.substring(0, maxLen).concat("...");
    return reqName;
  }
}