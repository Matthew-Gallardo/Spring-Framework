package org.acumen.training.codes;

import java.util.Properties;

import org.acumen.training.codes.services.Basket;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ImportResource(locations = {"classpath:applicationContext.xml"})
@ComponentScan("org.acumen.training.codes")
@PropertySource(value = {"classpath:/properties/jdbc.properties"}, encoding = "utf=8")
public class ApplicationConfiguration {

	@Bean
	public Properties jdbc(@Value("${url}")String url, 
			@Value("${user}")String username, 
			@Value("${password}")String  password , 
			@Value("${driverClass}")String driver) {
		Properties props = new Properties();
		props.setProperty("url", url);
		props.setProperty("user", username);
		props.setProperty("password", password);
		props.setProperty("driverClass", driver);

		return props;
	}
	
	@Bean
	public Basket b2(@Qualifier("jdbc") Properties jdbc) {
		Basket b = new Basket();
		b.setCredentials(jdbc);
		return b;
	}
	
}
