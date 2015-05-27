package com.fudanmed.platform.core.web.client.tree

import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider
import java.util.Collection
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory

class DeviceTypeCategoryTreeContentProvider implements ITreeGridContentProvider<UIDeviceTypeCategory>{

	Collection<UIDeviceTypeCategory> elements = newArrayList
	new(Collection<UIDeviceTypeCategory> elements){
		this.elements = elements
	}
	override getChildren(UIDeviceTypeCategory parent) {
		elements.filter[it.parent?.id==parent.id]
	}
	
	override getRootElements() {
		elements.filter[it.parent==null]
	}
	
}