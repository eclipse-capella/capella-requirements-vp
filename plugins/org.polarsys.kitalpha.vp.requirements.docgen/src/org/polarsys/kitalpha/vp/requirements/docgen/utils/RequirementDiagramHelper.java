/**
 *  Copyright (c) 2019 THALES GLOBAL SERVICES.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */

package org.polarsys.kitalpha.vp.requirements.docgen.utils;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.polarsys.kitalpha.doc.gen.business.core.preference.helper.DocgenDiagramPreferencesHelper;
import org.polarsys.kitalpha.doc.gen.business.core.scope.GenerationGlobalScope;
import org.polarsys.kitalpha.doc.gen.business.core.sirius.util.session.DiagramSessionHelper;
import org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

public class RequirementDiagramHelper implements IDiagramHelper {

  @Override
  public boolean select(EObject eObject) {
    if (eObject instanceof ReqIFElement) {
      return RequirementsServices.isLinkableWithoutScope(eObject) >= 0;
    }
    return false;
  }

  @Override
  public EObject getSemanticElement(DDiagramElement element) {
    return element.getTarget();
  }

  @Override
  public boolean isContainer(DDiagramElement element) {
    return false;
  }

  @Override
  public String getElementId(EObject eObject) {
    if (eObject instanceof ReqIFElement) {
      return ((ReqIFElement) eObject).getId();
    }
    return null;
  }

  @Override
  public String diagramDocumentationPostTraitement(EObject eObject, String documentation, String projectName,
      String outputFolder) {
    return "";
  }

  public static Set<DSemanticDiagram> getDiagramContainingObject(Requirement requirement) {
    Set<DSemanticDiagram> diagrams = new HashSet<DSemanticDiagram>();
    if (!DocgenDiagramPreferencesHelper.getExportDiagram()) {
      return diagrams;
    }

    for (DRepresentation representation : DiagramSessionHelper.getSessionDRepresentation()) {
      if (representation instanceof DSemanticDiagram) {
        DSemanticDiagram dSemanticDiagram = (DSemanticDiagram) representation;
        EObject semanticTarget = ((DSemanticDiagram) representation).getTarget();
        final boolean copyInScope = GenerationGlobalScope.getInstance().isCopyInScope(semanticTarget);
        if (copyInScope == false)
          continue;

        for (DDiagramElement diagramElement : dSemanticDiagram.getDiagramElements()) {
          EObject target = diagramElement.getTarget();
          if (diagramElement.isVisible() && EcoreUtil.equals(requirement, target)
              && EcoreUtil.equals(semanticTarget, target) == false) {
            // Current representation contains our model element.
            // Add it in resulting set, break current loop to search for next representation.
            diagrams.add((DSemanticDiagram) representation);
            break;
          }
        }
      }
    }
    return diagrams;
  }

}
