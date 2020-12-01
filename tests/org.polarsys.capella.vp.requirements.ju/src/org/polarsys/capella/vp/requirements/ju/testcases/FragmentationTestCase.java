/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.diffdata.EElementPresence;
import org.eclipse.emf.diffmerge.generic.api.diff.IDifference;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.handler.helpers.SemanticResourcesScope;
import org.polarsys.capella.shared.id.handler.IdManager;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.test.framework.helpers.IResourceHelpers;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaModule;
import org.polarsys.capella.vp.requirements.ju.transposer.TestInitializeTransformation;
import org.polarsys.capella.vp.requirements.ju.transposer.TestRequirementsImportLauncher;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

public class FragmentationTestCase extends BasicTestCase {

  private static final String systemAnalysis = "24658239-7734-4c39-9402-83325c52d04c";

  private static final String inputFileName = "model/inputs/model1.reqif";

  private static final String projectTestName = "fragmentedModel";

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
    SessionContext session = new SessionContext(getSession(projectTestName)) {

      @Override
      public <T extends EObject> T getSemanticElement(String objectIdentifier) {
        Map<String, EObject> map = getSemanticObjectMap();
        if (!map.containsKey(objectIdentifier)) {
          EObject object = IdManager.getInstance().getEObject(objectIdentifier,
              new SemanticResourcesScope(getSession().getTransactionalEditingDomain().getResourceSet()));
          putSemanticElement(objectIdentifier, object);
        }
        return (T) map.get(objectIdentifier);
      }

    };

    final EObject target = session.getSemanticElement(systemAnalysis);

    assertTrue(((BlockArchitecture) target).getOwnedExtensions().isEmpty());

    TestRequirementsImportLauncher testRequirementsImportLauncher = new TestRequirementsImportLauncher();
    TransactionHelper.getExecutionManager(target).execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        File file = IResourceHelpers.getFileOrFolderInTestPlugin(getClass(), inputFileName);
        URI model = URI.createFileURI(file.getPath());
        testRequirementsImportLauncher.launch(model, (BlockArchitecture) target, new NullProgressMonitor());
      }
    });
    assertTrue(((BlockArchitecture) target).getOwnedExtensions().stream().anyMatch(x -> x instanceof CapellaModule));

    IContext context = testRequirementsImportLauncher.getContext();
    Collection<IDifference<EObject>> differencesFromReferenceScope = (Collection<IDifference<EObject>>) context
        .get(TestInitializeTransformation.DIFFERENCES_FROM_REFERENCE_SCOPE);

    boolean anyMatch = differencesFromReferenceScope.stream().filter(EElementPresence.class::isInstance)
        .map(EElementPresence.class::cast).anyMatch(diff -> (diff.getElement() instanceof ModelElement));
    assertFalse("There should not be differences of Capella Element in the Candidate model", anyMatch);
  }
}
