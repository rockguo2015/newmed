package edu.fudan.langlab.gxt.client.component.form

import com.google.gwt.editor.client.HasEditorErrors
import com.sencha.gxt.widget.core.client.form.FieldLabel
import edu.fudan.langlab.gxt.client.component.form.factory.ComponentDelegateValueProvider

import static edu.fudan.langlab.gxt.client.component.form.Validations.*

class Validations {
	
	def static HasEditorErrors mapToErrorEditor(GXTFormComponent form, String errorKey){
		var head = errorKey
		var tail = ""
		if(errorKey.indexOf('.')>0){
			head = errorKey.substring(0,errorKey.indexOf('.'))
			tail = errorKey.substring(errorKey.indexOf('.')+1)	 
		}
		try{
			var widget = form.getWidget(head)
			if(widget==null){
				return null;
			}else if(widget instanceof ComponentDelegateValueProvider){
				return mapToErrorEditor((widget as ComponentDelegateValueProvider).deletate as GXTFormComponent,tail)
			}else
				return (widget.asWidget as FieldLabel).widget as HasEditorErrors
		}catch(Exception e){
			throw new RuntimeException(e)
		}
	}
	
	def static void clearErrors(GXTFormComponent form){
		form.allProperties.forEach[
			val w = it.asWidget
			if(w!=null && w instanceof FieldLabel && (w as FieldLabel).widget instanceof HasEditorErrors)
				((w as FieldLabel).widget as HasEditorErrors).showErrors(newArrayList)
		]
	}
}