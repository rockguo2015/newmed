package com.fudanmed.platform.core.web.client.tree

import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory
import java.util.Collection

class DeliverPatientCheckCategoryTreeContentProvider  implements ITreeGridContentProvider<UIDeliverPatientCheckCategory>{
	
	Collection<UIDeliverPatientCheckCategory> elements = newArrayList
	new(Collection<UIDeliverPatientCheckCategory> elements){
		this.elements = elements
	}

	override getChildren(UIDeliverPatientCheckCategory parent) {
		elements.filter[it.parentCategory==parent]
	}
	
	override getRootElements() {
		elements.filter[it.parentCategory==null]
	}
	
}
	