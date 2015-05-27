package com.uniquesoft.gwt.client.common.widgets.contentprovider;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ObjectNameFilter implements IObjectNameFilter, IsSerializable {

	
	Integer page;
	Integer pageSize;
	String name;
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
