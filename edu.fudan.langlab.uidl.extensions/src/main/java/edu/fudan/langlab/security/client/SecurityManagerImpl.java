package edu.fudan.langlab.security.client;

import java.util.Collection;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

import edu.fudan.langlab.security.shared.IFunctionIdentifier;

@Singleton
public class SecurityManagerImpl implements ISecurityManager {
	
	Collection<IFunctionIdentifier> functionIdentifiers = Lists.newArrayList();
	private boolean isSuperUser;

	@Override
	public boolean canAccess(IFunctionIdentifier identifier) {
		if (isSuperUser)
			return true;
		else
			return functionIdentifiers.contains(identifier);
	}

	@Override
	public void addFunctionIdentifier(IFunctionIdentifier identifier) {
		functionIdentifiers.add(identifier);

	}

	@Override
	public void setAsSuperuser() {
		this.isSuperUser = true;
	}

}
