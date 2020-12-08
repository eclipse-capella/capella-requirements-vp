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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.polarsys.kitalpha.doc.gen.business.core.preference.helper.DocgenDiagramPreferencesHelper;
import org.polarsys.kitalpha.doc.gen.business.core.scope.GenerationGlobalScope;
import org.polarsys.kitalpha.doc.gen.business.core.scope.ScopeReferencesStrategy;
import org.polarsys.kitalpha.doc.gen.business.core.sirius.util.session.DiagramSessionHelper;
import org.polarsys.kitalpha.doc.gen.business.core.util.DocGenHtmlUtil;
import org.polarsys.kitalpha.doc.gen.business.core.util.EscapeChars;
import org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService;
import org.polarsys.kitalpha.doc.gen.business.core.util.LabelProviderHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.Folder;
import org.polarsys.kitalpha.vp.requirements.Requirements.Module;
import org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * This class is a fork of the class org.polarsys.capella.docgen.util.CapellaServices
 * 
 * @author Boubekeur Zendagui
 */

public class RequirementsServices {

  public final static String H1_OPEN = "<h1>";
  public final static String H1_CLOSE = "</h1>";
  public final static String H2_OPEN = "<h2>";
  public final static String H2_CLOSE = "</h2>";

  public final static String TABLE_OPEN = "<table>";
  public final static String TABLE_CLOSE = "</table>";
  public final static String TABLE_ROW_OPEN = "<tr>";
  public final static String TABLE_ROW_CLOSE = "</tr>";
  public final static String TABLE_TH_OPEN = "<th>";
  public final static String TABLE_TH_CLOSE = "</th>";
  public final static String TABLE_TD_OPEN = "<td>";
  public final static String TABLE_TD_CLOSE = "</td>";

  public final static String LIST_OPEN = "<ul>";
  public final static String LIST_CLOSE = "</ul>";
  public final static String LIST_ITEM_OPEN = "<li>";
  public final static String LIST_ITEM_CLOSE = "</li>";

  protected final static String HYPERLINK_OPEN = "<a href=\"";
  protected final static String HYPERLINK_SEPARATOR = "/";
  protected final static String HYPERLINK_COMPLETE = "\">";
  protected final static String HYPERLINK_CLOSE = "</a>";
  private static final String PATH_OPEN = "../";
  private static final String PATH_COMPLETE = ".html";
  public static final String LINE_BREAK = "<br/>";

  public static Set<DSemanticDiagram> getDiagramContainingObject(ReqIFElement element) {
    Set<DSemanticDiagram> diagrams = new HashSet<DSemanticDiagram>();
    if (!DocgenDiagramPreferencesHelper.getExportDiagram()) {
      return diagrams;
    }

    if (GenerationGlobalScope.getInstance().getReferencesStrategy().equals(ScopeReferencesStrategy.DONT_EXPORT)) {
      element = (ReqIFElement) GenerationGlobalScope.getInstance().getOriginalModelElement(element);
    }

    for (DRepresentation representation : DiagramSessionHelper.getSessionDRepresentation()) {
      if (representation instanceof DSemanticDiagram) {
        DSemanticDiagram dSemanticDiagram = (DSemanticDiagram) representation;
        EObject semanticTarget = ((DSemanticDiagram) representation).getTarget();
        final boolean copyInScope = GenerationGlobalScope.getInstance().isCopyInScope(semanticTarget);
        if (copyInScope == false) {
          continue;
        }

        for (DDiagramElement diagramElement : dSemanticDiagram.getDiagramElements()) {
          EObject target = diagramElement.getTarget();
          if (diagramElement.isVisible() && EcoreUtil.equals(element, target)
              && EcoreUtil.equals(semanticTarget, target) == false) {
            // Current representation contains our model element.
            // Add it in resulting set, break current loop to search for next representation.
            diagrams.add((DSemanticDiagram) representation);
          }
        }
      }
    }
    return diagrams;
  }

  public static boolean hasChildren(ReqIFElement element) {
    if (element instanceof Module) {
      return !((Module) element).getOwnedRequirements().isEmpty();
    }
    if (element instanceof Folder) {
      return !((Folder) element).getOwnedRequirements().isEmpty();
    }
    return false;
  }

  /**
   * 
   * @param element
   * @return
   */
  public static String getElementPath(EObject element, IFileNameService fileNameService) {
    StringBuffer buffer = new StringBuffer();
    Iterator<EObject> iterator = getFullElementPath(element).iterator();
    while (iterator.hasNext()) {
      EObject model = iterator.next();
      IFileNameService usedFileNameService = null;
      if (!(model instanceof ReqIFElement)) {
        usedFileNameService = fileNameService;
      }
      buffer.append(getHyperlinkFromElement(model, usedFileNameService));
      if (iterator.hasNext()) {
        buffer.append(" > ");
      }
    }
    return buffer.toString();
  }

  private static List<EObject> getFullElementPath(EObject element) {
    List<EObject> eObjects = new ArrayList<EObject>();
    EObject parent = element.eContainer();
    if (parent instanceof EObject) {
      eObjects.addAll(getFullElementPath(parent));
    }
    eObjects.add(element);
    return eObjects;
  }

  /**
   * <b>Create a html hyper link from an element</b>
   * <p>
   * Create and format a html hyper link (a href) from a Capella Element
   * 
   * @param element
   * @return
   */
  public static String getHyperlinkFromElement(EObject element) {
    return getHyperlinkFromElement(element, LabelProviderHelper.getText(element), RequirementFileNameService.SERVICE);
  }

  public static String getHyperlinkFromElement(EObject element, IFileNameService service) {
    return getHyperlinkFromElement(element, LabelProviderHelper.getText(element), service);
  }

  private static String getHyperlinkFromElement(EObject element, String label, IFileNameService service) {
    if (element instanceof DSemanticDiagram) {
      return getHyperlinkFromDiagram((DSemanticDiagram) element, service);
    }
    int linked = isLinkable(element, service);
    // Get the representation name
    String text = label;
    // Format representation name with html rules
    text = EscapeChars.forHTML(text);
    // Initialize Buffer
    StringBuffer buffer = new StringBuffer();
    if (linked != -1) {
      // Add the opening href tag to the buffer
      buffer.append(HYPERLINK_OPEN);
      // Add the preoject root ressource to the buffer
      if (linked == 1) {
        buffer.append(getPathFromElement(element.eContainer(), service));
        buffer.append("#");
        buffer.append(getAnchorId(element));
      } else
        buffer.append(getPathFromElement(element, service));
      // Add the href tag completion to the buffer
      buffer.append(HYPERLINK_COMPLETE);
    }
    // Add the name to present to the buffer
    buffer.append(text);
    if (linked != -1) {
      // Add the close href tag to the buffer
      buffer.append(HYPERLINK_CLOSE);
    }
    // return the buffer
    return buffer.toString();
  }

  private static String getHyperlinkFromDiagram(DSemanticDiagram diagram, IFileNameService service) {
    // Get the representation name
    String text = LabelProviderHelper.getText(diagram);
    // Format representation name with html rules
    text = EscapeChars.forHTML(text);
    // Initialize Buffer
    StringBuffer buffer = new StringBuffer();
    // Add the opening href tag to the buffer
    buffer.append(HYPERLINK_OPEN);
    // Add the project root resource to the buffer
    buffer.append(getPathFromElement(diagram.getTarget(), service));
    // Add diagram fragment id as link anchor
    buffer.append("#");
    buffer.append(diagram.getUid());
    // Add the href tag completion to the buffer
    buffer.append(HYPERLINK_COMPLETE);
    // Add the name to present to the buffer
    buffer.append(text);
    // Add the close href tag to the buffer
    buffer.append(HYPERLINK_CLOSE);
    // return the buffer
    return buffer.toString();
  }

  public static String getAnchorId(EObject element) {
    String id = "id" + EcoreUtil.getURI(element).fragment();
    return id;
  }

  /**
   * 
   * @param element
   * @return 0 if element has page, 1 if parent element has page, otherwise -1
   */
  public static int isLinkable(EObject element, IFileNameService service) {
    if ((!GenerationGlobalScope.getInstance().inScope(element, true))) {
      return -1;
    }

    if (element instanceof ReqIFElement) {
      return isLinkableWithoutScope(element);
    } else {
      String fileName = service.getFileName(element);
      if (fileName != null && !fileName.isEmpty()) {
        return 0;
      }
      return -1;
    }
  }

  /**
   * 
   * @param element
   * @return 0 if element has page, 1 if parent element has page, otherwise -1
   */
  public static int isLinkableWithoutScope(EObject element) {
    if (element instanceof Requirement || element instanceof Module) {
      return 0;
    }
    return -1;
  }

  public static String getPathFromElement(EObject element, IFileNameService fileNameService) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(PATH_OPEN);
    // Add the project root resource to the buffer
    buffer.append(DocGenHtmlUtil.getModelName(element));
    // Add the Separator to the buffer
    buffer.append(HYPERLINK_SEPARATOR);
    // Add the file name to the buffer
    buffer.append(fileNameService != null ? fileNameService.getFileName(element)
        : RequirementFileNameService.SERVICE.getFileName(element));
    // Add the href tag completion to the buffer
    buffer.append(PATH_COMPLETE);
    return buffer.toString();
  }
  
  public static String getImageLinkFromElement(EObject element, String projectName, String outputFolder) {
	String imageFileName = LabelProviderHelper.getImageFileName(element, projectName, outputFolder);
	StringBuffer buffer = new StringBuffer();
	return appendRelativePath(element, imageFileName, buffer, "../icon/");
  }

  private static String appendRelativePath(EObject element, String imageFileName, StringBuffer buffer, String relativePath) {
	buffer.append("<img src=\"");
	buffer.append(relativePath);
	buffer.append(imageFileName);
	buffer.append("\" alt=\"");
	buffer.append(element.eClass().getName());
	buffer.append("\" />");
	return buffer.toString();
  }
}
