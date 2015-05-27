package com.uniquesoft.gwt.shared.restful;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.user.client.rpc.AsyncCallback;

public abstract class BaseRequestCallback<T> implements RequestCallback {
	protected AsyncCallback<T> callback;
	public BaseRequestCallback(AsyncCallback<T> callback){
		this.callback = callback;
	}
	@Override
	public void onError(Request request, Throwable exception) {
		callback.onFailure(exception);

	}

}
