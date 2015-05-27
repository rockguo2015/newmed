package com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.cells.FloatTextCell;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.ValueGetter;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.GWTGridRow;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory.rows.GWTGridNumberRow;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * 
 * A factory to generate the row item with the value type {@link Float}
 *
 */
public class FloatValueProviderFactory implements IInitializerSupport {

	/**
	 * Read only text
	 * 
	 * @param <D> the data type of the object binding with the grid
	 * 
	 */
	public static class FloatTextRow<D> extends GWTGridRow<D, Float, Float> {

		/**
		 *  Construct the FloatTextRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public FloatTextRow(String id, String title,
				IObjectFieldAccessor<D, Float> fieldAccessor) {
			super(title);
			initRow(fieldAccessor);

		}

		@Override
		public Cell<Float> createCell() {
			return new FloatTextCell();
		}
	}

	/**
	 * A number row that can format the number form.
	 * 
	 * @param <D> the data type of the object binding with the grid
	 */
	public static class FloatFormatNumberRow<D> extends
			GWTGridNumberRow<D, Float> {

		/**
		 *  Construct the FloatFormatNumberRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 * 
		 */
		public FloatFormatNumberRow(String id, String title,
				IObjectFieldAccessor<D, Float> objectValues) {
			super(id, title, objectValues);
		}

		/**
		 *  Construct the FloatFormatNumberRow with the given {@code title}
		 *  {@link IObjectFieldAccessor} and the given format template.
		 * 
		 */
		public FloatFormatNumberRow(String id, String title,
				IObjectFieldAccessor<D, Float> objectValues, String format) {
			super(id, title, objectValues, format);
		}
	}

	/**
	 * Editable text
	 * 
	 * @param <D> the data type of the object binding with the grid
	 * 
	 */
	public static class FloatEditTextRow<D> extends
			GWTGridRow<D, Float, String> {

		IObjectFieldAccessor<D, Float> objectValues;

		/**
		 *  Construct the FloatEditTextRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 * 
		 */
		public FloatEditTextRow(String id, String title,
				IObjectFieldAccessor<D, Float> objectValues) {
			super(title);
			this.objectValues = objectValues;
			ValueGetter<D, String> getValue = new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return FloatEditTextRow.this.objectValues.getValue(
							object).toString();
				}
			};
			this.setValueGetter(getValue);
			FieldUpdater<D, String> fieldUpdater = new FieldUpdater<D, String>() {

				@Override
				public void update(int index, D object, String value) {

					FloatEditTextRow.this.objectValues.setValue(object,
							new Float(value));
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
	 * Return the row item that displays a Float value as read only text.
	 * 
	 * @param id {@link String}
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> FloatTextRow<D> createAsFloatText(String id, String title,
			IObjectFieldAccessor<D, Float> objectValues) {
		return new FloatTextRow<D>(id, title, objectValues);
	}

	/**
	 * Return the row item that displays Float value as editable text.
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> FloatEditTextRow<D> createAsFloatEditText(String id,
			String title, IObjectFieldAccessor<D, Float> objectValues) {
		return new FloatEditTextRow<D>(id, title, objectValues);
	}

	/**
	 * Return the row item that displays Float value as default format.
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> FloatFormatNumberRow<D> createAsFloatFormatNumber(
			String id, String title, IObjectFieldAccessor<D, Float> objectValues) {
		return new FloatFormatNumberRow<D>(id, title, objectValues);
	}

	/**
	 * Return the row item that displays Float value according to 
	 * the given format template.
	 * 
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> FloatFormatNumberRow<D> createAsFloatFormatNumber(
			String id, String title,
			IObjectFieldAccessor<D, Float> objectValues, String format) {
		return new FloatFormatNumberRow<D>(id, title, objectValues, format);
	}

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
}
