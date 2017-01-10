/*******************************************************************************
 * Copyright (c) 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.properties.widgets;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * This class is a Composite that will return a fixed size on a call to computeSize(int, int, boolean).<br>
 * 
 * It can be used as children of a ScrolledComposite when we do not want to display/use scroll bars of this
 * ScrolledComposite (because children of this Composite have already their own scroll bars).<br>
 *
 * The preferredSize (<=> computedSize) is used by the parent ScrolledComposite to know if it has to display its scroll
 * bars (see for example org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage.resizeScrolledComposite()).<br>
 * => Return a small preferred size so ScrollBars will not be displayed.
 */
public class FixedPreferredSizeComposite extends Composite {
  protected Point preferredSize = new Point(0, 0);
  
  public FixedPreferredSizeComposite (Composite parent, int style) {
    super (parent, style);
    GridLayout gridLayout = new GridLayout(1, false);
    gridLayout.marginWidth = 0;
    gridLayout.marginHeight = 0;
    setLayout(gridLayout);
  }
  
  @Override
  public Point computeSize(int wHint, int hHint, boolean changed) {
    return preferredSize;
  }
  
  public void setPreferredSize(Point preferredSize) {
    this.preferredSize = preferredSize;
  }
}
