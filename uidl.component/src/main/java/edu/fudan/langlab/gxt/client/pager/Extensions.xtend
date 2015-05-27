package edu.fudan.langlab.gxt.client.pager

import com.uniquesoft.gwt.client.common.widgets.ObjectListView
import com.uniquesoft.gwt.client.common.widgets.pager.IPager

class Extensions {
	
	def static <T> IPager<T> createPager(ObjectListView<T> objectListView){
		new GXTPager(objectListView)=>[
			activePage = 1
			pageSize = 30
		]
	}
}