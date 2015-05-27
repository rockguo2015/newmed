package com.uniquesoft.gwt.client.common.widgets.valueprovider;

/**
 * Basic widget class type for the UI data type.
 * Each data type instance will be transfered as a ICanAsWidget to set into a component as a field.
 * It is related with a data type. In UIDL, we create a specific widget for the data type,
 *
 */
public interface ICanAsWidget {
	/**
	 * @return the UI widget that can be shown on the web page
	 */
	Object asWidget();
}
