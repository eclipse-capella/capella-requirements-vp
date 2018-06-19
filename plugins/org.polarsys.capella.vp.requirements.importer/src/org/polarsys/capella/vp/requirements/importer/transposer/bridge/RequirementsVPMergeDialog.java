/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.bridge;

import org.eclipse.emf.diffmerge.bridge.interactive.UpdateDialog;
import org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * This dialog is displayed when user chooses to import a ReqIF model.
 * It overrides the UpdateDialog in order to remove the two buttons
 * "Open In Editor" and "Defer" because they do not work properly.
 * @author S0070513
 *
 */
public class RequirementsVPMergeDialog extends UpdateDialog {

  public RequirementsVPMergeDialog(Shell shell_p, String title_p, EMFDiffNode input_p) {
    super(shell_p, title_p, input_p);
  }

  @Override
  protected void createButtonsForButtonBar(Composite parent_p) {
    boolean editable = isEditable();
    if (editable)
      createOKButton(parent_p);
    createButton(parent_p, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, !editable);
  }
}
