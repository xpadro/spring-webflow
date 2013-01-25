package xpadro.tutorial.webflow.beans;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import xpadro.tutorial.webflow.model.Car;

/**
 * Contains employee personal data and sales record
 * 
 * @author xpadro
 *
 */
@Component("userBean")
@Scope("conversation")
public class UserBean {

	private String name;
	private String surname;
	private String code;
	private String city;
	private List<Car> sales;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the sales
	 */
	public List<Car> getSales() {
		return sales;
	}
	/**
	 * @param sales the sales to set
	 */
	public void setSales(List<Car> sales) {
		this.sales = sales;
	}
	
	
}
