package org.acumen.training.codes.test;


import java.util.Arrays;
import java.util.logging.Logger;

import org.acumen.training.codes.Basket;
import org.acumen.training.codes.HelloWorld;
import org.acumen.training.codes.Market;
import org.acumen.training.codes.Profile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCreateBeans {
	private static final Logger LOGGER = Logger.getLogger(TestCreateBeans.class.getName());
	
	@Test
	public void testGetProfile() {
		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			
			Profile p1 = container.getBean("p1",Profile.class);
			LOGGER.info("%s".formatted(p1.hashCode()));
			
	
			p1=container.getBean("p1",Profile.class);
			LOGGER.info("%s".formatted(p1.hashCode()));
			LOGGER.info(p1.toString());
			
			Profile p2 = container.getBean("p2",Profile.class);
			LOGGER.info(p2.toString());
		
			
			Basket b1 = container.getBean("b1",Basket.class);
			b1.getCredentials().list(System.out);
			System.out.println(b1.getFruits());
			
			System.out.println(b1.getInventory());
			System.out.println(Arrays.toString(b1.getCreditors()));
			
			Market m1= container.getBean("m1", Market.class);
			
			m1.getOfficers().forEach((p)->{
				 System.out.println(p.toString());
			});
			
			
			
			HelloWorld hw2 = container.getBean("hw2", HelloWorld.class);
			System.out.println(hw2.getMessage());
			
			System.out.println(m1.getEmployees());
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
	}

}
