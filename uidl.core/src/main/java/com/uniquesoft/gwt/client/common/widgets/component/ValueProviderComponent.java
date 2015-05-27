package com.uniquesoft.gwt.client.common.widgets.component;

import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

/**
 * A basic component implementation that integrate the value operation methods
 * for the value.
 *
 * @param <T> the data type of value
 */
public abstract class ValueProviderComponent<T> extends BaseComponent<T>
		implements IValueProvider<T> {

	public void addValueChangedListener(ValueChangedListener<T> listener) {

	}

	/**
	 * Create a new object in the server side and then set the client side value into the new object
	 * @return the server side  component
	 */
	public abstract T getValueAsNew();

	/**
	 * Server side has the related object for the client side object, we just need to update the 
	 * server side object.
	 * @param copyValue
	 * @return the server side component
	 */
	public abstract T getValue(T copyValue);


	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider#getValue()
	 * get the client side component value 
	 */
	@Override
	public T getValue() {
		return doGetValue();
	}

	protected abstract T doGetValue();

	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget#asWidget()
	 * OverLoad this method for special component
	 */
	public Object asWidget() {
		return null;
	}
}
