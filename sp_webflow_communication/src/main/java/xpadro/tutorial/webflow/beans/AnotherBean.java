package xpadro.tutorial.webflow.beans;

import org.springframework.stereotype.Component;

@Component("anotherBean")
public class AnotherBean {

	public String pingBean() {
		return "Retrieving AnotherBean from Spring context";
	}
}
