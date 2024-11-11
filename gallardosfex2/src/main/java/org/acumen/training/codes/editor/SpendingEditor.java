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

			if (cleanedText.isEmpty() || cleanedText.equalsIgnoreCase("none")) {
				setValue(0.0);
				return;
			}
			Double value = Double.parseDouble(cleanedText);
			setValue(value <= 0.0 ? 0.0 : value);
		} catch (NumberFormatException e) {
			setValue(-1.0);
		}
	}
}
