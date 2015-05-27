package edu.fudan.langlab.domain.organization;

import java.util.Collection;

/*
 * 用于管理预定义的系统角色
 */
public interface SystemRoleManager {
	Collection<RoleContributor> getRoleContributors();
	String getRoleDescription(String roleid);
	RoleContributor getRoleContributor(String roleid);
}
