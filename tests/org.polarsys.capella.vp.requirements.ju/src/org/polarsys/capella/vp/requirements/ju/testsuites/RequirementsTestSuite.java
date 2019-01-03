/*******************************************************************************
 * Copyright (c) 2016, 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.vp.requirements.ju.testsuites;

import java.util.ArrayList;
import java.util.List;

import org.polarsys.capella.test.framework.api.BasicTestArtefact;
import org.polarsys.capella.test.framework.api.BasicTestSuite;
import org.polarsys.capella.vp.requirements.ju.misc.PropertyViewTestCase;
import org.polarsys.capella.vp.requirements.ju.testcases.FragmentationTestCase;
import org.polarsys.capella.vp.requirements.ju.testcases.ImportPreferencesTestCase;
import org.polarsys.capella.vp.requirements.ju.testcases.ImportTestCase;
import org.polarsys.capella.vp.requirements.ju.testcases.ModelDiffTestCase;
import org.polarsys.capella.vp.requirements.ju.testcases.ModelDiffTestCase2;
import org.polarsys.capella.vp.requirements.ju.testcases.ModelDiffTestCase3;
import org.polarsys.capella.vp.requirements.ju.testcases.REQ_Relation_01;
import org.polarsys.capella.vp.requirements.ju.testcases.REQ_Relation_02;
import org.polarsys.capella.vp.requirements.ju.testcases.RequirementsCustomDataTestCase;
import org.polarsys.capella.vp.requirements.ju.testcases.RequirementsTestCase;
import org.polarsys.capella.vp.requirements.ju.testcases.RequirementsToolsTestCase;
import org.polarsys.capella.vp.requirements.ju.testcases.ValidationRulesRegisteringTest;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.AbstractRelation_RelationType;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.BooleanValueAttribute_Definition_AttributeDefinition;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.CapellaElement_CapellaIncomingRelation_Requirement;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.CapellaElement_CapellaOutgoingRelation_Requirement;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.DateValueAttribute_Definition_AttributeDefinition;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.EnumerationValueAttribute_Definition_AttributeDefinition;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.EnumerationValueAttribute_Values_EnumValue;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.IntegerValueAttribute_Definition_AttributeDefinition;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.RealValueAttribute_Definition_AttributeDefinition;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.Requirement_CapellaIncomingRelation_CapellaElement;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.Requirement_CapellaOutgoingRelation_CapellaElement;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.Requirement_InternalRelationSource_Requirement;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.Requirement_InternalRelationTarget_Requirement;
import org.polarsys.capella.vp.requirements.ju.testcases.bqmodel.queries.StringValueAttribute_Definition_AttributeDefinition;

import junit.framework.Test;

/**
 * @author Joao Barata
 */
public class RequirementsTestSuite extends BasicTestSuite {

  /**
   * Returns the suite. This is required to unary launch this test.
   */
  public static Test suite() {
    return new RequirementsTestSuite();
  }

  /**
   * @see org.polarsys.capella.test.framework.api.BasicTestSuite#getTests()
   */
  @Override
  protected List<BasicTestArtefact> getTests() {
    List<BasicTestArtefact> tests = new ArrayList<BasicTestArtefact>();

    tests.add(new AbstractRelation_RelationType());
    tests.add(new BooleanValueAttribute_Definition_AttributeDefinition());
    tests.add(new CapellaElement_CapellaIncomingRelation_Requirement());
    tests.add(new CapellaElement_CapellaOutgoingRelation_Requirement());
    tests.add(new DateValueAttribute_Definition_AttributeDefinition());
    tests.add(new EnumerationValueAttribute_Definition_AttributeDefinition());
    tests.add(new EnumerationValueAttribute_Values_EnumValue());
    tests.add(new IntegerValueAttribute_Definition_AttributeDefinition());
    tests.add(new RealValueAttribute_Definition_AttributeDefinition());
    tests.add(new Requirement_CapellaIncomingRelation_CapellaElement());
    tests.add(new Requirement_CapellaOutgoingRelation_CapellaElement());
    tests.add(new Requirement_InternalRelationTarget_Requirement());
    tests.add(new Requirement_InternalRelationSource_Requirement());
    tests.add(new StringValueAttribute_Definition_AttributeDefinition());
    

    tests.add(new ValidationRulesRegisteringTest());
    tests.add(new RequirementsTestCase());
    tests.add(new ImportPreferencesTestCase());
    tests.add(new ImportTestCase());
    tests.add(new REQ_Relation_01());
    tests.add(new REQ_Relation_02());

    tests.add(new PropertyViewTestCase());
    
    tests.add(new ModelDiffTestCase());
    tests.add(new ModelDiffTestCase2());
    tests.add(new ModelDiffTestCase3());
    tests.add(new FragmentationTestCase());

    tests.add(new RequirementsCustomDataTestCase());
    tests.add(new RequirementsToolsTestCase());
    return tests;
  }
}
