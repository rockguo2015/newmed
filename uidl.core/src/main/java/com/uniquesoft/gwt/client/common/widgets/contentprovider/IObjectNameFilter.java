package com.uniquesoft.gwt.client.common.widgets.contentprovider;

import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria;

/**
 * An interface that provides methods to get or set the name for a object.
 *
 */
public interface IObjectNameFilter extends IPagedCriteria{
	public String getName();
	public void setName(String name);
}
