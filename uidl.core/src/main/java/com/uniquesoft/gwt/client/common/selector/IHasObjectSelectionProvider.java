package com.uniquesoft.gwt.client.common.selector;

import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;

public interface IHasObjectSelectionProvider<T>{
	ObjectSelectionProvider<T> getSelectionProvider();
}
