package edu.fudan.langlab.csv.shared

import java.util.Map
import java.util.Collection
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2
import com.uniquesoft.gwt.shared.validation.ValidationException

class CSVValidationExtensions {
	
	def static <T> void forEachWithCVSValidation(Iterable<T> datas,(T)=>void processor,(String)=>String keyTitleMapper){
		val Map<Integer, Collection<ValidationErrorItem>> errors = newHashMap();
		IterableExtensions2::forEachWithIndex(datas)[value,index|
			try{
				processor.apply(value)
			}catch(ValidationException e){
				errors.put((index+1).intValue,e.errors)
			}
		]
		var keyTitleMap = errors.values.flatten.map[keys].flatten.filter[!nullOrEmpty].toSet.toInvertedMap[
			val result = keyTitleMapper.apply(it)
			if(result==null) it else result
		]
		
		if(errors.size()>0){
			throw new CSVValidationException(keyTitleMap,errors)
		}
	}	
}