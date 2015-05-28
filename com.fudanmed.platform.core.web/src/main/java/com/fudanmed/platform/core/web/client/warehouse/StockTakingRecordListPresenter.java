package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingRecordPresenter;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class StockTakingRecordListPresenter extends WorkbenchAbstractPresenter<StockTakingRecordListPresenterView> {
  @Inject
  protected StockTakingRecordListPresenterServiceAsync _service;
  
  @Inject
  public StockTakingRecordListPresenter(final StockTakingRecordListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateStockTakingRecordPresenter> createOrUpdatePresenter;
  
  public void setup(final Procedure1<? super StockTakingRecordListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          
          postInit.apply(StockTakingRecordListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIStockTakingRecordCriteria c) {
    
    final Procedure1<IPagedResult<UIStockTakingRecord>> _function = new Procedure1<IPagedResult<UIStockTakingRecord>>() {
        public void apply(final IPagedResult<UIStockTakingRecord> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIStockTakingRecord>> _onSuccess = this.<IPagedResult<UIStockTakingRecord>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_showDetailRequestExecution(final RCStockTakingRecordProxy value) {
    
    final Procedure1<Collection<UIStockTakingRecordItem>> _function = new Procedure1<Collection<UIStockTakingRecordItem>>() {
        public void apply(final Collection<UIStockTakingRecordItem> details) {
          final Procedure1<UIStockTakingRecord> _function = new Procedure1<UIStockTakingRecord>() {
              public void apply(final UIStockTakingRecord detail) {
                
                getView().showDetails(detail,details);
                
              }
            };
          AsyncCallback<UIStockTakingRecord> _onSuccess = StockTakingRecordListPresenter.this.<UIStockTakingRecord>onSuccess(_function);
          _service.loadStockTakingRecordInfo(value, _onSuccess);
        }
      };
    AsyncCallback<Collection<UIStockTakingRecordItem>> _onSuccess = this.<Collection<UIStockTakingRecordItem>>onSuccess(_function);
    _service.loadDetails(value, _onSuccess);
  }
  
  public void _eventbus_StockTakingRecordsChanged() {
    getView().refresh();
    
  }
  
  public void view_modifyStockTakingRequestExecution(final RCStockTakingRecordProxy value) {
    
    CreateOrUpdateStockTakingRecordPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateStockTakingRecordPresenter> _function = new Procedure1<CreateOrUpdateStockTakingRecordPresenter>() {
        public void apply(final CreateOrUpdateStockTakingRecordPresenter it) {
          final Procedure1<CreateOrUpdateStockTakingRecordPresenter> _function = new Procedure1<CreateOrUpdateStockTakingRecordPresenter>() {
              public void apply(final CreateOrUpdateStockTakingRecordPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateStockTakingRecordPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_StockTakingRequestExecution() {
    
    CreateOrUpdateStockTakingRecordPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateStockTakingRecordPresenter> _function = new Procedure1<CreateOrUpdateStockTakingRecordPresenter>() {
        public void apply(final CreateOrUpdateStockTakingRecordPresenter it) {
          final Procedure1<CreateOrUpdateStockTakingRecordPresenter> _function = new Procedure1<CreateOrUpdateStockTakingRecordPresenter>() {
              public void apply(final CreateOrUpdateStockTakingRecordPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(_function);
        }
      };
    ObjectExtensions.<CreateOrUpdateStockTakingRecordPresenter>operator_doubleArrow(_get, _function);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIStockTakingRecordCriteria>(){
    			
    			public void execute(UIStockTakingRecordCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    getView().showDetailRequest(new RequestHandler1<RCStockTakingRecordProxy>(){
    			
    			public void execute(RCStockTakingRecordProxy value){
    				view_showDetailRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordsChangedHandler(){
    public void StockTakingRecordsChanged(){
    	_eventbus_StockTakingRecordsChanged();
    }
    }));
    getView().modifyStockTakingRequest(new RequestHandler1<RCStockTakingRecordProxy>(){
    			
    			public void execute(RCStockTakingRecordProxy value){
    				view_modifyStockTakingRequestExecution(value);
    			}
    			
    		});
    getView().StockTakingRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_StockTakingRequestExecution();
    			}
    			
    		});
    
  }
}
