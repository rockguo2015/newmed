package edu.fudan.langlab.gxt.client.widget

import com.google.gwt.user.client.ui.Widget
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer$VerticalLayoutData
import com.sencha.gxt.widget.core.client.form.FieldLabel
import com.sencha.gxt.widget.core.client.form.FormPanel$LabelAlign
class WidgetExtensions {
	
	def static <T extends Widget> T addFill(VerticalLayoutContainer vcontainer, T widget){
		vcontainer.add(widget, new VerticalLayoutData(-10,-1))
		widget
	}
	def static Widget withBorder(Widget widget){
		val result = new com.sencha.gxt.widget.core.client.ContentPanel();
		result.setHeaderVisible(false);
		result.widget = widget
		result
	}
	
	def static Widget withFieldSet(Widget widget,String title){
		val fieldSet = new com.sencha.gxt.widget.core.client.form.FieldSet();
		fieldSet.setHeadingText(title);
		fieldSet.widget = widget
		fieldSet		
	}
	
	def static FieldLabel alignTop(FieldLabel label){
		label.labelAlign = FormPanel$LabelAlign::TOP
		label
	}	
}