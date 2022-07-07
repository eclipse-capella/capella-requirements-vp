/*******************************************************************************
 * Copyright (c) 2020, 2022 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.polarsys.capella.common.tools.report.config.registry.ReportManagerRegistry;
import org.polarsys.capella.common.tools.report.util.IReportManagerDefaultComponents;
import org.polarsys.capella.core.commands.preferences.util.PreferencesHelper;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ReqIFTextParser {
  
  private ImageImporter imageImporter;
  private IContext context;
  private static final Logger LOGGER = ReportManagerRegistry.getInstance().subscribe(IReportManagerDefaultComponents.DEFAULT);
  private int dialogResult = Window.OK;

  public ReqIFTextParser(IContext context) {
    this.context = context;
    this.context.put(IRequirementsImporterBridgeConstants.IMAGES_TO_COPY,
        new HashMap<String, Map<String, List<Path>>>());
  }
  
  public ReqIFTextParser(IContext context, ImageImporter imageImporter) {
    this(context);
    this.imageImporter = imageImporter;
  }
  
  /**
   * Transform XHTML text into HTML text
   * 
   * @param content
   * @return
   */
  public String transformToHTML(String content, AttributeOwner owner) {
    return transformToHTML(content, owner, null);
  }

  /**
   * Transform XHTML text into HTML text
   * 
   * @param content: the XHTML content
   *        rootTag: the original root tag of the content
   * @return
   */
  public String transformToHTML(String content, AttributeOwner owner, String rootTag) {
    try {
      DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
      df.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
      df.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
      DocumentBuilder builder = df.newDocumentBuilder();
      Document document = builder.parse(new InputSource(new StringReader(content)));
      transformToHTML(document, document.getDocumentElement(), rootTag);
      removeOLEObjects(document, document.getDocumentElement());
      replaceImgObjects(document, document.getDocumentElement());
      convertAllImgElements(document, document.getDocumentElement(), owner);

      StringWriter writer = new StringWriter();
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
      transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
      Transformer transformer = transformerFactory.newTransformer();
      transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
      transformer.transform(new DOMSource(document), new StreamResult(writer));
      
      return writer.toString();
    } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
      LOGGER.log(Level.ERROR, "Error while parsing XHTML from ReqIF content", e);
    }
    // Return the raw content in case it cannot be parsed
    return content;
  }
  
  /**
   * Transform XHTML text into HTML text
   * 
   * @param document
   * @param element
   */
  protected void transformToHTML(Document document, Element element) {
    transformToHTML(document, element, null);
  }

  protected void transformToHTML(Document document, Element element, String rootTag) {
    if (element.getTagName().equals("reqif:XHTML")) {
      if (rootTag == null) {
        document.renameNode(element, null, "p");
      } else {
        document.renameNode(element, null, rootTag);        
      }
      while (element.getAttributes().getLength() > 0) {
        Node att = element.getAttributes().item(0);
        element.getAttributes().removeNamedItem(att.getNodeName());
      }
    } else {
      document.renameNode(element, null, element.getNodeName().replace("xhtml:", ""));
    }
    NodeList children = element.getChildNodes();
    for (int i = 0; i < children.getLength(); i++) {
      Node child = children.item(i);
      if (child instanceof Element) {
        transformToHTML(document, (Element) child);
      }

    }
  }
  
  /**
   * Remove OLE objects in ReqIF format
   * 
   * @param document
   * @param element
   */
  protected void removeOLEObjects(Document document, Element element) {
    NodeList children = element.getChildNodes();
    for (int i = 0; i < children.getLength(); i++) {
      Node child = children.item(i);
      if (child instanceof Element) {
        if (isOLEObj((Element) child)) {
          NodeList childrenOfOLEObj = child.getChildNodes();
          for (int j = 0; j < childrenOfOLEObj.getLength(); j++) {
            Node childOfOLEOjb = childrenOfOLEObj.item(j);
            element.insertBefore(childOfOLEOjb, child);
          }
          element.removeChild(child);
        } else {
          removeOLEObjects(document, (Element) child);
        }
      }
    }
  }

  /**
   * Replace img objects in ReqIF format by img elements
   * 
   * @param document
   * @param element
   */
  protected void replaceImgObjects(Document document, Element element) {
    NodeList children = element.getChildNodes();
    for (int i = 0; i < children.getLength(); i++) {
      Node child = children.item(i);
      if (child instanceof Element) {
        if (isImgObj((Element) child)) {
          Element imgElement = document.createElement("img");
          imgElement.setAttribute("src", ((Element) child).getAttribute("data"));
          element.insertBefore(imgElement, child);
          element.removeChild(child);
        } else {
          replaceImgObjects(document, (Element) child);
        }
      }
    }
  }

  /**
   * Convert all img elements in ReqIF format into Capella description format according to the chosen image importing
   * strategy
   * 
   * @param document
   * @param element
   */
  protected void convertAllImgElements(Document document, Element element, AttributeOwner owner) {
    NodeList children = element.getChildNodes();
    for (int i = 0; i < children.getLength(); i++) {
      Node child = children.item(i);
      if (child instanceof Element) {
        if (((Element) child).getTagName().equals("img")) {
          convertImgElement(owner, child);
        } else {
          convertAllImgElements(document, (Element) child, owner);
        }
      }
    }
  }

  /**
   * Convert the img element after choosing the importing strategy
   * @param owner
   * @param child
   */
  protected void convertImgElement(AttributeOwner owner, Node child) {
    Element imgElement = (Element) child;
    if (imageImporter == null) {
      imageImporter = new ImageImporter();
      Display.getDefault().syncExec(() -> {
        ImageImportingDialog dialog = new ImageImportingDialog(Display.getDefault().getActiveShell(),
            imageImporter, getCurrentProject());
        this.dialogResult = dialog.open();
      });
      if (this.dialogResult == Window.CANCEL) {
          throw new OperationCanceledException();
      }
    }
    if (imageImporter.getRelPath() != null) {
      convertImgElement(imgElement, owner);
    } else {
      LOGGER.log(Level.ERROR, "No valid path to import. Images won't be imported");
    }
  }

  /**
   * Convert the img element in ReqIF format into Capella description format. We suppose that the src of the 
   * imgElement before being converted is always the name of the exported image.
   * 
   * @param imgElement
   *          the img element to convert
   */
  protected void convertImgElement(Element imgElement, AttributeOwner owner) {
    String imgName = imgElement.getAttribute("src");
    imgElement.setAttribute("src", imageImporter.getRelPath() + imgName);
    storeFileToCopy(imgName, getReqIFFolder(),
        (new File(getCurrentProject().getLocation().removeLastSegments(1).toString(), imageImporter.getRelPath())).getPath(), owner);
  }

  /**
   * 
   * @param imagePath
   * @return base64 encoded string
   */
  public String encode(String imagePath) {
    String base64Image = "";
    File file = new File(imagePath);
    String ext = FilenameUtils.getExtension(imagePath);
    try (FileInputStream fis = new FileInputStream(file)) {
      byte[] imageData = new byte[(int) file.length()];
      int len = fis.read(imageData);
      while (len != -1) {
        len = fis.read(imageData);
      }
      base64Image = "data:image/" + ext + ";base64," + Base64.getEncoder().encodeToString(imageData);
    } catch (IOException e) {
      LOGGER.log(Level.ERROR, "Error while encoding image to Base64", e);
    }
    return base64Image;
  }

  /**
   * @return the folder containing the imported ReqIF file
   */
  private String getReqIFFolder() {
    URI reqIFPath = (URI) context.get(IRequirementsImporterBridgeConstants.CONTEXT_MODEL);
    return reqIFPath.trimSegments(1).toFileString();
  }

  /**
   * @return the current project to which we import ReqIF elements
   */
  public IProject getCurrentProject() {
    EObject targetElement = (EObject) context.get(IRequirementsImporterBridgeConstants.TARGET_ELEMENT);
    return PreferencesHelper.getProject(targetElement);
  }

  /**
   * Store images possibly to be copied in form of Map<Requirement ID, list of pairs <path of source file, path of
   * target file>>
   * 
   * @param fileName
   * @param srcFolder
   * @param targetFolder
   * @param owner
   */
  private void storeFileToCopy(String fileName, String srcFolder, String targetFolder, AttributeOwner owner) {
    Path srcPath = Paths.get((new File(srcFolder, fileName)).getPath());
    Path targetPath = Paths.get((new File(targetFolder, fileName)).getPath());
    List<Path> srcPath2targetPath = Arrays.asList(srcPath, targetPath);
    Map<String, List<List<Path>>> reqID2Images = (Map<String, List<List<Path>>>) context
        .get(IRequirementsImporterBridgeConstants.IMAGES_TO_COPY);
    List<List<Path>> images = reqID2Images.computeIfAbsent(owner.getReqIFIdentifier(), k -> new ArrayList<>());
    images.add(srcPath2targetPath);
  }

  private boolean isImgObj(Element element) {
    return element.getTagName().equals("object") && element.hasAttribute("type")
        && element.getAttribute("type").startsWith("image/");
  }

  private boolean isOLEObj(Element element) {
    return element.getTagName().equals("object") && element.hasAttribute("type")
        && element.getAttribute("type").equals("text/rtf") && element.hasAttribute("data")
        && element.getAttribute("data").endsWith(".ole");
  }
}
