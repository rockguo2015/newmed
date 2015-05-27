package com.uniquesoft.gwt.client.common.extensions

import com.google.gwt.safehtml.shared.SafeHtmlBuilder

class SafeHtmlBuilderExtensions {
	def static highlightIf(SafeHtmlBuilder sb, Object value, (Void)=>Boolean checker){
		if(checker.apply(null))
			sb.appendHtmlConstant("<font color='red'>"+value.toString+"</font>")
		else
			sb.appendHtmlConstant(value.toString)
	}
	
	def static progressInfoNoMoreThan(Integer first, Integer second){
		if(first>second){
			"<font color='red'>"+first.toString+"</font>"
		}else if(first == second){
			"<font color='green'>"+first.toString+"</font>"
		}else{
			"<B>"+first.toString+"</B>"
		}
	}
	def static progressInfo(Integer first, Integer second){
		if(first>=second){
			"<font color='green'>"+first.toString+"</font>"
		}else{
			"<B>"+first.toString+"</B>"
		}
	}
	def static progressInfoNoMoreThan(Double f, Double s){
		val first = (f * 100).intValue
		val second = (s * 100).intValue
		if(first>second){
			"<font color='red'>"+f.toString+"</font>"
		}else if(first == second){
			"<font color='green'>"+f.toString+"</font>"
		}else{
			"<B>"+f.toString+"</B>"
		}
	}
	def static progressInfoNoMoreThan(Double f, Double s, String content){
		val first = (f * 100).intValue
		val second = (s * 100).intValue
		if(first>second){
			"<font color='red'>"+content+"</font>"
		}else if(first == second){
			"<font color='green'>"+content+"</font>"
		}else{
			"<B>"+content+"</B>"
		}
	}
	def static progressInfoCountDown(Double f, Double s){
		val first = (f * 100).intValue
		val second = (s * 100).intValue
		if(first<second){
			"<font color='red'>"+f.toString+"</font>"
		}else if(first==second){
			"<font color='green'>"+f.toString+"</font>"
		}else{
			"<B>"+f.toString+"</B>"
		}
	}
	def static progressInfo(Double f, Double s){
		val first = (f * 100).intValue
		val second = (s * 100).intValue
		if(first>=second){
			"<font color='green'>"+f.toString+"</font>"
		}else{
			"<B>"+f.toString+"</B>"
		}
	}

	def static hightlightIfLessThan(Integer first, Integer second){
		if(first<second){
			"<font color='red'>"+first.toString+"</font>"
		}else if(first == second){
			"<font color='green'>"+first.toString+"</font>"
		}else{
			"<B>"+first.toString+"</B>"
		}
	}
	
	def static progressInfo(Boolean finished){
		if(finished){
			"<font color='green'>已完成</font>"
		}else{
			"<B>未完成</B>"
		}
	}

}