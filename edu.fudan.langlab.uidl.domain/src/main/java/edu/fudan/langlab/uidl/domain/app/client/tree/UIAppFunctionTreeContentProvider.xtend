package edu.fudan.langlab.uidl.domain.app.client.tree

import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeContentProvider
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction

class UIAppFunctionTreeContentProvider implements ITreeContentProvider<UIAppFunction>{
	override getChildren(UIAppFunction parent,Iterable<UIAppFunction> functions) {
		functions.filter[it.parentFunctionId == parent.functionId]
	}

	override getRootElements(Iterable<UIAppFunction> functions) {
		functions.filter[it.parentFunctionId==null]
	}
	
}