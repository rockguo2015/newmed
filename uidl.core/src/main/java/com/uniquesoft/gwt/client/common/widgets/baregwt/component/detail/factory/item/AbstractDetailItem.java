package com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.factory.item;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;



/**
 * This is another kind of detail view type, it doesn't use Grid which is 
 * used in GWTProperty detail. The mechanism of it is a little like GWTForm while
 * GWTPropertyDetail is a little like ListGrid.
 *
 * @param <T> 
 */
public abstract class AbstractDetailItem<T> extends HorizontalPanel{
	
	protected Label titleLabel;
	protected VerticalPanel contentContainer;
	
	/**
	 * Create a HorizontailPanel that contain a label and a VerticalPanel.
	 * Label is used to show the title, VerticalPanel is used to show the detail.
	 * @param id The id of the object that will be shown. 
	 * @param title The title of the object that will be shown
	 */
	public AbstractDetailItem(String id, String title) {
		titleLabel = new Label(title+" : ");
		contentContainer = new VerticalPanel();
	}
	
}
