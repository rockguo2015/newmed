package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.AbstractGWTGridColumn;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.GWTGridNumberColumn;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * 
 * A factory to generate the column item with the value type {@link Integer}
 *
 */
public class IntegerValueProviderFactory implements IInitializerSupport {

	/**
	 * Read only text
	 * 
	 * @param <D> the data type of the object that is binding with the grid
	 * 
	 */
	public static class IntegerTextColumn<D> extends
			AbstractGWTGridColumn<D, Integer, String> {

		IObjectFieldAccessor<D, Integer> objectValues;

		/**
		 *  Construct the IntegerTextColumn with given {@code title}, {@link IObjectFieldAccessor}.
		 */
		public IntegerTextColumn(String id, String title,
				IObjectFieldAccessor<D, Integer> objectValues) {
			super(title);
			this.objectValues = objectValues;
			initColumn(new TextCell(), this.createStringGeter(objectValues));

		}
	}

	/**
	 * Editable text
	 * 
	 * @param <D> the data type of the object that is binding with the grid
	 * 
	 */
	public static class IntegerEditTextColumn<D> extends
			AbstractGWTGridColumn<D, Integer, String> {

		IObjectFieldAccessor<D, Integer> objectValues;

		/**
		 *  Construct the IntegerEditTextColumn with given {@code title}, {@link IObjectFieldAccessor}.
		 */
		public IntegerEditTextColumn(String id, String title,
				IObjectFieldAccessor<D, Integer> objectValues) {
			super(title);
			this.objectValues = objectValues;

			FieldUpdater<D, String> filedUpdater = new FieldUpdater<D, String>() {

				@Override
				public void update(int index, D object, String value) {

					IntegerEditTextColumn.this.objectValues.setValue(object,
							new Integer(value));
				}

			};
			initColumn(new EditTextCell(),
					this.createStringGeter(objectValues), filedUpdater);

		}
	}

	/**
	 * Formatable read only text
	 * 
	 * @param <D> the data type of the object that is binding with the grid
	 * 
	 */
	public static class IntegerNumberFormatColumn<D> extends
	GWTGridNumberColumn<D, Integer> {

		IObjectFieldAccessor<D, Integer> objectValues;

		/**
		 *  Construct the IntegerNumberFormatColumn with the given {@code title},
		 *   {@link IObjectFieldAccessor}.
		 */
		public IntegerNumberFormatColumn(String id, String title,
				IObjectFieldAccessor<D, Integer> objectValues) {
			super(id,title, objectValues);
			this.objectValues = objectValues;
		}
		
		/**
		 *  Construct the IntegerNumberFormatColumn with the given {@code title},
		 *   {@link IObjectFieldAccessor} and format template {@code format}.
		 */
		public IntegerNumberFormatColumn(String id, String title,
				IObjectFieldAccessor<D, Integer> objectValues,String format) {
			super(id,title, objectValues,format);
			this.objectValues = objectValues;
		}
	}

	
	/**
	 * Return the float column item that displays as read only text.
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> IntegerTextColumn<D> createAsIntegerTextColumn(String id,
			String title, IObjectFieldAccessor<D, Integer> objectValues) {
		return new IntegerTextColumn<D>(id, title, objectValues);
	}

	/**
	 * Return the float column item that displays as editable text.
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> IntegerEditTextColumn<D> createAsIntegerEditTextColumn(
			String id, String title,
			IObjectFieldAccessor<D, Integer> objectValues) {
		return new IntegerEditTextColumn<D>(id, title, objectValues);
	}
	
	/**
	 * Return the float column item that displays as text with default format.
	 * 
	 */
	@WidgetProvider(requireAccessor = true)
	public <D>  IntegerNumberFormatColumn<D> createAsIntegerNumberFormatColumn(
			String id, String title,
			IObjectFieldAccessor<D, Integer> objectValues) {
		return new IntegerNumberFormatColumn<D>(id, title, objectValues);
	}
	

	/**
	 * Return the float column item that displays as text with the given format template.
	 * 
	 */
	@WidgetProvider(requireAccessor = true)
	public <D>  IntegerNumberFormatColumn<D> createAsIntegerNumberFormatColumn(
			String id, String title,
			IObjectFieldAccessor<D, Integer> objectValues,String format) {
		return new IntegerNumberFormatColumn<D>(id, title, objectValues,format);
	}

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
}
