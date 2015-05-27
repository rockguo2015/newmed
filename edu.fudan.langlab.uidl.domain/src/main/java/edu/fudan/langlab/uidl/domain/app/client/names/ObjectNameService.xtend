package edu.fudan.langlab.uidl.domain.app.client.names

import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction

class ObjectNameService extends edu.fudan.langlab.common.client.names.ObjectNameService{
	
	def dispatch internalGetId(UICodeType o){
		o.className
	}

	def dispatch String internalGetName(UICodeType o){
		o.name
	}
	def dispatch internalGetId(UIAppFunction function){
		function.id.toString
	}

	def dispatch String internalGetName(UIAppFunction function){
		function.name
	}
	
}
