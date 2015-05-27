package edu.fudan.mylang.common

class NumberExtensions {
	def static Integer nullsafe(Integer value){
		if(value==null) 0
		else value
	} 
	
	def static Double nullsafe(Double value){
		if(value==null) 0d else value
	}
	
	def static Float nullsafe(Float value){
		if(value==null)0f else value
	}
}