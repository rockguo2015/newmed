package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemOutStockRecordListPresenter extends WorkbenchAbstractPresenter<WorkItemOutStockRecordListPresenterView> {
  @Inject
  protected WorkItemOutStockRecordListPresenterServiceAsync _service;
  
  @Inject
  public WorkItemOutStockRecordListPresenter(final WorkItemOutStockRecordListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Procedure1<? super WorkItemOutStockRecordListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(WorkItemOutStockRecordListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setWorkItemTask(final RCWorkItemTaskProxy context) {
    
    final Procedure1<Collection<UIWorkItemStockRecord>> _function = new Procedure1<Collection<UIWorkItemStockRecord>>() {
        public void apply(final Collection<UIWorkItemStockRecord> it) {
          getView().setResults(it);
          
        }
      };
    AsyncCallback<Collection<UIWorkItemStockRecord>> _onSuccess = this.<Collection<UIWorkItemStockRecord>>onSuccess(_function);
    _service.loadWorkItemOutStockRecordList(context, _onSuccess);
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
