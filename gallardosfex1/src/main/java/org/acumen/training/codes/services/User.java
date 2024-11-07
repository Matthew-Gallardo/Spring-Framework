package org.acumen.training.codes.services;

public class User {
	private String name;
	public User() {	
	}

	public User(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	
	
	
}