package com.fudanmed.platform.core.web.client.app;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;

import edu.fudan.langlab.security.client.ISecurityManager;
import edu.fudan.langlab.uidl.domain.app.client.BaseClientModule;
import edu.fudan.langlab.uidl.domain.app.client.ModuleInitializer;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchManager;
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenter;
import edu.fudan.langlab.uidl.domain.app.client.workbench.ApplicationWorkbenchPresenter;

@GinModules({ BaseClientModule.class, MainModule.class })
public interface MainGinjector extends Ginjector, RuntimeGinjector {

	static final MainGinjector INSTANCE = GWT.create(MainGinjector.class);

	EventBus getEventBus();

	ApplicationWorkbenchPresenter getWorkbench();
	
	WorkbenchManager getWorkbenchManager();

	LoginPresenter getLoginPresenter();

	ModuleInitializer getApplicationBuilder();

	ISecurityManager getSecurityManager();

}
