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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.polarsys.kitalpha.emde.extension.ExtensionModelManager;
import org.polarsys.kitalpha.emde.extension.ModelExtensionHelper;

import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsFactory;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

/**
 * This is the item provider adapter for a {@link org.polarsys.kitalpha.vp.requirements.Requirements.Requirement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementItemProvider extends AttributeOwnerItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IItemPropertyDescriptor requirementTypePropertyDescriptor;

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementItemProvider(AdapterFactory adapterFactory) {
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
			// Process RequirementsPackage.Literals.REQUIREMENT__REQUIREMENT_TYPE
			if (requirementTypePropertyDescriptor != null) {
				Object requirementTypeValue = eObject.eGet(RequirementsPackage.Literals.REQUIREMENT__REQUIREMENT_TYPE,
						true);
				if (requirementTypeValue != null && requirementTypeValue instanceof EObject && ModelExtensionHelper
						.getInstance(eObject).isExtensionModelDisabled((EObject) requirementTypeValue)) {
					itemPropertyDescriptors.remove(requirementTypePropertyDescriptor);
				} else if (requirementTypeValue == null && ExtensionModelManager.getAnyType(eObject,
						RequirementsPackage.Literals.REQUIREMENT__REQUIREMENT_TYPE) != null) {
					itemPropertyDescriptors.remove(requirementTypePropertyDescriptor);
				} else if (itemPropertyDescriptors.contains(requirementTypePropertyDescriptor) == false) {
					itemPropertyDescriptors.add(requirementTypePropertyDescriptor);
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

			addReqIFNamePropertyDescriptor(object);
			addReqIFPrefixPropertyDescriptor(object);
			addRequirementTypePropertyDescriptor(object);
			addReqIFChapterNamePropertyDescriptor(object);
			addReqIFForeignIDPropertyDescriptor(object);
			addReqIFTextPropertyDescriptor(object);
			addRequirementTypeProxyPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Req IF Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReqIFNamePropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add(createItemPropertyDescriptor
		// end-extension-code
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_SharedDirectAttributes_ReqIFName_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_SharedDirectAttributes_ReqIFName_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_SharedDirectAttributes_type"), //$NON-NLS-1$
				RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_NAME, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				// begin-extension-code
				null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Req IF Prefix feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReqIFPrefixPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add(createItemPropertyDescriptor
		// end-extension-code
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_SharedDirectAttributes_ReqIFPrefix_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_SharedDirectAttributes_ReqIFPrefix_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_SharedDirectAttributes_type"), //$NON-NLS-1$
				RequirementsPackage.Literals.SHARED_DIRECT_ATTRIBUTES__REQ_IF_PREFIX, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				// begin-extension-code
				null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Requirement Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequirementTypePropertyDescriptor(Object object) {
		// begin-extension-code
		requirementTypePropertyDescriptor = createItemPropertyDescriptor
		// end-extension-code		
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Requirement_requirementType_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Requirement_requirementType_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_Requirement_type"), //$NON-NLS-1$
				RequirementsPackage.Literals.REQUIREMENT__REQUIREMENT_TYPE, true, false, true, null, null,
				// begin-extension-code
				null);
		itemPropertyDescriptors.add(requirementTypePropertyDescriptor);
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Req IF Chapter Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReqIFChapterNamePropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add(createItemPropertyDescriptor
		// end-extension-code
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Requirement_ReqIFChapterName_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Requirement_ReqIFChapterName_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_Requirement_type"), //$NON-NLS-1$
				RequirementsPackage.Literals.REQUIREMENT__REQ_IF_CHAPTER_NAME, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				// begin-extension-code
				null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Req IF Foreign ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReqIFForeignIDPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add(createItemPropertyDescriptor
		// end-extension-code
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Requirement_ReqIFForeignID_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Requirement_ReqIFForeignID_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_Requirement_type"), //$NON-NLS-1$
				RequirementsPackage.Literals.REQUIREMENT__REQ_IF_FOREIGN_ID, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				// begin-extension-code
				null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Req IF Text feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReqIFTextPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add(createItemPropertyDescriptor
		// end-extension-code
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Requirement_ReqIFText_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Requirement_ReqIFText_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_Requirement_type"), //$NON-NLS-1$
				RequirementsPackage.Literals.REQUIREMENT__REQ_IF_TEXT, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				// begin-extension-code
				null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Requirement Type Proxy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequirementTypeProxyPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add(createItemPropertyDescriptor
		// end-extension-code
		(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_Requirement_requirementTypeProxy_feature"), //$NON-NLS-1$
				getString("_UI_PropertyDescriptor_description", "_UI_Requirement_requirementTypeProxy_feature", //$NON-NLS-1$//$NON-NLS-2$
						"_UI_Requirement_type"), //$NON-NLS-1$
				RequirementsPackage.Literals.REQUIREMENT__REQUIREMENT_TYPE_PROXY, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
				// begin-extension-code
				null));
		// end-extension-code
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(RequirementsPackage.Literals.REQUIREMENT__OWNED_RELATIONS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns Requirement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Requirement")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {

		String label = ((Requirement) object).getId();
		// begin-extension-code
		return label == null || label.length() == 0 ? "[" + getString("_UI_Requirement_type") + "]" : label; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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

		switch (notification.getFeatureID(Requirement.class)) {
		case RequirementsPackage.REQUIREMENT__REQ_IF_NAME:
		case RequirementsPackage.REQUIREMENT__REQ_IF_PREFIX:
		case RequirementsPackage.REQUIREMENT__REQ_IF_CHAPTER_NAME:
		case RequirementsPackage.REQUIREMENT__REQ_IF_FOREIGN_ID:
		case RequirementsPackage.REQUIREMENT__REQ_IF_TEXT:
		case RequirementsPackage.REQUIREMENT__REQUIREMENT_TYPE_PROXY:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		case RequirementsPackage.REQUIREMENT__OWNED_RELATIONS:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

		newChildDescriptors.add(createChildParameter(RequirementsPackage.Literals.REQUIREMENT__OWNED_RELATIONS,
				RequirementsFactory.eINSTANCE.createInternalRelation()));

	}

}