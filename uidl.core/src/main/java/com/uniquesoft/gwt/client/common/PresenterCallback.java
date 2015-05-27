package com.uniquesoft.gwt.client.common;

public interface PresenterCallback<T extends Presenter<?>> {
	void initialized(T presenter);
}
