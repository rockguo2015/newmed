package com.uniquesoft.gwt.client.common.widgets;

import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.widgets.component.Component;

/**
 * An interface for ListView that provides methods to operate the contents in it.
 *
 * @param <T>
 */
public interface ObjectListView<T> extends ObjectSelectionProvider<T> {

	/**
	 * @param result the items of the widget
	 */
	void setObjects(Iterable<T> result);

	/**
	 * @return the item collection
	 */
	Iterable<T> getObjects();

	/**
	 * Care about whether the contents of the widget has changed.
	 * @param listener
	 */
	void addContentChangedListener(ContentChangedListener<T> listener);

	/**
	 * Pay attention to the widget whether some selections have changed.
	 * @param listener
	 */
	void addSelectEntityListener(SelectEntityListener<T> listener);

	void setComponentProvider(Provider<? extends Component<T>> componentProvider);

	public interface ContentChangedListener<VT> {
		void contentChanged(Iterable<VT> contents);
	}

	public interface SelectEntityListener<VT> {
		void objectSelected(VT selected);
	}
	
	/**
	 * Add element to the listView
	 * @param uientity
	 */
	public void addElement(T uientity);
		
	public void removeElement(T uientity);

}
