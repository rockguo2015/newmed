package com.uniquesoft.gwt.client.common;

import com.google.gwt.user.client.ui.Widget;

/**
 * An interface that provides methods to show or destroy a web page which contains a group of web components
 *
 */
public interface View {
	
	/**
	 * 
	 * @return the web widget that can be shown on the page
	 */
	Widget asWidget();
	
	/**
	 * destroy the current view page
	 */
	void destroy();
}
