package xpadro.tutorial.webflow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.webflow.execution.Action;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import xpadro.tutorial.webflow.beans.UserBean;
import xpadro.tutorial.webflow.model.Car;


/**
 * Gets employee information from the data layer. Actually it uses a mock service
 * 
 * @author xpadro
 *
 */
@Controller("getDataController")
public class GetDataController implements Action {
	@Autowired
	private ApplicationContext context;
	
	@Override
	public Event execute(RequestContext req) throws Exception {
		UserBean user = context.getBean("userBean", UserBean.class);
		String event = invokeMockService(user);
		
		return new Event(this, event);
	}
	
	
	private String invokeMockService(UserBean user) {
		user.setCode("X56FD");
		user.setCity("Barcelona");
		user.setSales(getSales());
		
		return "yes";
	}
	
	private List<Car> getSales() {
		List<Car> salesList = new ArrayList<Car>();
		Car car = new Car();
		car.setManufacturer("BMW");
		car.setModel("Serie 3 320i");
		car.setPrice(35400);
		salesList.add(car);
		
		car = new Car();
		car.setManufacturer("BMW");
		car.setModel("Serie 5 535i");
		car.setPrice(60600);
		salesList.add(car);
		
		car = new Car();
		car.setManufacturer("Mercedes");
		car.setModel("Clase A 180");
		car.setPrice(28570);
		salesList.add(car);
		
		return salesList;
	}
}
