package com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.CheckboxCell;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.GWTGridRow;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * A factory to generate the row item with type {@link Boolean}.
 *
 */
public class BooleanValueProviderFactory implements IInitializerSupport {
	
	/**
	 * Check Box
	 * 
	 * @author hugolin
	 *
	 * @param <D> the data type the object binded with the grid
	 */
	
	public static class CheckBoxRow<D> extends GWTGridRow<D, Boolean, Boolean> {

		IObjectFieldAccessor<D, Boolean> objectValues;

		/**
		 * Construct the CheckBoxRow with given {@code title} and {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the row
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public CheckBoxRow(String id, String title,
				IObjectFieldAccessor<D, Boolean> objectValues) {
			super(title);
			initRow(objectValues);
		}

		@Override
		public Cell<Boolean> createCell() {
			return new CheckboxCell();
		}
	}

	/**
	 * Return a tow item that display as check box.
	 * 
	 * @param id
	 * @param title
	 * @param objectValues
	 * @return
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> CheckBoxRow<D> createAsCheckBox(String id,
			String title, IObjectFieldAccessor<D, Boolean> objectValues) {
		return new CheckBoxRow<D>(id, title, objectValues);
	}

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
}
