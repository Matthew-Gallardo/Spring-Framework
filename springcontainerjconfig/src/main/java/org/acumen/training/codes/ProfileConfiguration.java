package org.acumen.training.codes;

import org.acumen.training.codes.model.Profile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration

public class ProfileConfiguration {
	
	@Scope(value = "singleton")
	@Bean(value = "p1", initMethod = "createBean", destroyMethod = "destroyBean")
	public Profile getProfile(@Value("101")Integer id, @Value("Kanye")String firstname, 
			@Value("West")String lastname, @Value("1000.00")Double salary)
	{
		Profile profile = new Profile();
		profile.setId(id);
		profile.setFirstname(firstname);
		profile.setLastname(lastname);
		profile.setSalary(salary);
		return profile;
	}
	
	@Bean
	public Profile p2(@Value("101")Integer id, @Value("Kanye")String firstname, 
			@Value("West")String lastname, @Value("1000.00")Double salary) 
	{
		
		Profile profile = new Profile();
		profile.setId(id);
		profile.setFirstname(firstname);
		profile.setLastname(lastname);
		profile.setSalary(salary);
		return profile;
	}
}
