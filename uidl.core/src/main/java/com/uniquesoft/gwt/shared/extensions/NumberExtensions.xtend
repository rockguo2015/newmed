package com.uniquesoft.gwt.shared.extensions
import com.google.gwt.i18n.client.NumberFormat
class NumberExtensions {
	
	def static SequenceGenerator sequence(Integer start){
		return new SequenceGenerator(start)
	}
	
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
	
	def static Double asCurrency(Double c){
		Math::floor(c * 100)/100
	}
	
	def static String asCurrencyString(Double amount){
		if(amount==null || amount==0)
			'--'
		else 
			NumberFormat::getFormat('#,###.00').format(amount)
	}
	def static String asBareCurrencyString(Double amount){
		if(amount==null || amount==0)
			'--'
		else 
			NumberFormat::getFormat('#,###').format(amount)
	}

	def static String asPercentString(Double amount){
		if(amount==null || amount==0)
			'--'
		else 
			NumberFormat::getFormat('###').format(Math::round(amount*100)) + '%'
			
	}

}