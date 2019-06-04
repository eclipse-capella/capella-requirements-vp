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
package org.polarsys.capella.vp.requirements.design.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.EdgeTarget;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.data.cs.Component;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.model.helpers.ComponentExt;
import org.polarsys.capella.core.sirius.analysis.CapellaServices;
import org.polarsys.capella.core.sirius.analysis.DiagramServices;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsFactory;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.capella.vp.requirements.ui.commands.ReqVPCustomDataHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
 
/**
 * <!-- begin-user-doc --> This class is an implementation of the Sirius
 * JavaExtension
 * '<em><b>[org.polarsys.capella.vp.requirements.design.service.CapellaRequirementsOpenJavaService]</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */

public class CapellaRequirementsOpenJavaService {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CapellaRequirementsOpenJavaService() {
		// Do nothing
	}
	
	/**
	 * Return all the requirements in the block architecture for the given context.
	 * @param context
	 * @return
	 */
  public Collection<EObject> getAllAvailableRequirements(EObject context) {
    EObject element = context;
    if (element instanceof DSemanticDecorator) {
      element = ((DSemanticDecorator) element).getTarget();
    }
    // Incoming
    List<EObject> result = new ArrayList<>();
    IBusinessQuery incomingQuery = BusinessQueriesProvider.getInstance().getContribution(
        CapellacorePackage.Literals.CAPELLA_ELEMENT,
        CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE);
    result.addAll(incomingQuery.getAvailableElements(element));

    // Outgoing
    IBusinessQuery outgoingQuery = BusinessQueriesProvider.getInstance().getContribution(
        CapellacorePackage.Literals.CAPELLA_ELEMENT,
        CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET);
    result.addAll(outgoingQuery.getAvailableElements(element));
    return result;
  }
  
  /**
   * Return the visible requirements on the given diagram.
   * @param elementView
   * @param diagram
   * @param incoming
   * @param outgoing
   * @return
   */
  public Collection<EObject> getVisibleRequirementsOnDiagram(EObject context) {
    DDiagram diagram = getDiagram(context);
    if (diagram != null) {
      return diagram.getDiagramElements().stream() //
          .map(DDiagramElement::getTarget) //
          .filter(Requirement.class::isInstance) //
          .collect(Collectors.toSet());

    }
    return Collections.emptySet();
  }
  
  private DDiagram getDiagram(EObject context) {
    DDiagram result = null;
    if (context instanceof DDiagram) {
      result = (DDiagram) context;
    } else if (context instanceof DDiagramElement) {
      result = ((DDiagramElement) context).getParentDiagram();
    }
    return result;
  }

	/**
	 * Return all Requirements for a diagram or a diagram element
	 * 
	 * @param context
	 * @param elementView
	 * @return
	 */
	public Collection<EObject> getAllRequirementsForElement(EObject elementView) {
		List<EObject> result = new ArrayList<>();

		// if the given element view is a diagram, return all requirements of the
		// diagram and all requirements of all Capella Elements of the diagram
		if (elementView instanceof DSemanticDiagram) {
		  DSemanticDiagram diagram = (DSemanticDiagram) elementView;
			result.addAll(getRequirementsForDiagram(diagram, true, true));
			for (DDiagramElement diagramElement : diagram.getDiagramElements()) {
				if (diagramElement.getTarget() instanceof CapellaElement) {
					result.addAll(getRequirementsForDiagramElement(diagramElement, true, true));
				}
			}
		// if the given element view is a diagram element (of a Capella Element or Requirement), return all of its requirements
		} else if (elementView instanceof DDiagramElement) {
			result.addAll(getRequirementsForDiagramElement((DDiagramElement) elementView, true, true));
		}
		return result;
	}

	/**
	 * Found all incoming and/or outgoing Requirements from/to an element using business queries
	 * 
	 * @param context
	 * @param elementView
	 * @param incoming
	 *            true if you want all incoming requirements
	 * @param outgoing
	 *            true if you want all outgoing requirements
	 * @return
	 */
  public Collection<EObject> getRequirementsForElement(EObject elementView, boolean incoming, boolean outgoing) {
    if (elementView instanceof DSemanticDiagram) {
      return getRequirementsForDiagram((DSemanticDiagram)elementView, incoming, outgoing);
    }

    if (elementView instanceof DDiagramElement) {
      return getRequirementsForDiagramElement((DDiagramElement) elementView, incoming, outgoing);
    }
    return Collections.emptyList();
  }

  private List<EObject> getRequirementsForDiagramElement(DDiagramElement diagramElement, boolean incoming, boolean outgoing) {
    EObject element = diagramElement.getTarget();
    if (element instanceof CapellaElement) {
      return getRequirementsForCapellaElement((CapellaElement) element, incoming, outgoing);
    }
    if (element instanceof Requirement) {
    	return getRequirementsForRequirement((Requirement) element, incoming, outgoing);
    }
    return Collections.emptyList();
  }

  private List<EObject> getRequirementsForRequirement(Requirement requirement, boolean incoming, boolean outgoing) {
    List<EObject> result = new ArrayList<>();
    if (incoming) {
    	IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
    			RequirementsPackage.Literals.REQUIREMENT,
    			RequirementsPackage.Literals.INTERNAL_RELATION__SOURCE);
    	result.addAll(query.getCurrentElements(requirement, false));
    }
    if (outgoing) {
    	IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
    			RequirementsPackage.Literals.REQUIREMENT,
    			RequirementsPackage.Literals.INTERNAL_RELATION__TARGET);
    	result.addAll(query.getCurrentElements(requirement, false));
    }
    return result;
  }

  private List<EObject> getRequirementsForCapellaElement(CapellaElement element, boolean incoming, boolean outgoing) {
    List<EObject> result = new ArrayList<>();
    if (incoming) {
    	IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
    			CapellacorePackage.Literals.CAPELLA_ELEMENT,
    	        CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE);
    	result.addAll(query.getCurrentElements(element, false));
    }
    if (outgoing) {
    	IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
    			CapellacorePackage.Literals.CAPELLA_ELEMENT,
    	        CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET);
    	result.addAll(query.getCurrentElements(element, false));
    }
    return result;
  }

  private List<EObject> getRequirementsForDiagram(DSemanticDiagram diagram, boolean incoming, boolean outgoing) {
    List<EObject> result = new ArrayList<>();
    if (incoming) {
    	IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
    			ViewpointPackage.Literals.DREPRESENTATION,
    	        CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE);
    	result.addAll(query.getCurrentElements(diagram, false));
    }
    if (outgoing) {
    	IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
    			ViewpointPackage.Literals.DREPRESENTATION,
    	        CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET);
    	result.addAll(query.getCurrentElements(diagram, false));
    }
    return result;
  }
	

	/**
	 * Found all incoming and/or outgoing Requirements from/to an element in a diagram
	 * 
	 * @param context
	 * @param elementView
	 * @param diagram
	 * @param incoming
	 *            true if you want all incoming requirements
	 * @param outgoing
	 *            true if you want all outgoing requirements
	 * @return
	 */
	public Collection<EObject> getExistingRequirementsInDiagram(EObject elementView, DDiagram diagram, boolean incoming, boolean outgoing) {
		Collection<EObject> requirements = getRequirementsForElement(elementView, incoming, outgoing);

		// Collect requirements of elementView if they are the target of a diagram element in the diagram
		return diagram.getDiagramElements().stream() //
		    .map(DDiagramElement::getTarget) //
				.filter(requirements::contains) //
				.collect(Collectors.toList());
	}

	/**
	 * Hide Requirements (Requirements in requirementsInDiagram but not in selectedRequirements)
	 * 
	 * @param context
	 * @param diagram
	 * @param selectedRequirements
	 * @param requirementsInDiagram
	 * @return
	 */
	public EObject hideRequirements(EObject diagram, Collection<EObject> selectedRequirements, Collection<EObject> requirementsInDiagram) {

    if (diagram instanceof DDiagram) {
      DDiagram ddiagram = (DDiagram) diagram;

      // collect all requirements in requirementsInDiagram but not in selectedRequirements
      Set<EObject> requirementsToHide = requirementsInDiagram.stream()
          .filter(req -> !selectedRequirements.contains(req)) //
          .collect(Collectors.toSet());

      // call removeContainerView for all diagram elements of the diagram where their target is contained in
      // requirementsToHide
      DiagramServices diagramService = DiagramServices.getDiagramServices();
      ddiagram.getDiagramElements().stream() //
          .filter(container -> requirementsToHide.contains(container.getTarget())) //
          .forEach(diagramService::removeContainerView);
    }
		
		return diagram;
	}
	
	/**
	 * Return the name of the relation type, empty string if not found
	 * 
	 * @param relation
	 * @return
	 */
	public String getRelationTypeLabel(AbstractRelation relation) {
		RelationType type = relation.getRelationType();
		if (type != null) {
			String name = type.getReqIFLongName();
			if (name != null) {
				return name;
			}
		}
		return ICommonConstants.EMPTY_STRING;
	}

	/**
   * Return the title of a Requirement
   * based on the predefined AQL expression
   * @param requirement
   * @return
   */
  public String getRequirementTitle(Requirement requirement) {
    Session session = SessionManager.INSTANCE.getSession(requirement);
    
    String expression = ReqVPCustomDataHelper.getDefaultLabelExpression();
    String maxLength = ReqVPCustomDataHelper.getDefaultLabelLength();
    
    EAnnotation queriesAnnotation = ReqVPCustomDataHelper.getCustomData(session);
    
    if (queriesAnnotation != null) {
      expression = queriesAnnotation.getDetails()
          .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL);
      maxLength = queriesAnnotation.getDetails()
          .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL_LENGTH);
    }
   
    return evaluateExpression(session, requirement, expression, maxLength);
  }

  /**
   * Return the content of a Requirement
   * based on the predefined AQL expression
   * @param requirement
   * @return
   */
  public String getRequirementContent(Requirement requirement) {
    Session session = SessionManager.INSTANCE.getSession(requirement);

    String expression = ReqVPCustomDataHelper.getDefaultContentExpression();
    String maxLength = ReqVPCustomDataHelper.getDefaultContentLength(); 
    
    EAnnotation queriesAnnotation = ReqVPCustomDataHelper.getCustomData(session);
    if (queriesAnnotation != null) {
      expression = queriesAnnotation.getDetails()
          .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT);
      maxLength = queriesAnnotation.getDetails()
          .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT_LENGTH);
    }
    
    return evaluateExpression(session, requirement, expression, maxLength);
  }

  /**
   * Compute the string from an AQL expression for a requirement.
   * @param session
   * @param requirement
   * @param expression
   * @param maxLength
   * @return
   */
  protected String evaluateExpression(Session session, Requirement requirement, String expression, String maxLength) {
    try {
      if (session != null && expression != null) {
        IInterpreter interpreter = session.getInterpreter();
        if (interpreter != null) {
          Object value = interpreter.evaluate(requirement, expression);
          StringBuilder resultBuilder = new StringBuilder();
          if (value instanceof List<?>) {
            for (Object item : (List<?>) value) {
              resultBuilder.append(item);
            }
          } else {
            resultBuilder.append(value);
          }
          return reduceString(resultBuilder.toString(), maxLength);
        }
      }
    } catch (EvaluationException ex) {
      return "<Undefined>";
    }
    return "<Undefined>";
  }
  
  /**
   * If the string is longer than a predefined maximum length, it will be reduced and followed by "..."
   * @param value
   * @param maxLengthText
   * @return
   */
  protected String reduceString(String value, String maxLengthText) {
    if (maxLengthText.length() == 0) {
      return value;
    }
    int maxLen = Integer.parseInt(maxLengthText);
    if (maxLen == 0) {
      return value;
    }
    if (value.length() > maxLen) {
      return value.substring(0, maxLen).concat("...");
    }
    return value;
  }
  
  /**
   * Find the source of the outgoing relation with a requirement.
   * With this relation, the target is a requirement, the source is capella element or diagram.
   * @param relation
   * @return
   */
  public Collection<EObject> findOutgoingRelationSource(CapellaOutgoingRelation relation) {
    return findRelationEnds(relation.getSource());
  }
  
  /**
   * Find the source of the incoming relation with a requirement.
   * With this relation, the source is a requirement, the target is capella element or diagram.
   * @param relation
   * @return
   */
  public Collection<EObject> findIncomingRelationTarget(CapellaIncomingRelation relation) {
   return findRelationEnds(relation.getTarget());
  }
  
  private List<EObject> findRelationEnds(CapellaElement element) {
    List<EObject> result = new ArrayList<>();
    // TODO If in the method getCurrentElements(EObject element, boolean onlyGenerated), 
    // if the RepresentedInstance of InstanceRole is handled,
    // we need to add the representing instance roles in the result
    if (element instanceof Component) {
      result.addAll(ComponentExt.getRepresentingParts((Component) element));
    } 
    result.add(element);
    return result;
  }
  
  public void createRequirementLink(EObject source, EObject target, EdgeTarget sourceView, EdgeTarget targetView){
    if(source instanceof Requirement){
      if(target instanceof CapellaElement){
        CapellaIncomingRelation relation = createCapellaIncomingRelation((Requirement)source, (CapellaElement)target);
        createEdge(ReqDesignNameConstants.REQ_VP_INCOMING_RELATION, sourceView, targetView, relation);
      }else if(target instanceof Requirement){
        InternalRelation relation = createInternalRelation((Requirement)source, (Requirement)target);
        createEdge(ReqDesignNameConstants.REQ_VP_INTERNAL_RELATION, sourceView, targetView, relation);
      }
    }else if(source instanceof CapellaElement && target instanceof Requirement){
      CapellaOutgoingRelation relation = createCapellaOutgoingRelation((Requirement)target, (CapellaElement)source);
      createEdge(ReqDesignNameConstants.REQ_VP_OUTGOING_RELATION, sourceView, targetView, relation);
    }
  }
  
  private DEdge createEdge(String mappingName, EdgeTarget sourceView, EdgeTarget targetView, AbstractRelation relation) {
    DDiagram diagram = CapellaServices.getService().getDiagramContainer(sourceView);
    EdgeMapping mapping = getEdgeMapping(diagram, mappingName);
    return DiagramServices.getDiagramServices().createEdge(mapping, sourceView, targetView, relation);
  }
  
  // https://bugs.polarsys.org/show_bug.cgi?id=2113
  // Use DiagramServices.getDiagramServices().getEdgeMapping(diagram, mappingName) when the above bug is fixed and delete this method
  private EdgeMapping getEdgeMapping(final DDiagram diagram, String mappingName) {
    for(Layer layer : diagram.getActivatedLayers()){
      for (final EdgeMapping mapping : layer.getAllEdgeMappings()) {
        if (mapping.getName().equals(mappingName)) {
          return mapping;
        }
      }
    }
    return null;
  }
  
  private CapellaOutgoingRelation createCapellaOutgoingRelation(Requirement requirement,
      CapellaElement capellaElement) {
    CapellaOutgoingRelation link = CapellaRequirementsFactory.eINSTANCE.createCapellaOutgoingRelation();
    if(capellaElement instanceof Part && ((Part)capellaElement).getAbstractType() instanceof CapellaElement){
      CapellaElement type = (CapellaElement)((Part)capellaElement).getAbstractType();
      link.setSource(type);      
      type.getOwnedExtensions().add(link);
    }else{
      link.setSource(capellaElement);      
      capellaElement.getOwnedExtensions().add(link);
    }
    link.setTarget(requirement);
    link.setRelationType(getDefaultType(link));
    capellaElement.getOwnedExtensions().add(link);
    return link;
  }
  
  private CapellaIncomingRelation createCapellaIncomingRelation(Requirement requirement,
      CapellaElement capellaElement) {
    CapellaIncomingRelation link = CapellaRequirementsFactory.eINSTANCE.createCapellaIncomingRelation();
    link.setSource(requirement);
    if(capellaElement instanceof Part && ((Part)capellaElement).getAbstractType() instanceof CapellaElement){
      link.setTarget((CapellaElement)((Part)capellaElement).getAbstractType());      
    }else{
      link.setTarget(capellaElement);      
    }
    link.setRelationType(getDefaultType(link));
    requirement.getOwnedRelations().add(link);
    return link;
  }

  private InternalRelation createInternalRelation(Requirement sourceRequirement,
      Requirement targetRequirment) {
    InternalRelation internalLink = RequirementsFactory.eINSTANCE.createInternalRelation();
    internalLink.setSource(sourceRequirement);
    internalLink.setTarget(targetRequirment);
    internalLink.setRelationType(getDefaultType(internalLink));
    sourceRequirement.getOwnedRelations().add(internalLink);
    return internalLink;
  }
  
  private RelationType getDefaultType(AbstractRelation relation) {
    IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
        RequirementsPackage.eINSTANCE.getAbstractRelation(),
        RequirementsPackage.eINSTANCE.getAbstractRelation_RelationType());
    List<EObject> availableElements = query.getAvailableElements(relation);
    if (availableElements.size() == 1)
      return (RelationType) availableElements.get(0);
    return null;
  }
  /**
   * Check whether the selected requirement is linked to the current diagram.
   * @param requirement
   * @param diagram
   * @return
   */
  public boolean isLinkedToDiagram(Requirement requirement, DSemanticDiagram diagram) {
    if (requirement != null && diagram != null) {
      List<EObject> requirements = getRequirementsForDiagram(diagram, true, true);
      for (EObject currentRequirement : requirements) {
        if (requirement.equals(currentRequirement)) {
          return true;
        }
      }
    }
    return false;
  }
}