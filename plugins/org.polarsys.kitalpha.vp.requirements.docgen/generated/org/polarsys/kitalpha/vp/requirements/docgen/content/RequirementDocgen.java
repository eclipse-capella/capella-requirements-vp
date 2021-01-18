//Generated with EGF 1.6.1.201906060805
package org.polarsys.kitalpha.vp.requirements.docgen.content;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.vp.requirements.docgen.helper.RequirementHelper;

public class RequirementDocgen extends org.polarsys.kitalpha.vp.requirements.docgen.common.AbstractRequirementDocgen {
	protected static String nl;

	public static synchronized RequirementDocgen create(String lineSeparator) {
		nl = lineSeparator;
		RequirementDocgen result = new RequirementDocgen();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public RequirementDocgen() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.polarsys.kitalpha.vp.requirements.Requirements.Requirement) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.polarsys.kitalpha.vp.requirements.Requirements.Requirement parameter = null;

	public void set_parameter(org.polarsys.kitalpha.vp.requirements.Requirements.Requirement object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setElementContext(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		element = parameter;
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setElementContext", stringBuffer.toString());
	}

	protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String outputFolder = ctx.getValue("outputFolder").toString();
		String projectName = ctx.getValue("projectName").toString();

		stringBuffer.append(TEXT_1);
		super.method_content(stringBuffer, ctx);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(RequirementHelper.generateRequirementProperties(parameter, projectName, outputFolder));
		stringBuffer.append(TEXT_2);
		stringBuffer.append(RequirementHelper.generateFolderContent(parameter));
		stringBuffer.append(TEXT_2);
		stringBuffer.append(RequirementHelper.generateRequirementAttributesSection(parameter));
		stringBuffer.append(TEXT_2);
		stringBuffer.append(
				RequirementHelper.generateRequirementInternalAllocationSection(parameter, projectName, outputFolder));
		stringBuffer.append(TEXT_2);
		stringBuffer
				.append(RequirementHelper.generateRequirementsAllocationSection(parameter, projectName, outputFolder));
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
	}
}