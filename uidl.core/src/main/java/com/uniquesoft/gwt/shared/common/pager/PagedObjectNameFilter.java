package com.uniquesoft.gwt.shared.common.pager;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.IObjectNameFilter;

public class PagedObjectNameFilter implements IObjectNameFilter, IsSerializable {

	private Integer page;
	private Integer pageSize = 30;
	private String name;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
