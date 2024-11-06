package org.acumen.training.codes.model;

public class HelloWorld {
	private String message;
	public HelloWorld() {
		System.out.println("Creating Hw");
	}
	public HelloWorld(String message) {
		this.message = message;
	}
	
	public String getMessage()	{
		return this.message;
	}
}
