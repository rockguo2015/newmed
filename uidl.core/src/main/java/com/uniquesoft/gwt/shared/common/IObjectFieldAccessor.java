package com.uniquesoft.gwt.shared.common;

/**
 * Provide a way o get the value or set the value for an object
 *
 * @param <D> the object that we want to get the information about its field
 * @param <T> The field value that we want to set for the object
 */
public interface IObjectFieldAccessor<D, T> {
	
	/**
	 * @param object
	 * @return one field value of the object
	 */
	T getValue(D object);

	/**
	 * @param object
	 * @param value set the value for the object
	 */
	void setValue(D object, T value);
	
}