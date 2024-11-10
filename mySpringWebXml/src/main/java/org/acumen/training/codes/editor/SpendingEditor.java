package org.acumen.training.codes.editor;

import java.beans.PropertyEditorSupport;

public class SpendingEditor extends PropertyEditorSupport {
	@Override
	public String getAsText() {
		return "0.0";
	}

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Double value = Double.parseDouble(text);
            setValue(value < 0 ? -1 : value); // Set -1 if value is invalid
        } catch (Exception e) {
            setValue(-1.0); 
        }
    }
}
