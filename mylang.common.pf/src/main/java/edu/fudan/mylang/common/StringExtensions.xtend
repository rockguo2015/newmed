package edu.fudan.mylang.common

class StringExtensions {
	def static nullsafe(String value){
		if(value==null) "" else value
	}
	def static toSqlLike(String value){
		if(value==null) "%"
		else "%" + value + "%"
	}
}