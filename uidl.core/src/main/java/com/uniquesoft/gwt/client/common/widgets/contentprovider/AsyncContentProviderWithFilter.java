package com.uniquesoft.gwt.client.common.widgets.contentprovider;


/**
 * Provider a method that can filter the contents, and the contents are loaded asynchronously. 
 *
 * @param <T>
 * @param <Filter> criteria that filters the contents
 */
public interface AsyncContentProviderWithFilter<T, Filter> extends
		ContentProvider<T> {
	Filter createCriteria();
	/**
	 * @param context criteria principles to filter the contents
	 * @param callback when all the contents have been loaded according to the filter, call the callback to send a notice.
	 */
	void loadContent(Filter context, ContentLoadedCallback callback);

}
