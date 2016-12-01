/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.bridge.rules;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IQuery;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.Rule;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.ReqIFMapping;

public abstract class AbstractRule<A, B> extends  Rule<A, B> {

  ReqIFMapping mapping;
  
  public ReqIFMapping getMapping() {
    return mapping;
  }

  public AbstractRule(ReqIFMapping mapping, IQuery<?, ? extends A> provider, String id) {
    super(provider, id);
    this.mapping=mapping;
  }
  
}
