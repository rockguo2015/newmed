package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateMaintenamceTypePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateMaintenamceTypePresenterView;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateMaintenamceTypePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateMaintenamceTypePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateMaintenamceTypePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateMaintenamceTypePresenter(final CreateOrUpdateMaintenamceTypePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCMaintenamceTypeProxy parent;
  
  public void setup4Create(final RCMaintenamceTypeProxy parent, final Procedure1<? super CreateOrUpdateMaintenamceTypePresenter> postInitializer) {
    
    this.used4Update = false;
    this.parent = parent;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          getView().setParent(parent);
          
          postInitializer.apply(CreateOrUpdateMaintenamceTypePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCMaintenamceTypeProxy value, final Procedure1<? super CreateOrUpdateMaintenamceTypePresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIMaintenamceType> _function = new Procedure1<UIMaintenamceType>() {
              public void apply(final UIMaintenamceType it) {
                CreateOrUpdateMaintenamceTypePresenterView _view = CreateOrUpdateMaintenamceTypePresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateMaintenamceTypePresenter.this);
              }
            };
          AsyncCallback<UIMaintenamceType> _onSuccess = CreateOrUpdateMaintenamceTypePresenter.this.<UIMaintenamceType>onSuccess(_function);
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
      CreateOrUpdateMaintenamceTypePresenterView _view = this.getView();
      UIMaintenamceType _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {
            CreateOrUpdateMaintenamceTypePresenterView _view = CreateOrUpdateMaintenamceTypePresenter.this.getView();
            UIMaintenamceType _value = _view.getValue();
            RCMaintenamceTypeProxy _proxy = _value.toProxy();
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.MaintenamceTypeChangedEvent(_proxy));
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateMaintenamceTypePresenterView _view_1 = this.getView();
      UIMaintenamceType _value_1 = _view_1.getValue();
      final Procedure1<UIMaintenamceType> _function_1 = new Procedure1<UIMaintenamceType>() {
          public void apply(final UIMaintenamceType it) {
            it.setParent(CreateOrUpdateMaintenamceTypePresenter.this.parent);
          }
        };
      UIMaintenamceType _doubleArrow = ObjectExtensions.<UIMaintenamceType>operator_doubleArrow(_value_1, _function_1);
      final Procedure1<RCMaintenamceTypeProxy> _function_2 = new Procedure1<RCMaintenamceTypeProxy>() {
          public void apply(final RCMaintenamceTypeProxy it) {
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.MaintenamceTypeAddedEvent(it));
            
            notifier.success();
            CreateOrUpdateMaintenamceTypePresenterView _view = CreateOrUpdateMaintenamceTypePresenter.this.getView();
            UIMaintenamceType _value = _view.getValue();
            Boolean _inputNext = _value.getInputNext();
            boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_inputNext);
            if (_isLogicTrue) {
              eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.InputNextMaintenamceTypeEvent(CreateOrUpdateMaintenamceTypePresenter.this.parent));
              
            }
          }
        };
      AsyncCallback<RCMaintenamceTypeProxy> _onSuccess_1 = this.<RCMaintenamceTypeProxy>onSuccess(_function_2);
      _service.createValue(_doubleArrow, _onSuccess_1);
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
