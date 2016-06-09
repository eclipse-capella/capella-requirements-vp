/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.activities;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.ui.specification.IModelScopeDefinition;
import org.eclipse.emf.diffmerge.ui.specification.ext.ResourceScopeDefinition;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.datatypes.DatatypesPackage;
import org.eclipse.rmf.reqif10.serialization.ReqIF10ResourceFactoryImpl;
import org.eclipse.rmf.reqif10.xhtml.XhtmlPackage;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.common.ef.ExecutionManagerRegistry;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.transition.common.activities.AbstractActivity;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.IRequirementsImporterBridgeConstants;
import org.polarsys.kitalpha.cadence.core.api.parameter.ActivityParameters;
import org.polarsys.kitalpha.transposer.api.ITransposerWorkflow;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * @author Joao Barata
 */
public class InitializeTransformation extends AbstractActivity {

  public static final String getId() {
    return InitializeTransformation.class.getCanonicalName();
  }

  @Override
  protected IStatus _run(ActivityParameters activityParams) {

    IContext context = (IContext) activityParams.getParameter(ITransposerWorkflow.TRANSPOSER_CONTEXT).getValue();

    IEditableModelScope sourceScope = loadSourceScope(context);
    context.put(IRequirementsImporterBridgeConstants.SOURCE_SCOPE, sourceScope);

    IEditableModelScope targetScope = loadTransformationScope(context);
    context.put(IRequirementsImporterBridgeConstants.TARGET_SCOPE, targetScope);

    return Status.OK_STATUS;
  }

  /**
   * @param context
   */
  protected IEditableModelScope loadTransformationScope(IContext context) {
    EObject target = (BlockArchitecture) context.get(IRequirementsImporterBridgeConstants.TARGET_ELEMENT);
    IModelScopeDefinition definition = new ResourceScopeDefinition(target.eResource(), getId(), false);
    return definition.createScope(definition.getEntrypoint());
  }

  protected IEditableModelScope loadSourceScope(IContext context) {
    ExecutionManager manager = ExecutionManagerRegistry.getInstance().addNewManager();
    ResourceSet resourceSet = manager.getEditingDomain().getResourceSet();
    resourceSet.getPackageRegistry().put(ReqIF10Package.eINSTANCE.getNsURI(), ReqIF10Package.eINSTANCE);
    resourceSet.getPackageRegistry().put(XhtmlPackage.eINSTANCE.getNsURI(), XhtmlPackage.eINSTANCE);
    resourceSet.getPackageRegistry().put(DatatypesPackage.eINSTANCE.getNsURI(), DatatypesPackage.eINSTANCE);
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new ReqIF10ResourceFactoryImpl());

    URI uri = (URI) context.get(IRequirementsImporterBridgeConstants.CONTEXT_MODEL);
    Resource resource = resourceSet.getResource(uri, true);
    IModelScopeDefinition definition = new ResourceScopeDefinition(resource, getId(), false);
    return definition.createScope(definition.getEntrypoint());
  }
}
