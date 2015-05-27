package com.fudanmed.platform.core.web.client.tree

import edu.fudan.langlab.gxt.shared.component.treegrid.ITreeGridContentProvider
import com.fudanmed.platform.core.web.shared.organization.UIOrganization
import java.util.Collection

class OrganizationTreeContentProvider implements ITreeGridContentProvider<UIOrganization>{
	
	Collection<UIOrganization> organizations = newArrayList
	new(Collection<UIOrganization> organizations){
		this.organizations = organizations
	}
	override getChildren(UIOrganization parent) {
		organizations.filter[it.parent?.id==parent.id]
	}

	override getRootElements() {
		organizations.filter[it.parent==null]
	}
	
}