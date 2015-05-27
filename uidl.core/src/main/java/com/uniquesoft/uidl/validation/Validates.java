package com.uniquesoft.uidl.validation;

import com.google.common.collect.Lists;
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;

public class Validates {
	public static <T> void validateWith(T obj, IValidator<T> validator) {
		java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = validator
				.validate(obj);
		if (errors.size() != 0)
			throw new com.uniquesoft.gwt.shared.validation.ValidationException(
					errors);

	}

	public static void reportSingleError(String id, String message) {
		java.util.Collection<com.uniquesoft.gwt.shared.validation.ValidationErrorItem> errors = Lists
				.newArrayList();
		errors.add(new ValidationErrorItem(message, id));
		throw new com.uniquesoft.gwt.shared.validation.ValidationException(
				errors);

	}
	public static void Assert(boolean value,String id, String message) {
		if(value) return;
			reportSingleError(id, message);		
	}

	public static void Assert(boolean value, String message) {
		if (!value)
			reportSingleError("", message);
	}
}
