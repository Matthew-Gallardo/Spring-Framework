package org.acumen.training.codes.test;

import java.util.Arrays;

import org.acumen.training.codes.Basket;
import org.acumen.training.codes.HelloWorld;
import org.acumen.training.codes.Market;
import org.acumen.training.codes.Profile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCreateBeans {
	
	@Test
	public void testGetProfile() {
		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			Profile p1 = container.getBean("p1",Profile.class);
			System.out.println(p1.hashCode());
			p1=container.getBean("p1",Profile.class);
			System.out.println(p1.hashCode());
			System.out.println("%d %s %s %f".formatted(p1.getId(),p1.getFirstname(), 
					p1.getLastname(), p1.getSalary()));
			Profile p2 = container.getBean("p2",Profile.class);
			System.out.println("%d %s %s %f".formatted(p2.getId(),p2.getFirstname(), 
					p2.getLastname(), p2.getSalary()));
			
			Basket b1 = container.getBean("b1",Basket.class);
			b1.getCredentials().list(System.out);
			System.out.println(b1.getFruits());
			System.out.println(b1.getInventory());
			System.out.println(Arrays.toString(b1.getCreditors()));
			
			Market m1= container.getBean("m1", Market.class);
			System.out.println(m1.getOfficers());
			
			HelloWorld hw2 = container.getBean("hw2", HelloWorld.class);
			System.out.println(hw2.getMessage());
			
			System.out.println(m1.getEmployees());
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
	}

}
