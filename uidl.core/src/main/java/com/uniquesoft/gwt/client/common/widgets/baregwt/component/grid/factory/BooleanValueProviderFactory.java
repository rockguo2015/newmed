package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.i18n.client.NumberFormat;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.AbstractGWTGridColumn;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
/**
 * A factory to generate the column item of type Boolean.
 *
 */
public class BooleanValueProviderFactory implements IInitializerSupport {
	
	/**
	 * Check Box
	 * 
	 * @author hugolin
	 *
	 * @param <D> the data type the object binding with the grid
	 */
	
	public static class CheckBoxColumn<D> extends AbstractGWTGridColumn<D, Boolean, Boolean> {

		IObjectFieldAccessor<D, Boolean> objectValues;
		/**
		 * Construct the CheckBoxColumn with given {@code title}, {@link IObjectFieldAccessor}.
	     *  
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public CheckBoxColumn(String id, String title,
				IObjectFieldAccessor<D, Boolean> objectValues) {
			super(title);
			initColumn(new CheckboxCell(),objectValues);
		}
	}

	/**
	 * Return the Boolean column item that display as a check box.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 * @return
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> CheckBoxColumn<D> createAsCheckBoxColumn(String id,
			String title, IObjectFieldAccessor<D, Boolean> objectValues) {
		return new CheckBoxColumn<D>(id, title, objectValues);
	}

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
}
