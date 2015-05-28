package com.fudanmed.platform.core.web.client.app;

import com.fudanmed.platform.core.web.client.app.UIWorkbenchPartRegister;
import com.fudanmed.platform.deliver.web.client.DeliverModualInitalizer;
import com.google.inject.Inject;
import edu.fudan.langlab.uidl.domain.app.client.ModuleInitializer;
import edu.fudan.langlab.uidl.domain.app.client.WorkbenchManager;

@SuppressWarnings("all")
public class ModuleInitializerImpl implements ModuleInitializer {
  @Inject
  private UIWorkbenchPartRegister workbenchPartRegister;
  
  @Inject
  private WorkbenchManager workbenchManager;
  
  @Inject
  private DeliverModualInitalizer deliverModualInitalizer;
  
  public void initializeModule() {
    this.workbenchPartRegister.initialize();
    this.deliverModualInitalizer.registerWorkbenchCommands(this.workbenchManager);
  }
}
