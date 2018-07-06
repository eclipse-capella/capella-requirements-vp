/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ju.misc;

import org.eclipse.sirius.diagram.DDiagram;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.step.tools.CreateDEdgeTool;
import org.polarsys.capella.test.framework.context.SessionContext;

public class RequirementsDiagram extends DiagramContext {
	
	public static String CREATE_REQUIREMENT_LINK_TOOL_NAME           = "Requirement Link";
	public static String SHOW_HIDE_REQUIREMENTS_TOOL_NAME            = "Requirements";
	public static String SHOW_HIDE_ALL_LINKED_REQUIREMENTS_TOOL_NAME = "All Linked Requirements";
	public static String SHOW_HIDE_INCOMING_REQUIREMENTS_TOOL_NAME   = "Incoming Requirements";
	public static String SHOW_HIDE_OUTGOING_REQUIREMENTS_TOOL_NAME   = "Outgoing Requirements";
	
	public RequirementsDiagram(SessionContext context, DDiagram diagram) {
		super(context, diagram);
	}

	public void createRequirementLink(String sourceId, String targetId) {
	    new CreateDEdgeTool(this, CREATE_REQUIREMENT_LINK_TOOL_NAME, sourceId, targetId).run();
	}
	
	public void showRequirements(final String id) {
		new InsertRemoveRequirementTool(this, SHOW_HIDE_REQUIREMENTS_TOOL_NAME).insert(id);
	}
	
	public void showRequirements(final String[] id) {
		new InsertRemoveRequirementTool(this, SHOW_HIDE_REQUIREMENTS_TOOL_NAME).insert(id);
	}

	public void hideRequirements(final String id) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_REQUIREMENTS_TOOL_NAME).remove(id);
	}
	
	public void hideRequirements(final String[] id) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_REQUIREMENTS_TOOL_NAME).remove(id);
	}
	
	public void showRequirements(String id, String containerId) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_REQUIREMENTS_TOOL_NAME, containerId).insert(id);
	}
	
	public void hideRequirements(String id, String containerId) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_REQUIREMENTS_TOOL_NAME, containerId).remove(id);
	}

	public void showAllLinkedRequirements() {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_ALL_LINKED_REQUIREMENTS_TOOL_NAME).insertAll();
	}
	
	public void showAllLinkedRequirements(String containerId) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_ALL_LINKED_REQUIREMENTS_TOOL_NAME, containerId).insertAll();
	}
	
	public void showIncomingRequirements(String id) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_INCOMING_REQUIREMENTS_TOOL_NAME).insert(id);
	}
		
	public void hideIncomingRequirements(String id) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_INCOMING_REQUIREMENTS_TOOL_NAME).remove(id);
	}
	
	public void showIncomingRequirements(String id, String containerId) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_INCOMING_REQUIREMENTS_TOOL_NAME, containerId).insert(id);
	}
	
	public void hideIncomingRequirements(String id, String containerId) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_INCOMING_REQUIREMENTS_TOOL_NAME, containerId).remove(id);
	}
	
	public void showOutgoingRequirements(String id) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_OUTGOING_REQUIREMENTS_TOOL_NAME).insert(id);
	}
	
	public void hideOutgoingRequirements(String id) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_OUTGOING_REQUIREMENTS_TOOL_NAME).remove(id);
	}
	
	public void showOutgoingRequirements(String id, String containerId) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_OUTGOING_REQUIREMENTS_TOOL_NAME, containerId).insert(id);
	}
	
	public void hideOutgoingRequirements(String id, String containerId) {
	    new InsertRemoveRequirementTool(this, SHOW_HIDE_OUTGOING_REQUIREMENTS_TOOL_NAME, containerId).remove(id);
	}
}
