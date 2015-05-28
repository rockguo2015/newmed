package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanList4DevicePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanList4DevicePresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DevicePMPlanList4DevicePresenter extends WorkbenchAbstractPresenter<DevicePMPlanList4DevicePresenterView> {
  @Inject
  protected DevicePMPlanList4DevicePresenterServiceAsync _service;
  
  @Inject
  public DevicePMPlanList4DevicePresenter(final DevicePMPlanList4DevicePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCDeviceProxy context;
  
  public void setup(final IPresenterInitiazerNotifier<DevicePMPlanList4DevicePresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(DevicePMPlanList4DevicePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCDeviceProxy context, final IPresenterInitiazerNotifier<DevicePMPlanList4DevicePresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          DevicePMPlanList4DevicePresenter.this.refresh();_notifier.done(DevicePMPlanList4DevicePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setDevice(final RCDeviceProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIDevicePMPlan>> _function = new Procedure1<Collection<UIDevicePMPlan>>() {
          public void apply(final Collection<UIDevicePMPlan> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIDevicePMPlan>> _onSuccess = this.<Collection<UIDevicePMPlan>>onSuccess(_function);
      _service.loadDevicePMPlanList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_DevicePMPlansChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedHandler(){
    public void DevicePMPlansChanged(){
    	_eventbus_DevicePMPlansChanged();
    }
    }));
    
  }
}
