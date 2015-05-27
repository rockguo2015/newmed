package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;

/**
 *Make the TextBox to show the string value, but cannot be edited on the page.
 *
 * @param <T>
 */
public class ReadonlyValueProvider<T> implements IValueViewer<T>{

	private TextBox textItem;
	private GWTFormItem formItem;
	IObjectNameProvider objectNameProvider;
	public ReadonlyValueProvider(String id, final String value,RuntimeGinjector runtimeGinjector){
		textItem = new TextBox();
		textItem.setEnabled(false);
		objectNameProvider = runtimeGinjector.getObjectNameProvider();
		formItem = new GWTFormItem() {
			Label label = new Label(value);

			@Override
			public Widget getLabelWidget() {
				return label;
			}

			@Override
			public Widget getValueWidget() {
				return textItem;
			}

		};
	}
	@Override
	public GWTFormItem asWidget() {
		
		return formItem;
	}

	@Override
	public IValueViewer<T> setValue(T value) {
		textItem.setValue(objectNameProvider.getName(value));
		return this;
	}
	
}