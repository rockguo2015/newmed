package com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.factory.item;

import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValuesViewer;

/**
 * This class is used to show the detail of a collection of one data type.
 * For a collection, extend this class and overload the setValue to deploy
 * how to show the values in a VerticalPanel. 
 *
 * @param <T> 
 */
public abstract class MultiElementDetailItem<T> extends AbstractDetailItem<T>
		implements IValuesViewer<T> {

	public MultiElementDetailItem(String id, String title) {
		super(id, title);
	}

}
