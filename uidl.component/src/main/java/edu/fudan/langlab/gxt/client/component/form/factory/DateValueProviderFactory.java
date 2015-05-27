package edu.fudan.langlab.gxt.client.component.form.factory;

import java.util.Date;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.DateTimePropertyEditor;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TimeField;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class DateValueProviderFactory implements IInitializerSupport {

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	public static class DateItem implements IValueProvider<Date> {

		private FieldLabel fieldLabel;
		private DateField dateField = new DateField(new DateTimePropertyEditor(
				DateTimeFormat.getFormat("yyyy-MM-dd")));

		public DateItem(String id, String title, Boolean isRequired) {
			if(isRequired){
				fieldLabel = new FieldLabel(dateField);
				fieldLabel.setHTML(Forms.toRequiredTitle(title));
			}else
				fieldLabel = new FieldLabel(dateField, title);
		}

		@Override
		public IValueViewer<Date> setValue(Date value) {
			dateField.setValue(value);
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public Date getValue() {
			return dateField.getValue();
		}

		@Override
		public void addValueChangedListener(
				final ValueChangedListener<Date> listener) {
			dateField.addValueChangeHandler(new ValueChangeHandler<Date>() {

				@Override
				public void onValueChange(ValueChangeEvent<Date> event) {
					listener.onValueChanged(event.getValue());
				}
			});
		}
	}

	public static class TimeItem implements IValueProvider<Date> {

		private FieldLabel fieldLabel;
		private TimeField timeField = new TimeField();

		public TimeItem(String id, String title) {
			timeField.setFormat(DateTimeFormat.getFormat(PredefinedFormat.HOUR24_MINUTE));
			fieldLabel = new FieldLabel(timeField, title);
		}

		@Override
		public IValueViewer<Date> setValue(Date value) {
			timeField.setValue(value);
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public Date getValue() {
			return timeField.getValue();
		}

		@Override
		public void addValueChangedListener(
				final ValueChangedListener<Date> listener) {
			timeField.addValueChangeHandler(new ValueChangeHandler<Date>() {

				@Override
				public void onValueChange(ValueChangeEvent<Date> event) {
					listener.onValueChanged(event.getValue());
				}
			});
		}
	}

	@WidgetProvider(isDefault = true)
	public DateItem createAsDateItem(String id, String title) {
		return new DateItem(id, title,false);
	}
	@WidgetProvider
	public DateItem createAsRequiredDateItem(String id, String title) {
		return new DateItem(id, title,true);
	}

	public class DateReadonlyItem extends ReadonlyItem<Date> {
		public DateReadonlyItem(String id, String title) {
			super(id, title);
		}

		@Override
		protected String toString(Date value) {
			if (value != null)
				return DateTimeFormat.getFormat("yyyy-MM-dd").format(value);
			else
				return "";
		}
	}

	@WidgetProvider
	public DateReadonlyItem createAsReadonlyItem(String id, String title) {
		return new DateReadonlyItem(id, title);
	}

	@WidgetProvider
	public TimeItem createAsTimeItem(String id, String title) {
		return new TimeItem(id, title);
	}

	public class TimeReadonlyItem extends ReadonlyItem<Date> {
		public TimeReadonlyItem(String id, String title) {
			super(id, title);
		}

		@Override
		protected String toString(Date value) {
			if (value != null)
				return DateTimeFormat.getFormat(
						DateTimeFormat.PredefinedFormat.HOUR24_MINUTE).format(
						value);
			else
				return "";
		}
	}
	@WidgetProvider
	public TimeReadonlyItem createAsTimeReadonlyItem(String id, String title) {
		return new TimeReadonlyItem(id, title);
	}

}
