package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.DevicePropertyPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DevicePropertyPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DevicePropertyPresenter extends WorkbenchAbstractPresenter<DevicePropertyPresenterView> {
  @Inject
  protected DevicePropertyPresenterServiceAsync _service;
  
  @Inject
  public DevicePropertyPresenter(final DevicePropertyPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final RCDeviceProxy device, final IPresenterInitiazerNotifier<DevicePropertyPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIDevice> _function = new Procedure1<UIDevice>() {
              public void apply(final UIDevice it) {
                getView().setValue(it);
                _notifier.done(DevicePropertyPresenter.this);
              }
            };
          AsyncCallback<UIDevice> _onSuccess = DevicePropertyPresenter.this.<UIDevice>onSuccess(_function);
          _service.loadDeviceInfo(device, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final IPresenterInitiazerNotifier<DevicePropertyPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(DevicePropertyPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setDevice(final RCDeviceProxy device) {
    
    final Procedure1<UIDevice> _function = new Procedure1<UIDevice>() {
        public void apply(final UIDevice it) {
          getView().setValue(it);
          
        }
      };
    AsyncCallback<UIDevice> _onSuccess = this.<UIDevice>onSuccess(_function);
    _service.loadDeviceInfo(device, _onSuccess);
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
