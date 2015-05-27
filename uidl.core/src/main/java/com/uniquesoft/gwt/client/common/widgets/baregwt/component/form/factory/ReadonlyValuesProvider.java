package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import java.util.Collection;

import javax.annotation.Nullable;

import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValuesViewer;

/**
 * It sets multy objects' values into a text box to display.
 *
 * @param <T>
 */
public class ReadonlyValuesProvider<T> implements IValuesViewer<T> {

	private TextBox textItem;
	private GWTFormItem formItem;
	IObjectNameProvider objectNameProvider;
	
	public ReadonlyValuesProvider(String id, final String value, RuntimeGinjector runtimeGinjector) {
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

	/* (non-Javadoc)
	 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValuesViewer#setValue(java.util.Collection)
	 * Make the name values of all the objects into a single string seperated by "," and then set it into the TextBox
	 */
	@Override
	public void setValue(Collection<T> value) {
		Iterable<String> names = Iterables.transform(value, new Function<T, String>() {

			@Override
			public String apply(@Nullable T input) {
				return objectNameProvider.getName(input);
			}
		});

		textItem.setValue(IteratorExtensions.join(names.iterator(),","));
		
	}
	
}