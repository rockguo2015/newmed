package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.BatchInitializePMPlanPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.BatchInitializePMPlanPresenterView;
import com.fudanmed.platform.core.web.shared.device.BatchInitializePMPlanData;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class BatchInitializePMPlanPresenter extends WorkbenchAbstractPresenter<BatchInitializePMPlanPresenterView> implements CommitablePresenter {
  @Inject
  protected BatchInitializePMPlanPresenterServiceAsync _service;
  
  @Inject
  public BatchInitializePMPlanPresenter(final BatchInitializePMPlanPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCDevicePMSpecificationProxy devicePMSpec;
  
  private UIDeviceCriteria deviceCriteria;
  
  public void setup(final UIDeviceCriteria deviceCriteria, final IPresenterInitiazerNotifier<BatchInitializePMPlanPresenter> _notifier) {
    
    this.deviceCriteria = deviceCriteria;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(BatchInitializePMPlanPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    BatchInitializePMPlanPresenterView _view = this.getView();
    BatchInitializePMPlanData _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          Info.display("success", "\u6279\u91CF\u751F\u6210PM\u8BA1\u5212");eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicePMSpecificationsChangedEvent());
          
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.init4Device(this.deviceCriteria, _value, _onSuccess);
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
