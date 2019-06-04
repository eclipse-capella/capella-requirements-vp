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
package org.polarsys.capella.vp.requirements.ju.tools;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.step.tools.InsertRemoveTool;
import org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement;

public class InsertRemoveRequirementTool extends InsertRemoveTool {

  protected DiagramContext context;
  protected Collection<DDiagramElement> elementsBeforeApplyingTool;
  protected DDiagramElement newElement;

  public InsertRemoveRequirementTool(DiagramContext context, String toolName) {
    super(context, toolName);
    this.context = context;
  }

  public InsertRemoveRequirementTool(DiagramContext context, String toolName, String containerId) {
    super(context, toolName, containerId);
    this.context = context;
  }

  private Collection<DDiagramElement> getDiagramOwnedElements() {
    return context.getDiagram().getOwnedDiagramElements();
  }

  @Override
  protected void preRunTest() {
    super.preRunTest();
    elementsBeforeApplyingTool = new ArrayList<>(getDiagramOwnedElements());
  }

  @Override
  protected void postRunTest() {
    super.postRunTest();
    Collection<DDiagramElement> newElements = getDiagramOwnedElements().stream() //
        .filter(e -> !elementsBeforeApplyingTool.contains(e)) //
        .collect(Collectors.toList());

    // collect id and associated diagram element for each new element
    Map<String, DDiagramElement> idToNewElement = new HashMap<>();
    for (DDiagramElement diagramElement : newElements) {
      EObject target = diagramElement.getTarget();
      if (target instanceof ModelElement) {
        ModelElement element = (ModelElement) target;
        idToNewElement.put(element.getId(), diagramElement);
      } else if (target instanceof IdentifiableElement) {
        IdentifiableElement element = (IdentifiableElement) target;
        idToNewElement.put(element.getId(), diagramElement);
      }
    }

    for (int i = 0; i < toInsert.length; i++) {
      String id = toInsert[i];
      if (idToNewElement.containsKey(id)) {
        DDiagramElement diagramElement = idToNewElement.get(id);
        getExecutionContext().putSemanticElement(id, diagramElement.getTarget());
      } else {
        fail("The id of this element is not an id given in parameters.");
      }
    }
  }
}
