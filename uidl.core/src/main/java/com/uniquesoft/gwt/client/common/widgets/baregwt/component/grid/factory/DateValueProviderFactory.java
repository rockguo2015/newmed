package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory;

import java.util.Date;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.cell.client.DatePickerCell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.AbstractGWTGridColumn;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * 
 * A factory to generate the column item with the value type {@link Date}
 *
 */
public class DateValueProviderFactory implements IInitializerSupport {
	
	/**
	 * Read only date text
	 * 
	 * @author hugolin
	 *
	 * @param <D> the data type the object that binding with the grid
	 */
	public static class DateColumn<D> extends AbstractGWTGridColumn<D, Date, Date> {

		IObjectFieldAccessor<D, Date> objectValues;

		/**
		 *  Construct the DateColumn with given {@code title}, {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public DateColumn(String id, String title,
				IObjectFieldAccessor<D, Date> objectValues) {
			super(title);
			this.objectValues = objectValues;
			DateTimeFormat dateFormat = DateTimeFormat.getFormat(PredefinedFormat.DATE_MEDIUM);
			initColumn(new DateCell(dateFormat),objectValues);
		}
	}

	/**
	 * Date text with date picker
	 * 
	 * @author hugolin
	 *
	 * @param <D> the data type the object binded with the grid
	 */
	public static class DatePickerColumn<D> extends AbstractGWTGridColumn<D, Date, Date> {

		IObjectFieldAccessor<D, Date> objectValues;

		/**
		 *  Construct the DatePickerColumn with given {@code title}, {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public DatePickerColumn(String id, String title,
				IObjectFieldAccessor<D, Date> objectValues) {
			super(title);
			this.objectValues = objectValues;
			DateTimeFormat dateFormat = DateTimeFormat.getFormat(PredefinedFormat.DATE_MEDIUM);
			initColumn(new DatePickerCell(dateFormat),objectValues);
		}
	}	
	
	/**
	 * Create read only date column item
	 * 
	 * @param id not used yet
	 * @param title the head of this column
	 * @param objectValues provide the get()set() methods for the UiComponent property
	 * @return Column
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> DateColumn<D> createAsDateColumn(String id, String title,
			IObjectFieldAccessor<D, Date> objectValues) {
		return new DateColumn<D>(id, title, objectValues);
	}

	/**
	 * Return the date column item that display as a date picker.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 * @return
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> DatePickerColumn<D> createAsDatePickerColumn(String id, String title,
			IObjectFieldAccessor<D, Date> objectValues) {
		return new DatePickerColumn<D>(id, title, objectValues);
	}
	
	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
}
