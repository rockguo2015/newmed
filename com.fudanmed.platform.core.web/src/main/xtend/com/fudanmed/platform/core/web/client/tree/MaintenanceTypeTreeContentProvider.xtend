package com.fudanmed.platform.core.web.client.tree

import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider
import java.util.Collection
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType

class MaintenanceTypeTreeContentProvider implements ITreeGridContentProvider<UIMaintenamceType>{

	Collection<UIMaintenamceType> elements = newArrayList
	new(Collection<UIMaintenamceType> elements){
		this.elements = elements
	}
	override getChildren(UIMaintenamceType parent) {
		elements.filter[it.parent?.id==parent.id]
	}
	override getRootElements() {
		elements.filter[it.parent==null]
	}
	
}