package com.uniquesoft.gwt.client.common.widgets.baregwt.component.propertydetail;

import com.google.gwt.user.client.ui.Grid;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.propertydetail.factory.item.PropertyDetailItem;
import com.uniquesoft.gwt.client.common.widgets.component.ValueProviderComponent;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;

/**
 *By extending ValueProviderComponent, use "getAllProperties" 
 *to set all the detail items into the detail container.
 *In runtime it show the details of one object in a grid.
 *it's readonly
 * @param <T>
 */
public abstract class GWTPropertyDetailViewComponent<T> extends ValueProviderComponent<T> {
	private Grid detailGrid = new Grid(0,2);
	private boolean initialized = false;
	protected void initialize() {
		for(ICanAsWidget item : getAllProperties()){
			addItem((PropertyDetailItem) item);
		}
	}
	public Grid asWidget() {
		if (!initialized) {
			initialize();
			initialized = true;
		}		
		return detailGrid;
	}
	
	protected void addItem(PropertyDetailItem item){
		int current = detailGrid.getRowCount();
		detailGrid.resizeRows(current+1);
		detailGrid.setHTML(current, 0, item.getTitle());
		detailGrid.setWidget(current, 1, item.asWidget());
	}
	

}
