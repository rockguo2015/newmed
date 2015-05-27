package com.uniquesoft.gwt.client.common.widgets.pager

import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria

class Extensions {
	
	
	def static <T extends IPagedCriteria> T withPagerInfo(T pagedCriteria, IPager pager){
		if(pager.activePage==-1) pagedCriteria.page = 1
		else pagedCriteria.page = pager.activePage
		pagedCriteria.pageSize = pager.pageSize
		pagedCriteria
	}
}