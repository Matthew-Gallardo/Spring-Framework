package org.acumen.training.codes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {

	@RequestMapping(path="/redirect/welcome.html", method = RequestMethod.GET)
	public String redirectWelcome(RedirectAttributes atts) {
		atts.addFlashAttribute("welcomeMsg", "Welcome to SBC!!");
		return"redirect:/app1/welcome.html";
	}
	@RequestMapping(path="/redirect/hello", method = RequestMethod.GET)
	public RedirectView redirectHello() {
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/mySpring/app1/hello");
		return redirect;
	}
}
