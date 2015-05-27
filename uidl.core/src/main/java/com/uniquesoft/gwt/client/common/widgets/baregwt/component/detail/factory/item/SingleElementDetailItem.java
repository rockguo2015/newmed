package com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.factory.item;

import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;

/**
 * This abstract class is inherited to show the detail of a single object.
 * Rewrite the getValue() to show the detail of one object.
 * @param <T>
 */
public abstract class SingleElementDetailItem<T> extends AbstractDetailItem<T>
		implements IValueViewer<T> {

	/**
	 * Use id and title to create a HorizontalPanel which contails a label and 
	 * a VerticalPanel.
	 * @param id We can find the unique object by its id
	 * @param title The object title that will be shown on the page
	 */
	public SingleElementDetailItem(String id, String title) {
		super(id, title);
	}

}
