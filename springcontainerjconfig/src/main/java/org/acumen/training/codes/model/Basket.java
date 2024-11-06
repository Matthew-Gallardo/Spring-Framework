package org.acumen.training.codes.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Basket {
	private Properties credentials;
	public Properties getCredentials() {
		return credentials;
	}
	public void setCredentials(Properties credentials) {
		this.credentials = credentials;
	}
	public List<String> getFruits() {
		return fruits;
	}
	public void setFruits(List<String> fruits) {
		this.fruits = fruits;
	}
	public Map<String, Double> getInventory() {
		return inventory;
	}
	public void setInventory(Map<String, Double> inventory) {
		this.inventory = inventory;
	}
	public String[] getCreditors() {
		return creditors;
	}
	public void setCreditors(String[] creditors) {
		this.creditors = creditors;
	}
	private List<String> fruits;
	private Map<String, Double> inventory;
	private String[] creditors;

}
