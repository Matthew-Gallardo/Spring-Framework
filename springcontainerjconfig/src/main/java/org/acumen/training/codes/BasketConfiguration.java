package org.acumen.training.codes;

import java.util.List;
import java.util.Properties;

import org.acumen.training.codes.model.Basket;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasketConfiguration {

	@Bean
	public Basket b1(@Qualifier("credentials")Properties credentials ,
			@Qualifier("fruits")List<String> fruits) { // <ref bean ="">
		Basket b = new Basket();
		b.setCredentials(credentials);
		return b;
		
	}
}
