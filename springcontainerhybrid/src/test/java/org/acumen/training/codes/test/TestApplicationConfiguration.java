package org.acumen.training.codes.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.acumen.training.codes.ApplicationConfiguration;
import org.acumen.training.codes.services.Basket;
import org.acumen.training.codes.services.Employee;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApplicationConfiguration {
	public static final Logger LOGGER = LogManager.getLogger(TestApplicationConfiguration.class);
	
	@Test
	public void testAppConfiguration() {
		
	
		Employee employee = container.getBean("employee", Employee.class);
		LOGGER.info("{}", employee);
		Basket basket = container.getBean("b1", Basket.class);
		LOGGER.info("{}", basket.getCredentials());
		
		Basket basket2 = container.getBean("b2", Basket.class);
		LOGGER.info("{}", basket2.getCredentials());
		
		container.close();
	}

}
