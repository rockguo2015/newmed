package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory;

import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.cells.FloatTextCell;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.AbstractGWTGridColumn;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.GWTGridNumberColumn;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.ValueGetter;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * 
 * A factory to generate the column item with the value type {@link Float}
 *
 */
public class FloatValueProviderFactory implements IInitializerSupport {

	/**
	 * Read only text
	 * 
	 * @param <D> the data type the object that is binding with the grid
	 * 
	 */
	public static class FloatTextColumn<D> extends
			AbstractGWTGridColumn<D, Float, Float> {

		IObjectFieldAccessor<D, Float> objectValues;

		/**
		 *  Construct the FloatTextColumn with given {@code title}, {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public FloatTextColumn(String id, String title,
				IObjectFieldAccessor<D, Float> objectValues) {
			super(title);
			this.objectValues = objectValues;
			initColumn(new FloatTextCell(), objectValues);

		}
	}
	
	/**
	 * A {@link GWTGridNumberColumn} subclass with the value type {@link Float}
	 * 
	 * @param <D> the data type the object that is binding with the grid
	 */
	public static class FloatNumberFormatColumn<D> extends
	GWTGridNumberColumn<D, Float> {

		IObjectFieldAccessor<D, Float> objectValues;

		/**
		 *  Construct the FloatNumberFormatColumn with the given {@code title},
		 *   {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public FloatNumberFormatColumn(String id, String title,
				IObjectFieldAccessor<D, Float> objectValues) {
			super(id,title, objectValues);
			this.objectValues = objectValues;
		}
		
		/**
		 *  Construct the FloatNumberFormatColumn with the given {@code title},
		 *   {@link IObjectFieldAccessor} and {@code format}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public FloatNumberFormatColumn(String id, String title,
				IObjectFieldAccessor<D, Float> objectValues,String format) {
			super(id,title, objectValues,format);
			this.objectValues = objectValues;
		}
	}

	/**
	 * Editable Text column
	 *
	 * @param <D> the type of Row
	 */
	public static class FloatEditTextColumn<D> extends
			AbstractGWTGridColumn<D, Float, String> {

		IObjectFieldAccessor<D, Float> objectValues;

		/**
		 *  Construct the FloatNumberFormatColumn with the given {@code title},
		 *   {@link IObjectFieldAccessor}.
		 */
		public FloatEditTextColumn(String id, String title,
				IObjectFieldAccessor<D, Float> objectValues) {
			super(title);
			this.objectValues = objectValues;
			ValueGetter<D, String> getValue = new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return FloatEditTextColumn.this.objectValues.getValue(object).toString();
				}
			};
			
			FieldUpdater<D,String> filedUpdater = new FieldUpdater<D,String>(){

				@Override
				public void update(int index, D object, String value) {
					
					FloatEditTextColumn.this.objectValues.setValue(object, new Float(value));
				}
				
			};
			initColumn(new EditTextCell(), getValue, filedUpdater );

		}
	}

	/**
	 * Return the float column item that displays as read only text.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> FloatTextColumn<D> createAsFloatTextColumn(String id,
			String title, IObjectFieldAccessor<D, Float> objectValues) {
		return new FloatTextColumn<D>(id, title, objectValues);
	}
	

	/**
	 * Return the float column item that displays as editable text.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> FloatEditTextColumn<D> createAsFloatEditTextColumn(String id,
			String title, IObjectFieldAccessor<D, Float> objectValues) {
		return new FloatEditTextColumn<D>(id, title, objectValues);
	}
	
	/**
	 * Return the float column item with default format.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(requireAccessor = true)
	public <D>  FloatNumberFormatColumn<D> createAsFloatNumberFormatColumn(
			String id, String title,
			IObjectFieldAccessor<D, Float> objectValues) {
		return new FloatNumberFormatColumn<D>(id, title, objectValues);
	}
	

	/**
	 * Return the float column item with the given format template
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(requireAccessor = true)
	public <D>  FloatNumberFormatColumn<D> createAsFloatNumberFormatColumn(
			String id, String title,
			IObjectFieldAccessor<D, Float> objectValues,String format) {
		return new FloatNumberFormatColumn<D>(id, title, objectValues,format);
	}
	
	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
}
