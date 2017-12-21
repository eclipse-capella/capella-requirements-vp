/*******************************************************************************
 * Copyright (c) 2016, 2017 THALES GLOBAL SERVICES.
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
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.ui.specification.IModelScopeDefinition;
import org.eclipse.emf.diffmerge.ui.specification.ext.ResourceScopeDefinition;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.datatypes.DatatypesPackage;
import org.eclipse.rmf.reqif10.serialization.ReqIF10ResourceFactoryImpl;
import org.eclipse.rmf.reqif10.xhtml.XhtmlPackage;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.common.ef.ExecutionManagerRegistry;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.transition.common.activities.AbstractActivity;
import org.polarsys.capella.vp.requirements.importer.RequirementsVPPlugin;
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

    IStatus loadSourceStatus = loadSourceScope(context);
    if (!checkStatus(loadSourceStatus)) {
      return loadSourceStatus;
    }

    IStatus loadTargetStatus = loadTransformationScope(context);
    if (!checkStatus(loadTargetStatus)) {
      return loadTargetStatus;
    }

    return Status.OK_STATUS;
  }

  /**
   * @param context
   */
  protected IStatus loadTransformationScope(IContext context) {
    EObject target = (BlockArchitecture) context.get(IRequirementsImporterBridgeConstants.TARGET_ELEMENT);
    IModelScopeDefinition definition = new ResourceScopeDefinition(target.eResource(), getId(), false);
    IEditableModelScope targetScope = definition.createScope(definition.getEntrypoint());
    context.put(IRequirementsImporterBridgeConstants.TARGET_SCOPE, targetScope);
    return Status.OK_STATUS;
  }

  /**
   * @param context
   */
  protected IStatus loadSourceScope(IContext context) {
    ExecutionManager manager = ExecutionManagerRegistry.getInstance().addNewManager();
    ResourceSet resourceSet = manager.getEditingDomain().getResourceSet();
    resourceSet.getPackageRegistry().put(ReqIF10Package.eINSTANCE.getNsURI(), ReqIF10Package.eINSTANCE);
    resourceSet.getPackageRegistry().put(XhtmlPackage.eINSTANCE.getNsURI(), XhtmlPackage.eINSTANCE);
    resourceSet.getPackageRegistry().put(DatatypesPackage.eINSTANCE.getNsURI(), DatatypesPackage.eINSTANCE);
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new ReqIF10ResourceFactoryImpl());

    URI uri = (URI) context.get(IRequirementsImporterBridgeConstants.CONTEXT_MODEL);
    Resource resource = resourceSet.getResource(uri, true);
    IModelScopeDefinition definition = new ResourceScopeDefinition(resource, getId(), false);
    IEditableModelScope sourceScope = definition.createScope(definition.getEntrypoint());
    context.put(IRequirementsImporterBridgeConstants.SOURCE_SCOPE, sourceScope);
    return checkErrors(resource.getErrors());
  }

  private IStatus checkErrors(EList<Diagnostic> errors) {
    if (errors == null || errors.isEmpty()){
      return Status.OK_STATUS;
    }
    if (errors.size() == 1){
      return new Status(IStatus.ERROR, RequirementsVPPlugin.PLUGIN_ID, 0, errors.get(0).getMessage(), safeCast(errors.get(0)));
    }
    MultiStatus statii = new MultiStatus(RequirementsVPPlugin.PLUGIN_ID, 0, "Errors while loading ReqIF file", null);
    for (Diagnostic diagnostic : errors) {
      statii.add(new Status(IStatus.ERROR, RequirementsVPPlugin.PLUGIN_ID, 0, diagnostic.getMessage(), safeCast(diagnostic)));
    }
    return statii;
  }

  private Throwable safeCast(Diagnostic diagnostic) {
    if(diagnostic instanceof Throwable){
      return (Throwable)diagnostic;
    }
    return null;
  }
}
