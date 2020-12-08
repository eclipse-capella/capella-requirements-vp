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
package org.polarsys.capella.vp.requirements.ju.testcases;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElementContainer;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.test.diagram.common.ju.api.AbstractDiagramTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.vp.requirements.ju.RequirementsDiagram;

public class RequirementsToolsTestCase extends AbstractDiagramTestCase {

  private static final String REQ_1 = "fe5ca911-1f2f-40eb-932b-3e4dab3eed86";
  private static final String REQ_2 = "269f08ec-513d-41fd-96ec-1ee6c2dbd8cd";
  private static final String REQ_3 = "bd488918-1fa9-4278-a9c9-18874d4ddeb2";
  private static final String REQ_4 = "4eff0b4f-cbf5-434b-b021-69b882b6e2f5";
  private static final String REQ_5 = "aae247d0-5cc1-4dba-8a26-a9370c976366";

  @Override
  protected String getRequiredTestModel() {
    return "In-Flight Entertainment System With Requirements";
  }

  @Override
  public void test() throws Exception {
    Session session = getSession(getRequiredTestModel());
    SessionContext sessionContext = new SessionContext(session);

    Set<String> alreadyTested = new HashSet<>();
    for (DRepresentation representation : DialectManager.INSTANCE.getAllRepresentations(session)) {
      if (representation instanceof DDiagram) {
        DDiagram diagram = (DDiagram) representation;
        String diagramType = diagram.getDescription().getName();
        if (!alreadyTested.contains(diagramType)) {
          alreadyTested.add(diagramType);
          testRequirementsToolsOnDiagram(diagram, sessionContext);
        }
      }
    }
  }

  /**
   * Return the first node target or container target of the diagram
   * 
   * @param diagram
   * @return
   */
  private String getFirstCapellaElement(RequirementsDiagram diagram) {
    for (DNode node : diagram.getDiagram().getNodes()) {
      EObject nodeTarget = node.getTarget();
      if (nodeTarget instanceof CapellaElement) {
        CapellaElement target = (CapellaElement) nodeTarget;
        return target.getId();
      }
    }
    for (DDiagramElementContainer container : diagram.getDiagram().getContainers()) {
      EObject containerTarget = container.getTarget();
      if (containerTarget instanceof CapellaElement) {
        CapellaElement target = (CapellaElement) containerTarget;
        return target.getId();
      }
    }
    return null;
  }

  /**
   * Called on each diagram and scenario of the model
   * 
   * @param rep
   * @param sessionContext
   */
  private void testRequirementsToolsOnDiagram(DDiagram rep, SessionContext sessionContext) {
    System.out.println("Test requirements tools on diagram: " + rep.getName());
    RequirementsDiagram diagram = new RequirementsDiagram(sessionContext, rep);

    // Using tools for testing on a requirement
    diagram.showRequirements(REQ_3);
    testRequirementsToolsOnGivenElement(diagram, REQ_3, REQ_1, REQ_2);
    diagram.hideRequirements(REQ_3);

    // Using tools for testing on a capella diagram element
    String aCapellaElement = getFirstCapellaElement(diagram);
    if (aCapellaElement != null) {
      testRequirementsToolsOnGivenElement(diagram, aCapellaElement, REQ_4, REQ_5);
    }
  }

  /**
   * @param diagram
   * @param id
   * @param IdIsDiagram
   */
  private void testRequirementsToolsOnGivenElement(RequirementsDiagram diagram, String id, String incomingReq,
      String outgoingReq) {
    // Show the requirements on the diagrams
    diagram.showRequirements(incomingReq, outgoingReq);
    diagram.hasView(outgoingReq);
    diagram.hasView(incomingReq);

    // create Requirement Links if element is not a diagram
    diagram.createRequirementLink(id, outgoingReq);
    diagram.createRequirementLink(incomingReq, id);

    // hide Outgoing Requirements
    diagram.hideOutgoingRequirements(outgoingReq, id);
    diagram.hasntView(outgoingReq);

    // hide Incoming Requirements
    diagram.hideIncomingRequirements(incomingReq, id);
    diagram.hasntView(incomingReq);

    // show Outgoing Requirements
    diagram.showOutgoingRequirements(outgoingReq, id);
    diagram.hasView(outgoingReq);

    // show Incoming Requirements
    diagram.showIncomingRequirements(incomingReq, id);
    diagram.hasView(incomingReq);

    // hide Requirements
    diagram.hideRequirements(outgoingReq, incomingReq);
    diagram.hasntView(outgoingReq);
    diagram.hasntView(incomingReq);

    // show all Linked Requirements
    diagram.showAllLinkedRequirements(id);
    diagram.hasView(outgoingReq);
    diagram.hasView(incomingReq);
  }
}
