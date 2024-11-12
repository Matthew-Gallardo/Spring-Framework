package org.acumen.training.codes.exception;

import java.util.InputMismatchException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public String errorIllegalArgument(IllegalArgumentException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "errorIllegalArgument";
    }

    @ExceptionHandler(value = InputMismatchException.class)
    public String errorInputMismatch(InputMismatchException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "errorInputMismatch";
    }

    @ExceptionHandler(value = NullPointerException.class)
    public String errorNullPointer(NullPointerException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "errorNullPointer";
    }
}
