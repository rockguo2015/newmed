package com.uniquesoft.gwt.client.common;

public interface FormViewer<T> extends ViewerWithValidation {
	
	T getValue();

	void setValue(T value);
	
}
