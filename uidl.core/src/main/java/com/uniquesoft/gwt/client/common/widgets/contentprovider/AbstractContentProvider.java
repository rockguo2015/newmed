package com.uniquesoft.gwt.client.common.widgets.contentprovider;

import java.util.Collection;

import com.google.common.collect.Lists;

/**
 * Abstract class. if any content has changed, it will 
 * notice the widget to update the content values. 
 *
 * @param <T>
 */
public abstract class AbstractContentProvider<T> implements ContentProvider<T> {

	private Collection<ContentProvider.ContentChangedListener> listeners = Lists
			.newArrayList();

	@Override
	public void addContentChangedListener(
			ContentProvider.ContentChangedListener contentChangedListener) {
		listeners.add(contentChangedListener);

	}

	/**
	 * Do some update work for each content that has changed its value.
	 */
	protected void notifyContentChanged() {
		for (ContentProvider.ContentChangedListener listener : listeners) {
			listener.onContentChanged();
		}
	}
}
