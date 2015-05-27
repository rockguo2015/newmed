package com.uniquesoft.uidl.extensions

import com.uniquesoft.gwt.shared.GWTEntity
import edu.fudan.mylang.pf.IModelObject

class ValidationExtensions {
	def static <T extends GWTEntity>  boolean isUnique(T uientity, (T)=>IModelObject valueFinder){
		var result = valueFinder.apply(uientity)
		if(uientity.id == null){
			result == null
		}else{
			result == null || (result.id == uientity.id)
		}		
	}
		
}