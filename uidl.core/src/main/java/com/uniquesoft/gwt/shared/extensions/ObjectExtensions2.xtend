package com.uniquesoft.gwt.shared.extensions

class ObjectExtensions2 {
	def static  <T> T withDefault(T value, (Void)=>T creator){
		if(value==null) creator.apply(null)
		else value
	} 
	def static  <T> ifNotNull(T value, (T)=>void action){
		if(value==null) action.apply(value)
	} 
	
}