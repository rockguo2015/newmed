package com.uniquesoft.gwt.shared.common.pager;

import java.util.Collection;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * This is used to get the information of established page.
 *
 * @param <V> the type of the records that will be show
 */
public interface IPagedResult<V> extends IsSerializable, Collection<V>{

	/**
	 * @return all the records in established page
	 */
	Collection<V> getResult();
	
	/**
	 * @return the current page number
	 */
	int getPage();

	/**
	 * @return the numbe of the current page records
	 */
	long getTotalRecords();
}
