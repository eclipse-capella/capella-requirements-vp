/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ui.commands.obfuscator;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;

/**
 * Add Obfuscation actions.
 *
 * @author Joao Barata
 */
public class ObfuscatorActionProvider extends CommonActionProvider {
  /**
   * Obfuscate a model action.
   */
  private ObfuscateResourceAction obfuscateModelAction;

  /**
   * @see org.eclipse.ui.actions.ActionGroup#dispose()
   */
  @Override
  public void dispose() {   
    ISelectionProvider selectionProvider = getActionSite().getViewSite().getSelectionProvider();
    if (null != obfuscateModelAction) {
      selectionProvider.removeSelectionChangedListener(obfuscateModelAction);
      obfuscateModelAction = null;
    }
    super.dispose();
  }

  /**
   * @see org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars)
   */
  @Override
  public void fillActionBars(IActionBars actionBars) {
    // Do nothing.
  }

  /**
   * @see org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.action.IMenuManager)
   */
  @Override
  public void fillContextMenu(IMenuManager menu) {
    updateActionBars();
    menu.appendToGroup(ICommonMenuConstants.GROUP_GENERATE, obfuscateModelAction);
  }

  /**
   * @see org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.ICommonActionExtensionSite)
   */
  @Override
  public void init(ICommonActionExtensionSite site) {
    super.init(site);
    ISelectionProvider selectionProvider = site.getViewSite().getSelectionProvider();
    obfuscateModelAction = new ObfuscateResourceAction();
    registerToSelectionChanges(obfuscateModelAction, selectionProvider);
  }

  /**
   * Register given action to the selection changes emitted by given selection provider.
   * @param action
   * @param selectionProvider
   */
  protected void registerToSelectionChanges(ISelectionChangedListener action, ISelectionProvider selectionProvider) {
    // Listen selection changes.
    selectionProvider.addSelectionChangedListener(action);
    // Set the current selection otherwise at first run, selection is lost.
    ISelection selection = selectionProvider.getSelection();
    if (!selection.isEmpty()) {
      action.selectionChanged(new SelectionChangedEvent(selectionProvider, selection));
    }
  }
}
