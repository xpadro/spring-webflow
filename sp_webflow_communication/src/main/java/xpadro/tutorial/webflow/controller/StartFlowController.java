package xpadro.tutorial.webflow.controller;

import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.core.collection.ParameterMap;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;


/**
 * Checks that the parameters sent from the main flow arrive correctly
 * 
 * @author xpadro
 *
 */
@Controller("startFlowController")
public class StartFlowController extends MultiAction {
	private static final String PARAM_OTHER = "otherParam";

	public Event start(RequestContext context) {
		ParameterMap map1 = context.getExternalContext().getRequestParameterMap();
		ParameterMap map2 = context.getRequestParameters();
		Assert.assertNotNull(map1.get(PARAM_OTHER));
		Assert.assertNotNull(map2.get(PARAM_OTHER));
		Assert.assertNotNull(context.getFlowScope().get("urlParam"));
		
		context.getFlashScope().put(PARAM_OTHER, map1.get(PARAM_OTHER));

		return new Event(this,  "yes");
	}
}
