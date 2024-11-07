package org.acumen.training.codes.test;

import org.acumen.training.codes.ApplicationConfiguration;
import org.acumen.training.codes.model.Basket;
import org.acumen.training.codes.model.EmployeePojo;
import org.acumen.training.codes.model.Grocery;
import org.acumen.training.codes.model.OnlineCartApp;
import org.acumen.training.codes.model.Profile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCreateBeans {
	public static final Logger LOGGER = LogManager.getLogger(TestCreateBeans.class);
	
	
	@Test
	public void testApplicationConfig() {
		try (AnnotationConfigApplicationContext container = 
				new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
			
			
			Profile p1 = container.getBean("p1",Profile.class);
			LOGGER.info("Profile 1 hashcode {}", p1.hashCode());
			p1 = container.getBean("p1",Profile.class);
			LOGGER.info("Profile 1 second hashcode {}", p1.hashCode());
			LOGGER.info("Profile 1 hashcode", p1.hashCode());
			LOGGER.info("Profile 1 {} ", p1);
			Profile p2 = container.getBean("p2",Profile.class);
			LOGGER.info("Profile 2 {} ", p2);
			Basket b = container.getBean("b1",Basket.class);
			LOGGER.info("{}", b.getCredentials());
			EmployeePojo emp1 =  container.getBean("employeePojo", EmployeePojo.class);
			LOGGER.info("Employee Details: {}", emp1);
			
			Grocery g = container.getBean("grocery", Grocery.class);
			LOGGER.info("Price: {}", g.getFruits());
			LOGGER.info("Inventory: {}", g.getPriceList());
			LOGGER.info("{}", g.getProfile());
			
			
			OnlineCartApp oca = container.getBean("onlineCartApp", OnlineCartApp.class);
			LOGGER.info("Basket: {}" , oca.getBasket());
			LOGGER.info("Employee: {}" , oca.getEmployee());
			LOGGER.info("Market: {}" , oca.getMarket());
			LOGGER.info("Profile: {}" , oca.getProfile());
			
			
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
	}

}
