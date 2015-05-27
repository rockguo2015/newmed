package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class DoubleValueProviderFactory {
	@Inject
	RuntimeGinjector runtimeGinjector;
	
	public static class DoubleItemBasedStringValueProvider implements
	IValueProvider<Double> {

		private TextBox doubleItem;
		private GWTFormItem formItem;
		DoubleItemBasedStringValueProvider(String id, final String title){
			doubleItem = new TextBox();
			formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return doubleItem;
				}

			};
		}
		@Override
		public IValueProvider<Double> setValue(Double value) {
			doubleItem.setValue(value.toString());
			return this;
		}

		@Override
		public GWTFormItem asWidget() {
			
			return formItem;
		}

		@Override
		public Double getValue() {
			
			return Double.parseDouble((String) doubleItem.getValue());
		}

		@Override
		public void addValueChangedListener(
				ValueChangedListener<Double> listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static class DoubleReadonlyValueProvider extends ReadonlyValueProvider<Double>{

		public DoubleReadonlyValueProvider(String id, String value,
				RuntimeGinjector runtimeGinjector) {
			super(id, value, runtimeGinjector);
			}
		
	}
	@WidgetProvider(isDefault = true)
	public DoubleItemBasedStringValueProvider createAsDoubleItem(String id,
			String title) {
		return new DoubleItemBasedStringValueProvider(id, title);
	}
	
	@WidgetProvider(isReadonly = true)
	public <T> DoubleReadonlyValueProvider createAsReadonlyText(String id,
			String title) {
		return new DoubleReadonlyValueProvider(id, title, runtimeGinjector);
	}
}