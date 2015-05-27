package com.uniquesoft.gwt.shared.validation;

import java.util.ArrayList;
import java.util.Collection;

import com.google.common.collect.Iterables;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Record all the validation errors about the UIDL code.
 * If the error item collection size is not zero ,means there is an error. 
 *
 */
public class ValidationException extends RuntimeException implements IsSerializable {

	private static final long serialVersionUID = 1L;

	private Collection<ValidationErrorItem> errors = new ArrayList<ValidationErrorItem>();

	/**
	 * Create a validation exception collection
	 * @param validateErrorList
	 */
	public ValidationException(Collection<ValidationErrorItem> validateErrorList) {
		this.errors = validateErrorList;
	}

	public ValidationException() {
		
	}

	/**
	 * @return all the error Items 
	 */
	public Collection<ValidationErrorItem> getErrors() {
		return errors;
	}

	/** Record the error that the code has discovered.
	 * @param checkError a kind of validation error.
	 */
	public void addCheckError(ValidationErrorItem checkError) {
		errors.add(checkError);
	}

	/**
	 * @return true means it still has error
	 */
	public boolean hasErrors() {
		return errors.size() != 0;
	}
	
	@Override
	public String getMessage() {
		return toString();
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(ValidationErrorItem item : errors){
			sb.append(item.getMessage());
			sb.append("\r\n");
		}
		return sb.toString();
	}
}
