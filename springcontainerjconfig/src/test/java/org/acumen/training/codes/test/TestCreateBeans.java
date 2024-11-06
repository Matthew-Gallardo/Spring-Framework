package org.acumen.training.codes.test;

import org.acumen.training.codes.ApplicationConfiguration;
import org.acumen.training.codes.model.Profile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCreateBeans {
	
	@Test
	public void testApplicationConfig() {
		try (AnnotationConfigApplicationContext container = 
				new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
			Profile p1 = container.getBean("p1",Profile.class);
			System.out.println("%d %s %s %f".formatted(p1.getId(),p1.getFirstname(), 
					p1.getLastname(), p1.getSalary()));
			Profile p2 = container.getBean("p2",Profile.class);
			System.out.println("%d %s %s %f".formatted(p2.getId(),p2.getFirstname(), 
					p2.getLastname(), p2.getSalary()));
		} catch (BeansException e) {
			e.printStackTrace();
		}
		
	}

}
