package org.acumen.training.codes.editor;

import java.beans.PropertyEditorSupport;
import java.text.DecimalFormat;

public class SpendingEditor extends PropertyEditorSupport {
    private static final DecimalFormat formatter = new DecimalFormat("$0.00");

    @Override
    public String getAsText() {
        Double value = (Double) getValue();
        return value == null || value < 0 ? "$0.00" : formatter.format(value);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            String cleanedText = text.replace("$", "").trim();
            Double value = Double.parseDouble(cleanedText);
            // Only set -1 if the value is negative; accept zero and positive values
            setValue(value < 0.0 ? -1.0 : value); 
        } catch (Exception e) {
            setValue(-1.0);
        }
    }
}
