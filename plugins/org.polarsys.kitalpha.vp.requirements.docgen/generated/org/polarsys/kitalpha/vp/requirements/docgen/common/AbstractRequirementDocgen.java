//Generated with EGF 1.5.1.v20180423-0901
package org.polarsys.kitalpha.vp.requirements.docgen.common;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.vp.requirements.docgen.utils.RequirementFileNameService;
import org.polarsys.kitalpha.doc.gen.business.core.util.EscapeChars;
import org.polarsys.kitalpha.doc.gen.business.core.util.LabelProviderHelper;
import org.polarsys.kitalpha.doc.gen.business.core.util.DocGenHtmlUtil;
import org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService;
import org.polarsys.kitalpha.doc.gen.business.core.extension.page.PageExtensionRuntimeParameters;

public class AbstractRequirementDocgen
		extends org.polarsys.kitalpha.doc.gen.business.core.doccontent.ElementDocContent {
	protected static String nl;

	public static synchronized AbstractRequirementDocgen create(String lineSeparator) {
		nl = lineSeparator;
		AbstractRequirementDocgen result = new AbstractRequirementDocgen();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public AbstractRequirementDocgen() {
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

		if (preCondition(ctx)) {
			ctx.setNode(new Node.Container(currentNode, getClass()));
			orchestration(ctx);
		}

		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_setElementContext(new StringBuffer(), ictx);

		method_setFileName(new StringBuffer(), ictx);
		super.orchestration(new SuperOrchestrationContext(ictx));

		return null;
	}

	protected org.eclipse.emf.ecore.EObject element = null;

	public void set_element(org.eclipse.emf.ecore.EObject object) {
		this.element = object;
	}

	protected org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService domainFileNameService = null;

	public void set_domainFileNameService(org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService object) {
		this.domainFileNameService = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_setElementContext(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		element = null;
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setElementContext", stringBuffer.toString());
	}

	protected void method_setFileName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		fileName = RequirementFileNameService.SERVICE.getFileName(element);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setFileName", stringBuffer.toString());
	}

	protected void method_setFileNameService(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		fileNameService = RequirementFileNameService.SERVICE;
		stringBuffer.append(TEXT_1);

		Object value = ctx.getValue(PageExtensionRuntimeParameters.RUNTIME_PARAMETER_CONTRACT_NAME);
		if (value instanceof Map) {
			Object object = ((Map) value).get(PageExtensionRuntimeParameters.FILE_NAME_SERVICE_PARAMETER);
			if (object instanceof IFileNameService) {
				domainFileNameService = (IFileNameService) object;
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setFileNameService", stringBuffer.toString());
	}

	protected void method_setContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String elementName = EscapeChars.forHTML(LabelProviderHelper.getText(element));
		String elementType = EscapeChars.forHTML(element.eClass().getName());
		title = "Requirement - " + DocGenHtmlUtil.getModelName(element) + " - " + elementType + " " + elementName;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setContext", stringBuffer.toString());
	}

	protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.polarsys.kitalpha.vp.requirements.docgen/egf/requirement-docgen.fcore#LogicalName=org.polarsys.kitalpha.vp.requirements.docgen.common.CommonPageTopPattern"	args="element:element, domainFileNameService:domainFileNameService"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("element", element);
			callParameters.put("domainFileNameService", domainFileNameService);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.vp.requirements.docgen/egf/requirement-docgen.fcore#_wBsyIJzMEemJ2K-s0Y7hRg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
	}

	protected void method_endContent(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.polarsys.kitalpha.vp.requirements.docgen/egf/requirement-docgen.fcore#LogicalName=org.polarsys.kitalpha.vp.requirements.docgen.common.CommonPageBottomPattern"	args="element:element, domainFileNameService:domainFileNameService"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("element", element);
			callParameters.put("domainFileNameService", domainFileNameService);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.polarsys.kitalpha.vp.requirements.docgen/egf/requirement-docgen.fcore#_kjFpsJzgEemJ2K-s0Y7hRg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "endContent", stringBuffer.toString());
	}
}