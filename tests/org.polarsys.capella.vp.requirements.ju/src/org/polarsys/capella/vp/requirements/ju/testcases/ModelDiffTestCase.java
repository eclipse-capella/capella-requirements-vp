/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
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
 * This test case imports a sample ReqIF model into a test model and compare the result to a reference model
 */
public class ModelDiffTestCase extends BasicTestCase {

  private static final String systemAnalysis = "24658239-7734-4c39-9402-83325c52d04c";
  private static final String inputFileName = "model/inputs/Sample.reqif";
  private static final String projectTestName = "emptymodel";
  private static final String projectWithImportedReqifTestName = "emptymodelWithImportedReqif";

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
    final EObject target = session.getSemanticElement(systemAnalysis);

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
    }

  }
}
