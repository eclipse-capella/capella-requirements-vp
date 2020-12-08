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
package org.polarsys.capella.vp.requirements.ui.importer.preferences.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Layout;

public class SWTUtil {

  public static Group createGroup(Composite container, String text, Layout layout, Object layoutData) {
    Group grp = new Group(container, SWT.NONE);
    grp.setText(text);
    grp.setLayoutData(layoutData);
    grp.setLayout(layout);
    return grp;
  }
  
  public static Button createButton(Composite container, int style, String text, Object layoutData) {
    Button btn = new Button(container, style);
    btn.setText(text);
    btn.setLayoutData(layoutData);
    return btn;
  }
}
