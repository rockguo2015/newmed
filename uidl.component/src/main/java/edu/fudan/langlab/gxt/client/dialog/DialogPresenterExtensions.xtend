package edu.fudan.langlab.gxt.client.dialog

import com.uniquesoft.gwt.client.common.CommitablePresenter
import com.uniquesoft.gwt.client.common.Presenter
import com.uniquesoft.gwt.client.common.widgets.IHasSize
import com.uniquesoft.gwt.client.common.widgets.IHasTitle

class DialogPresenterExtensions {
	def static GXTDialog asDialog(CommitablePresenter dialogPresenter){
		var result = new GXTDialog(dialogPresenter)
		val view = (dialogPresenter as Presenter).view
		if(view instanceof IHasTitle){
			result.headingText = (view as IHasTitle).title
		}
		if(view instanceof IHasSize){
			var size = ((dialogPresenter as Presenter).view as IHasSize).size
			result.width = size.width
			result.height = size.height
		}
		result.show
		result
	}

	def static GXTDialog asActivatedDialog(CommitablePresenter dialogPresenter){
		var result = new GXTDialog(dialogPresenter,true)
		val view = (dialogPresenter as Presenter).view
		if(view instanceof IHasTitle){
			result.headingText = (view as IHasTitle).title
		}else{
			result.header.visible = false
		}
		if(view instanceof IHasSize){
			var size = ((dialogPresenter as Presenter).view as IHasSize).size
			result.width = size.width
			result.height = size.height
		}
		result.show
		result
	}

	
	def static GXTDialog asDialog(CommitablePresenter dialogPresenter, String title){
		var result = new GXTDialog(dialogPresenter)
		result.headingText = title
		if((dialogPresenter as Presenter).view instanceof IHasSize){
			var size = ((dialogPresenter as Presenter).view as IHasSize).size
			result.width = size.width
			result.height = size.height
		}
		result.show
		result
	}

	def static GXTDialog asDialog(CommitablePresenter dialogPresenter, String title, Integer width){
		var result = new GXTDialog(dialogPresenter)
		result.headingText = title
		result.setWidth(width)
		result.show
		result
	}	
	
	def static GXTDialog asDialog(CommitablePresenter dialogPresenter, String title, Integer width, Integer height){
		var result = new GXTDialog(dialogPresenter)
		result.headingText = title
		result.setWidth(width)
		result.setHeight(height)
		result.show
		result
	}	
}