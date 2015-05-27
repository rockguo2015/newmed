package edu.fudan.langlab.gxt.client.dialog

import com.sencha.gxt.widget.core.client.box.MessageBox
import com.sencha.gxt.widget.core.client.Dialog

class MessageBoxExtensions {
	def static addConfirmHandler(MessageBox messageBox, (Void)=>void handler){
		messageBox.addHideHandler[event|
			var buttonID = (event.source as Dialog).hideButton.itemId
			if(buttonID.equals(Dialog$PredefinedButton::YES.name ) || buttonID.equals(Dialog$PredefinedButton::OK.name )){
				handler.apply(null)
			}			
		]
	}
}