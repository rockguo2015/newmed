package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateOutStockRecordPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateOutStockRecordPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.print.Print;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateOutStockRecordPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateOutStockRecordPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateOutStockRecordPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateOutStockRecordPresenter(final CreateOrUpdateOutStockRecordPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final Procedure1<? super CreateOrUpdateOutStockRecordPresenter> postInitializer) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCEmployeeProxy> _function = new Procedure1<RCEmployeeProxy>() {
              public void apply(final RCEmployeeProxy it) {
                CreateOrUpdateOutStockRecordPresenterView _view = CreateOrUpdateOutStockRecordPresenter.this.getView();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      postInitializer.apply(CreateOrUpdateOutStockRecordPresenter.this);
                      CreateOrUpdateOutStockRecordPresenterView _view = CreateOrUpdateOutStockRecordPresenter.this.getView();
                      _view.postInitialize();
                    }
                  };
                _view.setSourceWarehouseContext(it, _function);
              }
            };
          AsyncCallback<RCEmployeeProxy> _onSuccess = CreateOrUpdateOutStockRecordPresenter.this.<RCEmployeeProxy>onSuccess(_function);
          _service.loadCurrentUser(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCOutStockRecordProxy value, final Procedure1<? super CreateOrUpdateOutStockRecordPresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCEmployeeProxy> _function = new Procedure1<RCEmployeeProxy>() {
              public void apply(final RCEmployeeProxy it) {
                CreateOrUpdateOutStockRecordPresenterView _view = CreateOrUpdateOutStockRecordPresenter.this.getView();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      final Procedure1<UIOutStockRecord> _function = new Procedure1<UIOutStockRecord>() {
                          public void apply(final UIOutStockRecord it) {
                            CreateOrUpdateOutStockRecordPresenterView _view = CreateOrUpdateOutStockRecordPresenter.this.getView();
                            _view.setValue(it);
                            postInitializer.apply(CreateOrUpdateOutStockRecordPresenter.this);
                          }
                        };
                      AsyncCallback<UIOutStockRecord> _onSuccess = CreateOrUpdateOutStockRecordPresenter.this.<UIOutStockRecord>onSuccess(_function);
                      _service.loadValue(value, _onSuccess);
                    }
                  };
                _view.setSourceWarehouseContext(it, _function);
              }
            };
          AsyncCallback<RCEmployeeProxy> _onSuccess = CreateOrUpdateOutStockRecordPresenter.this.<RCEmployeeProxy>onSuccess(_function);
          _service.loadCurrentUser(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_teamChangedExecution(final RCMaintenanceTeamProxy newTeam) {
    
    final Procedure1<RCOrganizationProxy> _function = new Procedure1<RCOrganizationProxy>() {
        public void apply(final RCOrganizationProxy it) {
          CreateOrUpdateOutStockRecordPresenterView _view = CreateOrUpdateOutStockRecordPresenter.this.getView();
          _view.setSelectedOrganization(it);
        }
      };
    AsyncCallback<RCOrganizationProxy> _onSuccess = this.<RCOrganizationProxy>onSuccess(_function);
    _service.loadOrganization(newTeam, _onSuccess);
  }
  
  public void view_productSidEnteredExecution(final String sid, final RCWarehouseProxy store) {
    
    final Procedure1<UIProductWarehouseStorageSummary> _function = new Procedure1<UIProductWarehouseStorageSummary>() {
        public void apply(final UIProductWarehouseStorageSummary it) {
          CreateOrUpdateOutStockRecordPresenterView _view = CreateOrUpdateOutStockRecordPresenter.this.getView();
          _view.setProductSummary(it);
        }
      };
    AsyncCallback<UIProductWarehouseStorageSummary> _onSuccess = this.<UIProductWarehouseStorageSummary>onSuccess(_function);
    _service.getProductSummaryByProductSid(sid, store, _onSuccess);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdateOutStockRecordPresenterView _view = this.getView();
      UIOutStockRecord _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.OutStockRecordsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateOutStockRecordPresenterView _view_1 = this.getView();
      UIOutStockRecord _value_1 = _view_1.getValue();
      final Procedure1<RCOutStockRecordProxy> _function_1 = new Procedure1<RCOutStockRecordProxy>() {
          public void apply(final RCOutStockRecordProxy record) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.OutStockRecordsChangedEvent());
            
            CreateOrUpdateOutStockRecordPresenterView _view = CreateOrUpdateOutStockRecordPresenter.this.getView();
            UIOutStockRecord _value = _view.getValue();
            Boolean _print = _value.getPrint();
            if ((_print).booleanValue()) {
              final Procedure1<String> _function = new Procedure1<String>() {
                  public void apply(final String html) {
                    Print.it(html);
                  }
                };
              AsyncCallback<String> _onSuccess = CreateOrUpdateOutStockRecordPresenter.this.<String>onSuccess(_function);
              _service.generatePrintContents(record, _onSuccess);
            }
            notifier.success();
          }
        };
      AsyncCallback<RCOutStockRecordProxy> _onSuccess_1 = this.<RCOutStockRecordProxy>onSuccess(_function_1);
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
    getView().teamChanged(new RequestHandler1<RCMaintenanceTeamProxy>(){
    			
    			public void execute(RCMaintenanceTeamProxy newTeam){
    				view_teamChangedExecution(newTeam);
    			}
    			
    		});
    getView().productSidEntered(new RequestHandler2<String,RCWarehouseProxy>(){
    			
    			public void execute(String sid,RCWarehouseProxy store){
    				view_productSidEnteredExecution(sid,store);
    			}
    			
    		});
    
  }
}
