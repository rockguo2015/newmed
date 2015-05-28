package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypeCategoryPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypeCategoryPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateDeviceTypeCategoryPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateDeviceTypeCategoryPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateDeviceTypeCategoryPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateDeviceTypeCategoryPresenter(final CreateOrUpdateDeviceTypeCategoryPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCDeviceTypeCategoryProxy parent;
  
  public void setup4Create(final RCDeviceTypeCategoryProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateDeviceTypeCategoryPresenter> _notifier) {
    
    this.used4Update = false;
    this.parent = parent;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          getView().setParent(parent);
          _notifier.done(CreateOrUpdateDeviceTypeCategoryPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCDeviceTypeCategoryProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateDeviceTypeCategoryPresenter> _notifier) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIDeviceTypeCategory> _function = new Procedure1<UIDeviceTypeCategory>() {
              public void apply(final UIDeviceTypeCategory it) {
                CreateOrUpdateDeviceTypeCategoryPresenterView _view = CreateOrUpdateDeviceTypeCategoryPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateDeviceTypeCategoryPresenter.this);
              }
            };
          AsyncCallback<UIDeviceTypeCategory> _onSuccess = CreateOrUpdateDeviceTypeCategoryPresenter.this.<UIDeviceTypeCategory>onSuccess(_function);
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
      CreateOrUpdateDeviceTypeCategoryPresenterView _view = this.getView();
      UIDeviceTypeCategory _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {
            CreateOrUpdateDeviceTypeCategoryPresenterView _view = CreateOrUpdateDeviceTypeCategoryPresenter.this.getView();
            UIDeviceTypeCategory _value = _view.getValue();
            RCDeviceTypeCategoryProxy _proxy = _value.toProxy();
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryChangedEvent(_proxy));
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateDeviceTypeCategoryPresenterView _view_1 = this.getView();
      UIDeviceTypeCategory _value_1 = _view_1.getValue();
      final Procedure1<UIDeviceTypeCategory> _function_1 = new Procedure1<UIDeviceTypeCategory>() {
          public void apply(final UIDeviceTypeCategory it) {
            it.setParent(CreateOrUpdateDeviceTypeCategoryPresenter.this.parent);
          }
        };
      UIDeviceTypeCategory _doubleArrow = ObjectExtensions.<UIDeviceTypeCategory>operator_doubleArrow(_value_1, _function_1);
      final Procedure1<RCDeviceTypeCategoryProxy> _function_2 = new Procedure1<RCDeviceTypeCategoryProxy>() {
          public void apply(final RCDeviceTypeCategoryProxy it) {
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryAddedEvent(it));
            
            notifier.success();
          }
        };
      AsyncCallback<RCDeviceTypeCategoryProxy> _onSuccess_1 = this.<RCDeviceTypeCategoryProxy>onSuccess(_function_2);
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
