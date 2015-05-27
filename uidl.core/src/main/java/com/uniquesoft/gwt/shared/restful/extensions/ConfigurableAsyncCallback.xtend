package com.uniquesoft.gwt.shared.restful.extensions

import com.google.gwt.http.client.RequestCallback
import com.google.gwt.http.client.Request
import com.google.gwt.http.client.Response

class ConfigurableRequestCallback implements RequestCallback {
	
	def static  ConfigurableRequestCallback callback((ConfigurableRequestCallback)=>void init) {
		val x = new ConfigurableRequestCallback()
		init.apply(x)
		return x
	}

	override onError(Request request, Throwable exception) {
		onFailure.apply(request,exception)
	}
	
	override onResponseReceived(Request request, Response response) {
		onSuccess.apply(request,response)
	}	
	
	(Request,Throwable)=>void onFailure = null
	(Request,Response)=>void onSuccess = null

	def void onSuccessDo((Request,Response)=>void onSuccess) {
		this.onSuccess = onSuccess
	}

	def void onFailureDo((Request,Throwable)=>void onFailure) {
		this.onFailure = onFailure
	}
}