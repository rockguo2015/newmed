package com.uniquesoft.gwt.client.common.widgets.selector;

import java.util.Collection;

import com.google.common.collect.Lists;

/**
 * It is used for radio button or combo box. If the selection about the 
 * widgets have changed, notice the widget to do related work.
 *
 * @param <T>
 */
public class SelectionChangeManager<T> {
	public interface ValueChangedListener<T> {
		void onSelectionChanged(T value);
	}

	Collection<ValueChangedListener<T>> listeners = Lists.newArrayList();

	public void addSelectionChangedListener(ValueChangedListener<T> listener) {
		listeners.add(listener);
	}
	
	public void removeSelectionChangedListener(ValueChangedListener<T> listener){
		listeners.remove(listener);
	}

	public void fireSelectionChangedEvent(T newSelection) {
		for (ValueChangedListener<T> listener : listeners) {
			listener.onSelectionChanged(newSelection);
		}
	}
}
