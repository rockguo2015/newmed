package edu.fudan.langlab.gxt.client.validation

import com.google.common.collect.ArrayListMultimap
import com.google.gwt.editor.client.EditorError
import com.google.gwt.editor.client.HasEditorErrors
import com.sencha.gxt.widget.core.client.form.error.DefaultEditorError
import com.uniquesoft.gwt.client.common.GWTAbstractView
import com.uniquesoft.gwt.client.common.ViewerWithValidation
import com.uniquesoft.gwt.shared.validation.ValidationErrorItem
import java.util.Collection
import com.sencha.gxt.widget.core.client.info.Info

abstract class ErrorNotifierViewer extends GWTAbstractView implements ViewerWithValidation{
	
	def void clearErrors(){
		
	}
	
	def HasEditorErrors mapField(String errorKey){
		throw new UnsupportedOperationException
	}
	
	override showValidationErrors(Collection<ValidationErrorItem> errors){
		clearErrors
		val ArrayListMultimap<HasEditorErrors,EditorError> mm =ArrayListMultimap::create
		val (String)=>HasEditorErrors fieldMapper = [
			mapField(it)
		]
		errors.forEach[item|item.keys.forEach[
			val field = fieldMapper.apply(it)
			if(field==null)
				Info::display("数据校验错误",item.messageWithTitle)
			else
				mm.put(field,new DefaultEditorError(field,item.message,null))
		]]
		mm.keys.forEach[
			showErrors(mm.get(it))
		]
	}	
}