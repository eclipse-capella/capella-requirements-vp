package org.polarsys.capella.vp.requirements.CapellaRequirements.provider.sections;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.core.properties.sections.NamedElementSection;
import org.polarsys.capella.core.model.handler.helpers.CapellaAdapterHelper;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;

/**
 * This is the item provider adapter for a {@link CapellaOutgoingRelationSection} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CapellaOutgoingRelationSection extends NamedElementSection {
	/**
	 * @generated
	 */
	@Override
	public boolean select(Object toTest) {
		EObject obj = CapellaAdapterHelper.resolveSemanticObject(toTest);

		return obj != null && obj.eClass()
				.equals(org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage.eINSTANCE
						.getCapellaOutgoingRelation());
	}
}
