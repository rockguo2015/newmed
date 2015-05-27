package com.fudanmed.platform.core.web.client.tree

import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider
import java.util.Collection

class ProductCategoryTreeContentProvider implements ITreeGridContentProvider<UIProductCategory>{

	Collection<UIProductCategory> elements = newArrayList
	new(Collection<UIProductCategory> elements){
		this.elements = elements
	}
	override getChildren(UIProductCategory parent) {
		elements.filter[it.parent?.id==parent.id]
	}
	
	override getRootElements() {
		elements.filter[it.parent==null]
	}
	
}