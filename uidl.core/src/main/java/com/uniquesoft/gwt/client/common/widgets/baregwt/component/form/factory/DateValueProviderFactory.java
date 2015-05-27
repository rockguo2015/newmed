package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

/**
 * This is a factory for Data type
 *
 */
public class DateValueProviderFactory {
	/**
	 * Use a TextBox to show the Date's string value.
	 *
	 */
	public static final class ReadonlyDateItem implements IValueProvider<Date> {
		Date date = new Date();
		private TextBox dateItem;
		private GWTFormItem formItem;
		ReadonlyDateItem(String id,final String title){
			dateItem = new TextBox();
			dateItem.setEnabled(false);
			formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return dateItem;
				}

			};
		}
		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer#setValue(java.lang.Object)
		 * Format the Date to String and set the string in a textbox to show.
		 */
		@Override
		public IValueProvider<Date> setValue(Date value) {
			dateItem.setText(null);
			date = value;
			if (value != null)
				dateItem.setValue(DateTimeFormat.getFormat("MM/dd/yyyy")
						.format(value));
			return this;
		}

		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget#asWidget()
		 * return the GWTFormItem to show on the page
		 */
		@Override
		public GWTFormItem asWidget() {
			return formItem;
		}

		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider#getValue()
		 * get the textBox's value.
		 */
		@Override
		public Date getValue() {
			if (dateItem.getValue() != null) {
				return date;
			} else
				return null;
		}

		@Override
		public void addValueChangedListener(ValueChangedListener<Date> listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * It is used to show a Date value in a label.
	 *
	 */
	public static class DateItemBasedStringValueProvider implements
	IValueProvider<Date> {
		
		private GWTFormItem formItem;
		private DateLabel dateItem;
		/**
		 * Create a GWTFormItem that contains a title label and a date label.
		 * @param id
		 * @param title
		 */
		DateItemBasedStringValueProvider(String id,
				final String title){
			dateItem = new DateLabel();
				formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return dateItem;
				}

			};
		}
		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer#setValue(java.lang.Object)
		 * Set the content of the Date label.
		 */
		@Override
		public IValueProvider<Date> setValue(Date value) {
			dateItem.setValue(null);
			if (value != null) {
				dateItem.setValue(value);
			}
			return this;
		}

		@Override
		public GWTFormItem asWidget() {
			
			return formItem;
		}

		@Override
		public Date getValue() {
			
			return dateItem.getValue();
		}

		@Override
		public void addValueChangedListener(ValueChangedListener<Date> listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * There is a calendar inside the textbox, we can click one day to show it in the textbox.
	 *
	 */
	public static class DatePickerItem implements
							IValueProvider<Date> {
		private DateBox dateItem;
		private GWTFormItem formItem;
		
		/**
		 * Create a GWTFormItem contains a title label and a DateBox.
		 * @param id
		 * @param title
		 */
		DatePickerItem(String id,final String title){
			 DateTimeFormat dateFormat = DateTimeFormat.getLongDateFormat();
			 dateItem = new DateBox();
			 dateItem.setFormat(new DateBox.DefaultFormat(dateFormat));
			 formItem = new GWTFormItem() {
					Label label = new Label(title);

					@Override
					public Widget getLabelWidget() {
						return label;
					}

					@Override
					public Widget getValueWidget() {
						return dateItem;
					}

				};
		}
		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer#setValue(java.lang.Object)
		 * Set the Date picker's value to show.
		 */
		@Override
		public IValueProvider<Date> setValue(Date value) {
			
			dateItem.setValue(null);
			if (value != null) {
				dateItem.setValue(value);
			}
			return this;
		}

		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget#asWidget()
		 * return the  GWTFormItem 
		 */
		@Override
		public GWTFormItem asWidget() {
			
			return formItem;
		}

		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider#getValue()
		 * Get the DateBox's value
		 */
		@Override
		public Date getValue() {
			
			return dateItem.getValue();
		}

		@Override
		public void addValueChangedListener(ValueChangedListener<Date> listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	/**
	 * "DateItem" is the option name provided by UIDL to connect the datatype and DateItemBasedStringValueProvider
	 * @param id
	 * @param title
	 * @return create a DateItemBasedStringValueProvider
	 */
	@WidgetProvider()
	public DateItemBasedStringValueProvider createAsDateItem(String id,
			String title) {
		return new DateItemBasedStringValueProvider(id, title);
	}
	
	/**
	 * @param id
	 * @param title
	 * @return Create a ReadonlyDateItem
	 */
	@WidgetProvider
	public ReadonlyDateItem createAsReadonlyDateItem(final String id,
			final String title) {
		return new ReadonlyDateItem(id, title);
	}
	
	/**
	 * @param id
	 * @param title
	 * @return create a datePicker
	 */
	@WidgetProvider(isDefault = true)
	public DatePickerItem createAsDatePickerItem(String id,
			String title) {
		return new DatePickerItem(id, title);
	}
}