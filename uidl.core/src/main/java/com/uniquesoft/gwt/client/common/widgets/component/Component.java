package com.uniquesoft.gwt.client.common.widgets.component;

import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;

/**
 * UI Component that can show value of type T
 * 
 * @author ztg
 * 
 * @param <T>
 */
public interface Component<T> extends IValueViewer<T>, IInitializerSupport {

	/**
	 * If the component value has changed, call the  valueUpdated method to update it
	 *
	 * @param <T>
	 */
	public interface ValueUpdatedListener<T> {
		void valueUpdated(T value);
	}

	/**
	 * @param valueUpdatedListener
	 * Add a value updated listener forthe component
	 */
	void addValueUpdatedListener(ValueUpdatedListener<T> valueUpdatedListener);
	
	/**
	 * Set the new value for the component
	 * @param newValue
	 */
	void valueUpdated(T newValue);

	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.client.common.async.IInitializerSupport#initialize(com.uniquesoft.gwt.client.common.async.IPostInitializeAction)
	 * Initialize the items in this component, it may get some data from the server side. When all the data has been prepared, it can be shown.
	 */
	void initialize(IPostInitializeAction handler);

}
