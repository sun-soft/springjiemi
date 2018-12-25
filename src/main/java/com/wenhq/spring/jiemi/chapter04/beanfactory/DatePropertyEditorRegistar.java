package com.wenhq.spring.jiemi.chapter04.beanfactory;

import java.beans.PropertyEditor;
import java.sql.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class DatePropertyEditorRegistar implements PropertyEditorRegistrar{
	private PropertyEditor propertyEditor;

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, propertyEditor);
	}

	public PropertyEditor getPropertyEditor() {
		return propertyEditor;
	}

	public void setPropertyEditor(PropertyEditor propertyEditor) {
		this.propertyEditor = propertyEditor;
	}

}
