package org.acumen.training.codes.model;

import java.util.logging.Logger;

public class HelloWorld {
	private static final Logger LOGGER = Logger.getLogger(HelloWorld.class.getName());
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
	public void createBean() {
		LOGGER.info("Create HelloWorld Object");
	}
	
	public void destroyBean() {
		LOGGER.info("Destroying HelloWorld Object");
		
	}
}
