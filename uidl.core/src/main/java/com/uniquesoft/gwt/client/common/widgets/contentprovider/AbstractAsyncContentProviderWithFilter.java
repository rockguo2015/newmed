package com.uniquesoft.gwt.client.common.widgets.contentprovider;

import java.util.Collection;

import com.google.common.collect.Lists;
import com.uniquesoft.gwt.client.common.ServiceCallback;

/**
 * A content provider model. It can update the contents, add a filter to choose the contents that we needed,
 * load the contents from the server side asynchronously.
 *
 * @param <T>
 * @param <Filter>
 */
public abstract class AbstractAsyncContentProviderWithFilter<T, Filter> extends AbstractContentProvider<T>
		implements AsyncContentProviderWithFilter<T, Filter> {

	public abstract Filter createCriteria();
	
	Collection<T> contents = Lists.newArrayList();

	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider#getContents()
	 * Get the contents that have been provided for this component.
	 */
	@Override
	public Collection<T> getContents() {
		return contents;
	}

	abstract protected void doGetContent(Filter context,
			ServiceCallback<Collection<T>> callback);

	@Override
	public void loadContent(final Filter context,
			final ContentLoadedCallback callback) {
		doGetContent(context, new ServiceCallback<Collection<T>>() {
			@Override
			public void onSuccess(Collection<T> result) {
				contents = result;
				notifyContentChanged();
				callback.contentLoaded();
			}
		});
	}
}
