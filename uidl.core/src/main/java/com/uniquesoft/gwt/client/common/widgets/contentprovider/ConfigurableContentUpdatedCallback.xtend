package com.uniquesoft.gwt.client.common.widgets.contentprovider


class ConfigurableContentUpdatedCallback implements ContentLoadedCallback{
	
	def static ContentLoadedCallback onContentUpdated((Void)=>void onContentUpdated){
		var x = new ConfigurableContentUpdatedCallback()
		x.onContentUpdatedDo(onContentUpdated)
		return x
	}
	
	(Void)=>void onContentUpdated
	
	def void onContentUpdatedDo((Void)=>void action){
		onContentUpdated = action
	}

	override contentLoaded() {
		onContentUpdated.apply(null)
	}
}