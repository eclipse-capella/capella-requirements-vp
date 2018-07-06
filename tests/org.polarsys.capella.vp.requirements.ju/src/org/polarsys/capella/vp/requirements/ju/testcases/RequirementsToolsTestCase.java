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
package org.polarsys.capella.vp.requirements.ju.testcases;

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
import org.polarsys.capella.vp.requirements.ju.misc.RequirementsDiagram;

public class RequirementsToolsTestCase extends AbstractDiagramTestCase {
  
  private static String REQ_1 = "fe5ca911-1f2f-40eb-932b-3e4dab3eed86";
  private static String REQ_2 = "269f08ec-513d-41fd-96ec-1ee6c2dbd8cd";
  private static String REQ_3 = "bd488918-1fa9-4278-a9c9-18874d4ddeb2";
  private static String REQ_4 = "4eff0b4f-cbf5-434b-b021-69b882b6e2f5";
  private static String REQ_5 = "aae247d0-5cc1-4dba-8a26-a9370c976366";
  
  @Override
  protected String getRequiredTestModel() {
    return "In-Flight Entertainment System With Requirements";
  }

  @Override
  public void test() throws Exception {
    Session session = getSession(getRequiredTestModel());
    SessionContext sessionContext = new SessionContext(session);
  
    for (DRepresentation representation : DialectManager.INSTANCE.getAllRepresentations(session)) {
      if (representation instanceof DDiagram) {
        DDiagram diagram = (DDiagram) representation;
        testRequirementsToolsOnDiagram(diagram, sessionContext);
      }
    }
  }
  
  /**
   * Return the first node target or container target of the diagram
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
   * @param rep
   * @param sessionContext
   */
  private void testRequirementsToolsOnDiagram(DDiagram rep, SessionContext sessionContext) {
      
    RequirementsDiagram diagram = new RequirementsDiagram(sessionContext, rep);
    diagram.open();
    
    // test on diagram
//    testRequirementsToolsOnGivenElement(diagram, diagram.getDiagramId());
    
    // test on a Requirement
    testRequirementsToolsOnGivenElement(diagram, REQ_3, REQ_1, REQ_2);
    
    // test on a Capella Element
    String CAPELLA_ELEMENT_1 = getFirstCapellaElement(diagram);
    if (CAPELLA_ELEMENT_1 == null) {
      fail("No Capella Element found in this diagram: "+rep.getName());
    } else {
      testRequirementsToolsOnGivenElement(diagram, CAPELLA_ELEMENT_1, REQ_4, REQ_5);
    }
  }
  
  /**
   * called on a capella element, a requirement, and the back of the given diagram
   * @param diagram
   * @param id
   * @param IdIsDiagram
   */
  private void testRequirementsToolsOnGivenElement(RequirementsDiagram diagram, String id, String incomingReq, String outgoingReq) {
      
    // show Requirements
    if (id.equals(REQ_3)) {
      diagram.showRequirements(outgoingReq, incomingReq, REQ_3);
    } else {
      diagram.showRequirements(outgoingReq, incomingReq);
    }
    
    // create Requirement Links
    if (!id.equals(diagram.getDiagramId())) {
      diagram.createRequirementLink(id, outgoingReq);
      diagram.createRequirementLink(incomingReq, id);
    } else {
      // cannot use Requirement Links tool for diagram
      
    }
    
    // hide Incoming/Outgoing Requirements
    diagram.hideOutgoingRequirements(outgoingReq, id);
    diagram.hideIncomingRequirements(incomingReq, id);
      
    // show Incoming/Outgoing Requirements
    diagram.showOutgoingRequirements(outgoingReq, id);
    diagram.showIncomingRequirements(incomingReq, id);
    
    // hide Requirements
    diagram.hideRequirements(new String[]{outgoingReq, incomingReq});
    
    // REQ_3 must stay
    if (id.equals(REQ_3)) {
      diagram.showRequirements(REQ_3);
      diagram.hasView(REQ_3);
    }
    
    // show all Linked Requirements
    diagram.hasntView(outgoingReq);
    diagram.hasntView(incomingReq);
    diagram.showAllLinkedRequirements(id);
    diagram.hasView(outgoingReq);
    diagram.hasView(incomingReq);
    
    // REQ_3 must stay
    if (id.equals(REQ_3)) {
      diagram.hasView(REQ_3);
    }
  }
}

