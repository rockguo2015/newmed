package edu.fudan.langlab.gxt.client.component.propertyview.factory;

import com.google.gwt.user.client.ui.Label;

public interface IPropertyItem<T> {

	public abstract String getName();

	public abstract int getColspan();

	public abstract Label asWidget();

}