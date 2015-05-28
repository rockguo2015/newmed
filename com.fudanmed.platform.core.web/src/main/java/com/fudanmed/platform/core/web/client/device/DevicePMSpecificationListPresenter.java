package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
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

public class DevicePMSpecificationListPresenter extends WorkbenchAbstractPresenter<DevicePMSpecificationListPresenterView> {
  @Inject
  protected DevicePMSpecificationListPresenterServiceAsync _service;
  
  @Inject
  public DevicePMSpecificationListPresenter(final DevicePMSpecificationListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCDeviceProxy context;
  
  public void setup(final IPresenterInitiazerNotifier<DevicePMSpecificationListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(DevicePMSpecificationListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCDeviceProxy context, final IPresenterInitiazerNotifier<DevicePMSpecificationListPresenter> _notifier) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          DevicePMSpecificationListPresenter.this.refresh();_notifier.done(DevicePMSpecificationListPresenter.this);
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
      final Procedure1<Collection<UIDevicePMSpecification>> _function = new Procedure1<Collection<UIDevicePMSpecification>>() {
          public void apply(final Collection<UIDevicePMSpecification> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIDevicePMSpecification>> _onSuccess = this.<Collection<UIDevicePMSpecification>>onSuccess(_function);
      _service.loadDevicePMSpecificationList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_DevicePMSpecificationsChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DevicePMSpecificationsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DevicePMSpecificationsChangedHandler(){
    public void DevicePMSpecificationsChanged(){
    	_eventbus_DevicePMSpecificationsChanged();
    }
    }));
    
  }
}
