/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ui.commands;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.viewpoint.DAnalysisCustomData;
import org.eclipse.sirius.viewpoint.ViewpointFactory;

/**
 * The command for modifying the custom data of requirements VP in EMF resource.
 * @author S0070513
 *
 */
public class SaveQueriesCommand extends RecordingCommand {

  private Session session;
  private EAnnotation queriesAnnotation;
  private String labelExpression;
  private String contentExpression;
  private String labelMaxLength;
  private String contentMaxLength;

  public SaveQueriesCommand(TransactionalEditingDomain domain, Session session, EAnnotation queriesAnnotation,
      String labelExpression, String contentExpression, String labelMaxLength, String contentMaxLength) {
    super(domain);
    this.session = session;
    this.queriesAnnotation = queriesAnnotation;
    this.labelExpression = labelExpression;
    this.contentExpression = contentExpression;
    this.labelMaxLength = labelMaxLength;
    this.contentMaxLength = contentMaxLength;
  }

  @Override
  protected void doExecute() {
    queriesAnnotation.getDetails().put(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL,
        labelExpression);
    queriesAnnotation.getDetails().put(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT,
        contentExpression);
    queriesAnnotation.getDetails().put(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL_LENGTH,
        labelMaxLength);
    queriesAnnotation.getDetails().put(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT_LENGTH,
        contentMaxLength);

    DAnalysisCustomData customDataForReqVP = null;
    Resource resource = ReqVPCustomDataHelper.getResource(session);
    for (EObject content : resource.getContents()) {
      if (content instanceof DAnalysisCustomData) {
        DAnalysisCustomData customData = (DAnalysisCustomData) content;
        if (ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES.equals(customData.getKey())) {
          customDataForReqVP = customData;
          break;
        }
      }
    }
    if (customDataForReqVP == null) {
      customDataForReqVP = ViewpointFactory.eINSTANCE.createDAnalysisCustomData();
      resource.getContents().add(customDataForReqVP);
    }

    customDataForReqVP.setKey(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES);
    customDataForReqVP.setData(queriesAnnotation);
  }
}
