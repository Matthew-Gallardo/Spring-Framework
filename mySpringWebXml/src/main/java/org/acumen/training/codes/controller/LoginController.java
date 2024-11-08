package org.acumen.training.codes.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Form Handling using Request Handler
@Controller
@RequestMapping("login/form.html")
public class LoginController {
	
	//Model
	//ModelMap
	//ModelAndView
	/*
	@RequestMapping(path = "/login/form.html", method = RequestMethod.GET)
	public String loginLoginForm(Model model) {
		String title= "SBC Login Form";
		String header = "New Login Form Page";
		//model.addAttribute("title", title);
		//model.addAttribute("headerx", header);
		Map<String, Object>attsMap = new HashMap<String, Object>();
		attsMap.put("title", title);
		attsMap.put("headerx", header);
		model.addAllAttributes(attsMap);
		return "loginForm";
	}
	@RequestMapping(path = "/login/result.html", method = RequestMethod.GET)
	public String loginLoginResult(ModelMap modelMap) {
		String title= "SBC Login Details";
		modelMap.put("title", title);
		return "loginResult";
	}
	*/
	@RequestMapping(method = RequestMethod.GET)
	public String loginLoginForm(Model model) {
		String title= "SBC Login Form";
		String header = "New Login Form Page";
		//model.addAttribute("title", title);
		//model.addAttribute("headerx", header);
		Map<String, Object>attsMap = new HashMap<String, Object>();
		attsMap.put("title", title);
		attsMap.put("headerx", header);
		model.addAllAttributes(attsMap);
		return "loginForm";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String loginLoginResult(ModelMap modelMap, 
				@RequestParam("username")String username, 
				@RequestParam("password") String password,
				@RequestParam("birthday") LocalDate birthday) {
		String title= "SBC Login Details";
		modelMap.put("title", title);
		modelMap.put("username", username);
		modelMap.put("password", password);
		modelMap.put("birthday", birthday);
		return "loginResult";
	}
	
}
