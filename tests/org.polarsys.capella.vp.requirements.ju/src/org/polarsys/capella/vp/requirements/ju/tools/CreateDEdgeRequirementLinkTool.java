/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ju.tools;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNodeListElement;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.step.tools.CreateDEdgeTool;
import org.polarsys.capella.test.diagram.common.ju.wrapper.utils.ArgumentType;
import org.polarsys.capella.vp.requirements.ju.RequirementsDiagram;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;

public class CreateDEdgeRequirementLinkTool extends CreateDEdgeTool {

  public CreateDEdgeRequirementLinkTool(DiagramContext context, String sourceView, String targetView) {
    super(context, RequirementsDiagram.CREATE_REQUIREMENT_LINK_TOOL_NAME, sourceView, targetView);
  }
  
  @Override
  protected void initToolArguments() {
    DSemanticDecorator edgeSourceView = getDiagramContext().getView(_sourceView);
    if (edgeSourceView instanceof DNodeListElement) {
      edgeSourceView = (DSemanticDecorator) edgeSourceView.eContainer(); // Move up to DNodeList
    }
    _toolWrapper.setArgumentValue(ArgumentType.SOURCE, edgeSourceView);

    DSemanticDecorator edgeTargetView = getDiagramContext().getView(_targetView);
    if (edgeTargetView instanceof DNodeListElement) {
      edgeTargetView = (DSemanticDecorator) edgeTargetView.eContainer(); // Move up to DNodeList
    }
    _toolWrapper.setArgumentValue(ArgumentType.TARGET, edgeTargetView);
  }
  
  @Override
  public DEdge getResult() {
    DEdge createdEdgeView = (DEdge) _newEdgesElements.iterator().next();
    EObject edgeTarget = createdEdgeView.getTarget();
    if (edgeTarget instanceof AbstractRelation) {
      String edgeId = ((AbstractRelation) edgeTarget).getId();
      
      getExecutionContext().putSemanticElement(edgeId, edgeTarget);
      getDiagramContext().putView(edgeId, createdEdgeView);
      
      return createdEdgeView;
    }
    
    return super.getResult();
  }
}
