package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class IntegerValueProviderFactory {

	public static class IntegerItemBasedIntegerValueProvider implements
			IValueProvider<Integer> {

		private IntegerBox integerItem;
		private GWTFormItem formItem;

		public IntegerItemBasedIntegerValueProvider(String id,
				final String title) {
			integerItem = new IntegerBox();
			formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return integerItem;
				}

			};
		}

		@Override
		public Integer getValue() {
			return integerItem.getValue();
		}

		@Override
		public IValueProvider<Integer> setValue(Integer value) {
			integerItem.setValue(value);
			return this;
		}

		@Override
		public void addValueChangedListener(
				ValueChangedListener<Integer> listener) {
			// TODO Auto-generated method stub

		}

		@Override
		public GWTFormItem asWidget() {
			return formItem;
		}

		public void clearValue() {
			integerItem.setText("");
		}
	}

	@WidgetProvider(isDefault = true)
	public IntegerItemBasedIntegerValueProvider createAsIntegerItemAdaptor(
			String id, String title) {
		return new IntegerItemBasedIntegerValueProvider(id, title);
	}

}
