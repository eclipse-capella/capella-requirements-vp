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

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.step.tools.InsertRemoveTool;
import org.polarsys.capella.test.diagram.common.ju.wrapper.utils.DiagramHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.IdentifiableElement;

public class InsertRemoveRequirementTool extends InsertRemoveTool {

	protected DiagramContext context;
	protected Collection<DDiagramElement> elements;
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
		 return DiagramHelper.getOwnedElements(getExecutionContext().getView(context.getDiagramId()));
	 }

	@Override
	protected void preRunTest() {
		super.preRunTest();
		elements = getDiagramOwnedElements();
	}
	
	@Override
	protected void postRunTest() {
		super.postRunTest();
	    Collection<DDiagramElement> newElements = getDiagramOwnedElements();
	    newElements.removeAll(elements);
	    
	    // collect id and associated diagram element for each new element
	    Map<String, DDiagramElement> IDsOfNewElements = new HashMap<String, DDiagramElement>();
	    for (DDiagramElement diagramElement : newElements) {
	    	EObject target = diagramElement.getTarget();
    		if (target instanceof ModelElement) {
    			ModelElement element = (ModelElement) target;
    			IDsOfNewElements.put(element.getId(), diagramElement);
    		} else if (target instanceof IdentifiableElement) {
    			IdentifiableElement element = (IdentifiableElement) target;
    			IDsOfNewElements.put(element.getId(), diagramElement);
    		}
	    }
	    
	    for (String IDToInsert : Arrays.asList(toInsert)) {
	    	if (IDsOfNewElements.containsKey(IDToInsert)) {
	    		DDiagramElement diagramElement = IDsOfNewElements.get(IDToInsert);
			    getExecutionContext().putView(IDToInsert,diagramElement);
			    getExecutionContext().putSemanticElement(IDToInsert, diagramElement.getTarget());
			} else {
				fail("The id of this element is not an id given in parameters.");
			}
	    }
	}
}
