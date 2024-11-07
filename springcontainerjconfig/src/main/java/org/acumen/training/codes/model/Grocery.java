package org.acumen.training.codes.model;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Grocery {
	private static final Logger LOGGER = Logger.getLogger(Grocery.class.getName());
	//@Qualifier("fruits")
	//@Autowired
	private List<String> fruits;
	
	//@Qualifier("inventory")
	//@Autowired
	private Map<String, Double>priceList;
	
	//@Qualifier("p1")
	//@Autowired
	private Profile profile;
	
	
	public Grocery() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public Grocery(@Qualifier("fruits") List<String> fruits, 
			@Qualifier("inventory") Map<String, Double> priceList, 
			@Qualifier("p2") Profile profile) {
		super();
		this.fruits = fruits;
		this.priceList = priceList;
		this.profile = profile;
	}




	public List<String> getFruits() {
		return fruits;
	}
	public void setFruits(List<String> fruits) {
		this.fruits = fruits;
	}
	public Map<String, Double> getPriceList() {
		return priceList;
	}
	public void setPriceList(Map<String, Double> priceList) {
		this.priceList = priceList;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "Grocery [fruits=" + fruits + ", priceList=" + priceList + ", profile=" + profile + "]";
	}
	public void createBean() {
		LOGGER.info("Create Grocery Object");
	}
	
	public void destroyBean() {
		LOGGER.info("Destroying Grocery Object");
		
	}
	

}
