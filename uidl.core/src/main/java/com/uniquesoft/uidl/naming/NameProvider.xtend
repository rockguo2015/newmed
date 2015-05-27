package com.uniquesoft.uidl.naming


public abstract class AbstractNameProvider implements INameProvider{


	override getName(Object entity) {
		doGetName(entity);
	}

	
	def dispatch String doGetName(Object entity){
		entity.getClass.name + "[" + entity.hashCode.toString+"]"
	}
	
}