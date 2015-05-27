package com.fudanmed.platform.core.web.client.app

import com.google.inject.Inject
import edu.fudan.langlab.uidl.domain.app.client.ModuleInitializer
import com.google.gwt.event.shared.EventBus
import edu.fudan.langlab.uidl.domain.app.client.login.ApplicationInitializedEvent
import com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenter
import com.google.inject.Provider
import edu.fudan.langlab.uidl.domain.app.client.workbench.ShowPresenterEvent
import com.fudanmed.platform.core.web.client.workbench.RouterPresenter
//import com.fudanmed.platform.deliver.web.client.DeliverModualInitalizer
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchManager

class ModuleInitializerImpl implements ModuleInitializer {
	@Inject
	private UIWorkbenchPartRegister workbenchPartRegister;
	@Inject WorkbenchManager workbenchManager
	
//	@Inject
//	private DeliverModualInitalizer deliverModualInitalizer;
//	@Inject EventBus eventbus
	override initializeModule() {
		workbenchPartRegister.initialize();
//		deliverModualInitalizer.registerWorkbenchCommands(workbenchManager);
//		defineStartupScreen();
	}
	
//	@Inject Provider<RouterPresenter> supplierManagementPresenter
	 
//	def defineStartupScreen(){
//		eventbus.addHandler(ApplicationInitializedEvent::__type__)[app|
//			val router = supplierManagementPresenter.get
//			eventbus.fireEvent(new ShowPresenterEvent(router))
//			router.route
//		]		
//		
//	}
	
}