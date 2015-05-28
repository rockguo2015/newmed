package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingRecordPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingRecordPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.print.Print;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateStockTakingRecordPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateStockTakingRecordPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateStockTakingRecordPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateStockTakingRecordPresenter(final CreateOrUpdateStockTakingRecordPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final Procedure1<? super CreateOrUpdateStockTakingRecordPresenter> postInitializer) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCWarehouseProxy> _function = new Procedure1<RCWarehouseProxy>() {
              public void apply(final RCWarehouseProxy it) {
                getView().setHostWarehouse(it);
                
                postInitializer.apply(CreateOrUpdateStockTakingRecordPresenter.this);
              }
            };
          AsyncCallback<RCWarehouseProxy> _onSuccess = CreateOrUpdateStockTakingRecordPresenter.this.<RCWarehouseProxy>onSuccess(_function);
          _service.getHostWarehouse(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCStockTakingRecordProxy value, final Procedure1<? super CreateOrUpdateStockTakingRecordPresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIStockTakingRecord> _function = new Procedure1<UIStockTakingRecord>() {
              public void apply(final UIStockTakingRecord it) {
                CreateOrUpdateStockTakingRecordPresenterView _view = CreateOrUpdateStockTakingRecordPresenter.this.getView();
                _view.setValue(it);
                final Procedure1<RCWarehouseProxy> _function = new Procedure1<RCWarehouseProxy>() {
                    public void apply(final RCWarehouseProxy it) {
                      getView().setHostWarehouse(it);
                      
                      postInitializer.apply(CreateOrUpdateStockTakingRecordPresenter.this);
                    }
                  };
                AsyncCallback<RCWarehouseProxy> _onSuccess = CreateOrUpdateStockTakingRecordPresenter.this.<RCWarehouseProxy>onSuccess(_function);
                _service.getHostWarehouse(_onSuccess);
              }
            };
          AsyncCallback<UIStockTakingRecord> _onSuccess = CreateOrUpdateStockTakingRecordPresenter.this.<UIStockTakingRecord>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdateStockTakingRecordPresenterView _view = this.getView();
      UIStockTakingRecord _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateStockTakingRecordPresenterView _view_1 = this.getView();
      UIStockTakingRecord _value_1 = _view_1.getValue();
      final Procedure1<RCStockTakingRecordProxy> _function_1 = new Procedure1<RCStockTakingRecordProxy>() {
          public void apply(final RCStockTakingRecordProxy record) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordsChangedEvent());
            
            CreateOrUpdateStockTakingRecordPresenterView _view = CreateOrUpdateStockTakingRecordPresenter.this.getView();
            UIStockTakingRecord _value = _view.getValue();
            Boolean _print = _value.getPrint();
            if ((_print).booleanValue()) {
              final Procedure1<String> _function = new Procedure1<String>() {
                  public void apply(final String html) {
                    Print.it(html);
                  }
                };
              AsyncCallback<String> _onSuccess = CreateOrUpdateStockTakingRecordPresenter.this.<String>onSuccess(_function);
              _service.generatePrintContents(record, _onSuccess);
            }
            notifier.success();
          }
        };
      AsyncCallback<RCStockTakingRecordProxy> _onSuccess_1 = this.<RCStockTakingRecordProxy>onSuccess(_function_1);
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
    
  }
}
