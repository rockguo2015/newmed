package com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.ValueGetter;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.GWTGridRow;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory.rows.GWTGridNumberRow;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * 
 * A factory to generate the row item with the value type {@link Double}
 *
 */
public class DoubleValueProviderFactory implements IInitializerSupport {

	/**
	 * Read-only text
	 * 
	 * @param <D> the data type of the object binding with the grid
	 */
	public static class DoubleTextRow<D> extends GWTGridRow<D, Double, String> {

		/**
		 *  Construct the DoubleTextRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public DoubleTextRow(String id, String title,
				final IObjectFieldAccessor<D, Double> fieldAccessor) {
			super(title);
			this.setValueGetter(new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return fieldAccessor.getValue(object).toString();
				}
			});

		}

		@Override
		public Cell<String> createCell() {
			return new TextCell();
		}
	}

	/**
	 * Editablt text
	 * 
	 * @param <D> the data type of the object binding with the grid
	 */
	public static class DoubleEditTextRow<D> extends
			GWTGridRow<D, Double, String> {

		IObjectFieldAccessor<D, Double> objectValues;

		/**
		 * Construct the DoubleEditTextRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 */
		public DoubleEditTextRow(String id, String title,
				IObjectFieldAccessor<D, Double> objectValues) {
			super(title);
			this.objectValues = objectValues;
			ValueGetter<D, String> valueGetter = new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return DoubleEditTextRow.this.objectValues.getValue(object)
							.toString();
				}
			};
			this.setValueGetter(valueGetter);
			FieldUpdater<D, String> fieldUpdater = new FieldUpdater<D, String>() {

				@Override
				public void update(int index, D object, String value) {

					DoubleEditTextRow.this.objectValues.setValue(object,
							new Double(value));
				}

			};
			this.setFileldUpdater(fieldUpdater);

		}

		@Override
		public Cell<String> createCell() {
			return new EditTextCell();
		}
	}

	/**
	 * A number row that can format the number form.
	 * 
	 * @param <D> the data type of the object binding with the grid
	 */
	public static class DoubleNumberFormatRow<D> extends
			GWTGridNumberRow<D, Double> {

		IObjectFieldAccessor<D, Double> objectValues;

		/**
		 * Construct the DoubleNumberFormatRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 */
		public DoubleNumberFormatRow(String id, String title,
				IObjectFieldAccessor<D, Double> objectValues) {
			super(id, title, objectValues);
			this.objectValues = objectValues;
		}

		/**
		 * Construct the DoubleNumberFormatRow with the given {@code title} 
		 * {@link IObjectFieldAccessor} and the format template
		 * @param id {@link String}
		 * @param title the head name of the Row
		 * @param objectValues {@link IObjectFieldAccessor}
		 * @param format the format template
		 */
		public DoubleNumberFormatRow(String id, String title,
				IObjectFieldAccessor<D, Double> objectValues, String format) {
			super(id, title, objectValues, format);
			this.objectValues = objectValues;
		}
	}

	
	/**
	 * Return the row item that displays a Double value as read only text.
	 * 
	 * @param id {@link String}
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> DoubleTextRow<D> createAsDoubleTextColumn(String id,
			String title, IObjectFieldAccessor<D, Double> objectValues) {
		return new DoubleTextRow<D>(id, title, objectValues);
	}

	/**
	 * Return the row item that displays Double value as editable text.
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> DoubleEditTextRow<D> createAsDoubleEditTextColumn(String id,
			String title, IObjectFieldAccessor<D, Double> objectValues) {
		return new DoubleEditTextRow<D>(id, title, objectValues);
	}

	/**
	 * Return the row item that displays Double value as default format.
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> DoubleNumberFormatRow<D> createAsDoubleFormatNumber(
			String id, String title,
			IObjectFieldAccessor<D, Double> objectValues) {
		return new DoubleNumberFormatRow<D>(id, title, objectValues);
	}

	/**
	 * Return the row item that displays Double value according to 
	 * the given format template.
	 * 
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> DoubleNumberFormatRow<D> createAsDoubleFormatNumber(
			String id, String title,
			IObjectFieldAccessor<D, Double> objectValues, String format) {
		return new DoubleNumberFormatRow<D>(id, title, objectValues, format);
	}

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
}
