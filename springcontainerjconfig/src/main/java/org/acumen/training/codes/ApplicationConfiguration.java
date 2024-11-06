package org.acumen.training.codes;

import java.util.List;
import java.util.Properties;

import org.acumen.training.codes.model.Basket;
import org.acumen.training.codes.model.Profile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
	
	private Properties credentials () {
		Properties props = new Properties();
		props.setProperty("fullname", "Kendrick Lamar");
		props.setProperty("permit", "123412");
		props.setProperty("dateStarted", "2010-10-10");
		return props;
	}
	
	@Bean
	public Profile p1() {
		return new Profile();
	}
	@Bean
	public Profile p2(@Value("101")Integer id, @Value("Kanye")String firstname, @Value("West")String lastname, @Value("1000.00")Double salary) 
	{
		
		Profile profile = new Profile();
		profile.setId(id);
		profile.setFirstname(firstname);
		profile.setLastname(lastname);
		profile.setSalary(salary);
		return profile;
	}

	@Bean
	public Basket b1() {
		
		return new Basket();
		
	}
}
