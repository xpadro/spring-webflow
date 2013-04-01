package xpadro.tutorial.webflow.controller;

import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.core.collection.ParameterMap;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;


/**
 * Checks that parameters sent from the main flow arrive correctly
 * 
 * @author xpadro
 *
 */
@Controller("startFlowController")
public class StartFlowController extends MultiAction {

	public Event start(RequestContext context) {
		ParameterMap map1 = context.getExternalContext().getRequestParameterMap();
		ParameterMap map2 = context.getRequestParameters();
		Assert.assertNotNull(map1.get("otherParam"));
		Assert.assertNotNull(map2.get("otherParam"));
		Assert.assertNotNull(context.getFlowScope().get("urlParam"));
		
		context.getFlashScope().put("otherParam", map1.get("otherParam"));

		return new Event(this,  "yes");
	}
}
