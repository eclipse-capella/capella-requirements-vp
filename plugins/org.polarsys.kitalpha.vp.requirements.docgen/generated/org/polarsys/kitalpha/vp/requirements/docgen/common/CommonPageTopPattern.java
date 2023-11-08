//Generated with EGF 1.6.4.202309201142
package org.polarsys.kitalpha.vp.requirements.docgen.common;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.vp.requirements.docgen.utils.RequirementsServices;
import org.polarsys.kitalpha.doc.gen.business.core.util.EscapeChars;
import org.polarsys.kitalpha.vp.requirements.docgen.utils.ImageHelper;

public class CommonPageTopPattern {
	protected static String nl;

	public static synchronized CommonPageTopPattern create(String lineSeparator) {
		nl = lineSeparator;
		CommonPageTopPattern result = new CommonPageTopPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<img src=\"../icon/";
	protected final String TEXT_2 = "\" alt=\"";
	protected final String TEXT_3 = "\" style=\"float:left; margin-right:10px\" />" + NL + "" + NL + "<h1>";
	protected final String TEXT_4 = "</h1>" + NL + "" + NL
			+ "<p style=\"margin-top:3px; margin-bottom:3px\"><span class=\"elementMetaClass\">";
	protected final String TEXT_5 = "</span></p>" + NL + "" + NL + "<em class=\"elementPath\">";
	protected final String TEXT_6 = "</em>";
	protected final String TEXT_7 = " ";
	protected final String TEXT_8 = NL;
	protected final String TEXT_9 = NL + "No description";

	public CommonPageTopPattern() {
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

		List<Object> elementList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> domainFileNameServiceList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object elementParameter : elementList) {
			for (Object domainFileNameServiceParameter : domainFileNameServiceList) {

				this.element = (org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement) elementParameter;
				this.domainFileNameService = (org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService) domainFileNameServiceParameter;

				if (preCondition(ctx)) {
					ctx.setNode(new Node.Container(currentNode, getClass()));
					orchestration(ctx);
				}

			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_8);
		stringBuffer.append(TEXT_8);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_body(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("element", this.element);
			parameterValues.put("domainFileNameService", this.domainFileNameService);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement element = null;

	public void set_element(org.polarsys.kitalpha.vp.requirements.Requirements.ReqIFElement object) {
		this.element = object;
	}

	protected org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService domainFileNameService = null;

	public void set_domainFileNameService(org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService object) {
		this.domainFileNameService = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("element", this.element);
		parameters.put("domainFileNameService", this.domainFileNameService);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String outputFolder = ctx.getValue("outputFolder").toString();
		String projectName = ctx.getValue("projectName").toString();
		String elementType = EscapeChars.forHTML(element.eClass().getName());
		String documentTitle = RequirementsServices.getHyperlinkFromElement(element, domainFileNameService);
		String elementPath = RequirementsServices.getElementPath(element, domainFileNameService);
		String logo = ImageHelper.getImagePath(element, projectName, outputFolder);
		String description = element.getReqIFDescription();

		stringBuffer.append(TEXT_1);
		stringBuffer.append(logo);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(elementType);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(documentTitle);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(elementType);
		stringBuffer.append(TEXT_5);
		stringBuffer.append(elementPath);
		stringBuffer.append(TEXT_6);
		if (description != null) {
			stringBuffer.append(TEXT_7);
			stringBuffer.append(TEXT_8);
			stringBuffer.append(description);
		} else {
			stringBuffer.append(TEXT_9);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}