package com.fudanmed.platform.core.web.client.tree

import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider
import java.util.Collection
import com.fudanmed.platform.core.web.shared.project.UIGeneralTask

class GeneralTaskTreeContentProvider  implements ITreeGridContentProvider<UIGeneralTask>{
	Collection<UIGeneralTask> tasks
	
	new(Collection<UIGeneralTask> tasks){
		this.tasks = tasks
	}

	override getChildren(UIGeneralTask parent) {
		tasks.filter[it.parent!=null && it.parent==parent.hashCode]
	}
	
	override getRootElements() {
		tasks.filter[it.parent==null]
	}
	
}