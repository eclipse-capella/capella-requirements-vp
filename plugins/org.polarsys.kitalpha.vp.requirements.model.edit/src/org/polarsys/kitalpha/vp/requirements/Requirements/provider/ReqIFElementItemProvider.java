/**
 *
 *  Copyright (c) 2016, 2019 THALES GLOBAL SERVICES.
 *  
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *     Thales - initial API and implementation
 */

package org.polarsys.kitalpha.vp.requirements.Requirements.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * This is the item provider adapter for a {@link org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReqIFElementItemProvider extends IdentifiableElementItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReqIFElementItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addReqIFIdentifierPropertyDescriptor(object);
			addReqIFDescriptionPropertyDescriptor(object);
			addReqIFLongNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Req IF Identifier feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReqIFIdentifierPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add(createItemPropertyDescriptor
		// end-extension-code
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ReqIFElement_ReqIFIdentifier_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_ReqIFElement_ReqIFIdentifier_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_ReqIFElement_type"), //$NON-NLS-1$
				RequirementsPackage.Literals.REQ_IF_ELEMENT__REQ_IF_IDENTIFIER, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				// begin-extension-code
				null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Req IF Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReqIFDescriptionPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add(createItemPropertyDescriptor
		// end-extension-code
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ReqIFElement_ReqIFDescription_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_ReqIFElement_ReqIFDescription_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_ReqIFElement_type"), //$NON-NLS-1$
				RequirementsPackage.Literals.REQ_IF_ELEMENT__REQ_IF_DESCRIPTION, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				// begin-extension-code
				null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Req IF Long Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReqIFLongNamePropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add(createItemPropertyDescriptor
		// end-extension-code
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ReqIFElement_ReqIFLongName_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_ReqIFElement_ReqIFLongName_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_ReqIFElement_type"), //$NON-NLS-1$
				RequirementsPackage.Literals.REQ_IF_ELEMENT__REQ_IF_LONG_NAME, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				// begin-extension-code
				null));
		// end-extension-code
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {

		String label = ((ReqIFElement) object).getId();
		// begin-extension-code
		return label == null || label.length() == 0 ? "[" + getString("_UI_ReqIFElement_type") + "]" : label; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		// end-extension-code
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ReqIFElement.class)) {
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_IDENTIFIER:
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_DESCRIPTION:
		case RequirementsPackage.REQ_IF_ELEMENT__REQ_IF_LONG_NAME:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}