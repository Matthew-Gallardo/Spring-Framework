package org.acumen.training.codes.validator;

import org.acumen.training.codes.model.form.CalculatorForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CalculatorFormValidator implements Validator {

    private static final double MIN_VALUE = -1000000.00;
    private static final double MAX_VALUE = 1000000.00;
    

    @Override
    public boolean supports(Class<?> clazz) {
        return CalculatorForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CalculatorForm form = (CalculatorForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "operand1", "form.operand1.empty", "Operand 1 is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "operand2", "form.operand2.empty", "Operand 2 is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "operator", "form.operator.empty", "Operator is required.");

       
        if (form.getOperand1() == null) {
            errors.rejectValue("operand1", "form.operand1.invalid", "Invalid number for Operand 1.");
            
        } else {
            validateOperand(form.getOperand1(), "operand1", errors);
           
        }

        if (form.getOperand2() == null) {
            errors.rejectValue("operand2", "form.operand2.invalid", "Invalid number for Operand 2.");
        
        } else {
            validateOperand(form.getOperand2(), "operand2", errors);
          
        }
  
        if ("/".equals(form.getOperator()) && form.getOperand2() != null && form.getOperand2() == 0.0) {
            errors.rejectValue("operand2", "form.operand2.divisionByZero", "Cannot divide by zero.");
        }
    }

    private void validateOperand(Double operand, String fieldName, Errors errors) {
        if (operand < MIN_VALUE || operand > MAX_VALUE) {
            errors.rejectValue(fieldName, "form." + fieldName + ".outOfRange",
                    "Value must be between " + MIN_VALUE + " and " + MAX_VALUE + ".");
        }

        String[] parts = operand.toString().split("\\.");
        if (parts.length == 2 && parts[1].length() > 3) {
            errors.rejectValue(fieldName, "form." + fieldName + ".tooManyDecimals", 
                    "Operand must have at most 3 decimal places.");
        }
    }
}
