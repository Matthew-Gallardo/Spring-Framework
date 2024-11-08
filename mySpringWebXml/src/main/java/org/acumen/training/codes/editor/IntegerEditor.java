package org.acumen.training.codes.editor;

import java.beans.PropertyEditorSupport;

public class IntegerEditor extends PropertyEditorSupport{
	@Override
	public String getAsText() {
		return "0";
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Integer num = Integer.parseInt(text);
			setValue(num);
		} catch (Exception e) {
			setValue(-1);
		}
	}
	

}
