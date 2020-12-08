/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ui.semanticbrowser.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.polarsys.capella.common.ui.toolkit.browser.view.ISemanticBrowserViewPart;
import org.polarsys.capella.vp.requirements.semantic.browser.queries.QueriesStateProvider;

/**
 * @author Joao Barata
 */
public class ShowHideRequirements implements IViewActionDelegate {

  protected ISemanticBrowserViewPart view;

	@Override
	public void run(IAction action) {
	  QueriesStateProvider.getInstance().updateQueriesEnablementState(action.isChecked());
    Object input = view.getCurrentViewer().getInput();
    view.setInputOnViewers(input);
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// nothing to do
	}

	@Override
	public void init(IViewPart view) {
		this.view = (ISemanticBrowserViewPart) view;
	}
}
