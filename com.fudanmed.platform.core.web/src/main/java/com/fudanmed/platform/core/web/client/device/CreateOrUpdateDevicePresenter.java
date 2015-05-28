package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
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

public class CreateOrUpdateDevicePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateDevicePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateDevicePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateDevicePresenter(final CreateOrUpdateDevicePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final RCDeviceTypeProxy deviceType, final UIOnsitePosition location, final IPresenterInitiazerNotifier<CreateOrUpdateDevicePresenter> _notifier) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          CreateOrUpdateDevicePresenterView _view = CreateOrUpdateDevicePresenter.this.getView();
          _view.setDeviceType(deviceType);
          CreateOrUpdateDevicePresenterView _view_1 = CreateOrUpdateDevicePresenter.this.getView();
          _view_1.setLocation(location);_notifier.done(CreateOrUpdateDevicePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCDeviceProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateDevicePresenter> _notifier) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIDevice> _function = new Procedure1<UIDevice>() {
              public void apply(final UIDevice it) {
                CreateOrUpdateDevicePresenterView _view = CreateOrUpdateDevicePresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateDevicePresenter.this);
              }
            };
          AsyncCallback<UIDevice> _onSuccess = CreateOrUpdateDevicePresenter.this.<UIDevice>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Dupicate(final RCDeviceProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateDevicePresenter> _notifier) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIDevice> _function = new Procedure1<UIDevice>() {
              public void apply(final UIDevice it) {
                CreateOrUpdateDevicePresenterView _view = CreateOrUpdateDevicePresenter.this.getView();
                final Procedure1<UIDevice> _function = new Procedure1<UIDevice>() {
                    public void apply(final UIDevice it) {
                      it.setId(null);
                      it.setSid("");
                      it.setName("");
                    }
                  };
                UIDevice _doubleArrow = ObjectExtensions.<UIDevice>operator_doubleArrow(it, _function);
                _view.setValue(_doubleArrow);_notifier.done(CreateOrUpdateDevicePresenter.this);
              }
            };
          AsyncCallback<UIDevice> _onSuccess = CreateOrUpdateDevicePresenter.this.<UIDevice>onSuccess(_function);
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
      CreateOrUpdateDevicePresenterView _view = this.getView();
      UIDevice _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicesChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateDevicePresenterView _view_1 = this.getView();
      UIDevice _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicesChangedEvent());
            
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
