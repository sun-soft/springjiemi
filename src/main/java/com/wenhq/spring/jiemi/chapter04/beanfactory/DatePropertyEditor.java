package com.wenhq.spring.jiemi.chapter04.beanfactory;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePropertyEditor extends PropertyEditorSupport{

	private String datePattern;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        LocalDate date= LocalDate.parse(text, formatter);
        Date d = Date.valueOf(date);
        this.setValue(d);
	}

	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	
	
}
