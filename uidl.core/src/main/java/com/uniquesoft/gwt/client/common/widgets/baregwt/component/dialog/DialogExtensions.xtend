package com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog;

import com.uniquesoft.gwt.client.common.Presenter
/*
 * this class is binded with com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog.IManagableByDialog.
 * we can see the connection in language com.uniquesoft.lang.gwtentity.scoping.featurecalls.UIExtensionClassNameProvider:
 * put("com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog.IManagableByDialog",newArrayList("com.uniquesoft.gwt.client.common.widgets.baregwt.component.dialog.DialogExtensions"))
 * In UIDL,can use it like this:
 * val p = gwtGridPresenter.get
				p.asGWTDialog("List Grid")=>[
					center
					setWidth("800")
					show
				]
 * 
 */
class DialogExtensions {
	def static asGWTDialog(IManagableByDialog managableByDialog, String title){
		var dialog = new Dialog(managableByDialog as Presenter,title)
		dialog.initialize
		dialog
	}

	def static asGWTDialog(IManagableByDialog managableByDialog, String title, (Void)=>void postAction){
		var dialog = new Dialog(managableByDialog as Presenter,title)[postAction.apply(null)]
		dialog.initialize
		dialog
	}
	
	def static asGWTInfoDialog(IManagableByDialog managableByDialog, String title){
		var dialog = new Dialog(managableByDialog as Presenter,title)
		dialog.okOnly = true
		dialog.initialize
		dialog
	}	
}