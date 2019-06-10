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
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.Role;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.diffdata.impl.EComparisonImpl;
import org.eclipse.emf.diffmerge.impl.policies.ConfigurableMatchPolicy;
import org.eclipse.emf.diffmerge.impl.policies.ConfigurableMatchPolicy.FineGrainedMatchCriterion;
import org.eclipse.emf.diffmerge.impl.policies.ConfigurableMatchPolicy.MatchCriterionKind;
import org.eclipse.emf.diffmerge.ui.specification.IModelScopeDefinition;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.compare.CapellaMatchPolicy;
import org.polarsys.capella.core.compare.CapellaScopeFactory;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.test.framework.helpers.IResourceHelpers;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFImporterDiffPolicy;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFMergePolicy;
import org.polarsys.capella.vp.requirements.ju.transposer.TestRequirementsImportLauncher;

/**
 * 
 * This test case imports the Sample3 ReqIF model into emptymodel and compare the result to a reference model.
 * 
 */
public class ModelDiffTestCase3 extends BasicTestCase {

  private static final String operationalAnalysis = "19fef609-7a17-4a16-8c4d-563ae4cfd1c4";
  private static final String inputFileName = "model/inputs/Sample3.reqif";
  private static final String projectTestName = "sample3";
  private static final String projectWithImportedReqifTestName = "sample3WithImportedReqif";

  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestArtefact#getRequiredTestModels()
   */
  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(projectTestName, projectWithImportedReqifTestName);
  }

  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestCase#test()
   */
  @Override
  public void test() throws Exception {
    SessionContext session = new SessionContext(getSession(projectTestName));
    getSession(projectWithImportedReqifTestName);
    final EObject target = session.getSemanticElement(operationalAnalysis);

    if (target instanceof BlockArchitecture) {
      TransactionHelper.getExecutionManager(target).execute(new AbstractReadWriteCommand() {
        @Override
        public void run() {
          File file = IResourceHelpers.getFileOrFolderInTestPlugin(getClass(), inputFileName);
          URI model = URI.createFileURI(file.getPath());
          new TestRequirementsImportLauncher().launch(model, (BlockArchitecture) target, new NullProgressMonitor());
        }
      });
    }

    IModelScopeDefinition testFixtureScope = new CapellaScopeFactory().createScopeDefinition(
        getTestModel(projectWithImportedReqifTestName).getUriSemanticFile(), "testFixtureModel", true);
    IModelScopeDefinition modelToTestScope = new CapellaScopeFactory()
        .createScopeDefinition(getTestModel(projectTestName).getUriSemanticFile(), "toTestModel", true);

    EComparisonImpl comparison = new EComparisonImpl(
        testFixtureScope.createScope(getTestModel(projectWithImportedReqifTestName).getEditingDomain()),
        modelToTestScope.createScope(getTestModel(projectTestName).getEditingDomain()));

    // Since ReqIF elements have different IDs each time they are imported, we should use these match criteria
    CapellaMatchPolicy custoMatchPolicy = new CapellaMatchPolicy();
    Collection<MatchCriterionKind> criteria = Arrays.asList(MatchCriterionKind.INTRINSIC_ID, MatchCriterionKind.NAME,
        MatchCriterionKind.EXTRINSIC_ID, MatchCriterionKind.STRUCTURE);
    custoMatchPolicy.setAllUsedCriteria(criteria);

    Collection<FineGrainedMatchCriterion> fineGrainedCriteria = Arrays.asList(
        ConfigurableMatchPolicy.CRITERION_QNAMES_LABELS, ConfigurableMatchPolicy.CRITERION_STRUCTURE_ROOTS,
        ConfigurableMatchPolicy.CRITERION_STRUCTURE_CONTAINMENTS);
    custoMatchPolicy.setAllUsedFineGrainedCriteria(fineGrainedCriteria);

    comparison.compute(custoMatchPolicy, new ReqIFImporterDiffPolicy(), new ReqIFMergePolicy(),
        new NullProgressMonitor());

    List<IDifference> differencesFromReference = comparison.getDifferences(Role.REFERENCE);
    List<IDifference> differencesFromTarget = comparison.getDifferences(Role.TARGET);
    
    if (differencesFromReference.size() > 0 || differencesFromTarget.size() > 0) {
      fail("There should not be any differences between the test model with ReqIf imported and the reference model");
      // If you have changed the fixtureModel, you may have forgotten that types are hidden by default in diffmerge
      // view, so perhaps your fixtureModel is incomplete
    }
  }
}
