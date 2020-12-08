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

package org.polarsys.capella.vp.requirements.CapellaRequirements.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;

import org.polarsys.kitalpha.emde.extension.ExtensionModelManager;
import org.polarsys.kitalpha.emde.extension.ModelExtensionHelper;

/**
 * This is the item provider adapter for a {@link org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CapellaIncomingRelationItemProvider extends CapellaRelationItemProvider
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IItemPropertyDescriptor sourcePropertyDescriptor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IItemPropertyDescriptor targetPropertyDescriptor;

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapellaIncomingRelationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void checkChildCreationExtender(Object object) {
		super.checkChildCreationExtender(object);
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			// Process CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE
			if (sourcePropertyDescriptor != null) {
				Object sourceValue = eObject.eGet(CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE,
						true);
				if (sourceValue != null && sourceValue instanceof EObject
						&& ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) sourceValue)) {
					itemPropertyDescriptors.remove(sourcePropertyDescriptor);
				} else if (sourceValue == null && ExtensionModelManager.getAnyType(eObject,
						CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE) != null) {
					itemPropertyDescriptors.remove(sourcePropertyDescriptor);
				} else if (itemPropertyDescriptors.contains(sourcePropertyDescriptor) == false) {
					itemPropertyDescriptors.add(sourcePropertyDescriptor);
				}
			}
			// Process CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET
			if (targetPropertyDescriptor != null) {
				Object targetValue = eObject.eGet(CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET,
						true);
				if (targetValue != null && targetValue instanceof EObject
						&& ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) targetValue)) {
					itemPropertyDescriptors.remove(targetPropertyDescriptor);
				} else if (targetValue == null && ExtensionModelManager.getAnyType(eObject,
						CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET) != null) {
					itemPropertyDescriptors.remove(targetPropertyDescriptor);
				} else if (itemPropertyDescriptors.contains(targetPropertyDescriptor) == false) {
					itemPropertyDescriptors.add(targetPropertyDescriptor);
				}
			}
		}
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

			addSourcePropertyDescriptor(object);
			addTargetPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Source feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSourcePropertyDescriptor(Object object) {
		// begin-extension-code
		sourcePropertyDescriptor = createItemPropertyDescriptor
		// end-extension-code		
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_CapellaIncomingRelation_source_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_CapellaIncomingRelation_source_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_CapellaIncomingRelation_type"), //$NON-NLS-1$
				CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE, true, false, true, null, null,
				// begin-extension-code
				null);
		itemPropertyDescriptors.add(sourcePropertyDescriptor);
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Target feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetPropertyDescriptor(Object object) {
		// begin-extension-code
		targetPropertyDescriptor = createItemPropertyDescriptor
		// end-extension-code		
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_CapellaIncomingRelation_target_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_CapellaIncomingRelation_target_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_CapellaIncomingRelation_type"), //$NON-NLS-1$
				CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET, true, false, true, null, null,
				// begin-extension-code
				null);
		itemPropertyDescriptors.add(targetPropertyDescriptor);
		// end-extension-code
	}

	/**
	 * This returns CapellaIncomingRelation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CapellaIncomingRelation")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {

		String label = ((CapellaIncomingRelation) object).getId();
		// begin-extension-code
		return label == null || label.length() == 0 ? "[" + getString("_UI_CapellaIncomingRelation_type") + "]" : label; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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