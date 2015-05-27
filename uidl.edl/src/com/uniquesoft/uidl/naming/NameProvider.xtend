package com.uniquesoft.uidl.naming

import edu.fudan.mylang.pf.IModelObject
import edu.fudan.mylang.pf.INamedModelObject
import org.springframework.stereotype.Service

public abstract class EDLAbstractNameProvider implements INameProvider{


	override getName(Object entity) {
		doGetName(entity);
	}

	
	def dispatch String doGetName(IModelObject entity){
		if(entity instanceof INamedModelObject){
			(entity as INamedModelObject).entityName
		}else
			entity.getClass.name + "[" + entity.id.toString+"]"
	}
	
	def dispatch String doGetName(Object entity){
		entity?.toString
	}
	
}

@Service("NameProvider")
public class NameProvider extends EDLAbstractNameProvider{

}