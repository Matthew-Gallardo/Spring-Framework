package org.acumen.training.codes.controller;

import org.acumen.training.codes.editor.SpendingEditor;
import org.acumen.training.codes.model.form.SpendingForm;
import org.acumen.training.codes.validator.SpendingFormValidator;
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
@RequestMapping("/spending/form.html")
public class SpendingFormController {

    @Autowired
    private SpendingFormValidator spendingFormValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Double.class, new SpendingEditor());
        binder.setValidator(spendingFormValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("form3", new SpendingForm());
        return "spendingForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(@Validated @ModelAttribute("form3") SpendingForm form, 
    		BindingResult result, 
    		Model model) {
        if (result.hasErrors()) {
            return "spendingForm";
        }
        form.calculatePercentages();
        model.addAttribute("form", form);
        return "spendingResult";
    }
}
