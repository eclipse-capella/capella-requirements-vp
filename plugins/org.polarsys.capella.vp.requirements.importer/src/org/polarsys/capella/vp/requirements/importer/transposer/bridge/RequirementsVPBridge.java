/*******************************************************************************
 * Copyright (c) 2018, 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.diffmerge.api.scopes.IEditableModelScope;
import org.eclipse.emf.diffmerge.bridge.api.IBridge;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace;
import org.eclipse.emf.diffmerge.bridge.incremental.BridgeTraceBasedMatchPolicy;
import org.eclipse.emf.diffmerge.bridge.interactive.EMFInteractiveBridge;
import org.eclipse.emf.diffmerge.bridge.interactive.UpdateDialog;
import org.eclipse.emf.diffmerge.bridge.traces.gen.bridgetraces.BridgetracesFactory;
import org.eclipse.emf.diffmerge.bridge.traces.gen.bridgetraces.Trace;
import org.eclipse.emf.diffmerge.diffdata.EComparison;
import org.eclipse.emf.diffmerge.diffdata.impl.EComparisonImpl;
import org.eclipse.emf.diffmerge.generic.api.IComparison;
import org.eclipse.emf.diffmerge.generic.api.IDiffPolicy;
import org.eclipse.emf.diffmerge.generic.api.IMatchPolicy;
import org.eclipse.emf.diffmerge.generic.api.IMergePolicy;
import org.eclipse.emf.diffmerge.generic.api.IMergeSelector;
import org.eclipse.emf.diffmerge.generic.api.diff.IDifference;
import org.eclipse.emf.diffmerge.generic.api.scopes.ITreeDataScope;
import org.eclipse.emf.diffmerge.ui.viewers.AbstractComparisonViewer;
import org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode;
import org.eclipse.emf.diffmerge.ui.viewers.categories.DifferenceCategorySet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.data.capellamodeller.Project;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.cs.CsPackage;
import org.polarsys.capella.core.model.handler.helpers.HoldingResourceHelper;
import org.polarsys.capella.core.model.helpers.ProjectExt;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaModule;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaTypesFolder;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.categories.EClassCategory;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.categories.RelationIdentifierCategory;
import org.polarsys.kitalpha.emde.model.ElementExtension;
import org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * @author Joao Barata
 */
public class RequirementsVPBridge extends EMFInteractiveBridge<IEditableModelScope, IEditableModelScope> {

  public static IEditableModelScope temporaryScope = null;
  IEditableModelScope _sourceScope;
  IEditableModelScope _targetScope;

  public RequirementsVPBridge(IEditableModelScope sourceScope, IEditableModelScope targetScope,
      IBridge<IEditableModelScope, IEditableModelScope> bridge, IDiffPolicy<EObject> diffPolicy,
      IMergePolicy<EObject> mergePolicy, IMergeSelector<EObject> merger) {
    super(bridge, diffPolicy, mergePolicy, merger);
    _sourceScope = sourceScope;
    _targetScope = targetScope;
  }

  @Override
  protected IBridgeTrace.Editable createTrace() {
    Trace trace = BridgetracesFactory.eINSTANCE.createTrace();
    initializeTrace(trace);
    return trace;
  }

  @Override
  protected EComparison compare(IEditableModelScope created, IEditableModelScope existing, IBridgeTrace createdTrace,
      IBridgeTrace existingTrace, IProgressMonitor monitor) {
    EComparison result = new EComparisonImpl(existing, created);

    IMatchPolicy<EObject> matchPolicy = new BridgeTraceBasedMatchPolicy<EObject>(created, createdTrace, existingTrace) {

      @Override
      public Object getMatchID(EObject element, ITreeDataScope<EObject> scope) {
        Object trace = super.getMatchID(element, scope);
        if (trace == null) {
          trace = EcoreUtil.getID(element);
        }
        return trace;
      }

    };
    result.compute(matchPolicy, getDiffPolicy(), getMergePolicy(), monitor);
    return result;
  }

  @Override
  public IEditableModelScope createIntermediateDataSet(IEditableModelScope sourceDataSet,
      IEditableModelScope targetDataSet) {
    // if (null == temporaryScope) {
    IEditableModelScope scope = super.createIntermediateDataSet(sourceDataSet, targetDataSet);
    initializeTemporaryScope(scope);
    temporaryScope = scope;
    // }
    return temporaryScope;
  }

  protected void initializeTemporaryScope(final IEditableModelScope scope) {
    // We want to create an empty model with same IDs than the target (to avoid reconciliation)
    final IEditableModelScope targetScope = _targetScope;
    Resource target = EcoreUtil.getRootContainer(targetScope.getContents().get(0)).eResource();
    // We load the target elements using the source editing domain to avoid blocking the target editing domain during
    // Import
    Resource targetLoadedInSourceScope = _sourceScope.getContents().get(0).eResource().getResourceSet()
        .getResource(target.getURI(), true);

    scope.add(targetLoadedInSourceScope.getContents().get(0));

    // We remove the imported modules content since we create only elements in this package
    ExecutionManager manager = TransactionHelper.getExecutionManager(_sourceScope.getContents());
    if (manager != null) {
      manager.execute(new AbstractReadWriteCommand() {
        @Override
        public void run() {
          Resource holdingResource = HoldingResourceHelper
              .getHoldingResource(TransactionHelper.getEditingDomain(_sourceScope.getContents()));

          Project project = ProjectExt.getProject(scope.getContents().get(0));
          HoldingResourceHelper.attachToHoldingResource(project, holdingResource);
          removeImportedModules(project);

          TreeIterator<EObject> it = project.eAllContents();
          Map<CapellaRelation, Collection<?>> capellaRelationsMap = new HashMap<>();

          while (it.hasNext()) {
            EObject element = it.next();

            if (element instanceof CapellaRelation) {
              updateCapellaRelationsMap((CapellaRelation) element, capellaRelationsMap);
            }

            else if (element instanceof ModelElement) {
              ((ModelElement) element).getId();
            }
          }

          removeCapellaRelations(capellaRelationsMap);
        }

      });
    }
  }

  void removeImportedModules(Project project) {
    for (EObject block : EObjectExt.getAll(project, CsPackage.Literals.BLOCK_ARCHITECTURE)) {
      List<ElementExtension> toBeRemoved = new ArrayList<ElementExtension>();
      Iterator<ElementExtension> it = ((BlockArchitecture) block).getOwnedExtensions().iterator();
      while (it.hasNext()) {
        ElementExtension ext = it.next();
        if (ext instanceof ReqIFElement) {
          String reqifid = ((ReqIFElement) ext).getReqIFIdentifier();
          if (reqifid != null && !reqifid.isEmpty()) {
            if (ext instanceof CapellaModule) {
              toBeRemoved.add(ext);
            } else if (ext instanceof CapellaTypesFolder) {
              ((CapellaTypesFolder) ext).getOwnedTypes().clear();
              ((CapellaTypesFolder) ext).getOwnedDefinitionTypes().clear();
            }
          }
        }
      }
      ((BlockArchitecture) block).getOwnedExtensions().removeAll(toBeRemoved);
    }
  }

  private void updateCapellaRelationsMap(CapellaRelation capellaRelation,
      Map<CapellaRelation, Collection<?>> capellaRelationsMap) {
    EObject container = capellaRelation.eContainer();
    if (container != null) {
      EStructuralFeature containingFeature = capellaRelation.eContainingFeature();
      if (containingFeature != null) {
        Object containingObject = container.eGet(containingFeature);
        if (containingObject instanceof Collection<?>) {
          Collection<?> containingCollection = (Collection<?>) containingObject;
          capellaRelationsMap.put(capellaRelation, containingCollection);
        }
      }
    }
  }

  private void removeCapellaRelations(Map<CapellaRelation, Collection<?>> capellaRelationsMap) {
    for (Map.Entry<CapellaRelation, Collection<?>> entry : capellaRelationsMap.entrySet()) {
      CapellaRelation capellaRelation = entry.getKey();
      Collection<?> containingCollection = entry.getValue();

      try {
        containingCollection.remove(capellaRelation);
      } catch (UnsupportedOperationException e) {
        e.printStackTrace();
      }
    }

  }

  @Override
  protected void handleMergedDifferences(final IComparison<EObject> comparison, final IBridgeTrace createdTrace,
      final IBridgeTrace existingTrace) {
    ExecutionManager manager = TransactionHelper.getExecutionManager(_targetScope.getContents());
    if (manager != null) {
      manager.execute(new AbstractReadWriteCommand() {
        @Override
        public void run() {
          RequirementsVPBridge.super.handleMergedDifferences(comparison, createdTrace, existingTrace);
        }
      });
    }
  }

  @Override
  protected EMFDiffNode createDiffNode(EComparison comparison, EditingDomain domain) {
    final EMFDiffNode diffNode = super.createDiffNode(comparison, domain);

    Collection<IDifference<EObject>> remainingDifferences = comparison.getRemainingDifferences();

    DifferenceCategorySet set = new DifferenceCategorySet(Messages.Categories_Name, Messages.Categories_Description);
    set.getChildren().add(new EClassCategory(RequirementsPackage.Literals.INTERNAL_RELATION,
        Messages.Categories_InternalRelations, RequirementsPackage.Literals.INTERNAL_RELATION));

    EClassCategory typesFolderEClassCategory = new EClassCategory(RequirementsPackage.Literals.TYPES_FOLDER,
        Messages.Categories_Types, RequirementsPackage.Literals.ENUM_VALUE,
        RequirementsPackage.Literals.DATA_TYPE_DEFINITION, RequirementsPackage.Literals.ATTRIBUTE_DEFINITION,
        RequirementsPackage.Literals.ABSTRACT_TYPE, RequirementsPackage.Literals.TYPES_FOLDER);
    typesFolderEClassCategory.setActive(true); /* Types Folder are now filtered */
    set.getChildren().add(typesFolderEClassCategory);

    set.getChildren().add(new RelationIdentifierCategory());

    diffNode.getCategoryManager().addCategories(set);
    return diffNode;
  }

  public void initializeTrace(Trace trace) {
    trace.setSymbolFunction(RequirementEMFSYmbolFunction.getInstance());
  }

  protected AbstractComparisonViewer createComparisonViewer(Composite parent) {
    return new RequirementsComparisonViewer(parent);
  }

  @Override
  protected UpdateDialog createMergeDialog(EMFDiffNode diffNode_p) {
    return new RequirementsVPMergeDialog(Display.getDefault().getActiveShell(), getTitle(), diffNode_p);
  }
}
