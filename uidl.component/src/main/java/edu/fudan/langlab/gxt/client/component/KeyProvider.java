package edu.fudan.langlab.gxt.client.component;

import com.sencha.gxt.data.shared.ModelKeyProvider;

public class KeyProvider<T> implements ModelKeyProvider<T>{

	@Override
	public String getKey(T item) {
		return Integer.toString(item.hashCode());
	}

}
