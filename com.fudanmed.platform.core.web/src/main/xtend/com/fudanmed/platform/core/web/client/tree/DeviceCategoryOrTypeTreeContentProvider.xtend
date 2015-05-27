package com.fudanmed.platform.core.web.client.tree

import com.fudanmed.platform.core.web.shared.device.UIDeviceCategoryAndType
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider
import java.util.Collection

class DeviceCategoryOrTypeTreeContentProvider implements ITreeGridContentProvider<UIDeviceCategoryAndType>{
	
	Collection<UIDeviceCategoryAndType> elements = newArrayList
	new(Collection<UIDeviceCategoryAndType> elements){
		this.elements = elements
	}

	override getChildren(UIDeviceCategoryAndType parent) {
		elements.filter[it.parent==parent]
	}
	
	override getRootElements() {
		elements.filter[it.parent==null]
	}
	
}