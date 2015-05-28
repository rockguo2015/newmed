package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateInStockRecordPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateInStockRecordPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.CreateOrUpdateInStockRecordInitData;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.print.Print;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateInStockRecordPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateInStockRecordPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateInStockRecordPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateInStockRecordPresenter(final CreateOrUpdateInStockRecordPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final Procedure1<? super CreateOrUpdateInStockRecordPresenter> postInitializer) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<CreateOrUpdateInStockRecordInitData> _function = new Procedure1<CreateOrUpdateInStockRecordInitData>() {
              public void apply(final CreateOrUpdateInStockRecordInitData it) {
                CreateOrUpdateInStockRecordPresenterView _view = CreateOrUpdateInStockRecordPresenter.this.getView();
                _view.setDefaultValues(it);
                CreateOrUpdateInStockRecordPresenterView _view_1 = CreateOrUpdateInStockRecordPresenter.this.getView();
                RCEmployeeProxy _currentUser = it.getCurrentUser();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      postInitializer.apply(CreateOrUpdateInStockRecordPresenter.this);
                    }
                  };
                _view_1.setSourceWarehouseContext(_currentUser, _function);
              }
            };
          AsyncCallback<CreateOrUpdateInStockRecordInitData> _onSuccess = CreateOrUpdateInStockRecordPresenter.this.<CreateOrUpdateInStockRecordInitData>onSuccess(_function);
          _service.loadCreateOrUpdateInStockRecordInitData(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCInStockRecordProxy value, final Procedure1<? super CreateOrUpdateInStockRecordPresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<CreateOrUpdateInStockRecordInitData> _function = new Procedure1<CreateOrUpdateInStockRecordInitData>() {
              public void apply(final CreateOrUpdateInStockRecordInitData it) {
                CreateOrUpdateInStockRecordPresenterView _view = CreateOrUpdateInStockRecordPresenter.this.getView();
                RCEmployeeProxy _currentUser = it.getCurrentUser();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      final Procedure1<UIInStockRecord> _function = new Procedure1<UIInStockRecord>() {
                          public void apply(final UIInStockRecord it) {
                            CreateOrUpdateInStockRecordPresenterView _view = CreateOrUpdateInStockRecordPresenter.this.getView();
                            _view.setValue(it);
                            postInitializer.apply(CreateOrUpdateInStockRecordPresenter.this);
                          }
                        };
                      AsyncCallback<UIInStockRecord> _onSuccess = CreateOrUpdateInStockRecordPresenter.this.<UIInStockRecord>onSuccess(_function);
                      _service.loadValue(value, _onSuccess);
                    }
                  };
                _view.setSourceWarehouseContext(_currentUser, _function);
              }
            };
          AsyncCallback<CreateOrUpdateInStockRecordInitData> _onSuccess = CreateOrUpdateInStockRecordPresenter.this.<CreateOrUpdateInStockRecordInitData>onSuccess(_function);
          _service.loadCreateOrUpdateInStockRecordInitData(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_productSidEnteredExecution(final String sid) {
    
    final Procedure1<UIProductSpecification> _function = new Procedure1<UIProductSpecification>() {
        public void apply(final UIProductSpecification it) {
          CreateOrUpdateInStockRecordPresenterView _view = CreateOrUpdateInStockRecordPresenter.this.getView();
          _view.setProductSpecification(it);
        }
      };
    AsyncCallback<UIProductSpecification> _onSuccess = this.<UIProductSpecification>onSuccess(_function);
    _service.getProductSpecByProductSid(sid, _onSuccess);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdateInStockRecordPresenterView _view = this.getView();
      UIInStockRecord _value = _view.getValue();
      final Procedure1<RCInStockRecordProxy> _function = new Procedure1<RCInStockRecordProxy>() {
          public void apply(final RCInStockRecordProxy value) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.InStockRecordsChangedEvent());
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionsChangedEvent());
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStoragesChangedEvent());
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummarysChangedEvent());
            
            CreateOrUpdateInStockRecordPresenterView _view = CreateOrUpdateInStockRecordPresenter.this.getView();
            UIInStockRecord _value = _view.getValue();
            Boolean _print = _value.getPrint();
            if ((_print).booleanValue()) {
              final Procedure1<String> _function = new Procedure1<String>() {
                  public void apply(final String it) {
                    Print.it(it);
                  }
                };
              AsyncCallback<String> _onSuccess = CreateOrUpdateInStockRecordPresenter.this.<String>onSuccess(_function);
              _service.generatePrintContent(value, _onSuccess);
            }
            notifier.success();
          }
        };
      AsyncCallback<RCInStockRecordProxy> _onSuccess = this.<RCInStockRecordProxy>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateInStockRecordPresenterView _view_1 = this.getView();
      UIInStockRecord _value_1 = _view_1.getValue();
      final Procedure1<RCInStockRecordProxy> _function_1 = new Procedure1<RCInStockRecordProxy>() {
          public void apply(final RCInStockRecordProxy value) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.InStockRecordsChangedEvent());
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionsChangedEvent());
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStoragesChangedEvent());
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummarysChangedEvent());
            
            CreateOrUpdateInStockRecordPresenterView _view = CreateOrUpdateInStockRecordPresenter.this.getView();
            UIInStockRecord _value = _view.getValue();
            Boolean _print = _value.getPrint();
            if ((_print).booleanValue()) {
              final Procedure1<String> _function = new Procedure1<String>() {
                  public void apply(final String it) {
                    Print.it(it);
                  }
                };
              AsyncCallback<String> _onSuccess = CreateOrUpdateInStockRecordPresenter.this.<String>onSuccess(_function);
              _service.generatePrintContent(value, _onSuccess);
            }
            notifier.success();
          }
        };
      AsyncCallback<RCInStockRecordProxy> _onSuccess_1 = this.<RCInStockRecordProxy>onSuccess(_function_1);
      _service.createValue(_value_1, _onSuccess_1);
    }
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().productSidEntered(new RequestHandler1<String>(){
    			
    			public void execute(String sid){
    				view_productSidEnteredExecution(sid);
    			}
    			
    		});
    
  }
}
