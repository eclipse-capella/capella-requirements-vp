/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
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

import java.io.File;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.libraries.model.ICapellaModel;
import org.polarsys.capella.core.libraries.utils.ScopeModelWrapper;
import org.polarsys.capella.core.transition.common.context.TransitionContext;
import org.polarsys.capella.shared.id.handler.IScope;
import org.polarsys.capella.shared.id.handler.IdManager;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.helpers.IResourceHelpers;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.IRequirementsImporterBridgeConstants;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ImageImportStrategy;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ImageImporter;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFTextParser;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;

public class TextTransformTestCase extends BasicTestCase {

  private static final String REQIF_TEXT = "<reqif:XHTML xmlns:reqif=\"http://www.omg.org/spec/ReqIF/20110401/reqif.xsd\" xmlns:xhtml=\"http://www.w3.org/1999/xhtml\"><xhtml:div>Sysmodel shall provide an interface to set time (in 24h format).<xhtml:br /><xhtml:b>Operational Analysis</xhtml:b><xhtml:br />Several stakeholders <xhtml:b>have</xhtml:b> <xhtml:i>relationships</xhtml:i> <xhtml:span style=\"text-decoration:underline\">with</xhtml:span> <xhtml:span style=\"text-decoration:line-through\">the</xhtml:span> <xhtml:sub>IFE</xhtml:sub> <xhtml:sup>system</xhtml:sup>, they all have different goals. The focus is put here on the operational needs the IFE system will somehow contribute to. <xhtml:b>What is the precise scope or content of the IFE system is not elicited yet at this stage</xhtml:b>.<xhtml:br />Discover the entities and their goals in his the operational capabilities diagram: <xhtml:span style=\"text-decoration:underline\">[OCB] Operational Capabilities</xhtml:span>.<xhtml:br />Operational Architecture Diagrams provide a comprehensive view of the activities performed by the entities in order to reach their goals.<xhtml:br /><xhtml:div><xhtml:div><xhtml:div><xhtml:ul><xhtml:li><xhtml:span style=\"text-decoration:underline\">[OAB] High-Level Expected Activities</xhtml:span> </xhtml:li><xhtml:li>And its refined version <xhtml:span style=\"text-decoration:underline\">[OAB] All Operational Activities and Entities</xhtml:span></xhtml:li></xhtml:ul></xhtml:div></xhtml:div></xhtml:div>The different phases of a flight are described in <xhtml:span style=\"text-decoration:underline\">[M&#38;S] Aircraft Flying Phases</xhtml:span> and their sequence in <xhtml:span style=\"text-decoration:underline\">[OES] Flight Phases</xhtml:span>.<xhtml:br /><xhtml:br /><xhtml:object data=\"Test.ole\" type=\"text/rtf\"><xhtml:object data=\"Test.png\" type=\"image/png\">OLE Object</xhtml:object></xhtml:object></xhtml:div></reqif:XHTML>";
  private static final String PARSED_REQIF_TEXT = "<p><div>Sysmodel shall provide an interface to set time (in 24h format).<br/><b>Operational Analysis</b><br/>Several stakeholders <b>have</b> <i>relationships</i> <span style=\"text-decoration:underline\">with</span> <span style=\"text-decoration:line-through\">the</span> <sub>IFE</sub> <sup>system</sup>, they all have different goals. The focus is put here on the operational needs the IFE system will somehow contribute to. <b>What is the precise scope or content of the IFE system is not elicited yet at this stage</b>.<br/>Discover the entities and their goals in his the operational capabilities diagram: <span style=\"text-decoration:underline\">[OCB] Operational Capabilities</span>.<br/>Operational Architecture Diagrams provide a comprehensive view of the activities performed by the entities in order to reach their goals.<br/><div><div><div><ul><li><span style=\"text-decoration:underline\">[OAB] High-Level Expected Activities</span> </li><li>And its refined version <span style=\"text-decoration:underline\">[OAB] All Operational Activities and Entities</span></li></ul></div></div></div>The different phases of a flight are described in <span style=\"text-decoration:underline\">[M&amp;S] Aircraft Flying Phases</span> and their sequence in <span style=\"text-decoration:underline\">[OES] Flight Phases</span>.<br/><br/><img src=\"{0}\"/></div></p>";
  private static final String INPUT_REQIF_FILE = "model/inputs/model1.reqif";
  private static final String OUPUT_IMG_FILE_ABS_PATH = "model/Test.png";
  private static final String OUPUT_IMG_FILE_RELATIVE_PATH = "Test.png";
  private static final String PROJECT = "fragmentedModel";
  private static final String SA = "24658239-7734-4c39-9402-83325c52d04c";
  private static final String UNEXPECTED_IMPORTED_TEXT = "Imported text is not as expected";
  
  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestArtefact#getRequiredTestModels()
   */
  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(PROJECT);
  }
  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestCase#test()
   */
  @Override
  public void test() throws Exception {
    ICapellaModel model = getTestModel(PROJECT);
    IScope scope = new ScopeModelWrapper(model);
    EObject target = IdManager.getInstance().getEObject(SA, scope);
    
    IContext context = new TransitionContext();
    File file = IResourceHelpers.getFileOrFolderInTestPlugin(getClass(), INPUT_REQIF_FILE);
    URI modelURI = URI.createFileURI(file.getPath());
    context.put(IRequirementsImporterBridgeConstants.CONTEXT_MODEL, modelURI);
    context.put(IRequirementsImporterBridgeConstants.TARGET_ELEMENT, target);
    ImageImporter imageImporter = new ImageImporter();
    
    testAbsPathImportStrategy(context, imageImporter);
    testRelativePathImportStrategy(context, imageImporter);
    testEmbeddedImportStrategy(context, imageImporter);
  }
  
  protected void testAbsPathImportStrategy(IContext context, ImageImporter imageImporter) {
    imageImporter.setImgImportStrategy(ImageImportStrategy.ABS_PATH);
    imageImporter.setAbsPath(getFolderInTestModelRepository("").toString());
    ReqIFTextParser parser = new ReqIFTextParser(context, imageImporter);
    Requirement dummyReq = RequirementsFactory.eINSTANCE.createRequirement();
    dummyReq.setReqIFIdentifier("Dummy");
    String parsedContent = parser.transformToHTML(REQIF_TEXT, dummyReq);
    String expectedConent = MessageFormat.format(PARSED_REQIF_TEXT, IResourceHelpers.getFileOrFolderInTestPlugin(getClass(), OUPUT_IMG_FILE_ABS_PATH).toURI().toString());
    assertTrue(UNEXPECTED_IMPORTED_TEXT, parsedContent.equals(expectedConent));
  }
  
  protected void testRelativePathImportStrategy(IContext context, ImageImporter imageImporter) {
    imageImporter.setImgImportStrategy(ImageImportStrategy.REL_PATH);
    imageImporter.setRelPath("");
    ReqIFTextParser parser = new ReqIFTextParser(context, imageImporter);
    Requirement dummyReq = RequirementsFactory.eINSTANCE.createRequirement();
    dummyReq.setReqIFIdentifier("Dummy");
    String parsedContent = parser.transformToHTML(REQIF_TEXT, dummyReq);
    String expectedConent = MessageFormat.format(PARSED_REQIF_TEXT, OUPUT_IMG_FILE_RELATIVE_PATH);
    assertTrue(UNEXPECTED_IMPORTED_TEXT, parsedContent.equals(expectedConent));
  }

  protected void testEmbeddedImportStrategy(IContext context, ImageImporter imageImporter) {
    imageImporter.setImgImportStrategy(ImageImportStrategy.EMBEDDED);
    ReqIFTextParser parser = new ReqIFTextParser(context, imageImporter);
    String parsedContent = parser.transformToHTML(REQIF_TEXT, null);
    String expectedConent = MessageFormat.format(PARSED_REQIF_TEXT,
        "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHsAAABgCAIAAACytJpwAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAEnQAABJ0Ad5mH3gAAAKuSURBVHhe7ZBbbsMwDAR7kH72/jfrGVIBZheFFCPhw1vK2AF/EsnL1Xw8BBcZZyPjbGScjYyzkXE2r41/f37dYOwxDZBxNjLOxmHcfm9Fw/IyzkbG2cg4GxlnI+NsZJyNjLORcTYyzkbG2cg4GxlnI+NsZJyNjLORcTYyzkbG2cg4Gxlnc2fjaH42do/L3YyjbWAs4mJuYhwlS8ZCr2Fv4+j2dP5eOO5P4PTp2KVqdjWOVtPY8S9n/6/g5jR2XMeWxlEJYwcLLy+s4BOMHRSxmXGUwdjBCW9eW8GHGDtIs5NxNHm/j+vyCj7PhExsYxw1XGW895+CkGTOwR7G0cFbI/bVCnLyURsYR4FAh/CHK4hKpnU3ju2xAplvV5CWCWxtHKvD25OfryAwnNnXOPZmVucTVpAZi93AuP0OURKykoltahxLk3tLQlYQG0juaBwb80urclaQ7A1vbdx+JyiMWomFy3icWHg741hXsrEw6imB/L7G7XeO2rSVQL6Mpwjky3gW74pexst3lQeueFc4jG899pgL8K6Q8SzeFTKexbvitXEm3vYd8HaW8SzezjKexdu5l/GB9wH/jrewjKcItJXxFIG2Mp4i0Lad8UHgGf9CrKeMx4n1bG3c+xgm4ZIdjQ/C76ERrtfU+CD8JALoFqi3gfHAqy4lWayv8UHybVeQr7SN8fALCynp09r4oOSRJVQ16W58UPXUDIUdNjA+KHxwgNrtexg/qH35O0wbx9hBgp2MD6b3j7GDC7ho0WbGB5OIY+ysgin5GDurYD/jB5MRjB37mXIwdlzHrsYPJjvT2KVzpvvT2KVq9jZ+MJnKj+Vewx2Mg0mcdyzlYm5l/C+TzbOx20Rua7wtMs5GxtnIOBsZZyPjbGScjYyzkXE2Ms5GxtnIOBsZ5/J4/AChQpDw0zm4eAAAAABJRU5ErkJggg==");
    assertTrue(UNEXPECTED_IMPORTED_TEXT, parsedContent.equals(expectedConent));
  }
}
