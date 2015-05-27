package edu.fudan.langlab.uidl.domain.app.client.workbench

import com.uniquesoft.gwt.client.common.Presenter
import com.google.gwt.event.shared.EventBus
import com.uniquesoft.gwt.client.common.AbstractPresenter
import com.uniquesoft.gwt.client.common.Viewer

abstract class WorkbenchAbstractPresenter<V extends Viewer> extends AbstractPresenter<V>{
	
	new(V display, EventBus eventBus) {
		super(display, eventBus)
	}
	
	def popup(Presenter<?> window){
		eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(window));
	}
}