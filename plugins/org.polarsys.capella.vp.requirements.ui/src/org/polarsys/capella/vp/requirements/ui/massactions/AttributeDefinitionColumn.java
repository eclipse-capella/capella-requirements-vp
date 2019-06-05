/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ui.massactions;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.editor.ComboBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.DateCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.painter.cell.ComboBoxPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.painter.cell.decorator.PaddingDecorator;
import org.eclipse.osgi.util.NLS;
import org.polarsys.capella.common.helpers.EObjectLabelProviderHelper;
import org.polarsys.capella.common.tools.report.EmbeddedMessage;
import org.polarsys.capella.common.tools.report.config.registry.ReportManagerRegistry;
import org.polarsys.capella.common.tools.report.util.IReportManagerDefaultComponents;
import org.polarsys.capella.vp.requirements.model.helpers.TypeHelper;
import org.polarsys.kitalpha.massactions.core.column.AbstractMAColumn;
import org.polarsys.kitalpha.massactions.core.helper.DisplayConverterHelper;
import org.polarsys.kitalpha.vp.requirements.Requirements.AbstractType;
import org.polarsys.kitalpha.vp.requirements.Requirements.Attribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeDefinitionEnumeration;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner;
import org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.DateValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumValue;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationDataTypeDefinition;
import org.polarsys.kitalpha.vp.requirements.Requirements.EnumerationValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.IntegerValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RealValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.Requirement;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;
import org.polarsys.kitalpha.vp.requirements.Requirements.StringValueAttribute;

/**
 * Define a column for attribute. We want to merge attributes as much as possible. Enumeration cannot be simply merged
 * as even if they have same name, they can have different literals. Other attributes can be merged if they share the
 * same dataType's name.
 */
public class AttributeDefinitionColumn extends AbstractMAColumn {

  // Type of attributes to be created if they are missing
  protected EClass type;

  // Definition of the column. If several definition are matched into one, the first is matched here.
  // We will use the correct definition on setValue.
  protected AttributeDefinition definition;

  public AttributeDefinitionColumn(EClass type, AttributeDefinition definition) {
    this.type = type;
    this.definition = definition;
  }

  public EClass getType() {
    return type;
  }

  public AttributeDefinition getDefinition() {
    return definition;
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, getIdentifier(definition));
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof AttributeDefinitionColumn) {
      AttributeDefinitionColumn clm = (AttributeDefinitionColumn) obj;
      if (!getIdentifier(definition).equals(getIdentifier(clm.definition))) {
        return false;
      }
      return true;
    }
    return false;
  }

  @Override
  public String getName() {
    return EObjectLabelProviderHelper.getText(definition);
  }

  @Override
  public String getLabel() {
    return EObjectLabelProviderHelper.getText(definition);
  }

  @Override
  protected IDisplayConverter createDisplayConverter() {
    if (definition instanceof AttributeDefinitionEnumeration) {
      return new EnumerationDisplayConverter();
    }
    EDataType dataType = TypeHelper.getDataType(type);
    if (dataType != null) {
      return DisplayConverterHelper.getDisplayConverter(dataType.getName());
    }
    return super.createDisplayConverter();
  }

  @Override
  protected ICellEditor createCellEditor() {
    if (definition instanceof AttributeDefinitionEnumeration) {
      List<EnumValue> values = ((EnumerationDataTypeDefinition) ((AttributeDefinitionEnumeration) definition)
          .getDefinitionType()).getSpecifiedValues().stream().map(EnumValue.class::cast).collect(Collectors.toList());
      ComboBoxCellEditor editor = new ComboBoxCellEditor(values);
      editor.setMultiselect(((AttributeDefinitionEnumeration) definition).isMultiValued());
      return editor;
    }
    EDataType dataType = TypeHelper.getDataType(type);
    if (EcorePackage.Literals.EDATE == dataType) {
      return new DateCellEditor();
    }
    return super.createCellEditor();
  }

  @Override
  protected ICellPainter createCellPainter() {
    if (definition instanceof AttributeDefinitionEnumeration && isEditable()) {
      return new PaddingDecorator(new ComboBoxPainter(), 0, 5, 0, 5);
    }
    return super.createCellPainter();
  }

  @Override
  public Object getDataValue(EObject arg0) {
    if (arg0 instanceof AttributeOwner) {
      Optional<Attribute> attr = ((AttributeOwner) arg0).getOwnedAttributes().stream()
          .filter(a -> getIdentifier(definition).equals(getIdentifier(a.getDefinition()))).findFirst();
      if (attr.isPresent()) {
        Attribute a = attr.get();
        if (a instanceof BooleanValueAttribute) {
          return ((BooleanValueAttribute) a).isValue();

        } else if (a instanceof DateValueAttribute) {
          return ((DateValueAttribute) a).getValue() == null ? Date.from(Instant.EPOCH)
              : ((DateValueAttribute) a).getValue();

        } else if (a instanceof EnumerationValueAttribute) {
          return ((EnumerationValueAttribute) a).getValues();

        } else if (a instanceof IntegerValueAttribute) {
          return ((IntegerValueAttribute) a).getValue();

        } else if (a instanceof RealValueAttribute) {
          return ((RealValueAttribute) a).getValue();

        } else if (a instanceof StringValueAttribute) {
          return ((StringValueAttribute) a).getValue();
        }
        return attr.get();

      } else if (TypeHelper.getCompatibleType(definition) == RequirementsPackage.Literals.DATE_VALUE_ATTRIBUTE) {
        // DateEditor doesn't handle null values.
        return Date.from(Instant.EPOCH);
      }
    }
    return null;
  }

  @Override
  public void setDataValue(EObject arg0, Object arg1) {

    AttributeOwner req = (AttributeOwner) arg0;
    Attribute attribute = ((AttributeOwner) arg0).getOwnedAttributes().stream()
        .filter(aa -> getIdentifier(definition).equals(getIdentifier(aa.getDefinition()))).findFirst()
        .orElseGet(() -> createAttribute(req, definition));

    if (attribute instanceof BooleanValueAttribute) {
      ((BooleanValueAttribute) attribute).setValue(((Boolean) arg1).booleanValue());

    } else if (attribute instanceof DateValueAttribute) {
      if (arg1 != null) {
        ((DateValueAttribute) attribute).setValue((Date) arg1);
      }

    } else if (attribute instanceof EnumerationValueAttribute) {
      ((EnumerationValueAttribute) attribute).getValues().clear();
      if (arg1 instanceof EnumValue) {
        ((EnumerationValueAttribute) attribute).getValues().add((EnumValue) arg1);
      } else if (arg1 instanceof Collection && !(((Collection) arg1).isEmpty())) {
        ((EnumerationValueAttribute) attribute).getValues().addAll((Collection) arg1);
      }

    } else if (attribute instanceof IntegerValueAttribute) {
      ((IntegerValueAttribute) attribute).setValue(((Integer) arg1).intValue());

    } else if (attribute instanceof RealValueAttribute) {
      ((RealValueAttribute) attribute).setValue(((Double) arg1).doubleValue());

    } else if (attribute instanceof StringValueAttribute) {
      String value = arg1 == null ? "" : arg1.toString(); //$NON-NLS-1$
      ((StringValueAttribute) attribute).setValue(value);
    }
  }

  @Override
  public void dataChanged(Collection<EObject> arg0) {

  }

  /**
   * Create an attribute for the given definition. If the owner has a type which doesn't expect this kind of attribute,
   * it doesn't create it.
   */
  public Attribute createAttribute(AttributeOwner req, AttributeDefinition definition) {

    AttributeDefinition wantedDefinition = definition;
    Attribute attr = null;
    AbstractType type = TypeHelper.getType(req);

    if (type != null) {
      wantedDefinition = type.getOwnedAttributes().stream()
          .filter(a -> getIdentifier(a).equals(getIdentifier(definition))).findFirst().orElseGet(() -> definition);
      if (wantedDefinition.eContainer() != type) {
        ReportManagerRegistry.getInstance().subscribe(IReportManagerDefaultComponents.MODEL)
            .warn(new EmbeddedMessage(
                NLS.bind(Messages.AttributeDefinitionColumn_AttributeOnWrongType,
                    new String[] { EObjectLabelProviderHelper.getText(wantedDefinition),
                        EObjectLabelProviderHelper.getText(req),
                        EObjectLabelProviderHelper.getText(((Requirement) req).getRequirementType()) }),
                IReportManagerDefaultComponents.MODEL, Arrays.asList(attr, req)));
        return null;
      }
    }

    EClass toCreate = TypeHelper.getCompatibleType(wantedDefinition);
    attr = (Attribute) toCreate.getEPackage().getEFactoryInstance().create(toCreate);
    req.getOwnedAttributes().add(attr);
    attr.setDefinition(wantedDefinition);
    return attr;
  }

  private String getIdentifier(AttributeDefinition definition) {
    if (definition == null) {
      return String.valueOf(definition);
    }
    if (definition.getReqIFLongName() == null) {
      return definition.getId();
    }
    if (definition instanceof AttributeDefinitionEnumeration) {
      return definition.getId();
    }
    if (definition.getDefinitionType() != null) {
      return definition.getReqIFLongName() + definition.getDefinitionType().getReqIFLongName();
    }
    return definition.getReqIFLongName();
  }
};