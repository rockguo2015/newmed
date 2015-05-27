package com.fudanmed.platform.core.web.client.tree

import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition
import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider
import java.util.Collection

class OnsitePositionTreeContentProvider implements ITreeGridContentProvider<UIOnsitePosition>{

	Collection<UIOnsitePosition> positions = newArrayList
	new(Collection<UIOnsitePosition> positions){
		this.positions = positions
	}
	override getChildren(UIOnsitePosition parent) {
		positions.filter[it.parent?.id==parent.id]
	}
	
	override getRootElements() {
		positions.filter[it.parent==null]
	}
	
}