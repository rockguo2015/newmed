package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateOutStockRecordPresenter;
import com.fudanmed.platform.core.web.client.warehouse.OutStockRecordListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.OutStockRecordListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.print.Print;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class OutStockRecordListPresenter extends WorkbenchAbstractPresenter<OutStockRecordListPresenterView> {
  @Inject
  protected OutStockRecordListPresenterServiceAsync _service;
  
  @Inject
  public OutStockRecordListPresenter(final OutStockRecordListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateOutStockRecordPresenter> createOrUpdatePresenter;
  
  public void setup(final Procedure1<? super OutStockRecordListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          
          postInit.apply(OutStockRecordListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIOutStockRecordCriteria c) {
    
    final Procedure1<IPagedResult<UIOutStockRecord>> _function = new Procedure1<IPagedResult<UIOutStockRecord>>() {
        public void apply(final IPagedResult<UIOutStockRecord> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIOutStockRecord>> _onSuccess = this.<IPagedResult<UIOutStockRecord>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_showDetailRequestExecution(final RCOutStockRecordProxy value) {
    
    final Procedure1<Collection<UIOutStockRecordItem>> _function = new Procedure1<Collection<UIOutStockRecordItem>>() {
        public void apply(final Collection<UIOutStockRecordItem> details) {
          final Procedure1<UIOutStockRecord> _function = new Procedure1<UIOutStockRecord>() {
              public void apply(final UIOutStockRecord detail) {
                
                getView().showDetails(detail,details);
                
              }
            };
          AsyncCallback<UIOutStockRecord> _onSuccess = OutStockRecordListPresenter.this.<UIOutStockRecord>onSuccess(_function);
          _service.loadOutStockRecordInfo(value, _onSuccess);
        }
      };
    AsyncCallback<Collection<UIOutStockRecordItem>> _onSuccess = this.<Collection<UIOutStockRecordItem>>onSuccess(_function);
    _service.loadDetails(value, _onSuccess);
  }
  
  public void _eventbus_OutStockRecordsChanged() {
    getView().refresh();
    
  }
  
  public void view_OutStockRequestExecution() {
    
    CreateOrUpdateOutStockRecordPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateOutStockRecordPresenter> _function = new Procedure1<CreateOrUpdateOutStockRecordPresenter>() {
        public void apply(final CreateOrUpdateOutStockRecordPresenter it) {
          final Procedure1<CreateOrUpdateOutStockRecordPresenter> _function = new Procedure1<CreateOrUpdateOutStockRecordPresenter>() {
              public void apply(final CreateOrUpdateOutStockRecordPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(_function);
        }
      };
    ObjectExtensions.<CreateOrUpdateOutStockRecordPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_printExecution(final RCOutStockRecordProxy value) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String html) {
          Print.it(html);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.generatePrintContents(value, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIOutStockRecordCriteria>(){
    			
    			public void execute(UIOutStockRecordCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    getView().showDetailRequest(new RequestHandler1<RCOutStockRecordProxy>(){
    			
    			public void execute(RCOutStockRecordProxy value){
    				view_showDetailRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.OutStockRecordsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.OutStockRecordsChangedHandler(){
    public void OutStockRecordsChanged(){
    	_eventbus_OutStockRecordsChanged();
    }
    }));
    getView().OutStockRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_OutStockRequestExecution();
    			}
    			
    		});
    getView().print(new RequestHandler1<RCOutStockRecordProxy>(){
    			
    			public void execute(RCOutStockRecordProxy value){
    				view_printExecution(value);
    			}
    			
    		});
    
  }
}
