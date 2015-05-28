package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordManagementPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemStockRecordManagementPresenter extends WorkbenchAbstractPresenter<WorkItemStockRecordManagementPresenterView> {
  @Inject
  protected WorkItemStockRecordManagementPresenterServiceAsync _service;
  
  @Inject
  public WorkItemStockRecordManagementPresenter(final WorkItemStockRecordManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void onStartExecution() {
    getView().refresh();
    
  }
  
  public void setup(final Procedure1<? super WorkItemStockRecordManagementPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          
          postInit.apply(WorkItemStockRecordManagementPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_showDetailRequestExecution(final RCWorkItemStockRecordProxy value) {
    
    final Procedure1<Collection<UIWorkItemStockRecordItem>> _function = new Procedure1<Collection<UIWorkItemStockRecordItem>>() {
        public void apply(final Collection<UIWorkItemStockRecordItem> it) {
          getView().showDetail(it);
          
        }
      };
    AsyncCallback<Collection<UIWorkItemStockRecordItem>> _onSuccess = this.<Collection<UIWorkItemStockRecordItem>>onSuccess(_function);
    _service.loadDetail(value, _onSuccess);
  }
  
  public void view_filterRequestExecution(final UIWorkItemStockRecordCriteria c) {
    
    final Procedure1<IPagedResult<UIWorkItemStockRecord>> _function = new Procedure1<IPagedResult<UIWorkItemStockRecord>>() {
        public void apply(final IPagedResult<UIWorkItemStockRecord> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIWorkItemStockRecord>> _onSuccess = this.<IPagedResult<UIWorkItemStockRecord>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_WorkItemStockRecordsChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().showDetailRequest(new RequestHandler1<RCWorkItemStockRecordProxy>(){
    			
    			public void execute(RCWorkItemStockRecordProxy value){
    				view_showDetailRequestExecution(value);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UIWorkItemStockRecordCriteria>(){
    			
    			public void execute(UIWorkItemStockRecordCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordsChangedHandler(){
    public void WorkItemStockRecordsChanged(){
    	_eventbus_WorkItemStockRecordsChanged();
    }
    }));
    onStartExecution();
    
  }
}
