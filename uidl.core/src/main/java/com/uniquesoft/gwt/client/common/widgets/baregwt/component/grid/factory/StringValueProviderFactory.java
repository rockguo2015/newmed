package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.user.cellview.client.Column;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.AbstractGWTGridColumn;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * 
 * A factory to generate the column item with the value type {@link String}
 *
 */
public class StringValueProviderFactory implements IInitializerSupport {

	/**
	 * Read only text
	 *
	 * @param <D> the data type of Row
	 */
	public static class TextColumn<D> extends AbstractGWTGridColumn<D,String,String> {

		IObjectFieldAccessor<D, String> objectValues;

		/**
		 *  Construct the TextColumn with a given {@code title}, {@link IObjectFieldAccessor}.
		 */
		public TextColumn(String id, String title,
				IObjectFieldAccessor<D, String> objectValues) {
			super(title);
			this.objectValues = objectValues;
			initColumn(new TextCell(), objectValues);
		}
	}
	
	/**
	 * Click this Column, then you can edit it
	 * 
	 * @author hugolin
	 *
	 * @param <D>  the data type the object binded with the grid
	 */
	
	public static class EditTextColumn<D> extends AbstractGWTGridColumn<D,String,String> {

		IObjectFieldAccessor<D, String> objectValues;

		/**
		 *  Construct the EditTextColumn with a given {@code title}, {@link IObjectFieldAccessor}.
		 */
		public EditTextColumn(String id, String title,
				IObjectFieldAccessor<D, String> objectValues) {
			super(title);
			this.objectValues = objectValues;
			initColumn(new EditTextCell(), objectValues);
		}
	}
	
	/**
	 * Input box
	 * 
	 * @author hugolin
	 *
	 * @param <D> the data type of Row
	 */
	public static class TextInputColumn<D> extends AbstractGWTGridColumn<D,String,String> {

		IObjectFieldAccessor<D, String> objectValues;

		/**
		 *  Construct the TextInputColumn with a given {@code title}, {@link IObjectFieldAccessor}.
		 */
		public TextInputColumn(String id, String title,
				IObjectFieldAccessor<D, String> objectValues) {
			super(title);
			this.objectValues = objectValues;
			initColumn(new TextInputCell(), objectValues);
		}
	}

	
	/**
	 * Button in Grid
	 * 
	 * @author hugolin
	 *
	 * @param <D> the data type the object binded with the grid
	 */
	public static class ButtonColumn<D> extends AbstractGWTGridColumn<D,String,String> {

		IObjectFieldAccessor<D, String> objectValues;

		/**
		 *  Construct the ButtonColumn with a given {@code title}, {@link IObjectFieldAccessor}.
		 */
		public ButtonColumn(String id, String title,
				IObjectFieldAccessor<D, String> objectValues) {
			super(title);
			this.objectValues = objectValues;
			initColumn(new ButtonCell(), objectValues);
			new FieldUpdater<D, String>(){

				@Override
				public void update(int index, D object, String value) {
					// TODO Auto-generated method stub
					
				}};
		}
		
		/**
		 * Set the filed updater that is used to update the column
		 * 
		 * @param fieldUpdater the filed updater
		 */
		public void setFieldUpdater(FieldUpdater<D, String> fieldUpdater){
			((Column<D,String>) (this.column)).setFieldUpdater(fieldUpdater);
		}
	}
	
	
	/**
	 * Return a text column item that display as a read only text.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> TextColumn<D> createAsTextColumn(String id, String title,
			IObjectFieldAccessor<D, String> objectValues) {
		return new TextColumn<D>(id, title, objectValues);
	}

	/**
	 * Return a column item that display as an editable text.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> EditTextColumn<D> createAsEditTextColumn(String id, String title,
			IObjectFieldAccessor<D, String> objectValues) {
		return new EditTextColumn<D>(id, title, objectValues);
	}
	
	/**
	 * Return a column item that display as a button.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> ButtonColumn<D> createAsButtonColumn(String id, String title,
			IObjectFieldAccessor<D, String> objectValues) {
		return new ButtonColumn<D>(id, title, objectValues);
	}
	
	/**
	 * Return a column item that display as an input box.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	@WidgetProvider(requireAccessor = true)
	public <D> TextInputColumn<D> createAsTextInputColumn(String id, String title,
			IObjectFieldAccessor<D, String> objectValues) {
		return new TextInputColumn<D>(id, title, objectValues);
	}
	
	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
}
