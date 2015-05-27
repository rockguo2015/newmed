package com.uniquesoft.gwt.client.common.widgets.valueprovider;

import java.util.Collection;

/**
 * This interface providers a method to set the value for a multy-value widget.
 * 
 * @param <T>
 */
public interface IValuesViewer<T> extends ICanAsWidget{

	/**
	 * @param value a group of value to be set into the widget
	 */
	void setValue(Collection<T> value);

}
