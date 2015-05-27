package edu.fudan.langlab.gxt.client.selector

import com.sencha.gxt.widget.core.client.Dialog
import static extension  com.uniquesoft.gwt.shared.extensions.IterableExtensions2.*
import com.uniquesoft.gwt.client.common.Presenter
import com.uniquesoft.gwt.client.common.selector.IHasObjectSelectionProvider

class ObjectSelector<T>{
	//p.asPopupSelector[]
	(T)=>void action
	IHasObjectSelectionProvider<T> presenter
	T selectedObject
	new(IHasObjectSelectionProvider<T> presenter, (T)=>void action){
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
				selectedObject = it.head
			]
			dialog.getButtonById(Dialog$PredefinedButton::OK.name())=>[
				addSelectHandler[
					if(selectedObject!=null)	action.apply(selectedObject)
					if((presenter as Presenter).isActivated) (presenter as Presenter).deactivate
					dialog.hide
				]
			]
		]
	}
	
	def static <T> asSelector(IHasObjectSelectionProvider<T> selectionProvider, String title, int width, int height,(T)=>void action){
		new ObjectSelector(selectionProvider,action).asDialog(width,height)=>[
			it.title = title
		]
	}
	def static <T> asMultiSelector(IHasObjectSelectionProvider<T> selectionProvider, String title, int width, int height,(Iterable<T>)=>void action){
		new ObjectsSelector(selectionProvider,action).asDialog(width,height)=>[
			it.title = title
		]
	}
	
}