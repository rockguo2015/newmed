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

public class FloatValueProviderFactory {
	@Inject
	RuntimeGinjector runtimeGinjector;
	
	public static class FloatItemBasedIntegerValueProvider implements
	IValueProvider<Float> {
		private TextBox floatItem;
		private GWTFormItem formItem;
		FloatItemBasedIntegerValueProvider(String id,
				final String title){
			floatItem = new TextBox();
			formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return floatItem;
				}

			};
		}
		@Override
		public IValueProvider<Float> setValue(Float value) {
			floatItem.setValue(value.toString());
			return this;
		}

		@Override
		public GWTFormItem asWidget() {
		
			return formItem;
		}

		public void clearValue() {
			floatItem.setText("");
		}
		@Override
		public Float getValue() {
			
			return Float.parseFloat((String) floatItem.getValue());
		}

		@Override
		public void addValueChangedListener(ValueChangedListener<Float> listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static class FloatReadonlyValueProvider extends ReadonlyValueProvider<Float>{

		public FloatReadonlyValueProvider(String id, String value,
				RuntimeGinjector runtimeGinjector) {
			super(id, value, runtimeGinjector);
		}
	}
	
	@WidgetProvider(isDefault = true)
	public FloatItemBasedIntegerValueProvider createAsFloatItem(String id,
			String title) {
		return new FloatItemBasedIntegerValueProvider(id, title);
	}
	
	@WidgetProvider(isReadonly = true)
	public FloatReadonlyValueProvider createAsReadonlyText(String id,
			String title) {
		return new FloatReadonlyValueProvider(id, title, runtimeGinjector);
	}
}