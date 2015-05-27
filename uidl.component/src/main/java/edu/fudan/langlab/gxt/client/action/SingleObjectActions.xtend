package edu.fudan.langlab.gxt.client.action

import com.uniquesoft.gwt.shared.GWTEntity
import com.sencha.gxt.widget.core.client.button.TextButton
import com.uniquesoft.gwt.client.common.action.BaseAction
import com.uniquesoft.gwt.client.common.action.SingleObjectAction
import com.uniquesoft.gwt.client.common.action.ActionContext
import com.uniquesoft.gwt.client.common.action.Requester

class SingleObjectActions<VT>  extends BaseAction<VT> implements SingleObjectAction<VT>{
	
	def static <VT extends GWTEntity>SingleObjectAction onExecuteDo((VT)=>void onExecute){
		var x = new SingleObjectActions<VT>()
		x.onExecute(onExecute)
		x
	}
	
	def static <VT> SingleObjectActions onSingleObjectAction(ActionContext<VT> actionContext, (SingleObjectActions)=>void init){
		var x = new SingleObjectActions<VT>()
		x.actionContext = actionContext
		init.apply(x)
		x
	}
	
	ActionContext<VT> actionContext
	
	VT selectedObject
	
	(VT)=>void onExecute
	
	(Void) => Boolean doCheckenable
	
	def onExecute((VT)=>void action){
		onExecute = action
	}
	
	def onCheckEnable((Void) => Boolean checkenable){
		doCheckenable = checkenable
	}
	override execute() {
		onExecute.apply(selectedObject)
	}
	
	override checkEnable(){
		if(doCheckenable == null)
			true
		else doCheckenable.apply(null)
	}

	override setSelectedObject(VT selectedObject) {
		this.selectedObject = selectedObject
	}
	
	def TextButton asButtonRequester(String name){
		var requester = new ButtonRequester(name)
		actionContext.registerAction(requester,this)
		requester.asWidget=>[width = 75]
	}
	
	def void attachOnRequester(Requester requester){
		actionContext.registerAction(requester,this)
	}
}