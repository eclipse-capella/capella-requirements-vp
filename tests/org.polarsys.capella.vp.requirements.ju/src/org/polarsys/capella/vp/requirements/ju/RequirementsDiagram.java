/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ju;

import org.eclipse.sirius.diagram.DDiagram;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.vp.requirements.ju.tools.CreateDEdgeRequirementLinkTool;
import org.polarsys.capella.vp.requirements.ju.tools.InsertRemoveRequirementTool;

public class RequirementsDiagram extends DiagramContext {

  public static final String CREATE_REQUIREMENT_LINK_TOOL_NAME = "Requirement Link";
  public static final String SHOW_HIDE_REQUIREMENTS_TOOL_NAME = "Requirements";
  public static final String SHOW_HIDE_ALL_LINKED_REQUIREMENTS_TOOL_NAME = "All Linked Requirements";
  public static final String SHOW_HIDE_INCOMING_REQUIREMENTS_TOOL_NAME = "Incoming Requirements";
  public static final String SHOW_HIDE_OUTGOING_REQUIREMENTS_TOOL_NAME = "Outgoing Requirements";

  public RequirementsDiagram(SessionContext context, DDiagram diagram) {
    super(context, diagram);
  }

  public void createRequirementLink(String sourceId, String targetId) {
    new CreateDEdgeRequirementLinkTool(this, sourceId, targetId).run();
  }

  public void showRequirements(final String... id) {
    new InsertRemoveRequirementTool(this, SHOW_HIDE_REQUIREMENTS_TOOL_NAME).insert(id);
  }

  public void hideRequirements(final String... id) {
    new InsertRemoveRequirementTool(this, SHOW_HIDE_REQUIREMENTS_TOOL_NAME).remove(id);
  }

  public void showAllLinkedRequirements(String containerId) {
    new InsertRemoveRequirementTool(this, SHOW_HIDE_ALL_LINKED_REQUIREMENTS_TOOL_NAME, containerId).insertAll();
  }

  public void showIncomingRequirements(String id, String containerId) {
    new InsertRemoveRequirementTool(this, SHOW_HIDE_INCOMING_REQUIREMENTS_TOOL_NAME, containerId).insert(id);
  }

  public void hideIncomingRequirements(String id, String containerId) {
    new InsertRemoveRequirementTool(this, SHOW_HIDE_INCOMING_REQUIREMENTS_TOOL_NAME, containerId).remove(id);
  }

  public void showOutgoingRequirements(String id, String containerId) {
    new InsertRemoveRequirementTool(this, SHOW_HIDE_OUTGOING_REQUIREMENTS_TOOL_NAME, containerId).insert(id);
  }

  public void hideOutgoingRequirements(String id, String containerId) {
    new InsertRemoveRequirementTool(this, SHOW_HIDE_OUTGOING_REQUIREMENTS_TOOL_NAME, containerId).remove(id);
  }
}
