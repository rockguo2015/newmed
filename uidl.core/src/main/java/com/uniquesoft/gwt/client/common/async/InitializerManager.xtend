package com.uniquesoft.gwt.client.common.async

import java.util.Collection
/**
 * This class is used to make sure all the components in the view has initialized.
 * The components can initialize asynchronously. When all the components have finished to 
 * get the necessary data, the view continue to display them.  
 * 
 */

class InitializerManager {
	
	def static initialize(Collection<? extends IInitializerSupport>  initializerSupports, IPostInitializeAction postAction){
		if(initializerSupports.size==0){
			if(postAction!=null)postAction.initializeFinished(null)
		}else{
			val Collection<IInitializerSupport> initializing = newHashSet
			initializerSupports.forEach[
				initializing.add(it)
			]
			initializerSupports.forEach[initializerSupport|
				initializerSupport.initialize[
					initializing.remove(initializerSupport)
					if(initializing.empty)
						postAction.initializeFinished(null)
				]
			]		
		}
		
	}
}