package org.acumen.training.codes.validator;

import org.acumen.training.codes.model.form.SpendingForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SpendingFormValidator implements Validator {

    private static final double MIN_VALUE = 0.0;
    private static final double MAX_VALUE = 1000000.0;  
    private static final double INVALID_VALUE = -1.0;  

    @Override
    public boolean supports(Class<?> clazz) {
        return SpendingForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SpendingForm form = (SpendingForm) target;

       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "food", "form.food.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clothing", "form.clothing.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "entertainment", "form.entertainment.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rent", "form.rent.empty");

        
        validateAmount(form.getFood(), "food", errors);
        validateAmount(form.getClothing(), "clothing", errors);
        validateAmount(form.getEntertainment(), "entertainment", errors);
        validateAmount(form.getRent(), "rent", errors);
    }

    private void validateAmount(Double amount, String field, Errors errors) {
        if (amount == null || amount == INVALID_VALUE) {
            errors.rejectValue(field, "form." + field + ".invalid");
            return;
        }

        if (amount < MIN_VALUE || amount > MAX_VALUE) {
            errors.rejectValue(field, "form." + field + ".outOfRange");
            return;
        }

        String amountStr = amount.toString();
        int decimalIndex = amountStr.indexOf('.');
        if (decimalIndex >= 0 && amountStr.length() - decimalIndex - 1 > 2) {
            errors.rejectValue(field, "form." + field + ".tooManyDecimals");
        }
    }
}
