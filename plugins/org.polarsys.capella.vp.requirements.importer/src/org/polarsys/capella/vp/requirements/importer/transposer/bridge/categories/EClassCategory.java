/*******************************************************************************
 * Copyright (c) 2016, 2019, 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.importer.transposer.bridge.categories;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.diffmerge.diffdata.EElementPresence;
import org.eclipse.emf.diffmerge.generic.api.Role;
import org.eclipse.emf.diffmerge.generic.api.diff.IDifference;
import org.eclipse.emf.diffmerge.ui.viewers.EMFDiffNode;
import org.eclipse.emf.diffmerge.ui.viewers.categories.AbstractDifferenceCategory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.polarsys.capella.common.ef.ExecutionManagerRegistry;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.core.model.handler.helpers.HoldingResourceHelper;
import org.polarsys.capella.vp.requirements.importer.transposer.bridge.Messages;

public class EClassCategory extends AbstractDifferenceCategory {

  Collection<EClass> clazzes;
  EClass iconClazz;
  String name;
  String description;

  public boolean keepElement(Object element) {
    for (EClass clazz : clazzes) {
      if (clazz.isInstance(element)) {
        return true;
      }
    }
    return false;
  }

  public EClassCategory(EClass iconClazz, String name, EClass clazz) {
    this(iconClazz, name, Collections.singletonList(clazz));
  }

  public EClassCategory(EClass iconClazz, String name, Collection<EClass> clazzes) {
    setInFocusMode(false);
    this.clazzes = clazzes;
    this.iconClazz = iconClazz;
    this.name = NLS.bind(Messages.CategoryFormat_Name, name);
    this.description = NLS.bind(Messages.CategoryFormat_Description, name);
  }

  public EClassCategory(EClass iconClazz, String name, EClass... clazzes) {
    this(iconClazz, name, Arrays.asList(clazzes));
  }

  @Override
  public boolean covers(IDifference<?> difference, EMFDiffNode node) {
    if (difference instanceof EElementPresence) {
      EObject source = ((EElementPresence) difference).getElementMatch().get(Role.REFERENCE);
      EObject target = ((EElementPresence) difference).getElementMatch().get(Role.TARGET);
      for (EClass clazz : clazzes) {
        if (clazz.isInstance(source) || clazz.isInstance(target)) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public String getID() {
    String result = ""; //$NON-NLS-1$
    for (EClass clazz : clazzes) {
      result += clazz.getName() + "; "; //$NON-NLS-1$
    }
    return result;
  }

  @Override
  public String getDescription(EMFDiffNode node) {
    return description;
  }

  @Override
  public String getText(EMFDiffNode node) {
    return name;
  }

  @Override
  public Image getImage(final EMFDiffNode node) {
    final Image[] image = new Image[1];

    if (iconClazz != null && !iconClazz.isAbstract()) {
      TransactionalEditingDomain domain = (TransactionalEditingDomain) node.getEditingDomain();
      ExecutionManagerRegistry.getInstance().getExecutionManager(domain).execute(new AbstractReadWriteCommand() {
        @Override
        public void run() {
          Resource res = HoldingResourceHelper.getHoldingResource((TransactionalEditingDomain) node.getEditingDomain());
          EObject obj = ((EPackage) iconClazz.eContainer()).getEFactoryInstance().create(iconClazz);
          res.getContents().add(obj);
          Object imagePointer = EObjectLabelProviderHelper.getImage(obj);
          image[0] = ExtendedImageRegistry.getInstance().getImage(imagePointer);
        }
      });
    }
    return image[0];
  }

}
