package org.acumen.training.codes.controller;

import java.io.IOException;
import java.io.PrintWriter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("name")
public class HelloWorldController {
	
	public static final Logger LOGGER = LogManager.getLogger(HelloWorldController.class);

	//handler request(returns String)
	//action methods
	//services
	@ModelAttribute("name")
	public String name() {
		return "Hello Matt";
	}
	
	@ResponseBody // text plain result
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String printhelloWorld() {
		return "Bosssing Musta Buhay buhay ";
	}
	@ResponseBody 
	@RequestMapping(path = "/greet", method = RequestMethod.GET)
	public String greet(@ModelAttribute("name") String name) {
		return "Happy Lunch %s".formatted(name);
	}
	
	//Request Parameters
	@ResponseBody 
	@RequestMapping(path = "/profile/request", method = RequestMethod.GET)
	//Property editors
	public String askProfile(@RequestParam("id") Integer id , 
			@RequestParam("firstname")String firstname,  // if string you can remove the request param annotation
			@RequestParam("lastname")String lastname, 
			@RequestParam("salary")	Double salary) //Parsing all the primitive types
	{
		String template="%d %s %s %f".formatted(id,firstname,lastname,salary);
		LOGGER.info("Ask Profile Successfully fetched");
		return template;
		
	}
	
	//Path Variables
	@ResponseBody 
	@RequestMapping(path = "/profile/tx/{transaction}", method = RequestMethod.GET)
	public String updateAddProfile(@PathVariable("transaction") String tx)
	{
		String txName = "error";
		switch (tx) {
		case "add": 
			txName ="add profile data";
			LOGGER.info("Into the add profile data ");
			break;
		case "edit": 
			txName ="edit profile data";
			LOGGER.info("Into the edit profile data ");
			break;
		default:
			break;
		}
		LOGGER.info("updateAddProfile Successfully fetched");
		return txName;
		
	}
	
	// JakartaEE ( Do not use)
	@RequestMapping(path = "/print", method = RequestMethod.GET)
	public void printMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out= resp.getWriter();
		out.write("Do not use me, im a jakartaee");
		
	}
	
	//Views
	@RequestMapping(path = "/welcome.html", method = RequestMethod.GET)
	public String showWelcome(@ModelAttribute("welcomeMsg") String welcomeMsg) {
		return "welcomex";
	}	
	
	

}
