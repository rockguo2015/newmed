package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DevicePMPlanListPresenter extends WorkbenchAbstractPresenter<DevicePMPlanListPresenterView> {
  @Inject
  protected DevicePMPlanListPresenterServiceAsync _service;
  
  @Inject
  public DevicePMPlanListPresenter(final DevicePMPlanListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super Void> loader;
  
  public void setup(final IPresenterInitiazerNotifier<DevicePMPlanListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(DevicePMPlanListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCDevicePMSpecificationProxy context, final IPresenterInitiazerNotifier<DevicePMPlanListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIDevicePMPlan>> _function = new Procedure1<Collection<UIDevicePMPlan>>() {
              public void apply(final Collection<UIDevicePMPlan> items) {
                getView().setResults(items);
                
              }
            };
          AsyncCallback<Collection<UIDevicePMPlan>> _onSuccess = DevicePMPlanListPresenter.this.<Collection<UIDevicePMPlan>>onSuccess(_function);
          _service.loadDevicePMPlanList(context, _onSuccess);
        }
      };
    this.loader = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          DevicePMPlanListPresenter.this.refresh();_notifier.done(DevicePMPlanListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setDevicePMSpecification(final RCDevicePMSpecificationProxy context) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIDevicePMPlan>> _function = new Procedure1<Collection<UIDevicePMPlan>>() {
              public void apply(final Collection<UIDevicePMPlan> items) {
                getView().setResults(items);
                
              }
            };
          AsyncCallback<Collection<UIDevicePMPlan>> _onSuccess = DevicePMPlanListPresenter.this.<Collection<UIDevicePMPlan>>onSuccess(_function);
          _service.loadDevicePMPlanList(context, _onSuccess);
        }
      };
    this.loader = _function;
    this.refresh();
  }
  
  public void setDevice(final RCDeviceProxy context) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIDevicePMPlan>> _function = new Procedure1<Collection<UIDevicePMPlan>>() {
              public void apply(final Collection<UIDevicePMPlan> items) {
                getView().setResults(items);
                
              }
            };
          AsyncCallback<Collection<UIDevicePMPlan>> _onSuccess = DevicePMPlanListPresenter.this.<Collection<UIDevicePMPlan>>onSuccess(_function);
          _service.loadDevicePMPlanList4Device(context, _onSuccess);
        }
      };
    this.loader = _function;
    this.refresh();
  }
  
  public void refresh() {
    
    this.loader.apply(null);
  }
  
  public void _eventbus_DevicePMPlansChanged() {
    
    InputOutput.<String>println("input eventbus.DevicePMPlansChanged()");
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
