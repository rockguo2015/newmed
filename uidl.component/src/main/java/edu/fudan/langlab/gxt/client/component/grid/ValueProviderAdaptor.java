package edu.fudan.langlab.gxt.client.component.grid;

import com.sencha.gxt.core.client.ValueProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

public class ValueProviderAdaptor<T, V> implements ValueProvider<T, V> {
	private IObjectFieldAccessor<T, V> accessor;
	private String path;

	public ValueProviderAdaptor(IObjectFieldAccessor<T,V> accessor, String path){
		this.path = path;
		this.accessor = accessor;
	}
	@Override
	public V getValue(T object) {
		return accessor.getValue(object);
	}

	@Override
	public void setValue(T object, V value) {
		accessor.setValue(object, value);

	}

	@Override
	public String getPath() {
		return path;
	}

}
