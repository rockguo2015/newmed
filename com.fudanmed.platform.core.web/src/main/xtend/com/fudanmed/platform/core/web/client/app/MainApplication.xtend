package com.fudanmed.platform.core.web.client.app

import edu.fudan.langlab.uidl.domain.app.client.BaseApplication
import edu.fudan.langlab.uidl.domain.app.client.login.ApplicationInitializedEvent

class MainApplication extends BaseApplication {

	override protected doOnModuleLoad() {
		MainGinjector::INSTANCE.getApplicationBuilder().initializeModule()
	}
	
	override createMainPresenter() {
		MainGinjector::INSTANCE.getLoginPresenter();
	}
		
}