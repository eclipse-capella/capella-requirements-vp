/*******************************************************************************
 * Copyright (c) 2016, 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.activities;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.api.IBridge;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace;
import org.eclipse.emf.diffmerge.bridge.api.incremental.IIncrementalBridgeExecution;
import org.eclipse.emf.diffmerge.bridge.interactive.util.ResourceUtil;
import org.eclipse.emf.diffmerge.bridge.traces.gen.bridgetraces.BridgetracesFactory;
import org.eclipse.emf.diffmerge.bridge.traces.gen.bridgetraces.BridgetracesPackage;
import org.eclipse.emf.diffmerge.bridge.traces.gen.bridgetraces.Trace;
import org.eclipse.emf.diffmerge.diffdata.EComparison;
import org.eclipse.emf.diffmerge.impl.scopes.FragmentedModelScope;
import org.eclipse.emf.diffmerge.ui.specification.IModelScopeDefinition;
import org.eclipse.emf.diffmerge.ui.specification.ext.ResourceScopeDefinition;
import org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.datatypes.DatatypesPackage;
import org.eclipse.rmf.reqif10.serialization.ReqIF10ResourceFactoryImpl;
import org.eclipse.rmf.reqif10.xhtml.XhtmlPackage;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.common.ef.ExecutionManagerRegistry;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.capellamodeller.util.CapellamodellerResourceFactoryImpl;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.model.handler.command.CapellaResourceHelper;
import org.polarsys.capella.core.transition.common.activities.AbstractActivity;
import org.polarsys.capella.vp.requirements.importer.RequirementsVPPlugin;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.IRequirementsImporterBridgeConstants;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMapping;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementsVPBridge;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFImporterDiffPolicy;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFMergePolicy;
import org.polarsys.kitalpha.cadence.core.api.parameter.ActivityParameters;
import org.polarsys.kitalpha.transposer.api.ITransposerWorkflow;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * @author Joao Barata
 */
public class InitializeTransformation extends AbstractActivity {

  public static String getId() {
    return InitializeTransformation.class.getCanonicalName();
  }

  @Override
  protected IStatus _run(final ActivityParameters activityParams) {
    Job job = new Job("Load ReqIF resource") {
      @Override
      protected IStatus run(IProgressMonitor monitor) {
        return initializeTransformation(activityParams);
      }
    };
    job.setRule(ReqIFJobSchedulingRule.getInstance());
    job.setPriority(Job.SHORT);
    job.schedule();
    return Status.OK_STATUS;
  }

  protected IStatus initializeTransformation(final ActivityParameters activityParams) {
    final IContext context = (IContext) activityParams.getParameter(ITransposerWorkflow.TRANSPOSER_CONTEXT).getValue();

    IStatus loadSourceStatus = loadSourceScope(context);
    if (!checkStatus(loadSourceStatus)) {
      return loadSourceStatus;
    }

    IStatus loadTargetStatus = loadTransformationScope(context);
    if (!checkStatus(loadTargetStatus)) {
      return loadTargetStatus;
    }

    final IEditableModelScope sourceScope = (IEditableModelScope) context
        .get(IRequirementsImporterBridgeConstants.SOURCE_SCOPE);
    final IEditableModelScope targetScope = (IEditableModelScope) context
        .get(IRequirementsImporterBridgeConstants.TARGET_SCOPE);

    // Define the set of rules for the transformation
    ReqIFMapping mapping = new ReqIFMapping(context);

    // Incremental bridge
    final RequirementsVPBridge bridge = createBridge(sourceScope, targetScope, mapping);

    // Load traces
    Resource traceResource = getCreateResource(getTraceURI(getTransformationURI(targetScope)),
        getTransformationDomain(targetScope));
    IBridgeTrace/* .Editable */ existingTrace = /* (IBridgeTrace.Editable) */getTrace(bridge, traceResource);

    // Do the merge
    final IIncrementalBridgeExecution execution2 = bridge.executeOn(sourceScope, targetScope, null/* execution */,
        existingTrace/* execution.getTrace() */, true, new NullProgressMonitor());

    context.put(IRequirementsImporterBridgeConstants.BRIDGE, bridge);
    context.put(IRequirementsImporterBridgeConstants.TRACE_RESOURCE, traceResource);
    context.put(IRequirementsImporterBridgeConstants.BRIDGE_EXECUTION, execution2);
    return Status.OK_STATUS;
  }

  protected TransactionalEditingDomain getTransformationDomain(IEditableModelScope definition) {
    return TransactionUtil
        .getEditingDomain(((FragmentedModelScope) definition).getRootResources().iterator().next().getResourceSet());
  }

  protected URI getTransformationURI(IEditableModelScope definition) {
    return ((FragmentedModelScope) definition).getRootResources().iterator().next().getURI();
  }

  protected RequirementsVPBridge createBridge(IEditableModelScope sourceScope, IEditableModelScope targetScope,
      IBridge<IEditableModelScope, IEditableModelScope> bridge) {
    return new RequirementsVPBridge(sourceScope, targetScope, bridge, new ReqIFImporterDiffPolicy(),
        new ReqIFMergePolicy(), null) {
      @Override
      protected EMFDiffNode createDiffNode(EComparison comparison, EditingDomain domain) {
        EMFDiffNode diffNode = super.createDiffNode(comparison, domain);
        return diffNode;
      }
    };
  }

  /**
   * TODO COEV From org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob
   */
  protected URI getTraceURI(URI uri) {
    return uri.appendFileExtension(BridgetracesPackage.eNAME);
  }

  /**
   * @param context
   */
  protected IStatus loadTransformationScope(IContext context) {
    EObject target = (BlockArchitecture) context.get(IRequirementsImporterBridgeConstants.TARGET_ELEMENT);
    EObject root = EcoreUtil.getRootContainer(target);
    // Target scope must not be read-only. Otherwise we can have problems during the merge
    IModelScopeDefinition definition = new ResourceScopeDefinition(root.eResource(), getId(), true);
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

    // Capella resources can be loaded using source scope editing domain (see
    // org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementsVPBridge.initializeTemporaryScope(IEditableModelScope))
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(CapellaResourceHelper.CAPELLA_MODEL_FILE_EXTENSION, new CapellamodellerResourceFactoryImpl());
    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(CapellaResourceHelper.CAPELLA_FRAGMENT_FILE_EXTENSION, new CapellamodellerResourceFactoryImpl());

    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
        .put(IRequirementsImporterBridgeConstants.REQIF_MODEL_FILE_EXTENSION, new ReqIF10ResourceFactoryImpl());

    URI uri = (URI) context.get(IRequirementsImporterBridgeConstants.CONTEXT_MODEL);
    Resource resource = resourceSet.getResource(uri, true);
    IModelScopeDefinition definition = new ResourceScopeDefinition(resource, getId(), false);
    IEditableModelScope sourceScope = definition.createScope(definition.getEntrypoint());
    context.put(IRequirementsImporterBridgeConstants.SOURCE_SCOPE, sourceScope);
    return checkErrors(resource.getErrors());
  }

  private IStatus checkErrors(EList<Diagnostic> errors) {
    if (errors == null || errors.isEmpty()) {
      return Status.OK_STATUS;
    }
    if (errors.size() == 1) {
      return new Status(IStatus.ERROR, RequirementsVPPlugin.PLUGIN_ID, 0, errors.get(0).getMessage(),
          safeCast(errors.get(0)));
    }
    MultiStatus statii = new MultiStatus(RequirementsVPPlugin.PLUGIN_ID, 0, "Errors while loading ReqIF file", null);
    for (Diagnostic diagnostic : errors) {
      statii.add(
          new Status(IStatus.ERROR, RequirementsVPPlugin.PLUGIN_ID, 0, diagnostic.getMessage(), safeCast(diagnostic)));
    }
    return statii;
  }

  private Throwable safeCast(Diagnostic diagnostic) {
    if (diagnostic instanceof Throwable) {
      return (Throwable) diagnostic;
    }
    return null;
  }

  /**
   * TODO COEV From org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob, if no trace, we create one
   * 
   * @param bridge
   */
  protected IBridgeTrace getTrace(final RequirementsVPBridge bridge, final Resource traceResource) {
    IBridgeTrace trace = null;
    if (!traceResource.getContents().isEmpty()) {
      EObject root = traceResource.getAllContents().next();
      if (root instanceof IBridgeTrace) {
        trace = (IBridgeTrace) root;
      }
    }
    if (trace == null) {
      trace = BridgetracesFactory.eINSTANCE.createTrace();
    }

    final Trace trace2 = /* EcoreUtil.copy( */(Trace) trace/* ) */;
    TransactionHelper.getExecutionManager(traceResource).execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        if (traceResource.getContents().isEmpty()) {
          traceResource.getContents().add(trace2);
        }
        bridge.initializeTrace(trace2);

      }
    });
    // bridge.initializeTrace(trace2);
    return trace;
  }

  /**
   * TODO COEV From org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob
   */
  protected Resource getCreateResource(URI uri, TransactionalEditingDomain domain) {
    ResourceSet rs = domain.getResourceSet();
    Resource result = ResourceUtil.getCreateResourceForUri(uri, rs); // TODO COEV not exported
    ResourceUtil.ensureLoaded(result);
    return result;
  }
}
