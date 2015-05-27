package com.uniquesoft.gwt.client.common.widgets.valueprovider;

import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;

/**
 * An interface that provide a method to set or get the contents
 *
 * @param <T>
 */
public interface ISelector<T> {
	
	/**
	 * Set the content provider that is used to provide the content.
	 * 
	 * @param provider {@link ContentProvider}
	 */
	void setContentProvider(ContentProvider<T> provider);
	
}
