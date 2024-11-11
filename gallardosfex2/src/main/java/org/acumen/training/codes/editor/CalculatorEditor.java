package org.acumen.training.codes.editor;

import java.beans.PropertyEditorSupport;

public class CalculatorEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString() : "0.0";
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Double num = Double.parseDouble(text);
            setValue(num);
        } catch (Exception e) {
            setValue(null);  
        }
    }
}
