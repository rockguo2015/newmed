package com.uniquesoft.gwt.client.common.extensions

import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider

class ObjectSelectionProviders {
	def static <T> T getOnlySelected(ObjectSelectionProvider<T> op){
		var objects = op.selectedObjects
		if(objects==null || objects.size!=1) return null
		else return op.selectedObjects.findFirst[true]
	}
	def static <T> void forOnlySelected(ObjectSelectionProvider<T> op, (T)=>void processor){
		var objects = op.selectedObjects
		if(objects==null || objects.size!=1) return
		else processor.apply(op.selectedObjects.findFirst[true])
	}
	def static <T> Boolean isOnlySelectedAnd(ObjectSelectionProvider<T> op, (T)=>Boolean p){
		var objects = op.selectedObjects
		if(objects==null || objects.size!=1) return false
		return p.apply(op.selectedObjects.findFirst[true])
	}
	
}