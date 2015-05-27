package edu.fudan.langlab.security.client;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

import edu.fudan.langlab.security.shared.IFunctionIdentifier;

@ImplementedBy(SecurityManagerImpl.class)
@Singleton
public interface ISecurityManager {
	
	void setAsSuperuser();

	boolean canAccess(IFunctionIdentifier identifier);

	void addFunctionIdentifier(IFunctionIdentifier identifier);

}
