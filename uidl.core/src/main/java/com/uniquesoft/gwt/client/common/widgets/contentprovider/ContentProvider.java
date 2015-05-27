package com.uniquesoft.gwt.client.common.widgets.contentprovider;

import java.util.Collection;

/**
 * In interface provided the contents for a widget. For example, a ListGrid is 
 * used to list all the employ information for a company, then we use content provider to give all 
 * the company's employee data to the ListGrid.
 *
 * @param <T>
 */
public interface ContentProvider<T> {

	/**
	 * An interface to notice the widget that its contents has changed, then it can update
	 * the contents for the widget 
	 *
	 */
	public interface ContentChangedListener {

		void onContentChanged();

	}

	/**
	 * Get all the provided contents
	 * @return the provided contents
	 */
	Collection<T> getContents();
	
	/**
	 * If the one item of contents has changed, notice the widget to do update
	 * @param contentChangedListener
	 */
	void addContentChangedListener(ContentChangedListener contentChangedListener);

}