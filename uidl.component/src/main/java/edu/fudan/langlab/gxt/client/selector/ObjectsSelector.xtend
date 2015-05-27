package edu.fudan.langlab.gxt.client.selector

import com.sencha.gxt.widget.core.client.Dialog
import static extension  com.uniquesoft.gwt.shared.extensions.IterableExtensions2.*
import com.uniquesoft.gwt.client.common.Presenter
import com.uniquesoft.gwt.client.common.selector.IHasObjectSelectionProvider

class ObjectsSelector<T>{
	//p.asPopupSelector[]
	(Iterable<T>)=>void action
	IHasObjectSelectionProvider<T> presenter
	Iterable<T> selectedObjects
	new(IHasObjectSelectionProvider<T> presenter, (Iterable<T>)=>void action){
		this.action = action
		this.presenter = presenter
	}
	
	def asDialog(int width, int height){
		new Dialog()=>[dialog|
			dialog.width = width
			dialog.height = height
			dialog.setPredefinedButtons(Dialog$PredefinedButton::OK, Dialog$PredefinedButton::CANCEL);
			dialog.setModal(true)
			dialog.add((presenter as Presenter).getView().asWidget)
			dialog.getButtonById(Dialog$PredefinedButton::CANCEL.name())=>[
				addSelectHandler[
					if((presenter as Presenter).isActivated) (presenter as Presenter).deactivate
					dialog.hide
				]
			]
			presenter.selectionProvider.addSelectionChangedListener[Iterable<T> it|
				selectedObjects = it
			]
			dialog.getButtonById(Dialog$PredefinedButton::OK.name())=>[
				addSelectHandler[
					if(selectedObjects!=null)	action.apply(selectedObjects)
					if((presenter as Presenter).isActivated) (presenter as Presenter).deactivate
					dialog.hide
				]
			]
		]
	}
	
}