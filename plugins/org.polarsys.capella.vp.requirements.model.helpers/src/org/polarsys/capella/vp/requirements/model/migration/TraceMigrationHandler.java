/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.model.migration;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.capella.core.data.migration.AbstractMigrationRunnable;
import org.polarsys.capella.core.data.migration.Messages;
import org.polarsys.capella.core.data.migration.MigrationJobScheduler;
import org.polarsys.capella.core.data.migration.context.MigrationContext;
import org.polarsys.capella.core.data.migration.handlers.AbstractMigrationHandler;
import org.polarsys.capella.vp.requirements.model.helpers.TraceHelper;

public class TraceMigrationHandler extends AbstractMigrationHandler {

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);

    for (Object element : selection.toArray()) {
      if (element instanceof IFile) {
        IFile traceFile = (IFile) element;

        MigrationContext context = new MigrationContext();
        context.setName(NLS.bind(Messages.MigrationAction_Title, traceFile.getName()));
        context.setShell(HandlerUtil.getActiveShell(event));
        context.setSkipConfirmation(false);
        context.setBackupModel(false);

        AbstractMigrationRunnable migrationRunnable = new TraceMigrationRunnable(traceFile);
        LinkedList<AbstractMigrationRunnable> runnables = new LinkedList<>();
        runnables.add(migrationRunnable);

        new MigrationJobScheduler().run(runnables, context, true, false);
      }
    }

    return event;

  }

  @Override
  protected boolean isValidSelection(List<Object> selection) {
    return selection.stream().allMatch(o -> o instanceof IFile && TraceHelper.isLegacyTraceResource((IFile) o));
  }

}