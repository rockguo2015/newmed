package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemOutStockRecordPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemOutStockRecordPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.print.Print;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateWorkItemOutStockRecordPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateWorkItemOutStockRecordPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateWorkItemOutStockRecordPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateWorkItemOutStockRecordPresenter(final CreateOrUpdateWorkItemOutStockRecordPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final RCWorkItemTaskProxy workItem, final Procedure1<? super CreateOrUpdateWorkItemOutStockRecordPresenter> postInitializer) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCEmployeeProxy> _function = new Procedure1<RCEmployeeProxy>() {
              public void apply(final RCEmployeeProxy it) {
                CreateOrUpdateWorkItemOutStockRecordPresenterView _view = CreateOrUpdateWorkItemOutStockRecordPresenter.this.getView();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      final Procedure1<RCRepairTaskProxy> _function = new Procedure1<RCRepairTaskProxy>() {
                          public void apply(final RCRepairTaskProxy it) {
                            CreateOrUpdateWorkItemOutStockRecordPresenterView _view = CreateOrUpdateWorkItemOutStockRecordPresenter.this.getView();
                            _view.setWorkItemTask(workItem, it);
                            postInitializer.apply(CreateOrUpdateWorkItemOutStockRecordPresenter.this);
                          }
                        };
                      AsyncCallback<RCRepairTaskProxy> _onSuccess = CreateOrUpdateWorkItemOutStockRecordPresenter.this.<RCRepairTaskProxy>onSuccess(_function);
                      _service.getRepairTask(workItem, _onSuccess);
                    }
                  };
                _view.setSourceWarehouseContext(it, _function);
              }
            };
          AsyncCallback<RCEmployeeProxy> _onSuccess = CreateOrUpdateWorkItemOutStockRecordPresenter.this.<RCEmployeeProxy>onSuccess(_function);
          _service.getCurrentUser(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_productSidEnteredExecution(final String sid, final RCWarehouseProxy store) {
    
    final Procedure1<UIProductWarehouseStorageSummary> _function = new Procedure1<UIProductWarehouseStorageSummary>() {
        public void apply(final UIProductWarehouseStorageSummary it) {
          CreateOrUpdateWorkItemOutStockRecordPresenterView _view = CreateOrUpdateWorkItemOutStockRecordPresenter.this.getView();
          _view.setProductSummary(it);
        }
      };
    AsyncCallback<UIProductWarehouseStorageSummary> _onSuccess = this.<UIProductWarehouseStorageSummary>onSuccess(_function);
    _service.getProductSummaryByProductSid(sid, store, _onSuccess);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    CreateOrUpdateWorkItemOutStockRecordPresenterView _view = this.getView();
    UIWorkItemOutStockRecord _value = _view.getValue();
    final Procedure1<RCWorkItemOutStockRecordProxy> _function = new Procedure1<RCWorkItemOutStockRecordProxy>() {
        public void apply(final RCWorkItemOutStockRecordProxy record) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordsChangedEvent());
          
          CreateOrUpdateWorkItemOutStockRecordPresenterView _view = CreateOrUpdateWorkItemOutStockRecordPresenter.this.getView();
          UIWorkItemOutStockRecord _value = _view.getValue();
          Boolean _print = _value.getPrint();
          if ((_print).booleanValue()) {
            CreateOrUpdateWorkItemOutStockRecordPresenterView _view_1 = CreateOrUpdateWorkItemOutStockRecordPresenter.this.getView();
            UIWorkItemOutStockRecord _value_1 = _view_1.getValue();
            Boolean _fitPrint = _value_1.getFitPrint();
            if ((_fitPrint).booleanValue()) {
              final Procedure1<String> _function = new Procedure1<String>() {
                  public void apply(final String html) {
                    Print.it(html);
                  }
                };
              AsyncCallback<String> _onSuccess = CreateOrUpdateWorkItemOutStockRecordPresenter.this.<String>onSuccess(_function);
              _service.generateFitPrintContents(record, _onSuccess);
            } else {
              final Procedure1<String> _function_1 = new Procedure1<String>() {
                  public void apply(final String html) {
                    Print.it(html);
                  }
                };
              AsyncCallback<String> _onSuccess_1 = CreateOrUpdateWorkItemOutStockRecordPresenter.this.<String>onSuccess(_function_1);
              _service.generatePrintContents(record, _onSuccess_1);
            }
          }
          notifier.success();
        }
      };
    AsyncCallback<RCWorkItemOutStockRecordProxy> _onSuccess = this.<RCWorkItemOutStockRecordProxy>onSuccess(_function);
    _service.createValue(_value, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().productSidEntered(new RequestHandler2<String,RCWarehouseProxy>(){
    			
    			public void execute(String sid,RCWarehouseProxy store){
    				view_productSidEnteredExecution(sid,store);
    			}
    			
    		});
    
  }
}
