package edu.fudan.langlab.gxt.client.component.form.factory;

import com.sencha.gxt.data.shared.LabelProvider;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;

public class LabelProviderAdaptor<T> implements LabelProvider<T> {
	private IObjectNameProvider nameProvider;

	public LabelProviderAdaptor(IObjectNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	@Override
	public String getLabel(T item) {
		return nameProvider.getName(item);
	}

}
