package org.acumen.training.codes.controller;

import java.util.HashMap;
import java.util.Map;

import org.acumen.training.codes.editor.CalculatorEditor;
import org.acumen.training.codes.model.form.CalculatorForm;
import org.acumen.training.codes.validator.CalculatorFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/calculator/form.html")
public class CalculatorFormController {
	
	@Autowired
	private CalculatorFormValidator calculatorFormValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Double.class, new CalculatorEditor());
		binder.setValidator(calculatorFormValidator);
		
	
	}

	
	@ModelAttribute("optOperator")
	public Map<String, String> optOperator(){
		Map<String, String> operator = new HashMap<>();	
		operator.put("+", "+");
		operator.put("-", "-");
		operator.put("/", "/");
		operator.put("*", "*");
		return operator;
		
		
	}
	@RequestMapping(method = RequestMethod.GET)
	public String loadFormPage(Model model) {
		CalculatorForm form1 = new CalculatorForm();
		model.addAttribute("form2", form1);
		
		return"calculatorForm";
		
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitFormPage(Model model, 
			@Validated @ModelAttribute("form2")CalculatorForm form, 
			BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("form2", form);
			return"calculatorForm";
		}
		form.calculate();
		model.addAttribute("form", form);
		return"calculatorResult";
	}
}
