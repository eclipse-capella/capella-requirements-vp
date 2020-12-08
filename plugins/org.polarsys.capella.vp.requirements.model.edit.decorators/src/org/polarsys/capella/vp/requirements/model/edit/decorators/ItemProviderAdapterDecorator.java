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
package org.polarsys.capella.vp.requirements.model.edit.decorators;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

/**
 * @author Joao Barata
 */
public class ItemProviderAdapterDecorator extends ItemProviderDecorator implements Adapter.Internal {

  private List<Notifier> targets;

  public ItemProviderAdapterDecorator(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getRootAdapterFactory()
   */
  protected AdapterFactory getRootAdapterFactory() {
    if (adapterFactory instanceof ComposeableAdapterFactory) {
      return ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory();
    }

    return adapterFactory;
  }

  /**
   * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#overlayImage(Object,
   *      Object)
   */
  protected Object overlayImage(Object object, Object image) {
    if (AdapterFactoryEditingDomain.isControlled(object)) {
      List<Object> images = new ArrayList<Object>(2);
      images.add(image);
      images.add(EMFEditPlugin.INSTANCE.getImage("full/ovr16/ControlledObject"));
      image = new ComposedImage(images);
    }
    return image;
  }

  /**
   * @see org.eclipse.emf.common.notify.Adapter#getTarget()
   */
  public Notifier getTarget() {
    if (targets == null || targets.isEmpty()) {
      return null;
    }
    return targets.get(targets.size() - 1);
  }

  /**
   * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
   */
  public void setTarget(Notifier newTarget) {
    if (targets == null) {
      targets = new ArrayList<Notifier>();
    }
    targets.add(newTarget);
  }

  /**
   * @see org.eclipse.emf.common.notify.Adapter.Internal#unsetTarget(org.eclipse.emf.common.notify.Notifier)
   */
  public void unsetTarget(Notifier oldTarget) {
    if (targets != null) {
      targets.remove(oldTarget);
    }
  }
}
