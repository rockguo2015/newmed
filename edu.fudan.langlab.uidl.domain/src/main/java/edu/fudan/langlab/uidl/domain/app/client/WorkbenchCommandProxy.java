package edu.fudan.langlab.uidl.domain.app.client;

public interface WorkbenchCommandProxy extends WorkbenchPartProxy {
	void execute();
	Boolean requireCheck();
}
