package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.TextCell;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.AbstractGWTGridColumn;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.ValueGetter;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.RequireContentProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ISingleValueSelector;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * 
 * A factory to generate the column item  with the value type that is not specified
 *
 */
public class DefaultObjectSelectorFactory implements IInitializerSupport {

	/**
	 * Show number in different formats
	 * 
	 * @author hugolin
	 * 
	 * @param <D> the data type the object that is binging with the grid
	 */
	public static class DefaultTextColumn<D, C> extends
			AbstractGWTGridColumn<D, C, String> {

		IObjectFieldAccessor<D, C> objectValues;

		/**
		 *  Construct the DefaultTextColumn with given {@code title}, {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public DefaultTextColumn(String id, String title,
				final IObjectFieldAccessor<D, C> objectValues) {
			super(title);
			this.objectValues = objectValues;
			Cell<String> cell = new TextCell();
			ValueGetter<D, String> valueGeter = new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return objectValues.getValue(object).toString();
				}

			};
			initColumn(cell, valueGeter);
		}
	}

	/**
	 * Selection box in grid
	 * 
	 * @author hugolin
	 * 
	 * @param <D> the data type the object that is binding with the grid
	 */
	public static class DefaultSelectionColumn<D, C> extends
			AbstractGWTGridColumn<D, C, String> implements ISingleValueSelector<C>{

		IObjectFieldAccessor<D, C> objectValues;
		private Map<String, C> optionsMap;
		
		/**
		 *  Construct the DefaultSelectionColumn with given {@code title}, {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public DefaultSelectionColumn(String id, String title,
				final IObjectFieldAccessor<D, C> objectValues) {
			super(title);
			this.objectValues = objectValues;
		}

		/**
		 * Return the {@code optionsMap} that is displayed in the
		 * selection list.
		 */
		public Map<String, C> getOptionsMap() {
			return optionsMap;
		}

		/**
		 * Set the {@code optionsmap} and create the {@link SelectionCell}
		 * with the {@code optionsmap}.
		 * 
		 * @param optionsmap the mapping between selections and data
		 */
		private void setOptionsMap(Map<String, C> optionsmap) {
			this.optionsMap = optionsmap;
			List<String> options = new ArrayList<String>();
			for (String item : optionsmap.keySet()) {
				options.add(item);
			}
			Cell<String> cell = new SelectionCell(options);
			ValueGetter<D, String> valueGeter = new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return objectValues.getValue(object).toString();
				}

			};
			FieldUpdater<D, String> filedUpdater = new FieldUpdater<D, String>() {

				@Override
				public void update(int index, D object, String value) {

					DefaultSelectionColumn.this.objectValues.setValue(object,
							DefaultSelectionColumn.this.optionsMap.get(value));
				}

			};

			initColumn(cell, valueGeter, filedUpdater);
			
		}

		@Override
		public void setContentProvider(ContentProvider<C> provider) {
			Map<String,C> optionsMap = new HashMap<String,C>();
			for(C g : provider.getContents()){
				optionsMap.put(g.toString(),g);
			}
			setOptionsMap(optionsMap);
			
		}

	}

	/**
	 * Return the default column item that display as a readonly text.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 * @return
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	@RequireContentProvider
	public <D, C> DefaultSelectionColumn<D, C> createAsDefaultSelectionColumn(String id,
			String title, IObjectFieldAccessor<D, C> objectValues) {
		return new DefaultSelectionColumn<D, C>(id, title, objectValues);
	}

	/**
	 * Return the default column item that display as a selection widget.
	 * 
	 * @param id the id of the item
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 * @return
	 */
	@WidgetProvider( requireAccessor = true)
	public <D, C> DefaultTextColumn<D, C> createAsDefaultTextColumn(String id,
			String title, IObjectFieldAccessor<D, C> objectValues) {
		return new DefaultTextColumn<D, C>(id, title, objectValues);
	}
	
	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
	
}
