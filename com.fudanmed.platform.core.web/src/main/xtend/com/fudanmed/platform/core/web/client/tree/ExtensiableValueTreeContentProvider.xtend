package com.fudanmed.platform.core.web.client.tree

import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot
import java.util.Collection

class ExtensiableValueTreeContentProvider  implements ITreeGridContentProvider<UIAttributeSlot>{
	
	Collection<UIAttributeSlot> slots
	new(Collection<UIAttributeSlot> slots){
		this.slots = slots
	}	

	override getChildren(UIAttributeSlot parent) {
		slots.filter[it.parentSlot==parent]
	}
	
	override getRootElements() {
		slots.filter[it.parentSlot==null]
	}
	
}