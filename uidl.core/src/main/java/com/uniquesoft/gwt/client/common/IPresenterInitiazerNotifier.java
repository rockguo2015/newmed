package com.uniquesoft.gwt.client.common;

import com.uniquesoft.gwt.client.common.Presenter;

public interface  IPresenterInitiazerNotifier<T extends Presenter<?>> {
	void done(T presenter);
}
