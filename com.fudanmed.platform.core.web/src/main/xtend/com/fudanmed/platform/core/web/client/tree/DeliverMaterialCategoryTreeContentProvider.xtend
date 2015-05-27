package com.fudanmed.platform.core.web.client.tree

import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory
import java.util.Collection

class DeliverMaterialCategoryTreeContentProvider  implements ITreeGridContentProvider<UIDeliverMaterialCategory>{
	
	Collection<UIDeliverMaterialCategory> elements = newArrayList
	new(Collection<UIDeliverMaterialCategory> elements){
		this.elements = elements
	}

	override getChildren(UIDeliverMaterialCategory parent) {
		elements.filter[it.parentCategory==parent]
	}
	
	override getRootElements() {
		elements.filter[it.parentCategory==null]
	}
	
}
	