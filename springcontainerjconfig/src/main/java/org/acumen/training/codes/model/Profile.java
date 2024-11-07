package org.acumen.training.codes.model;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;

public class Profile {
	private static final Logger LOGGER = Logger.getLogger(Profile.class.getName());
	
	@Value(value = "101")
	private Integer id;
	@Value(value = "Kai")
	private String firstname;
	@Value(value = "Sotto")
	private String lastname;
	@Value(value = "1000.00")
	private Double salary;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	//Hook Methods
	public void createBean() {
		LOGGER.info("Create Profile Object");
	}
	
	public void destroyBean() {
		LOGGER.info("Destroying Profile Object");
		
	}
	@Override
	public String toString() {
		return "Profile [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", salary=" + salary + "]";
	}
	
}
