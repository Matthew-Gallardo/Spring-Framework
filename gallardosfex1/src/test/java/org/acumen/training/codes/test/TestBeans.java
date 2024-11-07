package org.acumen.training.codes.test;

import java.util.List;

import org.acumen.training.codes.MyBeans;
import org.acumen.training.codes.services.BasketSets;
import org.acumen.training.codes.services.JavaData;
import org.acumen.training.codes.services.RecordData;
import org.acumen.training.codes.services.User;
import org.acumen.training.codes.services.UserDao;
import org.acumen.training.codes.services.UserId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeans {
	public static final Logger LOGGER = LogManager.getLogger(TestBeans.class);

	@Test
	public void testApplicationContext() {
		try (ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			// User 
			User user1 =  container.getBean("user1", User.class);
			User user2 =  container.getBean("user2", User.class);
			User user3 =  container.getBean("user3", User.class);
			User user4 =  container.getBean("user4", User.class);

			LOGGER.info("User 1:{}", user1);
			LOGGER.info("User 2:{}", user2);
			LOGGER.info("User 3:{}", user3);
			LOGGER.info("User 4:{}", user4);
		

			//UserId
			UserId userId =  container.getBean("userId", UserId.class);
			LOGGER.info("UserId: {}", userId);
			
			// UserDao beans
			UserDao userDao1 =  container.getBean("userDao1", UserDao.class);
			UserDao userDao2 =  container.getBean("userDao2",UserDao.class);

			List<User> usersDao1 = userDao1.getUsers();
			System.out.println("UserDao1 Users: ");
			usersDao1.forEach(System.out::println);

			List<User> usersDao2 = userDao2.getUsers();
			System.out.println("UserDao2 Users: ");
			usersDao2.forEach(System.out::println);
		} catch (BeansException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testMyBeans() {
		try (AnnotationConfigApplicationContext container = 
				new AnnotationConfigApplicationContext(MyBeans.class)) {
			    RecordData recordData1 = container.getBean("recordData1", RecordData.class);
		        RecordData recordData2 = container.getBean("recordData2", RecordData.class);
		        RecordData recordData3 = container.getBean("recordData3", RecordData.class);
		        RecordData recordData4 = container.getBean("recordData4", RecordData.class);
		        
		        
		        LOGGER.info("RecordData1: {}", recordData1);
		        LOGGER.info("RecordData2: {}", recordData2);
		        LOGGER.info("RecordData3: {}", recordData3);
		        LOGGER.info("RecordData4: {}", recordData4);
		    

		
		        BasketSets basketSet1 = container.getBean("basketSet1", BasketSets.class);
		        BasketSets basketSet2 = container.getBean("basketSet2", BasketSets.class);
		        BasketSets basketSet1Alias = container.getBean("basketSet1Alias", BasketSets.class);
		        BasketSets basketSet2Alias = container.getBean("basketSet2Alias", BasketSets.class);
		
		        		
		        LOGGER.info("BasketSet1: {}", basketSet1);
		        LOGGER.info("BasketSet2: {}", basketSet2);
		        LOGGER.info("BasketSet1Alias: {}", basketSet1Alias);
		        LOGGER.info("BasketSet2Alias: {}", basketSet2Alias);
	
			
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testJavaData() {
		
		try (ClassPathXmlApplicationContext container = 
				new ClassPathXmlApplicationContext("applicationContext.xml")) {
		
			JavaData javaData = container.getBean("javaData",JavaData.class);
			LOGGER.info("Username: {}", javaData.getUser());
			LOGGER.info("Password: {}", javaData.getPassword());
			LOGGER.info("Uri: {}", javaData.getUri());
			LOGGER.info("Driver Class: {}", javaData.getDriverClass());
			

		} catch (BeansException e) {
			e.printStackTrace();
		}

	}
}
