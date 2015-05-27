package com.uniquesoft.gwt.client.common;

import java.util.Collection;

import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;

/**
 * Add validation mechanism for the view.
 * 
 *
 */
public interface ViewerWithValidation extends Viewer {

	/**
	 * @param errors all the validation errors that the view has appeared
	 */
	void showValidationErrors(Collection<ValidationErrorItem> errors);
}
