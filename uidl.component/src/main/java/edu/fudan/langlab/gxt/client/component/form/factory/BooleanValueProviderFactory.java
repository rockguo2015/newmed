package edu.fudan.langlab.gxt.client.component.form.factory;

import java.util.List;

import com.google.gwt.editor.client.EditorError;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class BooleanValueProviderFactory {

	public static class TrueFalseReadonlyItem implements IValueViewer<Boolean> {

		private FieldLabel fieldLabel;
		private Label valueField;

		public TrueFalseReadonlyItem(String id, String title) {
			fieldLabel = new FieldLabel(valueField = new Label(), title);
		}

		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public IValueViewer<Boolean> setValue(Boolean value) {
			if (value) {
				valueField.setText("是");
			} else {
				valueField.setText("否");
			}
			return this;
		}
	}

	public static class CheckBoxItem implements IValueProvider<Boolean> {

		private CheckBox booleanField;
		private FieldLabel fieldLabel;

		public CheckBoxItem(String id, String title) {
			fieldLabel = new FieldLabel(booleanField = new CheckBox(), title);
			fieldLabel.getWidget().setWidth("50");
			fieldLabel.setWidth(120);
		}

		@Override
		public IValueViewer<Boolean> setValue(Boolean value) {
			if (value == null)
				booleanField.setValue(false);
			else
				booleanField.setValue(value);
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public Boolean getValue() {
			return booleanField.getValue();
		}

		@Override
		public void addValueChangedListener(
				final ValueChangedListener<Boolean> listener) {
			booleanField
					.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

						@Override
						public void onValueChange(
								ValueChangeEvent<Boolean> event) {
							listener.onValueChanged(event.getValue());

						}
					});

		}
	}

	@WidgetProvider(isDefault = true)
	public CheckBoxItem createAsCheckBoxItem(String id, String title) {
		return new CheckBoxItem(id, title);
	}

	@WidgetProvider
	public TrueFalseReadonlyItem createAsReadonlyItem(String id, String title) {
		TrueFalseReadonlyItem result = new TrueFalseReadonlyItem(id, title);
		return result;
	}

}
