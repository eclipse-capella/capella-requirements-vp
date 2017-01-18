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
package org.polarsys.capella.vp.requirements.business.queries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.polarsys.capella.common.helpers.EcoreUtil2;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.data.cs.BlockArchitecture;
import org.polarsys.capella.core.data.ctx.CtxPackage;
import org.polarsys.capella.core.data.ctx.SystemAnalysis;
import org.polarsys.capella.core.data.epbs.EPBSArchitecture;
import org.polarsys.capella.core.data.epbs.EpbsPackage;
import org.polarsys.capella.core.data.la.LaPackage;
import org.polarsys.capella.core.data.la.LogicalArchitecture;
import org.polarsys.capella.core.data.oa.OaPackage;
import org.polarsys.capella.core.data.oa.OperationalAnalysis;
import org.polarsys.capella.core.data.pa.PaPackage;
import org.polarsys.capella.core.data.pa.PhysicalArchitecture;
import org.polarsys.capella.core.model.utils.ListExt;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public class AbstractRelation_RelationType implements IBusinessQuery {

  /**
   * @see org.polarsys.capella.core.business.queries.ui.business.queries.IBusinessQuery#getAvailableElements(EObject)
   */
  @Override
  public List<EObject> getAvailableElements(EObject element) {
    List<EObject> availableElements = new ArrayList<EObject>();

    EObject referencedElement = null;
    if (element instanceof CapellaIncomingRelation)
      referencedElement = ((CapellaIncomingRelation) element).getSource();
    else if (element instanceof CapellaOutgoingRelation)
      referencedElement = ((CapellaOutgoingRelation) element).getSource();
    else if (element instanceof InternalRelation)
      referencedElement = ((InternalRelation) element).getSource();

    if (referencedElement != null) {
      if ((referencedElement instanceof OperationalAnalysis)
          || EcoreUtil2.isContainedBy(referencedElement, OaPackage.Literals.OPERATIONAL_ANALYSIS)) {
        OperationalAnalysis oa = (OperationalAnalysis) ((referencedElement instanceof OperationalAnalysis) ? referencedElement
            : EcoreUtil2.getFirstContainer(referencedElement, OaPackage.Literals.OPERATIONAL_ANALYSIS));
        if (oa != null) {
          availableElements.addAll(getRelationTypes(oa));
        }
      } else if ((referencedElement instanceof SystemAnalysis)
          || EcoreUtil2.isContainedBy(referencedElement, CtxPackage.Literals.SYSTEM_ANALYSIS)) {
        SystemAnalysis ca = (SystemAnalysis) ((referencedElement instanceof SystemAnalysis) ? referencedElement
            : EcoreUtil2.getFirstContainer(referencedElement, CtxPackage.Literals.SYSTEM_ANALYSIS));
        if (ca != null) {
          availableElements.addAll(getRelationTypes(ca));
          for (BlockArchitecture ba : ca.getAllocatedArchitectures()) {
            OperationalAnalysis oa = (OperationalAnalysis) ba;
            availableElements.addAll(getRelationTypes(oa));
          }
        }
      } else if ((referencedElement instanceof LogicalArchitecture)
          || EcoreUtil2.isContainedBy(referencedElement, LaPackage.Literals.LOGICAL_ARCHITECTURE)) {
        LogicalArchitecture la = (LogicalArchitecture) ((referencedElement instanceof LogicalArchitecture) ? referencedElement
            : EcoreUtil2.getFirstContainer(referencedElement, LaPackage.Literals.LOGICAL_ARCHITECTURE));
        if (la != null) {
          availableElements.addAll(getRelationTypes(la));
          for (BlockArchitecture ba1 : la.getAllocatedArchitectures()) {
            SystemAnalysis ca = (SystemAnalysis) ba1;
            availableElements.addAll(getRelationTypes(ca));
            for (BlockArchitecture ba2 : ca.getAllocatedArchitectures()) {
              OperationalAnalysis oa = (OperationalAnalysis) ba2;
              availableElements.addAll(getRelationTypes(oa));
            }
          }
        }
      } else if ((referencedElement instanceof PhysicalArchitecture)
          || EcoreUtil2.isContainedBy(referencedElement, PaPackage.Literals.PHYSICAL_ARCHITECTURE)) {
        PhysicalArchitecture pa = (PhysicalArchitecture) ((referencedElement instanceof PhysicalArchitecture) ? referencedElement
            : EcoreUtil2.getFirstContainer(referencedElement, PaPackage.Literals.PHYSICAL_ARCHITECTURE));
        if (pa != null) {
          availableElements.addAll(getRelationTypes(pa));
          for (BlockArchitecture ba1 : pa.getAllocatedArchitectures()) {
            LogicalArchitecture la = (LogicalArchitecture) ba1;
            availableElements.addAll(getRelationTypes(la));
            for (BlockArchitecture ba2 : la.getAllocatedArchitectures()) {
              SystemAnalysis ca = (SystemAnalysis) ba2;
              availableElements.addAll(getRelationTypes(ca));
              for (BlockArchitecture ba3 : ca.getAllocatedArchitectures()) {
                OperationalAnalysis oa = (OperationalAnalysis) ba3;
                availableElements.addAll(getRelationTypes(oa));
              }
            }
          }
        }
      } else if ((referencedElement instanceof EPBSArchitecture)
          || EcoreUtil2.isContainedBy(referencedElement, EpbsPackage.Literals.EPBS_ARCHITECTURE)) {
        EPBSArchitecture ea = (EPBSArchitecture) ((referencedElement instanceof EPBSArchitecture) ? referencedElement
            : EcoreUtil2.getFirstContainer(referencedElement, EpbsPackage.Literals.EPBS_ARCHITECTURE));
        if (ea != null) {
          availableElements.addAll(getRelationTypes(ea));
          for (BlockArchitecture ba1 : ea.getAllocatedArchitectures()) {
            PhysicalArchitecture pa = (PhysicalArchitecture) ba1;
            availableElements.addAll(getRelationTypes(pa));
            for (BlockArchitecture ba2 : pa.getAllocatedArchitectures()) {
              LogicalArchitecture la = (LogicalArchitecture) ba2;
              availableElements.addAll(getRelationTypes(la));
              for (BlockArchitecture ba3 : la.getAllocatedArchitectures()) {
                SystemAnalysis ca = (SystemAnalysis) ba3;
                availableElements.addAll(getRelationTypes(ca));
                for (BlockArchitecture ba4 : ca.getAllocatedArchitectures()) {
                  OperationalAnalysis oa = (OperationalAnalysis) ba4;
                  availableElements.addAll(getRelationTypes(oa));
                }
              }
            }
          }
        }
      }
    }
    availableElements = ListExt.removeDuplicates(availableElements);

    return availableElements;
  }

  @Override
  public EClass getEClass() {
    return RequirementsPackage.Literals.ABSTRACT_RELATION;
  }

  /**
   * 
   */
  List<RelationType> getRelationTypes(BlockArchitecture arch) {
    List<RelationType> elements = new ArrayList<RelationType>();

    TreeIterator<EObject> content = arch.eAllContents();
    while (content.hasNext()) {
      EObject object = (EObject) content.next();
      if (object instanceof RelationType) {
        elements.add((RelationType) object);
      }
    }

    return elements;
  }

  @Override
  public List<EObject> getCurrentElements(EObject element, boolean onlyGenerated) {
    List<EObject> currentElements = new ArrayList<>();
    if (element instanceof AbstractRelation) {
      RelationType relationType = ((AbstractRelation) element).getRelationType();
      if (relationType != null)
        currentElements.add(relationType);
    }
    return currentElements;
  }

  @Override
  public List<EReference> getEStructuralFeatures() {
    return Collections.singletonList(RequirementsPackage.Literals.ABSTRACT_RELATION__RELATION_TYPE);
  }
}
