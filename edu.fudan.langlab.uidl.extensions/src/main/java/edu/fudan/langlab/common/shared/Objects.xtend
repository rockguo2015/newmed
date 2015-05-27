package edu.fudan.langlab.common.shared

class Objects {
	def static <T> Boolean satisfy(T object, (T)=>Boolean predicate){
		if(object==null) return false
		return predicate.apply(object)
	}
	
	def static  <T> T nullsafe(T value, (Void)=>T creator){
		if(value==null) creator.apply(null)
		else value
	} 	
}