package com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellWidget;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.ValueGetter;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.GWTGridRow;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory.cellwidget.GridCellWidget;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.RequireContentProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ISingleValueSelector;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * 
 * A factory to generate the row item with the value type that is not specified
 *
 */
public class DefaultObjectSelectorFactory implements IInitializerSupport {

	/**
	 * Show date read only text
	 * 
	 * @author hugolin
	 * 
	 * @param <D> the data type of Column
	 * @param <C> the data type of Row
	 */
	public static class DefaultTextRow<D, C> extends
	GWTGridRow<D, C, String> {

		/**
		 *  Construct the DefaultTextRow with given {@code title}, {@link IObjectFieldAccessor}.
		 * 
		 * @param id {@link String}
		 * @param title the head name of the column
		 * @param objectValues {@link IObjectFieldAccessor}
		 */
		public DefaultTextRow(String id, String title,
				final IObjectFieldAccessor<D, C> filedAccessor) {
			super(title);
			
			ValueGetter<D, String> valueGetter = new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return filedAccessor.getValue(object).toString();
				}

			};
			this.setValueGetter(valueGetter);
		}

		@Override
		public Cell<String> createCell() {
			return new TextCell();
		}
	}

	/**
	 * Selection box
	 * 
	 * @author hugolin
	 * 
	 * @param <D>
	 *            the data type the object binded with the grid
	 */
	public static class DefaultSelectionRow<D, C> extends
	GWTGridRow<D, C, String> implements ISingleValueSelector<C>{

		private IObjectFieldAccessor<D, C> objectValues;
		private Map<String, C> optionsMap;
		private List<String> options;

		/**
		 *  Construct the DefaultSelectionRow with given {@code title}, {@link IObjectFieldAccessor}.
		 */
		public DefaultSelectionRow(String id, String title,
				final IObjectFieldAccessor<D, C> objectValues) {
			super(title);
			this.objectValues = objectValues;
		}

		/**
		 * Return the {@code optionsMap}
		 */
		public Map<String, C> getOptionsMap() {
			return optionsMap;
		}

		/**
		 * Set the {@code optionsmap} and initialize the row
		 * 
		 * @param optionsmap the mapping of selection items and the value 
		 */
		private void setOptionsMap(Map<String, C> optionsmap) {
			this.optionsMap = optionsmap;
			options = new ArrayList<String>();
			for (String item : optionsmap.keySet()) {
				options.add(item);
			}
			ValueGetter<D, String> valueGetter = new ValueGetter<D, String>() {

				@Override
				public String getValue(D object) {
					return objectValues.getValue(object).toString();
				}

			};
			this.setValueGetter(valueGetter);
			FieldUpdater<D, String> filedUpdater = new FieldUpdater<D, String>() {

				@Override
				public void update(int index, D object, String value) {

					DefaultSelectionRow.this.objectValues.setValue(object,
							DefaultSelectionRow.this.optionsMap.get(value));
				}

			};
			this.setFileldUpdater(filedUpdater);

			
		}

		@Override
		public void setContentProvider(ContentProvider<C> provider) {
			Map<String,C> optionsMap = new HashMap<String,C>();
			for(C g : provider.getContents()){
				optionsMap.put(g.toString(),g);
			}
			setOptionsMap(optionsMap);
			
		}

		@Override
		public Cell<String> createCell() {
			return new SelectionCell(options);
		}

	}

	/**
	 * Return the default column item that display as a selection widget.
	 * 
	 * @param id {@link String}
	 * @param title the head of the row
	 * @param objectValues
	 *            provide the get()set() methods for the UiComponent property
	 */
	@WidgetProvider( requireAccessor = true)
	@RequireContentProvider
	public <D, C> DefaultSelectionRow<D, C> createAsDefaultSelectionRow(String id,
			String title, IObjectFieldAccessor<D, C> objectValues) {
		return new DefaultSelectionRow<D, C>(id, title, objectValues);
	}

	/**
	 * Return the default text column item that display as read only text.
	 */
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D, C> DefaultTextRow<D, C> createAsDefaultTextRow(String id,
			String title, IObjectFieldAccessor<D, C> objectValues) {
		return new DefaultTextRow<D, C>(id, title, objectValues);
	}
	
	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);

	}
	
}
