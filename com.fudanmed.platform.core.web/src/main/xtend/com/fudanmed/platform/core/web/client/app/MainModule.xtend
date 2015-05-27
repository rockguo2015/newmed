package com.fudanmed.platform.core.web.client.app

import com.fudanmed.platform.core.web.client.names.ObjectNameService
import com.uniquesoft.gwt.client.common.RuntimeGinjector
import com.uniquesoft.gwt.client.common.gin.UIDLBaseGinModule
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider
import edu.fudan.langlab.uidl.domain.app.client.ModuleInitializer
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchManager
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchManagerImpl
import edu.fudan.langlab.uidl.domain.app.client.login.FudanmedLoginView
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenter
import edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenterView

class MainModule extends UIDLBaseGinModule {
	
	override protected configure() {
		
		bind(typeof(RuntimeGinjector)).to(typeof(MainGinjector));
		bind(typeof(IObjectNameProvider))
				.to(typeof(ObjectNameService));
		bindPresenter(typeof(edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenter), 
				typeof(edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenterView),
				typeof(edu.fudan.langlab.uidl.domain.app.client.login.FudanmedLoginView));
				
		bind(typeof(WorkbenchManager)).to(typeof(WorkbenchManagerImpl))
				.asEagerSingleton();
			
				
		bind(typeof(ModuleInitializer)).to(typeof(ModuleInitializerImpl));
		bind(typeof(UIWorkbenchPartRegister));
		
		
		

	}
	
}