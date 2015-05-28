package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemReturnStockRecordPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemReturnStockRecordPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
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

public class CreateOrUpdateWorkItemReturnStockRecordPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateWorkItemReturnStockRecordPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateWorkItemReturnStockRecordPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateWorkItemReturnStockRecordPresenter(final CreateOrUpdateWorkItemReturnStockRecordPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup4Create(final RCWorkItemTaskProxy workItem, final Procedure1<? super CreateOrUpdateWorkItemReturnStockRecordPresenter> postInitializer) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCEmployeeProxy> _function = new Procedure1<RCEmployeeProxy>() {
              public void apply(final RCEmployeeProxy it) {
                CreateOrUpdateWorkItemReturnStockRecordPresenterView _view = CreateOrUpdateWorkItemReturnStockRecordPresenter.this.getView();
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      final Procedure1<RCRepairTaskProxy> _function = new Procedure1<RCRepairTaskProxy>() {
                          public void apply(final RCRepairTaskProxy it) {
                            CreateOrUpdateWorkItemReturnStockRecordPresenterView _view = CreateOrUpdateWorkItemReturnStockRecordPresenter.this.getView();
                            _view.setWorkItemTask(workItem, it);
                            postInitializer.apply(CreateOrUpdateWorkItemReturnStockRecordPresenter.this);
                          }
                        };
                      AsyncCallback<RCRepairTaskProxy> _onSuccess = CreateOrUpdateWorkItemReturnStockRecordPresenter.this.<RCRepairTaskProxy>onSuccess(_function);
                      _service.getRepairTask(workItem, _onSuccess);
                    }
                  };
                _view.setSourceWarehouseContext(it, _function);
              }
            };
          AsyncCallback<RCEmployeeProxy> _onSuccess = CreateOrUpdateWorkItemReturnStockRecordPresenter.this.<RCEmployeeProxy>onSuccess(_function);
          _service.getCurrentUser(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    CreateOrUpdateWorkItemReturnStockRecordPresenterView _view = this.getView();
    UIWorkItemReturnStockRecord _value = _view.getValue();
    final Procedure1<RCWorkItemReturnStockRecordProxy> _function = new Procedure1<RCWorkItemReturnStockRecordProxy>() {
        public void apply(final RCWorkItemReturnStockRecordProxy value) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordsChangedEvent());
          
          CreateOrUpdateWorkItemReturnStockRecordPresenterView _view = CreateOrUpdateWorkItemReturnStockRecordPresenter.this.getView();
          UIWorkItemReturnStockRecord _value = _view.getValue();
          Boolean _print = _value.getPrint();
          if ((_print).booleanValue()) {
            final Procedure1<String> _function = new Procedure1<String>() {
                public void apply(final String html) {
                  Print.it(html);
                }
              };
            AsyncCallback<String> _onSuccess = CreateOrUpdateWorkItemReturnStockRecordPresenter.this.<String>onSuccess(_function);
            _service.generatePrintContents(value, _onSuccess);
          }
          notifier.success();
        }
      };
    AsyncCallback<RCWorkItemReturnStockRecordProxy> _onSuccess = this.<RCWorkItemReturnStockRecordProxy>onSuccess(_function);
    _service.createValue(_value, _onSuccess);
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
