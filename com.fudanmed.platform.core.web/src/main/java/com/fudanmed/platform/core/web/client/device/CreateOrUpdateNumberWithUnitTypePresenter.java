package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateNumberWithUnitTypePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateNumberWithUnitTypePresenterView;
import com.fudanmed.platform.core.web.shared.device.UINumberWithUnitType;
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

public class CreateOrUpdateNumberWithUnitTypePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateNumberWithUnitTypePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateNumberWithUnitTypePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateNumberWithUnitTypePresenter(final CreateOrUpdateNumberWithUnitTypePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final Procedure1<? super CreateOrUpdateNumberWithUnitTypePresenter> postInitializer) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInitializer.apply(CreateOrUpdateNumberWithUnitTypePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCNumberWithUnitTypeProxy value, final Procedure1<? super CreateOrUpdateNumberWithUnitTypePresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UINumberWithUnitType> _function = new Procedure1<UINumberWithUnitType>() {
              public void apply(final UINumberWithUnitType it) {
                CreateOrUpdateNumberWithUnitTypePresenterView _view = CreateOrUpdateNumberWithUnitTypePresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateNumberWithUnitTypePresenter.this);
              }
            };
          AsyncCallback<UINumberWithUnitType> _onSuccess = CreateOrUpdateNumberWithUnitTypePresenter.this.<UINumberWithUnitType>onSuccess(_function);
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
      CreateOrUpdateNumberWithUnitTypePresenterView _view = this.getView();
      UINumberWithUnitType _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.NumberWithUnitTypesChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateNumberWithUnitTypePresenterView _view_1 = this.getView();
      UINumberWithUnitType _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.NumberWithUnitTypesChangedEvent());
            
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
