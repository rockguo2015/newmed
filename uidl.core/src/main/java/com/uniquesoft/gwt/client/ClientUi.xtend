package com.uniquesoft.gwt.client

import com.google.gwt.user.client.ui.ComplexPanel
import com.google.gwt.user.client.ui.HasWidgets
import com.google.gwt.user.client.ui.Widget
import com.uniquesoft.gwt.client.common.GWTAbstractView

import static com.uniquesoft.gwt.client.ClientUi.*

class ClientUi {
	def static <T> T with(T obj, (T)=>void init) {
		init.apply(obj)
		return obj
	}
	
	def static <T> T lazy(T o, (void)=>T init){
		if(o!=null) return o
		init.apply(null)
	}

	def static void operator_add(HasWidgets it, Widget widget) {
		it.add(widget)
	}
	def static void operator_add(ComplexPanel it, Widget widget) {
		it.add(widget)
	}
	
	def static void operator_add(GWTAbstractView it, Widget widget) {
		it.addWidget(widget)
	}
	
//	def static void  operator_add( Layout it,  Canvas canvas ){
//	  it.addMember(canvas);
// 	}
// 	
// 	def static void operator_add(Layout it, Widget widget){
// 		it.addMember(widget)
// 	}
 	
 	def static boolean isNullOrEmpty(Object object){
 		if(object==null) return true
 		else return doIsNullOrEmptyCheck(object)
 	}
 	
 	def static dispatch boolean doIsNullOrEmptyCheck(String s){
 		return s==null || s.trim.length==0
 	}
 	
 	def static dispatch boolean doIsNullOrEmptyCheck(Object object){
 		return object == null
 	}
 	
 	def static dispatch boolean doIsNullOrEmptyCheck(Enum<?> enumValue){
 		return enumValue == null
 	}
}