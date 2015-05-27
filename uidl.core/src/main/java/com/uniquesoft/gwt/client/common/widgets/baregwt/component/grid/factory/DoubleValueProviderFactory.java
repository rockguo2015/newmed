package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.AbstractGWTGridColumn;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.GWTGridNumberColumn;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.ValueGetter;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * 
 * A factory to generate the column item with the value type {@link Double}
 *
 */
public class DoubleValueProviderFactory implements IInitializerSupport {

	/**
	 * Readonly text
	 * 
	 * @param <D> the data type the object that is binding with the grid
	 */
	public static class DoubleTextColumn<D> extends
			AbstractGWTGridColumn<D, Double, Double> {

		IObjectFieldAccessor<D, Double> objectValues;

		/**
		 *  Construct the DoubleTextColumn with given {@code title}, {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public DoubleTextColumn(String id, String title,
				IObjectFieldAccessor<D, Double> objectValues) {
			super(title);
			this.objectValues = objectValues;

			Cell<Double> cell = new AbstractCell<Double>() {

				@Override
				public void render(
						com.google.gwt.cell.client.Cell.Context context,
						Double value, SafeHtmlBuilder sb) {
					sb.append(value);

				}

			};
			initColumn(cell, objectValues);

		}
	}

	/**
	 * A editable Text column
	 *
	 * @param <D> the type of Row
	 */
	public static class DoubleEditTextColumn<D> extends
			AbstractGWTGridColumn<D, Double, String> {

		IObjectFieldAccessor<D, Double> objectValues;

		/**
		 *  Construct the DoubleEditTextColumn with given {@code title}, {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public DoubleEditTextColumn(String id, String title,
				IObjectFieldAccessor<D, Double> objectValues) {
			super(title);
			this.objectValues = objectValues;
			ValueGetter<D, String> getValue = new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return DoubleEditTextColumn.this.objectValues.getValue(
							object).toString();
				}
			};

			FieldUpdater<D, String> filedUpdater = new FieldUpdater<D, String>() {

				@Override
				public void update(int index, D object, String value) {

					DoubleEditTextColumn.this.objectValues.setValue(object,
							new Double(value));
				}

			};
			initColumn(new EditTextCell(), getValue, filedUpdater);

		}
	}

	/**
	 * A number column that can format the number form.
	 *
	 * @param <D> the type of Row
	 */
	public static class DoubleNumberFormatColumn<D> extends
	GWTGridNumberColumn<D, Double> {

		IObjectFieldAccessor<D, Double> objectValues;

		/**
		 *  Construct the DoubleNumberFormatColumn with given {@code title} and 
		 *  {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public DoubleNumberFormatColumn(String id, String title,
				IObjectFieldAccessor<D, Double> objectValues) {
			super(id,title, objectValues);
			this.objectValues = objectValues;
		}
		
		/**
		 *  Construct the DoubleNumberFormatColumn with given {@code title}, 
		 *  {@link IObjectFieldAccessor} and {@code format}
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 * @param format the format template
		 */
		public DoubleNumberFormatColumn(String id, String title,
				IObjectFieldAccessor<D, Double> objectValues,String format) {
			super(id,title, objectValues,format);
			this.objectValues = objectValues;
		}
	}
	
	
	
	/**
	 * Return the double column item that display as read only text.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> DoubleTextColumn<D> createAsDoubleTextColumn(String id,
			String title, IObjectFieldAccessor<D, Double> objectValues) {
		return new DoubleTextColumn<D>(id, title, objectValues);
	}
	
	/**
	 * Return the double column item that display as a editable text.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> DoubleEditTextColumn<D> createAsDoubleEditTextColumn(String id,
			String title, IObjectFieldAccessor<D, Double> objectValues) {
		return new DoubleEditTextColumn<D>(id, title, objectValues);
	}
	
	/**
	 * Return the double column item with default format.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(requireAccessor = true)
	public <D>  DoubleNumberFormatColumn<D> createAsDoubleNumberFormatColumn(
			String id, String title,
			IObjectFieldAccessor<D, Double> objectValues) {
		return new DoubleNumberFormatColumn<D>(id, title, objectValues);
	}
	

	/**
	 * Return the double column item with the given format template.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 * @param format the format template
	 */
	@WidgetProvider(requireAccessor = true)
	public <D>  DoubleNumberFormatColumn<D> createAsDoubleNumberFormatColumn(
			String id, String title,
			IObjectFieldAccessor<D, Double> objectValues,String format) {
		return new DoubleNumberFormatColumn<D>(id, title, objectValues,format);
	}

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
}
