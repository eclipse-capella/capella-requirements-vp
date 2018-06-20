/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.core.data.capellamodeller.SystemEngineering;

/**
 * The handler when menu item "Configure Requirement Labels In Diagram" is clicked.
 * It will open a configuration wizard allowing user to modify the AQL expressions.
 * @author S0070513
 *
 */
public class ReqVPConfigureCommandHandler implements IHandler {

  @Override
  public void addHandlerListener(IHandlerListener handlerListener) {
    // Nothing
  }

  @Override
  public void dispose() {
    // Nothing to dispose
  }

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    SystemEngineering selectedSystemEngineering = null;

    try {
      ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
      ITreeSelection selection = (ITreeSelection) selectionService.getSelection();
      selectedSystemEngineering = (SystemEngineering) selection.getFirstElement();
    } catch (Exception e) {
      selectedSystemEngineering = null;
    }

    if (selectedSystemEngineering != null) {
      final Session session = SessionManager.INSTANCE.getSession(selectedSystemEngineering);
      String labelExpression = null;
      String labelMaxLength = null;
      String contentExpression = null;
      String contentMaxLength = null;
      EAnnotation queriesAnnotation = ReqVPCustomDataHelper.getCustomData(session);

      if (queriesAnnotation == null) {
        queriesAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
      } else {
        labelExpression = queriesAnnotation.getDetails()
            .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL);
        labelMaxLength = queriesAnnotation.getDetails()
            .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL_LENGTH);
        contentExpression = queriesAnnotation.getDetails()
            .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT);
        contentMaxLength = queriesAnnotation.getDetails()
            .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT_LENGTH);
      }

      ReqVPConfigureDialog dialog = new ReqVPConfigureDialog(Display.getCurrent().getActiveShell(), labelExpression,
          contentExpression, labelMaxLength, contentMaxLength);
      dialog.create();
      
      if (dialog.open() == Window.OK) {
        TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
        domain.getCommandStack()
            .execute(new SaveQueriesCommand(domain, session, queriesAnnotation, dialog.getLabelExpression(),
                dialog.getContentExpression(), dialog.getLabelMaxLength(), dialog.getContentMaxLength()));
      }
    }

    return null;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean isHandled() {
    return true;
  }

  @Override
  public void removeHandlerListener(IHandlerListener handlerListener) {
    // Nothing
  }

}
