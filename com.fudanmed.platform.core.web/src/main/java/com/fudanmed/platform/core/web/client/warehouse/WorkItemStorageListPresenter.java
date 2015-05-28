package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStorage;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemStorageListPresenter extends WorkbenchAbstractPresenter<WorkItemStorageListPresenterView> {
  @Inject
  protected WorkItemStorageListPresenterServiceAsync _service;
  
  @Inject
  public WorkItemStorageListPresenter(final WorkItemStorageListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Procedure1<? super WorkItemStorageListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(WorkItemStorageListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setGroupTask(final RCGroupTaskProxy context) {
    
    final Procedure1<Collection<UIWorkItemStorage>> _function = new Procedure1<Collection<UIWorkItemStorage>>() {
        public void apply(final Collection<UIWorkItemStorage> it) {
          getView().setResults(it);
          
        }
      };
    AsyncCallback<Collection<UIWorkItemStorage>> _onSuccess = this.<Collection<UIWorkItemStorage>>onSuccess(_function);
    _service.loadWorkItemStorageList4GroupTask(context, _onSuccess);
  }
  
  public void setRepairTask(final RCRepairTaskProxy context) {
    
    final Procedure1<Collection<UIWorkItemStorage>> _function = new Procedure1<Collection<UIWorkItemStorage>>() {
        public void apply(final Collection<UIWorkItemStorage> it) {
          getView().setResults(it);
          
        }
      };
    AsyncCallback<Collection<UIWorkItemStorage>> _onSuccess = this.<Collection<UIWorkItemStorage>>onSuccess(_function);
    _service.loadWorkItemStorageList4RepairTask(context, _onSuccess);
  }
  
  public void setWorkItemTask(final RCWorkItemTaskProxy context) {
    
    final Procedure1<Collection<UIWorkItemStorage>> _function = new Procedure1<Collection<UIWorkItemStorage>>() {
        public void apply(final Collection<UIWorkItemStorage> it) {
          getView().setResults(it);
          
        }
      };
    AsyncCallback<Collection<UIWorkItemStorage>> _onSuccess = this.<Collection<UIWorkItemStorage>>onSuccess(_function);
    _service.loadWorkItemStorageList4WorkItemTask(context, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    
  }
}
