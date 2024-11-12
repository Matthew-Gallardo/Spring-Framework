package org.training.codes.global;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.training.codes.global")
public class MyGlobalConfiguration {
	
	@Bean
	public String title() {
		return "Root Title";
	}

}
