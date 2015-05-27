package edu.fudan.langlab.gxt.client.component.form.factory;

import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class ComponentDelegateValueProvider<T> implements IValueProvider<T>{

	
	private IValueProvider<T> valueProvider;

	ComponentDelegateValueProvider(IValueProvider<T> valueProvider){
		this.valueProvider = valueProvider;
	}
	@Override
	public IValueViewer<T> setValue(T value) {
		return valueProvider.setValue(value);
	}

	@Override
	public Object asWidget() {
		return valueProvider.asWidget();
	}

	@Override
	public T getValue() {
		return valueProvider.getValue();
	}

	@Override
	public void addValueChangedListener(ValueChangedListener<T> listener) {
		valueProvider.addValueChangedListener(listener);
	}
	
	public IValueProvider<T> getDeletate(){
		return valueProvider;
	}

}
