package edu.fudan.langlab.gxt.client.component.form.factory;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.form.AdapterField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public abstract class ReadonlyItem<T> implements IValueProvider<T> {
	private HTML content;
	private FieldLabel fieldLabel;
	private T value;
	
	public ReadonlyItem(String id, String title){
		
		AdapterField<T> field = new AdapterField<T>(
				content = new HTML()) {

			@Override
			public void setValue(T value) {

				ReadonlyItem.this.setValue(value);
			}

			@Override
			public T getValue() {
				return ReadonlyItem.this.getValue();
			}
		};
		
		fieldLabel = new FieldLabel(field,title);
	}

	@Override
	public IValueViewer<T> setValue(T value) {
		this.value = value;
		content.setHTML("<i><u>"+toString(value)+"</u></i>");
		return this;
	}

	@Override
	public void addValueChangedListener(ValueChangedListener<T> listener) {
		
	}
	@Override
	public T getValue() {
		return value;
	}
	protected abstract String toString(T value);

	@Override
	public FieldLabel asWidget() {
		
		return fieldLabel;
	}
}