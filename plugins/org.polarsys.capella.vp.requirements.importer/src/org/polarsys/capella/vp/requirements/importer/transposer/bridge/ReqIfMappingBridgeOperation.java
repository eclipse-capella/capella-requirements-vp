/*******************************************************************************
 * Copyright (c) 2016, 2018 THALES GLOBAL SERVICES.
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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingBridge;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IRule;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.MappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.MappingExecution.PendingDefinition;
import org.eclipse.emf.diffmerge.bridge.mapping.operations.MappingBridgeOperation;
import org.eclipse.emf.diffmerge.impl.scopes.RootedModelScope;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.common.ef.ExecutionManager;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;

/**
 * @author Joao Barata
 */
public class ReqIfMappingBridgeOperation extends MappingBridgeOperation {

	public ReqIfMappingBridgeOperation(Object sourceDataSet, Object targetDataSet, IMappingBridge<?, ?> bridge, IBridgeExecution execution) {
		super(sourceDataSet, targetDataSet, bridge, execution);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleBridge(final IMappingBridge<?, ?> bridge, final MappingExecution execution, final Object sourceDataSet, final Object targetDataSet) {
		ExecutionManager manager = TransactionHelper.getExecutionManager(((RootedModelScope) targetDataSet).getContents());
		if (manager != null) {
			manager.execute(new AbstractReadWriteCommand() {
				@Override
				public void run() {
				    try {
				        ReqIfMappingBridgeOperation.super.handleBridge(bridge, execution, sourceDataSet, targetDataSet);
				    } catch (OperationCanceledException e) {
				        execution.setStatus(Status.CANCEL_STATUS);
				    }
				}
			});
		}
	}
	
  /**
   * {@inheritDoc}
   */
	@Override
	protected void handleRuleForTargetDefinition(IRule<?, ?, ?> rule, PendingDefinition pendingDef, MappingExecution execution) {
	  super.handleRuleForTargetDefinition(rule, pendingDef, execution);

	  prepareTarget(pendingDef.getTarget());
	}

	/**
	 * Set up systematic, elementary properties of the given target data object
	 * @param target a non-null object
	 */
	protected void prepareTarget(Object target) {
    if (target instanceof TupleNP) {
      for (Object e : ((TupleNP<?>) target).asCollection()) {
        if (e instanceof ModelElement) {
          ((ModelElement) e).getId();
        }
      }
    }
    if (target instanceof ModelElement) {
      ((ModelElement) target).getId();
    }
	}
	
	@Override
	public IStatus run() {
	    IStatus runStatus = super.run();
	    IStatus executionStatus = getBridgeExecution().getStatus();
	    if (executionStatus.equals(Status.CANCEL_STATUS)) {
	        return executionStatus;
	    }
	    return runStatus;
	}
}
