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
package org.polarsys.capella.vp.requirements.semantic.browser.queries;

/**
 * FIXME This class should be a service provided by the semantic browser
 * FIXME Currently the semantic browser only handles a static set of elements allowed to be shown/hidden
 *
 * @author Joao Barata
 */
public class QueriesStateProvider {

  private static QueriesStateProvider instance;
  private boolean enableQueries = false;
  
  private QueriesStateProvider() {
    //
  }
  
  public static QueriesStateProvider getInstance() {
    if (instance == null) {
      instance = new QueriesStateProvider();
    }
    return instance;
  }
  
  public boolean areQueriesEnabled() {
    return enableQueries;
  }

  public void updateQueriesEnablementState(boolean enable) {
    enableQueries = enable;
  }
}
