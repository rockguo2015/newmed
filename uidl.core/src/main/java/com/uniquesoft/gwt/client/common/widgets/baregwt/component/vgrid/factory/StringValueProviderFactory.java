package com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.cell.client.TextInputCell;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.ValueGetter;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.GWTGridRow;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * 
 * A factory to generate the row item with the value type {@link String}
 *
 */
public class StringValueProviderFactory {

	/**
	 * A Row implementation that displays an string value as a Read-only text.
	 * 
	 * @param <D> the data type of the object binding with the grid
	 */
	public static class TextRow<D> extends GWTGridRow<D, String, String> {

		/**
		 *  Construct the TextRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public TextRow(String id, String title,
				final IObjectFieldAccessor<D, String> objectValues) {
			super(title);
			this.setValueGetter(new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return objectValues.getValue(object);
				}

			});

		}

		@Override
		public Cell<String> createCell() {
			return new TextCell();
		}
	}

	/**
	 * A Row implementation that displays an string value as an editable text.
	 * 
	 * @param <D> the data type of the object binding with the grid
	 * 
	 */
	public static class EditTextRow<D> extends GWTGridRow<D, String, String> {

		/**
		 *  Construct the EditTextRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 */
		public EditTextRow(String id, String title,
				final IObjectFieldAccessor<D, String> objectValues) {
			super(title);
			this.setValueGetter(new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return objectValues.getValue(object);
				}

			});
			this.setFileldUpdater(new FieldUpdater<D, String>() {

				@Override
				public void update(int index, D object, String value) {
					objectValues.setValue(object, value);
				}
			});

		}

		@Override
		public Cell<String> createCell() {
			return new EditTextCell();
		}
	}

	/**
	 * A Row implementation that displays an string value as a button.
	 * 
	 * @param <D> the data type of the object binding with the grid
	 * 
	 */
	public static class ButtonColumn<D> extends GWTGridRow<D, String, String> {

		/**
		 *  Construct the EditTextRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 */
		public ButtonColumn(String id, String title,
				IObjectFieldAccessor<D, String> fieldAccessor) {
			super(title);
			initRow(fieldAccessor);
		}

		/**
		 * Set the behavior when update the value
		 * 
		 * @param fieldUpdater {@link FieldUpdater}
		 */
		public void setFieldUpdater(FieldUpdater<D, String> fieldUpdater) {
			this.setFieldUpdater(fieldUpdater);
		}

		@Override
		public Cell<String> createCell() {
			return new ButtonCell();
		}
	}

	/**
	 * A Row implementation that displays a string value as an input box.
	 * 
	 * @param <D> the data type of the object binding with the grid
	 * 
	 */
	public static class InputRow<D> extends GWTGridRow<D, String, String> {

		/**
		 *  Construct the InputRow with the given {@code title} and {@link IObjectFieldAccessor}.
		 */
		public InputRow(String id, String title,
				IObjectFieldAccessor<D, String> fieldAccessor) {
			super(title);
			initRow(fieldAccessor);
		}

		@Override
		public Cell<String> createCell() {
			return new TextInputCell();
		}
	}
	
	
	
	/**
	 * Return a row item that displays a string value as a read only text.
	 * 
	 * @param id {@link String}
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> TextRow<D> createAsText(String id, String title,
			IObjectFieldAccessor<D, String> objectValues) {
		return new TextRow<D>(id, title, objectValues);
	}

	/**
	 * Return a row item that displays a string value as an editable text.
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> EditTextRow<D> createAsEditText(String id, String title,
			IObjectFieldAccessor<D, String> objectValues) {
		return new EditTextRow<D>(id, title, objectValues);
	}

	/**
	 * Return a row item that displays a string value as a button.
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> ButtonColumn<D> createAsButton(String id, String title,
			IObjectFieldAccessor<D, String> objectValues) {
		return new ButtonColumn<D>(id, title, objectValues);
	}
	
	/**
	 * Return a row item that displays a string value as an input box.
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> InputRow<D> createAsInput(String id, String title,
			IObjectFieldAccessor<D, String> objectValues) {
		return new InputRow<D>(id, title, objectValues);
	}
}
