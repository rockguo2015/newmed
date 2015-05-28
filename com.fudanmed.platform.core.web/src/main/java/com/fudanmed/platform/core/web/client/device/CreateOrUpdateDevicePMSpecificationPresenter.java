package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMSpecificationPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMSpecificationPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateDevicePMSpecificationPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateDevicePMSpecificationPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateDevicePMSpecificationPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateDevicePMSpecificationPresenter(final CreateOrUpdateDevicePMSpecificationPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final RCDeviceProxy device, final IPresenterInitiazerNotifier<CreateOrUpdateDevicePMSpecificationPresenter> _notifier) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          CreateOrUpdateDevicePMSpecificationPresenterView _view = CreateOrUpdateDevicePMSpecificationPresenter.this.getView();
          _view.setDevice(device);_notifier.done(CreateOrUpdateDevicePMSpecificationPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCDevicePMSpecificationProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateDevicePMSpecificationPresenter> _notifier) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIDevicePMSpecification> _function = new Procedure1<UIDevicePMSpecification>() {
              public void apply(final UIDevicePMSpecification it) {
                CreateOrUpdateDevicePMSpecificationPresenterView _view = CreateOrUpdateDevicePMSpecificationPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateDevicePMSpecificationPresenter.this);
              }
            };
          AsyncCallback<UIDevicePMSpecification> _onSuccess = CreateOrUpdateDevicePMSpecificationPresenter.this.<UIDevicePMSpecification>onSuccess(_function);
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
      CreateOrUpdateDevicePMSpecificationPresenterView _view = this.getView();
      UIDevicePMSpecification _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicePMSpecificationsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateDevicePMSpecificationPresenterView _view_1 = this.getView();
      UIDevicePMSpecification _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicePMSpecificationsChangedEvent());
            
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
