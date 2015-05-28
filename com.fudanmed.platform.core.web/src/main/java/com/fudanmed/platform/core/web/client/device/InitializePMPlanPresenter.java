package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.InitializePMPlanPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.InitializePMPlanPresenterView;
import com.fudanmed.platform.core.web.shared.device.InitializePMPlanData;
import com.google.common.base.Objects;
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
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class InitializePMPlanPresenter extends WorkbenchAbstractPresenter<InitializePMPlanPresenterView> implements CommitablePresenter {
  @Inject
  protected InitializePMPlanPresenterServiceAsync _service;
  
  @Inject
  public InitializePMPlanPresenter(final InitializePMPlanPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCDevicePMSpecificationProxy devicePMSpec;
  
  public void setup4SingleDevice(final RCDevicePMSpecificationProxy devicePMSpec, final IPresenterInitiazerNotifier<InitializePMPlanPresenter> _notifier) {
    
    this.devicePMSpec = devicePMSpec;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Date> _function = new Procedure1<Date>() {
              public void apply(final Date it) {
                InitializePMPlanPresenterView _view = InitializePMPlanPresenter.this.getView();
                _view.setDefaultFromDate(it);_notifier.done(InitializePMPlanPresenter.this);
              }
            };
          AsyncCallback<Date> _onSuccess = InitializePMPlanPresenter.this.<Date>onSuccess(_function);
          _service.loadDefaultFromDate(devicePMSpec, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    boolean _notEquals = (!Objects.equal(this.devicePMSpec, null));
    if (_notEquals) {
      InitializePMPlanPresenterView _view = this.getView();
      InitializePMPlanData _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.init4Device(_value, this.devicePMSpec, _onSuccess);
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
