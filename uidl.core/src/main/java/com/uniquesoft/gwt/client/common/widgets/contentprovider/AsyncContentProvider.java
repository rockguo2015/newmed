package com.uniquesoft.gwt.client.common.widgets.contentprovider;

/**
 * An interface that providers the contents asynchronously .
 *
 * @param <T>
 */
public interface AsyncContentProvider<T> extends ContentProvider<T> {
	void loadContent();

}
