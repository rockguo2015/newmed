package com.uniquesoft.gwt.client.common.widgets.component;

import java.util.ArrayList;
import java.util.Collection;

import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;

/**
 * Inherit from the Component class, the difference is that it
 * allows to set many valueUpdatedListener, so we can monitor several 
 * different item widgets. If any of them has changed, update the component value.
 *
 * @param <T>
 */
public abstract class BaseComponent<T> implements Component<T> {

	Collection<ValueUpdatedListener<T>> valueUpdateListeners = new ArrayList<ValueUpdatedListener<T>>();

	@Override
	public void addValueUpdatedListener(
			ValueUpdatedListener<T> valueUpdatedListener) {
		valueUpdateListeners.add(valueUpdatedListener);
	}
	
	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.client.common.widgets.component.Component#valueUpdated(java.lang.Object)
	 * Update all the items if their values habe changed
	 */
	@Override
	public void valueUpdated(T newValue) {
		for(ValueUpdatedListener<T> listener : valueUpdateListeners){
			listener.valueUpdated(newValue);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer#setValue(java.lang.Object)
	 * Set all the items' value for this component
	 */
	@Override
	public IValueViewer<T> setValue(T value) {
		return doSetValue(value);
	}
	
	public void initializeComponent(){
		
	}
	/**
	 * get all the fields in this component
	 * @return a collection about all the fields in the component.
	 */
	public abstract Iterable<ICanAsWidget> getAllProperties();
	
	protected abstract IValueViewer<T> doSetValue(T value);
	
}
