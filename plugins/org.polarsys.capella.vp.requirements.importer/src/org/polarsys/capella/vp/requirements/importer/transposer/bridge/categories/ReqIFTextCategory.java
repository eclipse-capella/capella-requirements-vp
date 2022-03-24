/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.importer.transposer.bridge.categories;

import org.eclipse.emf.diffmerge.diffdata.EAttributeValuePresence;
import org.eclipse.emf.diffmerge.diffdata.EMatch;
import org.eclipse.emf.diffmerge.generic.api.diff.IDifference;
import org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode;
import org.eclipse.emf.diffmerge.ui.viewers.IDifferenceCategory;
import org.eclipse.emf.diffmerge.ui.viewers.categories.AbstractDifferenceCategory;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.provider.RequirementsEditPlugin;

public class ReqIFTextCategory extends AbstractDifferenceCategory {

  /** ID of this category */
  public static final String ID = "ReqVP.Text"; //$NON-NLS-1$
  
  protected static final String REQUIREMENT_ICON_PATH = "full/obj16/Requirement.gif"; //$NON-NLS-1$

  public ReqIFTextCategory() {
    super();
    setActive(false);
    setInFocusMode(false);
    setVisible(true);
    setModifiable(true);
  }

  /**
   * @see org.eclipse.emf.diffmerge.ui.viewers.IDifferenceCategory#covers(org.eclipse.emf.diffmerge.api.diff.IDifference,
   *      org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode)
   */
  public boolean covers(IDifference<?> difference_p, EMFDiffNode node_p) {
    boolean result = false;
    if (difference_p instanceof EAttributeValuePresence) {
      EAttributeValuePresence vp = (EAttributeValuePresence) difference_p;
      if (vp.getFeature() == RequirementsPackage.Literals.REQUIREMENT__REQ_IF_TEXT) {
        if (vp.eContainer() instanceof EMatch && ((EMatch) vp.eContainer()).getTarget() instanceof Requirement) {
          return true;
        }
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.emf.diffmerge.ui.viewers.IDifferenceCategoryItem#getDescription(org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode)
   */
  @Override
  public String getDescription(EMFDiffNode node_p) {
    return Messages.Category_ReqIFText_Description;
  }

  /**
   * @see org.eclipse.emf.diffmerge.ui.viewers.IDifferenceCategory#getID()
   */
  @Override
  public String getID() {
    return ID;
  }

  /**
   * @see org.eclipse.emf.diffmerge.ui.viewers.categories.AbstractDifferenceCategoryItem#getImage(org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode)
   */
  @Override
  public Image getImage(EMFDiffNode node_p) {
    return ExtendedImageRegistry.getInstance()
        .getImage(RequirementsEditPlugin.getPlugin().getImage(REQUIREMENT_ICON_PATH)); // $NON-NLS-1$
  }

  /**
   * @see org.eclipse.emf.diffmerge.ui.viewers.IDifferenceCategory#getText(org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode)
   */
  @Override
  public String getText(EMFDiffNode node_p) {
    return Messages.Categories_ReqIFText_Identifier;
  }

  /**
   * @see org.eclipse.emf.diffmerge.ui.viewers.IDifferenceCategory#copy()
   */
  @Override
  public IDifferenceCategory copy() {
      ReqIFTextCategory copied = new ReqIFTextCategory();
      copied.copyState(this);
      return copied;
  }

}