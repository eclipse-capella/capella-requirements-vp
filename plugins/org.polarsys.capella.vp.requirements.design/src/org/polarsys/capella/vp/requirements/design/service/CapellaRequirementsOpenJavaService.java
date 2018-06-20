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
import java.util.Arrays;
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
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.capellacore.BusinessQueriesProvider;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.sirius.analysis.DiagramServices;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.capella.vp.requirements.ui.commands.ReqVPCustomDataHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
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
		// TODO Auto-generated method stub
	}

	/**
	 * Return all Requirements for a diagram or a diagram element
	 * 
	 * @param context
	 * @param elementView
	 * @return
	 */
	public List<EObject> getAllRequirementsForElement(EObject elementView) {
		List<EObject> result = new ArrayList<EObject>();

		// if the given element view is a diagram, return all requirements of the
		// diagram and all requirements of all Capella Elements of the diagram
		if (elementView instanceof DSemanticDiagram) {
			result.addAll(getRequirementsForElement(elementView, true, true));
			DSemanticDiagram diagram = (DSemanticDiagram) elementView;
			for (DDiagramElement diagramElement : diagram.getDiagramElements()) {
				if (diagramElement.getTarget() instanceof CapellaElement) {
					result.addAll(getRequirementsForElement(diagramElement, true, true));
				}
			}
		// if the given element view is a diagram element (of a Capella Element or Requirement), return all of its requirements
		} else if (elementView instanceof DDiagramElement) {
			result.addAll(getRequirementsForElement(elementView, true, true));
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
	public List<EObject> getRequirementsForElement(EObject elementView, boolean incoming, boolean outgoing) {
		List<EObject> result = new ArrayList<EObject>();

		// if the given element view is a diagram
		if (elementView instanceof DSemanticDiagram) {
			DSemanticDiagram diagram = (DSemanticDiagram) elementView;
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
		// if the given element view is a diagram element...
		} else if (elementView instanceof DDiagramElement) {
			DDiagramElement diagramElement = (DDiagramElement) elementView;
			EObject element = diagramElement.getTarget();
			// ... of a Capella Element
			if (element instanceof CapellaElement) {
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
			}
			// ... of a Requirement
			else if (element instanceof Requirement) {
				if (incoming) {
					IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
							RequirementsPackage.Literals.REQUIREMENT,
							RequirementsPackage.Literals.INTERNAL_RELATION__SOURCE);
					result.addAll(query.getCurrentElements(element, false));
				}
				if (outgoing) {
					IBusinessQuery query = BusinessQueriesProvider.getInstance().getContribution(
							RequirementsPackage.Literals.REQUIREMENT,
							RequirementsPackage.Literals.INTERNAL_RELATION__TARGET);
					result.addAll(query.getCurrentElements(element, false));
				}
			}
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
	public List<EObject> getExistingRequirementsInDiagram(EObject elementView, DDiagram diagram, boolean incoming, boolean outgoing) {
		List<EObject> requirements = getRequirementsForElement(elementView, incoming, outgoing);

		// Collect requirements of elementView if they are the target of a diagram element in the diagram
		return diagram.getDiagramElements().stream().map(diagramElement -> diagramElement.getTarget())
				.filter(target -> requirements.contains(target)).collect(Collectors.toList());
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
	public EObject hideRequirements(EObject diagram, Object[] selectedRequirementsArray, List<EObject> requirementsInDiagram) {

		if (diagram instanceof DDiagram) {
			DDiagram ddiagram = (DDiagram) diagram;
			List<Object> selectedRequirements = Arrays.asList(selectedRequirementsArray);
			
			// collect all requirements in requirementsInDiagram but not in selectedRequirements
			Set<EObject> requirementsToHide = requirementsInDiagram.stream().filter(req -> !selectedRequirements.contains(req)).collect(Collectors.toSet());
			
			// call removeContainerView for all diagram elements of the diagram where their target is contained in requirementsToHide
			ddiagram.getDiagramElements().stream().filter(container -> requirementsToHide.contains(container.getTarget())).forEach(DiagramServices.getDiagramServices()::removeContainerView);
		}
		
		return diagram;
	}
	
	/**
	 * Return if the given requirement is a requirement linked to the diagram
	 * @param requirement
	 * @param requirement
	 * @param diagram
	 * @return
	 */
	public boolean isLinkedToTheDiagram(EObject requirement, EObject diagram) {
		return getRequirementsForElement(diagram, true, true).contains(requirement);
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
    EAnnotation queriesAnnotation = ReqVPCustomDataHelper.getCustomData(session);
    String expression = queriesAnnotation.getDetails()
        .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL);
    String maxLength = queriesAnnotation.getDetails()
        .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_LABEL_LENGTH);
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

    EAnnotation queriesAnnotation = ReqVPCustomDataHelper.getCustomData(session);
    String expression = queriesAnnotation.getDetails()
        .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT);
    String maxLength = queriesAnnotation.getDetails()
        .get(ReqVPCustomDataHelper.CUSTOM_DATA_KEY_FOR_REQ_VP_QUERIES_CONTENT_LENGTH);
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
            for (Object item : (List) value) {
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
}