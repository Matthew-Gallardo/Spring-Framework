package org.acumen.training.codes.validator;

import java.time.LocalDate;

import org.acumen.training.codes.model.form.ProfileForm;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProfileFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ProfileForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProfileForm form = (ProfileForm) target;
		// Checking whitespaces
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "form.id.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname", "form.fullname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "form.salary.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "form.birthday.empty");
		
		//Custom validation with error messages
		if (form.getBirthday().isBefore(LocalDate.of(1950, 1, 1))|| 
			form.getBirthday().equals(LocalDate.of(1950, 1, 1))){
			errors.rejectValue("birthday", "form.birthday.invalid");
		}
		
		if (form.getId() <= 0) {
			errors.rejectValue("id", "form.id.invalid");
		}
		
		if (form.getSalary() <= -1){
			errors.rejectValue("salary", "form.salary.invalid");
		}
		
		
		
	}

}
