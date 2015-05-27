package edu.fudan.langlab.gxt.client.widget;

import com.sencha.gxt.data.shared.Store;

public interface IHasStoreComponent<T> {
	Store<T> getStore();
}
