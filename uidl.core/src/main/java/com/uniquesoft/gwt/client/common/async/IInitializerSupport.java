package com.uniquesoft.gwt.client.common.async;


/**
 * Monitor the initial process, when all the data has been received  from the server side,
 * it will call the IPostInitializeAction to declare that the initialize has finished.
 *
 */
public interface IInitializerSupport {

	/**
	 * To get the data asynchronously, when finished, call the IPostInitializeAction
	 * @param postInitialize callback function, it is call when the initialize work has finished.
	 */
	void initialize(IPostInitializeAction postInitialize);

}
