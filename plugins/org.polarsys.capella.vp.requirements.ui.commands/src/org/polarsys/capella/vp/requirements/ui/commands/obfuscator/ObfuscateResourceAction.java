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

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.polarsys.capella.vp.requirements.reqif.resource.obfuscator.ResourceObfuscatorHelper;
import org.polarsys.capella.vp.requirements.ui.commands.RequirementsVPUICommandsPlugin;

/**
 * Obfuscate end-user selected resources.
 *
 * @author Joao Barata
 */
public class ObfuscateResourceAction extends BaseSelectionListenerAction {

  /**
   * Obfuscation model image id.
   */
  public static final String IMG_OBFUSCATE_MODEL = "binary.gif"; //$NON-NLS-1$

  /**
   * Constructor.
   */
  public ObfuscateResourceAction() {
    super(Messages.ObfuscateResourceAction_Title);
    setImageDescriptor(RequirementsVPUICommandsPlugin.getDefault().getImageDescriptor(IMG_OBFUSCATE_MODEL));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void run() {
    if (!MessageDialog.openConfirm(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
    	Messages.ObfuscateResourceAction_ConfirmationDialog_Title,
        Messages.ObfuscateResourceAction_ConfirmationDialog_Message))
    {
      return;
    }

    for (Object selection : getStructuredSelection().toList()) {
      if (selection instanceof IFile) {
    	  ResourceObfuscatorHelper.obfuscateResource((IFile) selection);
      }
    }
  }
}
