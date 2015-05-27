package com.uniquesoft.uidl.validation;

import java.util.Collection;

import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;

public interface IValidator<T> {
	
	public Collection<ValidationErrorItem> validate(T t);
	
}
