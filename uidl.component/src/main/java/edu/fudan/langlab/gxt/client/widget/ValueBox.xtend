package edu.fudan.langlab.gxt.client.widget

import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider
//import com.sencha.gxt.widget.core.client.Dialog
import com.uniquesoft.gwt.client.common.widgets.Size
import com.google.gwt.user.client.ui.Widget
import com.sencha.gxt.widget.core.client.Dialog
import com.sencha.gxt.widget.core.client.Dialog$PredefinedButton
class ValueDialog<T> {
	
	(T) => void valueProcessor
	IValueProvider<T> valueProvider
	
	new(IValueProvider<T> valueProvider,(T) => void valueProcessor){
		this.valueProvider = valueProvider
		this.valueProcessor = valueProcessor
	}
	
	def show(String title, Size size){
		val dialog = new Dialog
		dialog.setPredefinedButtons(PredefinedButton::OK, PredefinedButton::CANCEL);
		dialog.setModal(true)
		dialog.add(valueProvider.asWidget as Widget)
		dialog.getButtonById(PredefinedButton::CANCEL.name()).
			addSelectHandler[
				dialog.hide
			]
		dialog.getButtonById(PredefinedButton::OK.name()).
			addSelectHandler[
				if(valueProcessor!=null)
					valueProcessor.apply(valueProvider.value)
					dialog.hide
			]
		dialog.show
	}
}