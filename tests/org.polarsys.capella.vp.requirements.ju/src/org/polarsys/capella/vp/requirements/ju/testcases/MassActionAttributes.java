/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.vp.requirements.ju.testcases;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.common.tools.report.appenders.reportlogview.LightMarkerRegistry;
import org.polarsys.capella.test.framework.api.BasicTestCase;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.vp.requirements.model.helpers.TypeHelper;
import org.polarsys.capella.vp.requirements.ui.massactions.AttributeDefinitionColumn;
import org.polarsys.capella.vp.requirements.ui.massactions.RequirementAttributesProvider;
import org.polarsys.kitalpha.massactions.core.column.IMAColumn;
import org.polarsys.kitalpha.vp.requirements.Requirements.AttributeOwner;
import org.polarsys.kitalpha.vp.requirements.Requirements.BooleanValueAttribute;
import org.polarsys.kitalpha.vp.requirements.Requirements.RequirementsPackage;

public class MassActionAttributes extends BasicTestCase {

  private static final String projectTestName = "attributes";

  public static final String REQ = "6b227995-a180-484a-b371-fe9ee6c07ab2"; //$NON-NLS-1$
  public static final String REQ_BOOL1 = "7244d94f-4d76-42f9-aeb6-7a7fb352193e"; //$NON-NLS-1$
  public static final String REQ_BOOL2 = "e3ff7807-bbd2-4128-ab5a-e5bb67a54309"; //$NON-NLS-1$
  public static final String REQ_BOOL3 = "75324161-4f0d-4ffd-b059-d1f084285343"; //$NON-NLS-1$
  public static final String REQ_STRING1 = "c4a84e42-eb7c-4b18-a88f-3682c68fe7e4"; //$NON-NLS-1$
  public static final String REQ_ENUM = "f119215a-a66c-4055-9f20-16fb6b540fc2"; //$NON-NLS-1$
  public static final String REQ_ENUM_1 = "bafbf432-553a-4286-8ead-43ceed9f136a"; //$NON-NLS-1$
  
  public static final String REQ2 = "e1db5d1b-5a01-4f15-b5b4-a35bb8909fc8"; //$NON-NLS-1$
  public static final String REQ2_STRING1 = "7d9a0c3d-1725-4116-b0f6-44cb3fa31bcb"; //$NON-NLS-1$
  public static final String REQ2_ENUM = "254015c2-27ab-4731-87ea-882f58dd7f00"; //$NON-NLS-1$
  public static final String REQ2_BOOL1 = "db937965-bbf9-4c7a-b552-4cace14bddb2"; //$NON-NLS-1$
  public static final String REQ2_DATE = "ef9301ee-c5bc-4561-91fb-be4c777c4367"; //$NON-NLS-1$
  public static final String REQ2_BOOL2 = "f65ab475-b6af-4a75-b6ba-9c0e49b30c89"; //$NON-NLS-1$
  public static final String REQ2_BOOL3 = "34325c3f-5677-406d-9be7-7cef25ab9032"; //$NON-NLS-1$
  public static final String REQ2_OTHER = "9f259f8a-6a19-450a-8001-8d8b973d9f42"; //$NON-NLS-1$
  public static final String REQ2_NULL = "8ca65755-f48f-40b8-8c43-30e9e36ba350"; //$NON-NLS-1$
  
  public static final String REQA = "77675242-1015-4e81-a1de-f527f9c8a268"; //$NON-NLS-1$
  public static final String REQB = "72aec6ad-60f4-4284-83ea-0a6c04d15deb"; //$NON-NLS-1$
  
  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestArtefact#getRequiredTestModels()
   */
  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList("attributes");
  }

  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestCase#test()
   */
  @Override
  public void test() throws Exception {
    SessionContext s = new SessionContext(getSession(projectTestName));

    
    assertTrue(TypeHelper.getDataType(RequirementsPackage.Literals.BOOLEAN_VALUE_ATTRIBUTE) == EcorePackage.Literals.EBOOLEAN);
    assertTrue(TypeHelper.getDataType(RequirementsPackage.Literals.ENUMERATION_DATA_TYPE_DEFINITION) == null); //Its not a dataType
    assertTrue(TypeHelper.getDataType(RequirementsPackage.Literals.STRING_VALUE_ATTRIBUTE) == EcorePackage.Literals.ESTRING);
    assertTrue(TypeHelper.getDataType(RequirementsPackage.Literals.DATE_VALUE_ATTRIBUTE) == EcorePackage.Literals.EDATE);
    assertTrue(TypeHelper.getDataType(RequirementsPackage.Literals.INTEGER_VALUE_ATTRIBUTE) == EcorePackage.Literals.EINT);
    assertTrue("Real is a double", TypeHelper.getDataType(RequirementsPackage.Literals.REAL_VALUE_ATTRIBUTE) == EcorePackage.Literals.EDOUBLE);
    
    assertTrue(TypeHelper.getCompatibleType(s.getSemanticElement(REQ_BOOL1)) == RequirementsPackage.Literals.BOOLEAN_VALUE_ATTRIBUTE);
    assertTrue(TypeHelper.getCompatibleType(s.getSemanticElement(REQ_BOOL2)) == RequirementsPackage.Literals.BOOLEAN_VALUE_ATTRIBUTE);
    assertTrue(TypeHelper.getCompatibleType(s.getSemanticElement(REQ_STRING1)) == RequirementsPackage.Literals.STRING_VALUE_ATTRIBUTE);
    assertTrue(TypeHelper.getCompatibleType(s.getSemanticElement(REQ_ENUM)) == RequirementsPackage.Literals.ENUMERATION_VALUE_ATTRIBUTE);
    assertTrue(TypeHelper.getCompatibleType(s.getSemanticElement(REQ2_ENUM)) == RequirementsPackage.Literals.ENUMERATION_VALUE_ATTRIBUTE);
    assertTrue(TypeHelper.getCompatibleType(s.getSemanticElement(REQ2_DATE)) == RequirementsPackage.Literals.DATE_VALUE_ATTRIBUTE);
    assertTrue("Other types are mapped to String", TypeHelper.getCompatibleType(s.getSemanticElement(REQ2_OTHER)) == RequirementsPackage.Literals.STRING_VALUE_ATTRIBUTE);
    
    
    Collection<IMAColumn> cols2 = new RequirementAttributesProvider().getColumnValues(Collections.emptyList(), Arrays.asList(s.getSemanticElement(REQB)));
    assertTrue("At least one column", cols2.size()>0);
    assertTrue("All have expected kind", cols2.stream().allMatch(AttributeDefinitionColumn.class::isInstance));
    assertTrue("All have definition", cols2.stream().map(AttributeDefinitionColumn.class::cast).noneMatch(x -> x.getDefinition() == null));
    assertTrue("Date shall not be null even if no attribute", cols2.stream().map(AttributeDefinitionColumn.class::cast).filter(x -> findColumn(x, "Req2_Date")).findFirst().get().getDataValue(s.getSemanticElement(REQB)) != null);
    
    Collection<IMAColumn> cols3 = new RequirementAttributesProvider().getColumnValues(Collections.emptyList(), Arrays.asList(s.getSemanticElement(REQA)));
    assertTrue("At least one column", cols3.size()>0);
    assertTrue("All have expected kind", cols3.stream().allMatch(AttributeDefinitionColumn.class::isInstance));
    assertTrue("Enum and Enum_1 have same definitions, they shall be separated though", cols3.stream().map(AttributeDefinitionColumn.class::cast).filter(x -> findColumn(x, "Enum") || findColumn(x, "Enum_1")).count() == 2);
    
    final Collection<IMAColumn> cols = new RequirementAttributesProvider().getColumnValues(Collections.emptyList(), Arrays.asList(s.getSemanticElement(REQA), s.getSemanticElement(REQB)));
    assertTrue("At least one column", cols.size()>0);
    assertTrue("All have expected kind", cols.stream().allMatch(AttributeDefinitionColumn.class::isInstance));
    assertTrue("All have definition", cols.stream().map(AttributeDefinitionColumn.class::cast).noneMatch(x -> x.getDefinition() == null));
    assertTrue("Bool1.definition have same name, same DataType, they shall be merged to one column", cols.stream().map(AttributeDefinitionColumn.class::cast).filter(x -> findColumn(x, "Bool1")).count() == 1);
    assertTrue("Bool2.definition have same name, same DataType names, they shall be merged to one column", cols.stream().map(AttributeDefinitionColumn.class::cast).filter(x -> findColumn(x, "Bool2")).count() == 1);
    assertTrue("Bool3.definition have same name, different DataType names, they shall not be available", cols.stream().map(AttributeDefinitionColumn.class::cast).filter(x -> findColumn(x, "Bool3")).count() == 0);
    
    TransactionHelper.getExecutionManager((EObject)s.getSemanticElement(REQA)).execute(new AbstractReadWriteCommand() {
      @Override
      public void run() {
        AttributeDefinitionColumn column = cols.stream().map(AttributeDefinitionColumn.class::cast).filter(x -> findColumn(x, "Bool1")).findFirst().get();
        column.setDataValue(s.getSemanticElement(REQA), Boolean.TRUE);
        column.setDataValue(s.getSemanticElement(REQB), Boolean.TRUE);
      }
    });
    assertTrue("Value shall be set on REQA", getAttributeValue(s.getSemanticElement(REQA), "Bool1").equals(Boolean.TRUE));
    assertTrue("Value shall be set on REQB", getAttributeValue(s.getSemanticElement(REQB), "Bool1").equals(Boolean.TRUE));
    
    
    assertTrue("Enum have different definitions, they shall be separated", cols.stream().map(AttributeDefinitionColumn.class::cast).filter(x -> findColumn(x, "Enum")).count() == 0);
    
    Collection<IMAColumn> colsModule = new RequirementAttributesProvider().getColumnValues(Collections.emptyList(), Arrays.asList(s.getSemanticElement(REQB)));
    assertTrue("At least one column for modules", colsModule.size()>0);
  }
  
  private static Boolean getAttributeValue(EObject c, String name) {
    return ((BooleanValueAttribute)((AttributeOwner)c).getOwnedAttributes().stream().filter(a -> a.getDefinition().getReqIFLongName().equals(name)).findFirst().get()).isValue();
  }
  
  private static boolean findColumn(AttributeDefinitionColumn c, String name) {
    return c.getDefinition().getReqIFLongName().equals(name);
  }
}