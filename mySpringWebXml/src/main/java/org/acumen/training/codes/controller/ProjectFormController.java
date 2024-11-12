package org.acumen.training.codes.controller;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.acumen.training.codes.model.data.Project;
import org.acumen.training.codes.model.form.ProjectForm;
import org.acumen.training.codes.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hrms/project/form.html")
public class ProjectFormController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		
		ProjectForm projectForm = new ProjectForm();
		
		model.addAttribute("projForm", projectForm);
		return"projectForm";
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, 
	        @ModelAttribute("projForm") ProjectForm projectForm) {
	    
	    
	    if (projectForm.getProjectname() == null || projectForm.getProjectname().isEmpty()) {
	        throw new NullPointerException("Project name cannot be empty");
	    }
	    if (projectForm.getProjectdate() == null) {
	    	throw new NullPointerException("Project date cannot be empty");
	    }
	   
	    if (projectForm.getId() == null) {
	    	throw new NullPointerException("Project Id cannot be empty");
	    }


	    if (projectForm.getProjectdate().isBefore(LocalDate.now())) {
	        throw new IllegalArgumentException("Project date cannot be before today");
	    }

	    
	    projectService.insertRecord(projectForm);

	   
	    List<Project> recs = projectService.retrieveAll();
	    model.addAttribute("recs", recs);

	   
	    return "projectResult";
	}


	
	//Type1: Localized exception Handler
	@ExceptionHandler(value = NullPointerException.class)
	public String errorNullPointerSubmitForm(Model model) {
		String message = "Empty project name.";
		model.addAttribute("message", message);
		return "errorNullPointer";
	}

}
