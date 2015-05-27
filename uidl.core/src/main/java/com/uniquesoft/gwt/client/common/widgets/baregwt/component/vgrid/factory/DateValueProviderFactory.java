package com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory;

import java.util.Date;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.DatePickerCell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.GWTGridRow;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * A factory to generate the row item with type {@link Date}.
 *
 */
public class DateValueProviderFactory implements IInitializerSupport {
	
	/**
	 * Read-only date text
	 * 
	 *
	 * @param <D> the data type the object binding with the grid
	 */
	public static class DateRow<D> extends GWTGridRow<D, Date, Date> {

		/**
		 * Construct the DateRow with a given {@code title}, {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of row
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public DateRow(String id, String title,
				IObjectFieldAccessor<D, Date> objectValues) {
			super(title);
			initRow(objectValues);
		}

		@Override
		public Cell<Date> createCell() {
			DateTimeFormat dateFormat = DateTimeFormat.getFormat(PredefinedFormat.DATE_MEDIUM);
			return new DateCell(dateFormat);
		}
	}

	/**
	 * Date text with date picker
	 * 
	 * @author hugolin
	 *
	 * @param <D> the data type the object binded with the grid
	 */
	public static class DatePickerRow<D> extends GWTGridRow<D, Date, Date> {

		IObjectFieldAccessor<D, Date> objectValues;

		/**
		 * Construct the DatePickerRow with a given {@code title}, {@link IObjectFieldAccessor}.
		 */
		public DatePickerRow(String id, String title,
				IObjectFieldAccessor<D, Date> objectValues) {
			super(title);
			this.objectValues = objectValues;
			initRow(objectValues);
		}

		@Override
		public Cell<Date> createCell() {
			DateTimeFormat dateFormat = DateTimeFormat.getFormat(PredefinedFormat.DATE_MEDIUM);
			return new DatePickerCell(dateFormat);
		}
	}	
	
	/**
	 * return a read only date text row item
	 * 
	 * @param id not used yet
	 * @param title the head of this column
	 * @param objectValues provide the get()set() methods for the UiComponent property
	 * @return Column
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> DateRow<D> createAsDateText(String id, String title,
			IObjectFieldAccessor<D, Date> objectValues) {
		return new DateRow<D>(id, title, objectValues);
	}

	/**
	 * Return a row item that displays as date picker
	 * 
	 * @param id {@link String}
	 * @param title the head name of the row
	 * @param objectValues {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> DatePickerRow<D> createAsDatePicker(String id, String title,
			IObjectFieldAccessor<D, Date> objectValues) {
		return new DatePickerRow<D>(id, title, objectValues);
	}
	
	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
}
