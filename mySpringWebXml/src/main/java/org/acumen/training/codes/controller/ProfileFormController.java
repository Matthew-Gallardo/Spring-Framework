package org.acumen.training.codes.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.acumen.training.codes.editor.BirthdayEditor;
import org.acumen.training.codes.editor.DoubleEditor;
import org.acumen.training.codes.editor.IntegerEditor;
import org.acumen.training.codes.model.data.Project;
import org.acumen.training.codes.model.form.ProfileForm;
import org.acumen.training.codes.validator.ProfileFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.enterprise.inject.build.compatible.spi.Validation;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/profile/form.html")
//@SessionAttributes(names = {"optColor"})
public class ProfileFormController {
	
	
	@Autowired
	private ProfileFormValidator profileFormValidator;
	
	@Qualifier("project1")
	@Autowired
	private Project project1;
	
	@Qualifier("project2")
	@Autowired
	private Project project2;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, "birthday", new BirthdayEditor());
		binder.registerCustomEditor(Integer.class, new IntegerEditor());
		binder.registerCustomEditor(Double.class, new DoubleEditor());
		binder.setValidator(profileFormValidator);
	}
	
	//@ModelAttribute (name = "optGender")
	public Map<String, String> optGender()
	{
		Map<String, String> gender = new HashMap<>();	
		gender.put("male", "MALE");
		gender.put("female", "FEMALE");
		gender.put("other", "OTHER");
		return gender;
	}
	//@ModelAttribute("optColor")
	public Map<String, String> optColor(){
		Map<String, String> color = new HashMap<>();	
		color.put("red", "RED");
		color.put("blue", "BLUE");
		color.put("yellow", "YELLOW");
		return color;
	}
	
	@ModelAttribute("optFood")
	public Map<String, String> optFood(){
		Map<String, String> food = new HashMap<>();	
		food.put("siopao", "SIOPAO");
		food.put("siomai", "SIOMAI");
		food.put("suman", "SUMAN");
		return food;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadFormPage(Model model) {
		ProfileForm form1 = new ProfileForm();
		model.addAttribute("form1", form1);
		return"profileForm";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitFormPage(Model model, 
			@Validated @ModelAttribute("form1")ProfileForm form, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("form1", form);
			return"profileForm";
		}
		System.out.println(project1.hashCode());
		System.out.println(project2.hashCode());
		model.addAttribute("form", form);
		
		return"profileResult";
	}

}
