package org.acumen.training.codes;

import org.acumen.training.codes.model.HelloWorld;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class OthersConfiguration {
	
	@Bean(name = "hw1")
	public HelloWorld helloWorld (@Value("Kanye West for President") String msg) {
		return new HelloWorld(msg);
	}
}
