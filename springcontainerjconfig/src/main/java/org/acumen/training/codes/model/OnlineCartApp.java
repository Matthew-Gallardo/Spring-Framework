package org.acumen.training.codes.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OnlineCartApp {

	@Autowired //getBean
	private Market market;
	
	@Qualifier("p2") // use ref
	@Autowired
	private Profile profile;
	
	@Autowired
	private EmployeePojo employee;
	
	@Autowired
	private Basket basket;
	public Market getMarket() {
		return market;
	}
	public void setMarket(Market market) {
		this.market = market;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public EmployeePojo getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeePojo employee) {
		this.employee = employee;
	}
	public Basket getBasket() {
		return basket;
	}
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	@Override
	public String toString() {
		return "OnlineCartApp [market=" + market + ", profile=" + profile + ", employee=" + employee + ", basket="
				+ basket + "]";
	}
	
	
}
