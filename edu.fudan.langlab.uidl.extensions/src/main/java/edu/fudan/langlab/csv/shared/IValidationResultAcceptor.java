package edu.fudan.langlab.csv.shared;

import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;

public interface IValidationResultAcceptor {
	void accept(ValidationErrorItem errorItem);
}
