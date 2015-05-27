package com.uniquesoft.gwt.client.common.widgets.valueprovider;

/**
 * An interface that provide a method to set the widget value.
 * The widget has a single value.
 *
 * @param <T>
 */
public interface IValueViewer<T> extends ICanAsWidget {

	/**
	 * Set the value which will be displayed in the view
	 * 
	 * @param value the object to be passed to the viewer
	 * @return the Viewer
	 */
	IValueViewer<T> setValue(T value);

}
