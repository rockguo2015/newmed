package com.uniquesoft.gwt.client.common.widgets.valueprovider;

import java.util.Collection;

import com.google.common.collect.Lists;

/**
 * This class is used to manage the widget value changing.
 * Once the value has changed, it can call related methods to deal this change.
 *
 * @param <T>
 */
public class ValueChangedManager<T> {
	
	/**
	 * An interface to deal with the value changing
	 *
	 * @param <T>
	 */
	public interface ValueChangedListener<T> {
		void onValueChanged(T value);
	}

	Collection<ValueChangedListener<T>> listeners = Lists.newArrayList();

	/**
	 * Add a listener for a widget value. If this value has any change, it will 
	 * call the related method to update the widget or other widgets.
	 * @param listener
	 */
	public void addValueChangedListener(ValueChangedListener<T> listener) {
		listeners.add(listener);
	}

	/**
	 * Remove the value change listener
	 * @param listener
	 */
	public void removeValueChangedListener(ValueChangedListener<T> listener) {
		listeners.remove(listener);
	}

	/**
	 * Deal with all the value changes in this widget
	 * @param newValue  The current value of the widget, the widget value may have changed.
	 */
	public void fireValueChangedEvent(T newValue) {
		for (ValueChangedListener<T> listener : listeners) {
			listener.onValueChanged(newValue);
		}
	}
}
