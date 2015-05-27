package edu.fudan.langlab.uidl.domain.app.server.service.login;

import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;

import java.util.Collection;
public interface ISecurityService {
	User login(String userid, String passwd);
	Collection<? extends IFunctionIdentifier> loadValidFunctions4User(String userid);
}
