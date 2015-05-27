package edu.fudan.langlab.csv.shared;

import com.uniquesoft.gwt.shared.validation.ValidationErrorItem;

public class DefaultFieldValidationResultAcceptor implements IFieldValidationResultAcceptor{

	private String key;
	private IValidationResultAcceptor collector;
	public DefaultFieldValidationResultAcceptor(String key,IValidationResultAcceptor collector){
		this.key = key;
		this.collector = collector;
	}
	@Override
	public void accept(String message) {
		collector.accept(new ValidationErrorItem(message,key));
		
	}
	
}