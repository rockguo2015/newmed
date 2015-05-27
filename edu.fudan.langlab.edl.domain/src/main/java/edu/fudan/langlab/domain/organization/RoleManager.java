package edu.fudan.langlab.domain.organization;

import java.util.Collection;

import edu.fudan.langlab.domain.security.AppRole;

public interface RoleManager {
	Collection<AppRole> getAllRoles();
}
