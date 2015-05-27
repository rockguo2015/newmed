package com.uniquesoft.gwt.shared.extensions

import java.util.Collection
import com.uniquesoft.gwt.shared.validation.ValidationException
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem

class IterableExtensions2 {
	def  static <T> Collection<T> unlazy(Iterable<T> iterable){
		val result = <T>newArrayList()
		iterable.forEach[
			result.add(it)
		]
		result		
	} 
	
	def static <T> forEachWithIndex(Iterable<T> iterables, (T,Long)=>void action){
		var Long index = 0l
		for(element : iterables){
			action.apply(element,index)
			index = index + 1
		}
	}
	
	def static <T> getOnlySelected(Iterable<T> iterables){
		if(iterables==null || iterables.size!=1)null
		else iterables.head
	}
	
	def static <T> forOnlySelected(Iterable<T> iterables,(T)=>void processor){
		if(iterables==null || iterables.size!=1)return
		else processor.apply(iterables.head)
	}
	
	def static <T> void forEachWithValidation(Iterable<T> datas,(T)=>void processor){
		val errors = <ValidationErrorItem>newArrayList
		forEachWithIndex(datas)[value,index|
			try{
				processor.apply(value)
			}catch(ValidationException e){
				errors.addAll(e.errors)
			}
		]
		if(errors.size()>0){
			throw new ValidationException(errors)
		}
	}	

}