package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMPlanPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMPlanPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
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

public class CreateOrUpdateDevicePMPlanPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateDevicePMPlanPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateDevicePMPlanPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateDevicePMPlanPresenter(final CreateOrUpdateDevicePMPlanPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final RCDevicePMSpecificationProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateDevicePMPlanPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateDevicePMPlanPresenterView _view = CreateOrUpdateDevicePMPlanPresenter.this.getView();
          UIDevicePMPlan _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateDevicePMPlanPresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, parent, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateDevicePMPlanPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCDevicePMPlanProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateDevicePMPlanPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateDevicePMPlanPresenterView _view = CreateOrUpdateDevicePMPlanPresenter.this.getView();
          UIDevicePMPlan _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateDevicePMPlanPresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIDevicePMPlan> _function = new Procedure1<UIDevicePMPlan>() {
              public void apply(final UIDevicePMPlan it) {
                CreateOrUpdateDevicePMPlanPresenterView _view = CreateOrUpdateDevicePMPlanPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateDevicePMPlanPresenter.this);
              }
            };
          AsyncCallback<UIDevicePMPlan> _onSuccess = CreateOrUpdateDevicePMPlanPresenter.this.<UIDevicePMPlan>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    this.commiter.apply(notifier);
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
