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

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.compare.CapellaMergePolicy;
import org.polarsys.capella.core.model.handler.helpers.HoldingResourceHelper;
import org.polarsys.capella.core.transition.common.activities.AbstractActivity;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.IRequirementsImporterBridgeConstants;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMapping;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.RequirementsVPBridge;
import org.polarsys.capella.vp.requirements.importer.transposer.policies.ReqIFImporterDiffPolicy;
import org.polarsys.kitalpha.cadence.core.api.parameter.ActivityParameters;
import org.polarsys.kitalpha.transposer.api.ITransposerWorkflow;
import org.polarsys.kitalpha.transposer.rules.handler.rules.api.IContext;

/**
 * @author Joao Barata
 */
public class TransposerTransformation extends AbstractActivity {

  public static String getId() {
    return TransposerTransformation.class.getCanonicalName();
  }

  @Override
  protected IStatus _run(ActivityParameters activityParams) {

    final IContext context = (IContext) activityParams.getParameter(ITransposerWorkflow.TRANSPOSER_CONTEXT).getValue();
    final IEditableModelScope sourceScope = (IEditableModelScope) context.get(IRequirementsImporterBridgeConstants.SOURCE_SCOPE);
    final IEditableModelScope targetScope = (IEditableModelScope) context.get(IRequirementsImporterBridgeConstants.TARGET_SCOPE);

    // Define the set of rules for the transformation
    ReqIFMapping mapping = new ReqIFMapping(context);
    
    // Incremental bridge
    final RequirementsVPBridge bridge = createBridge(targetScope, mapping);

    // Load traces
    Resource traceResource = getCreateResource(getTraceURI(getTransformationURI(targetScope)), getTransformationDomain(targetScope));
    IBridgeTrace/*.Editable*/ existingTrace = /*(IBridgeTrace.Editable)*/ getTrace(bridge, traceResource);

    // Run transformation
    //IMappingExecution execution = mapping.createExecution(existingTrace);
    //((MappingExecution) execution).setTolerantToDuplicates(true); //?
    //SystemArchitectBridge.temporaryScope = null;
    //IEditableModelScope tempScope = bridge.createIntermediateDataSet(sourceScope, targetScope);
    
    //execution = mapping.executeOn(sourceScope, tempScope, execution, new NullProgressMonitor());
    
    // Do only the merge
    final IIncrementalBridgeExecution execution2 = bridge.executeOn(sourceScope, targetScope, null/*execution*/, existingTrace/*execution.getTrace()*/, true, new NullProgressMonitor());

    // TODO do here all necessary transformations before to show the diff/merge dialog
    
    bridge.mergeInteractively(execution2, new NullProgressMonitor());

    // Save traces and output model
    save(execution2, traceResource, execution2.getTrace(), targetScope);

  	TransactionHelper.getExecutionManager(traceResource).execute(new AbstractReadWriteCommand() {
  	      @Override
  	      public void run() {
              HoldingResourceHelper.flushHoldingResource(TransactionHelper.getEditingDomain(targetScope.getContents().get(0)));
  	      }
  	});

    return Status.OK_STATUS;
  }

  protected RequirementsVPBridge createBridge(IEditableModelScope targetScope, IBridge<IEditableModelScope, IEditableModelScope> bridge) {
    return new RequirementsVPBridge(targetScope, bridge, new ReqIFImporterDiffPolicy(), new CapellaMergePolicy(), null) {
      @Override
      protected EMFDiffNode createDiffNode(EComparison comparison, EditingDomain domain) {
        EMFDiffNode diffNode = super.createDiffNode(comparison, domain);

//        diffNode.setCount(UserDifferenceKind.MOVE, false);
//
//        for (IDifference diff : comparison.getDifferences(Role.TARGET)) {
//          if (diff instanceof EReferenceValuePresence) {
//            EReferenceValuePresence valuePresence = (EReferenceValuePresence) diff;
//            EReference reference = valuePresence.getFeature();
//            if (EmdePackage.Literals.EXTENSIBLE_ELEMENT__OWNED_EXTENSIONS.equals(reference)
//             || RequirementsPackage.Literals.TYPES_FOLDER__OWNED_TYPES.equals(reference)) {
//              EObject rootPkg = ReqIFMappingQueries.getTypesFolder(context, targetScope);
//              EObject value = valuePresence.getValue().getTarget();
//              if (rootPkg.equals(value) || EObjectExt.isContainedBy(value, rootPkg)) {
//                diffNode.getUIComparison().getDifferencesToIgnore().add(valuePresence);
//                diffNode.getUIComparison().getDifferencesToIgnore().addAll((Collection<? extends EMergeableDifference>) valuePresence.getExplicitDependenciesForReference());
//              }
//            }
//          } else if (diff instanceof EElementPresence) {
//            EElementPresence elementPresence = (EElementPresence) diff;
//            if (CapellaRequirementsPackage.Literals.CAPELLA_TYPES_FOLDER.equals(elementPresence.getElement().eClass())) {
//              diffNode.getUIComparison().getDifferencesToIgnore().add(elementPresence);
//            }
//          }
//        }

        return diffNode;
      }
    };
  }

  /**
   * @param traceResource
   * @param trace
   */
  @SuppressWarnings("rawtypes")
  private void save(IIncrementalBridgeExecution execution, Resource traceResource, IBridgeTrace trace,
      IEditableModelScope targetScope) {

    try {
      // setTrace(traceResource, execution.getTrace());
      // compact(traceResource);
      traceResource.save(new HashMap());
      targetScope.getContents().get(0).eResource().save(new HashMap());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  protected static void compact(Resource resource) {
    List<EObject> filtered = EcoreUtil.filterDescendants(resource.getContents());
    resource.getContents().retainAll(filtered);
  }

  protected static void setTrace(final Resource traceResource, final IBridgeTrace trace) {
	TransactionHelper.getExecutionManager(traceResource).execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        traceResource.getContents().clear();
        traceResource.getContents().add((EObject) trace);
      }
    });
  }

  protected TransactionalEditingDomain getTransformationDomain(IEditableModelScope definition) {
    return TransactionUtil.getEditingDomain(((FragmentedModelScope) definition).getRootResources().iterator().next()
        .getResourceSet());
  }

  protected URI getTransformationURI(IEditableModelScope definition) {
    return ((FragmentedModelScope) definition).getRootResources().iterator().next().getURI();
  }

  /**
   * TODO COEV From org.eclipse.emf.diffmerge.bridge.interactive.BridgeJob
   */
  protected URI getTraceURI(URI uri) {
    return uri.appendFileExtension(BridgetracesPackage.eNAME);
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

    final Trace trace2 = /*EcoreUtil.copy(*/(Trace) trace/*)*/;
    TransactionHelper.getExecutionManager(traceResource).execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        if (traceResource.getContents().isEmpty()) {
          traceResource.getContents().add(trace2);
        }
        bridge.initializeTrace(trace2);

      }
    });
    //bridge.initializeTrace(trace2);
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
