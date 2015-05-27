package edu.fudan.langlab.domain.security;

import edu.fudan.langlab.domain.organization.Party;

public interface ISystemUserService {
	User getCurrentUser();
	void setCurrentUser(User user);
	Party getCurrentUserAsParty();
}
