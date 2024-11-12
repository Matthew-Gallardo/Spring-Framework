package org.sbc.training.codes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSbcController {

	@Autowired
	private String title;
	//services
	@ResponseBody // text plain result
	@RequestMapping(path = "/sbc/hello", method = RequestMethod.GET)
	public String printhelloWorld() {
		return "Bosssing sbc Musta Buhay buhay , %s".formatted(title);
	}

}
