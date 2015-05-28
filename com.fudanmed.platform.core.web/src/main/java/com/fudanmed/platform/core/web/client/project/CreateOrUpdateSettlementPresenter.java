package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateSettlementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateSettlementPresenterView;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
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

public class CreateOrUpdateSettlementPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateSettlementPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateSettlementPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateSettlementPresenter(final CreateOrUpdateSettlementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final Procedure1<? super CreateOrUpdateSettlementPresenter> postInitializer) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInitializer.apply(CreateOrUpdateSettlementPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCSettlementProxy value, final Procedure1<? super CreateOrUpdateSettlementPresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UISettlement> _function = new Procedure1<UISettlement>() {
              public void apply(final UISettlement it) {
                CreateOrUpdateSettlementPresenterView _view = CreateOrUpdateSettlementPresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateSettlementPresenter.this);
              }
            };
          AsyncCallback<UISettlement> _onSuccess = CreateOrUpdateSettlementPresenter.this.<UISettlement>onSuccess(_function);
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
      CreateOrUpdateSettlementPresenterView _view = this.getView();
      UISettlement _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.SettlementsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateSettlementPresenterView _view_1 = this.getView();
      UISettlement _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.SettlementsChangedEvent());
            
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
