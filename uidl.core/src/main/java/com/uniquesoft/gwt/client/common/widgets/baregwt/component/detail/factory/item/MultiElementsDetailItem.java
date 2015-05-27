package com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.factory.item;

import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValuesViewer;

public abstract class MultiElementsDetailItem<T> extends AbstractDetailItem<T>
		implements IValuesViewer<T> {

	public MultiElementsDetailItem(String id, String title) {
		super(id, title);
	}

}
