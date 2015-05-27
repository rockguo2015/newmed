package edu.fudan.langlab.gxt.client.widget

import com.sencha.gxt.widget.core.client.container.SimpleContainer
import com.uniquesoft.gwt.client.common.Presenter
import com.sencha.gxt.widget.core.client.container.ResizeContainer
import com.sencha.gxt.widget.core.client.ContentPanel
import com.uniquesoft.gwt.client.common.widgets.IPresenterContainer

class PresenterContainer implements IPresenterContainer{
	
	private SimpleContainer container = new SimpleContainer
	private Presenter activePresenter

	override showActivatedPresenter(String title,Presenter p){
		if(activePresenter!=null){
			activePresenter.deactivate
			activePresenter.getView().asWidget().removeFromParent
		}
		activePresenter = p
		val w = activePresenter.getView().asWidget
		var c = new com.sencha.gxt.widget.core.client.ContentPanel=>[result|
			result.setBodyBorder(false);
			result.setHeadingHtml("<span style='font-size:12px;'>" + title
					+ "</span>");
			result.widget = w
		]
		container.setWidget(c)	
		if(w instanceof ResizeContainer){
			(w as ResizeContainer).forceLayout
		}
		container.forceLayout
		
	}

	
	override showActivatedPresenter(Presenter p){
		if(activePresenter!=null){
			activePresenter.deactivate
			activePresenter.getView().asWidget().removeFromParent
		}
		activePresenter = p
		var w = activePresenter.getView().asWidget
		container.setWidget(w)	
		if(w instanceof ResizeContainer){
			(w as ResizeContainer).forceLayout
		}
		container.forceLayout
		
	}
	
	override showPresenter(Presenter p){
		showPresenter(p)[]
	}
	override showPresenter(Presenter p,(void)=>void postInitializer){
		if(activePresenter!=null){
			activePresenter.deactivate
			activePresenter.getView().asWidget().removeFromParent
		}
		activePresenter = p
		activePresenter.activate[
			var w = activePresenter.getView().asWidget
			container.setWidget(w)	
			if(w instanceof ResizeContainer){
				(w as ResizeContainer).forceLayout
			}
			container.forceLayout
			postInitializer.apply(null)
		]
	}
	
	override asWidget(){
		container
	}
	
	override destory(){
		if(activePresenter!=null) activePresenter.deactivate
		
	}

	override clear() {
		if(activePresenter!=null){
			activePresenter.deactivate
			activePresenter.getView().asWidget().removeFromParent
		}
		activePresenter = null
	}
	
}