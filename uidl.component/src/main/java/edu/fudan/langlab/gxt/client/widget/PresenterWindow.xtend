package edu.fudan.langlab.gxt.client.widget

import com.sencha.gxt.widget.core.client.Window
import com.uniquesoft.gwt.client.common.Presenter
import com.uniquesoft.gwt.client.common.Viewer
import com.uniquesoft.gwt.client.common.widgets.IHasSize
import com.uniquesoft.gwt.client.common.widgets.IHasTitle

class PresenterWindow{
	private Presenter<? extends Viewer> presenter
	private Window window
	new(Presenter<? extends Viewer> p){
		this.presenter = p
	}
	
	def void showWindow(){
		window = new Window=>[
			modal = true
			it.setResizable(false)
			maximizable = false
		]
		presenter.activate[
			window.widget = presenter.view.asWidget
			if(presenter.view instanceof IHasSize){
				var size = (presenter.view as IHasSize).size
				if(size.height!=0){
					window.height = size.height
				}
				if(size.width != 0){
					window.width = size.width
				}
			}else{
				window.maximize
			}
			if(presenter.view instanceof IHasTitle){
				window.headingText = (presenter.view as IHasTitle).title
			}
		]
		window.addHideHandler[
			presenter.deactivate
		]
		window.show()		
	}

	def void showActivatedWindow(){
		window = new Window=>[
			modal = true
			it.setResizable(false)
			maximizable = false
		]
		window.widget = presenter.view.asWidget
		if(presenter.view instanceof IHasSize){
			var size = (presenter.view as IHasSize).size
			if(size.height!=0){
				window.height = size.height
			}
			if(size.width != 0){
				window.width = size.width
			}
		}
		if(presenter.view instanceof IHasTitle){
			window.headingText = (presenter.view as IHasTitle).title
		}else{
			window.header.visible = false
		}
		window.addHideHandler[
			presenter.deactivate
		]
		window.show()	
		if(!(presenter.view instanceof IHasSize)){
			window.maximize
		}	
	}
	
}