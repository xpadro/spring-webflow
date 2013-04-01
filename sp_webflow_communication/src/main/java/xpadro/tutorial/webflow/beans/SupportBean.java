package xpadro.tutorial.webflow.beans;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

import xpadro.tutorial.webflow.model.Car;

@Component("supportBean")
@Scope("flow")
public class SupportBean {
	@Autowired
	private ApplicationContext context;
	private static Logger logger = Logger.getLogger("main");
	
	/**
	 * Retrieves a car instance from the flow scope
	 * @param context
	 * @return
	 */
	public String validateCarColor(RequestContext context) {
		Car car = (Car) context.getFlowScope().get("car");
		Assert.assertNotNull(car);
		Assert.assertEquals("red", car.getColor());
		
		return "success";
	}
	
	/**
	 * Checks the car has been set correctly and validates access to Spring context
	 * @return
	 */
	public String validateCarMechanics() {
		RequestContext context = RequestContextHolder.getRequestContext();
		Car car = (Car) context.getFlowScope().get("car");
		Assert.assertNotNull(car);
		Assert.assertEquals("8 cyl", car.getEngine());
		Assert.assertEquals("gasoline", car.getFuel());
		Assert.assertEquals("automatic", car.getTransmission());
		
		AnotherBean anotherBean = getBean1("anotherBean", AnotherBean.class);
		Assert.assertNotNull(anotherBean);
		logger.info(anotherBean.pingBean());
		
		AnotherBean anotherBean2 = getBean2("anotherBean", AnotherBean.class);
		Assert.assertNotNull(anotherBean2);
		logger.info(anotherBean2.pingBean());
		
		return "success";
	}
	
	/**
	 * Access the Spring context through the Web flow request context
	 * @param name
	 * @param clazz
	 * @return T
	 */
	public <T> T getBean1(String name, Class<T> clazz) {
		RequestContext context = RequestContextHolder.getRequestContext();
		return context.getActiveFlow().getApplicationContext().getBean(name, clazz);
	}
	
	/**
	 * Access the Spring context which has been auto wired to the bean
	 * @param name
	 * @param clazz
	 * @return T
	 */
	public <T> T getBean2(String name, Class<T> clazz) {
		return context.getBean(name, clazz);
	}
}
