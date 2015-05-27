package edu.fudan.langlab.gxt.client.action

import com.uniquesoft.gwt.client.common.action.BaseAction
import com.uniquesoft.gwt.client.common.action.MutilObjectAction
import com.uniquesoft.gwt.client.common.action.ActionContext
import com.sencha.gxt.widget.core.client.button.TextButton

class MultiObjectActions<VT>  extends BaseAction<VT> implements MutilObjectAction<VT>{

	ActionContext<VT> actionContext
	
	Iterable<VT> selectedObjects	
	
	def static <VT> MultiObjectActions onMultiObjectAction(ActionContext<VT> actionContext, (MultiObjectActions)=>void init){
		var x = new MultiObjectActions<VT>()
		x.actionContext = actionContext
		init.apply(x)
		x
	}

	(Iterable<VT>)=>void onExecute
	
	(Void) => Boolean doCheckenable
	
	def onExecute((Iterable<VT>)=>void action){
		onExecute = action
	}
	
	def onCheckEnable((Void) => Boolean checkenable){
		doCheckenable = checkenable
	}

	override execute() {
		onExecute.apply(selectedObjects)
	}
	
	override checkEnable(){
		if(doCheckenable == null)
			true
		else doCheckenable.apply(null)
	}
	
	override setSelectedObject(Iterable<VT> selectedObjects) {
		this.selectedObjects = selectedObjects
	}
	
	def TextButton asButtonRequester(String name){
		var requester = new ButtonRequester(name)
		actionContext.registerAction(requester,this)
		requester.asWidget=>[width = 75]
	}
	
}