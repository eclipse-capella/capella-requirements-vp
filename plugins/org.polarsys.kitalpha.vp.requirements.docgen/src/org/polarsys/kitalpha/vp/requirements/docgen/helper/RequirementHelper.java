/**
 *  Copyright (c) 2019 THALES GLOBAL SERVICES.
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

package org.polarsys.kitalpha.vp.requirements.docgen.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.common.helpers.EObjectExt;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.docgen.util.StringUtil;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaIncomingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaOutgoingRelation;
import org.polarsys.capella.vp.requirements.CapellaRequirements.CapellaRequirementsPackage;
import org.polarsys.kitalpha.doc.gen.business.core.util.LabelProviderHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumValue;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.Folder;
import org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.InternalRelation;
import org.polarsys.kitalpha.vp.requirements.Requirements.Module;
import org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RelationType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementType;
import org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute;
import org.polarsys.kitalpha.vp.requirements.docgen.utils.RequirementsServices;

public class RequirementHelper {
	
  public static String generateRequirementProperties(Requirement requirement, String projectName, String outputFolder) {
    String reqIFIdentifier = requirement.getReqIFIdentifier();
    String chapterName = requirement.getReqIFChapterName();
    String reqIFName = requirement.getReqIFName();
    String reqIFLongName = requirement.getReqIFLongName();
    String reqIFText = StringUtil.transformAREFString(requirement, requirement.getReqIFText(), projectName, outputFolder);
    RequirementType requirementType = requirement.getRequirementType();

    StringBuilder builder = new StringBuilder();

    builder.append(genSection("Properties"));
    builder.append("<b>Identifier: </b>").append(reqIFIdentifier).append(RequirementsServices.LINE_BREAK);
    builder.append("<b>Name: </b>").append(reqIFName).append(RequirementsServices.LINE_BREAK);
    builder.append("<b>Long name: </b>").append(reqIFLongName).append(RequirementsServices.LINE_BREAK);
    builder.append("<b>Chapter Name: </b>").append(chapterName).append(RequirementsServices.LINE_BREAK);
    builder.append("<b>Text: </b>").append(reqIFText).append(RequirementsServices.LINE_BREAK);
    builder.append("<b>Type: </b>").append(
        requirementType != null && requirementType.getReqIFLongName() != null ? requirementType.getReqIFLongName()
            : "");

    return builder.toString();

  }

  public static String generateRequirementAttributesSection(Requirement requirement) {
    StringBuffer sb = new StringBuffer();
    EList<Attribute> ownedAttributes = requirement.getOwnedAttributes();
    if (!ownedAttributes.isEmpty()) {
      sb.append(genSection("Requirement Attributes"));
      sb.append(RequirementsServices.TABLE_OPEN);
      sb.append(genTableRow(true, "Definition", "Value"));
      for (Attribute attribute : ownedAttributes) {
        AttributeDefinition definition = attribute.getDefinition();
        String definitionLabel = LabelProviderHelper.getText(definition);
        String value = "";
        if (attribute instanceof RealValueAttribute) {
          value = String.valueOf(((RealValueAttribute) attribute).getValue());
        } else if (attribute instanceof StringValueAttribute) {
          value = String.valueOf(((StringValueAttribute) attribute).getValue());
        } else if (attribute instanceof IntegerValueAttribute) {
          value = String.valueOf(((IntegerValueAttribute) attribute).getValue());
        } else if (attribute instanceof DateValueAttribute) {
          value = String.valueOf(((DateValueAttribute) attribute).getValue());
        } else if (attribute instanceof BooleanValueAttribute) {
          value = String.valueOf(((BooleanValueAttribute) attribute).isValue());
        } else if (attribute instanceof EnumerationValueAttribute) {
          EList<EnumValue> values = ((EnumerationValueAttribute) attribute).getValues();
          Collection<String> list = new ArrayList<String>();
          if (!values.isEmpty()) {
            for (EnumValue enumValue : values) {
              list.add(LabelProviderHelper.getText(enumValue));
            }
            value = genCommaString(list);
          }
        }
        sb.append(genTableRow(false, definitionLabel, value));
      }
      sb.append(RequirementsServices.TABLE_CLOSE);
    }
    return sb.toString();
  }

  public static String genCommaString(Collection<String> list) {

    StringBuilder builder = new StringBuilder();

    Iterator<String> iterator = list.iterator();

    int size = list.size();
    int i = 0;

    while (iterator.hasNext()) {
      builder.append(iterator.next());
      if (i < (size - 1)) {
        builder.append(", ");
      }
      i++;
    }

    return builder.toString();
  }

  public static String generateRequirementInternalAllocationSection(Requirement requirement, String projectName,
	      String outputFolder) {
    StringBuilder sb = new StringBuilder();
    EList<AbstractRelation> ownedRelations = requirement.getOwnedRelations();

    boolean first = true;
    if (!ownedRelations.isEmpty()) {
      for (AbstractRelation relation : ownedRelations) {
        if (relation instanceof InternalRelation) {
          if (first) {
            sb.append(genSection("Internal Requirement Allocations"));
            sb.append("<h3>Internal Links:</h3>").append(RequirementsServices.LINE_BREAK);
            ;
            sb.append(RequirementsServices.TABLE_OPEN);
            sb.append(genTableRow(true, "Target element", "Relation type"));
            first = false;
          }
          String relationTypeName = getRelationTypeName(relation);
          Requirement target = ((InternalRelation) relation).getTarget();
          String linkFromElement = getImageHyperlinkFromElement(target, projectName, outputFolder, RequirementsServices.NO_TARGET_DEFINED);
          sb.append(genTableRow(false, linkFromElement, relationTypeName));
        }
      }
      sb.append(RequirementsServices.TABLE_CLOSE);
    }

    return sb.toString();
  }
  
  private static String getImageHyperlinkFromElement (EObject target, String projectName, String outputFolder, String defaultValue) {
	  String linkFromElement = "";
      if (target != null) {
    	  String hyperlinkFromElement = RequirementsServices.getHyperlinkFromElement(target);
    	  String imageLinkFromElement = RequirementsServices.getImageLinkFromElement(target, projectName, outputFolder);
    	  linkFromElement = imageLinkFromElement + " " + hyperlinkFromElement;
      } else {
    	  linkFromElement = defaultValue;
      }
      return linkFromElement;
  }

  public static String generateRequirementsAllocationSection(Requirement requirement, String projectName,
      String folderName) {
    StringBuilder builder = new StringBuilder();

    generateRequirementRelations(requirement, builder, projectName, folderName);

    return builder.toString();
  }

  /**
   * @param requirement
   * @param builder
   */
  private static void generateRequirementRelations(EObject eObject, StringBuilder builder, String projectName,
      String folderName) {
    List<EObject> incomingRelations = EObjectExt.getReferencers(eObject,
        CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__TARGET);
    List<EObject> outgoingRelations = EObjectExt.getReferencers(eObject,
        CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__SOURCE);

    
    
    if (!incomingRelations.isEmpty() || !outgoingRelations.isEmpty()) {
      builder.append(genSection("Requirement Allocations"));
      builder.append(generateRequirementsIncomingAllocation(incomingRelations, projectName, folderName));
      builder.append(generateRequirementsOutgoingAllocation(outgoingRelations, projectName, folderName));
    }
  }

  public static String generateRequirementsIncomingAllocation(List<EObject> incomingRelations, String projectName,
      String folderName) {
    StringBuilder builder = new StringBuilder();

    if (!incomingRelations.isEmpty()) {
      builder.append("<div><h3>Incoming Links:</h3>").append(RequirementsServices.LINE_BREAK);
      builder.append(RequirementsServices.TABLE_OPEN);
      builder.append(genTableRow(true, "Source element", "Relation type"));
      for (EObject eObject : incomingRelations) {
        String relationTypeName = getRelationTypeName((AbstractRelation) eObject);
        CapellaElement source = ((CapellaOutgoingRelation) eObject).getSource();
        String linkFromElement = getImageHyperlinkFromElement(source, projectName, folderName, RequirementsServices.NO_SOURCE_DEFINED);
        builder.append(genTableRow(false, linkFromElement, relationTypeName));
      }
      builder.append(RequirementsServices.TABLE_CLOSE).append("</div>");
    }

    return builder.toString();
  }

  public static String generateRequirementsOutgoingAllocation(List<EObject> outgoingRelations, String projectName,
      String folderName) {
    StringBuilder builder = new StringBuilder();

    if (!outgoingRelations.isEmpty()) {
      builder.append("<div><h3>Outgoing Links:</h3>").append(RequirementsServices.LINE_BREAK);
      builder.append(RequirementsServices.TABLE_OPEN);
      builder.append(genTableRow(true, "Target element", "Relation type"));
      for (EObject eObject : outgoingRelations) {
        String relationTypeName = getRelationTypeName((AbstractRelation) eObject);
        CapellaElement target = ((CapellaIncomingRelation) eObject).getTarget();
        String linkFromElement = getImageHyperlinkFromElement(target, projectName, folderName, RequirementsServices.NO_TARGET_DEFINED);
        builder.append(genTableRow(false, linkFromElement, relationTypeName));
      }
      builder.append(RequirementsServices.TABLE_CLOSE).append("</div>");
    }
    return builder.toString();
  }

  public static String generateFolderContent(Requirement requirement) {
    StringBuilder builder = new StringBuilder();
    if (requirement instanceof Folder) {
      Folder folder = (Folder) requirement;
      EList<Requirement> ownedRequirements = folder.getOwnedRequirements();
      generateRequirementContents(builder, ownedRequirements);
    }
    return builder.toString();
  }

  /**
   * @param builder
   * @param ownedRequirements
   */
  private static void generateRequirementContents(StringBuilder builder, EList<Requirement> ownedRequirements) {
    if (!ownedRequirements.isEmpty()) {
      builder.append(genSection("Contained Elements"));

      List<String> moduleList = new ArrayList<String>();
      List<String> folderList = new ArrayList<String>();
      List<String> reqList = new ArrayList<String>();
      for (Requirement req : ownedRequirements) {
        String hyperlinkFromElement = RequirementsServices.getHyperlinkFromElement(req);
        if (req instanceof Module) {
          moduleList.add(hyperlinkFromElement);
          continue;
        }
        if (req instanceof Folder) {
          folderList.add(hyperlinkFromElement);
          continue;
        }
        reqList.add(hyperlinkFromElement);
      }
      if (!moduleList.isEmpty()) {
        builder.append("<h3>Modules</h3>").append(genList(moduleList));
      }
      if (!folderList.isEmpty()) {
        builder.append("<h3>Folders</h3>").append(genList(folderList));
      }
      if (!reqList.isEmpty()) {
        builder.append("<h3>Requirements</h3>").append(genList(reqList));
      }
    }
  }

  public static String generateModuleContents(Module module) {
    EList<Requirement> ownedRequirements = module.getOwnedRequirements();
    StringBuilder builder = new StringBuilder();

    generateRequirementContents(builder, ownedRequirements);

    return builder.toString();
  }

  /**
   * @param relation
   * @return name of relation.getRelationType()
   */
  public static String getRelationTypeName(AbstractRelation relation) {
    String relationTypeName = "";
    RelationType relationType = relation.getRelationType();
    if (relationType != null && relationType.getReqIFLongName() != null && !relationType.getReqIFLongName().isEmpty()) {
      relationTypeName = relationType.getReqIFLongName();
    }
    return relationTypeName;
  }

  public static String genSection(String value) {
    StringBuffer sb = new StringBuffer();
    sb.append(RequirementsServices.H2_OPEN);
    sb.append(value);
    sb.append(RequirementsServices.H2_CLOSE);
    return sb.toString();
  }

  public static String genList(Collection<String> values) {
    StringBuffer sb = new StringBuffer();
    if (!values.isEmpty()) {
      if (values.size() == 1) {
        sb.append(RequirementsServices.LIST_OPEN);
        sb.append(RequirementsServices.LIST_ITEM_OPEN);
        sb.append(((List<String>) values).get(0));
        sb.append(RequirementsServices.LIST_ITEM_CLOSE);
        sb.append(RequirementsServices.LIST_CLOSE);
      } else {
        sb.append(RequirementsServices.LIST_OPEN);
        for (String value : values) {
          sb.append(RequirementsServices.LIST_ITEM_OPEN);
          sb.append(value);
          sb.append(RequirementsServices.LIST_ITEM_CLOSE);
        }
        sb.append(RequirementsServices.LIST_CLOSE);
      }
    }
    return sb.toString();
  }

  public static String genTableRow(boolean header, String... values) {
    StringBuffer sb = new StringBuffer();
    if (values.length > 0) {
      sb.append(RequirementsServices.TABLE_ROW_OPEN);
      for (String value : values) {
        sb.append(header ? RequirementsServices.TABLE_TH_OPEN : RequirementsServices.TABLE_TD_OPEN);
        sb.append(value);
        sb.append(header ? RequirementsServices.TABLE_TH_CLOSE : RequirementsServices.TABLE_TD_CLOSE);
      }
      sb.append(RequirementsServices.TABLE_ROW_CLOSE);
    }
    return sb.toString();
  }

  public static String generateRequirementRelations(CapellaElement capellaElement, String outputFolder, String projectName) {
    StringBuilder builder = new StringBuilder();

    List<EObject> incomingRelations = EObjectExt.getReferencers(capellaElement,
        CapellaRequirementsPackage.Literals.CAPELLA_INCOMING_RELATION__TARGET);
    List<EObject> outgoingRelations = EObjectExt.getReferencers(capellaElement,
        CapellaRequirementsPackage.Literals.CAPELLA_OUTGOING_RELATION__SOURCE);

    if (!incomingRelations.isEmpty() || !outgoingRelations.isEmpty()) {
      builder.append(genSection("Requirement Allocations"));
    }

    if (!incomingRelations.isEmpty()) {
      builder.append(generateElementRequirementsIncomingAllocation(incomingRelations, outputFolder, projectName));
    }

    if (!outgoingRelations.isEmpty()) {
      builder.append(generateElementRequirementsOutgoingAllocation(outgoingRelations, outputFolder, projectName));
    }

    return builder.toString();
  }

  public static String generateElementRequirementsIncomingAllocation(List<EObject> incomingRelations, String outputFolder, String projectName) {
    StringBuilder builder = new StringBuilder();

    if (!incomingRelations.isEmpty()) {
      builder.append("<div><h3>Incoming Links:</h3>").append(RequirementsServices.LINE_BREAK);
      builder.append(RequirementsServices.TABLE_OPEN);
      builder.append(genTableRow(true, "Source element", "Relation type"));
      for (EObject eObject : incomingRelations) {
        String relationTypeName = getRelationTypeName((AbstractRelation) eObject);
        Requirement source = ((CapellaIncomingRelation) eObject).getSource();
        String hyperlinkFromElement = getImageHyperlinkFromElement(source, projectName, outputFolder, RequirementsServices.NO_TARGET_DEFINED);
        builder.append(genTableRow(false, hyperlinkFromElement, relationTypeName));
      }
      builder.append(RequirementsServices.TABLE_CLOSE).append("</div>");
    }

    return builder.toString();
  }

  public static String generateElementRequirementsOutgoingAllocation(List<EObject> outgoingRelations, String outputFolder, String projectName) {
    StringBuilder builder = new StringBuilder();

    if (!outgoingRelations.isEmpty()) {
      builder.append("<div><h3>Outgoing Links:</h3>").append(RequirementsServices.LINE_BREAK);
      builder.append(RequirementsServices.TABLE_OPEN);
      builder.append(genTableRow(true, "Target element", "Relation type"));
      for (EObject eObject : outgoingRelations) {
        String relationTypeName = getRelationTypeName((AbstractRelation) eObject);
        Requirement target = ((CapellaOutgoingRelation) eObject).getTarget();
        String hyperlinkFromElement = getImageHyperlinkFromElement(target, projectName, outputFolder, RequirementsServices.NO_TARGET_DEFINED);
        builder.append(genTableRow(false, hyperlinkFromElement, relationTypeName));
      }
      builder.append(RequirementsServices.TABLE_CLOSE).append("</div>");
    }
    return builder.toString();
  }
}
