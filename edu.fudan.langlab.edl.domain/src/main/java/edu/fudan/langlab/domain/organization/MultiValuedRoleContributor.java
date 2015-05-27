package edu.fudan.langlab.domain.organization;

import java.util.Collection;

public interface MultiValuedRoleContributor extends RoleContributor {
	Collection<? extends Party> getParties();
}
