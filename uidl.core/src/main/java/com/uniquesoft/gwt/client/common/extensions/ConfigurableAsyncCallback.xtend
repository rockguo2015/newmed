package com.uniquesoft.gwt.client.common.extensions

import com.uniquesoft.gwt.client.common.ServiceCallback
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem
import java.util.Collection
/**
 * Set special kinds of validation errors for the callback.
 */
class ConfigurableAsyncCallback<T> extends ServiceCallback<T> {
	
	def static <T> ConfigurableAsyncCallback<T> callback((ConfigurableAsyncCallback<T>)=>void init) {
		val x = new ConfigurableAsyncCallback<T>()
		init.apply(x)
		return x
	}
	
	(Throwable)=>void onFailure = null
	(T)=>void onSuccess = null
	(Collection<ValidationErrorItem>) => void onValidationFailure = null

	def void onSuccessDo((T)=>void onSuccess) {
		this.onSuccess = onSuccess
	}
	
	(Void)=>void onSessionTimeout
	def void onSessionTimeoutDo((Void)=>void onSessionTimeout){
		this.onSessionTimeout = onSessionTimeout
	}

	def void onFailureDo((Throwable)=>void onFailure) {
		this.onFailure = onFailure
	}
	
	def void onValidationFailureDo((Collection<ValidationErrorItem>) => void onValidationFailure){
		this.onValidationFailure = onValidationFailure
	}

	override onFailure(Throwable caught) {
		if(onFailure!=null)
			this.onFailure.apply(caught)
		else
			super.onFailure(caught)
	}

	override onSuccess(T result) {
		this.onSuccess.apply(result)
	}

	override onSessionTimeOutException(){
		this.onSessionTimeout.apply(null)
	}
	override onValidationException(Collection<ValidationErrorItem> errors){
		if(onValidationFailure!=null)
			this.onValidationFailure.apply(errors)
		else
			super.onValidationException(errors)
	}

}