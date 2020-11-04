/*******************************************************************************
 * Copyright (c) 2017, 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ju.testcases;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.test.framework.helpers.IResourceHelpers;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.categories.RelationIdentifierCategory;
import org.polarsys.capella.vp.requirements.ju.transposer.TestInitializeTransformation;
import org.polarsys.capella.vp.requirements.ju.transposer.TestRequirementsImportLauncher;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * 
 * This test case imports the Sample2.reqif model into MultipleImports which contains already Sample1.reqif and check
 * that there are no difference.
 * 
 * The differences between Sample1.reqif and Sample2.reqif are:
 * 
 * 1. The Spec Hierarchies have different IDs. We should indeed only care about Spec Object's ID
 * 
 * 2. The Relations have different IDs (due to DOORS's limitation). We should filter out these differences
 * 
 */
public class ModelDiffTestCase2 extends BasicTestCase {

  private static final String systemAnalysis = "24658239-7734-4c39-9402-83325c52d04c";
  private static final String inputFileName = "model/inputs/Sample1.reqif";
  private static final String projectTestName = "MultipleImports";

  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestArtefact#getRequiredTestModels()
   */
  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(projectTestName);
  }

  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestCase#test()
   */
  @Override
  public void test() throws Exception {
    SessionContext session = new SessionContext(getSession(projectTestName));
    final BlockArchitecture target = session.getSemanticElement(systemAnalysis);

    final TestRequirementsImportLauncher testRequirementsImportLauncher = new TestRequirementsImportLauncher();

    TransactionHelper.getExecutionManager(target).execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        File file = IResourceHelpers.getFileOrFolderInTestPlugin(getClass(), inputFileName);
        URI model = URI.createFileURI(file.getPath());
        testRequirementsImportLauncher.launch(model, (BlockArchitecture) target, new NullProgressMonitor());
      }
    });

    IContext context = testRequirementsImportLauncher.getContext();
    @SuppressWarnings("unchecked")
    List<IDifference> differences = (List<IDifference>) context.get(TestInitializeTransformation.DIFFERENCES_FROM_REFERENCE_SCOPE);

    // Take into account the Relation Identifier filter category
    RelationIdentifierCategory relationIdentifierCategoryFilter = new RelationIdentifierCategory();
    List<IDifference> filteredDifferences = differences.stream() //
        .filter(d -> !relationIdentifierCategoryFilter.covers(d, null)) //
        .collect(Collectors.toList());

    assertTrue("There should not be any differences when Sample1.reqif is imported to Capella model",
        filteredDifferences.isEmpty());

    // If you have changed the fixtureModel, you may have forgotten that types are hidden by default in diffmerge view,
    // so perhaps your fixtureModel is incomplete

  }
}
