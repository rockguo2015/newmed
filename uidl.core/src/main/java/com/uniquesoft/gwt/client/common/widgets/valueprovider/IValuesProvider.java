package com.uniquesoft.gwt.client.common.widgets.valueprovider;

import java.util.Collection;

import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

/**
 * IValuesProvider represents a ui widget that can input/ouput a value collection from the the widget.
 *
 * @param <T>
 */
public interface IValuesProvider<T> extends IValuesViewer<T> {

	/**
	 * Get the multy-value widget's values
	 * @return
	 */
	Collection<T> getValue();

	/**
	 * When some values have changed, notice the related method to deal with them.
	 * @param listener 
	 */
	void addValueChangedListener(ValueChangedListener<Collection<T>> listener);

}
