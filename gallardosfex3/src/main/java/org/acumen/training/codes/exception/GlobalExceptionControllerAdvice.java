package org.acumen.training.codes.exception;

import java.util.InputMismatchException;

import org.springframework.beans.TypeMismatchException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public String handleIllegalArgument(IllegalArgumentException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "errorIllegalArgument"; 
    }

    @ExceptionHandler(value = NullPointerException.class)
    public String handleNullPointer(NullPointerException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "errorNullPointer"; 
    }

    @ExceptionHandler(value = InputMismatchException.class)
    public String handleInputMismatch(InputMismatchException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "inputMismatch"; 
    }
    
    @ExceptionHandler(value = ISBNLimitException.class)
    public String handleIsbnLimit(ISBNLimitException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "errorLimit"; 
    }

    @ExceptionHandler(value = TypeMismatchException.class)
    public String handleTypeMismatch(TypeMismatchException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "typeMismatch"; 
    }

    @ExceptionHandler(value = Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        model.addAttribute("message", "An unexpected error occurred:" + ex.getMessage());
        return "errorGeneral"; 
    }
}
