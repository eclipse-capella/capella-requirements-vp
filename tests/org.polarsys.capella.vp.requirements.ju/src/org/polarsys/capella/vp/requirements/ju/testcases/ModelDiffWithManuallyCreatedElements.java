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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.api.diff.IElementPresence;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.test.framework.helpers.IResourceHelpers;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.ju.transposer.TestInitializeTransformation;
import org.polarsys.capella.vp.requirements.ju.transposer.TestRequirementsImportLauncher;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;

/**
 * This test is related to the Bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=568336
 * 
 * Here is the context of the test: We have a target model A and a reqif file that we want to import.
 * 
 * When a reqif file is imported, the xml requif elements are transformed into ReqIf model elements. Next a temporary
 * copy of model A is is created. All of the existing Reqif model elements are deleted from this temporary model and
 * replaced with the newly created ones (at the previous step). Let us call this temporary source model B.
 * 
 * Next a diff merge is done between temporary source model B and target model A.
 * 
 * Any Requif elements that were created in model A (Requirements, CapellaRelations), can not exist into model B since
 * this model was created from a reqif file. These newly created elements should be shown as deletions in the diff merge
 * TARGET SCOPE.
 * 
 * Any Requif deleted elements in model A that are still present in model B (and thus in the requif file) should be
 * shown as additions in the diff merge REFERENCE SCOPE.
 * 
 * The bug was that CapellaIncomingRelations were not removed from source model B during its construction, thus their
 * target was not correctly mapped to the existing Requirement in model A, and thus they were not shown as deletions but
 * as updates. Since the target of the CapellaIncomingRelation was a Requirement stored in temporary model, if the user
 * merges the changes, the save of the model will fail.
 *
 *
 * In this test we have imported the INPUT_REQUIF_FILE_NAME and we have <br/>
 * 1) Created 4 CapellaIncomingRelations <br/>
 * 2) Created 3 CapellaOutgoingRelations <br/>
 * 3) Created 1 Requirement <br/>
 * 4) Deleted 1 Existing Requirement <br/>
 * 
 * All of these changes must be present as IElementPresences in the target or reference scope.
 * 
 */
public class ModelDiffWithManuallyCreatedElements extends BasicTestCase {

  public static final String SYSTEM_ANALYSIS = "f02bb545-b9de-4f49-8a99-60d9ad390b3e"; //$NON-NLS-1$
  private static final String INPUT_REQUIF_FILE_NAME = "model/inputs/model1.reqif"; //$NON-NLS-1$
  private static final String MODEL_NAME = "model-with-manually-created-elements"; //$NON-NLS-1$

  private static final int TARGET_CAPELLA_INCOMING_RELATIONS_NUMBER = 4;
  private static final int TARGET_CAPELLA_OUTGOING_RELATIONS_NUMBER = 3;
  private static final int TARGET_CAPELLA_REQUIREMENTS_NUMBER = 1;

  private static final int REFERENCE_CAPELLA_INCOMING_RELATIONS_NUMBER = 0;
  private static final int REFERENCE_CAPELLA_OUTGOING_RELATIONS_NUMBER = 0;
  private static final int REFERENCE_CAPELLA_REQUIREMENTS_NUMBER = 1;

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(MODEL_NAME);
  }

  @SuppressWarnings("unchecked")
  @Override
  public void test() throws Exception {
    Session session = getSession(MODEL_NAME);
    assertNotNull(session);

    SessionContext sessionContext = new SessionContext(session);
    final BlockArchitecture systemAnalysis = sessionContext.getSemanticElement(SYSTEM_ANALYSIS);

    final TestRequirementsImportLauncher requirementsImportLauncher = new TestRequirementsImportLauncher();

    TransactionHelper.getExecutionManager(systemAnalysis).execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        File requifFile = IResourceHelpers.getFileOrFolderInTestPlugin(getClass(), INPUT_REQUIF_FILE_NAME);
        URI requifFileURI = URI.createFileURI(requifFile.getPath());
        requirementsImportLauncher.launch(requifFileURI, systemAnalysis, new NullProgressMonitor());
      }
    });

    IContext context = requirementsImportLauncher.getContext();

    List<IDifference> targetScopeDifferences = (List<IDifference>) context
        .get(TestInitializeTransformation.DIFFERENCES_FROM_TARGET_SCOPE);
    assertScopeDifferences(targetScopeDifferences, TARGET_CAPELLA_INCOMING_RELATIONS_NUMBER,
        TARGET_CAPELLA_OUTGOING_RELATIONS_NUMBER, TARGET_CAPELLA_REQUIREMENTS_NUMBER);

    List<IDifference> referenceScopeDifferences = (List<IDifference>) context
        .get(TestInitializeTransformation.DIFFERENCES_FROM_REFERENCE_SCOPE);
    assertScopeDifferences(referenceScopeDifferences, REFERENCE_CAPELLA_INCOMING_RELATIONS_NUMBER,
        REFERENCE_CAPELLA_OUTGOING_RELATIONS_NUMBER, REFERENCE_CAPELLA_REQUIREMENTS_NUMBER);

  }

  private void assertScopeDifferences(List<IDifference> differences, int incomingRelationsNumber,
      int outgoingRelationsNumber, int requirementsNumber) {
    List<CapellaIncomingRelation> incomingRelations = new ArrayList<>();
    List<CapellaOutgoingRelation> outgoingRelations = new ArrayList<>();
    List<Requirement> requirements = new ArrayList<>();

    for (IDifference difference : differences) {
      if (difference instanceof IElementPresence) {
        IElementPresence elementPresence = (IElementPresence) difference;
        EObject element = elementPresence.getElement();

        if (element instanceof CapellaIncomingRelation) {
          incomingRelations.add((CapellaIncomingRelation) element);
        } else if (element instanceof CapellaOutgoingRelation) {
          outgoingRelations.add((CapellaOutgoingRelation) element);
        } else if (element instanceof Requirement) {
          requirements.add((Requirement) element);
        }
      }
    }

    assertEquals(incomingRelationsNumber, incomingRelations.size());
    assertEquals(outgoingRelationsNumber, outgoingRelations.size());
    assertEquals(requirementsNumber, requirements.size());
  }

}
