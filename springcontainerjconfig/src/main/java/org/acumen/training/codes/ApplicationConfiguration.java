package org.acumen.training.codes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ProfileConfiguration.class, BasketConfiguration.class, OthersConfiguration.class})
@ComponentScan(basePackages = "org.acumen.training.codes") 
public class ApplicationConfiguration {
	
	@Bean
	public Properties credentials () {
		Properties props = new Properties();
		props.setProperty("fullname", "Kendrick Lamar");
		props.setProperty("permit", "123412");
		props.setProperty("dateStarted", "2010-10-10");
		return props;
	}
	
	@Bean
	public Map<String, Double> inventory(){
		Map<String, Double>inv = new HashMap<>();
		inv.put("pencil", 100.00);
		inv.put("paper", 231.1);
		inv.put("paper", 352.1);
		return inv;
	}
	
	@Bean
	public List<String> fruits(){
		List<String>f  = new ArrayList<String>();
		f.add("Mango");
		f.add("Apple");
		f.add("Lemon");
		return f;
	}
	@Bean
	public List<String> configs(){
		List<String>dbConf  = new ArrayList<String>();
		return dbConf;
	}
	
	
	
	



}
