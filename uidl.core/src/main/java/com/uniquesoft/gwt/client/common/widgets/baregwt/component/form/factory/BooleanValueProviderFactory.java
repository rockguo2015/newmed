package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

/**
 * This is a factory for Boolean type. For this type ,
 * we would create a CheckBox for UIDL language.
 *
 */

public class BooleanValueProviderFactory {
		public static class CheckBoxBooleanValueSelector implements
			IValueProvider<Boolean> {

		private ValueChangedManager<Boolean> valueChangedManager = new ValueChangedManager<Boolean>();

		private CheckBox checkbox;

		private GWTFormItem formItem;

		/**
		 * Create a GWTFormItem that contains a label and a checkbox
		 * @param id 
		 * @param title
		 */
		public CheckBoxBooleanValueSelector(String id, final String title) {
			checkbox = new CheckBox();
			formItem = new GWTFormItem() {

				@Override
				public Widget getLabelWidget() {
					return new Label(title);
				}

				@Override
				public Widget getValueWidget() {
					return checkbox;
				}
			};

			checkbox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

				@Override
				public void onValueChange(ValueChangeEvent<Boolean> event) {
					valueChangedManager.fireValueChangedEvent(event.getValue());

				}
			});
		}

		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider#getValue()
		 * Get the checkbox's value
		 */
		@Override
		public Boolean getValue() {
			return checkbox.getValue();
		}

		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer#setValue(java.lang.Object)
		 * Set the checkbox's value, selected or not. The default value is false.
		 */
		@Override
		public IValueProvider<Boolean> setValue(Boolean value) {

			if (value != null)
				checkbox.setValue(value);
			else
				checkbox.setValue(false);
			return this;
		}

		@Override
		public void addValueChangedListener(
				ValueChangedListener<Boolean> listener) {
			valueChangedManager.addValueChangedListener(listener);
		}

		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget#asWidget()
		 * Return the formItem as a widget to display on the page.
		 */
		@Override
		public GWTFormItem asWidget() {
			return formItem;
		}
	}

	@WidgetProvider(isDefault = true)
	public CheckBoxBooleanValueSelector createAsCheckBoxItem(String id,
			String title) {
		return new CheckBoxBooleanValueSelector(id, title);
	}
}
