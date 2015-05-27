package com.uniquesoft.gwt.client.common.command

import com.google.gwt.event.shared.EventBus
import com.google.gwt.user.client.rpc.AsyncCallback
import com.google.inject.Inject
import com.uniquesoft.gwt.client.common.SessionTimeoutEvent
import com.uniquesoft.gwt.client.common.action.ActionContext
import com.uniquesoft.gwt.client.common.async.IInitializerSupport
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback
import com.uniquesoft.gwt.shared.command.IContextConsumer
import com.uniquesoft.gwt.shared.command.IValueConsumer

abstract class BaseCommand implements IInitializerSupport{
	@Inject protected EventBus eventBus
	
	def String getTitle()
	
	def String getActionId()
	
	def boolean requireCheck(){
		true
	}
	
	override initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null)
	}

	def <T extends Object> AsyncCallback<T> onSuccess(
			 (T)=>void onSuccess) {
		var ConfigurableAsyncCallback<T> callback = new ConfigurableAsyncCallback<T>();
		callback.onSuccessDo(onSuccess);
		callback.onSessionTimeoutDo[eventBus.fireEvent(new SessionTimeoutEvent())]
		callback		
	}
	
}

abstract class BaseSimpleCommand extends BaseCommand{
	
	def void execute()
	
	def boolean checkEnable(){
		true
	}
	
}


abstract class BaseContextAwareSingleObjectCommand<T> extends BaseCommand implements IContextConsumer<T>,IValueConsumer<T>{
	
	ActionContext<? extends T> actionContext
	def getContext() {
		actionContext
	}
	override setContext(ActionContext<T> actionContext) {
		this.actionContext = actionContext
	}

	()=>T valueProvider
	def getValueProvider(){
		valueProvider
	}
	override setValueProvider(()=>T valueProvider){
		this.valueProvider = valueProvider
	}

	
	def void execute(T value)
	
	def boolean checkEnable(T value){
		true
	}
	
}

abstract class BaseContextAwareMultiObjectCommand<T> extends BaseCommand implements IContextConsumer<T>{
	
	ActionContext<? extends T> actionContext
	def getContext() {
		actionContext
	}
	
	override setContext(ActionContext<T> actionContext) {
		this.actionContext = actionContext
	}
	
	def void execute(Iterable<T> value)
	
	def boolean checkEnable(Iterable<T> value){
		value.size>0
	}
}