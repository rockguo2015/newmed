package com.uniquesoft.gwt.client.common.gin;

import com.google.gwt.inject.client.AbstractGinModule;
import com.uniquesoft.gwt.client.common.Presenter;
import com.uniquesoft.gwt.client.common.View;

/**
 *The UIDL presenter and view will be translated to three files: presenter, view and view impl,
 *here we bind them together. 
 *
 */
public abstract class UIDLBaseGinModule extends AbstractGinModule {
	public <T extends View> void bindPresenter(
			Class<? extends Presenter> presenter, Class<T> viewInterface,
			Class<? extends T> viewImpl) {
		bind(presenter);
		bind(viewInterface).to(viewImpl);
	}
}
