package com.uniquesoft.gwt.client.common.name;

import com.uniquesoft.gwt.client.common.async.IInitializerSupport;


/**
 * Provider two methods to get the id and value for a data type.
 *
 */
public interface IObjectNameProvider extends IInitializerSupport{

	/**
	 * get the value we needed for a data type
	 * @param o
	 * @return
	 */
	String getName(Object o);

	/**
	 * get the id of a object
	 * @param o
	 * @return
	 */
	String getId(Object o);
}
