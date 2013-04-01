package xpadro.tutorial.webflow.model;


/**
 * Car model
 * 
 * @author xpadro
 *
 */
public class Car {
	private String model;
	private String engine;
	private String fuel;
	private String transmission;
	private String color;
	private int factoryId;
	
	
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the engine
	 */
	public String getEngine() {
		return engine;
	}
	/**
	 * @param engine the engine to set
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}
	/**
	 * @return the fuel
	 */
	public String getFuel() {
		return fuel;
	}
	/**
	 * @param fuel the fuel to set
	 */
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	/**
	 * @return the transmission
	 */
	public String getTransmission() {
		return transmission;
	}
	/**
	 * @param transmission the transmission to set
	 */
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the factoryId
	 */
	public int getFactoryId() {
		return factoryId;
	}
	/**
	 * @param factoryId the factoryId to set
	 */
	public void setFactoryId(int factoryId) {
		this.factoryId = factoryId;
	}
}
