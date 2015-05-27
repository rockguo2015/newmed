package com.fudanmed.platform.core.security;

import org.springframework.stereotype.Component;

import edu.fudan.langlab.domain.organization.RoleContributor;

@Component("DummyRoleContributor")
public class DummyRoleContributor implements RoleContributor {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRoleId() {
		// TODO Auto-generated method stub
		return null;
	}

}
