package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateFaultTypePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateFaultTypePresenterView;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateFaultTypePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateFaultTypePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateFaultTypePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateFaultTypePresenter(final CreateOrUpdateFaultTypePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCMaintenamceTypeProxy parent;
  
  public void setup4Create(final RCMaintenamceTypeProxy parent, final Procedure1<? super CreateOrUpdateFaultTypePresenter> postInitializer) {
    
    this.used4Update = false;
    this.parent = parent;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          CreateOrUpdateFaultTypePresenterView _view = CreateOrUpdateFaultTypePresenter.this.getView();
          _view.setDefaultValues();
          getView().setParent(parent);
          
          postInitializer.apply(CreateOrUpdateFaultTypePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCFaultTypeProxy value, final Procedure1<? super CreateOrUpdateFaultTypePresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIFaultType> _function = new Procedure1<UIFaultType>() {
              public void apply(final UIFaultType it) {
                CreateOrUpdateFaultTypePresenterView _view = CreateOrUpdateFaultTypePresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateFaultTypePresenter.this);
              }
            };
          AsyncCallback<UIFaultType> _onSuccess = CreateOrUpdateFaultTypePresenter.this.<UIFaultType>onSuccess(_function);
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
      CreateOrUpdateFaultTypePresenterView _view = this.getView();
      UIFaultType _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.FaultTypesChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateFaultTypePresenterView _view_1 = this.getView();
      UIFaultType _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.FaultTypesChangedEvent());
            
            notifier.success();
            CreateOrUpdateFaultTypePresenterView _view = CreateOrUpdateFaultTypePresenter.this.getView();
            UIFaultType _value = _view.getValue();
            Boolean _inputNext = _value.getInputNext();
            boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_inputNext);
            if (_isLogicTrue) {
              eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.InputNextFaultTypeEvent(CreateOrUpdateFaultTypePresenter.this.parent));
              
            }
          }
        };
      AsyncCallback<Void> _onSuccess_1 = this.<Void>onSuccess(_function_1);
      _service.createValue(this.parent, _value_1, _onSuccess_1);
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
