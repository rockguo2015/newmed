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
 * A factory to generate the row item with the value type {@link Integer}
 *
 */
public class IntegerValueProviderFactory implements IInitializerSupport {

	/**
	 * A Row implementation that displays integer value as Read-only text.
	 * 
	 * @param <D> the data type of the object binding with the grid
	 * 
	 */
	public static class IntegerTextRow<D> extends
			GWTGridRow<D, Integer, String> {

		/**
		 *  Construct the IntegerTextRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public IntegerTextRow(String id, String title,
				final IObjectFieldAccessor<D, Integer> fieldAccessor) {
			super(title);
			this.setValueGetter(new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					if (fieldAccessor.getValue(object) != null)
						return fieldAccessor.getValue(object).toString();
					return "";
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
	public static class IntegerEditTextRow<D> extends
			GWTGridRow<D, Integer, String> {

		/**
		 *  Construct the IntegerEditTextRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 */
		public IntegerEditTextRow(String id, String title,
				final IObjectFieldAccessor<D, Integer> fieldAccessor) {
			super(title);
			this.setValueGetter(new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return String.valueOf(fieldAccessor.getValue(object));
				}
			});

			FieldUpdater<D, String> fieldUpdater = new FieldUpdater<D, String>() {

				@Override
				public void update(int index, D object, String value) {

					fieldAccessor.setValue(object, new Integer(value));
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
	public static class IntegerFormatNumberRow<D> extends
			GWTGridNumberRow<D, Integer> {

		/**
		 *  Construct the IntegerFormatNumberRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 * 
		 */
		public IntegerFormatNumberRow(String id, String title,
				IObjectFieldAccessor<D, Integer> objectValues) {
			super(id, title, objectValues);
		}

		/**
		 *  Construct the IntegerFormatNumberRow with the given {@code title}
		 *  {@link IObjectFieldAccessor} and the given format template.
		 * 
		 */
		public IntegerFormatNumberRow(String id, String title,
				IObjectFieldAccessor<D, Integer> objectValues, String format) {
			super(id, title, objectValues, format);
		}
	}

	
	
	/**
	 * Return a row item that displays a Integer value as read only text.
	 * 
	 * @param id {@link String}
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> IntegerTextRow<D> createAsIntegerText(String id,
			String title, IObjectFieldAccessor<D, Integer> objectValues) {
		return new IntegerTextRow<D>(id, title, objectValues);
	}

	/**
	 * Return a row item that displays a Integer value as editable text.
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> IntegerEditTextRow<D> createAsIntegerEditTextColumn(String id,
			String title, IObjectFieldAccessor<D, Integer> objectValues) {
		return new IntegerEditTextRow<D>(id, title, objectValues);
	}

	/**
	 * Return a row item that displays Integer value as default format.
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> IntegerFormatNumberRow<D> createAsIntegerFormatNumber(
			String id, String title,
			IObjectFieldAccessor<D, Integer> objectValues) {
		return new IntegerFormatNumberRow<D>(id, title, objectValues);
	}

	/**
	 * Return a row item that displays Integer value according to 
	 * the given format template.
	 * 
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> IntegerFormatNumberRow<D> createAsIntegerFormatNumber(
			String id, String title,
			IObjectFieldAccessor<D, Integer> objectValues, String format) {
		return new IntegerFormatNumberRow<D>(id, title, objectValues, format);
	}

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
}
