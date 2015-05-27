package edu.fudan.langlab.uidl.domain.app.client;


public interface WorkbenchPartProxy {

	WorkbenchPartCategory getCategory();
	
	String getFunctionId();
	
	String getName();
	
	Boolean requireCheck();

}
