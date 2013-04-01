package xpadro.tutorial.webflow.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import xpadro.tutorial.webflow.support.CarConstants;


/**
 * Resolves user preferences 
 * 
 * @author xpadro
 *
 */
@Controller("customerService")
public class CustomerServiceController {
	private static Logger logger = Logger.getLogger("main");
	
	/**
	 * Retrieve the user preferences
	 * @return
	 */
	public Map<String, String> getPreferences() {
		logger.info("Storing preferences in the flow scope");
		return getMockPreferences();
	}
	
	private Map<String, String> getMockPreferences() {
		Map<String, String> prefs = new HashMap<String, String>();
		prefs.put(CarConstants.PREFS_COLOR, "red");
		prefs.put(CarConstants.PREFS_MODEL, "corvette");
		prefs.put(CarConstants.PREFS_ENGINE, "8 cyl");
		prefs.put(CarConstants.PREFS_FUEL, "gasoline");
		prefs.put(CarConstants.PREFS_TRANSMISSION, "automatic");
		
		return prefs;
	}
}
