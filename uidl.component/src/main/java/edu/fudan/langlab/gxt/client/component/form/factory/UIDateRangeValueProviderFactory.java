package edu.fudan.langlab.gxt.client.component.form.factory;

import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;

import edu.fudan.langlab.gxt.client.component.form.factory.daterange.DateRangeField;

public class UIDateRangeValueProviderFactory implements IInitializerSupport {

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	public static class DateRangeItem implements IValueProvider<UIDateRange> {

		private DateRangeField textField;
		private FieldLabel fieldLabel;

		public DateRangeItem(String id, String title, Boolean isRequired) {
			if (isRequired) {
				fieldLabel = new FieldLabel(textField = new DateRangeField());
				fieldLabel.setHTML(Forms.toRequiredTitle(title));
			} else
				fieldLabel = new FieldLabel(textField = new DateRangeField(),
						title);
		}

		@Override
		public IValueViewer<UIDateRange> setValue(UIDateRange value) {
			textField.setValue(value);
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public UIDateRange getValue() {
			return textField.getValue();
		}

		@Override
		public void addValueChangedListener(
				final ValueChangedListener<UIDateRange> listener) {
			textField.addValueChangedListener(listener);
		}
	}

	@WidgetProvider(isDefault = true)
	public DateRangeItem createAsDateRangeItem(String id, String title) {
		return new DateRangeItem(id, title, false);
	}

}
