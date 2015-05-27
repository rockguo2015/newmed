package edu.fudan.langlab.domain.organization

import edu.fudan.mylang.pf.BaseService
import java.util.List
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Collection


@Service("SystemRoleManager")
class SystemRoleManagerImpl extends BaseService implements SystemRoleManager{
	
	@Autowired(required=false)
	private List<RoleContributor> roleContributors;
	
	override Collection<RoleContributor> getRoleContributors(){
		return roleContributors;
	}
	
	override getRoleDescription(String roleid){
		roleContributors.findFirst[it.roleId == roleid]?.description
	}	

	override getRoleContributor(String roleid) {
		roleContributors.findFirst[it.roleId == roleid]
	}
	
}