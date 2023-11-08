//Generated with EGF 1.6.4.202309201142
package org.polarsys.kitalpha.vp.requirements.docgen.common;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.kitalpha.vp.requirements.docgen.utils.RequirementFileNameService;
import org.polarsys.kitalpha.vp.requirements.docgen.utils.RequirementDiagramHelper;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.polarsys.kitalpha.doc.gen.business.core.util.LabelProviderHelper;
import org.polarsys.kitalpha.vp.requirements.docgen.utils.RequirementsServices;
import org.polarsys.kitalpha.vp.requirements.Requirements.*;

public class CommonPageBottomPattern {
	protected static String nl;

	public static synchronized CommonPageBottomPattern create(String lineSeparator) {
		nl = lineSeparator;
		CommonPageBottomPattern result = new CommonPageBottomPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<h2>Diagrams displaying \"";
	protected final String TEXT_2 = "\"</h2>" + NL + "<ul>";
	protected final String TEXT_3 = NL + "<li>";
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = " " + NL + "</li>";
	protected final String TEXT_6 = NL + "</ul>";

	public CommonPageBottomPattern() {
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

		stringBuffer.append(TEXT_4);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_setContext(new StringBuffer(), ictx);

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

	protected org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService fileNameService = null;

	public void set_fileNameService(org.polarsys.kitalpha.doc.gen.business.core.util.IFileNameService object) {
		this.fileNameService = object;
	}

	protected org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper helper = null;

	public void set_helper(org.polarsys.kitalpha.doc.gen.business.core.util.IDiagramHelper object) {
		this.helper = object;
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

		Set<DSemanticDiagram> diagramSet = RequirementsServices.getDiagramContainingObject(element);
		if (diagramSet.size() >= 1) {
			stringBuffer.append(TEXT_1);
			stringBuffer.append(LabelProviderHelper.getText(element));
			stringBuffer.append(TEXT_2);
			for (DSemanticDiagram diagram : diagramSet) {
				EObject eObject = diagram.getTarget();
				if (eObject == null) {
					//The diagram could not be exported 
					continue;
				}
				stringBuffer.append(TEXT_3);
				stringBuffer.append(TEXT_4);
				stringBuffer.append(RequirementsServices.getHyperlinkFromElement(diagram, domainFileNameService));
				stringBuffer.append(TEXT_5);

			}
			stringBuffer.append(TEXT_6);
		}
		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	protected void method_setContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		fileNameService = RequirementFileNameService.SERVICE;
		helper = new RequirementDiagramHelper();
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setContext", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}