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
package org.polarsys.capella.vp.requirements.semantic.browser.queries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.polarsys.capella.vp.requirements.model.helpers.RelationAnnotationHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;

public class RelationTypedRepresentationQuery extends AbstractViewpointQuery {

  public List<Object> computeQuery(Object object) {
    List<Object> result = new ArrayList<>();
    RelationType type = (RelationType) object;

    for (DAnnotation annotation : RelationAnnotationHelper.getTypedAnnotations(type)) {
      result.add(RelationAnnotationHelper.getDescriptor(annotation));
    }
    return result;
  }
}
