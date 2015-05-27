package edu.fudan.langlab.gxt.client.widget

import com.sencha.gxt.widget.core.client.ContentPanel
import com.uniquesoft.gwt.client.common.widgets.pager.IPager
import com.uniquesoft.gwt.shared.common.pager.IPagedCriteria
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent
import edu.fudan.langlab.gxt.client.pager.GXTPager
import com.uniquesoft.gwt.shared.common.pager.IPagedResult
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer$VerticalLayoutData
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer

class PagedList<T,C extends IPagedCriteria> {
	val GXTGridComponent<T> gridComponent
	val IPager pager
	val com.sencha.gxt.widget.core.client.ContentPanel content 
	val (void)=>C criteriaProvider
//	IPagedCriteria criteria

	def static <T,C extends IPagedCriteria>  asPagedList(GXTGridComponent<T> gridComponent, (void)=>C criteriaProvider,(IPagedCriteria)=>void notifier){
		new PagedList<T,C>(gridComponent,criteriaProvider,notifier)
	}
	
	new(GXTGridComponent<T> gridComponent, (void)=>C criteriaProvider,(IPagedCriteria)=>void notifier){
		this.gridComponent = gridComponent
		this.criteriaProvider = criteriaProvider
		pager = new GXTPager<T>(gridComponent)=>[
			activePage = 1
			pageSize = 30
			pagerHandler = [int pageNum, int recordsPerPage|
				notifier.apply(	
					(getCriteria()=>[IPagedCriteria c|
						c.page = pageNum
						c.pageSize = recordsPerPage
					]) as IPagedCriteria
				)
			]
		]		
		content = new com.sencha.gxt.widget.core.client.ContentPanel=>[
			it.setHeaderVisible(false)
			widget = new VerticalLayoutContainer=>[
				add(gridComponent.asWidget,new VerticalLayoutData(1,1))
				add(pager.asWidget)
			]
		]
		gridComponent.keepSelection
	}
	
	def getPager(){
		pager
	}
	
	def asWidget(){
		content
	}
	
	def C getCriteria(){
		val criteria = criteriaProvider.apply(null)
		if(pager.activePage==-1) criteria.page = 1
		else criteria.page = pager.activePage
		criteria.pageSize = pager.pageSize
		criteria
	}
	
	def setResults(IPagedResult<T> results){
		pager.pageLoaded(results)
	}
	
	def refresh((Void)=>void callback){
		pager.gotoPage(pager.activePage)[
			callback.apply(null)
		]
	}
	def refresh() {
		pager.gotoPage(pager.activePage)
	}
	def reveal(Object item){
		gridComponent.reveal(item)
	}
	
	
}