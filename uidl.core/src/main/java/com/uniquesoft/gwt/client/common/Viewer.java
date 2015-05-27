package com.uniquesoft.gwt.client.common;

import com.uniquesoft.gwt.client.common.async.IInitializerSupport;

/**
 * It is used to draw the web components on the page.
 * It provides asynchronous mechanism to initialize the components in the page 
 *
 */
public interface Viewer extends View, IInitializerSupport {

	/**
	 * Initialize all the view components in the view. The view can not be shown until 
	 * all the components have been initialized.
	 */
	public void initialize();

}
