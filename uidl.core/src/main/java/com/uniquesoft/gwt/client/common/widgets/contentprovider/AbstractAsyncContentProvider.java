package com.uniquesoft.gwt.client.common.widgets.contentprovider;

import java.util.Collection;

import com.google.common.collect.Lists;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;

public abstract class AbstractAsyncContentProvider<T> extends
		AbstractContentProvider<T> implements AsyncContentProvider<T>,
		IInitializerSupport {

	Collection<T> contents = Lists.newArrayList();

	@Override
	public Collection<T> getContents() {
		return contents;
	}

	abstract protected void doGetContent(ServiceCallback<Collection<T>> callback);

	public void loadContent() {
		doGetContent(new ServiceCallback<Collection<T>>() {
			@Override
			public void onSuccess(Collection<T> result) {
				contents = result;
				notifyContentChanged();
			}
		});
	}

//	IAsyncInitializerSupport postInitializer;
//
//	public void setNextInitializer(IAsyncInitializerSupport postInitializer) {
//		this.postInitializer = postInitializer;
//	}
//
//	public IAsyncInitializerSupport getNextInitializer() {
//		return postInitializer;
//	}

	public void initialize(final IPostInitializeAction postAction) {
		doGetContent(new ServiceCallback<Collection<T>>() {
			@Override
			public void onSuccess(Collection<T> result) {
				contents = result;
				notifyContentChanged();
				if(postAction!=null)
					postAction.initializeFinished(null);
			}
		});
	}

//	public void initialize(final IAsyncInitializerSupport nextInitializer) {
//		doGetContent(new ServiceCallback<Collection<T>>() {
//			@Override
//			public void onSuccess(Collection<T> result) {
//				contents = result;
//				nextInitializer.initialize();
//				notifyContentChanged();
//			}
//		});
//	}

}
