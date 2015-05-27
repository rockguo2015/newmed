package com.uniquesoft.gwt.client.common.widgets.valueprovider;

import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

/**
 * IValueProvider represents a ui widget that can input/ouput certain type of value.
 * 
 * @author ztiange
 *
 * @param <T>
 */
public interface IValueProvider<T> extends IValueViewer<T>{
	/**
	 * 
	 * @return the target value
	 */
	T getValue();

	/**
	 * Register the listener to the viewer
	 * 
	 * @param listener the action when value changed
	 */
	void addValueChangedListener(ValueChangedListener<T> listener);

}
