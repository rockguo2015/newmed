package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.csv.client.CSVClientExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemStorage4SettlementListPresenter extends WorkbenchAbstractPresenter<WorkItemStorage4SettlementListPresenterView> {
  @Inject
  protected WorkItemStorage4SettlementListPresenterServiceAsync _service;
  
  @Inject
  public WorkItemStorage4SettlementListPresenter(final WorkItemStorage4SettlementListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCSettlementProxy settlement;
  
  public void setup(final Procedure1<? super WorkItemStorage4SettlementListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(WorkItemStorage4SettlementListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setSettlement(final RCSettlementProxy context) {
    
    this.settlement = context;
    final Procedure1<Collection<UIWorkItemStorage4Settlement>> _function = new Procedure1<Collection<UIWorkItemStorage4Settlement>>() {
        public void apply(final Collection<UIWorkItemStorage4Settlement> it) {
          getView().setResults(it);
          
        }
      };
    AsyncCallback<Collection<UIWorkItemStorage4Settlement>> _onSuccess = this.<Collection<UIWorkItemStorage4Settlement>>onSuccess(_function);
    _service.loadWorkItemStorageList4Settlement(context, _onSuccess);
  }
  
  public void view_materialExportRequestExecution() {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          CSVClientExtensions.doDownload(it);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.prepareExport(this.settlement, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().materialExportRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_materialExportRequestExecution();
    			}
    			
    		});
    
  }
}
