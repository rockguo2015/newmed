package com.uniquesoft.gwt.client.common.widgets.baregwt.component.propertydetail.factory.item;

import com.google.gwt.user.cellview.client.CellWidget;

/**
 * This class is used to record the title and string value of the detail item 
 *
 */
public class PropertyDetailItem {
	protected CellWidget<String> widget;
	
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title+" : ";
	}
	
	public CellWidget<String> asWidget() {
        return widget;
    }
}
