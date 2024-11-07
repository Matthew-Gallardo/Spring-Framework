package org.acumen.training.codes.services;

public class UserId {
	private int id;
	private String name;

	public UserId(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "UserId [id=" + id + ", name=" + name + "]";
	}


	
}