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

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.PartSite;
import org.eclipse.ui.navigator.CommonNavigator;
import org.polarsys.capella.common.ui.toolkit.browser.view.ISemanticBrowserViewPart;
import org.polarsys.capella.core.platform.sirius.ui.navigator.view.CapellaCommonNavigator;
import org.polarsys.capella.core.platform.sirius.ui.navigator.viewer.CapellaNavigatorLabelProvider;
import org.polarsys.capella.core.ui.semantic.browser.view.SemanticBrowserView;

public class TableviewUIExtender {

  /**
   * Default constructor
   */
  public TableviewUIExtender(final Menu menu, final Table table) {
    createNavigationItems(menu, table);
  }

  /**
   * Returns the StructuredSelection to be used to focus in Semantic Browser or Capella Explorer from the input
   * TableItem[] selection
   * 
   * @param inSelection
   * @return
   */
  public StructuredSelection getSelectedFromSelection(TableItem[] inSelection) {
    if (inSelection != null && inSelection.length > 0) {
      return new StructuredSelection(inSelection[0].getData());
    }
    return null;
  }

  private void createNavigationItems(final Menu menu, final Table table) {
    createShowInExplorerItem(menu, table);
    createShowInSemanticBrowserItem(menu, table);
    createDisplayInStatusBar(table);
  }

  private void createDisplayInStatusBar(final Table table) {
    table.addListener(SWT.MouseExit, new Listener() {
      public void handleEvent(Event e) {
        displayInStatusBar(null);
      }
    });

    table.addListener(SWT.MouseDown, new Listener() {
      public void handleEvent(Event e) {
        StructuredSelection structuredSelection = getSelectedFromSelection(table.getSelection());
        if (structuredSelection != null) {
          displayInStatusBar(structuredSelection);
        }
      }
    });

    table.addListener(SWT.MouseEnter, new Listener() {
      public void handleEvent(Event e) {
        StructuredSelection structuredSelection = getSelectedFromSelection(table.getSelection());
        if (structuredSelection != null) {
          displayInStatusBar(structuredSelection);
        }
      }
    });
  }

  protected void displayInStatusBar(StructuredSelection structuredSelection) {
    Image elementImage = null;
    String elementDescription = null;
    if (structuredSelection != null) {
      CapellaNavigatorLabelProvider capellaNavigatorLabelProvider = new CapellaNavigatorLabelProvider();
      elementImage = capellaNavigatorLabelProvider.getImage(structuredSelection.getFirstElement());
      elementDescription = capellaNavigatorLabelProvider.getDescription(structuredSelection.getFirstElement());
    }

    IStatusLineManager currentStatusLineManager = getCurrentStatusLineManager();
    if (currentStatusLineManager != null) {
      currentStatusLineManager.setMessage(elementImage, elementDescription);
    }
  }

  private IStatusLineManager getCurrentStatusLineManager() {
    IWorkbenchPartSite currentSite = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
        .getActivePart().getSite();

    if (currentSite instanceof IViewSite) {
      return ((IViewSite) currentSite).getActionBars().getStatusLineManager();
    } else if (currentSite instanceof PartSite) {
      return ((PartSite) currentSite).getActionBars().getStatusLineManager();
    } else if (currentSite instanceof IEditorSite) {
      return ((IEditorSite) currentSite).getActionBars().getStatusLineManager();
    }
    return null;
  }

  /**
   * Create the "Show in Capella Explorer" menu item
   * 
   * @param menu
   *          a non-null menu
   * @param viewer
   *          a non-null viewer
   */
  protected void createShowInExplorerItem(final Menu menu, final Table table) {
    final MenuItem showInExp = new MenuItem(menu, SWT.NONE);
    showInExp.setText("Select in Capella Explorer");
    showInExp.setAccelerator(SWT.F8);
    CommonNavigator exp = getCapellaAdvanceExplorer(false);
    if (exp != null)
      showInExp.setImage(exp.getTitleImage());
    showInExp.setEnabled(true);
    // Enabled state

    /* Menu displayed */
    table.addListener(SWT.MouseDown, new Listener() {
      @Override
      public void handleEvent(Event event) {
        TableItem[] selection = table.getSelection();
        if (selection != null && (event.button == 3)) {
          boolean enable = selection.length == 1;
          if (enable) {
            Object first = selection[0];
            enable = first instanceof TableItem;

          }
          showInExp.setEnabled(enable);
        }
      }
    });

    /* F8 */
    table.addListener(SWT.KeyUp, new Listener() {
      @Override
      public void handleEvent(Event event) {
        StructuredSelection structuredSelection = getSelectedFromSelection(table.getSelection());
        if (structuredSelection != null && (event.keyCode == SWT.F8)) {
          CommonNavigator innerExp = getCapellaAdvanceExplorer(true);
          if (innerExp != null) {
            innerExp.selectReveal(structuredSelection);
          }
        }
      }
    });

    // Execution
    showInExp.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        StructuredSelection structuredSelection = getSelectedFromSelection(table.getSelection());
        if (structuredSelection != null) {
          CommonNavigator innerExp = getCapellaAdvanceExplorer(true);
          if (innerExp != null) {
            if (showInExp.getImage() == null) {
              showInExp.setImage(innerExp.getTitleImage());
            }
            innerExp.selectReveal(structuredSelection);
          }
        }
      }
    });
  }

  /**
   * Create the "Show in Semantic Browser" menu item
   * 
   * @param menu
   *          a non-null menu
   * @param viewer
   *          a non-null viewer
   */
  protected void createShowInSemanticBrowserItem(final Menu menu, final Table table) {
    final MenuItem showInSB = new MenuItem(menu, SWT.NONE);
    showInSB.setText("Show in Semantic Browser");
    showInSB.setAccelerator(SWT.F9);
    ISemanticBrowserViewPart sb = getSemanticBrowser(false);
    if (sb != null)
      showInSB.setImage(sb.getTitleImage());
    showInSB.setEnabled(true);
    // Enabled state

    /* Menu displayed */
    table.addListener(SWT.MouseDown, new Listener() {
      @Override
      public void handleEvent(Event event) {
        TableItem[] selection = table.getSelection();
        if (selection != null && (event.button == 3)) {
          boolean enable = selection.length == 1;
          if (enable) {
            Object first = selection[0];
            enable = first instanceof TableItem;

          }
          showInSB.setEnabled(enable);
        }
      }
    });

    /* F9 */
    table.addListener(SWT.KeyUp, new Listener() {
      @Override
      public void handleEvent(Event event) {
        StructuredSelection structuredSelection = getSelectedFromSelection(table.getSelection());
        if (structuredSelection != null && (event.keyCode == SWT.F9)) {
          ISemanticBrowserViewPart innerSb = getSemanticBrowser(true);
          if (innerSb != null) {
            innerSb.setInput(structuredSelection.getFirstElement());
          }
        }
      }
    });

    // Execution
    showInSB.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e) {
        StructuredSelection structuredSelection = getSelectedFromSelection(table.getSelection());
        if (structuredSelection != null) {
          ISemanticBrowserViewPart innerSb = getSemanticBrowser(true);
          if (innerSb != null) {
            if (showInSB.getImage() == null) {
              showInSB.setImage(innerSb.getTitleImage());
            }
            innerSb.setInput(structuredSelection.getFirstElement());
          }
        }
      }
    });
  }

  /**
   * Return the Capella Project Explorer view if possible
   * 
   * @param forceShow
   *          whether the view must be shown if it is hidden
   * @return a potentially null object
   */
  protected CommonNavigator getCapellaAdvanceExplorer(boolean forceShow) {
    CommonNavigator result = null;
    final String viewID = CapellaCommonNavigator.ID;
    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    IViewPart view = null;
    if (forceShow) {
      try {
        view = page.showView(viewID);
      } catch (PartInitException e) {
        // Proceed
      }
    } else {
      view = page.findView(viewID);
    }
    if (view instanceof CommonNavigator)
      result = (CommonNavigator) view;
    return result;
  }

  /**
   * Return the Semantic Browser view if possible
   * 
   * @param forceShow
   *          whether the view must be shown if it is hidden
   * @return a potentially null object
   */
  protected ISemanticBrowserViewPart getSemanticBrowser(boolean forceShow) {
    ISemanticBrowserViewPart result = null;
    final String viewID = SemanticBrowserView.SEMANTIC_BROWSER_ID;
    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    IViewPart view = null;
    if (forceShow) {
      try {
        view = page.showView(viewID);
      } catch (PartInitException e) {
        // Proceed
      }
    } else {
      view = page.findView(viewID);
    }
    if (view instanceof ISemanticBrowserViewPart)
      result = (ISemanticBrowserViewPart) view;
    return result;
  }

}
