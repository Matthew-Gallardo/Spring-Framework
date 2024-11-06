package org.acumen.training.codes.model;

import org.springframework.beans.factory.annotation.Value;

public class Profile {
	
	//@Value(value = "101")
	private Integer id;
	//@Value(value = "Kai")
	private String firstname;
	//@Value(value = "Sotto")
	private String lastname;
	//@Value(value = "1000.00")
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
		System.out.println("Creating Profile Object");
	}
	
	public void destroyBean() {
		System.out.println("Destroying Profile Object");
	}
}
