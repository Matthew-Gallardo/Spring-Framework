package org.acumen.training.codes.editor;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;

public class BirthdayEditor extends PropertyEditorSupport{
	@Override
	public String getAsText() {
		return LocalDate.now().toString();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			LocalDate bday= LocalDate.parse(text);
			setValue(bday);
		} catch (Exception e) {
			setValue(LocalDate.now());
		}
		
		
		
		
	}
}
