package edu.fudan.langlab.gxt.client.component.form.factory;

import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;

public class KeyProviderAdaptor<T> implements ModelKeyProvider<T> {

	private IObjectNameProvider nameProvider;
	public KeyProviderAdaptor(IObjectNameProvider nameProvider){
		this.nameProvider = nameProvider;
	}
	@Override
	public String getKey(T item) {
		return nameProvider.getId(item);
	}

}
