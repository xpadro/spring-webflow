package xpadro.tutorial.webflow.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

import xpadro.tutorial.webflow.model.Car;
import xpadro.tutorial.webflow.support.CarConstants;


/**
 * Completes the current car development according to user preferences
 * 
 * @author xpadro
 *
 */
@Controller("carFactory")
@SuppressWarnings("unchecked")
public class CarFactoryController extends MultiAction {
	private static Logger logger = Logger.getLogger("main");
	
	/**
	 * Paints the car instance with the user defined color
	 * @param car
	 * @return
	 */
	public Event paintCar(Car car) {
		RequestContext context = RequestContextHolder.getRequestContext();
		Map<String, String> prefs = (Map<String, String>) context.getFlowScope().get("preferences");
		car.setColor(prefs.get(CarConstants.PREFS_COLOR));
		logger.info("Accessing flow scoped variables: "+prefs);
		
		//Check 'car' is in flow scope
		Assert.assertNotNull(context.getFlowScope().get("car"));

		return new Event(this,  "success");
	}
	
	/**
	 * Sets the car configuration according to user preferences
	 * @param context
	 * @return
	 */
	public Event addMechanics(RequestContext context) {
		checkVariables(context);
		
		Map<String, String> prefs = (Map<String, String>) context.getFlowScope().get("preferences");
		Car car = (Car) context.getFlowScope().get("currentCar");
		logger.info("Accessing sub flow input parameter (prefs): "+prefs);
		logger.info("Accessing sub flow input parameter (car): "+car);

		car.setFactoryId(context.getExternalContext().getSessionMap().getInteger("factoryId"));
		logger.info("Accessing session attributes (factoryId): "+car.getFactoryId());
		car.setEngine(prefs.get(CarConstants.PREFS_ENGINE));
		car.setFuel(prefs.get(CarConstants.PREFS_FUEL));
		car.setTransmission(prefs.get(CarConstants.PREFS_TRANSMISSION));
		
		return new Event(this,  "success");
	}
	
	private void checkVariables(RequestContext context) {
		Object o1 = context.getRequestScope().get("carInstance1");
		Assert.assertNotNull(o1);
		Assert.assertTrue(o1 instanceof Car);
		Assert.assertEquals(((Car)o1).getColor(), "red");

		Object o2 = context.getRequestScope().get("carString");
		Assert.assertNotNull(o2);
		Assert.assertTrue(o2 instanceof String);
		Assert.assertEquals(((String)o2), "car");
		logger.info("Accessing request attribute (String): "+o2);
		
		Object o3 = context.getRequestScope().get("carInstance2");
		Assert.assertNotNull(o3);
		Assert.assertTrue(o3 instanceof Car);
		Assert.assertEquals(((Car)o3).getColor(), "red");
	}
}
