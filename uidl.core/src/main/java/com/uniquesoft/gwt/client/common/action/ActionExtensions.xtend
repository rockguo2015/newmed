package com.uniquesoft.gwt.client.common.action

import com.uniquesoft.gwt.client.common.widgets.ObjectListView
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider

class ActionExtensions {
	
	def static <V> createActionContext(ObjectSelectionProvider<V> objectSelectionProvider){
		new ActionContext<V>(objectSelectionProvider)
	}
	
	def static <V> createActionContext(ObjectListView<V> objectListView){
		val ac = new ActionContext<V>(objectListView)
		objectListView.addContentChangedListener[
			ac.updateStates
		]
		ac
	}
	
	def static <V> Boolean singleSelectedAnd(ObjectSelectionProvider<V> objectListView, (V)=>Boolean andOperation){
		if(objectListView.selectedObjects == null || objectListView.selectedObjects.size!=1) return false
		andOperation.apply(objectListView.selectedObjects.findFirst[true])
	}
}