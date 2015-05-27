package edu.fudan.langlab.common.client.names
import com.uniquesoft.gwt.shared.GWTNamedEntity
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider
import java.util.Date
import com.google.gwt.i18n.client.DateTimeFormat
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction

class ObjectNameService  implements IObjectNameProvider{

	override getId(Object o) {
		if(o==null) return null
		else return internalGetId(o)
	}
	
	override getName(Object o) {
		if(o==null)
			return ""
		else {
			var n = internalGetName(o)
			if(n==null) "" else n
		}
	}
	
	def dispatch String internalGetId(Object o){
		"_OBJ_ID_"+o.hashCode.toString
	}
	
	def dispatch internalGetId(GWTNamedEntity o){
		"_OBJ_ID_"+o.getId()
	}
	
	def dispatch internalGetId(Boolean o){
		"_OBJ_ID_"+o.toString
	}
	
	def dispatch String internalGetName(Object o){
		o.toString
	}

	def dispatch String internalGetName(GWTNamedEntity o){
		o.name
	}

	def dispatch String internalGetId(Enum enumObject){
		enumObject.name
	}
	
	def dispatch String internalGetName(Enum enumObject){
		enumObject.toString
	}
	
	def dispatch String internalGetName(Boolean o){
		if(o) "是" else "否"
	}
	
	def dispatch String internalGetName(Date value){
		if(value==null) return ''
		else DateTimeFormat::getFormat("yy/MM/dd").format(value)
	}
	
	override initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null)
	}
	
}