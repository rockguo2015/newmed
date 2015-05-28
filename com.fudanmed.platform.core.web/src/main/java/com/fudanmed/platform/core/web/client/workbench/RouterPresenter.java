package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenter;
import com.fudanmed.platform.core.web.client.project.ReportManagementPresenter;
import com.fudanmed.platform.core.web.client.workbench.RouterPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.workbench.RouterPresenterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.google.inject.Provider;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;

public class RouterPresenter extends WorkbenchAbstractPresenter<RouterPresenterView> {
  @Inject
  protected RouterPresenterServiceAsync _service;
  
  @Inject
  public RouterPresenter(final RouterPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<SupplierManagementPresenter> supplierManagementPresenter;
  
  @Inject
  private Provider<ReportManagementPresenter> reportManagementPresenter;
  
  public void onStartExecution() {
    
  }
  
  public void route() {
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    onStartExecution();
    
  }
}
