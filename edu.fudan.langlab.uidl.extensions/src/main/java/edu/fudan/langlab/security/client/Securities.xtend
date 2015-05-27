package edu.fudan.langlab.security.client

import com.google.inject.Inject
import com.uniquesoft.gwt.client.common.async.IInitializerSupport
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction
import edu.fudan.langlab.security.shared.IFunctionIdentifier
import edu.fudan.langlab.security.shared.FunctionIdentifier
import com.google.inject.Singleton

@Singleton
class Securities implements IInitializerSupport{
	//view.checkRequest.build[]
	//security.buildRequestFor(view.checkRequest)[]
	@Inject ISecurityManager securityManager;
	def void check(IFunctionIdentifier id, (void) => void initializer){
		if(securityManager.canAccess(id)){
			initializer.apply(null)
		}
	}

	def void check(String id, (void) => void initializer){
		if(securityManager.canAccess(new FunctionIdentifier(id))){
			initializer.apply(null)
		}
	}
	def void check(boolean requireCheck,String id, (void) => void initializer){
		if(!requireCheck)
			initializer.apply(null)
		else if(securityManager.canAccess(new FunctionIdentifier(id))){
			initializer.apply(null)
		}
	}

	def setAsSuperuser(){
		securityManager.setAsSuperuser
	}
	
	def registValidFunction(IFunctionIdentifier fi){
		securityManager.addFunctionIdentifier(fi)
	}

	override initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null)
	}
	
}