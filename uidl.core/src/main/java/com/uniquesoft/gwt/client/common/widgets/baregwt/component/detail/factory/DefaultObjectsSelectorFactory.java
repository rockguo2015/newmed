package com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.factory;

import java.util.Collection;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.factory.item.MultiElementDetailItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.GWTNamedEntity;

/**
 * The default place to match a collection type to find a detailItem to create.
 *
 */
public class DefaultObjectsSelectorFactory {
	@Inject
	RuntimeGinjector runtimeGinjector;

	/**
	 * Show the collection values in a Grid, then put the 
	 *Grid in the VerticalPanel.
	 * @param <T>
	 */
	public static class GridBasedDetailItem<T> extends
			MultiElementDetailItem<T> {
		  Grid summaryGrid;
		
		IObjectNameProvider nameProvider;

		/**
		 * Create a HorizonalPanel that contain a Label and a VerticalPanel.
		 * @param id
		 * @param title
		 * @param runtimeGinjector
		 */
		public GridBasedDetailItem(String id, String title,
				RuntimeGinjector runtimeGinjector) {
			super(id, title);
			add(titleLabel);
			add(contentContainer);
			nameProvider = runtimeGinjector.getObjectNameProvider();
		}

		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValuesViewer#setValue(java.util.Collection)
		 * create a Grid which has two columns.The first column displays the title, the second displays the value. 
		 */
		@Override
		public void setValue(Collection<T> value) {
			summaryGrid = new Grid(value.size(),2);
			
			int index = 0;
			for (T rec : value) {
				String title = new String(nameProvider.getId(rec));
				String titleValue = new String(nameProvider.getName(rec));
				summaryGrid.setHTML(index,0,title);
				summaryGrid.setHTML(index,1,titleValue);
				index++;
			}
			contentContainer.add(summaryGrid);
		}
	
	}

	/**
	 * @param id
	 * @param title
	 * @return Create a GridBasedDetailItem for this collection to show its detail.
	 * GridBaseDetailItem will be shown as a choice for collection type in UIDL.
	 * 
	 */
	@WidgetProvider(isDefault=true)
	public <T> GridBasedDetailItem<T> createAsGridBaseDetailItem(String id,
			String title) {
		return new GridBasedDetailItem<T>(id, title, runtimeGinjector);
	}
}
