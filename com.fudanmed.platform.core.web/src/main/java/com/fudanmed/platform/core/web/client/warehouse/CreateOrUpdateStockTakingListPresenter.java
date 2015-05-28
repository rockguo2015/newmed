package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateStockTakingListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateStockTakingListPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateStockTakingListPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateStockTakingListPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateStockTakingListPresenter(final CreateOrUpdateStockTakingListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final Procedure1<? super CreateOrUpdateStockTakingListPresenter> postInitializer) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCEmployeeProxy> _function = new Procedure1<RCEmployeeProxy>() {
              public void apply(final RCEmployeeProxy it) {
                CreateOrUpdateStockTakingListPresenterView _view = CreateOrUpdateStockTakingListPresenter.this.getView();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      postInitializer.apply(CreateOrUpdateStockTakingListPresenter.this);
                    }
                  };
                _view.setSourceWarehouseContext(it, _function);
              }
            };
          AsyncCallback<RCEmployeeProxy> _onSuccess = CreateOrUpdateStockTakingListPresenter.this.<RCEmployeeProxy>onSuccess(_function);
          _service.loadCurrentUser(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCStockTakingListProxy value, final Procedure1<? super CreateOrUpdateStockTakingListPresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCEmployeeProxy> _function = new Procedure1<RCEmployeeProxy>() {
              public void apply(final RCEmployeeProxy it) {
                CreateOrUpdateStockTakingListPresenterView _view = CreateOrUpdateStockTakingListPresenter.this.getView();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      final Procedure1<UIStockTakingList> _function = new Procedure1<UIStockTakingList>() {
                          public void apply(final UIStockTakingList it) {
                            CreateOrUpdateStockTakingListPresenterView _view = CreateOrUpdateStockTakingListPresenter.this.getView();
                            _view.setValue(it);
                            postInitializer.apply(CreateOrUpdateStockTakingListPresenter.this);
                          }
                        };
                      AsyncCallback<UIStockTakingList> _onSuccess = CreateOrUpdateStockTakingListPresenter.this.<UIStockTakingList>onSuccess(_function);
                      _service.loadValue(value, _onSuccess);
                    }
                  };
                _view.setSourceWarehouseContext(it, _function);
              }
            };
          AsyncCallback<RCEmployeeProxy> _onSuccess = CreateOrUpdateStockTakingListPresenter.this.<RCEmployeeProxy>onSuccess(_function);
          _service.loadCurrentUser(_onSuccess);
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
      CreateOrUpdateStockTakingListPresenterView _view = this.getView();
      UIStockTakingList _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.StockTakingListsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateStockTakingListPresenterView _view_1 = this.getView();
      UIStockTakingList _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.StockTakingListsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess_1 = this.<Void>onSuccess(_function_1);
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
