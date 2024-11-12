package org.acumen.training.codes;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.acumen.training.codes")
public class MySpringConfiguration implements WebMvcConfigurer {
 
	@Bean
	public ViewResolver vewResolver1() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(2);
		return resolver;
	}
 
	@Bean
	public ViewResolver vewResolver2() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);
		return resolver;
	}
 
	@Bean
	public ViewResolver vewResolver3() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(0);
		return resolver;
	}
 
	@Bean
	public View loginForm() {
		JstlView view = new JstlView();
		view.setUrl("/WEB-INF/jsp/login/login_form.jsp");
		return view;
	}
 
	@Bean
	public View loginResult() {
		JstlView view = new JstlView();
		view.setUrl("/WEB-INF/jsp/login/login_result.jsp");
		return view;
	}
 
	@Bean
	public View profileForm() {
		JstlView view = new JstlView();
		view.setUrl("/WEB-INF/jsp/profile/profile_form.jsp");
		return view;
	}
 
	@Bean
	public View profileResult() {
		JstlView view = new JstlView();
		view.setUrl("/WEB-INF/jsp/profile/profile_result.jsp");
		return view;
	}
	
	@Bean
	public View calculatorForm() {
		JstlView view = new JstlView();
		view.setUrl("/WEB-INF/jsp/calculator/calculator_form.jsp");
		return view;
	}
	
	@Bean
	public View calculatorResult() {
		JstlView view = new JstlView();
		view.setUrl("/WEB-INF/jsp/calculator/calculator_result.jsp");
		return view;
	}
	@Bean
	public View spendingForm() {
		JstlView view = new JstlView();
		view.setUrl("/WEB-INF/jsp/spending/spending_form.jsp");
		return view;
	}
	
	@Bean
	public View spendingrResult() {
		JstlView view = new JstlView();
		view.setUrl("/WEB-INF/jsp/spending/spending_result.jsp");
		return view;
	}
 
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("config.errors");
		return ms;
	}
	@Bean
	public SimpleMappingExceptionResolver exceptionResolver() {
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		//Exception to error views
		Properties exception= new Properties();
		exception.setProperty(ArithmeticException.class.getName(), "errArithmetic");
		exception.setProperty(ClassCastException.class.getName(), "errClassCast");
		resolver.setExceptionMappings(exception);
		
		//HTTP Status code to error view
		Properties errStatus= new Properties();
		errStatus.setProperty("err400", "400");
		errStatus.setProperty("err500", "500");
		errStatus.setProperty("err403", "403");
		resolver.setStatusCodes(errStatus);
		
		resolver.setDefaultErrorView("errDefaultPage");
		
		return resolver;
	}
	

}
 
